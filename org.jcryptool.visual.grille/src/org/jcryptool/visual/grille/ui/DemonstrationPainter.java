// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2011, 2020 JCrypTool Team and Contributors
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.visual.grille.ui;

import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.jcryptool.core.util.colors.ColorService;
import org.jcryptool.core.util.fonts.FontService;
import org.jcryptool.visual.grille.algorithm.Schablone;

public class DemonstrationPainter implements PaintListener {

    private Demonstration demonstration;
    private int width;
    private int height;
    private int cellWidth;
    private int cellHeight;
    private Canvas parent;

    /**
     * painter for the visualization
     * @param parent The parent canvas
     * @param demonstration
     */
    public DemonstrationPainter(Canvas parent, Demonstration demonstration) {
        this.demonstration = demonstration;
        this.parent = parent;
    }

	@Override
	public void paintControl(PaintEvent e) {
		
		e.gc.setAntialias(SWT.ON);
		
		width = parent.getSize().x;
		height = parent.getSize().y;
		if (width > height) {
			width = height;
		} else {
			height = width;
		}
		if (demonstration.getCurrentStep() == 0) {
			e.gc.fillRectangle(0, 0, width, height);
		} else if (demonstration.getCurrentStep() == 1) {
			e.gc.setFont(FontService.getLargeFont());
			int schablonenGrosse = demonstration.getSchablone().getSize();
			//Wenn kein Padding gebraucht wird zeige diesen Text an.
			if (demonstration.padding.length() == 0) {
				e.gc.drawText((NLS.bind(Messages.getString("DemonstrationPainter.description"),  //$NON-NLS-1$
						schablonenGrosse*schablonenGrosse, demonstration.padding.length())), 0, 0);
			} else {
				//Wenn ein padding n??tig ist.
				e.gc.drawText((NLS.bind(Messages.getString("DemonstrationPainter.description_1"), 
						schablonenGrosse*schablonenGrosse, demonstration.padding.length())), 0, 0); 
			}
			if (!(demonstration.padding.length() == 0)) { 
				e.gc.drawText((NLS.bind(Messages.getString("DemonstrationPainter.padding"),  //$NON-NLS-1$
						demonstration.padding.length())), 0, 175);
				Color savedColor = e.gc.getForeground();
				e.gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
				String padding = ""; //$NON-NLS-1$
				for (int i = 0; i < demonstration.padding.length(); i = i + 35) {
					padding += demonstration.padding.substring(i, Math.min(demonstration.padding.length(), i + 35));
					padding += "\n"; //$NON-NLS-1$
				}
				e.gc.drawText(padding, 0, 210);
				e.gc.setForeground(savedColor);

			}
		} else if (demonstration.getCurrentStep() <= 5) {
            Schablone crypt = demonstration.getSchablone();
            cellWidth = width / crypt.getSize();
            cellHeight = cellWidth;
            int width = cellWidth * crypt.getSize();
            int height = width;

            for (int y = 0; y < crypt.getSize(); y++) {
                for (int x = 0; x < crypt.getSize(); x++) {
                    if (crypt.get(y, x) != '0') {
                        Color savedColor = e.gc.getForeground();
                        Font savedFont = e.gc.getFont();
                        if (demonstration.getKey().get(y, x) == '1')
                            e.gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));

                        fillCell(e, x, y, crypt.get(y, x));

                        e.gc.setFont(savedFont);
                        e.gc.setForeground(savedColor);
                    }
                }
            }
            for (int i = 0; i < crypt.getSize() + 1; i++) {
                e.gc.drawLine((i) * (width / crypt.getSize()), 0, (i) * (width / crypt.getSize()), height);
                e.gc.drawLine(0, (i) * (width / crypt.getSize()), height, (i) * (width / crypt.getSize()));
            }
        } else {
            Schablone crypt = demonstration.getSchablone();
            cellWidth = width / crypt.getSize();
            cellHeight = cellWidth;
            int width = cellWidth * crypt.getSize();
            int height = width;
            Color savedColor = e.gc.getForeground();
            Font savedFont = e.gc.getFont();

            for (int y = 0; y < crypt.getSize(); y++) {
                for (int x = 0; x < crypt.getSize(); x++) {
                    if (crypt.get(y, x) != '0') {
                        fillCell(e, x, y, crypt.get(y, x));
                    }
                }
            }
            e.gc.setFont(savedFont);
            e.gc.setForeground(savedColor);

            for (int i = 0; i < crypt.getSize() + 1; i++) {
                e.gc.drawLine((i) * (width / crypt.getSize()), 0, (i) * (width / crypt.getSize()), height);
                e.gc.drawLine(0, (i) * (width / crypt.getSize()), height, (i) * (width / crypt.getSize()));
            }

            savedColor = e.gc.getForeground();
            e.gc.setForeground(ColorService.RED);

            for (int i = 0; i < crypt.getSize(); i++) {
                e.gc.drawLine(cellWidth / 2, cellHeight / 2 + i * cellHeight, cellWidth / 2 + (crypt.getSize() - 1)
                        * cellWidth, cellHeight / 2 + i * cellHeight);
                e.gc.drawLine(cellWidth / 2, cellHeight / 2 - 1 + i * cellHeight, cellWidth / 2 + (crypt.getSize() - 1)
                        * cellWidth, cellHeight / 2 - 1 + i * cellHeight);
                e.gc.drawLine(cellWidth / 2, cellHeight / 2 + 1 + i * cellHeight, cellWidth / 2 + (crypt.getSize() - 1)
                        * cellWidth, cellHeight / 2 + 1 + i * cellHeight);
                e.gc.drawLine(cellWidth / 2, cellHeight / 2 + 2 + i * cellHeight, cellWidth / 2 + (crypt.getSize() - 1)
                        * cellWidth, cellHeight / 2 + 2 + i * cellHeight);
                e.gc.drawLine(cellWidth / 2, cellHeight / 2 - 2 + i * cellHeight, cellWidth / 2 + (crypt.getSize() - 1)
                        * cellWidth, cellHeight / 2 - 2 + i * cellHeight);
                if (i != crypt.getSize() - 1) {
                    e.gc.drawLine(cellWidth / 2, cellHeight / 2 + (i + 1) * cellHeight,
                            cellWidth / 2 + (crypt.getSize() - 1) * cellWidth, cellHeight / 2 + i * cellHeight);
                    e.gc.drawLine(cellWidth / 2, cellHeight / 2 - 1 + (i + 1) * cellHeight,
                            cellWidth / 2 + (crypt.getSize() - 1) * cellWidth, cellHeight / 2 - 1 + i * cellHeight);
                    e.gc.drawLine(cellWidth / 2, cellHeight / 2 + 1 + (i + 1) * cellHeight,
                            cellWidth / 2 + (crypt.getSize() - 1) * cellWidth, cellHeight / 2 + 1 + i * cellHeight);

                }

            }
            e.gc.drawLine(cellWidth / 2 + (crypt.getSize() - 1) * cellWidth - (cellWidth / 2 / 2), cellHeight / 2
                    + (crypt.getSize() - 1) * cellHeight + (cellWidth / 2 / 2), cellWidth / 2 + (crypt.getSize() - 1)
                    * cellWidth, cellHeight / 2 + (crypt.getSize() - 1) * cellHeight);
            e.gc.drawLine(cellWidth / 2 + (crypt.getSize() - 1) * cellWidth - (cellWidth / 2 / 2) - 1, cellHeight / 2
                    + (crypt.getSize() - 1) * cellHeight + (cellWidth / 2 / 2), cellWidth / 2 + (crypt.getSize() - 1)
                    * cellWidth - 1, cellHeight / 2 + (crypt.getSize() - 1) * cellHeight);
            e.gc.drawLine(cellWidth / 2 + (crypt.getSize() - 1) * cellWidth - (cellWidth / 2 / 2) + 1, cellHeight / 2
                    + (crypt.getSize() - 1) * cellHeight + (cellWidth / 2 / 2), cellWidth / 2 + (crypt.getSize() - 1)
                    * cellWidth + 1, cellHeight / 2 + (crypt.getSize() - 1) * cellHeight);
            e.gc.drawLine(cellWidth / 2 + (crypt.getSize() - 1) * cellWidth - (cellWidth / 2 / 2), cellHeight / 2
                    + (crypt.getSize() - 1) * cellHeight - (cellWidth / 2 / 2), cellWidth / 2 + (crypt.getSize() - 1)
                    * cellWidth, cellHeight / 2 + (crypt.getSize() - 1) * cellHeight);
            e.gc.drawLine(cellWidth / 2 + (crypt.getSize() - 1) * cellWidth - (cellWidth / 2 / 2) - 1, cellHeight / 2
                    + (crypt.getSize() - 1) * cellHeight - (cellWidth / 2 / 2), cellWidth / 2 + (crypt.getSize() - 1)
                    * cellWidth - 1, cellHeight / 2 + (crypt.getSize() - 1) * cellHeight);
            e.gc.drawLine(cellWidth / 2 + (crypt.getSize() - 1) * cellWidth - (cellWidth / 2 / 2) + 1, cellHeight / 2
                    + (crypt.getSize() - 1) * cellHeight - (cellWidth / 2 / 2), cellWidth / 2 + (crypt.getSize() - 1)
                    * cellWidth + 1, cellHeight / 2 + (crypt.getSize() - 1) * cellHeight);
            e.gc.setForeground(savedColor);
        }
    }

	/**
	 * Set a Character c to a cell x y.
	 * @param e The paint listener
	 * @param x x-coordinate of the cell
	 * @param y y-coordinate of the cell
	 * @param c The character that should be set to this cell.
	 */
    private void fillCell(PaintEvent e, int x, int y, char c) {
    	
    	// Set the fontsize.
    	int fontSize = cellHeight / 2;
        e.gc.setFont(new Font(Display.getCurrent(), "Times Roman", fontSize, SWT.NORMAL)); //$NON-NLS-1$
        
    	// This calculates space the characters needs to be displayed fully.
    	Point estimatedTextSize = e.gc.textExtent("" + c);
    	
    	
    	int paddingWidth = (cellWidth - estimatedTextSize.x) / 2;
    	int paddingHeight = (cellHeight - estimatedTextSize.y) / 2;
    	
    	// This puts the character in the top left corner of a cell x y.
        Point eckeLO = new Point(x * cellWidth + paddingWidth, y * cellHeight + paddingHeight);
        e.gc.drawString("" + c, eckeLO.x, eckeLO.y); //$NON-NLS-1$
    }

}