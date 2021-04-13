//-----BEGIN DISCLAIMER-----
/*******************************************************************************
* Copyright (c) 2016, 2020 JCrypTool Team and Contributors
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
//-----END DISCLAIMER-----
package org.jcryptool.visual.merkletree;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.jcryptool.core.util.units.DefaultByteFormatter;
import org.jcryptool.core.util.units.UnitsService;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.jcryptool.visual.merkleTree"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework. BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        var byteFormatter = new DefaultByteFormatter.Builder().scaleUpThreshold(5_000L).build();
        
        // Register a byteformatter which starts to write out bytes to use within the plugin.
        if (UnitsService.get().isRegisteringPossible()) {
            UnitsService.get().registerFormatter(byteFormatter, PLUGIN_ID);
        }
        
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework. BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
        UnitsService.get().deregisterFormatter(PLUGIN_ID);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

}
