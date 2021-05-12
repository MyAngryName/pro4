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

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.jcryptool.core.logging.utils.LogUtil;
import org.jcryptool.core.util.colors.ColorService;
import org.jcryptool.core.util.fonts.FontService;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.jcryptool.core.util.ui.auto.SmoothScroller;



/**
 * 
 * @author Dan-Kerko Ciudin
 * 
 */

public class SignalEncryptionView extends ViewPart {
	
	// Constants
	public static final String ID = "org.jcryptool.visual.huffmanCoding.ui.SignalEncryptionView"; //$NON-NLS-1$
//	public final static int OVERVIEW = 0;
//	public final static int DOUBLERATCHET = 1;
		
	// Main UI components
	private Composite parent;

	private TabFolder tabFolder;
	private TabItem tbtmOverview;
	private TabItem tbtmDoubleRatchet;
	private SignalEncryptionView mainView;
	private SignalEncryptionViewDoubleRatchet doubleRatchetView;
	
	// Tab-Handling
    private int previousTab = 0;
	private SignalEncryptionViewOverview overViewTab;
	
	
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
		
		// Tab folder for the tabs
		tabFolder = new TabFolder(scrolledComposite, SWT.NONE);
		
		// first tab for the key overview
		tbtmOverview = new TabItem(tabFolder, SWT.NONE);
		tbtmOverview.setText("Allgemein");

		
		// second tab for the Double Ratchet algorithm
		tbtmDoubleRatchet = new TabItem(tabFolder, SWT.NONE);
		tbtmDoubleRatchet.setText("Double Ratchet");
		
		//tab selection listener
		tabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selection = tabFolder.getSelectionIndex();
				
				tabFolder.setSelection(selection);
				setTab(selection);
			}
		});
		
		//init first tab
		overViewTab = new SignalEncryptionViewOverview(tabFolder, SWT.NONE);	
		tbtmOverview.setControl(overViewTab);
		                     
		
        scrolledComposite.setContent(tabFolder);
        scrolledComposite.setMinSize(tabFolder.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		// This makes the ScrolledComposite scrolling, when the mouse 
		// is on a Text with one or more of the following tags: SWT.READ_ONLY,
		// SWT.V_SCROLL or SWT.H_SCROLL.
		SmoothScroller.scrollSmooth(scrolledComposite);
	}
	

	public void setTab(int tab) { 
        switch (tab) {
         case 0:         
           tbtmOverview.setControl(overViewTab);
           previousTab = 0;
           break; 
         case 1:   
//           tbtmDoubleRatchet.setControl(DoubleRatchetTab);
           previousTab = 1;
        default:
            break;
        }

        tabFolder.setSelection(tab);
        FontService.getHeaderFont();
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
