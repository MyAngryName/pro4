package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

public class Layout {

    private Layout() {
        // Private constructor to prevent instantiation of this class.
    }

    public static GridLayout gl_algorithmComposite() {
        return new GridLayout(6, false);
    }

    public static GridLayout gl_stepsComposite() {
        return new GridLayout(1, false);
    }

    public static GridLayout gl_arrowSpaceComposite() {
        return new GridLayout(1, false);
    }

    public static GridLayout gl_sendingReceivingChainComposite() {
        return new GridLayout(4, false);
    }

    public static GridLayout gl_rootChainComposite() {
        return new GridLayout(1, false);
    }

    public static GridLayout gl_diffieHellmanComposite() {
        return new GridLayout(1, false);
    }

    public static GridLayout gl_messageboxGroup() {
        return new GridLayout(1, false);
    }

    public static GridData gd_stepsComposite() {
        return new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
    }

    public static GridData gd_algorithmComposite() {
        return new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
    }

    public static GridData gd_arrowSpaceComposite() {
        return new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
    }

    public static GridData gd_Messagebox() {
        var gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        gridData.minimumHeight = 150;
        gridData.widthHint = 250;
        return gridData;
    }

    public static GridData gd_shortDescriptionTexts() {
        var gd_shortDescriptionTexts = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        gd_shortDescriptionTexts.minimumHeight = 20;
        gd_shortDescriptionTexts.widthHint = 800;
        return gd_shortDescriptionTexts;

    }

    // style data for the labels within the algorithm
    public static GridData gd_algorithmLabels() {
        var gd_algorithmLabels = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
        gd_algorithmLabels.widthHint = 150;
        gd_algorithmLabels.heightHint = 60;
        return gd_algorithmLabels;
    }

    public static GridData gd_sendingReceivingChainComposite() {
        return new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
    }

    public static GridData gd_rootChainComposite() {
        return new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
    }

    public static GridData gd_diffieHellmanComposite() {
        return new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
    }

    public static GridData gd_messageboxComposite() {
        return new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
    }

    // style data for the description texts
    public static GridData gd_longDescriptionTexts() {
        var gd_longDescriptionTexts = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        gd_longDescriptionTexts.minimumHeight = 30;
        gd_longDescriptionTexts.widthHint = 800;
        return gd_longDescriptionTexts;
    }

}
