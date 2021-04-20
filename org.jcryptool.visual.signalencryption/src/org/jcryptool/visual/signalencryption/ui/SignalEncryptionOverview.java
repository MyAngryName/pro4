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
    
    private static int ARROW_WIDTH = 10;
    private static int ARROW_HEAD_WIDTH = 20;

    /**
     * A simple state machine based on enum and enum methods.
     *
     * Use {@link STATE#next(SignalEncryptionOverview)} and {@link STATE#back(SignalEncryptionOverview)} to switch states.
     */
    private enum STATE {
        STEP_1 {
            @Override
            protected void switchState(SignalEncryptionOverview parent) {
                System.out.println("Switching to state 1");
            parent.stepTwoDescription.setVisible(false);
            parent.arrowCanvas.setVisible(false);
            parent.back.setEnabled(false);
            parent.next.setEnabled(true);
            }

            @Override
            STATE next(SignalEncryptionOverview parent) {
                STEP_2.switchState(parent);
                return STEP_2;
            }

            @Override
            STATE back(SignalEncryptionOverview parent) {
                return STEP_1;
            }
        }, STEP_2 {
            @Override
            protected void switchState(SignalEncryptionOverview parent) {
                System.out.println("Switching to state 2");
                parent.stepTwoDescription.setVisible(true);
                parent.arrowCanvas.setVisible(true);
                parent.next.setEnabled(false);
                parent.back.setEnabled(true);
            }

            @Override
            STATE next(SignalEncryptionOverview parent) {
                return STEP_1;
            }

            @Override
            STATE back(SignalEncryptionOverview parent) {
                STEP_1.switchState(parent);
                return STEP_1;
            }
        };
        
        protected abstract void switchState(SignalEncryptionOverview parent);
        abstract STATE next(SignalEncryptionOverview parent);
        abstract STATE back(SignalEncryptionOverview parent);
        
        public STATE setInitialState(SignalEncryptionOverview parent) {
            STEP_1.switchState(parent);
            return STEP_1;
        }
        
        };
    private STATE currentState = STATE.STEP_1;

    /*
     * Create GridData object and give it a widthHint (how large the component would like to be).
     */
    private GridData gridDataWidth(int horizonalAlignment, int verticalAlignment, boolean grabExcessHorizontal, boolean grabExcessVertical, int horizontalSpan, int verticalSpan, int width) {
    }

    /*
     * Draw an arrow on the canvas (from left to right)
     */
    static Path drawArrow(Canvas canvas) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = width - 0.2f * width;
        
        float lowerLineY = (height / 2) - (ARROW_WIDTH / 2);
        float upperLineY = (height / 2) + (ARROW_WIDTH / 2);

        float lowerArrowHeadY = (height / 2) - (ARROW_HEAD_WIDTH / 2);
        float upperArrowHeadY = (height / 2) + (ARROW_HEAD_WIDTH / 2);


        resultPath.moveTo(0, lowerLineY);
        resultPath.lineTo(0, upperLineY);
        resultPath.lineTo(baseLength, upperLineY);
        resultPath.lineTo(baseLength, upperArrowHeadY);
        resultPath.lineTo(width, height / 2);
        resultPath.lineTo(baseLength, lowerArrowHeadY);
        resultPath.lineTo(baseLength, lowerLineY);
        resultPath.lineTo(0, lowerLineY);
        return resultPath;
    }
    
    public SignalEncryptionOverview() {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        
        createChildren(shell);
        currentState = STATE.STEP_1.setInitialState(this);
        
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