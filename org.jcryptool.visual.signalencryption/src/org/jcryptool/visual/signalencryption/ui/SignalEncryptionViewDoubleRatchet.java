package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
// import org.jcryptool.visual.signalencryption.ui.SignalEncryptionDoubleRatchetState.STATE;

import static org.jcryptool.visual.signalencryption.ui.SignalEncryptionViewDoubleRatchetConstants.*;

public class SignalEncryptionViewDoubleRatchet extends Composite {

    Composite cmp_body;
    Composite cmp_alice;
    Composite cmp_bob;

    Button btn_alice;
    Button btn_bob;
    Button btn_next;
    Button btn_previous;

    Group grp_aliceSteps;
    Group grp_aliceAlgorithm;
    Group grp_bobSteps;
    Group grp_bobAlgorithm;
    Group grp_bobSendingReceivingChain;
    Group grp_bobSpace2;
    Group grp_bobRootChain;
    Group grp_bobSpace1;
    Group grp_bobDiffieHellman;
    Group grp_aliceDiffieHellman;
    Group grp_aliceRootChain;
    Group grp_aliceSendingReceivingChain;
    Group grp_aliceMessagebox;

    Composite cmp_aliceDiffieHellman;
    Composite cmp_aliceRootChain;
    Composite cmp_aliceReceivingChain;
    Composite cmp_aliceSendingChain;
    Composite cmp_bobDiffieHellman;
    Composite cmp_bobSendingChain;
    Composite cmp_bobReceivingChain;
    Composite cmp_bobRootChain;
    Composite cmp_aliceSteps;
    Composite cmp_aliceMessagebox;
    Composite cmp_bobMessagebox;
    Composite cmp_aliceArrowSpace1;
    Composite cmp_aliceArrowSpace2;
    Composite cmp_bobArrowSpace1;
    Composite cmp_bobArrowSpace2;

    String aliceAlgorithmGroupDescription = Messages.SignalEncryption_alice_AlgorithmGroupDescription;
    String bobAlgorithmGroupDescription = Messages.SignalEncryption_bob_AlgorithmGroupDescription;
    String stepGroupDescription = Messages.SignalEncryption_stepGroupDescription;
    String DiffieHellmanGroupDescription = Messages.SignalEncryption_DiffieHellmanGroupDescription;
    String RootChainDescription = Messages.SignalEncryption_RootChainDescription;
    String SendingChainDescription = Messages.SignalEncryption_SendingChainDescription;
    String ReceivingChainDescription = Messages.SignalEncryption_ReceivingChainDescription;
    String MessageboxDescription = Messages.SignalEncryption_MessageboxDescription;
    String btn_NextDescription = Messages.SignalEncryption_btnName_Next;
    String btn_PreviousDescription = Messages.SignalEncryption_btnName_Previous;

    Text txt_aliceDiffieHellman1;
    Text txt_aliceDiffieHellman2;
    Text txt_aliceDiffieHellman3;
    Text txt_bobDiffieHellman1;
    Text txt_bobDiffieHellman2;
    Text txt_bobDiffieHellman3;
    Text txt_aliceRootChain1;
    Text txt_aliceRootChain2;
    Text txt_aliceRootChain3;
    Text txt_aliceSendingChain1;
    Text txt_aliceSendingChain2;
    Text txt_aliceSendingChain3;
    Text txt_aliceSendingChain4;
    Text txt_aliceSendingChain5;
    Text txt_aliceReceivingChain1;
    Text txt_aliceReceivingChain2;
    Text txt_aliceReceivingChain3;
    Text txt_aliceReceivingChain4;
    Text txt_aliceReceivingChain5;
    Text txt_bobRootChain1;
    Text txt_bobRootChain2;
    Text txt_bobRootChain3;
    Text txt_bobSendingChain1;
    Text txt_bobSendingChain2;
    Text txt_bobSendingChain3;
    Text txt_bobSendingChain4;
    Text txt_bobSendingChain5;
    Text txt_bobReceivingChain1;
    Text txt_bobReceivingChain2;
    Text txt_bobReceivingChain3;
    Text txt_bobReceivingChain4;
    Text txt_bobReceivingChain5;

    Text txt_aliceStep0;
    Text txt_bobStep0;
    Text txt_step1;
    Text txt_step2;
    Text txt_step3;
    Text txt_step4;
    Text txt_aliceStep5;

    Text txt_bobStep5;
    Text txt_step6;
    Text txt_step7;
    Text txt_step8;
    protected Text txt_step9;

    Text txt_alicePlainText;
    Text txt_aliceCipherText;
    Text txt_bobPlainText;
    Text txt_bobCipherText;

    private String aliceDiffieHellmanLabel1 = Messages.SignalEncryption_aliceDiffieHellmanLabel1;
    private String aliceDiffieHellmanLabel2 = Messages.SignalEncryption_aliceDiffieHellmanLabel2;
    private String aliceDiffieHellmanLabel3 = Messages.SignalEncryption_aliceDiffieHellmanLabel3;
    private String aliceRootChainLabel1 = Messages.SignalEncryption_aliceRootChainLabel1;
    private String aliceRootChainLabel2 = Messages.SignalEncryption_aliceRootChainLabel2;
    private String aliceRootChainLabel3 = Messages.SignalEncryption_aliceRootChainLabel3;
    private String aliceSendingChainLabel1 = Messages.SignalEncryption_aliceSendingChainLabel1;
    private String aliceSendingChainLabel2 = Messages.SignalEncryption_aliceSendingChainLabel2;
    private String aliceSendingChainLabel3 = Messages.SignalEncryption_aliceSendingChainLabel3;
    private String aliceSendingChainLabel4 = Messages.SignalEncryption_aliceSendingChainLabel4;
    private String aliceSendingChainLabel5 = Messages.SignalEncryption_aliceSendingChainLabel5;
    private String aliceReceivingChainLabel1 = Messages.SignalEncryption_aliceReceivingChainLabel1;
    private String aliceReceivingChainLabel2 = Messages.SignalEncryption_aliceReceivingChainLabel2;
    private String aliceReceivingChainLabel3 = Messages.SignalEncryption_aliceReceivingChainLabel3;
    private String aliceReceivingChainLabel4 = Messages.SignalEncryption_aliceReceivingChainLabel4;
    private String aliceReceivingChainLabel5 = Messages.SignalEncryption_aliceReceivingChainLabel5;
    private String bobDiffieHellmanLabel1 = Messages.SignalEncryption_bobDiffieHellmanLabel1;
    private String bobDiffieHellmanLabel2 = Messages.SignalEncryption_bobDiffieHellmanLabel2;
    private String bobDiffieHellmanLabel3 = Messages.SignalEncryption_bobDiffieHellmanLabel3;
    private String bobRootChainLabel1 = Messages.SignalEncryption_bobRootChainLabel1;
    private String bobRootChainLabel2 = Messages.SignalEncryption_bobRootChainLabel2;
    private String bobRootChainLabel3 = Messages.SignalEncryption_bobRootChainLabel3;
    private String bobSendingChainLabel1 = Messages.SignalEncryption_bobSendingChainLabel1;
    private String bobSendingChainLabel2 = Messages.SignalEncryption_bobSendingChainLabel2;
    private String bobSendingChainLabel3 = Messages.SignalEncryption_bobSendingChainLabel3;
    private String bobSendingChainLabel4 = Messages.SignalEncryption_bobSendingChainLabel4;
    private String bobSendingChainLabel5 = Messages.SignalEncryption_bobSendingChainLabel5;
    private String bobReceivingChainLabel1 = Messages.SignalEncryption_bobReceivingChainLabel1;
    private String bobReceivingChainLabel2 = Messages.SignalEncryption_bobReceivingChainLabel2;
    private String bobReceivingChainLabel3 = Messages.SignalEncryption_bobReceivingChainLabel3;
    private String bobReceivingChainLabel4 = Messages.SignalEncryption_bobReceivingChainLabel4;
    private String bobReceivingChainLabel5 = Messages.SignalEncryption_bobReceivingChainLabel5;

    private String aliceStep0 = Messages.SignalEncryption_aliceDescriptionText0;
    private String bobStep0 = Messages.SignalEncryption_bobDescriptionText0;
    private String step1 = Messages.SignalEncryption_stepText1;
    private String step2 = Messages.SignalEncryption_stepText2;
    private String step3 = Messages.SignalEncryption_stepText3;
    private String step4 = Messages.SignalEncryption_stepText4;
    private String aliceStep5 = Messages.SignalEncryption_aliceStepText5;
    private String bobStep5 = Messages.SignalEncryption_bobStepText5;
    private String step6 = Messages.SignalEncryption_stepText6;
    private String step7 = Messages.SignalEncryption_stepText7;
    private String step8 = Messages.SignalEncryption_stepText8;
    private String step9 = Messages.SignalEncryption_stepText9;
    // private String bobStep5 = Messages.SignalEncryption_bobDescriptionText5;
    String MessageboxPlainText = "Geben Sie hier Ihre Nachricht an Bob ein.";
    private String MessageboxCipherText = "The Ciphertext";

    SignalEncryptionAlgorithmState signalEncryptionState;

    private SignalEncryptionViewDoubleRatchet instance;

    protected Canvas arr_aliceDiffieHellmanArrow1;
    protected Canvas arr_aliceDiffieHellmanArrow2;
    protected Canvas arr_aliceRootChainArrow1;
    protected Canvas arr_aliceRootChainArrow2;
    protected Canvas arr_aliceSendingChainArrow1;
    protected Canvas arr_aliceSendingChainArrow2;
    protected Canvas arr_aliceSendingChainArrow3;
    protected Canvas arr_aliceSendingChainArrow4;
    protected Canvas arr_aliceReceivingChainArrow1;
    protected Canvas arr_aliceReceivingChainArrow2;
    protected Canvas arr_aliceReceivingChainArrow3;
    protected Canvas arr_aliceReceivingChainArrow4;
    protected Canvas arr_aliceSpace1;
    protected Canvas arr_aliceSpace2;

    protected Canvas arr_bobReceivingChainArrow1;
    protected Canvas arr_bobReceivingChainArrow2;
    protected Canvas arr_bobReceivingChainArrow3;
    protected Canvas arr_bobReceivingChainArrow4;
    protected Canvas arr_bobSendingChainArrow1;
    protected Canvas arr_bobSendingChainArrow2;
    protected Canvas arr_bobSendingChainArrow3;
    protected Canvas arr_bobSendingChainArrow4;
    protected Canvas arr_bobDiffieHellmanArrow1;
    protected Canvas arr_bobDiffieHellmanArrow2;
    protected Canvas arr_bobRootChainArrow1;
    protected Canvas arr_bobRootChainArrow2;
    protected Canvas arr_bobSpace1;
    protected Canvas arr_bobSpace2;

    String input;
    private SignalEncryptionDoubleRatchetState signalEncryptionDoubleRatchetState;

    ModifyListener keys_changedListener;

    Group grp_bobMessagebox;

    private Composite cmp_buttons;

    private Composite cmp_header;

    SignalEncryptionViewDoubleRatchet(Composite parent, int style,
            SignalEncryptionAlgorithmState signalEncryptionState) {
        super(parent, style);

        this.signalEncryptionState = signalEncryptionState;
        this.instance = this;
        this.setLayout(new GridLayout(1, false));

        createHeaderComposite();
        createBodyComposite();
        createAliceComposite();
        createBobComposite();
        showAliceView();

        this.signalEncryptionDoubleRatchetState = new SignalEncryptionDoubleRatchetState(this);

    }

    private void createHeaderComposite() {

        cmp_header = new Composite(this, SWT.NONE);
        cmp_header.setLayout(new GridLayout(1, false));
        cmp_header.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 14, 1));

        createButtons();

    }

    private void createButtons() {
        cmp_buttons = new Composite(cmp_header, SWT.NONE);
        cmp_buttons.setLayout(new GridLayout(4, false));
        cmp_buttons.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

        createAliceButton();
        createPreviousButton();
        createNextButton();
        createBobButton();

    }

    private void createBodyComposite() {

        cmp_body = new Composite(this, SWT.NONE);
        cmp_body.setLayout(new StackLayout());
        cmp_body.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    }

    private void createAliceButton() {

        btn_alice = new Button(cmp_buttons, SWT.LEFT);
        btn_alice.setAlignment(SWT.CENTER);

        GridData gd_btnAlice = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_btnAlice.widthHint = 150;
        btn_alice.setLayoutData(gd_btnAlice);
        btn_alice.setText(Messages.SignalEncryption_btnName_Alice);

        btn_alice.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showAliceView();

            }
        });
    }

    private void createBobButton() {
        btn_bob = new Button(cmp_buttons, SWT.RIGHT);
        btn_bob.setAlignment(SWT.CENTER);
        GridData gd_btnBob = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
        gd_btnBob.widthHint = 150;
        btn_bob.setLayoutData(gd_btnBob);
        btn_bob.setText(Messages.SignalEncryption_btnName_Bob);

        btn_bob.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showBobView();

            }
        });
    }

    private void createPreviousButton() {
        btn_previous = new Button(cmp_buttons, SWT.PUSH);
        btn_previous.setAlignment(SWT.CENTER);
        GridData gd_btnPrev = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
        gd_btnPrev.widthHint = 150;
        btn_previous.setLayoutData(gd_btnPrev);
        btn_previous.setText(btn_PreviousDescription);
        btn_previous.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                signalEncryptionDoubleRatchetState.stepBack(instance,
                        signalEncryptionDoubleRatchetState);
                System.out.println(signalEncryptionDoubleRatchetState.getCurrentState().toString());

            }
        });
    }

    private void createNextButton() {
        btn_next = new Button(cmp_buttons, SWT.PUSH);
        btn_next.setAlignment(SWT.CENTER);
        GridData gd_btnNext = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_btnNext.widthHint = 150;
        btn_next.setLayoutData(gd_btnNext);
        btn_next.setText(btn_NextDescription);
        btn_next.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                signalEncryptionDoubleRatchetState.stepForward(instance,
                        signalEncryptionDoubleRatchetState);
                System.out.println(signalEncryptionDoubleRatchetState.getCurrentState().toString());
            }
        });

    }

    private void createBobComposite() {
        // Init of the layouts and data needed
        cmp_bob = new Composite(cmp_body, SWT.NONE);
        cmp_bob.setLayout(new GridLayout(1, true));

        // Parent groups for algorithm and steps composites
        grp_bobSteps = new Group(cmp_bob, SWT.NONE);
        grp_bobAlgorithm = new Group(cmp_bob, SWT.NONE);

        // Parent groups for chain composites
        grp_bobMessagebox = new Group(grp_bobAlgorithm, SWT.NONE);
        grp_bobSendingReceivingChain = new Group(grp_bobAlgorithm, SWT.NONE);
        cmp_bobArrowSpace2 = new Composite(grp_bobAlgorithm, SWT.NONE);
        grp_bobRootChain = new Group(grp_bobAlgorithm, SWT.NONE);
        cmp_bobArrowSpace1 = new Composite(grp_bobAlgorithm, SWT.NONE);
        grp_bobDiffieHellman = new Group(grp_bobAlgorithm, SWT.NONE);

        // Composites for overlapping sending and receiving chains
        cmp_bobSendingChain = new Composite(grp_bobSendingReceivingChain, SWT.NONE);
        cmp_bobReceivingChain = new Composite(grp_bobSendingReceivingChain, SWT.NONE);

        // Composite for Message Box
        cmp_bobMessagebox = new Composite(grp_bobMessagebox, SWT.NONE);

        // Layouts
        StackLayout sl_BobSendingReceivingChainGroup = new StackLayout();
        grp_bobSendingReceivingChain.setLayout(sl_BobSendingReceivingChainGroup);
        grp_bobSendingReceivingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());

        grp_bobSteps.setText(stepGroupDescription);
        grp_bobSteps.setLayout(Layout.gl_stepsComposite());
        grp_bobSteps.setLayoutData(Layout.gd_stepsComposite());

        grp_bobAlgorithm.setText(bobAlgorithmGroupDescription);
        grp_bobAlgorithm.setLayout(Layout.gl_algorithmGroup());
        grp_bobAlgorithm.setLayoutData(Layout.gd_algorithmGroup());
        
        createBobSendingChain();
        createBobReceivingChain();
        createBobRootChain();
        createBobDiffieHellmanChain();
        createBobMessagebox();
        createBobSteps();
        createBobArrowSpaces();
        showBobReceivingChain();

    }

    private void createBobArrowSpaces() {
        cmp_bobArrowSpace1.setLayout(Layout.gl_arrowSpaceComposite());
        cmp_bobArrowSpace1.setLayoutData(Layout.gd_arrowSpaceComposite());

        // arrow up
        arr_bobSpace1 = new Canvas(cmp_bobArrowSpace1, SWT.DOUBLE_BUFFERED);
        arr_bobSpace1.setLayoutData(SignalEncryptionArrows.canvasData(
               SWT.FILL,
               SWT.FILL,
               false,
               false,
               1,
               1,
               ARROW_CANVAS_WIDTH,
               Layout.calculateConnectingArrowHeight())
        );
        arr_bobSpace1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftUpLeftArrow(
                        arr_bobSpace1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        cmp_bobArrowSpace2.setLayout(Layout.gl_arrowSpaceComposite());
        cmp_bobArrowSpace2.setLayoutData(Layout.gd_arrowSpaceComposite());

        // arrow up
        arr_bobSpace2 = new Canvas(cmp_bobArrowSpace2, SWT.DOUBLE_BUFFERED);
        arr_bobSpace2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL,
                SWT.FILL,
                false,
                false,
                1,
                1,
                ARROW_CANVAS_WIDTH,
                Layout.calculateConnectingArrowHeight())
        );
        arr_bobSpace2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftUpLeftLine(
                        arr_bobSpace2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
    }

    private void createBobMessagebox() {

        grp_bobMessagebox.setLayout(Layout.gl_messageboxGroup());
        grp_bobMessagebox.setLayoutData(Layout.gd_messageboxComposite());
        grp_bobMessagebox.setText(MessageboxDescription);

        txt_bobCipherText = new Text(grp_bobMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_bobCipherText.setText(MessageboxCipherText);
        txt_bobCipherText.setLayoutData(Layout.gd_Messagebox());

        txt_bobPlainText = new Text(grp_bobMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_bobPlainText.setText(MessageboxPlainText);
        txt_bobPlainText.setLayoutData(Layout.gd_Messagebox());
        txt_bobPlainText.addListener(SWT.Modify, new Listener() {

            @Override
            public void handleEvent(Event e) {
                txt_bobPlainText.setTextLimit(256);
            }
        });
        txt_bobPlainText.setEditable(true);
    }

    private void createBobSteps() {
        txt_bobStep0 = new Text(grp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobStep0.setText(bobStep0);
        txt_bobStep0.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobStep5 = new Text(grp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobStep5.setText(bobStep5);
        txt_bobStep5.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_step6 = new Text(grp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step6.setText(step6);
        txt_step6.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_step7 = new Text(grp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step7.setText(step7);
        txt_step7.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_step8 = new Text(grp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step8.setText(step8);
        txt_step8.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_step9 = new Text(grp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step9.setText(step9);
        txt_step9.setLayoutData(Layout.gd_shortDescriptionTexts());
    }

    private void createBobSendingChain() {
        cmp_bobSendingChain.setLayout(Layout.gl_sendingReceivingChainComposite(SWT.RIGHT));
        cmp_bobSendingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());
        
        insertSpacers(cmp_bobSendingChain, 1);

        txt_bobSendingChain1 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain1.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobSendingChain1.setText(bobSendingChainLabel1);

        arr_bobSendingChainArrow4 = new Canvas(cmp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow4.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 2, 1, ARROW_CANVAS_WIDTH
        ));
        arr_bobSendingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(
                        arr_bobSendingChainArrow4, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        
        insertSpacers(cmp_bobSendingChain, 1);
        
        // arrow down
        arr_bobSendingChainArrow1 = new Canvas(cmp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow1.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_bobSendingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_bobSendingChainArrow1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        
        insertSpacers(cmp_bobSendingChain, 3);

        txt_bobSendingChain2 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain2.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobSendingChain2.setText(bobSendingChainLabel2);

        // arrow left
        arr_bobSendingChainArrow2 = new Canvas(cmp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_bobSendingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(
                        arr_bobSendingChainArrow2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobSendingChain3 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain3.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobSendingChain3.setText(bobSendingChainLabel3);

        txt_bobSendingChain4 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain4.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobSendingChain4.setText(bobSendingChainLabel4);

        // arrow left
        arr_bobSendingChainArrow3 = new Canvas(cmp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow3.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_bobSendingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownLeftArrow(
                        arr_bobSendingChainArrow3, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        
        insertSpacers(cmp_bobSendingChain, 3);

        txt_bobSendingChain5 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain5.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobSendingChain5.setText(bobSendingChainLabel5);

    }

    private void createBobReceivingChain() {

        cmp_bobReceivingChain.setLayout(Layout.gl_sendingReceivingChainComposite(SWT.RIGHT));
        cmp_bobReceivingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());
        
        insertSpacers(cmp_bobReceivingChain, 1);

        txt_bobReceivingChain1 = new Text(cmp_bobReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain1.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobReceivingChain1.setText(bobReceivingChainLabel1);

        arr_bobReceivingChainArrow4 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow4.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 2, 1, ARROW_CANVAS_WIDTH
        ));
        arr_bobReceivingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(
                        arr_bobReceivingChainArrow4, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        insertSpacers(cmp_bobReceivingChain, 1);
        
        // arrow down
        arr_bobReceivingChainArrow1 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow1.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_bobReceivingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_bobReceivingChainArrow1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        insertSpacers(cmp_bobReceivingChain, 3);

        txt_bobReceivingChain2 = new Text(cmp_bobReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain2.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobReceivingChain2.setText(bobReceivingChainLabel2);

        // arrow left
        arr_bobReceivingChainArrow2 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_bobReceivingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(
                        arr_bobReceivingChainArrow2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobReceivingChain3 = new Text(cmp_bobReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain3.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobReceivingChain3.setText(bobReceivingChainLabel3);

        txt_bobReceivingChain4 = new Text(cmp_bobReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain4.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobReceivingChain4.setText(bobReceivingChainLabel4);

        // arrow left
        arr_bobReceivingChainArrow3 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow3.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_bobReceivingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownLeftArrow(
                        arr_bobReceivingChainArrow3, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        
        insertSpacers(cmp_bobReceivingChain, 3);

        txt_bobReceivingChain5 = new Text(cmp_bobReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain5.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobReceivingChain5.setText(bobReceivingChainLabel5);

    }

    private void createBobRootChain() {
        grp_bobRootChain.setText(RootChainDescription);
        grp_bobRootChain.setLayout(Layout.gl_rootChainComposite());
        grp_bobRootChain.setLayoutData(Layout.gd_rootChainComposite());

        txt_bobRootChain1 = new Text(grp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobRootChain1.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobRootChain1.setText(bobRootChainLabel1);

        // arrow down
        arr_bobRootChainArrow1 = new Canvas(grp_bobRootChain, SWT.DOUBLE_BUFFERED);
        arr_bobRootChainArrow1.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, UP_DOWN_ARROW_SIZE
         ));
        arr_bobRootChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_bobRootChainArrow1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobRootChain2 = new Text(grp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobRootChain2.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobRootChain2.setText(bobRootChainLabel2);

        // arrow down
        arr_bobRootChainArrow2 = new Canvas(grp_bobRootChain, SWT.DOUBLE_BUFFERED);
        arr_bobRootChainArrow2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, UP_DOWN_ARROW_SIZE
        ));
        arr_bobRootChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_bobRootChainArrow2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobRootChain3 = new Text(grp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobRootChain3.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobRootChain3.setText(bobRootChainLabel3);

    }

    private void createBobDiffieHellmanChain() {
        grp_bobDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_bobDiffieHellman.setLayout(Layout.gl_diffieHellmanComposite());
        grp_bobDiffieHellman.setLayoutData(Layout.gd_diffieHellmanComposite());

        txt_bobDiffieHellman1 = new Text(grp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobDiffieHellman1.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobDiffieHellman1.setText(bobDiffieHellmanLabel1);

        // arrow down
        arr_bobDiffieHellmanArrow1 = new Canvas(grp_bobDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_bobDiffieHellmanArrow1.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, UP_DOWN_ARROW_SIZE
        ));
        arr_bobDiffieHellmanArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_bobDiffieHellmanArrow1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobDiffieHellman2 = new Text(grp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobDiffieHellman2.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobDiffieHellman2.setText(bobDiffieHellmanLabel2);

        // arrow up
        arr_bobDiffieHellmanArrow2 = new Canvas(grp_bobDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_bobDiffieHellmanArrow2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_bobDiffieHellmanArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawUpArrow(
                        arr_bobDiffieHellmanArrow2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobDiffieHellman3 = new Text(grp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobDiffieHellman3.setLayoutData(Layout.gd_algorithmLabels());
        txt_bobDiffieHellman3.setText(bobDiffieHellmanLabel3);

    }

    private void createAliceComposite() {
        // Init of the widgets, layouts and data needed
        cmp_alice = new Composite(cmp_body, SWT.NONE);
        cmp_alice.setLayout(new GridLayout(1, false));

        // Parent groups for algorithm and steps composites
        grp_aliceSteps = new Group(cmp_alice, SWT.NONE);
        grp_aliceAlgorithm = new Group(cmp_alice, SWT.NONE);

        // Parent groups for chain composites
        grp_aliceDiffieHellman = new Group(grp_aliceAlgorithm, SWT.NONE);
        cmp_aliceArrowSpace1 = new Composite(grp_aliceAlgorithm, SWT.NONE);
        grp_aliceRootChain = new Group(grp_aliceAlgorithm, SWT.NONE);
        cmp_aliceArrowSpace2 = new Composite(grp_aliceAlgorithm, SWT.NONE);
        grp_aliceSendingReceivingChain = new Group(grp_aliceAlgorithm, SWT.NONE);
        grp_aliceMessagebox = new Group(grp_aliceAlgorithm, SWT.NONE);

        // Composites for overlapping sending and receiving chains
        cmp_aliceSendingChain = new Composite(grp_aliceSendingReceivingChain, SWT.NONE);
        cmp_aliceReceivingChain = new Composite(grp_aliceSendingReceivingChain, SWT.NONE);

        // Layouts
        StackLayout sl_AliceSendingReceivingChainGroup = new StackLayout();
        grp_aliceSendingReceivingChain.setLayout(sl_AliceSendingReceivingChainGroup);
        grp_aliceSendingReceivingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());

        grp_aliceAlgorithm.setText(aliceAlgorithmGroupDescription);
        grp_aliceAlgorithm.setLayout(Layout.gl_algorithmGroup());
        grp_aliceAlgorithm.setLayoutData(Layout.gd_algorithmGroup());
        
        var gl_stepsGroup = new GridLayout(1, false);
        var gd_stepsGroup = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
        grp_aliceSteps.setText(stepGroupDescription);
        grp_aliceSteps.setLayout(gl_stepsGroup);
        grp_aliceSteps.setLayoutData(gd_stepsGroup);

        createAliceSteps();
        createAliceDiffieHellmanChain();
        createAliceRootChain();
        createAliceSendingChain();
        createAliceReceivingChain();
        createAliceMessagebox();
        createAliceArrowSpaces();
        showAliceSendingChain();
    }

    private void createAliceArrowSpaces() {
        cmp_aliceArrowSpace1.setLayout(Layout.gl_arrowSpaceComposite());
        cmp_aliceArrowSpace1.setLayoutData(Layout.gd_arrowSpaceComposite());
        
        //System.out.print(calculateConnectingArrowMargin());
        // arrow up
        arr_aliceSpace1 = new Canvas(cmp_aliceArrowSpace1, SWT.DOUBLE_BUFFERED);
        arr_aliceSpace1.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL,
                SWT.FILL,
                false,
                false,
                1,
                1,
                ARROW_CANVAS_WIDTH,
                Layout.calculateConnectingArrowHeight()
        ));
        arr_aliceSpace1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightUpRightArrow(
                        arr_aliceSpace1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        cmp_aliceArrowSpace2.setLayout(Layout.gl_arrowSpaceComposite());
        cmp_aliceArrowSpace2.setLayoutData(Layout.gd_arrowSpaceComposite());

        // arrow up
        arr_aliceSpace2 = new Canvas(cmp_aliceArrowSpace2, SWT.DOUBLE_BUFFERED);
        arr_aliceSpace2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL,
                SWT.FILL,
                false,
                false,
                1,
                1,
                ARROW_CANVAS_WIDTH,
                Layout.calculateConnectingArrowHeight()
        ));
        arr_aliceSpace2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightUpRightLine(
                        arr_aliceSpace2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
    }

    private void createAliceSteps() {
        txt_aliceStep0 = new Text(grp_aliceSteps, SWT.WRAP | SWT.READ_ONLY);
        txt_aliceStep0.setText(aliceStep0);
        txt_aliceStep0.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_step1 = new Text(grp_aliceSteps, SWT.WRAP | SWT.READ_ONLY);
        txt_step1.setText(step1);
        txt_step1.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_step2 = new Text(grp_aliceSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step2.setText(step2);
        txt_step2.setLayoutData(Layout.gd_longDescriptionTexts());
        txt_step3 = new Text(grp_aliceSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step3.setText(step3);
        txt_step3.setLayoutData(Layout.gd_longDescriptionTexts());
        txt_step4 = new Text(grp_aliceSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step4.setText(step4);
        txt_step4.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_aliceStep5 = new Text(grp_aliceSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_aliceStep5.setText(aliceStep5);
        txt_aliceStep5.setLayoutData(Layout.gd_longDescriptionTexts());
    }

    private void createAliceDiffieHellmanChain() {
        grp_aliceDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_aliceDiffieHellman.setLayout(Layout.gl_diffieHellmanComposite());
        grp_aliceDiffieHellman.setLayoutData(Layout.gd_diffieHellmanComposite());

        txt_aliceDiffieHellman1 = new Text(grp_aliceDiffieHellman,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceDiffieHellman1.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceDiffieHellman1.setText(aliceDiffieHellmanLabel1);

        // arrow down
        arr_aliceDiffieHellmanArrow1 = new Canvas(grp_aliceDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_aliceDiffieHellmanArrow1.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, SWT.DEFAULT, UP_DOWN_ARROW_SIZE
        ));
        arr_aliceDiffieHellmanArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_aliceDiffieHellmanArrow1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceDiffieHellman2 = new Text(grp_aliceDiffieHellman,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceDiffieHellman2.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceDiffieHellman2.setText(aliceDiffieHellmanLabel2);

        // arrow up
        arr_aliceDiffieHellmanArrow2 = new Canvas(grp_aliceDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_aliceDiffieHellmanArrow2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceDiffieHellmanArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawUpArrow(
                        arr_aliceDiffieHellmanArrow2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceDiffieHellman3 = new Text(grp_aliceDiffieHellman,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceDiffieHellman3.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceDiffieHellman3.setText(aliceDiffieHellmanLabel3);

    }

    private void createAliceRootChain() {
        grp_aliceRootChain.setText(RootChainDescription);
        grp_aliceRootChain.setLayout(Layout.gl_rootChainComposite());
        grp_aliceRootChain.setLayoutData(Layout.gd_rootChainComposite());

        txt_aliceRootChain1 = new Text(grp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceRootChain1.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceRootChain1.setText(aliceRootChainLabel1);

        // arrow down
        arr_aliceRootChainArrow1 = new Canvas(grp_aliceRootChain, SWT.DOUBLE_BUFFERED);
        arr_aliceRootChainArrow1.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceRootChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_aliceRootChainArrow1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceRootChain2 = new Text(grp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceRootChain2.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceRootChain2.setText(aliceRootChainLabel2);

        // arrow down
        arr_aliceRootChainArrow2 = new Canvas(grp_aliceRootChain, SWT.DOUBLE_BUFFERED);
        arr_aliceRootChainArrow2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceRootChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_aliceRootChainArrow2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceRootChain3 = new Text(grp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceRootChain3.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceRootChain3.setText(aliceRootChainLabel3);

    }

    private void createAliceReceivingChain() {

        cmp_aliceReceivingChain.setLayout(Layout.gl_sendingReceivingChainComposite(SWT.LEFT));
        cmp_aliceReceivingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());

        // arrow down
        arr_aliceReceivingChainArrow4 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow4.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 2, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceReceivingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(
                        arr_aliceReceivingChainArrow4, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceReceivingChain1 = new Text(cmp_aliceReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain1.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceReceivingChain1.setText(aliceReceivingChainLabel1);
        
        insertSpacers(cmp_aliceReceivingChain, 3);

        // arrow down
        arr_aliceReceivingChainArrow1 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow1.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceReceivingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_aliceReceivingChainArrow1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        insertSpacers(cmp_aliceReceivingChain, 1);

        txt_aliceReceivingChain2 = new Text(cmp_aliceReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain2.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceReceivingChain2.setText(aliceReceivingChainLabel2);

        // arrow right
        arr_aliceReceivingChainArrow2 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceReceivingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(
                        arr_aliceReceivingChainArrow2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceReceivingChain3 = new Text(cmp_aliceReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain3.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceReceivingChain3.setText(aliceReceivingChainLabel3);

        insertSpacers(cmp_aliceReceivingChain, 3);

        // arrow down
        arr_aliceReceivingChainArrow3 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow3.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceReceivingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownRightArrow(
                        arr_aliceReceivingChainArrow3, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceReceivingChain4 = new Text(cmp_aliceReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain4.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceReceivingChain4.setText(aliceReceivingChainLabel4);
        
        insertSpacers(cmp_aliceReceivingChain, 2);

        txt_aliceReceivingChain5 = new Text(cmp_aliceReceivingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain5.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceReceivingChain5.setText(aliceReceivingChainLabel5);

    }

    private void createAliceMessagebox() {
        grp_aliceMessagebox.setLayout(Layout.gl_messageboxGroup());

        grp_aliceMessagebox.setLayoutData(Layout.gd_messageboxComposite());
        grp_aliceMessagebox.setText(MessageboxDescription);

        txt_alicePlainText = new Text(grp_aliceMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        txt_alicePlainText.setText(MessageboxPlainText);
        txt_alicePlainText.setLayoutData(Layout.gd_Messagebox());

        txt_aliceCipherText = new Text(grp_aliceMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_aliceCipherText.setLayoutData(Layout.gd_Messagebox());

        txt_aliceCipherText.setText("Encrypted Message");
        txt_alicePlainText.addListener(SWT.Modify, new Listener() {

            @Override
            public void handleEvent(Event e) {
                txt_alicePlainText.setTextLimit(256);
            }
        });
        txt_alicePlainText.setEditable(true);
        System.out.println(txt_alicePlainText.getText());

    }

    private void createAliceSendingChain() {
        cmp_aliceSendingChain.setLayout(Layout.gl_sendingReceivingChainComposite(SWT.LEFT));
        cmp_aliceSendingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());

        // arrow down
        arr_aliceSendingChainArrow4 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow4.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 2, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceSendingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(
                        arr_aliceSendingChainArrow4, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceSendingChain1 = new Text(cmp_aliceSendingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain1.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceSendingChain1.setText(aliceSendingChainLabel1);
        
        insertSpacers(cmp_aliceSendingChain, 3);

        // arrow down
        arr_aliceSendingChainArrow1 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow1.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceSendingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(
                        arr_aliceSendingChainArrow1, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        insertSpacers(cmp_aliceSendingChain, 1);

        txt_aliceSendingChain2 = new Text(cmp_aliceSendingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain2.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceSendingChain2.setText(aliceSendingChainLabel2);

        // arrow right
        arr_aliceSendingChainArrow2 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow2.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceSendingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(
                        arr_aliceSendingChainArrow2, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceSendingChain3 = new Text(cmp_aliceSendingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain3.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceSendingChain3.setText(aliceSendingChainLabel3);
        
        insertSpacers(cmp_aliceSendingChain, 3);

        // arrow down
        arr_aliceSendingChainArrow3 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow3.setLayoutData(SignalEncryptionArrows.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ARROW_CANVAS_WIDTH
        ));
        arr_aliceSendingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownRightArrow(
                        arr_aliceSendingChainArrow3, ARROW_THICKNESS, ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceSendingChain4 = new Text(cmp_aliceSendingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain4.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceSendingChain4.setText(aliceSendingChainLabel4);

        insertSpacers(cmp_aliceSendingChain, 2);

        txt_aliceSendingChain5 = new Text(cmp_aliceSendingChain,
                SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain5.setLayoutData(Layout.gd_algorithmLabels());
        txt_aliceSendingChain5.setText(aliceSendingChainLabel5);

    }

    /**
     * Insert invisible spacing widgets into the composite container.
     * 
     * Can be used for GridLayouts to fill into "empty" slots in the grid.
     * @param parent widget to attach spacers to
     * @param number number of spacers (grid cells) to fill
     */
    private void insertSpacers(Composite parent, int number) {
        for (int i = 0; i < number; ++i ) {
            var label = new Label(parent, SWT.NONE);
            label.setVisible(false);
        }
    }

    void showBobView() {
        StackLayout layout = (StackLayout) this.cmp_body.getLayout();
        layout.topControl = this.cmp_bob;
        cmp_body.layout();
    }

    void showAliceView() {
        StackLayout layout = (StackLayout) this.cmp_body.getLayout();
        layout.topControl = this.cmp_alice;
        cmp_body.layout();
        
    }

    void showAliceReceivingChain() {
        StackLayout layout = (StackLayout) this.grp_aliceSendingReceivingChain.getLayout();
        grp_aliceSendingReceivingChain.setText(ReceivingChainDescription);
        layout.topControl = this.cmp_aliceReceivingChain;
        this.grp_aliceSendingReceivingChain.layout();
    }

    void showAliceSendingChain() {
        StackLayout layout = (StackLayout) this.grp_aliceSendingReceivingChain.getLayout();
        grp_aliceSendingReceivingChain.setText(SendingChainDescription);
        layout.topControl = this.cmp_aliceSendingChain;
        this.grp_aliceSendingReceivingChain.layout();
    }

    void showBobSendingChain() {
        StackLayout layout = (StackLayout) this.grp_bobSendingReceivingChain.getLayout();
        grp_bobSendingReceivingChain.setText(SendingChainDescription);
        layout.topControl = this.cmp_bobSendingChain;
        this.grp_bobSendingReceivingChain.layout();
    }

    void showBobReceivingChain() {
        StackLayout layout = (StackLayout) this.grp_bobSendingReceivingChain.getLayout();
        grp_bobSendingReceivingChain.setText(ReceivingChainDescription);
        layout.topControl = this.cmp_bobReceivingChain;
        this.grp_bobSendingReceivingChain.layout();
    }

    public void resetAll() {
        signalEncryptionDoubleRatchetState.reset(this);
    }

}
