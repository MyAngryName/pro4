//-----BEGIN DISCLAIMER-----
/*******************************************************************************
* Copyright (c) 2018, 2020 JCrypTool Team and Contributors
*
* All rights reserved. This program and the accompanying materials are made available under the
* terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
//-----END DISCLAIMER-----
package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;


/**
 * @author Lorenz Aigner
 * @author Dan-Kerko Ciudin
 * @author Dominik Füreder
 * 
 */

public class SignalEncryptionView extends ViewPart {
	
	
	// Main UI components
	private Composite parent;
	private Composite overViewComposite;
	private TabFolder tabFolder;
	private TabItem tbtmAllgemein;
	private TabItem tbtmDoubleRatchet;
	private SignalEncryptionView mainView;
	private SignalEncryptionViewDoubleRatchet doubleRatchetView;
	
	private TitleAndDescriptionComposite titleAndDescription;
	
	
	public SignalEncryptionView() {
	}
	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		this.mainView = this;
		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		
		tabFolder = new TabFolder(scrolledComposite, SWT.NONE);
		
		tbtmAllgemein = new TabItem(tabFolder, SWT.NONE);
		tbtmAllgemein.setText("Allgemein");
		
		tbtmDoubleRatchet = new TabItem(tabFolder, SWT.NONE);
		tbtmDoubleRatchet.setText("Double Ratchet");
		
		// Init first tab
		overViewComposite = new Composite(tabFolder, SWT.NONE);
		tbtmAllgemein.setControl(overViewComposite);
		GridLayout gl_overViewComposite = new GridLayout(2,false);
		gl_overViewComposite.marginHeight = 0;
		gl_overViewComposite.marginWidth = 0;
		overViewComposite.setLayout(gl_overViewComposite);
		
		// Content of first tab
		titleAndDescription = new TitleAndDescriptionComposite(overViewComposite);
		titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		titleAndDescription.setTitle("Allgemein");
		titleAndDescription.setDescription("Allgemeine Informationen");
	}
	
	
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	/**
     * resets the view, it's needed by JCrypTool
     */
    public void resetView() {
        Control[] children = parent.getChildren();
        for (Control control : children) {
            control.dispose();
        }
        createPartControl(parent);
        parent.layout();

//        reset();
    }
}
