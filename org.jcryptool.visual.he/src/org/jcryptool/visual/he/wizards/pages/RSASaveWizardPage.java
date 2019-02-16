// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2019 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.visual.he.wizards.pages;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Text;

/**
 * abstract superclass for unified access to {@link SaveKeypairPage} and {@link SavePublicKeyPage}.
 * @author Michael Gaber
 */
public abstract class RSASaveWizardPage extends WizardPage {

	/** field for the owner of this keypair. */
	protected Text owner;

	/**
	 * constructor just calling super.
	 * @param pageName page name
	 * @param title title
	 * @param titleImage title image
	 */
	public RSASaveWizardPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

}
