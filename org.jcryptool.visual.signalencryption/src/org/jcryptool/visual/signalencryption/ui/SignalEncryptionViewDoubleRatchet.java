package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
// import org.jcryptool.visual.signalencryption.ui.SignalEncryptionDoubleRatchetState.STATE;



public class SignalEncryptionViewDoubleRatchet extends Composite {

    private TitleAndDescriptionComposite titleAndDescription;

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

    Composite cmp_bobAlgorithm;
    Composite cmp_bobSteps;
    Composite cmp_aliceDiffieHellman;
    Composite cmp_aliceRootChain;
    Composite cmp_aliceReceivingChain;
    Composite cmp_aliceSendingChain;
    Composite cmp_bobDiffieHellman;
    Composite cmp_bobSendingChain;
    Composite cmp_bobReceivingChain;
    Composite cmp_bobRootChain;
//    Composite cmp_aliceAlgorithm;
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
    
    GridLayout gl_parent;
    GridLayout gl_diffieHellmanComposite;
    GridLayout gl_aliceComposite;
    GridLayout gl_bobComposite;
    GridLayout gl_algorithmComposite;
    GridLayout gl_rootChainComposite;
    GridLayout gl_sendingReceivingChainComposite;
    GridLayout gl_stepsComposite;
    GridLayout gl_algorithmGroup;
    GridLayout gl_stepsGroup;
    GridLayout gl_diffieHellmanGroup;
    GridLayout gl_rootChainGroup;
    StackLayout sl_AliceSendingReceivingChainGroup;
    GridLayout gl_arrowSpaceComposite;
    GridLayout gl_aliceReceivingChainGroup;
    GridLayout gl_messageboxComposite;

    GridData gd_algorithmComposite;
    GridData gd_stepsComposite;

    GridData gd_btnAlice;
    GridData gd_btnBob;
    GridData gd_btnNext;
    GridData gd_btnPrev;
    GridData gd_diffieHellmanComposite;
    GridData gd_rootChainComposite;
    GridData gd_sendingReceivingChainComposite;
    GridData gd_algorithmLabels;
    GridData gd_shortDescriptionTexts;
    GridData gd_longDescriptionTexts;
    GridData gd_bobAlgorithmGroup;
    GridData gd_bobStepsGroup;
    GridData gd_bobDiffieHellmanGroup;
    GridData gd_bobRootChainGroupe;
    GridData gd_bobSendingChainGroup;
    GridData gd_bobReceivingChainGroup;
    GridData gd_arrowSpaceComposite;
    GridData gd_Messagebox;

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

    private SignalEncryptionAlgorithm signalEncryptionAlgorithm;
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

    private GridLayout gl_messageboxGroup;

    private GridData gd_messageboxComposite;

    Group grp_bobMessagebox;

    private StackLayout sl_BobSendingReceivingChainGroup;

    private GridData gd_algorithmGroup;

    private GridData gd_stepsGroup;

    private GridData gd_diffieHellmanGroup;

    private GridData gd_rootChainGroup;

    private GridData gd_messageboxGroup;

    private GridData gd_sendingReceivingChainGroup;

    private Composite cmp_buttons;

    private Composite cmp_header;







    SignalEncryptionViewDoubleRatchet(Composite parent, int style,
            SignalEncryptionAlgorithmState signalEncryptionState) {
        super(parent, style);

        this.signalEncryptionState = signalEncryptionState;
        this.signalEncryptionAlgorithm = signalEncryptionState.getSignalEncryptionAlgorithm();
        this.instance = this;
        gl_parent = new GridLayout(1, false);
        setLayout(gl_parent);
        

        // style data for the labels within the algorithm
        gd_algorithmLabels = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
        gd_algorithmLabels.widthHint = 150;
        gd_algorithmLabels.heightHint = 60;

        // style data for the description texts
        gd_longDescriptionTexts = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        gd_longDescriptionTexts.minimumHeight = 30;
        
        gd_shortDescriptionTexts = new GridData(SWT.FILL,SWT.FILL,false,false, 1, 1);
        gd_shortDescriptionTexts.minimumHeight = 20;
        // style data for message box
        gd_Messagebox = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        
        // style data for arrow composites
        gl_arrowSpaceComposite = new GridLayout(1,false);
        gd_arrowSpaceComposite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
        

        gl_algorithmGroup = new GridLayout(6, false);
        gl_stepsGroup = new GridLayout(1, false);
        gl_diffieHellmanGroup = new GridLayout(1, false);
        gl_rootChainGroup = new GridLayout(1, false);
        gl_messageboxGroup = new GridLayout(1, false);


        gl_algorithmComposite = new GridLayout(6, false);
        gl_stepsComposite = new GridLayout(1, false);
        gl_diffieHellmanComposite = new GridLayout(1, false);
        gl_rootChainComposite = new GridLayout(1, false);
        gl_sendingReceivingChainComposite = new GridLayout(4, false);
        gl_messageboxComposite = new GridLayout(1, false);
        
        gd_algorithmGroup = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        gd_stepsGroup = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        gd_diffieHellmanGroup = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        gd_rootChainGroup = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        gd_messageboxGroup = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
        gd_sendingReceivingChainGroup = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);

        gd_algorithmComposite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        gd_stepsComposite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        gd_diffieHellmanComposite = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
        gd_rootChainComposite = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
        gd_messageboxComposite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
        gd_sendingReceivingChainComposite = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
        

        createHeaderComposite();
        createBodyComposite();
        createAliceComposite();
        createBobComposite();
        showAliceView();
        
        this.signalEncryptionDoubleRatchetState = new SignalEncryptionDoubleRatchetState(this);

    }

    private void createHeaderComposite() {

        cmp_header = new Composite(this, SWT.NONE);
        cmp_header.setLayout(new GridLayout(1,false));
        cmp_header.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 14, 1));
        cmp_header.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
        
        setTitleAndDescription();
        createButtons();
        
    }

    private void createButtons() {
        cmp_buttons = new Composite(cmp_header, SWT.NONE);
        cmp_buttons.setLayout(new GridLayout(4,false));
        cmp_buttons.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false,14,1));
        
        createAliceButton();
        createPreviousButton();
        createNextButton();
        createBobButton();
        
    }

    private void setTitleAndDescription() {
        
        Text text123 = new Text(cmp_header, SWT.NONE);
        text123.setText(Messages.SignalEncryption_TabTitle2 + "\n\n" + Messages.SignalEncryption_TabDesc2);
        text123.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
//        titleAndDescription = new TitleAndDescriptionComposite(cmp_header);
//        titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 14, 1));
//        titleAndDescription.setTitle(Messages.SignalEncryption_TabTitle2);
//        titleAndDescription.setDescription(Messages.SignalEncryption_TabDesc2);
    }

    private void createBodyComposite() {

        cmp_body = new Composite(this, SWT.NONE);
        cmp_body.setLayout(new StackLayout());
        cmp_body.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        cmp_body.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
    }

    private void createAliceButton() {
        
        btn_alice = new Button(cmp_buttons, SWT.LEFT);
        btn_alice.setAlignment(SWT.CENTER);

        gd_btnAlice = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
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
        gd_btnBob = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
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
        gd_btnPrev = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
        gd_btnPrev.widthHint = 150;
        btn_previous.setLayoutData(gd_btnPrev);
        btn_previous.setText(btn_PreviousDescription);
        btn_previous.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                signalEncryptionDoubleRatchetState.stepBack(instance, signalEncryptionDoubleRatchetState);
                System.out.println(signalEncryptionDoubleRatchetState.getCurrentState().toString());

            }
        });
    }

    private void createNextButton() {
        btn_next = new Button(cmp_buttons, SWT.PUSH);
        btn_next.setAlignment(SWT.CENTER);
        gd_btnNext = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_btnNext.widthHint = 150;
        btn_next.setLayoutData(gd_btnNext);
        btn_next.setText(btn_NextDescription);
        btn_next.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                signalEncryptionDoubleRatchetState.stepForward(instance, signalEncryptionDoubleRatchetState);
                System.out.println(signalEncryptionDoubleRatchetState.getCurrentState().toString());
            }
        });

    }
    
    private void createBobComposite() {
        // Init of the layouts and data needed
        cmp_bob = new Composite(cmp_body, SWT.NONE);

        // Parent groups for algorithm and steps composites
        grp_bobSteps = new Group(cmp_bob, SWT.CENTER);
        grp_bobAlgorithm = new Group(cmp_bob, SWT.CENTER);

        // Parent composite for chain groups
        cmp_bobSteps = new Composite(grp_bobSteps, SWT.CENTER);
        cmp_bobAlgorithm = new Composite(grp_bobAlgorithm, SWT.CENTER);

        // Parent groups for chain composites
        grp_bobMessagebox = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobSendingReceivingChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        cmp_bobArrowSpace2 = new Composite(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobRootChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        cmp_bobArrowSpace1 = new Composite(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobDiffieHellman = new Group(cmp_bobAlgorithm, SWT.CENTER);

        // Composites for overlapping sending and receiving chains
        cmp_bobSendingChain = new Composite(grp_bobSendingReceivingChain, SWT.CENTER);
        cmp_bobReceivingChain = new Composite(grp_bobSendingReceivingChain, SWT.CENTER);

        // Composite for Message Box
        cmp_bobMessagebox = new Composite(grp_bobMessagebox, SWT.CENTER);

        // Layouts
        gl_bobComposite = new GridLayout(1, true);
        sl_BobSendingReceivingChainGroup = new StackLayout();
        
        cmp_bob.setLayout(gl_bobComposite);

        grp_bobSteps.setText(stepGroupDescription);
        grp_bobSteps.setLayout(gl_stepsComposite);
        grp_bobSteps.setLayoutData(gd_stepsComposite);

        cmp_bobSteps.setLayout(gl_stepsComposite);
        cmp_bobSteps.setLayoutData(gd_stepsComposite);

        grp_bobAlgorithm.setText(bobAlgorithmGroupDescription);
        grp_bobAlgorithm.setLayout(gl_algorithmComposite);
        grp_bobAlgorithm.setLayoutData(gd_algorithmComposite);

        cmp_bobAlgorithm.setLayout(gl_algorithmComposite);
        cmp_bobAlgorithm.setLayoutData(gd_algorithmComposite);

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
        cmp_bobArrowSpace1.setLayout(gl_arrowSpaceComposite);
        cmp_bobArrowSpace1.setLayoutData(gd_arrowSpaceComposite);
        
        // arrow up
        arr_bobSpace1 = new Canvas(cmp_bobArrowSpace1, SWT.DOUBLE_BUFFERED);
        arr_bobSpace1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, true, 1, 1,75));
        arr_bobSpace1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftUpLeftArrow(arr_bobSpace1, 5, 10,156);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        new Text(cmp_bobArrowSpace1,SWT.NONE);
        new Text(cmp_bobArrowSpace1,SWT.NONE);
        new Text(cmp_bobArrowSpace1,SWT.NONE);
        new Text(cmp_bobArrowSpace1,SWT.NONE);
        new Text(cmp_bobArrowSpace1,SWT.NONE);
        new Text(cmp_bobArrowSpace1,SWT.NONE);
        
        cmp_bobArrowSpace2.setLayout(gl_arrowSpaceComposite);
        cmp_bobArrowSpace2.setLayoutData(gd_arrowSpaceComposite);
        
        // arrow up
        arr_bobSpace2 = new Canvas(cmp_bobArrowSpace2, SWT.DOUBLE_BUFFERED);
        arr_bobSpace2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, true, true, 1, 1,75));
        arr_bobSpace2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftUpLeftArrowHeadless(arr_bobSpace2, 5, 10,156);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        new Text(cmp_bobArrowSpace2,SWT.NONE);
        new Text(cmp_bobArrowSpace2,SWT.NONE);
        new Text(cmp_bobArrowSpace2,SWT.NONE);
        new Text(cmp_bobArrowSpace2,SWT.NONE);
        new Text(cmp_bobArrowSpace2,SWT.NONE);
        new Text(cmp_bobArrowSpace2,SWT.NONE);
	}

	private void createBobMessagebox() {
	    
	    grp_bobMessagebox.setLayout(gl_messageboxGroup);
	    grp_bobMessagebox.setLayoutData(gd_messageboxComposite);
	    grp_bobMessagebox.setText(MessageboxDescription);

        txt_bobCipherText = new Text(grp_bobMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_bobCipherText.setText(MessageboxCipherText);
        txt_bobCipherText.setLayoutData(gd_Messagebox);

        txt_bobPlainText = new Text(grp_bobMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_bobPlainText.setText(MessageboxPlainText);
        txt_bobPlainText.setLayoutData(gd_Messagebox);
        txt_bobPlainText.addListener(SWT.Modify, new Listener() {

            @Override
            public void handleEvent(Event e) {
                txt_bobPlainText.setTextLimit(256);
            }
        });
        txt_bobPlainText.setEditable(true);
    }

    private void createBobSteps() {
        txt_bobStep0 = new Text(cmp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobStep0.setText(bobStep0);
        txt_bobStep0.setLayoutData(gd_shortDescriptionTexts);
        txt_bobStep5 = new Text(cmp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobStep5.setText(bobStep5);
        txt_bobStep5.setLayoutData(gd_shortDescriptionTexts);
        txt_step6 = new Text(cmp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step6.setText(step6);
        txt_step6.setLayoutData(gd_shortDescriptionTexts);
        txt_step7 = new Text(cmp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step7.setText(step7);
        txt_step7.setLayoutData(gd_shortDescriptionTexts);
        txt_step8 = new Text(cmp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step8.setText(step8);
        txt_step8.setLayoutData(gd_shortDescriptionTexts);
        txt_step9 = new Text(cmp_bobSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_step9.setText(step9);
        txt_step9.setLayoutData(gd_shortDescriptionTexts);
    }

    private void createBobSendingChain() {
        grp_bobSendingReceivingChain.setLayout(sl_BobSendingReceivingChainGroup);
        grp_bobSendingReceivingChain.setLayoutData(gd_sendingReceivingChainComposite);

        cmp_bobSendingChain.setLayout(gl_sendingReceivingChainComposite);
        cmp_bobSendingChain.setLayoutData(gd_sendingReceivingChainComposite);

        // empty label for filling space
        new Text(cmp_bobSendingChain, SWT.NONE);
        
        txt_bobSendingChain1 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain1.setLayoutData(gd_algorithmLabels);
        txt_bobSendingChain1.setText(bobSendingChainLabel1);
        
        arr_bobSendingChainArrow4 = new Canvas(cmp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow4
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 2, 1, 75));
        arr_bobSendingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(arr_bobSendingChainArrow4, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        // empty label for filling space
        new Text(cmp_bobSendingChain, SWT.NONE);
        
        // arrow down
        arr_bobSendingChainArrow1 = new Canvas(cmp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobSendingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_bobSendingChainArrow1, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        // empty label for filling space
        new Text(cmp_bobSendingChain, SWT.NONE);        
        new Text(cmp_bobSendingChain, SWT.NONE);
        new Text(cmp_bobSendingChain, SWT.NONE);


        txt_bobSendingChain2 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain2.setLayoutData(gd_algorithmLabels);
        txt_bobSendingChain2.setText(bobSendingChainLabel2);

        // arrow left
        arr_bobSendingChainArrow2 = new Canvas(cmp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobSendingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(arr_bobSendingChainArrow2, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobSendingChain3 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain3.setLayoutData(gd_algorithmLabels);
        txt_bobSendingChain3.setText(bobSendingChainLabel3);
        
        txt_bobSendingChain4 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain4.setLayoutData(gd_algorithmLabels);
        txt_bobSendingChain4.setText(bobSendingChainLabel4);

        // arrow left
        arr_bobSendingChainArrow3 = new Canvas(cmp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow3
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobSendingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownLeftArrow(arr_bobSendingChainArrow3, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        // empty label for filling space
        new Text(cmp_bobSendingChain, SWT.NONE);
        new Text(cmp_bobSendingChain, SWT.NONE);
        new Text(cmp_bobSendingChain, SWT.NONE);

        txt_bobSendingChain5 = new Text(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobSendingChain5.setLayoutData(gd_algorithmLabels);
        txt_bobSendingChain5.setText(bobSendingChainLabel5);

    }

    private void createBobReceivingChain() {

        cmp_bobReceivingChain.setLayout(gl_sendingReceivingChainComposite);
        cmp_bobReceivingChain.setLayoutData(gd_sendingReceivingChainComposite);

        // empty label for filling space
        new Text(cmp_bobReceivingChain, SWT.NONE);
        
        txt_bobReceivingChain1 = new Text(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain1.setLayoutData(gd_algorithmLabels);
        txt_bobReceivingChain1.setText(bobReceivingChainLabel1);
        
        arr_bobReceivingChainArrow4 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow4
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 2, 1, 75));
        arr_bobReceivingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(arr_bobReceivingChainArrow4, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        // empty label for filling space
        new Text(cmp_bobReceivingChain, SWT.NONE);
        
        // arrow down
        arr_bobReceivingChainArrow1 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobReceivingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_bobReceivingChainArrow1, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        // empty label for filling space
        new Text(cmp_bobReceivingChain, SWT.NONE);        
        new Text(cmp_bobReceivingChain, SWT.NONE);
        new Text(cmp_bobReceivingChain, SWT.NONE);


        txt_bobReceivingChain2 = new Text(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain2.setLayoutData(gd_algorithmLabels);
        txt_bobReceivingChain2.setText(bobReceivingChainLabel2);

        // arrow left
        arr_bobReceivingChainArrow2 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobReceivingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(arr_bobReceivingChainArrow2, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobReceivingChain3 = new Text(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain3.setLayoutData(gd_algorithmLabels);
        txt_bobReceivingChain3.setText(bobReceivingChainLabel3);
        
        txt_bobReceivingChain4 = new Text(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain4.setLayoutData(gd_algorithmLabels);
        txt_bobReceivingChain4.setText(bobReceivingChainLabel4);

        // arrow left
        arr_bobReceivingChainArrow3 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow3
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobReceivingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownLeftArrow(arr_bobReceivingChainArrow3, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        // empty label for filling space
        new Text(cmp_bobReceivingChain, SWT.NONE);
        new Text(cmp_bobReceivingChain, SWT.NONE);
        new Text(cmp_bobReceivingChain, SWT.NONE);

        txt_bobReceivingChain5 = new Text(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobReceivingChain5.setLayoutData(gd_algorithmLabels);
        txt_bobReceivingChain5.setText(bobReceivingChainLabel5);

    }

    private void createBobRootChain() {
        grp_bobRootChain.setText(RootChainDescription);
        grp_bobRootChain.setLayout(gl_rootChainComposite);
        grp_bobRootChain.setLayoutData(gd_rootChainComposite);

        txt_bobRootChain1 = new Text(grp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobRootChain1.setLayoutData(gd_algorithmLabels);
        txt_bobRootChain1.setText(bobRootChainLabel1);

        // arrow down
        arr_bobRootChainArrow1 = new Canvas(grp_bobRootChain, SWT.DOUBLE_BUFFERED);
        arr_bobRootChainArrow1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobRootChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_bobRootChainArrow1, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobRootChain2 = new Text(grp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobRootChain2.setLayoutData(gd_algorithmLabels);
        txt_bobRootChain2.setText(bobRootChainLabel2);

        // arrow down
        arr_bobRootChainArrow2 = new Canvas(grp_bobRootChain, SWT.DOUBLE_BUFFERED);
        arr_bobRootChainArrow2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobRootChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_bobRootChainArrow2, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobRootChain3 = new Text(grp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobRootChain3.setLayoutData(gd_algorithmLabels);
        txt_bobRootChain3.setText(bobRootChainLabel3);

    }

    private void createBobDiffieHellmanChain() {
        grp_bobDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_bobDiffieHellman.setLayout(gl_diffieHellmanComposite);
        grp_bobDiffieHellman.setLayoutData(gd_rootChainComposite);

        txt_bobDiffieHellman1 = new Text(grp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobDiffieHellman1.setLayoutData(gd_algorithmLabels);
        txt_bobDiffieHellman1.setText(bobDiffieHellmanLabel1);

        // arrow down
        arr_bobDiffieHellmanArrow1 = new Canvas(grp_bobDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_bobDiffieHellmanArrow1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobDiffieHellmanArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_bobDiffieHellmanArrow1, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobDiffieHellman2 = new Text(grp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobDiffieHellman2.setLayoutData(gd_algorithmLabels);
        txt_bobDiffieHellman2.setText(bobDiffieHellmanLabel2);

        // arrow up
        arr_bobDiffieHellmanArrow2 = new Canvas(grp_bobDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_bobDiffieHellmanArrow2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobDiffieHellmanArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawUpArrow(arr_bobDiffieHellmanArrow2, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobDiffieHellman3 = new Text(grp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_bobDiffieHellman3.setLayoutData(gd_algorithmLabels);
        txt_bobDiffieHellman3.setText(bobDiffieHellmanLabel3);

    }

    private void createAliceComposite() {
        // Init of the widgets, layouts and data needed
        cmp_alice = new Composite(cmp_body, SWT.NONE);

        // Parent groups for algorithm and steps composites
        grp_aliceSteps = new Group(cmp_alice, SWT.CENTER);
        grp_aliceAlgorithm = new Group(cmp_alice, SWT.CENTER);

        // Parent composite for chain groups
//        cmp_aliceAlgorithm = new Composite(grp_aliceAlgorithm, SWT.CENTER);

        // Parent groups for chain composites
        grp_aliceDiffieHellman = new Group(grp_aliceAlgorithm, SWT.CENTER);    
        cmp_aliceArrowSpace1 = new Composite(grp_aliceAlgorithm, SWT.CENTER);  
        grp_aliceRootChain = new Group(grp_aliceAlgorithm, SWT.CENTER);
        cmp_aliceArrowSpace2 = new Composite(grp_aliceAlgorithm, SWT.CENTER); 
        grp_aliceSendingReceivingChain = new Group(grp_aliceAlgorithm, SWT.CENTER);
        grp_aliceMessagebox = new Group(grp_aliceAlgorithm, SWT.CENTER);

        // Composites for overlapping sending and receiving chains
        cmp_aliceSendingChain = new Composite(grp_aliceSendingReceivingChain, SWT.CENTER);
        cmp_aliceReceivingChain = new Composite(grp_aliceSendingReceivingChain, SWT.CENTER);

        // Layouts
        gl_aliceComposite = new GridLayout(1, false);
        sl_AliceSendingReceivingChainGroup = new StackLayout();

        cmp_alice.setLayout(gl_aliceComposite);

        grp_aliceAlgorithm.setText(aliceAlgorithmGroupDescription);
        grp_aliceAlgorithm.setLayout(gl_algorithmGroup);
        grp_aliceAlgorithm.setLayoutData(gd_algorithmGroup);

        grp_aliceSteps.setText(stepGroupDescription);
        grp_aliceSteps.setLayout(gl_stepsGroup);
        grp_aliceSteps.setLayoutData(gd_stepsGroup);

//        cmp_aliceAlgorithm.setLayout(gl_algorithmComposite);
//        cmp_aliceAlgorithm.setLayoutData(gd_algorithmComposite);

//        cmp_aliceSteps.setLayout(gl_stepsComposite);
//        cmp_aliceSteps.setLayoutData(gd_stepsComposite);

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
        cmp_aliceArrowSpace1.setLayout(gl_arrowSpaceComposite);
        cmp_aliceArrowSpace1.setLayoutData(gd_arrowSpaceComposite);
        
        // arrow up
        arr_aliceSpace1 = new Canvas(cmp_aliceArrowSpace1, SWT.DOUBLE_BUFFERED );
        arr_aliceSpace1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, true, 1, 1,75));
        arr_aliceSpace1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightUpRightArrow(arr_aliceSpace1, 5, 10,156);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        new Text(cmp_aliceArrowSpace1,SWT.NONE );
        new Text(cmp_aliceArrowSpace1,SWT.NONE );
        new Text(cmp_aliceArrowSpace1,SWT.NONE );
        new Text(cmp_aliceArrowSpace1,SWT.NONE );
        new Text(cmp_aliceArrowSpace1,SWT.NONE );
        new Text(cmp_aliceArrowSpace1,SWT.NONE );
        
        cmp_aliceArrowSpace2.setLayout(gl_arrowSpaceComposite);
        cmp_aliceArrowSpace2.setLayoutData(gd_arrowSpaceComposite);
        
        // arrow up
        arr_aliceSpace2 = new Canvas(cmp_aliceArrowSpace2, SWT.DOUBLE_BUFFERED);
        arr_aliceSpace2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, true, true, 1, 1,75));
        arr_aliceSpace2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightUpRightArrowHeadless(arr_aliceSpace2, 5, 10,156);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        new Text(cmp_aliceArrowSpace2,SWT.NONE );
        new Text(cmp_aliceArrowSpace2,SWT.NONE );
        new Text(cmp_aliceArrowSpace2,SWT.NONE );
        new Text(cmp_aliceArrowSpace2,SWT.NONE );
        new Text(cmp_aliceArrowSpace2,SWT.NONE );
        new Text(cmp_aliceArrowSpace2,SWT.NONE );
    }

    private void createAliceSteps() {
        txt_aliceStep0 = new Text(grp_aliceSteps, SWT.WRAP | SWT.READ_ONLY);
        txt_aliceStep0.setText(aliceStep0);
        txt_aliceStep0.setLayoutData(gd_shortDescriptionTexts);
        txt_step1 = new Text(grp_aliceSteps, SWT.WRAP | SWT.READ_ONLY);
        txt_step1.setText(step1);
        txt_step1.setLayoutData(gd_shortDescriptionTexts);
        txt_step2 = new Text(grp_aliceSteps, SWT.READ_ONLY | SWT.WRAP );
        txt_step2.setText(step2);
        txt_step2.setLayoutData(gd_longDescriptionTexts);
        txt_step3 = new Text(grp_aliceSteps, SWT.READ_ONLY | SWT.WRAP );
        txt_step3.setText(step3);
        txt_step3.setLayoutData(gd_longDescriptionTexts);
        txt_step4 = new Text(grp_aliceSteps, SWT.READ_ONLY | SWT.WRAP );
        txt_step4.setText(step4);
        txt_step4.setLayoutData(gd_shortDescriptionTexts);
        txt_aliceStep5 = new Text(grp_aliceSteps, SWT.READ_ONLY | SWT.WRAP );
        txt_aliceStep5.setText(aliceStep5);
        txt_aliceStep5.setLayoutData(gd_longDescriptionTexts);
    }

    private void createAliceDiffieHellmanChain() {
        grp_aliceDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_aliceDiffieHellman.setLayout(gl_diffieHellmanComposite);
        grp_aliceDiffieHellman.setLayoutData(gd_diffieHellmanComposite);

//        cmp_aliceDiffieHellman.setLayout(gl_diffieHellmanComposite);
//        cmp_aliceDiffieHellman.setLayoutData(gd_diffieHellmanComposite);

        txt_aliceDiffieHellman1 = new Text(grp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceDiffieHellman1.setLayoutData(gd_algorithmLabels);
        txt_aliceDiffieHellman1.setText(aliceDiffieHellmanLabel1);

        // arrow down
        arr_aliceDiffieHellmanArrow1 = new Canvas(grp_aliceDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_aliceDiffieHellmanArrow1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceDiffieHellmanArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_aliceDiffieHellmanArrow1, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceDiffieHellman2 = new Text(grp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceDiffieHellman2.setLayoutData(gd_algorithmLabels);
        txt_aliceDiffieHellman2.setText(aliceDiffieHellmanLabel2);

        // arrow up
        arr_aliceDiffieHellmanArrow2 = new Canvas(grp_aliceDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_aliceDiffieHellmanArrow2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceDiffieHellmanArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawUpArrow(arr_aliceDiffieHellmanArrow2, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });


        txt_aliceDiffieHellman3 = new Text(grp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceDiffieHellman3.setLayoutData(gd_algorithmLabels);
        txt_aliceDiffieHellman3.setText(aliceDiffieHellmanLabel3);
     

    }

    private void createAliceRootChain() {
        grp_aliceRootChain.setText(RootChainDescription);
        grp_aliceRootChain.setLayout(gl_rootChainComposite);
        grp_aliceRootChain.setLayoutData(gd_rootChainComposite);

//        cmp_aliceRootChain.setLayout(gl_rootChainComposite);
//        cmp_aliceRootChain.setLayoutData(gd_rootChainComposite);

        txt_aliceRootChain1 = new Text(grp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceRootChain1.setLayoutData(gd_algorithmLabels);
        txt_aliceRootChain1.setText(aliceRootChainLabel1);

        // arrow down
        arr_aliceRootChainArrow1 = new Canvas(grp_aliceRootChain, SWT.DOUBLE_BUFFERED);
        arr_aliceRootChainArrow1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceRootChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_aliceRootChainArrow1, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceRootChain2 = new Text(grp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceRootChain2.setLayoutData(gd_algorithmLabels);
        txt_aliceRootChain2.setText(aliceRootChainLabel2);
        
        // arrow down
        arr_aliceRootChainArrow2 = new Canvas(grp_aliceRootChain, SWT.DOUBLE_BUFFERED);
        arr_aliceRootChainArrow2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceRootChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_aliceRootChainArrow2, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceRootChain3 = new Text(grp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceRootChain3.setLayoutData(gd_algorithmLabels);
        txt_aliceRootChain3.setText(aliceRootChainLabel3);

    }

    private void createAliceReceivingChain() {

        cmp_aliceReceivingChain.setLayout(gl_sendingReceivingChainComposite);
        cmp_aliceReceivingChain.setLayoutData(gd_sendingReceivingChainComposite);
        
        // arrow down
        arr_aliceReceivingChainArrow4 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow4
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 2, 1, 75));
        arr_aliceReceivingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(arr_aliceReceivingChainArrow4, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });


        txt_aliceReceivingChain1 = new Text(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain1.setLayoutData(gd_algorithmLabels);
        txt_aliceReceivingChain1.setText(aliceReceivingChainLabel1);

        // empty label for filling space
        new Text(cmp_aliceReceivingChain, SWT.NONE);
        new Text(cmp_aliceReceivingChain, SWT.NONE);
        new Text(cmp_aliceReceivingChain, SWT.NONE);

        // arrow down
        arr_aliceReceivingChainArrow1 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceReceivingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_aliceReceivingChainArrow1, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        // empty label for filling space
        new Text(cmp_aliceReceivingChain, SWT.NONE);
        
        txt_aliceReceivingChain2 = new Text(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain2.setLayoutData(gd_algorithmLabels);
        txt_aliceReceivingChain2.setText(aliceReceivingChainLabel2);

        // arrow right
        arr_aliceReceivingChainArrow2 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceReceivingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(arr_aliceReceivingChainArrow2, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceReceivingChain3 = new Text(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain3.setLayoutData(gd_algorithmLabels);
        txt_aliceReceivingChain3.setText(aliceReceivingChainLabel3);

        // empty label for filling space
        new Text(cmp_aliceReceivingChain, SWT.NONE);
        new Text(cmp_aliceReceivingChain, SWT.NONE);
        new Text(cmp_aliceReceivingChain, SWT.NONE);

        // arrow down
        arr_aliceReceivingChainArrow3 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow3
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceReceivingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownRightArrow(arr_aliceReceivingChainArrow3, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceReceivingChain4 = new Text(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain4.setLayoutData(gd_algorithmLabels);
        txt_aliceReceivingChain4.setText(aliceReceivingChainLabel4);

        // empty label for filling space
        new Text(cmp_aliceReceivingChain, SWT.NONE);
        new Text(cmp_aliceReceivingChain, SWT.NONE);

        txt_aliceReceivingChain5 = new Text(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceReceivingChain5.setLayoutData(gd_algorithmLabels);
        txt_aliceReceivingChain5.setText(aliceReceivingChainLabel5);

    }

    private void createAliceMessagebox() {
        grp_aliceMessagebox.setLayout(gl_messageboxGroup);
        
        grp_aliceMessagebox.setLayoutData(gd_messageboxComposite);
        grp_aliceMessagebox.setText("Nachricht");
        
        txt_alicePlainText = new Text(grp_aliceMessagebox, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        txt_alicePlainText.setText(MessageboxPlainText);
        txt_alicePlainText.setLayoutData(gd_Messagebox);

        txt_aliceCipherText = new Text(grp_aliceMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_aliceCipherText.setLayoutData(gd_Messagebox);
        
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
        grp_aliceSendingReceivingChain.setLayout(sl_AliceSendingReceivingChainGroup);
        grp_aliceSendingReceivingChain.setLayoutData(gd_sendingReceivingChainComposite);

        cmp_aliceSendingChain.setLayout(gl_sendingReceivingChainComposite);
        cmp_aliceSendingChain.setLayoutData(gd_sendingReceivingChainComposite);
        
        // arrow down
        arr_aliceSendingChainArrow4 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow4
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 2, 1, 75));
        arr_aliceSendingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(arr_aliceSendingChainArrow4, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });


        txt_aliceSendingChain1 = new Text(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain1.setLayoutData(gd_algorithmLabels);
        txt_aliceSendingChain1.setText(aliceSendingChainLabel1);

        // empty label for filling space
        new Text(cmp_aliceSendingChain, SWT.NONE);
        new Text(cmp_aliceSendingChain, SWT.NONE);
        new Text(cmp_aliceSendingChain, SWT.NONE);

        // arrow down
        arr_aliceSendingChainArrow1 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceSendingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_aliceSendingChainArrow1, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        // empty label for filling space
        new Text(cmp_aliceSendingChain, SWT.NONE);
        
        txt_aliceSendingChain2 = new Text(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain2.setLayoutData(gd_algorithmLabels);
        txt_aliceSendingChain2.setText(aliceSendingChainLabel2);

        // arrow right
        arr_aliceSendingChainArrow2 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceSendingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(arr_aliceSendingChainArrow2, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceSendingChain3 = new Text(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain3.setLayoutData(gd_algorithmLabels);
        txt_aliceSendingChain3.setText(aliceSendingChainLabel3);

        // empty label for filling space
        new Text(cmp_aliceSendingChain, SWT.NONE);
        new Text(cmp_aliceSendingChain, SWT.NONE);
        new Text(cmp_aliceSendingChain, SWT.NONE);

        // arrow down
        arr_aliceSendingChainArrow3 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow3
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceSendingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownRightArrow(arr_aliceSendingChainArrow3, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceSendingChain4 = new Text(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain4.setLayoutData(gd_algorithmLabels);
        txt_aliceSendingChain4.setText(aliceSendingChainLabel4);

        // empty label for filling space
        new Text(cmp_aliceSendingChain, SWT.NONE);
        new Text(cmp_aliceSendingChain, SWT.NONE);

        txt_aliceSendingChain5 = new Text(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        txt_aliceSendingChain5.setLayoutData(gd_algorithmLabels);
        txt_aliceSendingChain5.setText(aliceSendingChainLabel5);

    }
    void showBobView() {
        StackLayout layout = (StackLayout) this.cmp_body.getLayout();
        layout.topControl = this.cmp_bob;
        this.cmp_body.layout();

    }
    void showAliceView() {
        StackLayout layout = (StackLayout) this.cmp_body.getLayout();
        layout.topControl = this.cmp_alice;
        this.cmp_body.layout();
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
