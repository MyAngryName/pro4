package org.jcryptool.visual.signalencryption.util;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

public class PathWithOffset extends Path {

	private final int offsetX;
	private final int offsetY;
	
	public PathWithOffset(Display display, int offsetX, int offsetY) {
		super(display);
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}

	@Override
	public void addRectangle(float x, float y, float width, float height) {
		super.addRectangle(x + offsetX, y + offsetY, width, height);
	}

	@Override
	public void lineTo(float x, float y) {
		super.lineTo(x + offsetX, y + offsetY);
	}

	@Override
	public void moveTo(float x, float y) {
		super.moveTo(x + offsetX, y + offsetY);
	}

	@Override
	public void cubicTo(float cx1, float cy1, float cx2, float cy2, float x, float y) {
		super.cubicTo(cx1 + offsetX, cy1 + offsetY, cx2 + offsetX, cy2 + offsetY, x + offsetX, y + offsetY);
	}
	
}
	
	
