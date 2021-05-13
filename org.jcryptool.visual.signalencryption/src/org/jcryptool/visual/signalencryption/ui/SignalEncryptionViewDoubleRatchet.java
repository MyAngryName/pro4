package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

/**
 * 
 * @author Dan-Kerko Ciudin
 * 
 * 
 */

public class SignalEncryptionViewDoubleRatchet extends Composite {

    private TitleAndDescriptionComposite titleAndDescription;

    private Composite composite;
    private Composite cmp_alice;
    private Composite cmp_bob;
    
    private Button btnAlice;
    private Button btnBob;
    

    private Group grp_aliceSteps;

    private Group grp_aliceAlgorithm;

    private Group grp_bobAlgorithm;
    
    

    

    SignalEncryptionViewDoubleRatchet(Composite parent, int style) {
        super(parent, style);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.horizontalSpacing = 3;
        gridLayout.verticalSpacing = 0;
        setLayout(gridLayout);

        
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
        
        composite = new Composite(this, SWT.NONE);
        composite.setLayout(new StackLayout());
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 14, 1));
        
        
    }

    private void createButtons() {
        
        btnAlice = new Button(this, SWT.LEFT);
        btnAlice.setAlignment(SWT.CENTER);

        GridData gd_btnAlice = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_btnAlice.widthHint = 150;
        btnAlice.setLayoutData(gd_btnAlice);
        btnAlice.setText("Alice");
        
        btnAlice.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showAliceView();
                
            }
        });

        btnBob = new Button(this, SWT.RIGHT);
        btnBob.setAlignment(SWT.CENTER);
        GridData gd_btnBob = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
        gd_btnBob.widthHint = 150;
        btnBob.setLayoutData(gd_btnBob);
        btnBob.setText("Bob");
        
        btnBob.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showBobView();
                
            }
        });
    }

    protected void showBobView() {
        StackLayout layout=(StackLayout) this.composite.getLayout();
        layout.topControl = this.cmp_bob;
        this.composite.layout();
        
    }

    protected void showAliceView() {
        StackLayout layout=(StackLayout) this.composite.getLayout();
        layout.topControl = this.cmp_alice;
        this.composite.layout();
        
    }

    private void createBobComposite() { 
        
       
        cmp_bob = new Composite(composite, SWT.NONE);
        cmp_bob.setLayout(new GridLayout(1, false));
        
        grp_bobAlgorithm = new Group(cmp_bob, SWT.NONE);
        grp_bobAlgorithm.setLayout(new GridLayout(1, false));


    }

    private void createAliceComposite() {
        
        cmp_alice = new Composite(composite, SWT.NONE);
        GridLayout gl_aliceComposite = new GridLayout(3, false);
        cmp_alice.setLayout(gl_aliceComposite);
        
        grp_aliceAlgorithm = new Group(cmp_alice, SWT.LEFT);
        grp_aliceAlgorithm.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));


        grp_aliceSteps = new Group(cmp_alice, SWT.RIGHT);
        grp_aliceSteps.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 3, 1));
        new Label(cmp_alice, SWT.NONE);
        new Label(cmp_alice, SWT.NONE);
        new Label(cmp_alice, SWT.NONE);

    }
}
