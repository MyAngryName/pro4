package org.jcryptool.visual.signalencryption.ui;

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionState.STATE;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

/**
 * 
 * @author Dan-Kerko Ciudin
 * 
 * 
 */

public class SignalEncryptionViewDoubleRatchet extends Composite {

    private TitleAndDescriptionComposite titleAndDescription;

    private Composite cmp_main;
    private Composite cmp_alice;
    private Composite cmp_bob;

    private Button btn_alice;
    private Button btn_bob;
    private Button btn_next;
    private Button btn_prev;

    private Group grp_aliceSteps;
    private Group grp_aliceAlgorithm;
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
    private GridData gd_bobDiffieHellmanComposite;
    private GridData gd_bobRootChainComposite;
    private GridData gd_bobSendingChainComposite;
    private GridData gd_bobReceivingChainComposite;

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
    private Label lb_aliceReceivingChain1;
    private Label lb_aliceReceivingChain2;
    private Label lb_aliceReceivingChain3;
    private Label lb_aliceReceivingChain4;
    private Label lb_bobRootChain1;
    private Label lb_bobRootChain2;
    private Label lb_bobRootChain3;
    private Label lb_bobSendingChain1;
    private Label lb_bobSendingChain2;
    private Label lb_bobSendingChain3;
    private Label lb_bobSendingChain4;
    private Label lb_bobReceivingChain1;
    private Label lb_bobReceivingChain2;
    private Label lb_bobReceivingChain3;
    private Label lb_bobReceivingChain4;

    private String aliceDiffieHellmanLabel1 = Messages.SignalEncryption_aliceDiffieHellmanLabel1;
    private String aliceDiffieHellmanLabel2 = Messages.SignalEncryption_aliceDiffieHellmanLabel2;
    private String aliceDiffieHellmanLabel3 = Messages.SignalEncryption_aliceDiffieHellmanLabel3;
    private String bobDiffieHellmanLabel1 = Messages.SignalEncryption_bobDiffieHellmanLabel1;
    private String bobDiffieHellmanLabel2 = Messages.SignalEncryption_bobDiffieHellmanLabel2;
    private String bobDiffieHellmanLabel3 = Messages.SignalEncryption_bobDiffieHellmanLabel3;
    private String aliceRootChainLabel1 = "Root Chain Schlüssel";
    private String aliceRootChainLabel2 = "Schlüsselableitungs-Funktion (KDF)";
    private String aliceRootChainLabel3 = "Neuer Root Chain Schlüssel";
    private String aliceSendingChainLabel1 = "Sending Chain Schlüssel";
    private String aliceSendingChainLabel2 = "Schlüsselableitungs-Funktion (KDF)";
    private String aliceSendingChainLabel3 = "Sending Key";
    private String aliceSendingChainLabel4 = "Neuer Sending Chain Schlüssel";
    private String aliceReceivingChainLabel1 = "Receiving Chain Schlüssel";
    private String aliceReceivingChainLabel2 = "Schlüsselableitungs-Funktion (KDF)";
    private String aliceReceivingChainLabel3 = "Receiving Key";
    private String aliceReceivingChainLabel4 = "Neuer Receiving Chain Schlüssel";
    private String bobRootChainLabel1 = "Root Chain Schlüssel";
    private String bobRootChainLabel2 = "Schlüsselableitungs-Funktion (KDF)";
    private String bobRootChainLabel3 = "Neuer Root Chain Schlüssel";
    private String bobSendingChainLabel1 = "Sending Chain Schlüssel";
    private String bobSendingChainLabel2 = "Schlüsselableitungs-Funktion (KDF)";
    private String bobSendingChainLabel3 = "Sending Key";
    private String bobSendingChainLabel4 = "Neuer Sending Chain Schlüssel";
    private String bobReceivingChainLabel1 = "Receiving Chain Schlüssel";
    private String bobReceivingChainLabel2 = "Schlüsselableitungs-Funktion (KDF)";
    private String bobReceivingChainLabel3 = "Receiving Key";
    private String bobReceivingChainLabel4 = "Neuer Receiving Chain Schlüssel";

    private Group grp_bobSteps;

    private Group grp_bobAlgorithm;

    private Group grp_bobSendingChain;

    private Group grp_bobReceivingChain;

    private Group grp_bobRootChain;

    private Group grp_bobDiffieHellman;

    private GridData gd_bobAlgorithmGroup;

    private GridData gd_bobStepsGroup;

    private GridData gd_bobDiffieHellmanGroup;

    private GridData gd_bobRootChainGroupe;

    private GridData gd_bobSendingChainGroup;

    private GridData gd_bobReceivingChainGroup;

    private GridLayout gl_bobAlgorithmGroup;

    private GridLayout gl_bobStepsGroup;

    private GridLayout gl_bobDiffieHellmanGroup;

    private GridLayout gl_bobRootChainGroup;

    private GridLayout gl_bobSendingChainGroup;

    private GridLayout gl_bobReceivingChainGroup;

    private Group grp_aliceDiffieHellman;

    private Group grp_aliceRootChain;

    private Group grp_aliceSendingChain;

    private Group grp_aliceReceivingChain;

    private Composite cmp_aliceAlgorithm;

    private Composite cmp_aliceSteps;

    private GridLayout gl_aliceAlgorithmGroup;

    private GridLayout gl_aliceStepsGroup;

    private GridLayout gl_aliceDiffieHellmanGroup;

    private GridLayout gl_aliceRootChainGroup;

    private GridLayout gl_aliceSendingChainGroup;

    private GridLayout gl_aliceReceivingChainGroup;

//    private String aliceStep1 = ""
    
    private SignalEncryptionAlgorithm signalEncryptionAlgorithm;
    private SignalEncryptionState signalEncryptionState;


    SignalEncryptionViewDoubleRatchet(Composite parent, int style, SignalEncryptionState signalEncryptionState) {
        super(parent, style);
        
        this.signalEncryptionState= signalEncryptionState;
        this.signalEncryptionAlgorithm = signalEncryptionState.getSignalEncryptionAlgorithm();
        
        gl_parent = new GridLayout(2, false);
        gl_parent.horizontalSpacing = 3;
        gl_parent.verticalSpacing = 0;
        setLayout(gl_parent);

        // style data for the labels within the algorithm
        gd_algorithmLabels = new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1);
        gd_algorithmLabels.verticalIndent = 40;
        gd_algorithmLabels.horizontalIndent = 10;
        gd_algorithmLabels.widthHint = 150;
        gd_algorithmLabels.heightHint = 70;

        setTitleAndDescription();
        createButtons();
        createMainComposite();
        createAliceComposite();
        createBobComposite();
        


    }

    private void setTitleAndDescription() {

        titleAndDescription = new TitleAndDescriptionComposite(this);
        titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        titleAndDescription.setTitle("Title");
        titleAndDescription.setDescription("Description");
    }

    private void createMainComposite() {

        cmp_main = new Composite(this, SWT.NONE);
        cmp_main.setLayout(new StackLayout());
        cmp_main.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 14, 1));

    }

    private void createButtons() {

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
        
        
        // Steps Buttons
        btn_prev = new Button(this, SWT.PUSH);
        btn_prev.setAlignment(SWT.CENTER);
        gd_btnPrev = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
        gd_btnPrev.widthHint = 150;
        btn_prev.setLayoutData(gd_btnPrev);
        btn_prev.setText("Previous");
        btn_prev.addSelectionListener(new SelectionAdapter() {

            
            @Override
            public void widgetSelected(SelectionEvent e) {
                signalEncryptionState.currentStateBack(signalEncryptionState);                
            }
        });
        
        btn_next = new Button(this, SWT.PUSH);
        btn_next.setAlignment(SWT.CENTER);
        gd_btnNext = new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1);
        gd_btnNext.widthHint = 150;
        btn_next.setLayoutData(gd_btnNext);
        btn_next.setText("Next");
        btn_next.addSelectionListener(new SelectionAdapter() {

            
            @Override
            public void widgetSelected(SelectionEvent e) {
                signalEncryptionState.currenStateNext(signalEncryptionState);                
            }
        });
    }

    protected void showBobView() {
        StackLayout layout = (StackLayout) this.cmp_main.getLayout();
        layout.topControl = this.cmp_bob;
        this.cmp_main.layout();

    }

    protected void showAliceView() {
        StackLayout layout = (StackLayout) this.cmp_main.getLayout();
        layout.topControl = this.cmp_alice;
        this.cmp_main.layout();

    }

    private void createBobComposite() {

        // Init of the layouts and data needed
        cmp_bob = new Composite(cmp_main, SWT.NONE);
        
        grp_bobSteps = new Group(cmp_bob, SWT.CENTER);
        grp_bobAlgorithm = new Group(cmp_bob, SWT.CENTER);
        
        cmp_bobSteps = new Composite(grp_bobSteps, SWT.CENTER);
        cmp_bobAlgorithm = new Composite(grp_bobAlgorithm, SWT.CENTER);
        
        grp_bobSendingChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobReceivingChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobRootChain = new Group(cmp_bobAlgorithm, SWT.CENTER);
        grp_bobDiffieHellman = new Group(cmp_bobAlgorithm, SWT.CENTER);
        
        cmp_bobSendingChain = new Composite(grp_bobSendingChain, SWT.CENTER | SWT.BORDER);
        cmp_bobReceivingChain = new Composite(grp_bobReceivingChain, SWT.CENTER | SWT.BORDER);
        cmp_bobRootChain = new Composite(grp_bobRootChain, SWT.CENTER | SWT.BORDER);
        cmp_bobDiffieHellman = new Composite(grp_bobDiffieHellman, SWT.CENTER | SWT.BORDER);

        gl_bobComposite = new GridLayout(2, false);
        
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
        gl_bobSendingChainComposite = new GridLayout(3, false);
        gl_bobReceivingChainComposite = new GridLayout(3, false);

        gd_bobAlgorithmComposite = new GridData(SWT.RIGHT, SWT.TOP, true, true, 1, 1);
        gd_bobStepsComposite = new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1);
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
        
        lb_bobSendingChain1 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain1.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain1.setText(bobSendingChainLabel1);


        lb_bobSendingChain2 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain2.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain2.setText(bobSendingChainLabel2);
        
        lb_bobSendingChain3 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain3.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain3.setText(bobSendingChainLabel3);
        
        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE); 
        
        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE);
        
        // empty label for filling space
        new Label(cmp_bobSendingChain, SWT.NONE);
        
        lb_bobSendingChain4 = new Label(cmp_bobSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobSendingChain4.setLayoutData(gd_algorithmLabels);
        lb_bobSendingChain4.setText(bobSendingChainLabel4);
        
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
        
        lb_bobReceivingChain1 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain1.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain1.setText(bobReceivingChainLabel1);


        lb_bobReceivingChain2 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain2.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain2.setText(bobReceivingChainLabel2);
        
        lb_bobReceivingChain3 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain3.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain3.setText(bobReceivingChainLabel3);
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE); 
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE);
        
        // empty label for filling space
        new Label(cmp_bobReceivingChain, SWT.NONE);
        
        lb_bobReceivingChain4 = new Label(cmp_bobReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobReceivingChain4.setLayoutData(gd_algorithmLabels);
        lb_bobReceivingChain4.setText(bobReceivingChainLabel4);
        
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
        
        // empty label for filling space
        new Label(cmp_bobRootChain, SWT.NONE);

        lb_bobRootChain2 = new Label(cmp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobRootChain2.setLayoutData(gd_algorithmLabels);
        lb_bobRootChain2.setText(bobRootChainLabel2);
        
        // empty label for filling space
        new Label(cmp_bobRootChain, SWT.NONE);

        lb_bobRootChain3 = new Label(cmp_bobRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobRootChain3.setLayoutData(gd_algorithmLabels);
        lb_bobRootChain3.setText(bobRootChainLabel3);

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

        lb_bobDiffieHellman2 = new Label(cmp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman2.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman2.setText(bobDiffieHellmanLabel2);
        lb_bobDiffieHellman2.setLayoutData(gd_algorithmLabels);
        
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

        grp_aliceAlgorithm = new Group(cmp_alice, SWT.CENTER);
        grp_aliceSteps = new Group(cmp_alice, SWT.CENTER);

        cmp_aliceAlgorithm = new Composite(grp_aliceAlgorithm, SWT.CENTER);
        cmp_aliceSteps = new Composite(grp_aliceSteps, SWT.CENTER);

        grp_aliceDiffieHellman = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceRootChain = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceSendingChain = new Group(cmp_aliceAlgorithm, SWT.CENTER);
        grp_aliceReceivingChain = new Group(cmp_aliceAlgorithm, SWT.CENTER);

        cmp_aliceDiffieHellman = new Composite(grp_aliceDiffieHellman, SWT.CENTER | SWT.BORDER);
        cmp_aliceRootChain = new Composite(grp_aliceRootChain, SWT.CENTER | SWT.BORDER);
        cmp_aliceSendingChain = new Composite(grp_aliceSendingChain, SWT.CENTER | SWT.BORDER);
        cmp_aliceReceivingChain = new Composite(grp_aliceReceivingChain, SWT.CENTER | SWT.BORDER);

        gl_aliceComposite = new GridLayout(2, false);
        
        gl_aliceAlgorithmGroup = new GridLayout(1, false);
        gl_aliceStepsGroup = new GridLayout(1, false);
        gl_aliceDiffieHellmanGroup = new GridLayout(1, false);
        gl_aliceRootChainGroup = new GridLayout(1, false);
        gl_aliceSendingChainGroup = new GridLayout(1, false);
        gl_aliceReceivingChainGroup = new GridLayout(1, false);
        
        gl_aliceAlgorithmComposite = new GridLayout(4, false);
        gl_aliceStepsComposite = new GridLayout(1, false);
        gl_aliceDiffieHellmanComposite = new GridLayout(2, false);
        gl_aliceRootChainComposite = new GridLayout(2, false);
        gl_aliceSendingChainComposite = new GridLayout(3, false);
        gl_aliceReceivingChainComposite = new GridLayout(3, false);

        gd_aliceAlgorithmComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceStepsComposite = new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1);
        gd_aliceDiffieHellmanComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceRootChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceSendingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceReceivingChainComposite = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);

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

        lb_aliceDiffieHellman2 = new Label(cmp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman2.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman2.setText(aliceDiffieHellmanLabel2);
        
        // empty label for filling space
        new Label(cmp_aliceDiffieHellman, SWT.NONE);

        lb_aliceDiffieHellman3 = new Label(cmp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman3.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman3.setText(aliceDiffieHellmanLabel3);

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

        lb_aliceRootChain2 = new Label(cmp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceRootChain2.setLayoutData(gd_algorithmLabels);
        lb_aliceRootChain2.setText(aliceRootChainLabel2);
        
        // empty label for filling space
        new Label(cmp_aliceRootChain, SWT.NONE);

        lb_aliceRootChain3 = new Label(cmp_aliceRootChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceRootChain3.setLayoutData(gd_algorithmLabels);
        lb_aliceRootChain3.setText(aliceRootChainLabel3);

        //
        // Sending Chain
        //
        grp_aliceSendingChain.setText(SendingChainDescription);
        grp_aliceSendingChain.setLayout(gl_aliceSendingChainComposite);
        grp_aliceSendingChain.setLayoutData(gd_aliceSendingChainComposite);
        
        cmp_aliceSendingChain.setLayout(gl_aliceSendingChainComposite);
        cmp_aliceSendingChain.setLayoutData(gd_aliceSendingChainComposite);
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE);    
        
        lb_aliceSendingChain1 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain1.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain1.setText(aliceSendingChainLabel1);
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE); 
        
        lb_aliceSendingChain1 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain1.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain1.setText(aliceSendingChainLabel1);


        lb_aliceSendingChain2 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain2.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain2.setText(aliceSendingChainLabel2);
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE); 
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE);
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE);

        lb_aliceSendingChain3 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain3.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain3.setText(aliceSendingChainLabel3);
        
        // empty label for filling space
        new Label(cmp_aliceSendingChain, SWT.NONE); 
        
        lb_aliceSendingChain4 = new Label(cmp_aliceSendingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceSendingChain4.setLayoutData(gd_algorithmLabels);
        lb_aliceSendingChain4.setText(aliceSendingChainLabel4);
        
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
        
        lb_aliceReceivingChain1 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain1.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain1.setText(aliceReceivingChainLabel1);


        lb_aliceReceivingChain2 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain2.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain2.setText(aliceReceivingChainLabel2);
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE); 
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE);
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE);

        lb_aliceReceivingChain3 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain3.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain3.setText(aliceReceivingChainLabel3);
        
        // empty label for filling space
        new Label(cmp_aliceReceivingChain, SWT.NONE); 
        
        lb_aliceReceivingChain4 = new Label(cmp_aliceReceivingChain, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceReceivingChain4.setLayoutData(gd_algorithmLabels);
        lb_aliceReceivingChain4.setText(aliceReceivingChainLabel4);
    }
    
}
