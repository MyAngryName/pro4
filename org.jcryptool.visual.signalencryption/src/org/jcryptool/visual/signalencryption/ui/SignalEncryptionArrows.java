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
     * public void setArrowData(int arrowWidth, int arrowHeadWidth) { this.arrowWidth = arrowWidth;
     * this.arrowHeadWidth = arrowHeadWidth; }
     */
    public static GridData canvasData(int horizonalAlignment, int verticalAlignment, boolean grabExcessHorizontal,
            boolean grabExcessVertical, int horizontalSpan, int verticalSpan, int width) {
        var gridData = new GridData(horizonalAlignment, verticalAlignment, grabExcessHorizontal, grabExcessVertical,
                horizontalSpan, verticalSpan);
        gridData.widthHint = width;
        return gridData;
    }
    private final static float arrowHeadSize = 12;

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
        resultPath.lineTo(baseLength + arrowHeadSize, height / 2);
        resultPath.lineTo(baseLength, lowerArrowHeadY);
        resultPath.lineTo(baseLength, lowerLineY);
        resultPath.lineTo(0, lowerLineY);
        
        return resultPath;
    }

    public static Path drawLeftArrow(Canvas canvas, int arrowWidth, int arrowHeadWidth) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = 0.2f * width;
        

        float lowerLineY = (height / 2) - (arrowWidth / 2);
        float upperLineY = (height / 2) + (arrowWidth / 2);

        float lowerArrowHeadY = (height / 2) - (arrowHeadWidth / 2);
        float upperArrowHeadY = (height / 2) + (arrowHeadWidth / 2);

        resultPath.moveTo(width, lowerLineY);
        resultPath.lineTo(width, upperLineY);
        resultPath.lineTo(baseLength, upperLineY);
        resultPath.lineTo(baseLength, upperArrowHeadY);
        resultPath.lineTo(baseLength - arrowHeadSize, height / 2);
        resultPath.lineTo(baseLength, lowerArrowHeadY);
        resultPath.lineTo(baseLength, lowerLineY);
        resultPath.lineTo(width, lowerLineY);
        
        return resultPath;
    }
    
    public  static Path drawUpArrow(Canvas canvas, int arrowWidth, int arrowHeadWidth) {

        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = 0.2f * height;

        float leftLineY = (width / 2) - (arrowWidth / 2);
        float rightLineY = (width / 2) + (arrowWidth / 2);

        float leftArrowLineY = (width / 2) - (arrowHeadWidth / 2);
        float rightArrowLineY = (width / 2) + (arrowHeadWidth / 2);

        resultPath.moveTo(leftLineY, height);
        resultPath.lineTo(leftLineY, baseLength);
        resultPath.lineTo(leftArrowLineY, baseLength);
        resultPath.lineTo(width/2,baseLength - arrowHeadSize);
        resultPath.lineTo(rightArrowLineY, baseLength);
        resultPath.lineTo(rightLineY, baseLength);
        resultPath.lineTo(rightLineY, height);
        resultPath.lineTo(leftLineY, height);
        
        return resultPath;
    }
    
    public static Path drawDownArrow (Canvas canvas, int arrowWidth, int arrowHeadWidth) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = height - 0.2f * height;
        

        float leftLineY = (width / 2) - (arrowWidth / 2);
        float rightLineY = (width / 2) + (arrowWidth / 2);

        float leftArrowLineY = (width / 2) - (arrowHeadWidth / 2);
        float rightArrowLineY = (width / 2) + (arrowHeadWidth / 2);

        resultPath.moveTo(leftLineY, 0);
        resultPath.lineTo(leftLineY, baseLength);
        resultPath.lineTo(leftArrowLineY, baseLength);
        resultPath.lineTo(width/2, baseLength + arrowHeadSize);
        resultPath.lineTo(rightArrowLineY, baseLength);
        resultPath.lineTo(rightLineY, baseLength);
        resultPath.lineTo(rightLineY, 0);
        resultPath.lineTo(leftLineY, 0);

        return resultPath;
    }
    
    public static Path drawDownRightArrow(Canvas canvas, int arrowWidth, int arrowHeadWidth) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = height - 0.2f * height;
        float baseLengthSecond = width - 0.2f * width;
        

        float leftLineY = (width / 2) - (arrowWidth / 2);
        float rightLineY = (width / 2) + (arrowWidth / 2);

        float leftArrowLineY = (width / 2) - (arrowHeadWidth / 2);
        float rightArrowLineY = (width / 2) + (arrowHeadWidth / 2);
        
        float lowerLineY = (height / 2) - (arrowWidth / 2);
        float upperLineY = (height / 2) + (arrowWidth / 2);

        float lowerArrowHeadY = (height / 2) - (arrowHeadWidth / 2);
        float upperArrowHeadY = (height / 2) + (arrowHeadWidth / 2);

        resultPath.moveTo(leftLineY, 0);
        resultPath.lineTo(leftLineY, baseLength);
        resultPath.lineTo(leftArrowLineY, baseLength);
        resultPath.lineTo(width/2, baseLength + arrowHeadSize);
        resultPath.lineTo(rightArrowLineY, baseLength);
        resultPath.lineTo(rightLineY, baseLength);
        resultPath.lineTo(rightLineY, lowerLineY);
        resultPath.lineTo(baseLengthSecond, lowerLineY);
        resultPath.lineTo(baseLengthSecond, lowerArrowHeadY);
        resultPath.lineTo(baseLengthSecond + arrowHeadSize, height / 2);
        resultPath.lineTo(baseLengthSecond, upperArrowHeadY);
        resultPath.lineTo(baseLengthSecond, upperLineY);
        resultPath.lineTo(rightLineY, upperLineY);
        resultPath.lineTo(rightLineY, 0);
        resultPath.lineTo(leftLineY, 0);

        return resultPath;
    }
    public static Path drawDownLeftArrow(Canvas canvas, int arrowWidth, int arrowHeadWidth) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = height - 0.2f * height;
        float baseLengthSecond =  0.2f * width;
        

        float leftLineY = (width / 2) - (arrowWidth / 2);
        float rightLineY = (width / 2) + (arrowWidth / 2);

        float leftArrowLineY = (width / 2) - (arrowHeadWidth / 2);
        float rightArrowLineY = (width / 2) + (arrowHeadWidth / 2);
        
        float lowerLineY = (height / 2) - (arrowWidth / 2);
        float upperLineY = (height / 2) + (arrowWidth / 2);

        float lowerArrowHeadY = (height / 2) - (arrowHeadWidth / 2);
        float upperArrowHeadY = (height / 2) + (arrowHeadWidth / 2);

        resultPath.moveTo(leftLineY, 0);
        
        resultPath.lineTo(leftLineY, upperLineY);
        resultPath.lineTo(baseLengthSecond, upperLineY);
        resultPath.lineTo(baseLengthSecond, upperArrowHeadY);
        resultPath.lineTo(baseLengthSecond - arrowHeadSize, height / 2);
        resultPath.lineTo(baseLengthSecond, lowerArrowHeadY);
        resultPath.lineTo(baseLengthSecond, lowerLineY);
        resultPath.lineTo(leftLineY, lowerLineY);
        
        resultPath.lineTo(leftLineY, baseLength);
        resultPath.lineTo(leftArrowLineY, baseLength);
        resultPath.lineTo(width/2, baseLength + arrowHeadSize);
        resultPath.lineTo(rightArrowLineY, baseLength);
        resultPath.lineTo(rightLineY, baseLength);
        resultPath.lineTo(rightLineY, 0);
        resultPath.lineTo(leftLineY, 0);

        return resultPath;
    }
    public  static Path drawVertikalLine(Canvas canvas, int arrowWidth, int arrowHeadWidth, int percentValue) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        
        float percent = (float)percentValue / 100;
        
        float lineWidthRight = width * percent+ arrowWidth/2 ;
        float lineWidthLeft = width * percent - arrowWidth/2;
        
        resultPath.moveTo(lineWidthRight, 0);
        resultPath.lineTo(lineWidthRight, height);
        resultPath.lineTo(lineWidthLeft, height);
        resultPath.lineTo(lineWidthLeft, 0);


        return resultPath;
    }
    public  static Path drawHorizontalLine(Canvas canvas, int arrowWidth, int arrowHeadWidth, int percentValue) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        
        float percent = (float)percentValue / 100;
        float lineWidthRight = height * percent + arrowWidth/2;
        float lineWidthLeft = height * percent - arrowWidth/2 ;
        
        resultPath.moveTo(0, lineWidthRight);
        resultPath.lineTo(width, lineWidthRight);
        resultPath.lineTo( width, lineWidthLeft);
        resultPath.lineTo(0, lineWidthLeft);

        return resultPath;
    }
    
    public static Path drawRightUpRightArrowHeadless(Canvas canvas, int arrowWidth, int arrowHeadWidth, int secondHeight) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = width - 0.2f * width;

        float lowerLineY = (height / 2) + (arrowWidth / 2) + (secondHeight / 2);
        float upperLineY = (height / 2) - (arrowWidth / 2) + (secondHeight / 2);
        
        float leftMiddleLineX = (width / 2) - (arrowWidth / 2);
        float rightMiddleLineX = (width / 2) + (arrowWidth / 2);

       
        float upperLineYSecond = (height / 2) - (arrowWidth / 2) - (secondHeight / 2);
        float lowerLineYSecond = (height / 2) + (arrowWidth / 2)  - (secondHeight / 2);
        

        float lowerArrowHeadY = (secondHeight) - (arrowHeadWidth / 2);
        float upperArrowHeadY = (secondHeight) + (arrowHeadWidth / 2);

        resultPath.moveTo(0, upperLineY);
        resultPath.lineTo(leftMiddleLineX, upperLineY);
        
        resultPath.lineTo(leftMiddleLineX, upperLineYSecond);
        
        //resultPath.lineTo(baseLength, upperLineYSecond);
        //resultPath.lineTo(baseLength, upperArrowHeadY);
        
        //resultPath.lineTo(width, secondHeight );
        //resultPath.lineTo(baseLength, lowerArrowHeadY);
        
        //resultPath.lineTo(baseLength, lowerLineYSecond);
        
        resultPath.lineTo(width, upperLineYSecond);
        
        resultPath.lineTo(width, lowerLineYSecond);

        resultPath.lineTo(rightMiddleLineX, lowerLineYSecond);
        
        resultPath.lineTo(rightMiddleLineX, lowerLineY);
        resultPath.lineTo(0, lowerLineY);
        resultPath.lineTo(0, upperLineY);

        return resultPath;

    }
    
    public static Path drawRightUpRightArrow(Canvas canvas, int arrowWidth, int arrowHeadWidth, int secondHeight) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = width - 0.1f * width;

        float lowerLineY = (height / 2) + (arrowWidth / 2) + (secondHeight / 2);
        float upperLineY = (height / 2) - (arrowWidth / 2) + (secondHeight / 2);
        
        float leftMiddleLineX = (width / 2) - (arrowWidth / 2);
        float rightMiddleLineX = (width / 2) + (arrowWidth / 2);

       
        float upperLineYSecond = (height / 2) - (arrowWidth / 2) - (secondHeight / 2);
        float lowerLineYSecond = (height / 2) + (arrowWidth / 2)  - (secondHeight / 2);
        

        float lowerArrowHeadY = (height / 2) + (arrowHeadWidth / 2) - (secondHeight / 2);
        float upperArrowHeadY = (height / 2) - (arrowHeadWidth / 2) - (secondHeight / 2);

        resultPath.moveTo(0, upperLineY);
        resultPath.lineTo(leftMiddleLineX, upperLineY);
        
        resultPath.lineTo(leftMiddleLineX, upperLineYSecond);
        
		//resultPath.lineTo(width, upperLineYSecond);
        //resultPath.lineTo(width, lowerLineYSecond);
		
		resultPath.lineTo(baseLength, upperLineYSecond);
		resultPath.lineTo(baseLength, upperArrowHeadY);

        resultPath.lineTo(baseLength + arrowHeadSize, height/2 - secondHeight/2);
        resultPath.lineTo(baseLength, lowerArrowHeadY);
        
        resultPath.lineTo(baseLength, lowerLineYSecond);
		
        resultPath.lineTo(rightMiddleLineX, lowerLineYSecond);
        
        resultPath.lineTo(rightMiddleLineX, lowerLineY);
        resultPath.lineTo(0, lowerLineY);
        resultPath.lineTo(0, upperLineY);

        return resultPath;

    }
    public static Path drawLeftUpLeftArrow(Canvas canvas, int arrowWidth, int arrowHeadWidth, int secondHeight) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = 0.2f * width;

        float lowerLineY = (height / 2) + (arrowWidth / 2) + (secondHeight / 2);
        float upperLineY = (height / 2) - (arrowWidth / 2) + (secondHeight / 2);
        
        float leftMiddleLineX = (width / 2) - (arrowWidth / 2);
        float rightMiddleLineX = (width / 2) + (arrowWidth / 2);

       
        float upperLineYSecond = (height / 2) - (arrowWidth / 2) - (secondHeight / 2);
        float lowerLineYSecond = (height / 2) + (arrowWidth / 2)  - (secondHeight / 2);
        

        float lowerArrowHeadY = (height / 2) - (secondHeight /2) - (arrowHeadWidth / 2);
        float upperArrowHeadY = (height / 2) - (secondHeight/2) + (arrowHeadWidth / 2);

        resultPath.moveTo(width, upperLineY);
        resultPath.lineTo(rightMiddleLineX, upperLineY);
        
        resultPath.lineTo(rightMiddleLineX, upperLineYSecond);
        
		//resultPath.lineTo(0, upperLineYSecond);
        //resultPath.lineTo(0, lowerLineYSecond);
		
		resultPath.lineTo(baseLength, upperLineYSecond);
		resultPath.lineTo(baseLength, upperArrowHeadY);

        resultPath.lineTo(baseLength - arrowHeadSize, height/2 - secondHeight/2 );
        resultPath.lineTo(baseLength, lowerArrowHeadY);
        
        resultPath.lineTo(baseLength, lowerLineYSecond);
		
        resultPath.lineTo(leftMiddleLineX, lowerLineYSecond);
        
        resultPath.lineTo(leftMiddleLineX, lowerLineY);
        resultPath.lineTo(width, lowerLineY);
        resultPath.lineTo(width, upperLineY);

        return resultPath;

    }
    public static Path drawLeftUpLeftArrowHeadless(Canvas canvas, int arrowWidth, int arrowHeadWidth, int secondHeight) {
        Path resultPath = new Path(canvas.getDisplay());
        int width = canvas.getBounds().width;
        int height = canvas.getBounds().height;
        float baseLength = 0.2f * width;

        float lowerLineY = (height / 2) + (arrowWidth / 2) + (secondHeight / 2);
        float upperLineY = (height / 2) - (arrowWidth / 2) + (secondHeight / 2);
        
        float leftMiddleLineX = (width / 2) - (arrowWidth / 2);
        float rightMiddleLineX = (width / 2) + (arrowWidth / 2);

       
        float upperLineYSecond = (height / 2) - (arrowWidth / 2) - (secondHeight / 2);
        float lowerLineYSecond = (height / 2) + (arrowWidth / 2)  - (secondHeight / 2);
        

        float lowerArrowHeadY = (height / 2) - (secondHeight /2) - (arrowHeadWidth / 2);
        float upperArrowHeadY = (height / 2) - (secondHeight/2) + (arrowHeadWidth / 2);

        resultPath.moveTo(width, upperLineY);
        resultPath.lineTo(rightMiddleLineX, upperLineY);
        
        resultPath.lineTo(rightMiddleLineX, upperLineYSecond);
        
		resultPath.lineTo(0, upperLineYSecond);
        resultPath.lineTo(0, lowerLineYSecond);

		
        resultPath.lineTo(leftMiddleLineX, lowerLineYSecond);
        
        resultPath.lineTo(leftMiddleLineX, lowerLineY);
        resultPath.lineTo(width, lowerLineY);
        resultPath.lineTo(width, upperLineY);

        return resultPath;

    }
    




}