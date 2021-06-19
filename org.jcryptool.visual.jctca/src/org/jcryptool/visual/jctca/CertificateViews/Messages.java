//-----BEGIN DISCLAIMER-----
/*******************************************************************************
* Copyright (c) 2013, 2021 JCrypTool Team and Contributors
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
//-----END DISCLAIMER-----
package org.jcryptool.visual.jctca.CertificateViews;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.jcryptool.visual.jctca.CertificateViews.messages"; //$NON-NLS-1$
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }

    public static String ShowReq_first_names;
    public static String ShowReq_country;
    public static String ShowReq_email;
    public static String ShowReq_last_names;
    public static String ShowReq_street;
    public static String ShowReq_zip;
    public static String ShowReq_city;
    public static String ShowReq_btn_grant_cert;
    public static String ShowReq_btn_reject_request;
}
