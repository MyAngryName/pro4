package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.custom.CBanner;

/**
 * 
 * @author Dan-Kerko Ciudin
 * 
 * 
 */

public class SignalEncryptionViewDoubleRatchet extends Composite {

    private TitleAndDescriptionComposite titleAndDescription;

    private GridData gd_aliceComposite;
    private GridData gd_bobComposite;

    SignalEncryptionViewDoubleRatchet(Composite parent, int style) {
        super(parent, style);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.horizontalSpacing = 3;
        gridLayout.verticalSpacing = 0;
        setLayout(gridLayout);

        Button btnAlice = new Button(this, SWT.NONE);
        GridData gd_btnAlice = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
        gd_btnAlice.widthHint = 150;
        btnAlice.setLayoutData(gd_btnAlice);

        btnAlice.setText("Alice");

        Button btnBob = new Button(this, SWT.RIGHT);
        btnBob.setAlignment(SWT.CENTER);
        GridData gd_btnBob = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
        gd_btnBob.widthHint = 150;
        btnBob.setLayoutData(gd_btnBob);
        btnBob.setText("Bob");
        
        Composite composite = new Composite(this, SWT.NONE);
        composite.setLayout(new StackLayout());
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 14, 1));
        
        Composite composite_1 = new Composite(composite, SWT.NONE);
        
        Composite composite_2 = new Composite(composite, SWT.NONE);
        // setLayout(new StackLayout());

        createAliceComposite();
        createBobComposite();

    }

    private void createBobComposite() {
        // TODO Auto-generated method stub

    }

    private void createAliceComposite() {
        // TODO Auto-generated method stub

    }
}
