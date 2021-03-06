// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2011, 2020 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.visual.grille.algorithm;

public class KeySchablone extends Schablone implements Cloneable {

    public KeySchablone(int size) {
        super(size);
        if (size % 2 != 0) {
            set(size / 2, size / 2, '2');
        }
    }

    /**
     * setzt an der genannten Stelle ein Loch und sperrt die durch Rotation belegten 3 weiteren Positionen in der
     * Schablone
     *
     * @param row Zeilenkoordinate des Loches
     * @param column Spaltenkoordinate des Loches
     */
    public void set(int row, int column) {
        // 0 = frei
        // 1 = loch
        // 2 = besetzt durch Drehung
        if (get(row, column) == '0') {
            super.set(row, column, '1');
            super.set(schablone.length - 1 - column, row, '2');
            super.set(column, schablone.length - 1 - row, '2');
            super.set(schablone.length - 1 - row, schablone.length - 1 - column, '2');
        }
    }

    public void unSet(int row, int column) {
        // 0 = frei
        // 1 = loch
        // 2 = besetzt durch Drehung
        if (get(row, column) == '1') {
            super.set(row, column, '0');
            super.set(schablone.length - 1 - column, row, '0');
            super.set(column, schablone.length - 1 - row, '0');
            super.set(schablone.length - 1 - row, schablone.length - 1 - column, '0');
        }
    }

    /**
     * 
     * @param row
     * @param column
     * @return True, if a hole is set or unset. False, if no hole has changed.
     */
    public boolean toggle(int row, int column) {
        if (get(row, column) == '0') {
            set(row, column);
            return true;
        } else if (get(row, column) == '1') {
            unSet(row, column);
            return true;
        }
        return false;
    }

    /**
     * pr??ft ob ein Feld der Schablone unbeschrieben bleibt
     *
     * @return falsch, wenn durch den schl??ssel nicht alle felder beschrieben werden; wahr, wenn schl??ssel zul??ssig ist
     */
    public boolean isValid() {
        for (int r = 0; r < schablone.length; r++) {
            for (int c = 0; c < schablone[r].length; c++) {
                if (get(r, c) == '0')
                    return false;
            }
        }
        return true;
    }

    /**
     * dreht die Schablone um 90 Grad im Uhrzeigersinn
     */
    public void rotateClockwise() {
        char[][] rotated = new char[getSize()][getSize()];
        for (int r = 0; r < schablone.length; r++) {
            for (int c = 0; c < schablone[r].length; c++) {
                rotated[c][schablone.length - 1 - r] = get(r, c);
            }
        }
        schablone = rotated;
    }

    public void rotateCounterClockwise() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    @Override
    public KeySchablone clone() {
        KeySchablone clone = new KeySchablone(getSize());
        for (int i = 0; i < getSize() * getSize(); i++) {
            if (get(i / getSize(), i % getSize()) == '1')
                clone.set(i / getSize(), i % getSize());
        }
        return clone;
    }
}
