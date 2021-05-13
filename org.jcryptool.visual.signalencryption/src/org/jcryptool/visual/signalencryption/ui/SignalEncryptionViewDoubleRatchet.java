package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
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

    private Button btn_Alice;
    private Button btn_Bob;

    private Group grp_aliceSteps;
    private Group grp_aliceAlgorithm;
    private Group grp_bobAlgorithm;
    private Group grp_bobSteps;
    private Group grp_aliceDiffieHellman;
    private Group grp_aliceRootChain;
    private Group grp_aliceReceivingChain;
    private Group grp_aliceSendingChain;
    private Group grp_bobDiffieHellman;
    private Group grp_bobSendingChain;
    private Group grp_bobReceivingChain;
    private Group grp_bobRootChain;

    private String AlgorithmGroupDescription = "Algorithmus";
    private String stepGroupDescription = "Aktueller Schritt";
    private String DiffieHellmanGroupDescription = "Diffie Hellman Schlüsselaustausch (DH)";
    private String RootChainDescription = "Root Chain";
    private String SendingChainDescription = "Sending Chain";
    private String ReceivingChainDescription = "Receiving Chain";

    private GridLayout gl_parent;
    private GridLayout gl_aliceDiffieHellman;
    private GridLayout gl_aliceComposite;
    private GridLayout gl_bobComposite;
    private GridLayout gl_aliceAlgorithm;
    private GridLayout gl_aliceRootChain;
    private GridLayout gl_aliceSendingChain;
    private GridLayout gl_aliceReceivingChain;
    private GridLayout gl_bobAlgorithm;
    private GridLayout gl_bobRootChain;
    private GridLayout gl_bobReceivingChain;
    private GridLayout gl_bobDiffieHellman;
    private GridLayout gl_bobSendingChain;
    private RowLayout rl_aliceSteps;
    private RowLayout rl_bobSteps;

    private GridData gd_aliceAlgorithm;
    private GridData gd_AliceSteps;

    private GridData gd_bobAlgorithm;
    private GridData gd_bobSteps;
    private GridData gd_btnAlice;
    private GridData gd_btnBob;
    private GridData gd_aliceDiffieHellman;
    private GridData gd_aliceRootChain;
    private GridData gd_aliceSendingChain;
    private GridData gd_aliceReceivingChain;
    private GridData gd_algorithmLabels;
    private GridData gd_bobDiffieHellman;
    private GridData gd_bobRootChain;
    private GridData gd_bobSendingChain;
    private GridData gd_bobReceivingChain;

    private Label lb_aliceDiffieHellman1;
    private Label lb_aliceDiffieHellman2;
    private Label lb_aliceDiffieHellman3;
    private Label lb_bobDiffieHellman1;
    private Label lb_bobDiffieHellman2;
    private Label lb_bobDiffieHellman3;

    private String aliceDiffieHellmanLabel1 = "Bob's DH öffentlicher Schlüssel";
    private String aliceDiffieHellmanLabel2 = "DH Schlüsselaustausch";
    private String aliceDiffieHellmanLabel3 = "Alice' DH Schlüsselpaar";
    private String bobDiffieHellmanLabel1 = "Alice' DH öffentlicher Schlüssel";
    private String bobDiffieHellmanLabel2 = "DH Schlüsselaustausch";
    private String bobDiffieHellmanLabel3 = "Bob's DH Schlüsselpaar";
//    private String aliceStep1 = ""

    SignalEncryptionViewDoubleRatchet(Composite parent, int style) {
        super(parent, style);
        gl_parent = new GridLayout(2, false);
        gl_parent.horizontalSpacing = 3;
        gl_parent.verticalSpacing = 0;
        setLayout(gl_parent);

        // style data for the labels within the algorithm
        gd_algorithmLabels = new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1);
        gd_algorithmLabels.verticalIndent = 10;
        gd_algorithmLabels.widthHint = 150;
        gd_algorithmLabels.heightHint = 50;

//        setTitleAndDescription();
        createButtons();
        createMainComposite();
        createAliceComposite();
        createBobComposite();

    }

//    private void setTitleAndDescription() {
//
//        titleAndDescription = new TitleAndDescriptionComposite(this);
//        titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
//        titleAndDescription.setTitle("Title");
//        titleAndDescription.setDescription("Description");
//    }

    private void createMainComposite() {

        cmp_main = new Composite(this, SWT.NONE);
        cmp_main.setLayout(new StackLayout());
        cmp_main.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 14, 1));

    }

    private void createButtons() {

        btn_Alice = new Button(this, SWT.LEFT);
        btn_Alice.setAlignment(SWT.CENTER);

        gd_btnAlice = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_btnAlice.widthHint = 150;
        btn_Alice.setLayoutData(gd_btnAlice);
        btn_Alice.setText("Alice");

        btn_Alice.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showAliceView();

            }
        });

        btn_Bob = new Button(this, SWT.RIGHT);
        btn_Bob.setAlignment(SWT.CENTER);
        gd_btnBob = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
        gd_btnBob.widthHint = 150;
        btn_Bob.setLayoutData(gd_btnBob);
        btn_Bob.setText("Bob");

        btn_Bob.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showBobView();

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
        grp_bobSendingChain = new Group(grp_bobAlgorithm, SWT.CENTER);
        grp_bobReceivingChain = new Group(grp_bobAlgorithm, SWT.CENTER);
        grp_bobRootChain = new Group(grp_bobAlgorithm, SWT.CENTER);
        grp_bobDiffieHellman = new Group(grp_bobAlgorithm, SWT.CENTER);

        gl_bobComposite = new GridLayout(2, false);
        gl_bobAlgorithm = new GridLayout(4, false);
        rl_bobSteps = new RowLayout(SWT.HORIZONTAL);
        gl_bobDiffieHellman = new GridLayout(3, false);
        gl_bobRootChain = new GridLayout(3, false);
        gl_bobSendingChain = new GridLayout(3, false);
        gl_bobReceivingChain = new GridLayout(3, false);

        gd_bobAlgorithm = new GridData(SWT.RIGHT, SWT.TOP, true, true, 1, 1);
        gd_bobSteps = new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1);
        gd_bobDiffieHellman = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_bobRootChain = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_bobSendingChain = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_bobReceivingChain = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);

        cmp_bob.setLayout(gl_bobComposite);

        grp_bobSteps.setText(stepGroupDescription);
        grp_bobSteps.setLayout(rl_bobSteps);
        grp_bobSteps.setLayoutData(gd_bobSteps);

        grp_bobAlgorithm.setText(AlgorithmGroupDescription);
        grp_bobAlgorithm.setLayout(gl_bobAlgorithm);
        grp_bobAlgorithm.setLayoutData(gd_bobAlgorithm);

        grp_bobSendingChain.setText(SendingChainDescription);
        grp_bobSendingChain.setLayout(gl_bobSendingChain);
        grp_bobSendingChain.setLayoutData(gd_bobSendingChain);

        grp_bobReceivingChain.setText(ReceivingChainDescription);
        grp_bobReceivingChain.setLayout(gl_bobReceivingChain);
        grp_bobReceivingChain.setLayoutData(gd_bobReceivingChain);

        grp_bobRootChain.setText(RootChainDescription);
        grp_bobRootChain.setLayout(gl_bobRootChain);
        grp_bobRootChain.setLayoutData(gd_bobRootChain);

        grp_bobDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_bobDiffieHellman.setLayout(gl_bobDiffieHellman);
        grp_bobDiffieHellman.setLayoutData(gd_bobDiffieHellman);

        lb_bobDiffieHellman1 = new Label(grp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman1.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman1.setText(bobDiffieHellmanLabel1);
        lb_bobDiffieHellman1.setLayoutData(gd_algorithmLabels);
        new Label(grp_bobDiffieHellman, SWT.NONE);
        new Label(grp_bobDiffieHellman, SWT.NONE);

        lb_bobDiffieHellman2 = new Label(grp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman2.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman2.setText(bobDiffieHellmanLabel2);
        lb_bobDiffieHellman2.setLayoutData(gd_algorithmLabels);
        new Label(grp_bobDiffieHellman, SWT.NONE);
        new Label(grp_bobDiffieHellman, SWT.NONE);

        lb_bobDiffieHellman3 = new Label(grp_bobDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_bobDiffieHellman3.setLayoutData(gd_algorithmLabels);
        lb_bobDiffieHellman3.setText(bobDiffieHellmanLabel3);
        lb_bobDiffieHellman3.setLayoutData(gd_algorithmLabels);

    }

    private void createAliceComposite() {

        // Init of the widgets, layouts and data needed
        cmp_alice = new Composite(cmp_main, SWT.NONE);
        grp_aliceAlgorithm = new Group(cmp_alice, SWT.CENTER);
        grp_aliceSteps = new Group(cmp_alice, SWT.CENTER);
        grp_aliceDiffieHellman = new Group(grp_aliceAlgorithm, SWT.CENTER);
        grp_aliceRootChain = new Group(grp_aliceAlgorithm, SWT.CENTER);
        grp_aliceSendingChain = new Group(grp_aliceAlgorithm, SWT.CENTER);
        grp_aliceReceivingChain = new Group(grp_aliceAlgorithm, SWT.CENTER);

        gl_aliceComposite = new GridLayout(2, false);
        gl_aliceAlgorithm = new GridLayout(4, false);
        rl_aliceSteps = new RowLayout(SWT.HORIZONTAL);
        gl_aliceDiffieHellman = new GridLayout(3, false);
        gl_aliceRootChain = new GridLayout(3, false);
        gl_aliceSendingChain = new GridLayout(3, false);
        gl_aliceReceivingChain = new GridLayout(3, false);

        gd_aliceAlgorithm = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_AliceSteps = new GridData(SWT.LEFT, SWT.TOP, false, true, 1, 1);
        gd_aliceDiffieHellman = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceRootChain = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceSendingChain = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);
        gd_aliceReceivingChain = new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1);

        cmp_alice.setLayout(gl_aliceComposite);

        grp_aliceAlgorithm.setText(AlgorithmGroupDescription);
        grp_aliceAlgorithm.setLayout(gl_aliceAlgorithm);
        grp_aliceAlgorithm.setLayoutData(gd_aliceAlgorithm);

        grp_aliceSteps.setText(stepGroupDescription);
        grp_aliceSteps.setLayout(rl_aliceSteps);
        grp_aliceSteps.setLayoutData(gd_AliceSteps);

        grp_aliceDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_aliceDiffieHellman.setLayout(gl_aliceDiffieHellman);
        grp_aliceDiffieHellman.setLayoutData(gd_aliceDiffieHellman);

        lb_aliceDiffieHellman1 = new Label(grp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman1.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman1.setText(aliceDiffieHellmanLabel1);
        lb_aliceDiffieHellman1.setLayoutData(gd_algorithmLabels);
        new Label(grp_aliceDiffieHellman, SWT.NONE);
        new Label(grp_aliceDiffieHellman, SWT.NONE);

        lb_aliceDiffieHellman2 = new Label(grp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman2.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman2.setText(aliceDiffieHellmanLabel2);
        lb_aliceDiffieHellman2.setLayoutData(gd_algorithmLabels);
        new Label(grp_aliceDiffieHellman, SWT.NONE);
        new Label(grp_aliceDiffieHellman, SWT.NONE);

        lb_aliceDiffieHellman3 = new Label(grp_aliceDiffieHellman, SWT.BORDER | SWT.WRAP | SWT.CENTER);
        lb_aliceDiffieHellman3.setLayoutData(gd_algorithmLabels);
        lb_aliceDiffieHellman3.setText(aliceDiffieHellmanLabel3);
        lb_aliceDiffieHellman3.setLayoutData(gd_algorithmLabels);

        grp_aliceRootChain.setText(RootChainDescription);
        grp_aliceRootChain.setLayout(gl_aliceRootChain);
        grp_aliceRootChain.setLayoutData(gd_aliceRootChain);

        grp_aliceSendingChain.setText(SendingChainDescription);
        grp_aliceSendingChain.setLayout(gl_aliceSendingChain);
        grp_aliceSendingChain.setLayoutData(gd_aliceSendingChain);

        grp_aliceReceivingChain.setText(ReceivingChainDescription);
        grp_aliceReceivingChain.setLayout(gl_aliceReceivingChain);
        grp_aliceReceivingChain.setLayoutData(gd_aliceReceivingChain);

    }
}
