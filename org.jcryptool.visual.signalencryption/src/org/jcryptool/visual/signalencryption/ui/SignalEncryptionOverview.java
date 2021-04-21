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


public class SignalEncryptionOverview {
    
    
    public SignalEncryptionOverview() {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        
        createChildren(shell);
        
        shell.pack();
        
        Composite composite = new Composite(shell, SWT.NONE);
        composite.setSize(new Point(600, 600));
        composite.setLayout(new RowLayout(SWT.HORIZONTAL));
        
        Label lblNewLabel = new Label(composite, SWT.BORDER);
        lblNewLabel.setAlignment(SWT.CENTER);
        lblNewLabel.setLocation(new Point(30, 50));
        lblNewLabel.setLayoutData(new RowData(68, 23));
        lblNewLabel.setText("Other Key");
        
        Label lblNewLabel_1 = new Label(composite, SWT.BORDER);
        lblNewLabel_1.setAlignment(SWT.CENTER);
        lblNewLabel_1.setLayoutData(new RowData(59, 19));
        lblNewLabel_1.setText("Root Key");
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    
    private void createChildren(Shell parent) {
        SignalEncryptionOverview instance = this;
    }
}