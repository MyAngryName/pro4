package org.jcryptool.visual.signalencryption.graphics;

import org.eclipse.swt.graphics.GC;

public interface Component {
	
	boolean isVisible();
	void setVisible(boolean visible);
	void draw(GC gc);

}
