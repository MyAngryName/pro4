package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.jcryptool.visual.signalencryption.graphics.ComponentDrawComposite;
import org.jcryptool.visual.signalencryption.graphics.Arrow.Anchor;
import org.jcryptool.visual.signalencryption.graphics.ComponentDrawComposite.Side;
import org.jcryptool.visual.signalencryption.util.PathWithOffset;

public class MailShapes {
	
	DrawingProperties props;
	
	boolean isVisible() {
		return true;
	}
	
	
	Path path() {
		return createPath(props);
	}
	
	Path createPath(DrawingProperties props) {
		var anchor = props.anchor.resolve(props.canvas);
		var path =  new PathWithOffset(props.canvas.getDisplay(), anchor.x + props.offsetX, anchor.y + props.offsetY);
		switch(props.type) {
		case RECEIVING:
			return createReceivingMail(path, props);
		case SENDING:
			return createSendingMail(path, props);
		default:
			return new Path(props.canvas.getDisplay());
		}
	}
	
	Path createSendingMail(Path path, DrawingProperties props) {
		int lineWidth = 5;
		int xLine = 70;
		int lengthUpperLine = -20;
		int lengthLowerLine = -40;
		int yUpperLine = 50;
		int yLowerLine = 25;
		int mailLeftX = xLine + 25;
		int mailRightX = mailLeftX + 80;
		int centerY = (yUpperLine + yLowerLine) / 2;
		int centerX = (mailRightX + mailLeftX) / 2;
		int mailTopY = centerY -  (yUpperLine - yLowerLine);
		int mailBotY = centerY +  (yUpperLine - yLowerLine);
		
		path.addRectangle(xLine, yUpperLine, lengthUpperLine, lineWidth);
		path.addRectangle(xLine, yLowerLine, lengthLowerLine, lineWidth);
		
		int height = mailTopY - mailBotY;
		int width = mailRightX - mailLeftX;
		
		path.addRectangle(mailLeftX, mailBotY, lineWidth, height);
		path.addRectangle(mailLeftX, mailTopY, width, lineWidth);
		path.addRectangle(mailLeftX, mailBotY, width, lineWidth);
		path.addRectangle(mailRightX, mailBotY, lineWidth, height);
		
		float cornerLeftX = mailLeftX + lineWidth;
		float cornerLeftY = mailTopY + lineWidth;
		float cornerRightX = mailRightX - lineWidth;
		float cornerRightY = mailTopY - lineWidth;
		
		path.moveTo(cornerLeftX + lineWidth * 1.5f, cornerLeftY);
		path.lineTo(centerX, centerY - lineWidth * 1.5f);
		path.lineTo(cornerRightX - lineWidth * 1.5f, cornerLeftY);
		path.lineTo(cornerRightX, cornerRightY);
		path.lineTo(cornerRightX, cornerRightY + lineWidth * 1.5f);
		path.lineTo(centerX, centerY + lineWidth * 1.5f);
		path.lineTo(cornerLeftX, cornerRightY + lineWidth * 1.5f);
		path.lineTo(cornerLeftX, cornerLeftY);
		path.lineTo(cornerLeftX + lineWidth * 1.5f, cornerLeftY);
		
		return path;
	}
	
	Path createReceivingMail(Path path, DrawingProperties props) {
		path.moveTo(10, 10);
		path.cubicTo(20, 20, 40, 20, 60, 10);
		path.moveTo(10, 10);
		return path;
	}

	static class MailShapeBuilder {
		
		private final Mail type;
		private Anchor anchor;
		private int offsetX;
		private int offsetY;
		
		public MailShapeBuilder(Mail type) {
			this.type = type;
		}
		
		
		public MailShapeBuilder offsetX(int offsetX) {
			this.offsetX = offsetX;
			return this;
		}


		public MailShapeBuilder offsetY(int offsetY) {
			this.offsetY = offsetY;
			return this;
		}
		
		public MailShapeBuilder relativeTo(Control control, Side side) {
			this.anchor = new Anchor(control, side);
					return this;
		}


		public MailShapes on(ComponentDrawComposite canvas) {
			var shape = new MailShapes();
			var props = new DrawingProperties();
			props.canvas = canvas;
			props.type = type;
			props.anchor = anchor;
			props.offsetX = offsetX;
			props.offsetY = offsetY;
			shape.props = props;
			canvas.addShape(shape);
			return shape;
		}
		
	}
	
	static MailShapeBuilder sendingMailIcon() {
		return new MailShapeBuilder(Mail.SENDING);
	}

	static MailShapeBuilder receivingMailIcon() {
		return new MailShapeBuilder(Mail.SENDING);
	}
	
	
	static class DrawingProperties {
		ComponentDrawComposite canvas;
		Anchor anchor;
		int offsetX;
		int offsetY;
		Mail type;
	}

	private enum Mail { SENDING, RECEIVING; }

}