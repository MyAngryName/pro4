//-----BEGIN DISCLAIMER-----
/*******************************************************************************
* Copyright (c) 2015, 2021 JCrypTool Team and Contributors
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
//-----END DISCLAIMER-----
package org.jcryptool.visual.wots.files;

/**
 * @author Moritz Horsch <horsch@cdc.informatik.tu-darmstadt.de>
 */
public class MathUtils {

    /**
     * Calculates the log base 2 of x.
     *
     * @param x Value x
     * @return Log base 2 of x
     */
    public static double log2(int x) {
	return (Math.log10(x) / Math.log10(2));
    }
}
