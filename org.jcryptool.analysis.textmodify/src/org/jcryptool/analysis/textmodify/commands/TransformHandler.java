// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2011, 2020 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.analysis.textmodify.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.jcryptool.analysis.textmodify.TextmodifyPlugin;
import org.jcryptool.core.logging.utils.LogUtil;
import org.jcryptool.core.operations.algorithm.classic.textmodify.Transform;
import org.jcryptool.core.operations.algorithm.classic.textmodify.TransformData;
import org.jcryptool.core.operations.editors.AbstractEditorService;
import org.jcryptool.core.operations.editors.EditorsManager;
import org.jcryptool.core.operations.util.PathEditorInput;
import org.jcryptool.core.util.constants.IConstants;
import org.jcryptool.crypto.ui.textmodify.wizard.ModifyWizard;

public class TransformHandler extends AbstractHandler {
    /**
     * get the text from an opened editor
     */
    private String getEditorText() {
        return inputStreamToString(EditorsManager.getInstance().getActiveEditorContentInputStream());
    }

    /**
     * reads the current value from an input stream
     *
     * @param in the input stream
     */
    private String inputStreamToString(InputStream in) {
        if (in != null) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(in, IConstants.UTF8_ENCODING));
            } catch (UnsupportedEncodingException e1) {
                LogUtil.logError(TextmodifyPlugin.PLUGIN_ID, e1);
            }

            StringBuffer myStrBuf = new StringBuffer();
            int charOut = 0;
            String output = ""; //$NON-NLS-1$
            try {
                while ((charOut = reader.read()) != -1) {
                    myStrBuf.append(String.valueOf((char) charOut));
                }
            } catch (IOException e) {
                LogUtil.logError(TextmodifyPlugin.PLUGIN_ID, e);
            }
            output = myStrBuf.toString();
            return output;
        } else
            return null;
    }

    /**
     * executes a TextModify Wizard.
     *
     * @param the Settings that have to be displayed at the beginning.
     * @return the selected settings.
     */
    private TransformData getTransformWizardSettings(final TransformData predefined) {
        ModifyWizard wizard = new ModifyWizard();
        wizard.setPredefinedData(predefined);
        WizardDialog dialog =
                new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                        wizard);

        if (dialog.open() == Window.OK) {
            return wizard.getWizardData();
        } else {
            return null;
        }
    }

    /**
     * The action has been activated. The argument of the method represents the 'real' action
     * sitting in the workbench UI.
     *
     * @see IWorkbenchWindowActionDelegate#run
     */
    @Override
	public Object execute(ExecutionEvent event) {
        if (EditorsManager.getInstance().isEditorOpen()) {
            String text = getEditorText();
            final TransformData transform = getTransformWizardSettings(new TransformData());

            if (transform != null) {
                final String oldEditorName = EditorsManager.getInstance().getActiveEditorTitle();

                String is = Transform.transformText(text, transform);
                IEditorInput customEditorInput = AbstractEditorService.createOutputFile(is);
                ((PathEditorInput) customEditorInput).setTooltip(Messages.TransformAction_tooltip1
                        + oldEditorName
                        + "; " + Messages.TransformAction_tooltip2 + transform.toString()); //$NON-NLS-1$

                try {
                    EditorsManager.getInstance().openNewTextEditor(customEditorInput);
                } catch (PartInitException e) {
                    LogUtil.logError(TextmodifyPlugin.PLUGIN_ID,
                            Messages.TransformAction_errorTransformMenuBtn);
                }
            }
        }
        return null;
    }
}