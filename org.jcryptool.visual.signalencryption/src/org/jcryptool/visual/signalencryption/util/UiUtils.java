package org.jcryptool.visual.signalencryption.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class UiUtils {

    private UiUtils() {
        // Private constructor to prevent instantiation of this class
    }

    /**
     * Insert invisible spacing widgets into the composite container.
     * 
     * Can be used for GridLayouts to fill into "empty" slots in the grid.
     * 
     * @param parent widget to attach spacers to
     * @param number number of spacers (grid cells) to fill
     */
    public static void insertSpacers(Composite parent, int number) {
        for (int i = 0; i < number; ++i) {
            var label = new Label(parent, SWT.NONE);
            label.setVisible(false);
        }
    }

}
