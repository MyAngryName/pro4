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


public class SignalEncryptionArrows extends Canvas {  
    
 public SignalEncryptionArrows(Composite parent, int style) {
        super(parent, style);
    }

    /*   
    public void setArrowData(int arrowWidth, int arrowHeadWidth) {
        this.arrowWidth = arrowWidth;
        this.arrowHeadWidth = arrowHeadWidth;
    }
*/
    public static GridData canvasData(int horizonalAlignment, int verticalAlignment, boolean grabExcessHorizontal, boolean grabExcessVertical, int horizontalSpan, int verticalSpan, int width) {
        var gridData = new GridData(horizonalAlignment, verticalAlignment, grabExcessHorizontal, grabExcessVertical, horizontalSpan, verticalSpan);
        gridData.widthHint = width;
        return gridData;
    }

    public static Path drawRightArrow(Canvas canvas, int arrowWidth, int arrowHeadWidth) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = width - 0.2f * width;
        
        float lowerLineY = (height / 2) - (arrowWidth / 2);
        float upperLineY = (height / 2) + (arrowWidth / 2);

        float lowerArrowHeadY = (height / 2) - (arrowHeadWidth / 2);
        float upperArrowHeadY = (height / 2) + (arrowHeadWidth / 2);


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
    
    public  static Path drawLeftArrow(Canvas canvas, int arrowWidth, int arrowHeadWidth) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = width + 0.2f * width;
        
        float lowerLineY = (height / 2) - (arrowWidth / 2);
        float upperLineY = (height / 2) + (arrowWidth / 2);

        float lowerArrowHeadY = (height / 2) - (arrowHeadWidth / 2);
        float upperArrowHeadY = (height / 2) + (arrowHeadWidth / 2);


        resultPath.moveTo(width, lowerLineY);
        resultPath.lineTo(width, upperLineY);
        resultPath.lineTo(baseLength, upperLineY);
        resultPath.lineTo(baseLength, upperArrowHeadY);
        resultPath.lineTo(width, height / 2);
        resultPath.lineTo(baseLength, lowerArrowHeadY);
        resultPath.lineTo(baseLength, lowerLineY);
        resultPath.lineTo(width, lowerLineY);
        return resultPath;
    }
    
    public  static Path drawDownArrow(Canvas canvas, int arrowWidth, int arrowHeadWidth) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = height - 0.2f * height;
        
        float leftLineY = (width / 2) - (arrowWidth / 2);
        float rightLineY = (width / 2) + (arrowWidth / 2);
        
        
        float leftArrowLineY = (width / 2) - (arrowHeadWidth / 2);
        float rightArrowLineY = (width / 2) + (arrowHeadWidth / 2);
        
        
        resultPath.moveTo(leftLineY, height);
        resultPath.lineTo(leftLineY, baseLength);
        resultPath.lineTo(leftLineY, leftArrowLineY);
        resultPath.lineTo(width/2, 0);
        resultPath.lineTo(rightArrowLineY, baseLength);
        resultPath.lineTo(rightLineY, baseLength);
        resultPath.lineTo(rightLineY, height);
        resultPath.lineTo(leftLineY, height);

        
        return resultPath;
    }
    
    public static Path drawUpArrow (Canvas canvas, int arrowWidth, int arrowHeadWidth) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = height + 0.2f * height;
        
        float leftLineY = (width / 2) - (arrowWidth / 2);
        float rightLineY = (width / 2) + (arrowWidth / 2);
        
        
        float leftArrowLineY = (width / 2) - (arrowHeadWidth / 2);
        float rightArrowLineY = (width / 2) + (arrowHeadWidth / 2);
        
        resultPath.moveTo(leftLineY, 0);
        resultPath.lineTo(leftLineY, baseLength);
        resultPath.lineTo(width/2, height);
        resultPath.lineTo(rightArrowLineY, baseLength);
        resultPath.lineTo(rightLineY, baseLength);
        resultPath.lineTo(rightLineY, 0);
        resultPath.lineTo(leftLineY, 0);
        
        return resultPath;
    }

}
