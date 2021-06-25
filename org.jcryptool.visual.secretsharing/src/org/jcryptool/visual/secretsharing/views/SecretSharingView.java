//-----BEGIN DISCLAIMER-----
/*******************************************************************************
* Copyright (c) 2011, 2021 JCrypTool Team and Contributors
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
//-----END DISCLAIMER-----
package org.jcryptool.visual.secretsharing.views;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.jcryptool.core.util.ui.auto.SmoothScroller;
import org.jcryptool.visual.secretsharing.SecretSharingPlugin;

/**
 * @author Oryal Inel
 * @author Thorben Groos
 * @version 1.0.0
 */
public class SecretSharingView extends ViewPart {

    private Composite parent;

    /**
     * Create contents of the view part
     * @param parent
     */
    @Override
    public void createPartControl(Composite parent) {
        this.parent = parent;

        ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        ShamirsSecretSharingComposite sscc = new ShamirsSecretSharingComposite(scrolledComposite, SWT.NONE, this);
        

        scrolledComposite.setContent(sscc);;
        scrolledComposite.setMinSize(sscc.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        
		// This makes the ScrolledComposite scrolling, when the mouse 
		// is on a Text with one or more of the following tags: SWT.READ_ONLY,
		// SWT.V_SCROLL or SWT.H_SCROLL.
		SmoothScroller.scrollSmooth(scrolledComposite);

		// This registers the context help on this view.
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, SecretSharingPlugin.PLUGIN_ID + ".view");

        hookActionBar();
    }

    private void hookActionBar() {
        IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
        mgr.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
        getViewSite().getActionBars().updateActionBars();
    }

    @Override
    public void setFocus() {
        parent.setFocus();
    }

    public void reset() {
        Control[] children = parent.getChildren();
        for (Control control : children) {
            control.dispose();
        }
        createPartControl(parent);
        parent.layout();
    }

}
