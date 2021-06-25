package org.jcryptool.visual.signalencryption.ui;

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionState.STATE;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Label;
<<<<<<< HEAD
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
// import org.jcryptool.visual.signalencryption.ui.SignalEncryptionDoubleRatchetState.STATE;
=======
import org.eclipse.swt.widgets.Text;
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11

/**
 * 
 * @author Dan-Kerko Ciudin
 * 
 * 
 */

public class SignalEncryptionViewDoubleRatchet extends Composite {

    private TitleAndDescriptionComposite titleAndDescription;

<<<<<<< HEAD
    Composite cmp_main;
    Composite cmp_alice;
    Composite cmp_bob;

    Button btn_alice;
    Button btn_bob;
    Button btn_next;
    Button btn_previous;

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
=======
    private Composite cmp_main;
    private Composite cmp_alice;
    private Composite cmp_bob;

    private Button btn_alice;
    private Button btn_bob;
    private Button btn_next;
    private Button btn_previous;

    private Group grp_aliceSteps;
    private Group grp_aliceAlgorithm;
    private Group grp_bobSteps;
    private Group grp_bobAlgorithm;
    private Group grp_bobSendingChain;
    private Group grp_bobReceivingChain;
    private Group grp_bobRootChain;
    private Group grp_bobDiffieHellman;
    private Group grp_aliceDiffieHellman;
    private Group grp_aliceRootChain;
    private Group grp_aliceSendingChain;
    private Group grp_aliceReceivingChain;
    
    private Composite cmp_bobAlgorithm;
    private Composite cmp_bobSteps;
    private Composite cmp_aliceDiffieHellman;
    private Composite cmp_aliceRootChain;
    private Composite cmp_aliceReceivingChain;
    private Composite cmp_aliceSendingChain;
    private Composite cmp_bobDiffieHellman;
    private Composite cmp_bobSendingChain;
    private Composite cmp_bobReceivingChain;
    private Composite cmp_bobRootChain;
    private Composite cmp_aliceAlgorithm;
    private Composite cmp_aliceSteps;

    private String AlgorithmGroupDescription = Messages.SignalEncryption_AlgorithmGroupDescription;
    private String stepGroupDescription = Messages.SignalEncryption_stepGroupDescription;
    private String DiffieHellmanGroupDescription = Messages.SignalEncryption_DiffieHellmanGroupDescription;
    private String RootChainDescription = Messages.SignalEncryption_RootChainDescription;
    private String SendingChainDescription = Messages.SignalEncryption_SendingChainDescription;
    private String ReceivingChainDescription = Messages.SignalEncryption_ReceivingChainDescription;

    private GridLayout gl_parent;
    private GridLayout gl_aliceDiffieHellmanComposite;
    private GridLayout gl_aliceComposite;
    private GridLayout gl_bobComposite;
    private GridLayout gl_aliceAlgorithmComposite;
    private GridLayout gl_aliceRootChainComposite;
    private GridLayout gl_aliceSendingChainComposite;
    private GridLayout gl_aliceReceivingChainComposite;
    private GridLayout gl_bobAlgorithmComposite;
    private GridLayout gl_bobRootChainComposite;
    private GridLayout gl_bobReceivingChainComposite;
    private GridLayout gl_bobDiffieHellmanComposite;
    private GridLayout gl_bobSendingChainComposite;
    private GridLayout gl_aliceStepsComposite;
    private GridLayout gl_bobStepsComposite;
    private GridLayout gl_bobAlgorithmGroup;
    private GridLayout gl_bobStepsGroup;
    private GridLayout gl_bobDiffieHellmanGroup;
    private GridLayout gl_bobRootChainGroup;
    private GridLayout gl_bobSendingChainGroup;
    private GridLayout gl_bobReceivingChainGroup;
    private GridLayout gl_aliceAlgorithmGroup;
    private GridLayout gl_aliceStepsGroup;
    private GridLayout gl_aliceDiffieHellmanGroup;
    private GridLayout gl_aliceRootChainGroup;
    private GridLayout gl_aliceSendingChainGroup;
    private GridLayout gl_aliceReceivingChainGroup;

    private GridData gd_aliceAlgorithmComposite;
    private GridData gd_aliceStepsComposite;

    private GridData gd_bobAlgorithmComposite;
    private GridData gd_bobStepsComposite;
    private GridData gd_btnAlice;
    private GridData gd_btnBob; 
    private GridData gd_btnNext;
    private GridData gd_btnPrev;
    private GridData gd_aliceDiffieHellmanComposite;
    private GridData gd_aliceRootChainComposite;
    private GridData gd_aliceSendingChainComposite;
    private GridData gd_aliceReceivingChainComposite;
    private GridData gd_algorithmLabels;
    private GridData gd_descriptionTexts;
    private GridData gd_bobDiffieHellmanComposite;
    private GridData gd_bobRootChainComposite;
    private GridData gd_bobSendingChainComposite;
    private GridData gd_bobReceivingChainComposite;
    private GridData gd_bobAlgorithmGroup;
    private GridData gd_bobStepsGroup;
    private GridData gd_bobDiffieHellmanGroup;
    private GridData gd_bobRootChainGroupe;
    private GridData gd_bobSendingChainGroup;
    private GridData gd_bobReceivingChainGroup;
<<<<<<< HEAD
    
    private STATE currentState = STATE.STEP_0;
=======
>>>>>>> c9b4c7de1aa72188fcfa5e89afb35d5d0c51c91b

    private Label lb_aliceDiffieHellman1;
    private Label lb_aliceDiffieHellman2;
    private Label lb_aliceDiffieHellman3;
    private Label lb_bobDiffieHellman1;
    private Label lb_bobDiffieHellman2;
    private Label lb_bobDiffieHellman3;
    private Label lb_aliceRootChain1;
    private Label lb_aliceRootChain2;
    private Label lb_aliceRootChain3;
    private Label lb_aliceSendingChain1;
    private Label lb_aliceSendingChain2;
    private Label lb_aliceSendingChain3;
    private Label lb_aliceSendingChain4;
    private Label lb_aliceSendingChain5;
    private Label lb_aliceReceivingChain1;
    private Label lb_aliceReceivingChain2;
    private Label lb_aliceReceivingChain3;
    private Label lb_aliceReceivingChain4;
    private Label lb_aliceReceivingChain5;
    private Label lb_bobRootChain1;
    private Label lb_bobRootChain2;
    private Label lb_bobRootChain3;
    private Label lb_bobSendingChain1;
    private Label lb_bobSendingChain2;
    private Label lb_bobSendingChain3;
    private Label lb_bobSendingChain4;
    private Label lb_bobSendingChain5;
    private Label lb_bobReceivingChain1;
    private Label lb_bobReceivingChain2;
    private Label lb_bobReceivingChain3;
    private Label lb_bobReceivingChain4;
    private Label lb_bobReceivingChain5;
    
    private Text txt_aliceStep1;
    private Text txt_aliceStep2;
    private Text txt_aliceStep3;
    private Text txt_aliceStep4;
    private Text txt_aliceStep5;
    private Text txt_aliceStep0;
    private Text txt_bobStep1;
    private Text txt_bobStep2;
    private Text txt_bobStep3;
    private Text txt_bobStep4;
    private Text txt_bobStep5;
    private Text txt_bobStep0;
    
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11

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
<<<<<<< HEAD

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

    SignalEncryptionDoubleRatchetState signalEncryptionDoubleRatchetState;

    private Canvas arr_aliceDiffieHellmanArrow1;

    private Canvas arrowCanvas;

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

    SignalEncryptionViewDoubleRatchet(Composite parent, int style,
            SignalEncryptionAlgorithmState signalEncryptionState) {
        super(parent, style);

        this.signalEncryptionState = signalEncryptionState;
        this.signalEncryptionAlgorithm = signalEncryptionState.getSignalEncryptionAlgorithm();
        this.instance = this;
        gl_parent = new GridLayout(4, false);
=======
    private String aliceStep1 = Messages.SignalEncryption_aliceDescriptionText1;
    private String aliceStep2 = Messages.SignalEncryption_aliceDescriptionText2;
    private String aliceStep3 = Messages.SignalEncryption_aliceDescriptionText3;
    private String aliceStep4 = Messages.SignalEncryption_aliceDescriptionText4;
    private String aliceStep5 = Messages.SignalEncryption_aliceDescriptionText5;
    private String aliceStep0 = Messages.SignalEncryption_aliceDescriptionText0;
    private String bobStep1 = Messages.SignalEncryption_bobDescriptionText1;
    private String bobStep2 = Messages.SignalEncryption_bobDescriptionText2;
    private String bobStep3 = Messages.SignalEncryption_bobDescriptionText3;
    private String bobStep4 = Messages.SignalEncryption_bobDescriptionText4;
    private String bobStep5 = Messages.SignalEncryption_bobDescriptionText5;
    private String bobStep0 = Messages.SignalEncryption_bobDescriptionText0;
<<<<<<< HEAD
=======
    private String title = Messages.SignalEncryption_TabTitle2;
    private String description = Messages.SignalEncryption_TabDesc2;
>>>>>>> c9b4c7de1aa72188fcfa5e89afb35d5d0c51c91b
    
    private int currentState = 0;

    private SignalEncryptionAlgorithm signalEncryptionAlgorithm;
    private SignalEncryptionState signalEncryptionState;
    
    private SignalEncryptionViewDoubleRatchet instance;
    


    SignalEncryptionViewDoubleRatchet(Composite parent, int style, SignalEncryptionState signalEncryptionState) {
        super(parent, style);
        
        this.signalEncryptionState= signalEncryptionState;
        this.signalEncryptionAlgorithm = signalEncryptionState.getSignalEncryptionAlgorithm();
        this.instance = this;
        gl_parent = new GridLayout(2, false);
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        gl_parent.horizontalSpacing = 3;
        gl_parent.verticalSpacing = 0;
        setLayout(gl_parent);

        // style data for the labels within the algorithm
        gd_algorithmLabels = new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1);
        gd_algorithmLabels.verticalIndent = 40;
        gd_algorithmLabels.horizontalIndent = 10;
        gd_algorithmLabels.widthHint = 150;
<<<<<<< HEAD
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
=======
        gd_algorithmLabels.heightHint = 70;
        
        // style data for the description texts
        gd_descriptionTexts = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
        gd_descriptionTexts.minimumWidth = 600;
        

        setTitleAndDescription();
        createAliceButton();
        createBobButton();
        createPreviousButton();
        createNextButton();
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        createMainComposite();
        createAliceComposite();
        createBobComposite();
        showAliceView();
<<<<<<< HEAD
        this.signalEncryptionDoubleRatchetState = new SignalEncryptionDoubleRatchetState(this);

    }

    private void setTitleAndDescription() {

        titleAndDescription = new TitleAndDescriptionComposite(this);
        titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
        titleAndDescription.setTitle(Messages.SignalEncryption_TabTitle2);
        titleAndDescription.setDescription(Messages.SignalEncryption_TabDesc2);
=======
<<<<<<< HEAD
=======
        switchState(currentState);
>>>>>>> c9b4c7de1aa72188fcfa5e89afb35d5d0c51c91b

        currentState = STATE.STEP_0.setInitialState(this);

    }

    /*
     * 
     */
    private void switchState(int state) {
        
        if(state >4) {
            return;
        }
        grp_bobSteps.setVisible(false);
        grp_bobAlgorithm.setVisible(false);
        grp_bobSendingChain.setVisible(false);
        grp_bobReceivingChain.setVisible(false);
        grp_bobRootChain.setVisible(false);
        grp_bobDiffieHellman.setVisible(false);
        lb_bobSendingChain1.setVisible(false);
        lb_bobSendingChain2.setVisible(false);
        lb_bobSendingChain3.setVisible(false);
        lb_bobSendingChain4.setVisible(false);
        lb_bobSendingChain5.setVisible(false);
        lb_bobReceivingChain1.setVisible(false);
        lb_bobReceivingChain2.setVisible(false);
        lb_bobReceivingChain3.setVisible(false);
        lb_bobReceivingChain4.setVisible(false);
        lb_bobReceivingChain5.setVisible(false);
        lb_bobRootChain1.setVisible(false);
        lb_bobRootChain2.setVisible(false);
        lb_bobRootChain3.setVisible(false);
        lb_bobDiffieHellman1.setVisible(false);
        lb_bobDiffieHellman2.setVisible(false);
        lb_bobDiffieHellman3.setVisible(false);
        grp_aliceAlgorithm.setVisible(false);
        grp_aliceSteps.setVisible(false);
        grp_aliceDiffieHellman.setVisible(false);
        grp_aliceRootChain.setVisible(false);
        grp_aliceSendingChain.setVisible(false);
        grp_aliceReceivingChain.setVisible(false);
        lb_aliceDiffieHellman1.setVisible(false);
        lb_aliceDiffieHellman2.setVisible(false);
        lb_aliceDiffieHellman3.setVisible(false);
        lb_aliceRootChain1.setVisible(false);
        lb_aliceRootChain2.setVisible(false);
        lb_aliceRootChain3.setVisible(false);
        lb_aliceSendingChain1.setVisible(false);
        lb_aliceSendingChain2.setVisible(false);
        lb_aliceSendingChain3.setVisible(false);
        lb_aliceSendingChain4.setVisible(false);
        lb_aliceSendingChain5.setVisible(false);
        lb_aliceReceivingChain1.setVisible(false);
        lb_aliceReceivingChain2.setVisible(false);
        lb_aliceReceivingChain3.setVisible(false);
        lb_aliceReceivingChain4.setVisible(false);
        lb_aliceReceivingChain5.setVisible(false);
        txt_aliceStep1.setVisible(false);
        txt_aliceStep2.setVisible(false);
        txt_aliceStep3.setVisible(false);
        txt_aliceStep4.setVisible(false);
        txt_aliceStep5.setVisible(false);
        txt_aliceStep0.setVisible(false);
        txt_bobStep1.setVisible(false);
        txt_bobStep2.setVisible(false);
        txt_bobStep3.setVisible(false);
        txt_bobStep4.setVisible(false);
        txt_bobStep5.setVisible(false);
        txt_bobStep0.setVisible(false);
        
        
        switch(state) {
        
        case 0: 
                    grp_aliceSteps.setVisible(true);
                    grp_bobSteps.setVisible(true);
                    break;
                
        case 1:     grp_aliceAlgorithm.setVisible(true);
                    grp_aliceSteps.setVisible(true);
                    grp_bobAlgorithm.setVisible(true);
                    grp_bobSteps.setVisible(true);
                    grp_aliceDiffieHellman.setVisible(true);
                    grp_bobDiffieHellman.setVisible(true);
                    grp_aliceRootChain.setVisible(true);
                    grp_bobRootChain.setVisible(true);
                    
                    lb_aliceDiffieHellman2.setVisible(true);
                    lb_aliceRootChain1.setVisible(true);
                    lb_aliceRootChain2.setVisible(true);
                    lb_aliceRootChain3.setVisible(true);
                    lb_bobDiffieHellman2.setVisible(true);
                    lb_bobRootChain1.setVisible(true);
                    lb_bobRootChain2.setVisible(true);
                    lb_bobRootChain3.setVisible(true);
                    
                    txt_aliceStep0.setVisible(true);
                    txt_bobStep0.setVisible(true);
                    txt_aliceStep1.setVisible(true);
                    txt_bobStep1.setVisible(true);
                    break;
                    
        case 2:     grp_aliceAlgorithm.setVisible(true);
                    grp_aliceSteps.setVisible(true);
                    grp_aliceDiffieHellman.setVisible(true);
                    grp_aliceRootChain.setVisible(true);
                    grp_aliceSendingChain.setVisible(true);
                    
                    grp_bobAlgorithm.setVisible(true);
                    grp_bobSteps.setVisible(true);
                    grp_bobDiffieHellman.setVisible(true);
                    grp_bobRootChain.setVisible(true);
                    grp_bobReceivingChain.setVisible(true);
                    
                    lb_aliceDiffieHellman2.setVisible(true);
                    lb_aliceRootChain1.setVisible(true);
                    lb_aliceRootChain2.setVisible(true);
                    lb_aliceRootChain3.setVisible(true);
                    lb_aliceSendingChain1.setVisible(true);
                    lb_aliceSendingChain2.setVisible(true);
                    lb_aliceSendingChain3.setVisible(true);
                    lb_aliceSendingChain4.setVisible(true);
                    lb_aliceSendingChain5.setVisible(true);
                    
                    lb_bobDiffieHellman2.setVisible(true);
                    lb_bobRootChain1.setVisible(true);
                    lb_bobRootChain2.setVisible(true);
                    lb_bobRootChain3.setVisible(true);
                    lb_bobReceivingChain1.setVisible(true);
                    lb_bobReceivingChain2.setVisible(true);
                    lb_bobReceivingChain3.setVisible(true);
                    lb_bobReceivingChain4.setVisible(true);
                    lb_bobReceivingChain5.setVisible(true);
                    
                    txt_aliceStep0.setVisible(true);
                    txt_bobStep0.setVisible(true);
                    txt_aliceStep1.setVisible(true);
                    txt_bobStep1.setVisible(true);
                    txt_aliceStep2.setVisible(true);
                    txt_bobStep2.setVisible(true);
                    
                    break;
                    
        case 3:     grp_aliceAlgorithm.setVisible(true);
                    grp_aliceSteps.setVisible(true);
                    grp_aliceDiffieHellman.setVisible(true);
                    grp_aliceRootChain.setVisible(true);
                    grp_aliceSendingChain.setVisible(true);
                    
                    grp_bobAlgorithm.setVisible(true);
                    grp_bobSteps.setVisible(true);
                    grp_bobDiffieHellman.setVisible(true);
                    grp_bobRootChain.setVisible(true);
                    grp_bobReceivingChain.setVisible(true);
                    
                    lb_aliceDiffieHellman2.setVisible(true);
                    lb_aliceRootChain1.setVisible(true);
                    lb_aliceRootChain2.setVisible(true);
                    lb_aliceRootChain3.setVisible(true);
                    lb_aliceSendingChain1.setVisible(true);
                    lb_aliceSendingChain2.setVisible(true);
                    lb_aliceSendingChain3.setVisible(true);
                    lb_aliceSendingChain4.setVisible(true);
                    lb_aliceSendingChain5.setVisible(true);
                    lb_aliceDiffieHellman1.setVisible(true);
                    lb_aliceDiffieHellman2.setVisible(true);
                    lb_aliceDiffieHellman3.setVisible(true);
                    
                    lb_bobDiffieHellman2.setVisible(true);
                    lb_bobRootChain1.setVisible(true);
                    lb_bobRootChain2.setVisible(true);
                    lb_bobRootChain3.setVisible(true);
                    lb_bobReceivingChain1.setVisible(true);
                    lb_bobReceivingChain2.setVisible(true);
                    lb_bobReceivingChain3.setVisible(true);
                    lb_bobReceivingChain4.setVisible(true);
                    lb_bobReceivingChain5.setVisible(true);
                    lb_bobDiffieHellman1.setVisible(true);
                    lb_bobDiffieHellman2.setVisible(true);
                    lb_bobDiffieHellman3.setVisible(true);

                    txt_aliceStep0.setVisible(true);
                    txt_bobStep0.setVisible(true);
                    txt_aliceStep1.setVisible(true);
                    txt_bobStep1.setVisible(true);
                    txt_aliceStep2.setVisible(true);
                    txt_bobStep2.setVisible(true);
                    txt_aliceStep3.setVisible(true);
                    txt_bobStep3.setVisible(true);
                    
                    break;
                    
        case 4:     grp_aliceAlgorithm.setVisible(true);
                    grp_aliceSteps.setVisible(true);
                    grp_aliceDiffieHellman.setVisible(true);
                    grp_aliceRootChain.setVisible(true);
                    grp_aliceSendingChain.setVisible(true);
                    grp_aliceReceivingChain.setVisible(true);
                    
                    grp_bobAlgorithm.setVisible(true);
                    grp_bobSteps.setVisible(true);
                    grp_bobDiffieHellman.setVisible(true);
                    grp_bobRootChain.setVisible(true);
                    grp_bobReceivingChain.setVisible(true);
                    grp_bobSendingChain.setVisible(true);
                    
                    lb_aliceDiffieHellman2.setVisible(true);
                    lb_aliceRootChain1.setVisible(true);
                    lb_aliceRootChain2.setVisible(true);
                    lb_aliceRootChain3.setVisible(true);
                    lb_aliceSendingChain1.setVisible(true);
                    lb_aliceSendingChain2.setVisible(true);
                    lb_aliceSendingChain3.setVisible(true);
                    lb_aliceSendingChain4.setVisible(true);
                    lb_aliceSendingChain5.setVisible(true);
                    lb_aliceDiffieHellman1.setVisible(true);
                    lb_aliceDiffieHellman2.setVisible(true);
                    lb_aliceDiffieHellman3.setVisible(true);
                    lb_aliceReceivingChain1.setVisible(true);
                    lb_aliceReceivingChain2.setVisible(true);
                    lb_aliceReceivingChain3.setVisible(true);
                    lb_aliceReceivingChain4.setVisible(true);
                    lb_aliceReceivingChain5.setVisible(true);
                    
                    lb_bobDiffieHellman2.setVisible(true);
                    lb_bobRootChain1.setVisible(true);
                    lb_bobRootChain2.setVisible(true);
                    lb_bobRootChain3.setVisible(true);
                    lb_bobReceivingChain1.setVisible(true);
                    lb_bobReceivingChain2.setVisible(true);
                    lb_bobReceivingChain3.setVisible(true);
                    lb_bobReceivingChain4.setVisible(true);
                    lb_bobReceivingChain5.setVisible(true);
                    lb_bobDiffieHellman1.setVisible(true);
                    lb_bobDiffieHellman2.setVisible(true);
                    lb_bobDiffieHellman3.setVisible(true);
                    lb_bobSendingChain1.setVisible(true);
                    lb_bobSendingChain2.setVisible(true);
                    lb_bobSendingChain3.setVisible(true);
                    lb_bobSendingChain4.setVisible(true);
                    lb_bobSendingChain5.setVisible(true);

                    txt_aliceStep0.setVisible(true);
                    txt_bobStep0.setVisible(true);
                    txt_aliceStep1.setVisible(true);
                    txt_bobStep1.setVisible(true);
                    txt_aliceStep2.setVisible(true);
                    txt_bobStep2.setVisible(true);
                    txt_aliceStep3.setVisible(true);
                    txt_bobStep3.setVisible(true);
                    txt_aliceStep4.setVisible(true);
                    txt_bobStep4.setVisible(true);
                    
                    break;
            
        
        }
        
    }

    private void setTitleAndDescription() {

        titleAndDescription = new TitleAndDescriptionComposite(this);
        titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        titleAndDescription.setTitle(title);
        titleAndDescription.setDescription(description);
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
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
<<<<<<< HEAD

    private void createBobButton() {
=======
    
<<<<<<< HEAD
    private void createBobButton(){
=======
    protected void createBobButton(){
>>>>>>> c9b4c7de1aa72188fcfa5e89afb35d5d0c51c91b
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        btn_bob = new Button(this, SWT.RIGHT);
        btn_bob.setAlignment(SWT.CENTER);
        gd_btnBob = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
        gd_btnBob.widthHint = 150;
<<<<<<< HEAD
        btn_bob.setLayoutData(gd_btnBob);
=======
        btn_bob.setLayoutData(gd_btnBob);        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        btn_bob.setText(Messages.SignalEncryption_btnName_Bob);

        btn_bob.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showBobView();

            }
        });
    }
<<<<<<< HEAD

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
            }
        });
    }

    private void showBobView() {
=======
<<<<<<< HEAD
    private void createPreviousButton() {
=======
    protected void createPreviousButton() {
>>>>>>> c9b4c7de1aa72188fcfa5e89afb35d5d0c51c91b
        btn_previous = new Button(this, SWT.PUSH);
        btn_previous.setAlignment(SWT.CENTER);
        gd_btnPrev = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
        gd_btnPrev.widthHint = 150;
        btn_previous.setLayoutData(gd_btnPrev);
<<<<<<< HEAD
        btn_previous.setText("Previous");
=======
        btn_previous.setText("Zurück");
>>>>>>> c9b4c7de1aa72188fcfa5e89afb35d5d0c51c91b
        btn_previous.addSelectionListener(new SelectionAdapter() {

            
            @Override
            public void widgetSelected(SelectionEvent e) {
<<<<<<< HEAD
                currentState = currentState.back(instance);
            }
        });        
    }
    private void createNextButton() {
=======
                signalEncryptionState.currentStateBack(signalEncryptionState);
                if(currentState < 1)
                    return;
                switchState(--currentState);
            }
        });        
    }
    protected void createNextButton() {
>>>>>>> c9b4c7de1aa72188fcfa5e89afb35d5d0c51c91b
        btn_next = new Button(this, SWT.PUSH);
        btn_next.setAlignment(SWT.CENTER);
        gd_btnNext = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
        gd_btnNext.widthHint = 150;
        btn_next.setLayoutData(gd_btnNext);
        btn_next.setText("Weiter");
        btn_next.addSelectionListener(new SelectionAdapter() {

            
            @Override
            public void widgetSelected(SelectionEvent e) {
<<<<<<< HEAD
                currentState = currentState.next(instance);
         }
        });    
    }
    private void showBobView() {
=======
                signalEncryptionState.currenStateNext(signalEncryptionState);
                if(currentState > 3)
                    return;
                switchState(++currentState);
            }
        });    
    }
    protected void showBobView() {
>>>>>>> c9b4c7de1aa72188fcfa5e89afb35d5d0c51c91b
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
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
<<<<<<< HEAD

        // Parent groups for algorithm and steps composites
        grp_bobSteps = new Group(cmp_bob, SWT.CENTER);
        grp_bobAlgorithm = new Group(cmp_bob, SWT.CENTER);

        // Parent composite for chain groups
        cmp_bobSteps = new Composite(grp_bobSteps, SWT.CENTER);
        cmp_bobAlgorithm = new Composite(grp_bobAlgorithm, SWT.CENTER);

        // Parent groups for chain composites
=======
        
        grp_bobSteps = new Group(cmp_bob, SWT.CENTER);
        grp_bobAlgorithm = new Group(cmp_bob, SWT.CENTER);
        
        cmp_bobSteps = new Composite(grp_bobSteps, SWT.CENTER);
        cmp_bobAlgorithm = new Composite(grp_bobAlgorithm, SWT.CENTER);
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        grp_bobSendingChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobReceivingChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobRootChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobDiffieHellman = new Group(cmp_bobAlgorithm, SWT.CENTER);
<<<<<<< HEAD

        // Composites for chain labels
=======
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        cmp_bobSendingChain = new Composite(grp_bobSendingChain, SWT.CENTER | SWT.BORDER);
        cmp_bobReceivingChain = new Composite(grp_bobReceivingChain, SWT.CENTER | SWT.BORDER);
        cmp_bobRootChain = new Composite(grp_bobRootChain, SWT.CENTER | SWT.BORDER);
        cmp_bobDiffieHellman = new Composite(grp_bobDiffieHellman, SWT.CENTER | SWT.BORDER);

<<<<<<< HEAD
        // Composite for Message Box
        cmp_bobMessageBox = new Composite(grp_bobSendingChain, SWT.CENTER | SWT.BORDER);

        gl_bobComposite = new GridLayout(1, true);

=======
        gl_bobComposite = new GridLayout(1, true);
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        gl_bobAlgorithmGroup = new GridLayout(1, false);
        gl_bobStepsGroup = new GridLayout(1, false);
        gl_bobDiffieHellmanGroup = new GridLayout(1, false);
        gl_bobRootChainGroup = new GridLayout(1, false);
        gl_bobSendingChainGroup = new GridLayout(1, false);
        gl_bobReceivingChainGroup = new GridLayout(1, false);
<<<<<<< HEAD

=======
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        gl_bobAlgorithmComposite = new GridLayout(4, false);
        gl_bobStepsComposite = new GridLayout(1, false);
        gl_bobDiffieHellmanComposite = new GridLayout(2, false);
        gl_bobRootChainComposite = new GridLayout(2, false);
<<<<<<< HEAD
        gl_bobSendingChainComposite = new GridLayout(4, false);
        gl_bobReceivingChainComposite = new GridLayout(5, false);
        gl_bobMessageBoxComposite = new GridLayout(1, false);
=======
        gl_bobSendingChainComposite = new GridLayout(3, false);
        gl_bobReceivingChainComposite = new GridLayout(3, false);
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11

        gd_bobAlgorithmComposite = new GridData(SWT.FILL, SWT.BOTTOM, true, true, 1, 1);
        gd_bobStepsComposite = new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1);
        gd_bobDiffieHellmanComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_bobRootChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_bobSendingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_bobReceivingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);

        cmp_bob.setLayout(gl_bobComposite);

<<<<<<< HEAD
        grp_bobSteps.setText(signalEncryptionState.getCurrentState().toString());
=======
        grp_bobSteps.setText(stepGroupDescription);
<<<<<<< HEAD
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

=======
>>>>>>> c9b4c7de1aa72188fcfa5e89afb35d5d0c51c91b
        grp_bobSteps.setLayout(gl_bobStepsComposite);
        grp_bobSteps.setLayoutData(gd_bobStepsComposite);
        
        cmp_bobSteps.setLayout(gl_bobStepsComposite);
        cmp_bobSteps.setLayoutData(gd_bobStepsComposite);

        grp_bobAlgorithm.setText(AlgorithmGroupDescription);
        grp_bobAlgorithm.setLayout(gl_bobAlgorithmComposite);
        grp_bobAlgorithm.setLayoutData(gd_bobAlgorithmComposite);
        
        cmp_bobAlgorithm.setLayout(gl_bobAlgorithmComposite);
        cmp_bobAlgorithm.setLayoutData(gd_bobAlgorithmComposite);

        
        //
        // Sending Chain
        //
        
        grp_bobSendingChain.setText(SendingChainDescription);
        grp_bobSendingChain.setLayout(gl_bobSendingChainComposite);
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
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        lb_bobSendingChain2 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain2.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain2.setText(bobSendingChainLabel2);

<<<<<<< HEAD
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

=======

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

        
        //
        // Receiving Chain
        //
        
        grp_bobReceivingChain.setText(ReceivingChainDescription);
        grp_bobReceivingChain.setLayout(gl_bobReceivingChainComposite);
        grp_bobReceivingChain.setLayoutData(gd_bobReceivingChainComposite);
        
        cmp_bobReceivingChain.setLayout(gl_bobReceivingChainComposite);
        cmp_bobReceivingChain.setLayoutData(gd_bobReceivingChainComposite);
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE);    
        
        lb_bobReceivingChain1 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain1.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain1.setText(bobReceivingChainLabel1);
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE); 
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE); 
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        lb_bobReceivingChain2 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain2.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain2.setText(bobReceivingChainLabel2);

<<<<<<< HEAD
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

=======
        lb_bobReceivingChain3 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain3.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain3.setText(bobReceivingChainLabel3);
        
        lb_bobReceivingChain4 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain4.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain4.setText(bobReceivingChainLabel4);
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE); 
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE);
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE);
        
        lb_bobReceivingChain5 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain5.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain5.setText(bobReceivingChainLabel5);
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE); 

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
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        // empty label for filling space
        new Label(cmp_bobRootChain, SWT.NONE);

        lb_bobRootChain2 = new Label(cmp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobRootChain2.setLayoutData(gd_algorithmLabels);
        lb_bobRootChain2.setText(bobRootChainLabel2);
<<<<<<< HEAD

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

=======
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        // empty label for filling space
        new Label(cmp_bobRootChain, SWT.NONE);

        lb_bobRootChain3 = new Label(cmp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobRootChain3.setLayoutData(gd_algorithmLabels);
        lb_bobRootChain3.setText(bobRootChainLabel3);

<<<<<<< HEAD
    }

    private void createBobDiffieHellmanChain() {
        //
        // Diffie Hellman Chain
        //

        grp_bobDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_bobDiffieHellman.setLayout(gl_bobDiffieHellmanComposite);
        grp_bobDiffieHellman.setLayoutData(gd_bobDiffieHellmanComposite);

=======
        //
        // Diffie Hellman Chain
        //
        
        grp_bobDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_bobDiffieHellman.setLayout(gl_bobDiffieHellmanComposite);
        grp_bobDiffieHellman.setLayoutData(gd_bobDiffieHellmanComposite);
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        cmp_bobDiffieHellman.setLayout(gl_bobDiffieHellmanComposite);
        cmp_bobDiffieHellman.setLayoutData(gd_bobDiffieHellmanComposite);

        lb_bobDiffieHellman1 = new Label(cmp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman1.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman1.setText(bobDiffieHellmanLabel1);
        lb_bobDiffieHellman1.setLayoutData(gd_algorithmLabels);
<<<<<<< HEAD

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

=======
        
        // empty label for filling space
        new Label(cmp_bobDiffieHellman, SWT.NONE);

>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        lb_bobDiffieHellman2 = new Label(cmp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman2.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman2.setText(bobDiffieHellmanLabel2);
        lb_bobDiffieHellman2.setLayoutData(gd_algorithmLabels);
<<<<<<< HEAD

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

=======
        
        // empty label for filling space
        new Label(cmp_bobDiffieHellman, SWT.NONE);

>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        lb_bobDiffieHellman3 = new Label(cmp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman3.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman3.setText(bobDiffieHellmanLabel3);
        lb_bobDiffieHellman3.setLayoutData(gd_algorithmLabels);
        
        // step description
        txt_bobStep0 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_bobStep0.setText(bobStep0);
        txt_bobStep0.setLayoutData(gd_descriptionTexts);
        txt_bobStep1 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_bobStep1.setText(bobStep1);
        txt_bobStep1.setLayoutData(gd_descriptionTexts);
        txt_bobStep2 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_bobStep2.setText(bobStep2);
        txt_bobStep2.setLayoutData(gd_descriptionTexts);
        txt_bobStep3 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_bobStep3.setText(bobStep3);
        txt_bobStep3.setLayoutData(gd_descriptionTexts);
        txt_bobStep4 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_bobStep4.setText(bobStep4);
        txt_bobStep4.setLayoutData(gd_descriptionTexts);
        txt_bobStep5 = new Text(cmp_bobSteps, SWT.NONE | SWT.WRAP);
        txt_bobStep5.setText(bobStep5);
        txt_bobStep5.setLayoutData(gd_descriptionTexts);
        
        
    }

    private void createAliceComposite() {

        // Init of the widgets, layouts and data needed
        cmp_alice = new Composite(cmp_main, SWT.NONE);

<<<<<<< HEAD
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
=======
        grp_aliceAlgorithm = new Group(cmp_alice, SWT.CENTER);
        grp_aliceSteps = new Group(cmp_alice, SWT.CENTER);

        cmp_aliceAlgorithm = new Composite(grp_aliceAlgorithm, SWT.CENTER);
        cmp_aliceSteps = new Composite(grp_aliceSteps, SWT.CENTER | SWT.FILL);

        grp_aliceDiffieHellman = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceRootChain = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceSendingChain = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceReceivingChain = new Group(cmp_aliceAlgorithm, SWT.CENTER);

        cmp_aliceDiffieHellman = new Composite(grp_aliceDiffieHellman, SWT.CENTER | SWT.BORDER);
        cmp_aliceRootChain = new Composite(grp_aliceRootChain, SWT.CENTER | SWT.BORDER);
        cmp_aliceSendingChain = new Composite(grp_aliceSendingChain, SWT.CENTER | SWT.BORDER);
        cmp_aliceReceivingChain = new Composite(grp_aliceReceivingChain, SWT.CENTER | SWT.BORDER);

        gl_aliceComposite = new GridLayout(1, false);
        
        gl_aliceAlgorithmGroup = new GridLayout(1, false);
        gl_aliceStepsGroup = new GridLayout(1, false);
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        gl_aliceDiffieHellmanGroup = new GridLayout(1, false);
        gl_aliceRootChainGroup = new GridLayout(1, false);
        gl_aliceSendingChainGroup = new GridLayout(1, false);
        gl_aliceReceivingChainGroup = new GridLayout(1, false);
<<<<<<< HEAD
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
=======
        
        gl_aliceAlgorithmComposite = new GridLayout(4, false);
        gl_aliceStepsComposite = new GridLayout(1, false);
        gl_aliceDiffieHellmanComposite = new GridLayout(2, false);
        gl_aliceRootChainComposite = new GridLayout(2, false);
        gl_aliceSendingChainComposite = new GridLayout(3, false);
        gl_aliceReceivingChainComposite = new GridLayout(3, false);

        gd_aliceAlgorithmComposite = new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1);
        gd_aliceStepsComposite = new GridData(SWT.FILL, SWT.BOTTOM, true, true, 1, 1);
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        gd_aliceDiffieHellmanComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceRootChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceSendingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceReceivingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
<<<<<<< HEAD
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
=======

        cmp_alice.setLayout(gl_aliceComposite);


        grp_aliceAlgorithm.setText(AlgorithmGroupDescription);
        grp_aliceAlgorithm.setLayout(gl_aliceAlgorithmComposite);
        grp_aliceAlgorithm.setLayoutData(gd_aliceAlgorithmComposite);

        grp_aliceSteps.setText(stepGroupDescription);
        grp_aliceSteps.setLayout(gl_aliceStepsComposite);
        grp_aliceSteps.setLayoutData(gd_aliceStepsComposite);
        
        cmp_aliceAlgorithm.setLayout(gl_aliceAlgorithmComposite);
        cmp_aliceAlgorithm.setLayoutData(gd_aliceAlgorithmComposite);
        
        cmp_aliceSteps.setLayout(gl_aliceStepsComposite);
        cmp_aliceSteps.setLayoutData(gd_aliceStepsComposite);
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        //
        // DH Chain
        //
        grp_aliceDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_aliceDiffieHellman.setLayout(gl_aliceDiffieHellmanComposite);
        grp_aliceDiffieHellman.setLayoutData(gd_aliceDiffieHellmanComposite);
<<<<<<< HEAD

=======
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        cmp_aliceDiffieHellman.setLayout(gl_aliceDiffieHellmanComposite);
        cmp_aliceDiffieHellman.setLayoutData(gd_aliceDiffieHellmanComposite);

        lb_aliceDiffieHellman1 = new Label(cmp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman1.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman1.setText(aliceDiffieHellmanLabel1);
<<<<<<< HEAD

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
=======
        
        // empty label for filling space
        new Label(cmp_aliceDiffieHellman, SWT.NONE);

        lb_aliceDiffieHellman2 = new Label(cmp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman2.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman2.setText(aliceDiffieHellmanLabel2);
        
        // empty label for filling space
        new Label(cmp_aliceDiffieHellman, SWT.NONE);

        lb_aliceDiffieHellman3 = new Label(cmp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman3.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman3.setText(aliceDiffieHellmanLabel3);

>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        //
        // Root Chain
        //
        grp_aliceRootChain.setText(RootChainDescription);
        grp_aliceRootChain.setLayout(gl_aliceRootChainComposite);
        grp_aliceRootChain.setLayoutData(gd_aliceRootChainComposite);
<<<<<<< HEAD

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

=======
        
        cmp_aliceRootChain.setLayout(gl_aliceRootChainComposite);
        cmp_aliceRootChain.setLayoutData(gd_aliceRootChainComposite);
        
        lb_aliceRootChain1 = new Label(cmp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceRootChain1.setLayoutData(gd_algorithmLabels);
        lb_aliceRootChain1.setText(aliceRootChainLabel1);
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        // empty label for filling space
        new Label(cmp_aliceRootChain, SWT.NONE);

        lb_aliceRootChain2 = new Label(cmp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceRootChain2.setLayoutData(gd_algorithmLabels);
        lb_aliceRootChain2.setText(aliceRootChainLabel2);
<<<<<<< HEAD

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

=======
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        // empty label for filling space
        new Label(cmp_aliceRootChain, SWT.NONE);

        lb_aliceRootChain3 = new Label(cmp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceRootChain3.setLayoutData(gd_algorithmLabels);
        lb_aliceRootChain3.setText(aliceRootChainLabel3);

<<<<<<< HEAD
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

        txt_aliceCipherText = new Text(cmp_aliceMessageBox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_aliceCipherText.setText(MessageBoxCipherText);
        txt_aliceCipherText.setLayoutData(gd_MessageBox);

    }

    private void createAliceSendingChain() {
=======
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        //
        // Sending Chain
        //
        grp_aliceSendingChain.setText(SendingChainDescription);
        grp_aliceSendingChain.setLayout(gl_aliceSendingChainComposite);
        grp_aliceSendingChain.setLayoutData(gd_aliceSendingChainComposite);
<<<<<<< HEAD

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

=======
        
        cmp_aliceSendingChain.setLayout(gl_aliceSendingChainComposite);
        cmp_aliceSendingChain.setLayoutData(gd_aliceSendingChainComposite);
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE);    
        
        lb_aliceSendingChain1 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain1.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain1.setText(aliceSendingChainLabel1);
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE); 
        
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
        lb_aliceSendingChain2 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain2.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain2.setText(aliceSendingChainLabel2);

<<<<<<< HEAD
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
=======
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11

        lb_aliceSendingChain3 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain3.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain3.setText(aliceSendingChainLabel3);
<<<<<<< HEAD

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
=======
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE); 
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE);
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE);
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11

        lb_aliceSendingChain4 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain4.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain4.setText(aliceSendingChainLabel4);
<<<<<<< HEAD

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
=======
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE); 
        
        lb_aliceSendingChain5 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain5.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain5.setText(aliceSendingChainLabel5);
        
        // Receiving Chain
        grp_aliceReceivingChain.setText(ReceivingChainDescription);
        grp_aliceReceivingChain.setLayout(gl_aliceReceivingChainComposite);
        grp_aliceReceivingChain.setLayoutData(gd_aliceReceivingChainComposite);
        
        cmp_aliceReceivingChain.setLayout(gl_aliceReceivingChainComposite);
        cmp_aliceReceivingChain.setLayoutData(gd_aliceReceivingChainComposite);
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE);    
        
        lb_aliceReceivingChain1 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain1.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain1.setText(aliceReceivingChainLabel1);
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE); 
        
        lb_aliceReceivingChain2 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain2.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain2.setText(aliceReceivingChainLabel2);


        lb_aliceReceivingChain3 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain3.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain3.setText(aliceReceivingChainLabel3);
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE); 
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE);

        lb_aliceReceivingChain4 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain4.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain4.setText(aliceReceivingChainLabel4);
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE); 
        
        lb_aliceReceivingChain5 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain5.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain5.setText(aliceReceivingChainLabel5);
        
        // step description

        txt_aliceStep0 = new Text(cmp_aliceSteps, SWT.WRAP | SWT.MULTI);
        txt_aliceStep0.setText(aliceStep0);
        txt_aliceStep0.setLayoutData(gd_descriptionTexts);
        txt_aliceStep1 = new Text(cmp_aliceSteps, SWT.WRAP | SWT.MULTI | SWT.READ_ONLY);
        txt_aliceStep1.setText(aliceStep1);
        txt_aliceStep1.setLayoutData(gd_descriptionTexts);
        txt_aliceStep2 = new Text(cmp_aliceSteps, SWT.NONE | SWT.WRAP | SWT.MULTI);
        txt_aliceStep2.setText(aliceStep2);
        txt_aliceStep2.setLayoutData(gd_descriptionTexts);
        txt_aliceStep3 = new Text(cmp_aliceSteps, SWT.NONE | SWT.WRAP | SWT.MULTI);
        txt_aliceStep3.setText(aliceStep3);
        txt_aliceStep3.setLayoutData(gd_descriptionTexts);
        txt_aliceStep4 = new Text(cmp_aliceSteps, SWT.NONE | SWT.WRAP | SWT.MULTI);
        txt_aliceStep4.setText(aliceStep4);
        txt_aliceStep4.setLayoutData(gd_descriptionTexts);
        txt_aliceStep5 = new Text(cmp_aliceSteps, SWT.NONE | SWT.WRAP | SWT.MULTI);
        txt_aliceStep5.setText(aliceStep5);
        txt_aliceStep5.setLayoutData(gd_descriptionTexts);
    }
    public enum STATE {
        STEP_0{
            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Hide these Elements
                parent.grp_bobSteps.setVisible(false);
                parent.grp_bobAlgorithm.setVisible(false);
                parent.grp_bobSendingChain.setVisible(false);
                parent.grp_bobReceivingChain.setVisible(false);
                parent.grp_bobRootChain.setVisible(false);
                parent.grp_bobDiffieHellman.setVisible(false);
                parent.lb_bobSendingChain1.setVisible(false);
                parent.lb_bobSendingChain2.setVisible(false);
                parent.lb_bobSendingChain3.setVisible(false);
                parent.lb_bobSendingChain4.setVisible(false);
                parent.lb_bobSendingChain5.setVisible(false);
                parent.lb_bobReceivingChain1.setVisible(false);
                parent.lb_bobReceivingChain2.setVisible(false);
                parent.lb_bobReceivingChain3.setVisible(false);
                parent.lb_bobReceivingChain4.setVisible(false);
                parent.lb_bobReceivingChain5.setVisible(false);
                parent.lb_bobRootChain1.setVisible(false);
                parent.lb_bobRootChain2.setVisible(false);
                parent.lb_bobRootChain3.setVisible(false);
                parent.lb_bobDiffieHellman1.setVisible(false);
                parent.lb_bobDiffieHellman2.setVisible(false);
                parent.lb_bobDiffieHellman3.setVisible(false);
                parent.grp_aliceAlgorithm.setVisible(false);
                parent.grp_aliceSteps.setVisible(false);
                parent.grp_aliceDiffieHellman.setVisible(false);
                parent.grp_aliceRootChain.setVisible(false);
                parent.grp_aliceSendingChain.setVisible(false);
                parent.grp_aliceReceivingChain.setVisible(false);
                parent.lb_aliceDiffieHellman1.setVisible(false);
                parent.lb_aliceDiffieHellman2.setVisible(false);
                parent.lb_aliceDiffieHellman3.setVisible(false);
                parent.lb_aliceRootChain1.setVisible(false);
                parent.lb_aliceRootChain2.setVisible(false);
                parent.lb_aliceRootChain3.setVisible(false);
                parent.lb_aliceSendingChain1.setVisible(false);
                parent.lb_aliceSendingChain2.setVisible(false);
                parent.lb_aliceSendingChain3.setVisible(false);
                parent.lb_aliceSendingChain4.setVisible(false);
                parent.lb_aliceSendingChain5.setVisible(false);
                parent.lb_aliceReceivingChain1.setVisible(false);
                parent.lb_aliceReceivingChain2.setVisible(false);
                parent.lb_aliceReceivingChain3.setVisible(false);
                parent.lb_aliceReceivingChain4.setVisible(false);
                parent.lb_aliceReceivingChain5.setVisible(false);
                parent.txt_aliceStep1.setVisible(false);
                parent.txt_aliceStep2.setVisible(false);
                parent.txt_aliceStep3.setVisible(false);
                parent.txt_aliceStep4.setVisible(false);
                parent.txt_aliceStep5.setVisible(false);
                parent.txt_aliceStep0.setVisible(false);
                parent.txt_bobStep1.setVisible(false);
                parent.txt_bobStep2.setVisible(false);
                parent.txt_bobStep3.setVisible(false);
                parent.txt_bobStep4.setVisible(false);
                parent.txt_bobStep5.setVisible(false);
                parent.txt_bobStep0.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_1.switchState(parent);
                return STEP_1;
            }
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                return STEP_0;
            }
            
        }, STEP_1 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                // Show these labels
                parent.grp_aliceSteps.setVisible(true);
                parent.grp_bobSteps.setVisible(true);
                
                parent.txt_aliceStep0.setVisible(true);
                parent.txt_bobStep0.setVisible(true);
                
                
                // Hide these Elements
                parent.grp_aliceAlgorithm.setVisible(false);
                parent.grp_bobAlgorithm.setVisible(false);
                parent.grp_aliceDiffieHellman.setVisible(false);
                parent.grp_bobDiffieHellman.setVisible(false);
                parent.grp_aliceRootChain.setVisible(false);
                parent.grp_bobRootChain.setVisible(false);
                
                parent.lb_aliceDiffieHellman2.setVisible(false);
                parent.lb_aliceRootChain1.setVisible(false);
                parent.lb_aliceRootChain2.setVisible(false);
                parent.lb_aliceRootChain3.setVisible(false);
                parent.lb_bobDiffieHellman2.setVisible(false);
                parent.lb_bobRootChain1.setVisible(false);
                parent.lb_bobRootChain2.setVisible(false);
                parent.lb_bobRootChain3.setVisible(false);
                
                parent.txt_aliceStep1.setVisible(false);
                parent.txt_bobStep1.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                parent.signalEncryptionState.stepForward(parent.signalEncryptionState);
                STEP_2.switchState(parent);
                return STEP_2;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                parent.signalEncryptionState.stepBack(parent.signalEncryptionState);
                STEP_0.switchState(parent);
                return STEP_0;
            }
            
        }, STEP_2 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Show these labels
                parent.grp_aliceAlgorithm.setVisible(true);
                parent.grp_bobAlgorithm.setVisible(true);
                parent.grp_aliceDiffieHellman.setVisible(true);
                parent.grp_bobDiffieHellman.setVisible(true);
                parent.grp_aliceRootChain.setVisible(true);
                parent.grp_bobRootChain.setVisible(true);
                
                parent.lb_aliceDiffieHellman2.setVisible(true);
                parent.lb_aliceRootChain1.setVisible(true);
                parent.lb_aliceRootChain2.setVisible(true);
                parent.lb_aliceRootChain3.setVisible(true);
                parent.lb_bobDiffieHellman2.setVisible(true);
                parent.lb_bobRootChain1.setVisible(true);
                parent.lb_bobRootChain2.setVisible(true);
                parent.lb_bobRootChain3.setVisible(true);
                

                parent.txt_aliceStep1.setVisible(true);
                parent.txt_bobStep1.setVisible(true);
                
                // Hide these Elements
                parent.grp_aliceSendingChain.setVisible(false);
                
                parent.grp_bobReceivingChain.setVisible(false);
                
                parent.lb_aliceSendingChain1.setVisible(false);
                parent.lb_aliceSendingChain2.setVisible(false);
                parent.lb_aliceSendingChain3.setVisible(false);
                parent.lb_aliceSendingChain4.setVisible(false);
                parent.lb_aliceSendingChain5.setVisible(false);
                
                parent.lb_bobReceivingChain1.setVisible(false);
                parent.lb_bobReceivingChain2.setVisible(false);
                parent.lb_bobReceivingChain3.setVisible(false);
                parent.lb_bobReceivingChain4.setVisible(false);
                parent.lb_bobReceivingChain5.setVisible(false);
                
                parent.txt_aliceStep2.setVisible(false);
                parent.txt_bobStep2.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                parent.signalEncryptionState.stepForward(parent.signalEncryptionState);
                STEP_3.switchState(parent);
                return STEP_3;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                parent.signalEncryptionState.stepBack(parent.signalEncryptionState);
                STEP_1.switchState(parent);
                return STEP_1;
            }
            
        }, STEP_3{

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Show these labels
                parent.grp_aliceDiffieHellman.setVisible(true);
                parent.grp_aliceRootChain.setVisible(true);
                parent.grp_aliceSendingChain.setVisible(true);
                
                parent.grp_bobReceivingChain.setVisible(true);
                
                parent.lb_aliceSendingChain1.setVisible(true);
                parent.lb_aliceSendingChain2.setVisible(true);
                parent.lb_aliceSendingChain3.setVisible(true);
                parent.lb_aliceSendingChain4.setVisible(true);
                parent.lb_aliceSendingChain5.setVisible(true);
                
                parent.lb_bobReceivingChain1.setVisible(true);
                parent.lb_bobReceivingChain2.setVisible(true);
                parent.lb_bobReceivingChain3.setVisible(true);
                parent.lb_bobReceivingChain4.setVisible(true);
                parent.lb_bobReceivingChain5.setVisible(true);
                
                parent.txt_aliceStep2.setVisible(true);
                parent.txt_bobStep2.setVisible(true);
                
                
                // Hide these Elements            
                parent.lb_aliceDiffieHellman1.setVisible(false);
                parent.lb_aliceDiffieHellman2.setVisible(false);
                parent.lb_aliceDiffieHellman3.setVisible(false);
                
                parent.lb_bobDiffieHellman1.setVisible(false);
                parent.lb_bobDiffieHellman2.setVisible(false);
                parent.lb_bobDiffieHellman3.setVisible(false);

                parent.txt_aliceStep3.setVisible(false);
                parent.txt_bobStep3.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_4.switchState(parent);
                return STEP_4;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_2.switchState(parent);
                return STEP_2;
            }
            
        }, STEP_4 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Show these labels
                parent.lb_aliceDiffieHellman1.setVisible(true);
                parent.lb_aliceDiffieHellman2.setVisible(true);
                parent.lb_aliceDiffieHellman3.setVisible(true);
                
                parent.lb_bobDiffieHellman1.setVisible(true);
                parent.lb_bobDiffieHellman2.setVisible(true);
                parent.lb_bobDiffieHellman3.setVisible(true);

                parent.txt_aliceStep3.setVisible(true);
                parent.txt_bobStep3.setVisible(true);
                
                
                // Hide these Elements
                parent.grp_aliceReceivingChain.setVisible(false);
                
                parent.grp_bobSendingChain.setVisible(false);
                
                parent.lb_aliceReceivingChain1.setVisible(false);
                parent.lb_aliceReceivingChain2.setVisible(false);
                parent.lb_aliceReceivingChain3.setVisible(false);
                parent.lb_aliceReceivingChain4.setVisible(false);
                parent.lb_aliceReceivingChain5.setVisible(false);
                
                parent.lb_bobSendingChain1.setVisible(false);
                parent.lb_bobSendingChain2.setVisible(false);
                parent.lb_bobSendingChain3.setVisible(false);
                parent.lb_bobSendingChain4.setVisible(false);
                parent.lb_bobSendingChain5.setVisible(false);

                parent.txt_aliceStep4.setVisible(false);
                parent.txt_bobStep4.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_5.switchState(parent);
                return STEP_5;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_3.switchState(parent);
                return STEP_3;
            }
            
        }, STEP_5 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Show these labels
                parent.grp_aliceReceivingChain.setVisible(true);
                
                parent.grp_bobSendingChain.setVisible(true);
                
                parent.lb_aliceReceivingChain1.setVisible(true);
                parent.lb_aliceReceivingChain2.setVisible(true);
                parent.lb_aliceReceivingChain3.setVisible(true);
                parent.lb_aliceReceivingChain4.setVisible(true);
                parent.lb_aliceReceivingChain5.setVisible(true);
                
                parent.lb_bobSendingChain1.setVisible(true);
                parent.lb_bobSendingChain2.setVisible(true);
                parent.lb_bobSendingChain3.setVisible(true);
                parent.lb_bobSendingChain4.setVisible(true);
                parent.lb_bobSendingChain5.setVisible(true);

                parent.txt_aliceStep4.setVisible(true);
                parent.txt_bobStep4.setVisible(true);
                
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                return STEP_5;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_4.switchState(parent);
                return STEP_4;
            }
            
        }, STEP_ENDLESS{

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                // TODO Auto-generated method stub
                return null;
            }
            
        };
        
        protected abstract void switchState(SignalEncryptionViewDoubleRatchet parent);
        abstract STATE next(SignalEncryptionViewDoubleRatchet parent);
        abstract STATE back(SignalEncryptionViewDoubleRatchet parent);
        public STATE setInitialState(SignalEncryptionViewDoubleRatchet parent) {
            STEP_0.switchState(parent);
            return STEP_0;
        }
    }
<<<<<<< HEAD

    void showBobMessageBox() {
        StackLayout layout = (StackLayout) this.grp_bobSendingChain.getLayout();
        grp_bobSendingChain.setText(MessageBoxDescription);
        layout.topControl = this.cmp_bobMessageBox;
        this.grp_bobSendingChain.layout();

    }
    public void resetAll() {
        signalEncryptionDoubleRatchetState.reset(this);
    }

=======
    
    
>>>>>>> 47ab36d5920ad2b05a23343f317887c831aa3b11
}
