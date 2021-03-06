// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2011, 2020 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.visual.grille.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.jcryptool.core.util.colors.ColorService;
import org.jcryptool.core.util.images.ImageService;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.jcryptool.core.util.ui.auto.SmoothScroller;
import org.jcryptool.visual.grille.algorithm.Grille;
import org.jcryptool.visual.grille.algorithm.KeySchablone;

public class View extends ViewPart {

	private Grille model;
	private Text text_input;
	private Button button_encrypt;
	private Button button_decrypt;
	private Button button_step5;
	private Button button_step4;
	private Button button_step3;
	private Button button_step2;
	private Button button_step1;
	private Button button_direct;
	private Button button_stepwise;
	private Button setHoles;
	private Button deleteHoles;
	private Text text_output;
	private Button button_okay;
	private Spinner spinner_keySize;
	private Canvas canvas_schluessel;
	private boolean setEncrypt = true;
	private Group group_output;
	private Group group_input;
	private Label label_step1;
	private Label label_step2;
	private Label label_step3;
	private Label label_step4;
	private Label label_step5;
	private Label label_step6;
	private Canvas canvas_demonstration;
	protected Demonstration demonstration;
	private KeyListener schluessel_listener;
	private Composite parent;
	private Composite viewParent;
	private Composite inOutText;
	private Composite composite_illustration;
	private Composite composite_canvas_demonstration;
	private StyledText keyText;

	public View() {
		model = new Grille();
		model.setKey(new KeySchablone(6));
	}

	@Override
	public void createPartControl(Composite viewParent) {
		this.viewParent = viewParent;
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(viewParent, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		parent = new Composite(scrolledComposite, SWT.NONE);
		parent.setLayout(new GridLayout(3, false));

		createDescription(parent);
		createOptions(parent);
		createInOutComposite(parent);
		createSchablone(parent);
		createIllustrationAndExecType(parent);

		scrolledComposite.setContent(parent);
		scrolledComposite.setMinSize(parent.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		// This makes the ScrolledComposite scrolling, when the mouse 
		// is on a Text with one or more of the following tags: SWT.READ_ONLY,
		// SWT.V_SCROLL or SWT.H_SCROLL.
		SmoothScroller.scrollSmooth(scrolledComposite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewParent, "org.jcryptool.visual.grille.grille");
	}

	/**
	 * Created the illustration (letters in squares that get turned) and the step
	 * buttons.
	 * 
	 * @param parent The parent composite.
	 */
	private void createIllustrationAndExecType(Composite parent) {
		composite_illustration = new Composite(parent, SWT.NONE);
		composite_illustration.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		GridLayout gl_composite_illustration = new GridLayout(2, false);
		gl_composite_illustration.marginWidth = 0;
		gl_composite_illustration.marginHeight = 0;
		composite_illustration.setLayout(gl_composite_illustration);

		createDemonstration(composite_illustration);
		createExecutionControls(composite_illustration);

	}

	/**
	 * Creates the text fields for input and output of the plain-/ciphertext.
	 * 
	 * @param parent The composite the control should be displayed in.
	 */
	private void createInOutComposite(Composite parent) {
		inOutText = new Composite(parent, SWT.NONE);
		inOutText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 2));
		// Composite should have no border, so it looks like the groups on the left.
		GridLayout gl_inOutText = new GridLayout(2, true);
		gl_inOutText.marginWidth = 0;
		gl_inOutText.marginHeight = 0;
		inOutText.setLayout(gl_inOutText);
		createInputtext(inOutText);
		createOutputtext(inOutText);
	}

	private void createInputtext(Composite parent) {
		group_input = new Group(parent, SWT.NONE);
		group_input.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		group_input.setLayout(new GridLayout());
		group_input.setText(Messages.getString("View.plaintext") + " (0)"); //$NON-NLS-1$

		text_input = new Text(group_input, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		GridData gd_text_input = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_text_input.minimumWidth = 200;
		gd_text_input.widthHint = text_input.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		gd_text_input.heightHint = text_input.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
		text_input.setLayoutData(gd_text_input);
		text_input.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (setEncrypt) {
					group_input
							.setText(Messages.getString("View.plaintext") + " (" + text_input.getText().length() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				} else {
					group_input.setText(
							Messages.getString("View.ciphertext") + " (" + text_input.getText().length() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
				reset();
			}
		});
	}

	private void createOutputtext(Composite parent) {
		group_output = new Group(parent, SWT.NONE);
		group_output.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		group_output.setLayout(new GridLayout());
		group_output.setText(Messages.getString("View.ciphertext") + " (0)"); //$NON-NLS-1$ //$NON-NLS-2$

		text_output = new Text(group_output, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		GridData gd_text_output = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_text_output.minimumWidth = 200;
		gd_text_output.widthHint = text_output.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		gd_text_output.heightHint = text_output.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
		text_output.setLayoutData(gd_text_output);
		text_output.addKeyListener(new org.eclipse.swt.events.KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				e.doit = false;
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		text_output.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (setEncrypt) {
					group_output.setText(
							Messages.getString("View.ciphertext") + " (" + text_output.getText().length() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				} else {
					group_output.setText(
							Messages.getString("View.plaintext") + " (" + text_output.getText().length() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

				}
			}
		});

	}

	// Used to reset the output text when the user changes the key.
	public void setText_outputText(String string) {
		text_output.setText(string);
	}

	/**
	 * Creates the buttons for each step.
	 * 
	 * @param parent The parent composite.
	 */
	private void createExecutionControls(Composite parent) {
		Composite execType = new Composite(parent, SWT.NONE);
		GridLayout gl_execType = new GridLayout();
		gl_execType.marginWidth = 0;
		gl_execType.marginHeight = 0;
		execType.setLayout(gl_execType);
		execType.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		createTypeSelection(execType);
		createSteps(execType);
	}

	private void createTypeSelection(Composite execType) {

		Group typeSelection = new Group(execType, SWT.NONE);
		typeSelection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		typeSelection.setText(Messages.getString("View.type")); //$NON-NLS-1$
		typeSelection.setLayout(new GridLayout(2, false));

		button_direct = new Button(typeSelection, SWT.RADIO);
		button_direct.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		button_direct.setText(Messages.getString("View.direct")); //$NON-NLS-1$
		button_direct.setSelection(true);
		button_direct.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				reset();
			}
		});

		button_okay = new Button(typeSelection, SWT.NONE);
		button_okay.setImage(ImageService.ICON_RUN);
		button_okay.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 2));
		button_okay.setText(Messages.getString("View.start")); //$NON-NLS-1$
		button_okay.setEnabled(false);
		button_okay.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				reset();
				if (button_direct.getSelection()) {
					if (setEncrypt == true) {
						String checkedText = model.check(text_input.getText());
						// Hier wird der eingegebene Text mit einem padding versehen.
						text_input.setText(checkedText);
						text_output.setText(model.encrypt(checkedText));
					} else {
						String checkedText = model.check(text_input.getText());
						if (checkedText.length() == text_input.getText().length())
							text_output.setText(model.decrypt(text_input.getText()));
						else {
							MessageBox messageBox = new MessageBox(new Shell(Display.getCurrent()), SWT.ERROR);
							messageBox.setText(Messages.getString("View.error")); //$NON-NLS-1$
							messageBox.setMessage(Messages.getString("View.length_error")); //$NON-NLS-1$
							messageBox.open();
						}
					}
				} else {
					demonstration = new Demonstration(model, text_input.getText());
					demonstration.showStep1();
					canvas_demonstration
							.addPaintListener(new DemonstrationPainter(canvas_demonstration, demonstration));
					canvas_demonstration.redraw();
					canvas_schluessel.removeMouseListener(schluessel_listener);
					button_step1.setEnabled(true);
					button_step1.setFocus();
					label_step1.setEnabled(true);
				}

			}

		});

		button_stepwise = new Button(typeSelection, SWT.RADIO);
		button_stepwise.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		button_stepwise.setText(Messages.getString("View.stepwise")); //$NON-NLS-1$

		button_stepwise.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				reset();
			}
		});

		typeSelection.pack();
	}

	private void createSteps(Composite execType) {

		Group steps = new Group(execType, SWT.NONE);
		steps.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		steps.setText(Messages.getString("View.steps")); //$NON-NLS-1$
		steps.setLayout(new GridLayout(1, true));

		Group step1 = new Group(steps, SWT.NONE);
		step1.setLayout(new GridLayout(2, false));
		step1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		step1.setText(Messages.getString("View.step1")); //$NON-NLS-1$
		
		label_step1 = new Label(step1, SWT.NONE);
		label_step1.setText(Messages.getString("View.check")); //$NON-NLS-1$
		label_step1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		button_step1 = new Button(step1, SWT.NONE);
		button_step1.setText(Messages.getString("View.proceed")); //$NON-NLS-1$
		button_step1.setEnabled(false);
		button_step1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				canvas_demonstration.redraw();
				canvas_schluessel.redraw();
				text_input.setText(text_input.getText() + demonstration.padding);
				demonstration.showStep2();
				label_step1.setEnabled(false);
				button_step2.setEnabled(true);
				button_step2.setFocus();
				label_step2.setEnabled(true);
			}
		});
		label_step1.setEnabled(false);

		Group step2 = new Group(steps, SWT.NONE);
		step2.setLayout(new GridLayout(2, false));
		step2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		step2.setText(Messages.getString("View.step2")); //$NON-NLS-1$
		
		label_step2 = new Label(step2, SWT.NONE);
		label_step2.setText(Messages.getString("View.first_turn")); //$NON-NLS-1$
		label_step2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		label_step2.setEnabled(false);
		
		button_step2 = new Button(step2, SWT.NONE);
		button_step2.setText(Messages.getString("View.proceed")); //$NON-NLS-1$
		button_step2.setEnabled(false);
		button_step2.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				demonstration.showStep3();
				canvas_demonstration.redraw();
				canvas_schluessel.redraw();
				button_step2.setEnabled(false);
				label_step2.setEnabled(false);
				button_step3.setEnabled(true);
				button_step3.setFocus();
				label_step3.setEnabled(true);
			}
		});
		

		Group step3 = new Group(steps, SWT.NONE);
		step3.setLayout(new GridLayout(2, false));
		step3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		step3.setText(Messages.getString("View.step3")); //$NON-NLS-1$
		
		label_step3 = new Label(step3, SWT.NONE);
		label_step3.setText(Messages.getString("View.second_turn")); //$NON-NLS-1$
		label_step3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		label_step3.setEnabled(false);
		
		button_step3 = new Button(step3, SWT.NONE);
		button_step3.setText(Messages.getString("View.proceed")); //$NON-NLS-1$
		button_step3.setEnabled(false);
		button_step3.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				demonstration.showStep4();
				canvas_demonstration.redraw();
				canvas_schluessel.redraw();
				button_step3.setEnabled(false);
				label_step3.setEnabled(false);
				button_step4.setEnabled(true);
				button_step4.setFocus();
				label_step4.setEnabled(true);
			}
		});	

		Group step4 = new Group(steps, SWT.NONE);
		step4.setLayout(new GridLayout(2, false));
		step4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		step4.setText(Messages.getString("View.step4")); //$NON-NLS-1$
		
		label_step4 = new Label(step4, SWT.NONE);
		label_step4.setText(Messages.getString("View.third_turn")); //$NON-NLS-1$
		label_step4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		label_step4.setEnabled(false);
		
		button_step4 = new Button(step4, SWT.NONE);
		button_step4.setText(Messages.getString("View.proceed")); //$NON-NLS-1$
		button_step4.setEnabled(false);
		button_step4.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				demonstration.showStep5();
				canvas_demonstration.redraw();
				canvas_schluessel.redraw();
				button_step4.setEnabled(false);
				label_step4.setEnabled(false);
				button_step5.setEnabled(true);
				button_step5.setFocus();
				label_step5.setEnabled(true);
			}
		});
		

		Group step5 = new Group(steps, SWT.NONE);
		step5.setLayout(new GridLayout(2, false));
		step5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		step5.setText(Messages.getString("View.step5")); //$NON-NLS-1$
		
		label_step5 = new Label(step5, SWT.NONE);
		label_step5.setText(Messages.getString("View.fourth_turn")); //$NON-NLS-1$
		label_step5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		label_step5.setEnabled(false);
		
		button_step5 = new Button(step5, SWT.NONE);
		button_step5.setText(Messages.getString("View.proceed")); //$NON-NLS-1$
		button_step5.setEnabled(false);
		button_step5.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				demonstration.showStep6();
				canvas_demonstration.redraw();
				canvas_schluessel.redraw();
				button_step5.setEnabled(false);
				label_step5.setEnabled(false);
				label_step6.setEnabled(true);
				text_output.setText(demonstration.getOutput());
			}
		});	

		Group step6 = new Group(steps, SWT.NONE);
		step6.setLayout(new GridLayout(2, false));
		step6.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		step6.setText(Messages.getString("View.step6")); //$NON-NLS-1$

		label_step6 = new Label(step6, SWT.NONE);
		label_step6.setText(Messages.getString("View.linewise")); //$NON-NLS-1$
		label_step6.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		label_step6.setEnabled(false);
	}

	/**
	 * Creates the illustration of the key grille.
	 * 
	 * @param parent The parent composite.
	 */
	private void createDemonstration(Composite parent) {

		Group illustration = new Group(parent, SWT.NONE);
		illustration.setLayout(new GridLayout());
		illustration.setText(Messages.getString("View.2")); //$NON-NLS-1$
		illustration.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		composite_canvas_demonstration = new Composite(illustration, SWT.NONE);
		composite_canvas_demonstration.setLayout(new FormLayout());
		GridData gd_composite_canvas_demonstration = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_composite_canvas_demonstration.minimumWidth = 400;
		composite_canvas_demonstration.setLayoutData(gd_composite_canvas_demonstration);

		canvas_demonstration = new Canvas(composite_canvas_demonstration, SWT.DOUBLE_BUFFERED);
		FormData fd_canvas_demonstration = new FormData();
		fd_canvas_demonstration.top = new FormAttachment(0);
		fd_canvas_demonstration.left = new FormAttachment(0);
		fd_canvas_demonstration.right = new FormAttachment(100);
		fd_canvas_demonstration.bottom = new FormAttachment(100);
		canvas_demonstration.setLayoutData(fd_canvas_demonstration);
		canvas_demonstration.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		canvas_demonstration.setToolTipText(Messages.getString("View.2"));

		int width_Canvas_demonstration = canvas_demonstration.getSize().x;
		int height_Canvas_demonstration = canvas_demonstration.getSize().y;
		if (width_Canvas_demonstration >= height_Canvas_demonstration) {
			canvas_demonstration.setSize(height_Canvas_demonstration, height_Canvas_demonstration);
		} else {
			canvas_demonstration.setSize(width_Canvas_demonstration, width_Canvas_demonstration);
		}
	}

	/**
	 * Creates the schablone animation and the belonging buttons
	 * 
	 * @param parent The parent composite.
	 */
	private void createSchablone(Composite parent) {
		Group schablone = new Group(parent, SWT.NONE);
		schablone.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		schablone.setLayout(new GridLayout(3, false));
		schablone.setText(Messages.getString("View.keygrille")); //$NON-NLS-1$

		canvas_schluessel = new Canvas(schablone, SWT.DOUBLE_BUFFERED);
		canvas_schluessel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		canvas_schluessel.addPaintListener(new KeyPainter(canvas_schluessel, model));
		schluessel_listener = new org.jcryptool.visual.grille.ui.KeyListener(model, this);
		canvas_schluessel.addMouseListener(schluessel_listener);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 3);
		gridData.widthHint = 151;
		gridData.heightHint = 151;
		canvas_schluessel.setLayoutData(gridData);

		Label spinner = new Label(schablone, SWT.NONE);
		spinner.setText(Messages.getString("View.size")); //$NON-NLS-1$
		spinner.setLayoutData(new GridData(SWT.BOTTOM, SWT.FILL, false, false));

		spinner_keySize = new Spinner(schablone, SWT.NONE);
		spinner_keySize.setMinimum(4);
		spinner_keySize.setMaximum(10);
		spinner_keySize.setIncrement(2);
		spinner_keySize.setSelection(6);
		spinner_keySize.setEnabled(true);
		spinner_keySize.setLayoutData(new GridData(SWT.NONE, SWT.FILL, false, false));
		spinner_keySize.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (Integer.parseInt(spinner_keySize.getText()) % 2 == 1
						|| Integer.parseInt(spinner_keySize.getText()) >= 11
						|| Integer.parseInt(spinner_keySize.getText()) <= 3)
					spinner_keySize.setSelection(6);
				model.setKey(new KeySchablone(Integer.parseInt(spinner_keySize.getText())));
				reset();
				canvas_schluessel.removeMouseListener(schluessel_listener);
				canvas_schluessel.addMouseListener(schluessel_listener);
				updateKeyText();
			}
		});

		// Spacer label
		new Label(schablone, SWT.NONE);

		setHoles = new Button(schablone, SWT.PUSH);
		setHoles.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, true));
		setHoles.setText(Messages.getString("View.1")); //$NON-NLS-1$
		setHoles.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// reset the old schablone
				model.setKey(new KeySchablone(Integer.parseInt(spinner_keySize.getText())));
				reset();

				boolean set = false;
				int size = model.getKey().getSize();
				int x = (int) (Math.random() * (size - 1) + 1);
				int y = (int) (Math.random() * (size - 1) + 1);

				do {
					for (int i = 0; i < 6; i++) {
						if (model.getKey().get((x + i) % size, y % size) == '0') {
							model.getKey().toggle((x + i) % size, y % size);
							y++;
							x++;
							break;
						}
					}
					if (!set) {
						y++;
					}
				} while (!model.getKey().isValid());

				canvas_schluessel.redraw();
				canvas_schluessel.removeMouseListener(schluessel_listener);
				canvas_schluessel.addMouseListener(schluessel_listener);
				checkOkButton();
				updateKeyText();
				
				text_input.setFocus();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);

			}
		});

		// Spacer label
		new Label(schablone, SWT.NONE);

		deleteHoles = new Button(schablone, SWT.PUSH);
		deleteHoles.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, false));
		deleteHoles.setText(Messages.getString("View.0")); //$NON-NLS-1$
		deleteHoles.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				model.setKey(new KeySchablone(Integer.parseInt(spinner_keySize.getText())));
				reset();
				canvas_schluessel.removeMouseListener(schluessel_listener);
				canvas_schluessel.addMouseListener(schluessel_listener);
				updateKeyText();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		keyText = new StyledText(schablone, SWT.READ_ONLY | SWT.H_SCROLL);
		keyText.setText(Messages.getString("View.key"));
		keyText.setBackground(ColorService.LIGHTGRAY);
		keyText.setAlwaysShowScrollBars(false);
		GridData gd_keyText = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
		gd_keyText.widthHint = keyText.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
		keyText.setLayoutData(gd_keyText);

	}

	/**
	 * Updates the textfield under the key grille. Displays the key as numbers.
	 */
	public void updateKeyText() {
		int counter = 1;
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < model.getKey().getSize(); j++) {
			for (int k = 0; k < model.getKey().getSize(); k++) {
				if (model.getKey().get(j, k) == '1') {
					sb.append(counter);
					sb.append(" ");
				}
				counter++;
			}
		}
		keyText.setText(Messages.getString("View.key") + sb.toString().trim());
	}

	/**
	 * Creates the options group. Group with two radio buttons, encryption and
	 * decryption.
	 * 
	 * @param parent The parent composite the control should be displayed in.
	 */
	private void createOptions(Composite parent) {
		Group options = new Group(parent, SWT.NONE);
		options.setLayout(new GridLayout(2, true));
		options.setText(Messages.getString("View.operation")); //$NON-NLS-1$
		options.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		button_encrypt = new Button(options, SWT.RADIO);
		button_encrypt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		button_encrypt.setText(Messages.getString("View.encryption")); //$NON-NLS-1$
		button_encrypt.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				// Nur etwas tun, wenn der Button ausgew??hlt wurde.
				// Das SelectionEvent wird auch bei der abwahl des Buttons aufgerufen.
				if (button_encrypt.getSelection()) {
					String temp = text_output.getText();
					reset();
					setEncrypt = true;
					group_input.setText(Messages.getString("View.plaintext") + " (0)"); //$NON-NLS-1$
					group_output.setText(Messages.getString("View.ciphertext") + " (0)"); //$NON-NLS-1$
					button_stepwise.setEnabled(true);
					text_input.setText(temp);
					updateKeyText();
				}
			}
		});
		button_encrypt.setSelection(true);

		button_decrypt = new Button(options, SWT.RADIO);
		button_decrypt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		button_decrypt.setText(Messages.getString("View.decryption")); //$NON-NLS-1$
		button_decrypt.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				// Nur etwas tun, wenn der Button ausgew??hlt wurde.
				// Das SelectionEvent wird auch bei der abwahl des Buttons aufgerufen.
				if (button_decrypt.getSelection()) {
					// Zwischenspeichern des Output der Verschl??sselung, um ihn
					// als input zu setzen.
					String temp = text_output.getText();
					reset();
					setEncrypt = false;
					group_output.setText(Messages.getString("View.plaintext") + " (0)"); //$NON-NLS-1$
					group_input.setText(Messages.getString("View.ciphertext") + " (0)"); //$NON-NLS-1$
					button_stepwise.setEnabled(false);
					button_stepwise.setSelection(false);
					button_direct.setSelection(true);
					// Copy the output to input field when mode switched from encryption to
					// decryption.
					text_input.setText(temp);
					updateKeyText();
				}
			}
		});
	}

	/**
	 * Creates the description part of the GUI.
	 * 
	 * @param parent The parent composite.
	 */
	private void createDescription(Composite parent) {		
		TitleAndDescriptionComposite titleAndDescription = new TitleAndDescriptionComposite(parent);
		titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		titleAndDescription.setTitle(Messages.getString("View.title"));
		titleAndDescription.setDescription(Messages.getString("View.description"));
	}

	private void reset() {
		if (demonstration != null) {
			demonstration.reset();
		}

		checkOkButton();
		text_output.setText("");
		button_step1.setEnabled(false);
		button_step2.setEnabled(false);
		button_step3.setEnabled(false);
		button_step4.setEnabled(false);
		button_step5.setEnabled(false);
		label_step1.setEnabled(false);
		label_step2.setEnabled(false);
		label_step3.setEnabled(false);
		label_step4.setEnabled(false);
		label_step5.setEnabled(false);
		label_step6.setEnabled(false);
		canvas_demonstration.redraw();
		canvas_schluessel.redraw();
	}

	public void resetView() {
		Control[] children = viewParent.getChildren();
		for (Control control : children) {
			control.dispose();
		}
		createPartControl(viewParent);
		viewParent.layout();
		model.setKey(new KeySchablone(Integer.parseInt(spinner_keySize.getText())));
	}

	@Override
	public void setFocus() {
		// Set focus on "put holes"-button after
		// plugin start.
		setHoles.setFocus();
	}

	public void checkOkButton() {
		if (model.getKey().isValid() && !text_input.getText().equals("")) { //$NON-NLS-1$
			button_okay.setEnabled(true);
		} else {
			button_okay.setEnabled(false);
		}
	}
}