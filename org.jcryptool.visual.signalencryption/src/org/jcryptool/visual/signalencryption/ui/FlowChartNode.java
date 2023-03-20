package org.jcryptool.visual.signalencryption.ui;

import java.util.Objects;
import java.util.function.BiFunction;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.core.util.colors.ColorService;
import org.jcryptool.core.util.images.ImageService;
import org.jcryptool.core.util.ui.layout.GridDataBuilder;

public class FlowChartNode extends Composite {

	private static final int POPUP_STYLE = SWT.MODELESS | SWT.SHADOW_ETCHED_OUT | SWT.BORDER;
	private static final Image buttonImage = ImageService.getImage(SignalEncryptionView.ID, "icons/searchIcon.png");
	/** How long to keep the button disabled when the window is closing */
	private static final long BUTTON_DISABLE_TIME = 250;

	private final Text txt_title;
	private final Button btn_action;
	private final Shell parentShell;
	private final String title;
	private boolean showing;
	private Shell popup;
	private BiFunction<Composite, Integer, Composite> popupProvider;

	private static String lock = "";
	private boolean buttonEnabled;

	private FlowChartNode(Composite parent, int style, String title, String actionName, Type type,
			BiFunction<Composite, Integer, Composite> popupProvider) {
		super(parent, style);
		this.popupProvider = popupProvider;
		this.parentShell = getShell();
		this.setBackground(ColorService.getColor(SWT.COLOR_LIST_BACKGROUND));

		setLayout(new GridLayout(1, true));

		txt_title = new Text(this, SWT.NONE);
		txt_title.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		txt_title.setText(title);
		this.title = title;

		btn_action = new Button(this, SWT.TOGGLE);
		btn_action.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		btn_action.setImage(buttonImage);

		if (!Objects.isNull(actionName) && !actionName.isEmpty()) {
			btn_action.setText(actionName);
		}

		btn_action.addSelectionListener(showPopupListener());
	}

	public FocusListener closeOnFocusLose() {
		return new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				new Thread(() -> lockAndSleep()).start();
				disposePopup();
			}
		};
	}

	public void setPopupProvider(BiFunction<Composite, Integer, Composite> popupProvider) {
		this.popupProvider = popupProvider;
	}

	public String getTitle() {
		return title;
	}

	private SelectionAdapter showPopupListener() {
		return new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!showing && !buttonEnabled) {
					showPopup();
					btn_action.setSelection(true);
				}
				// In case the button is still disabled when closing the window
				// keep the selection to false.
				if (buttonEnabled) {
					btn_action.setSelection(false);
				}
				// The else case (pressing the button again when it's showing) does not need to
				// be covered here
				// as it should automatically close as soon as the user brings focus to the main
				// window.
			}
		};
	}

	private void showPopup() {
		popup = new Shell(parentShell, POPUP_STYLE);
		popup.addFocusListener(closeOnFocusLose());

		var layout = new GridLayout();
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;

		popup.setLayout(layout);
		popup.setText(title);
		var baseComposite = new Composite(popup, SWT.NONE);
		baseComposite.setLayout(new GridLayout(1, true));
		baseComposite.setLayoutData(GridDataBuilder
				.with(SWT.FILL, SWT.FILL, true, true)
				.minimumHeight(100)
				.minimumWidth(400)
				.get()
		);
		popupProvider.apply(baseComposite, SWT.NONE);
		popup.forceActive();
		popup.forceFocus();
		popup.pack();
		setCenterLocation(popup);
		popup.open();
		showing = true;
		recursivelyAddFocusListener(popup);

		popup.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				showing = false;
				btn_action.setSelection(false);
			}
		});
	}

	private void recursivelyAddFocusListener(Composite x) {
		var children = x.getChildren();
		for (var child : children) {
			if (child instanceof Composite) {
				recursivelyAddFocusListener((Composite) child);
			}
			child.addFocusListener(closeOnFocusLose());
		}
	}

	private void disposePopup() {
		popup.dispose();
	}

	private void setCenterLocation(Shell shell) {
		var parentLocation = parentShell.getLocation();
		var parentSize = parentShell.getSize();
		var shellSize = shell.getSize();
		var x = parentLocation.x + (parentSize.x / 2) - (shellSize.x / 2);
		var y = parentLocation.y + (parentSize.y / 2) - (shellSize.y / 2);
		shell.setLocation(x, y);
	}

	/** Lock the pop-up button for a little time, else the window closes/opens immediately */
	private void lockAndSleep() {
		disablePopupButton();
		try {
			Thread.sleep(BUTTON_DISABLE_TIME);
		} catch (InterruptedException ignored) {
		}
		enablePopupButton();
	}

	private void disablePopupButton() {
		synchronized (lock) {
			buttonEnabled = true;
		}
	}

	private void enablePopupButton() {
		synchronized (lock) {
			buttonEnabled = false;
		}
	}

	public static class Builder {

		public Builder(Composite parent) {
			this.parent = parent;
		}

		private Composite parent;
		private int style = SWT.BORDER;
		private String title = "NO TITLE";
		private String actionName = "";
		private BiFunction<Composite, Integer, Composite> popupProvider = (shell, style) -> {
			var composite = new Composite(shell, style);
			var text = new Text(composite, SWT.NONE);
			text.setText("no content");
			return composite;
		};

		public Builder style(int style) {
			this.style = style;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder actionName(String actionName) {
			this.actionName = actionName;
			return this;
		}

		public Builder popupProvider(BiFunction<Composite, Integer, Composite> popupProvider) {
			this.popupProvider = popupProvider;
			return this;
		}

		public FlowChartNode buildOperationNode() {
			return new FlowChartNode(parent, style, title, actionName, Type.OPERATION, popupProvider);
		}

		public FlowChartNode buildValueNode() {
			return new FlowChartNode(parent, style, title, actionName, Type.VALUE, popupProvider);
		}

	}

	public static enum Type {
		OPERATION, VALUE
	}

}
