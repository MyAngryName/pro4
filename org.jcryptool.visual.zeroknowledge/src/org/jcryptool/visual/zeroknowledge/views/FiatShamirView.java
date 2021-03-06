// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2020 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.visual.zeroknowledge.views;

import java.math.BigInteger;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.jcryptool.core.util.ui.auto.SmoothScroller;
import org.jcryptool.visual.zeroknowledge.ModNCalculator;
import org.jcryptool.visual.zeroknowledge.algorithm.Modell;
import org.jcryptool.visual.zeroknowledge.algorithm.fiatshamir.FSAlice;
import org.jcryptool.visual.zeroknowledge.algorithm.fiatshamir.FSBob;
import org.jcryptool.visual.zeroknowledge.algorithm.fiatshamir.FSCarol;
import org.jcryptool.visual.zeroknowledge.ui.Buttons;
import org.jcryptool.visual.zeroknowledge.ui.Introduction;
import org.jcryptool.visual.zeroknowledge.ui.PrimeGenerator;
import org.jcryptool.visual.zeroknowledge.ui.fiatshamir.FSFlow;
import org.jcryptool.visual.zeroknowledge.ui.fiatshamir.FSParamsAliceCarol;
import org.jcryptool.visual.zeroknowledge.ui.fiatshamir.FSParamsBob;

public class FiatShamirView extends ViewPart implements Observer, ModNCalculator {

    private FSAlice alice;
    private FSBob bob;
    private Buttons buttons;
    private FSCarol carol;
    private FSFlow flow;
    private Composite main;
    private Modell modell;
    private FSParamsAliceCarol paramsAC;
    private FSParamsBob params_bob;
    private FSParamsAliceCarol params_carol;
    private PrimeGenerator prime;
    private Group info;
    private Composite parent;
	private TitleAndDescriptionComposite titleAndDescription;

    @Override
    public void createPartControl(Composite parent) {
        this.parent = parent;

        // Create srollable composite and composite within it
        ScrolledComposite sc =
                new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
        sc.setExpandHorizontal(true);
        sc.setExpandVertical(true);

        // gridlayout for elements
        Composite pageComposite = new Composite(sc, SWT.NONE);
        sc.setContent(pageComposite);
        pageComposite.setLayout(new GridLayout());

		titleAndDescription = new TitleAndDescriptionComposite(pageComposite);
		titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4 ,1));
		titleAndDescription.setTitle(Messages.FiatShamirView_title);
		titleAndDescription.setDescription(Messages.FiatShamirView_text);
        
        // pointer main points to pageComposite
        main = pageComposite;

        // Modelle
        modell = new Modell();
        bob = new FSBob();
        alice = new FSAlice();
        carol = new FSCarol();

        // bei den Modellen als Observer anmelden
        modell.addObserver(this);
        bob.addObserver(this);
        alice.addObserver(this);
        carol.addObserver(this);

        //Group Situatuation
        new Introduction(this, main, "FS");

        // Modul zum Erstellen von n
        prime = new PrimeGenerator(this, main);

        // Layout for Action-Flow group
        Group action = new Group(main, SWT.None);
        action.setText(Messages.FiatShamirView_1);
        action.setLayout(new GridLayout());
        action.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        

        // Modul f??r den Durchgang
        flow = new FSFlow(this, action);

        // "reset", "rerun", "several runs" buttons
        buttons = new Buttons(this, action, modell, null);
        buttons.enableMehrmals(false);

        // Layout for information group
        info = new Group(main, SWT.None);
        info.setLayout(new GridLayout(2, false));
        info.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        info.setText(Messages.FiatShamirView_2);

        // Modul zum Darstellen der Parameter von Bob
        params_bob = new FSParamsBob(bob, info);

        // Modul zum Darstellen der Parameter von Alice
        paramsAC = new FSParamsAliceCarol(alice, info);

        sc.setMinSize(pageComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        
		// This makes the ScrolledComposite scrolling, when the mouse 
		// is on a Text with one or more of the following tags: SWT.READ_ONLY,
		// SWT.V_SCROLL or SWT.H_SCROLL.
		SmoothScroller.scrollSmooth(sc);

        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
                "org.jcryptool.visual.zeroknowledge.fiatshamirContextHelpID"); //$NON-NLS-1$
    }

    /**
     * Methode, die das Bet??tigen der Buttons im Flow unm??glich macht.
     *
     * @see ModNCalculator#disableAllInFlow()
     */
    @Override
	public void disableAllInFlow() {
        flow.disableAll();
    }

    /**
     * gibt das Alice-Objekt zur??ck
     *
     * @return Alice-Objekt
     */
    public FSAlice getAlice() {
        return alice;
    }

    @Override
	public void setSecret() {
        alice.generateSecret();
        bob.setV(alice.getV());
        carol.generateSecret();
        flow.enableFirst();
        buttons.enableMehrmals(true);
    }

    /**
     * gibt das Bob-Objekt zur??ck
     *
     * @return Bob-Objekt
     */
    public FSBob getBob() {
        return bob;
    }

    /**
     * gibt das Buttons-Objekt der graphischen Oberfl??che zur??ck
     *
     * @return Buttons-Objekt
     */
    @Override
	public Buttons getButtons() {
        return buttons;
    }

    /**
     * gibt das Carol-Objekt zur??ck
     *
     * @return Carol-Objekt
     */
    public FSCarol getCarol() {
        return carol;
    }

    /**
     * gibt den Flow der graphsichen Oberfl??che zur??ck
     *
     * @return Flow der graphischen Oberfl??che
     */
    public FSFlow getFlow() {
        return flow;
    }

    /**
     * gibt das Modell zur??ck
     *
     * @return Modell der Applikation
     */
    @Override
	public Modell getModell() {
        return modell;
    }

    /**
     * Methode, um n zu erhalten.
     *
     * @return Modul n
     */
    @Override
	public BigInteger getN() {
        return alice.getN();
    }

    /**
     * gibt das Objekt zur??ck, das die Parameter von Bob darstellt
     *
     * @return Objekt, das die Parameter von Bob darstellt
     */
    public FSParamsBob getParamsBob() {
        return params_bob;
    }

    /**
     * gibt den PrimeGenerator zur??ck
     *
     * @return PrimeGenerator, der auf dem Haupt-Composite sichtbar ist
     */
    public PrimeGenerator getPrimeGen() {
        return prime;
    }



    /**
     * schaltet das Label f??r Exceptions aus
     */
    @Override
	public void removeException() {
        prime.removeException();
    }

    /**
     * macht das "Verifiziert"-Feld unsichtbar
     */
    @Override
	public void removeVerifingItem() {
        params_bob.getVerifiziert().setVisible(false);
    }

    /**
     * setzt das Protokoll zur??ck
     */
    @Override
	public void reset() {
    	// Reset the textfields for the primes p and q
    	prime.setP("");
    	prime.setQ("");
    	prime.removeException();
    	
        alice.reset();
        bob.reset();
        carol.reset();
        modell.reset();
        removeVerifingItem();
        flow.disableAll();
        flow.setStep(0);
        buttons.enableOK(false);
        buttons.enableMehrmals(false);
        params_bob.verifizieren(false);
    }

    /**
     * setzt alles au??er dem Geheimnis und v zur??ck
     */
    @Override
	public void resetNotSecret() {
        alice.resetNotSecret();
        bob.resetNotSecret();
        carol.resetNotSecret();
        flow.enableFirst();
        flow.setStep(0);
        removeVerifingItem();
        buttons.enableOK(false);
        params_bob.verifizieren(false);
    }

    /**
     * macht in Abh??ngigkeit von b die graphischen Komponenten sichtbar
     *
     * @param b true, wenn die Komponenten f??r den ersten Fall sichtbar sein sollen, false sonst
     */
    @Override
	public void setFirstCase(boolean b) {
        if (b) {
            params_carol.getGroup().dispose();
            params_carol = null;
            paramsAC = new FSParamsAliceCarol(alice, info);
        } else {
            paramsAC.getGroup().dispose();
            paramsAC = null;
            params_carol = new FSParamsAliceCarol(carol, info);
        }
        info.layout(true);

        if (!alice.getSecret().equals(BigInteger.ZERO)) {
            alice.resetNotSecret();
            carol.resetNotSecret();
            flow.enableFirst();
            buttons.enableOK(false);
        }
        bob.resetNotSecret();
        flow.setFirstCase(b);
        removeVerifingItem();
    }

    /**
     * Methode zum Setzen von p im Modell. Wenn q schon gesetzt ist, wird in den einzelnen Modellen
     * n gesetzt.
     *
     * @param p BigInteger Der zu setzende p Wert.
     */
    @Override
	public boolean setP(BigInteger p) {

        modell.setP(p);
        
        if (!modell.getQ().equals(BigInteger.ZERO) &&
        		!modell.getP().equals(BigInteger.ZERO)) {
            alice.setN(p, modell.getQ());
            bob.setN(p, modell.getQ());
            carol.setN(p, modell.getQ());
            
        	prime.setN(alice.getN().toString());
        	
        	setSecret();
        } else {
        	flow.disableAll();
        	buttons.enableMehrmals(false);
        }
        return true;
    }

    /**
     * Methode zum Setzen von q im Modell. Wenn p schon gesetzt ist, wird in den einzelnen Modellen
     * n gesetzt.
     *
     * @param p BigInteger Der zu setzende q Wert.
     */
    @Override
	public boolean setQ(BigInteger q) {

        modell.setQ(q);
        if (!modell.getP().equals(BigInteger.ZERO) &&
        		!modell.getQ().equals(BigInteger.ZERO)) {
            alice.setN(modell.getP(), q);
            bob.setN(modell.getP(), q);
            carol.setN(modell.getP(), q);
            
            prime.setN(getN().toString());
            
            setSecret();
        } else {
        	flow.disableAll();
        	buttons.enableMehrmals(false);
        }
        return true;
    }

    /**
     * Methode zum Updaten der einzelnen Komponenten. Dies geschieht in erster Linie durch das
     * Updaten der einzelnen Komponenten des Composites
     */
    @Override
	public void update(Observable arg0, Object arg1) {
        if (paramsAC != null)
            this.paramsAC.update();
        this.params_bob.update();
        if (params_carol != null)
            this.params_carol.update();
    }

    @Override
    public void setFocus() {
        parent.setFocus();
    }
}
