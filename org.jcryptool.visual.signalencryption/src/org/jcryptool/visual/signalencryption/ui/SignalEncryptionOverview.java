/**
 * 
 */
package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TableColumn;


    
public class SignalEncryptionOverview extends Composite {

	
    private Composite parameterComposite;

    private GridLayout parameterCompositeLayout;

    private Group parameterGroup;
    // private Group publicKeyGroup;

    private Text label_a;
    private Text label_b;
    private Text label_c;
    private Text label_d;
    private Text label_e;
    private Text label_f;
    private Text text_a;
    private Text text_b;
    private Text text_c;
    private Text text_d;
    private Text text_e;
    private Text text_f;
	
	public SignalEncryptionOverview (final Composite parent, final int style) {
		super(parent,SWT.NONE);
		createBody();
	}
    private void createBody() {
        setLayout(new GridLayout(1, false));
        final Composite bodyComposite = new Composite(this, SWT.NONE);
        GridLayout gl_bodyComposite = new GridLayout();
        gl_bodyComposite.marginWidth = 0;
        gl_bodyComposite.marginHeight = 0;
        bodyComposite.setLayout(gl_bodyComposite);

        createParameterBody(bodyComposite);
        
    }

    /**
     * Creates the parameter body, including parameter and description group.
     */
    private void createParameterBody(Composite parent) {
        parameterComposite = new Composite(parent, SWT.NONE);
        parameterComposite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        parameterCompositeLayout = new GridLayout(2, false);
        parameterCompositeLayout.marginWidth = 0;
        parameterCompositeLayout.marginHeight = 0;
        parameterComposite.setLayout(parameterCompositeLayout);
        GridData gd_parameterComposite = new GridData(SWT.NONE, SWT.TOP, true, false);
        gd_parameterComposite.widthHint = 832;
        parameterComposite.setLayoutData(gd_parameterComposite);

        createParameterGroup(parameterComposite);
        new Label(parameterComposite, SWT.NONE);
        new Label(parameterComposite, SWT.NONE);
        new Label(parameterComposite, SWT.NONE);

    }
    
    private void createParameterGroup(Composite parent) {
    	
    	parameterGroup = new Group(parent, SWT.NONE);
    	GridData gd_parameterGroup = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
    	parameterGroup.setLayoutData(gd_parameterGroup);
        parameterGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        parameterGroup.setLayout(new GridLayout(2, false));
        GridData gd_parameterGroup = new GridData(SWT.FILL, SWT.FILL, true, true);
        
        label_a = new Text(parameterGroup, SWT.READ_ONLY | SWT.CURSOR_ARROW);
        label_a.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_a.setText("Schlüssel");
        new Label(parameterGroup, SWT.NONE);

        text_a = new Text(parameterGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_a.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        text_a.setText("Beschreibung");
        
        label_b = new Text(parameterGroup, SWT.READ_ONLY | SWT.CURSOR_ARROW);
        label_b.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_b.setText("Diffie Hellman Key Pair");
        new Label(parameterGroup, SWT.NONE);

        text_b = new Text(parameterGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_b.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        text_b.setText("Besteht aus einem öffentlichen und privaten Teil.");
        
        label_c = new Text(parameterGroup, SWT.READ_ONLY | SWT.CURSOR_ARROW);
        label_c.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_c.setText("Shared Secret Key");
        new Label(parameterGroup, SWT.NONE);

        text_c = new Text(parameterGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_c.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        text_c.setText("Geheimer Schlüssel der von den Kommunikationspartnern mittels einem vereinbarten Schlüsselaustausch erstellt wird. Dieser Schlüssel dient als erster Schlüssel");
        
        label_d = new Text(parameterGroup, SWT.READ_ONLY | SWT.CURSOR_ARROW);
        label_d.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_d.setText("Root Chain Key");
        new Label(parameterGroup, SWT.NONE);

        text_d = new Text(parameterGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_d.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        text_d.setText("");
        
        label_e = new Text(parameterGroup, SWT.READ_ONLY);
        label_e.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_e.setText("Sending Chain Key");
        new Label(parameterGroup, SWT.NONE);

        text_e = new Text(parameterGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_e.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        text_e.setText("");
        
        label_f = new Text(parameterGroup, SWT.READ_ONLY | SWT.CURSOR_ARROW);
        label_f.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_f.setText("Receiving Chain Key");
        new Label(parameterGroup, SWT.NONE);

        text_f = new Text(parameterGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_f.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        text_f.setText("");
    }
}