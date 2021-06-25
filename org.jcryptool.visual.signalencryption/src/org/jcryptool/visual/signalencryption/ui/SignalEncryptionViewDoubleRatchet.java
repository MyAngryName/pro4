package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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

/**
 * 
 * @author Dan-Kerko Ciudin
 * 
 * 
 */

public class SignalEncryptionViewDoubleRatchet extends Composite {

    private TitleAndDescriptionComposite titleAndDescription;

    Composite cmp_main;
    Composite cmp_alice;
    Composite cmp_bob;

    Button btn_alice;
    Button btn_bob;
    Button btn_next;
    Button btn_previous;

    int stepCounter = 1;
    
    Group grp_steps;
    Group grp_aliceAlgorithm;
    Group grp_bobSteps;
    Group grp_bobAlgorithm;
    Group grp_bobSendingChain;
    Group grp_bobSpace2;
    Group grp_bobReceivingChain;
    Group grp_bobRootChain;
    Group grp_bobSpace1;
    Group grp_bobDiffieHellman;
    Group grp_aliceDiffieHellman;    
    Group grp_aliceArrowSpace1;
    Group grp_aliceRootChain;
    Group grp_aliceArrowSpace2;
    Group grp_aliceSendingChain;
    Group grp_aliceReceivingChain;

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
    Composite cmp_aliceAlgorithm;
    Composite cmp_steps;
    Composite cmp_aliceMessageBox;
    Composite cmp_bobMessageBox;

    String aliceAlgorithmGroupDescription = Messages.SignalEncryption_alice_AlgorithmGroupDescription;
    String bobAlgorithmGroupDescription = Messages.SignalEncryption_bob_AlgorithmGroupDescription;
    String stepGroupDescription = Messages.SignalEncryption_stepGroupDescription;
    String DiffieHellmanGroupDescription = Messages.SignalEncryption_DiffieHellmanGroupDescription;
    String RootChainDescription = Messages.SignalEncryption_RootChainDescription;
    String SendingChainDescription = Messages.SignalEncryption_SendingChainDescription;
    String ReceivingChainDescription = Messages.SignalEncryption_ReceivingChainDescription;
    String MessageBoxDescription = Messages.SignalEncryption_MessageBoxDescription;
    GridLayout gl_parent;
    GridLayout gl_aliceDiffieHellmanComposite;
    GridLayout gl_aliceComposite;
    GridLayout gl_bobComposite;
    GridLayout gl_aliceAlgorithmComposite;
    GridLayout gl_aliceRootChainComposite;
    GridLayout gl_aliceSendingChainComposite;
    GridLayout gl_aliceReceivingChainComposite;
    GridLayout gl_bobAlgorithmComposite;
    GridLayout gl_bobRootChainComposite;
    GridLayout gl_bobReceivingChainComposite;
    GridLayout gl_bobDiffieHellmanComposite;
    GridLayout gl_bobSendingChainComposite;
    GridLayout gl_stepsComposite;
    GridLayout gl_bobStepsComposite;
    GridLayout gl_bobAlgorithmGroup;
    GridLayout gl_bobStepsGroup;
    GridLayout gl_bobDiffieHellmanGroup;
    GridLayout gl_bobRootChainGroup;
    GridLayout gl_bobSendingChainGroup;
    GridLayout gl_bobReceivingChainGroup;
    GridLayout gl_bobSpaceGroup;
    GridLayout gl_aliceAlgorithmGroup;
    GridLayout gl_stepsGroup;
    GridLayout gl_aliceDiffieHellmanGroup;
    GridLayout gl_aliceRootChainGroup;
    GridLayout gl_aliceSendingChainGroup;
    GridLayout gl_aliceReceivingChainGroup;
    GridLayout gl_aliceSpaceGroup;
    GridLayout gl_aliceMessageBoxComposite;
    GridLayout gl_bobMessageBoxComposite;

    GridData gd_aliceAlgorithmComposite;
    GridData gd_stepsComposite;

    GridData gd_bobAlgorithmComposite;
    GridData gd_bobStepsComposite;
    GridData gd_btnAlice;
    GridData gd_btnBob;
    GridData gd_btnNext;
    GridData gd_btnPrev;
    GridData gd_aliceDiffieHellmanComposite;
    GridData gd_aliceRootChainComposite;
    GridData gd_aliceSendingChainComposite;
    GridData gd_aliceReceivingChainComposite;
    GridData gd_algorithmLabels;
    GridData gd_descriptionTexts;
    GridData gd_bobDiffieHellmanComposite;
    GridData gd_bobRootChainComposite;
    GridData gd_bobSendingChainComposite;
    GridData gd_bobReceivingChainComposite;
    GridData gd_bobAlgorithmGroup;
    GridData gd_bobStepsGroup;
    GridData gd_bobDiffieHellmanGroup;
    GridData gd_bobRootChainGroupe;
    GridData gd_bobSendingChainGroup;
    GridData gd_bobReceivingChainGroup;
    GridData gd_aliceArrowSpaceGroup;
    GridData gd_MessageBox;

    Label lb_aliceDiffieHellman1;
    Label lb_aliceDiffieHellman2;
    Label lb_aliceDiffieHellman3;
    Label lb_bobDiffieHellman1;
    Label lb_bobDiffieHellman2;
    Label lb_bobDiffieHellman3;
    Label lb_aliceRootChain1;
    Label lb_aliceRootChain2;
    Label lb_aliceRootChain3;
    Label lb_aliceSendingChain1;
    Label lb_aliceSendingChain2;
    Label lb_aliceSendingChain3;
    Label lb_aliceSendingChain4;
    Label lb_aliceSendingChain5;
    Label lb_aliceReceivingChain1;
    Label lb_aliceReceivingChain2;
    Label lb_aliceReceivingChain3;
    Label lb_aliceReceivingChain4;
    Label lb_aliceReceivingChain5;
    Label lb_bobRootChain1;
    Label lb_bobRootChain2;
    Label lb_bobRootChain3;
    Label lb_bobSendingChain1;
    Label lb_bobSendingChain2;
    Label lb_bobSendingChain3;
    Label lb_bobSendingChain4;
    Label lb_bobSendingChain5;
    Label lb_bobReceivingChain1;
    Label lb_bobReceivingChain2;
    Label lb_bobReceivingChain3;
    Label lb_bobReceivingChain4;
    Label lb_bobReceivingChain5;

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
    private String MessageBoxPlainText = "Geben Sie hier Ihre Nachricht an Bob ein.";
    private String MessageBoxCipherText = "The Ciphertext";

    private SignalEncryptionAlgorithm signalEncryptionAlgorithm;
    SignalEncryptionAlgorithmState signalEncryptionState;

    private SignalEncryptionViewDoubleRatchet instance;

    private Canvas arr_aliceDiffieHellmanArrow1;


    private Canvas arr_aliceDiffieHellmanArrow2;

    private Canvas arr_aliceRootChainArrow1;

    private Canvas arr_aliceRootChainArrow2;

    private Canvas arr_aliceSendingChainArrow5;
    private Canvas arr_aliceSendingChainArrow6;
    private Canvas arr_aliceSendingChainArrow1;
    private Canvas arr_aliceSendingChainArrow2;
    private Canvas arr_aliceSendingChainArrow3;
    private Canvas arr_aliceSendingChainArrow4;

    private Canvas arr_bobReceivingChainArrow1;
    private Canvas arr_bobReceivingChainArrow2;
    private Canvas arr_bobReceivingChainArrow3;
    private Canvas arr_bobReceivingChainArrow4;

    private Canvas arr_aliceReceivingChainArrow1;
    private Canvas arr_aliceReceivingChainArrow2;
    private Canvas arr_aliceReceivingChainArrow3;
    private Canvas arr_aliceReceivingChainArrow4;

    private Canvas arr_bobDiffieHellmanArrow1;
    private Canvas arr_bobDiffieHellmanArrow2;

    private Canvas arr_bobRootChainArrow1;

    private Canvas arr_bobRootChainArrow2;

    private Canvas arr_aliceSpace1;
    private Canvas arr_aliceSpace2;
    
    String input;
    private SignalEncryptionDoubleRatchetState signalEncryptionDoubleRatchetState;
    
    ModifyListener keys_changedListener;


    SignalEncryptionViewDoubleRatchet(Composite parent, int style,
            SignalEncryptionAlgorithmState signalEncryptionState) {
        super(parent, style);

        this.signalEncryptionState = signalEncryptionState;
        this.signalEncryptionAlgorithm = signalEncryptionState.getSignalEncryptionAlgorithm();
        this.instance = this;
        gl_parent = new GridLayout(4, false);
        gl_parent.horizontalSpacing = 3;
        gl_parent.verticalSpacing = 0;
        setLayout(gl_parent);

        // style data for the labels within the algorithm
        gd_algorithmLabels = new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1);
        gd_algorithmLabels.verticalIndent = 40;
        gd_algorithmLabels.horizontalIndent = 10;
        gd_algorithmLabels.widthHint = 150;
        gd_algorithmLabels.heightHint = 60;

        // style data for the description texts
        gd_descriptionTexts = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
        gd_descriptionTexts.minimumWidth = 600;
        gd_descriptionTexts.minimumHeight = 30;

        // style data for message box
        gd_MessageBox = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);

        setTitleAndDescription();
        createAliceButton();
        createPreviousButton();
        createNextButton();
        createBobButton();
        createMainComposite();
        createAliceComposite();
        createBobComposite();
        showAliceView();


        this.signalEncryptionDoubleRatchetState = new SignalEncryptionDoubleRatchetState(this);

    }

    private void setTitleAndDescription() {

        titleAndDescription = new TitleAndDescriptionComposite(this);
        titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
        titleAndDescription.setTitle(Messages.SignalEncryption_TabTitle2);
        titleAndDescription.setDescription(Messages.SignalEncryption_TabDesc2);
    }

    private void createMainComposite() {

        cmp_main = new Composite(this, SWT.NONE);
        cmp_main.setLayout(new StackLayout());
        cmp_main.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 14, 1));

    }

    private void createAliceButton() {

        btn_alice = new Button(this, SWT.LEFT);
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
        btn_bob = new Button(this, SWT.RIGHT);
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
        btn_previous = new Button(this, SWT.PUSH);
        btn_previous.setAlignment(SWT.CENTER);
        gd_btnPrev = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
        gd_btnPrev.widthHint = 150;
        btn_previous.setLayoutData(gd_btnPrev);
        btn_previous.setText("Previous");
        btn_previous.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {

                signalEncryptionDoubleRatchetState.stepBack(instance, signalEncryptionDoubleRatchetState);
            }
        });
    }

    private void createNextButton() {
        btn_next = new Button(this, SWT.PUSH);
        btn_next.setAlignment(SWT.CENTER);
        gd_btnNext = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_btnNext.widthHint = 150;
        btn_next.setLayoutData(gd_btnNext);
        btn_next.setText("Next");
        btn_next.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                signalEncryptionDoubleRatchetState.stepForward(instance, signalEncryptionDoubleRatchetState);
                System.out.println(signalEncryptionDoubleRatchetState.getCurrentState().toString());
            }
        });

    }

    private void showBobView() {
        StackLayout layout = (StackLayout) this.cmp_main.getLayout();
        layout.topControl = this.cmp_bob;
        this.cmp_main.layout();

    }

    private void showAliceView() {
        StackLayout layout = (StackLayout) this.cmp_main.getLayout();
        layout.topControl = this.cmp_alice;
        this.cmp_main.layout();

    }

    private void createBobComposite() {

        // Init of the layouts and data needed
        cmp_bob = new Composite(cmp_main, SWT.NONE);

        // Parent groups for algorithm and steps composites
        grp_bobSteps = new Group(cmp_bob, SWT.CENTER);
        grp_bobAlgorithm = new Group(cmp_bob, SWT.CENTER);

        // Parent composite for chain groups
        cmp_bobSteps = new Composite(grp_bobSteps, SWT.CENTER);
        cmp_bobAlgorithm = new Composite(grp_bobAlgorithm, SWT.CENTER);

        // Parent groups for chain composites
        grp_bobSendingChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobReceivingChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobRootChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobDiffieHellman = new Group(cmp_bobAlgorithm, SWT.CENTER);

        // Composites for chain labels
        cmp_bobSendingChain = new Composite(grp_bobSendingChain, SWT.CENTER | SWT.BORDER);
        cmp_bobReceivingChain = new Composite(grp_bobReceivingChain, SWT.CENTER | SWT.BORDER);
        cmp_bobRootChain = new Composite(grp_bobRootChain, SWT.CENTER | SWT.BORDER);
        cmp_bobDiffieHellman = new Composite(grp_bobDiffieHellman, SWT.CENTER | SWT.BORDER);

        // Composite for Message Box
        cmp_bobMessageBox = new Composite(grp_bobSendingChain, SWT.CENTER | SWT.BORDER);

        gl_bobComposite = new GridLayout(1, true);

        gl_bobAlgorithmGroup = new GridLayout(1, false);
        gl_bobStepsGroup = new GridLayout(1, false);
        gl_bobDiffieHellmanGroup = new GridLayout(1, false);
        gl_bobRootChainGroup = new GridLayout(1, false);
        gl_bobSendingChainGroup = new GridLayout(1, false);
        gl_bobReceivingChainGroup = new GridLayout(1, false);

        gl_bobAlgorithmComposite = new GridLayout(4, false);
        gl_bobStepsComposite = new GridLayout(1, false);
        gl_bobDiffieHellmanComposite = new GridLayout(2, false);
        gl_bobRootChainComposite = new GridLayout(2, false);
        gl_bobSendingChainComposite = new GridLayout(4, false);
        gl_bobReceivingChainComposite = new GridLayout(5, false);
        gl_bobMessageBoxComposite = new GridLayout(1, false);

        gd_bobAlgorithmComposite = new GridData(SWT.FILL, SWT.BOTTOM, true, true, 1, 1);
        gd_bobStepsComposite = new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1);
        gd_bobDiffieHellmanComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_bobRootChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_bobSendingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_bobReceivingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);

        cmp_bob.setLayout(gl_bobComposite);

        grp_bobSteps.setText(stepGroupDescription);
        grp_bobSteps.setLayout(gl_bobStepsComposite);
        grp_bobSteps.setLayoutData(gd_bobStepsComposite);

        cmp_bobSteps.setLayout(gl_bobStepsComposite);
        cmp_bobSteps.setLayoutData(gd_bobStepsComposite);

        grp_bobAlgorithm.setText(bobAlgorithmGroupDescription);
        grp_bobAlgorithm.setLayout(gl_bobAlgorithmComposite);
        grp_bobAlgorithm.setLayoutData(gd_bobAlgorithmComposite);

        cmp_bobAlgorithm.setLayout(gl_bobAlgorithmComposite);
        cmp_bobAlgorithm.setLayoutData(gd_bobAlgorithmComposite);

        createBobSendingChain();
        createBobReceivingChain();
        createBobRootChain();
        createBobDiffieHellmanChain();
        createBobMessageBox();
        createBobSteps();

    }

    private void createBobMessageBox() {

        cmp_bobMessageBox.setLayout(gl_bobMessageBoxComposite);
        cmp_bobMessageBox.setLayoutData(new GridData());

        txt_bobCipherText = new Text(cmp_bobMessageBox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_bobCipherText.setText(MessageBoxCipherText);
        txt_bobCipherText.setLayoutData(gd_MessageBox);

        txt_bobPlainText = new Text(cmp_bobMessageBox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_bobPlainText.setText(MessageBoxPlainText);
        txt_bobPlainText.setLayoutData(gd_MessageBox);
        
        

    }

    private void createBobSteps() {
        // step description
        txt_bobStep0 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_bobStep0.setText(bobStep0);
        txt_bobStep0.setLayoutData(gd_descriptionTexts);
        txt_bobStep5 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_bobStep5.setText(bobStep5);
        txt_bobStep5.setLayoutData(gd_descriptionTexts);
        txt_step6 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_step6.setText(step6);
        txt_step6.setLayoutData(gd_descriptionTexts);
        txt_step7 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_step7.setText(step7);
        txt_step7.setLayoutData(gd_descriptionTexts);
        txt_step8 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_step8.setText(step8);
        txt_step8.setLayoutData(gd_descriptionTexts);
        txt_step9 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_step9.setText(step9);
        txt_step9.setLayoutData(gd_descriptionTexts);
    }

    private void createBobSendingChain() {
        // Sending Chain
        grp_bobSendingChain.setLayout(new StackLayout());
        grp_bobSendingChain.setLayoutData(gd_bobSendingChainComposite);

        cmp_bobSendingChain.setLayout(gl_bobSendingChainComposite);
        cmp_bobSendingChain.setLayoutData(gd_bobSendingChainComposite);

        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE);

        lb_bobSendingChain1 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain1.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain1.setText(bobSendingChainLabel1);

        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE);

        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE);

        lb_bobSendingChain2 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain2.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain2.setText(bobSendingChainLabel2);

        lb_bobSendingChain3 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain3.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain3.setText(bobSendingChainLabel3);

        lb_bobSendingChain4 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain4.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain4.setText(bobSendingChainLabel4);

        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE);

        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE);

        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE);

        lb_bobSendingChain5 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain5.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain5.setText(bobSendingChainLabel5);

        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE);

    }

    private void createBobReceivingChain() {
        //
        // Receiving Chain
        //

        grp_bobReceivingChain.setText(ReceivingChainDescription);
        grp_bobReceivingChain.setLayout(gl_bobReceivingChainGroup);
        grp_bobReceivingChain.setLayoutData(gd_bobReceivingChainComposite);

        cmp_bobReceivingChain.setLayout(gl_bobReceivingChainComposite);
        cmp_bobReceivingChain.setLayoutData(gd_bobReceivingChainComposite);

        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);

        lb_bobReceivingChain1 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain1.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain1.setText(bobReceivingChainLabel1);

        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);

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
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);

        lb_bobReceivingChain2 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain2.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain2.setText(bobReceivingChainLabel2);

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

        lb_bobReceivingChain3 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain3.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain3.setText(bobReceivingChainLabel3);

        lb_bobReceivingChain4 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain4.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain4.setText(bobReceivingChainLabel4);

        // arrow left
        arr_bobReceivingChainArrow3 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow3
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobReceivingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(arr_bobReceivingChainArrow3, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        // arrow down
        arr_bobReceivingChainArrow4 = new Canvas(cmp_bobReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_bobReceivingChainArrow4
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_bobReceivingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_bobReceivingChainArrow4, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);
        new Label(cmp_bobReceivingChain, SWT.NONE);

        lb_bobReceivingChain5 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain5.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain5.setText(bobReceivingChainLabel5);

    }

    private void createBobRootChain() {
        //
        // Root Chain
        //

        grp_bobRootChain.setText(RootChainDescription);
        grp_bobRootChain.setLayout(gl_bobRootChainComposite);
        grp_bobRootChain.setLayoutData(gd_bobRootChainComposite);

        cmp_bobRootChain.setLayout(gl_bobRootChainComposite);
        cmp_bobRootChain.setLayoutData(gd_bobRootChainComposite);

        lb_bobRootChain1 = new Label(cmp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobRootChain1.setLayoutData(gd_algorithmLabels);
        lb_bobRootChain1.setText(bobRootChainLabel1);

        // empty label for filling space
        new Label(cmp_bobRootChain, SWT.NONE);

        // arrow down
        arr_bobRootChainArrow1 = new Canvas(cmp_bobRootChain, SWT.DOUBLE_BUFFERED);
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

        // empty label for filling space
        new Label(cmp_bobRootChain, SWT.NONE);

        lb_bobRootChain2 = new Label(cmp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobRootChain2.setLayoutData(gd_algorithmLabels);
        lb_bobRootChain2.setText(bobRootChainLabel2);

        // empty label for filling space
        new Label(cmp_bobRootChain, SWT.NONE);

        // arrow down
        arr_bobRootChainArrow2 = new Canvas(cmp_bobRootChain, SWT.DOUBLE_BUFFERED);
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

        // empty label for filling space
        new Label(cmp_bobRootChain, SWT.NONE);

        lb_bobRootChain3 = new Label(cmp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobRootChain3.setLayoutData(gd_algorithmLabels);
        lb_bobRootChain3.setText(bobRootChainLabel3);

    }

    private void createBobDiffieHellmanChain() {
        //
        // Diffie Hellman Chain
        //

        grp_bobDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_bobDiffieHellman.setLayout(gl_bobDiffieHellmanComposite);
        grp_bobDiffieHellman.setLayoutData(gd_bobDiffieHellmanComposite);

        cmp_bobDiffieHellman.setLayout(gl_bobDiffieHellmanComposite);
        cmp_bobDiffieHellman.setLayoutData(gd_bobDiffieHellmanComposite);

        lb_bobDiffieHellman1 = new Label(cmp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman1.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman1.setText(bobDiffieHellmanLabel1);
        lb_bobDiffieHellman1.setLayoutData(gd_algorithmLabels);

        // empty label for filling space
        new Label(cmp_bobDiffieHellman, SWT.NONE);

        // arrow down
        arr_bobDiffieHellmanArrow1 = new Canvas(cmp_bobDiffieHellman, SWT.DOUBLE_BUFFERED);
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

        // empty label for filling space
        new Label(cmp_bobDiffieHellman, SWT.NONE);

        lb_bobDiffieHellman2 = new Label(cmp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman2.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman2.setText(bobDiffieHellmanLabel2);
        lb_bobDiffieHellman2.setLayoutData(gd_algorithmLabels);

        // empty label for filling space
        new Label(cmp_bobDiffieHellman, SWT.NONE);

        // arrow up
        arr_bobDiffieHellmanArrow2 = new Canvas(cmp_bobDiffieHellman, SWT.DOUBLE_BUFFERED);
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
        // empty label for filling space
        new Label(cmp_bobDiffieHellman, SWT.NONE);

        lb_bobDiffieHellman3 = new Label(cmp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman3.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman3.setText(bobDiffieHellmanLabel3);
        lb_bobDiffieHellman3.setLayoutData(gd_algorithmLabels);

    }

    private void createAliceComposite() {

        // Init of the widgets, layouts and data needed
        cmp_alice = new Composite(cmp_main, SWT.NONE);

        // Parent groups for algorithm and steps composites
        grp_steps = new Group(cmp_alice, SWT.CENTER);
        grp_aliceAlgorithm = new Group(cmp_alice, SWT.CENTER);

        // Parent composite for chain groups
        cmp_aliceAlgorithm = new Composite(grp_aliceAlgorithm, SWT.CENTER);
        cmp_steps = new Composite(grp_steps, SWT.CENTER | SWT.FILL);

        // Parent groups for chain composites
        grp_aliceDiffieHellman = new Group(cmp_aliceAlgorithm, SWT.CENTER);       
        grp_aliceArrowSpace1 = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceRootChain = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceArrowSpace2 = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceSendingChain = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceReceivingChain = new Group(cmp_aliceAlgorithm, SWT.CENTER);

        // Composites for chain labels
        cmp_aliceDiffieHellman = new Composite(grp_aliceDiffieHellman, SWT.CENTER);
        cmp_aliceRootChain = new Composite(grp_aliceRootChain, SWT.CENTER);
        cmp_aliceSendingChain = new Composite(grp_aliceSendingChain, SWT.CENTER);
        cmp_aliceReceivingChain = new Composite(grp_aliceReceivingChain, SWT.CENTER);

        // Composite for Message Box
        cmp_aliceMessageBox = new Composite(grp_aliceReceivingChain, SWT.CENTER);

        // Layouts
        gl_aliceComposite = new GridLayout(1, false);

        gl_aliceAlgorithmGroup = new GridLayout(1, false);
        gl_stepsGroup = new GridLayout(1, false);
        gl_aliceDiffieHellmanGroup = new GridLayout(1, false);
        gl_aliceRootChainGroup = new GridLayout(1, false);
        gl_aliceSendingChainGroup = new GridLayout(1, false);
        gl_aliceReceivingChainGroup = new GridLayout(1, false);
        gl_aliceSpaceGroup = new GridLayout(1,false);

        gl_aliceAlgorithmComposite = new GridLayout(6, false);
        gl_stepsComposite = new GridLayout(1, false);
        gl_aliceDiffieHellmanComposite = new GridLayout(2, false);
        gl_aliceRootChainComposite = new GridLayout(2, false);
        gl_aliceSendingChainComposite = new GridLayout(5, false);
        gl_aliceReceivingChainComposite = new GridLayout(5, false);
        gl_aliceMessageBoxComposite = new GridLayout(1, false);

        gd_aliceAlgorithmComposite = new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1);
        gd_stepsComposite = new GridData(SWT.FILL, SWT.BOTTOM, true, true, 1, 1);
        gd_aliceDiffieHellmanComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceRootChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceSendingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceReceivingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceArrowSpaceGroup = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);

        cmp_alice.setLayout(gl_aliceComposite);

        grp_aliceAlgorithm.setText(aliceAlgorithmGroupDescription);
        grp_aliceAlgorithm.setLayout(gl_aliceAlgorithmComposite);
        grp_aliceAlgorithm.setLayoutData(gd_aliceAlgorithmComposite);

        grp_steps.setText(stepGroupDescription);
        grp_steps.setLayout(gl_stepsComposite);
        grp_steps.setLayoutData(gd_stepsComposite);

        cmp_aliceAlgorithm.setLayout(gl_aliceAlgorithmComposite);
        cmp_aliceAlgorithm.setLayoutData(gd_aliceAlgorithmComposite);

        cmp_steps.setLayout(gl_stepsComposite);
        cmp_steps.setLayoutData(gd_stepsComposite);

        createAliceSteps();
        
        createAliceDiffieHellmanChain();

        createAliceRootChain();

        createAliceSendingChain();

        createAliceReceivingChain();

        createAliceMessageBox();
        createAliceArrows();

    }

    private void createAliceArrows() {
        
        grp_aliceArrowSpace1.setLayout(gl_aliceSpaceGroup);
        grp_aliceArrowSpace1.setLayoutData(gd_aliceArrowSpaceGroup);
        
        // arrow up
        arr_aliceSpace1 = new Canvas(grp_aliceArrowSpace1, SWT.DOUBLE_BUFFERED);
        arr_aliceSpace1
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, true, 1, 1,75));
        arr_aliceSpace1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightUpRightArrow(arr_aliceSpace1, 5, 10,180);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        new Label(grp_aliceArrowSpace1,SWT.NONE);
        new Label(grp_aliceArrowSpace1,SWT.NONE);
        new Label(grp_aliceArrowSpace1,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace1,SWT.NONE);
        new Label(grp_aliceArrowSpace1,SWT.NONE);
        new Label(grp_aliceArrowSpace1,SWT.NONE);
        new Label(grp_aliceArrowSpace1,SWT.NONE);
        new Label(grp_aliceArrowSpace1,SWT.NONE);
        new Label(grp_aliceArrowSpace1,SWT.NONE);
        
        grp_aliceArrowSpace2.setLayout(gl_aliceSpaceGroup);
        grp_aliceArrowSpace2.setLayoutData(gd_aliceArrowSpaceGroup);
        
        // arrow up
        arr_aliceSpace2 = new Canvas(grp_aliceArrowSpace2, SWT.DOUBLE_BUFFERED);
        arr_aliceSpace2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, true, 1, 1,75));
        arr_aliceSpace2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightUpRightArrowHeadless(arr_aliceSpace2, 5, 10,208);
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        new Label(grp_aliceArrowSpace2,SWT.NONE);
        
        
        
    }

    private void createAliceSteps() {
        // step description

        txt_aliceStep0 = new Text(cmp_steps, SWT.WRAP | SWT.MULTI);
        txt_aliceStep0.setText(aliceStep0);
        txt_aliceStep0.setLayoutData(gd_descriptionTexts);
        txt_step1 = new Text(cmp_steps, SWT.WRAP | SWT.MULTI | SWT.READ_ONLY);
        txt_step1.setText(step1);
        txt_step1.setLayoutData(gd_descriptionTexts);
        txt_step2 = new Text(cmp_steps, SWT.NONE | SWT.WRAP | SWT.MULTI);
        txt_step2.setText(step2);
        txt_step2.setLayoutData(gd_descriptionTexts);
        txt_step3 = new Text(cmp_steps, SWT.NONE | SWT.WRAP | SWT.MULTI);
        txt_step3.setText(step3);
        txt_step3.setLayoutData(gd_descriptionTexts);
        txt_step4 = new Text(cmp_steps, SWT.NONE | SWT.WRAP | SWT.MULTI);
        txt_step4.setText(step4);
        txt_step4.setLayoutData(gd_descriptionTexts);
        txt_aliceStep5 = new Text(cmp_steps, SWT.NONE | SWT.WRAP | SWT.MULTI);
        txt_aliceStep5.setText(aliceStep5);
        txt_aliceStep5.setLayoutData(gd_descriptionTexts);
    }

    private void createAliceDiffieHellmanChain() {
        //
        // DH Chain
        //
        grp_aliceDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_aliceDiffieHellman.setLayout(gl_aliceDiffieHellmanComposite);
        grp_aliceDiffieHellman.setLayoutData(gd_aliceDiffieHellmanComposite);

        cmp_aliceDiffieHellman.setLayout(gl_aliceDiffieHellmanComposite);
        cmp_aliceDiffieHellman.setLayoutData(gd_aliceDiffieHellmanComposite);

        lb_aliceDiffieHellman1 = new Label(cmp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman1.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman1.setText(aliceDiffieHellmanLabel1);

        // empty label for filling space
        new Label(cmp_aliceDiffieHellman, SWT.NONE);

        // arrow down
        arr_aliceDiffieHellmanArrow1 = new Canvas(cmp_aliceDiffieHellman, SWT.DOUBLE_BUFFERED);
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

        // empty label for filling space
        new Label(cmp_aliceDiffieHellman, SWT.NONE);

        lb_aliceDiffieHellman2 = new Label(cmp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman2.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman2.setText(aliceDiffieHellmanLabel2);

        // empty label for filling space
        new Label(cmp_aliceDiffieHellman, SWT.NONE);

        // arrow up
        arr_aliceDiffieHellmanArrow2 = new Canvas(cmp_aliceDiffieHellman, SWT.DOUBLE_BUFFERED);
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
        // empty label for filling space
        new Label(cmp_aliceDiffieHellman, SWT.NONE);

        lb_aliceDiffieHellman3 = new Label(cmp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman3.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman3.setText(aliceDiffieHellmanLabel3);
     

    }

    private void createAliceRootChain() {
        //
        // Root Chain
        //
        grp_aliceRootChain.setText(RootChainDescription);
        grp_aliceRootChain.setLayout(gl_aliceRootChainComposite);
        grp_aliceRootChain.setLayoutData(gd_aliceRootChainComposite);

        cmp_aliceRootChain.setLayout(gl_aliceRootChainComposite);
        cmp_aliceRootChain.setLayoutData(gd_aliceRootChainComposite);

        lb_aliceRootChain1 = new Label(cmp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceRootChain1.setLayoutData(gd_algorithmLabels);
        lb_aliceRootChain1.setText(aliceRootChainLabel1);

        // empty label for filling space
        new Label(cmp_aliceRootChain, SWT.NONE);

        // arrow down
        arr_aliceRootChainArrow1 = new Canvas(cmp_aliceRootChain, SWT.DOUBLE_BUFFERED);
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

        // empty label for filling space
        new Label(cmp_aliceRootChain, SWT.NONE);

        lb_aliceRootChain2 = new Label(cmp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceRootChain2.setLayoutData(gd_algorithmLabels);
        lb_aliceRootChain2.setText(aliceRootChainLabel2);

        // empty label for filling space
        new Label(cmp_aliceRootChain, SWT.NONE);

        // arrow down
        arr_aliceRootChainArrow2 = new Canvas(cmp_aliceRootChain, SWT.DOUBLE_BUFFERED);
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

        // empty label for filling space
        new Label(cmp_aliceRootChain, SWT.NONE);

        lb_aliceRootChain3 = new Label(cmp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceRootChain3.setLayoutData(gd_algorithmLabels);
        lb_aliceRootChain3.setText(aliceRootChainLabel3);

    }

    private void createAliceReceivingChain() {
        // Receiving Chain
        grp_aliceReceivingChain.setLayout(new StackLayout());
        grp_aliceReceivingChain.setLayoutData(gd_aliceReceivingChainComposite);

        cmp_aliceReceivingChain.setLayout(gl_aliceReceivingChainComposite);
        cmp_aliceReceivingChain.setLayoutData(gd_aliceReceivingChainComposite);

        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        new Label(cmp_aliceReceivingChain, SWT.NONE);

        lb_aliceReceivingChain1 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain1.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain1.setText(aliceReceivingChainLabel1);

        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        new Label(cmp_aliceReceivingChain, SWT.NONE);

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
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        new Label(cmp_aliceReceivingChain, SWT.NONE);

        lb_aliceReceivingChain2 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain2.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain2.setText(aliceReceivingChainLabel2);

        // arrow right
        arr_aliceReceivingChainArrow2 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow2
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceReceivingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawLeftArrow(arr_aliceReceivingChainArrow2, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        lb_aliceReceivingChain3 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain3.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain3.setText(aliceReceivingChainLabel3);

        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        new Label(cmp_aliceReceivingChain, SWT.NONE);

        // arrow down
        arr_aliceReceivingChainArrow3 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow3
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceReceivingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawDownArrow(arr_aliceReceivingChainArrow3, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        // arrow right
        arr_aliceReceivingChainArrow4 = new Canvas(cmp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow4
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
        arr_aliceReceivingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(arr_aliceReceivingChainArrow4, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        lb_aliceReceivingChain4 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain4.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain4.setText(aliceReceivingChainLabel4);

        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        new Label(cmp_aliceReceivingChain, SWT.NONE);

        lb_aliceReceivingChain5 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain5.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain5.setText(aliceReceivingChainLabel5);

    }

    private void createAliceMessageBox() {

        cmp_aliceMessageBox.setLayout(gl_aliceMessageBoxComposite);
        cmp_aliceMessageBox.setLayoutData(new GridData());

        txt_alicePlainText = new Text(cmp_aliceMessageBox, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        txt_alicePlainText.setText(MessageBoxPlainText);
        txt_alicePlainText.setLayoutData(gd_MessageBox);

        txt_aliceCipherText.setLayoutData(gd_MessageBox);
        txt_aliceCipherText = new Text(cmp_aliceMessageBox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        
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
        //
        // Sending Chain
        //
        grp_aliceSendingChain.setText(SendingChainDescription);
        grp_aliceSendingChain.setLayout(gl_aliceSendingChainComposite);
        grp_aliceSendingChain.setLayoutData(gd_aliceSendingChainComposite);

        cmp_aliceSendingChain.setLayout(gl_aliceSendingChainComposite);
        cmp_aliceSendingChain.setLayoutData(gd_aliceSendingChainComposite);

//        // empty label for filling space
//        new Label(cmp_aliceSendingChain, SWT.NONE);
//        new Label(cmp_aliceSendingChain, SWT.NONE);
        
//        // arrow down
//        arr_aliceSendingChainArrow5 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
//        arr_aliceSendingChainArrow5
//                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
//        arr_aliceSendingChainArrow5.addPaintListener(new PaintListener() {
//            @Override
//            public void paintControl(PaintEvent event) {
//                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
//                Path path = SignalEncryptionArrows.drawHorizontalLine(arr_aliceSendingChainArrow5, 5, 10, 50);
//                event.gc.fillPath(path);
//                path.dispose();
//            }
//        });
        
        // arrow down
        arr_aliceSendingChainArrow6 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow6
                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 2, 1, 75));
        arr_aliceSendingChainArrow6.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = SignalEncryptionArrows.drawRightArrow(arr_aliceSendingChainArrow6, 5, 10);
                event.gc.fillPath(path);
                path.dispose();
            }
        });


        lb_aliceSendingChain1 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain1.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain1.setText(aliceSendingChainLabel1);

        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE);
        new Label(cmp_aliceSendingChain, SWT.NONE);
        new Label(cmp_aliceSendingChain, SWT.NONE);
        new Label(cmp_aliceSendingChain, SWT.NONE);

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
        new Label(cmp_aliceSendingChain, SWT.NONE);
        new Label(cmp_aliceSendingChain, SWT.NONE);

        lb_aliceSendingChain2 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain2.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain2.setText(aliceSendingChainLabel2);

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

        lb_aliceSendingChain3 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain3.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain3.setText(aliceSendingChainLabel3);

        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE);
        new Label(cmp_aliceSendingChain, SWT.NONE);
        new Label(cmp_aliceSendingChain, SWT.NONE);
        new Label(cmp_aliceSendingChain, SWT.NONE);

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

//        // arrow right
//        arr_aliceSendingChainArrow4 = new Canvas(cmp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
//        arr_aliceSendingChainArrow4
//                .setLayoutData(SignalEncryptionArrows.canvasData(SWT.FILL, SWT.FILL, false, false, 1, 1, 75));
//        arr_aliceSendingChainArrow4.addPaintListener(new PaintListener() {
//            @Override
//            public void paintControl(PaintEvent event) {
//                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
//                Path path = SignalEncryptionArrows.drawRightArrow(arr_aliceSendingChainArrow4, 5, 10);
//                event.gc.fillPath(path);
//                path.dispose();
//            }
//        });

        lb_aliceSendingChain4 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain4.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain4.setText(aliceSendingChainLabel4);

        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE);
        new Label(cmp_aliceSendingChain, SWT.NONE);

        lb_aliceSendingChain5 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain5.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain5.setText(aliceSendingChainLabel5);

    }

    void showAliceReceivingChain() {
        StackLayout layout = (StackLayout) this.grp_aliceReceivingChain.getLayout();
        grp_aliceReceivingChain.setText(ReceivingChainDescription);
        layout.topControl = this.cmp_aliceReceivingChain;
        this.grp_aliceReceivingChain.layout();

    }

    void showBobSendingChain() {
        StackLayout layout = (StackLayout) this.grp_bobSendingChain.getLayout();
        grp_bobSendingChain.setText(SendingChainDescription);
        layout.topControl = this.cmp_bobSendingChain;
        this.grp_bobSendingChain.layout();

    }

    void showAliceMessageBox() {
        StackLayout layout = (StackLayout) this.grp_aliceReceivingChain.getLayout();
        grp_aliceReceivingChain.setText(MessageBoxDescription);
        layout.topControl = this.cmp_aliceMessageBox;
        this.grp_aliceReceivingChain.layout();

    }

    void showBobMessageBox() {
        StackLayout layout = (StackLayout) this.grp_bobSendingChain.getLayout();
        grp_bobSendingChain.setText(MessageBoxDescription);
        layout.topControl = this.cmp_bobMessageBox;
        this.grp_bobSendingChain.layout();

    }
    public void resetAll() {
        signalEncryptionDoubleRatchetState.reset(this);
    }


}
