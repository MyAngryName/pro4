package org.jcryptool.visual.merkletree.ui;

import java.awt.Event;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Popup;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.container.namespaces.EclipsePlatformNamespace;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ExpandEvent;
import org.eclipse.swt.events.ExpandListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;
import org.jcryptool.visual.merkletree.Descriptions;
import org.jcryptool.visual.merkletree.algorithm.ISimpleMerkle;
import org.jcryptool.visual.merkletree.algorithm.Node;
import org.jcryptool.visual.merkletree.ui.MerkleConst.SUIT;
import org.eclipse.swt.graphics.Rectangle;

/**
 * Class for the Composite of Tabpage "MerkleTree"
 * 
 * @author Kevin Muehlboeck
 * @author Maximilian Lindpointner
 *
 */
public class MerkleTreeZestComposite
		extends Composite /* implements IZoomableWorkbenchPart */
{

	private GraphViewer viewer;
	private StyledText styledTextTree;
	private ArrayList<GraphConnection> markedConnectionList;
	ExpandBar descriptionExpander;
	Label descLabel;
	StyledText descText;
	Composite expandComposite;
	Composite zestComposite;
	Composite staticCursor;
	Canvas cursorCanvas;
	GridLayout zestLayout;
	SashForm zestSash;
	Display curDisplay;
	boolean distinctListener = false;
	boolean mouseDragging;
	Point cursorLoc;
	Point oldMouse;
	Point newMouse;
	int differenceMouseX;
	int differenceMouseY;
	Point oldSash;
	Point cameraPoint;
	Object lock = new Object();
	ISimpleMerkle merkle;
	Graph graph;
	Composite parent;
	boolean expandedFlag = true;

	ImageData test;
	Image pressedImage;

	// Interactive Variables
	String message;
	int step = 0;

	/**
	 * Create the composite. Including Description, GraphItem, GraphView,
	 * Description for GraphView
	 * 
	 * @param parent
	 * @param style
	 */
	/**
	 * @param parent
	 * @param style
	 * @param merkle
	 * @param verfahren
	 */
	public MerkleTreeZestComposite(Composite parent, int style, ISimpleMerkle merkle, SUIT verfahren) {
		super(parent, style);
		this.setLayout(new GridLayout(2, true));
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, MerkleConst.DESC_HEIGHT + 1));
		Composite parentComposite = this;
		curDisplay = getDisplay();
		this.merkle = merkle;
		this.parent = parent;

		/*
		 * the description label for the chosen mode
		 */
		descLabel = new Label(this, SWT.NONE);
		descLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, MerkleConst.H_SPAN_MAIN, 1));

		descriptionExpander = new ExpandBar(this, SWT.NONE);
		descriptionExpander.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		ExpandItem collapsablePart = new ExpandItem(descriptionExpander, SWT.NONE, 0);

		expandComposite = new Composite(descriptionExpander, SWT.NONE);
		GridLayout expandLayout = new GridLayout(2, true);
		expandComposite.setLayout(expandLayout);

		/*
		 * description text of the chosen mode
		 */
		descText = new StyledText(expandComposite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		descText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		// this.setLayout(new GridLayout(1, true));

		styledTextTree = new StyledText(this, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		styledTextTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		collapsablePart.setText("Beschreibung ausblenden");
		collapsablePart.setExpanded(true);
		collapsablePart.setControl(expandComposite);
		collapsablePart.setHeight((parent.getSize().y - 250) / 2);
		descriptionExpander.setBackground(curDisplay.getSystemColor(SWT.COLOR_WHITE));

		Button button = new Button(this, SWT.PUSH);
		button.setText("Interaktive Signaturerstellung");
		button.addListener(SWT.Selection, event -> {
			interactiveSignatureGeneration();
		});

		// Composite which contains a SashForm which contains the MerkleTree
		// Zest Graph
		zestComposite = new Composite(this, SWT.NONE);
		zestComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		zestLayout = new GridLayout();
		zestComposite.setLayout(zestLayout);

		Image releasedImage = new Image(getDisplay(), "C:\\Users\\XMSS\\Desktop\\pressedCursor.png");
		Cursor released = new Cursor(getDisplay(), releasedImage.getImageData(), 0, 0);

		zestComposite.setCursor(released);

		// sets the size for Composite zestComposite
		this.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				// TODO Auto-generated method stub
				zestComposite.setSize(1920, 1080);
			}
		});

		zestSash = new SashForm(zestComposite, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(zestSash);

		// Cursor stuff
		test = new ImageData("C:\\Users\\XMSS\\Desktop\\cursor.png");
		pressedImage = new Image(getDisplay(), test);
		cursorCanvas = new Canvas(zestComposite, SWT.NO_REDRAW_RESIZE | SWT.NO_BACKGROUND);
		cursorCanvas.setBackgroundMode(SWT.INHERIT_FORCE);
		cursorCanvas.setBounds(0, 0, 32, 32);
		zestSash.moveBelow(cursorCanvas);
		cursorCanvas.setVisible(false);

		cursorCanvas.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) { //
				e.gc.drawImage(pressedImage, 0, 0);
			}
		});

		// Beginning of the Graph
		viewer = new GraphViewer(zestSash, SWT.NONE);

		// Camera Movement
		MouseListener dragQueen = new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				distinctListener = false;
				mouseDragging = false;
				cameraPoint = zestSash.getLocation();
				zestComposite.setCursor(released);
				cursorCanvas.setVisible(false);
			}

			@Override
			public void mouseDown(MouseEvent e) {
				mouseDragging = true;
				oldMouse = Display.getCurrent().getCursorLocation();
				oldSash = zestSash.getLocation();
				// zestComposite.setCursor(pressed);
				zestComposite.setCursor(null);
				// staticCursor.setLocation(oldMouse);
				// cursorCanvas.setVisible(true);
				cursorLoc = oldMouse;
				cursorCanvas.setLocation(cursorLoc.x - zestComposite.getBounds().x - 45, cursorLoc.y - zestComposite.getBounds().y - 136);
				cursorCanvas.setVisible(true);

				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						while (mouseDragging) {
							if (distinctListener == false)
								updateSashPosition();
							try {
								Thread.sleep(25);

							} catch (InterruptedException e) {
							}

						}

					}
				};
				new Thread(runnable).start();

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// do nothing
			}
		};
		viewer.getGraphControl().addMouseListener(dragQueen);
		zestComposite.addMouseListener(dragQueen);

		descriptionExpander.addExpandListener(new ExpandListener() {

			Point currentShellSize;

			@Override
			public void itemExpanded(ExpandEvent e) {
				curDisplay.asyncExec(() -> {
					currentShellSize = parent.getSize();
					collapsablePart.setHeight(currentShellSize.y / 2);
					descriptionExpander.pack();
					parentComposite.layout();
					zestSash.setLocation(cameraPoint.x, cameraPoint.y - (currentShellSize.y / 2));
					expandedFlag = true;
				});

			}

			@Override
			public void itemCollapsed(ExpandEvent e) {
				curDisplay.asyncExec(() -> {
					currentShellSize = parent.getSize();
					descriptionExpander.pack();
					parentComposite.layout();
					zestSash.setLocation(cameraPoint.x, cameraPoint.y + (currentShellSize.y / 2));
					expandedFlag = false;
				});
			}
		});

		viewer.getGraphControl().setHorizontalScrollBarVisibility(FigureCanvas.NEVER);
		viewer.getGraphControl().setVerticalScrollBarVisibility(FigureCanvas.NEVER);
		markedConnectionList = new ArrayList<GraphConnection>();
		viewer.setContentProvider(new ZestNodeContentProvider());
		viewer.setLabelProvider(new ZestLabelProvider(ColorConstants.lightGreen));

		// select the layout of the connections -> CONNECTIONS_DIRECTED would be
		// a ->
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_SOLID);
		linkMerkleTree(merkle);
		viewer.applyLayout();

		Control control = viewer.getControl();
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		switch (verfahren) {
		case XMSS:
			descLabel.setText(Descriptions.XMSS.Tab1_Head0);
			descText.setText(Descriptions.XMSS.Tab1_Txt0);
			styledTextTree.setText(Descriptions.XMSS.Tab1_Txt1);
			break;
		case XMSS_MT:
			descLabel.setText(Descriptions.XMSS_MT.Tab1_Head0);
			descText.setText(Descriptions.XMSS_MT.Tab1_Txt0);
			styledTextTree.setText(Descriptions.XMSS_MT.Tab1_Txt1);
			break;
		case MSS:
		default:
			descLabel.setText(Descriptions.MSS.Tab1_Head0);
			descText.setText(Descriptions.MSS.Tab1_Txt0);
			styledTextTree.setText(Descriptions.MSS.Tab1_Txt1);
			break;

		}
		graph = viewer.getGraphControl();

		// Makes the nodes fixed (they cannot be dragged around with the mouse
		// by overriding the mouseMovedListener with empty event
		graph.getLightweightSystem().setEventDispatcher(new SWTEventDispatcher() {
			public void dispatchMouseMoved(MouseEvent e) {
			}

		});

		graph.addSelectionListener(new SelectionAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.
			 * eclipse.swt.events. SelectionEvent) Click-Event to get the
			 * Selected Node and to mark the other Nodes
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				distinctListener = true;
				if (e.item instanceof GraphNode) {
					GraphNode node = (GraphNode) e.item;
					Node n = (Node) node.getData();

					if (n.isLeaf()) {
						styledTextTree.setForeground(new Color(null, new RGB(1, 70, 122)));
						// styledTextTree.setFont(FontService.getHugeFont());
						styledTextTree.setText(Descriptions.ZestLabelProvider_5 + " " + n.getLeafNumber() + " = " //$NON-NLS-1$ //$NON-NLS-2$
								+ n.getNameAsString());

						if (markedConnectionList.size() == 0) {
							markBranch(node);
							markAuthPath(markedConnectionList);
						} else {
							unmarkBranch(markedConnectionList);
							markedConnectionList.clear();
							markBranch(node);
							markAuthPath(markedConnectionList);
						}
					} else {
						if (markedConnectionList.size() != 0) {
							unmarkBranch(markedConnectionList);
							markedConnectionList.clear();
							markBranch(node);
						} else {
							markBranch(node);
						}
						styledTextTree.setForeground(new Color(null, new RGB(0, 0, 0)));
						styledTextTree.setAlignment(SWT.LEFT);
						styledTextTree.setText(Descriptions.ZestLabelProvider_6 + " = " + n.getNameAsString());
					}
				}

				/* Deselects immediately to allow dragging */
				viewer.setSelection(new ISelection() {

					@Override
					public boolean isEmpty() {
						return false;
					}
				});
			}
		});
	}

	/**
	 * Marks the whole branch begining from the leaf node
	 * 
	 * @param leaf
	 *            - the leaf node of the branch
	 */
	@SuppressWarnings("unchecked")
	private void markBranch(GraphNode leaf) {
		ArrayList<GraphItem> items = new ArrayList<GraphItem>();

		try {
			GraphConnection connection = (GraphConnection) leaf.getTargetConnections().get(0);

			connection.setLineColor(viewer.getGraphControl().DARK_BLUE);
			connection.getSource().setBackgroundColor(viewer.getGraphControl().HIGHLIGHT_COLOR);
			connection.getDestination().setBackgroundColor(viewer.getGraphControl().HIGHLIGHT_COLOR);

			items.add(connection.getSource());
			items.add(connection.getDestination());

			markedConnectionList.add(connection);
			List<GraphConnection> l = connection.getSource().getTargetConnections();

			while (l.size() != 0) {
				connection = (GraphConnection) connection.getSource().getTargetConnections().get(0);
				connection.setLineColor(viewer.getGraphControl().DARK_BLUE);
				connection.getSource().setBackgroundColor(viewer.getGraphControl().HIGHLIGHT_COLOR);
				connection.getDestination().setBackgroundColor(viewer.getGraphControl().HIGHLIGHT_COLOR);

				items.add(connection.getSource());
				items.add(connection.getDestination());

				markedConnectionList.add(connection);

				l = connection.getSource().getTargetConnections();
			}
		} catch (IndexOutOfBoundsException ex) {
			items.add(((GraphConnection) (leaf.getSourceConnections().get(0))).getSource());
		}
		viewer.getGraphControl().setSelection(items.toArray(new GraphItem[items.size()]));
	}

	/**
	 * Unmark a previous marked branch
	 * 
	 * @param markedConnectionList
	 *            - Contains marked elements
	 */
	private void unmarkBranch(List<GraphConnection> markedConnectionList) {
		GraphConnection authPath;
		for (GraphConnection connection : markedConnectionList) {
			connection.setLineColor(ColorConstants.lightGray);
			connection.getSource().setBackgroundColor(viewer.getGraphControl().LIGHT_BLUE);
			authPath = (GraphConnection) connection.getSource().getSourceConnections().get(0);
			authPath.getDestination().setBackgroundColor(ColorConstants.lightGreen);
			authPath = (GraphConnection) connection.getSource().getSourceConnections().get(1);
			authPath.getDestination().setBackgroundColor(ColorConstants.lightGreen);

			// color the nodes back to light green
			Node leaf = (Node) connection.getDestination().getData();
			if (leaf.isLeaf()) {
				connection.getDestination().setBackgroundColor(ColorConstants.lightGreen);
			} else {
				connection.getDestination().setBackgroundColor(ColorConstants.lightGreen); // viewer.getGraphControl().LIGHT_BLUE
			}
		}
	}

	/**
	 * Marks the authentification path of the leaf
	 * 
	 * @param markedConnectionList
	 *            - Contains marked elements of the Changing Path
	 */
	private void markAuthPath(List<GraphConnection> markedConnectionList) {
		GraphConnection authPath;
		// List<GraphConnection> connections = leaf.getTargetConnections();
		for (GraphConnection connect : markedConnectionList) {
			Node myNode = (Node) connect.getDestination().getData();
			Node parentNode = (Node) connect.getSource().getData();

			if (myNode.equals(parentNode.getLeft())) {
				authPath = (GraphConnection) connect.getSource().getSourceConnections().get(1);
				authPath.getDestination().setBackgroundColor(ColorConstants.red);
			} else {
				authPath = (GraphConnection) connect.getSource().getSourceConnections().get(0);
				authPath.getDestination().setBackgroundColor(ColorConstants.red);
			}
		}
	}

	/**
	 * Synchronize the merklTree with the other Tabpages
	 * 
	 * @param merkle
	 */
	private void linkMerkleTree(ISimpleMerkle merkle) {
		if (merkle.getMerkleRoot() != null) {
			viewer.setInput(merkle.getTree());
			viewer.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
			viewer.applyLayout();
		}

	}

	private void setStaticCursor() {

	}

	/**
	 * 
	 * 
	 */
	private void updateSashPosition() {

		curDisplay.asyncExec(new Runnable() {
			@Override
			public void run() {
				newMouse = getDisplay().getCursorLocation();
				differenceMouseX = newMouse.x - oldMouse.x;
				differenceMouseY = newMouse.y - oldMouse.y;

				if (differenceMouseX != 0 || differenceMouseY != 0) {

					// differenceMouseX = Integer.min(1, differenceMouseX);
					// differenceMouseX = Integer.max(-1, differenceMouseX);
					// differenceMouseY = Integer.min(1, differenceMouseY);
					// differenceMouseY = Integer.max(-1, differenceMouseY);

					zestSash.setLocation((newMouse.x - oldMouse.x) + oldSash.x, (newMouse.y - oldMouse.y) + oldSash.y);
					oldSash.x = (newMouse.x - oldMouse.x) + oldSash.x;
					oldSash.y = (newMouse.y - oldMouse.y) + oldSash.y;
					oldMouse = newMouse;
				}

			}
		});
	}

	Composite popup;
	Rectangle compositePosition;
	Rectangle expanderPosition;
	Rectangle windowPosition;
	Rectangle currentView;
	Point popupPosition;
	Point graphPosition;

	Label guideLabel;
	Text signatureText;
	Button nextButton;
	Button backButton;
	Button cancelButton;
	Button verifyButton;

	String plainSignature;
	String signature[];
	GraphNode rootNode;
	GraphNode[] leaves;
	Image highlightedNode;

	int currentIndex;

	private void interactiveSignatureGeneration() {
		// Shell popup = new Shell(getDisplay(), SWT.MODELESS | SWT.TOOL |
		// SWT.ON_TOP);
		// popup.setSize(500, 150);

		popup = new Composite(zestComposite, SWT.BORDER);
		popup.setVisible(false);
		popup.setBounds(0, 0, 500, 150);
		popup.setBackground(getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		popup.setLayout(new GridLayout(6, true));
		zestSash.moveBelow(popup);

		// Initialize current size of the view
		compositePosition = zestComposite.getBounds();
		expanderPosition = descriptionExpander.getBounds();
		windowPosition = getShell().getBounds();
		currentView = new Rectangle(compositePosition.x, compositePosition.y, expanderPosition.width, windowPosition.height - 200 - compositePosition.y);

		// Initial Middle Position by taking the half of the currentView window,
		// and subtract half the size of the popup
		popupPosition = new Point(currentView.width / 2, currentView.height / 2);
		popupPosition.x -= popup.getBounds().width / 2;
		popupPosition.y -= popup.getBounds().height / 2;

		// Get leaves and root node
		List<?> graphNodeRetriever = graph.getNodes();
		Object[] nodeRetriever = viewer.getNodeElements();
		leaves = new GraphNode[nodeRetriever.length / 2 + 1];

		for (int i = 0, j = 0; i < graphNodeRetriever.size(); ++i) {
			if (((GraphNode) graphNodeRetriever.get(i)).getSourceConnections().isEmpty()) {
				leaves[j] = (GraphNode) graphNodeRetriever.get(i);
				++j;
			}
			if (((GraphNode) graphNodeRetriever.get(i)).getTargetConnections().isEmpty()) {
				rootNode = (GraphNode) graphNodeRetriever.get(i);
			}
		}

		currentIndex = Integer.parseInt(merkle.getKeyIndex());
		guideLabel = new Label(popup, SWT.WRAP);
		guideLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 6, 1));

		signatureText = new Text(popup, SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		signatureText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 6, 1));

		backButton = new Button(popup, SWT.PUSH);
		backButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		cancelButton = new Button(popup, SWT.PUSH);
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		cancelButton.setText("Abbrechen");

		Label spacer = new Label(popup, SWT.NONE);
		spacer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));

		nextButton = new Button(popup, SWT.PUSH);
		nextButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		nextButton.setText("Weiter");

		stepByStep();
		popup.layout(true);
		popup.setVisible(true);

		// Step by Step Listeners
		nextButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				++step;
				stepByStep();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

		});

		backButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				--step;
				stepByStep();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		cancelButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				step = 0;
				popup.dispose();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	Point leafPosition = new Point(0, 0);

	private void stepByStep() {
		switch (step) {

		case 0:
			backButton.setText("Zurück");
			backButton.setVisible(false);
			signatureText.setVisible(true);
			signatureText.setEditable(true);
			signatureText.setFocus();

			guideLabel.setText("Willkommen bei der Interaktiven Signaturerstellung\nGeben sie eine Nachricht an, die signiert werden soll");
			popup.setLocation(popupPosition);
			break;
		case 1:
			message = signatureText.getText();
			if (message.length() != 0) {
				guideLabel.setText("Im ersten Schritt suchen wir ein freies OTS Schlüsselpaar.");
				signatureText.setVisible(false);
				backButton.setVisible(true);
				signatureText.setEditable(false);

			}
			break;

		case 2:
			leafPosition = new Point(leaves[currentIndex].getLocation().x, leaves[currentIndex].getLocation().y);
			zestSash.setLocation(-leafPosition.x + popup.getBounds().width + 30, -leafPosition.y + currentView.height - 80);
			popup.setLocation(compositePosition.x + 10, currentView.height - (popup.getBounds().height + 10));
			guideLabel.setText("Hier, Blatt " + currentIndex + " ist verwendbar.\nWir schreiben also den Index des Blattes in die Signatur");
			signatureText.setText(currentIndex + " |");
			signatureText.setVisible(true);
			leaves[currentIndex].highlight();
			break;
		case 3:
			plainSignature = merkle.sign(message);
			signature = plainSignature.split("\\|");
			guideLabel.setText("Der Wert des Blattes " + currentIndex
					+ " ist der öffentliche Schlüssel der One-Time-Signature. Er wird zur Überprüfung der Nachricht benötigt und ist damit der nächste Teil der Signatur ");
			break;

		case 4:
			signatureText.setText(currentIndex + " | ");
			signatureText.append(signature[1]);
			break;
		case 5:
			guideLabel.setText(
					"Um Jetzt den Baum zu Hashen fehlt uns aber noch wichtige Information. Die Werte der rot markierten Nodes fehlen dem Prüfer der Signatur und müssen deshalb ergänzt werden");
			markBranch(leaves[currentIndex]);
			markAuthPath(markedConnectionList);
			break;
		case 6:
			zestSash.setLocation(-leafPosition.x + popup.getBounds().width + 30, -leafPosition.y + currentView.height - 80);
			popup.setLocation(compositePosition.x + 10, currentView.height - (popup.getBounds().height + 10));
			nextButton.setText("Weiter");
			signatureText.setText(currentIndex + " | ");
			signatureText.append(signature[1] + " | ");
			signatureText.append(signature[2]);
			break;
		case 7:
			guideLabel.setText("Sind alle notwendigen Knoten bis zur Wurzel ergänzt, ist die Signatur fertig. Sie kann jetzt im Tab \"Verifizieren\" überprüft werden ");
			Point rootPosition = new Point(rootNode.getLocation().x, rootNode.getLocation().y);
			zestSash.setLocation(-rootPosition.x + currentView.width / 2, -rootPosition.y + popup.getBounds().height + 15);
			popup.setLocation(currentView.width / 2 - popup.getBounds().width / 2, 10);

			nextButton.setText("Fertig");

			break;
		case 8:
			popup.dispose();
			step = 0;
			break;
		default:
			break;
		}
	}

}
