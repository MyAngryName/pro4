// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2019, 2020 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.analysis.fleissner.UI;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Canvas;
import org.jcryptool.analysis.fleissner.key.Grille;
import org.jcryptool.analysis.fleissner.key.KeySchablone;

public class KeyListener implements MouseListener {

	private FleissnerWindow fw;
	private Grille model;

	public KeyListener(Grille model, FleissnerWindow fw) {
		this.model = model;
		this.fw = fw;
	}

	@Override
    public void mouseDoubleClick(MouseEvent e) {}

	@Override
    public void mouseDown(MouseEvent e) {}

	@Override
    public void mouseUp(MouseEvent e) {
		KeySchablone key = model.getKey();
		int width = ((Canvas) e.widget).getSize().x;
		int cellWidth = width/key.getSize();
		int cellHeight = cellWidth;
		int posX = (int) Math.floor((double)e.x/cellWidth);
		int posY = (int) Math.floor((double)e.y/cellHeight);
		key.toggle(posY,posX);
		((Canvas) e.widget).redraw();
		fw.saveKey(key);
		fw.checkOkButton();
		fw.updateKeyText();
	}
}