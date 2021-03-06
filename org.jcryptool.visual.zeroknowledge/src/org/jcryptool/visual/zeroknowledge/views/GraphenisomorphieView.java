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

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.jcryptool.core.util.ui.auto.SmoothScroller;
import org.jcryptool.visual.zeroknowledge.Protocol;
import org.jcryptool.visual.zeroknowledge.algorithm.graphenisomorphie.GAlice;
import org.jcryptool.visual.zeroknowledge.algorithm.graphenisomorphie.GBob;
import org.jcryptool.visual.zeroknowledge.algorithm.graphenisomorphie.GCarol;
import org.jcryptool.visual.zeroknowledge.algorithm.graphenisomorphie.math.Graph;
import org.jcryptool.visual.zeroknowledge.ui.Buttons;
import org.jcryptool.visual.zeroknowledge.ui.Introduction;
import org.jcryptool.visual.zeroknowledge.ui.graphenisomorphie.GFlow;
import org.jcryptool.visual.zeroknowledge.ui.graphenisomorphie.GParamsAliceCarol;
import org.jcryptool.visual.zeroknowledge.ui.graphenisomorphie.GParamsBob;
import org.jcryptool.visual.zeroknowledge.ui.graphenisomorphie.ShowGraphen;
import org.jcryptool.visual.zeroknowledge.ui.graphenisomorphie.Zeichenflaeche;

public class GraphenisomorphieView extends ViewPart implements Observer, Protocol {
	private GAlice alice;
	private GBob bob;
	private Buttons buttons;
	private GCarol carol;
	private boolean firstcase = true;
	private GFlow flow;
	private Zeichenflaeche graphH;
	private Zeichenflaeche graphHGb;
	private ShowGraphen graphAlice;
	private ShowGraphen graphCarol;
	private GParamsAliceCarol paramsAlice;
	private GParamsBob paramsBob;
	private GParamsAliceCarol paramsCarol;
	private Group info;
	private Group action;
	private Composite parent;
	private TitleAndDescriptionComposite titleAndDescription;

	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;

		// Create srollable composite and composite within it
		ScrolledComposite sc = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);

		// gridlayout for elements
		Composite pageComposite = new Composite(sc, SWT.NONE);
		sc.setContent(pageComposite);
		pageComposite.setLayout(new GridLayout());
		
		titleAndDescription = new TitleAndDescriptionComposite(pageComposite);
		titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		titleAndDescription.setTitle(Messages.GraphenisomorphieView_title);
		titleAndDescription.setDescription(Messages.GraphenisomorphieView_text);

		// Modelle
		alice = new GAlice(6);
		bob = new GBob();
		carol = new GCarol(6);

		// bei den Modellen als Observer anmelden
		bob.addObserver(this);
		alice.addObserver(this);
		carol.addObserver(this);

		// Einfuehrung und Auswahl, ob das Geheimnis bekannt sein soll
		new Introduction(this, pageComposite, "G");

		action = new Group(pageComposite, SWT.NONE);
		action.setText(Messages.GraphenisomorphieView_1);
		action.setLayout(new GridLayout());
		action.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		// Label zum Erkl??ren der unterschiedlichen Nummern
		Label label = new Label(action, SWT.NONE);
		label.setText(Messages.GraphenisomorphieView_2);
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		// add Graph to action-flow
		graphAlice = new ShowGraphen(action, alice.getG0(), alice.getG1(), alice);

		// Modul fuer den Durchgang
		flow = new GFlow(this, action);

		buttons = new Buttons(this, action, null, null);

		flow.enableFirst();

		// Layout for information group
		info = new Group(pageComposite, SWT.NONE);
		info.setLayout(new GridLayout(2, true));
		info.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		info.setText(Messages.GraphenisomorphieView_3);

		// Modul zum Darstellen der Parameter von Bob
		paramsBob = new GParamsBob(bob, info);

		// Modul zum Darstellen der Parameter von Alice
		paramsAlice = new GParamsAliceCarol(alice, info);

		// Modul zum Darstellen der Parameter von Carol
		// params_carol = new G_ParamsAliceCarol(carol, info);
		// params_carol.setVisible(false);

		// make whole content scrollable
		sc.setMinSize(pageComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		// This makes the ScrolledComposite scrolling, when the mouse 
		// is on a Text with one or more of the following tags: SWT.READ_ONLY,
		// SWT.V_SCROLL or SWT.H_SCROLL.
		SmoothScroller.scrollSmooth(sc);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				"org.jcryptool.visual.zeroknowledge.graphisomorpismHelpID"); //$NON-NLS-1$
	}

	/**
	 * gibt das Alice-Objekt zur??ck
	 *
	 * @return Alice-Objekt
	 */
	public GAlice getAlice() {
		return alice;
	}

	/**
	 * gibt das Bob-Objekt zur??ck
	 *
	 * @return Bob-Objekt
	 */
	public GBob getBob() {
		return bob;
	}

	/**
	 * gibt das Buttons-Objekt der graphischen Oberfl??che zur??ck
	 *
	 * @return Buttons-Objekt
	 */
	public Buttons getButtons() {
		return buttons;
	}

	/**
	 * gibt das Carol-Objekt zur??ck
	 *
	 * @return Carol-Objekt
	 */
	public GCarol getCarol() {
		return carol;
	}

	/**
	 * gibt den Flow der graphischen Oberfl??che zur??ck
	 *
	 * @return Flow der graphischen Oberfl??che
	 */
	public GFlow getFlow() {
		return flow;
	}

	/**
	 * Methode zum Erhalten des Composites
	 *
	 * @return SheComposite, in der alle graphischen Objekte enthalten sind
	 */
	public Composite getMain() {
		// return main;
		return parent;
	}

	/**
	 * gibt das Objekt zur??ck, das die Parameter von Bob darstellt
	 *
	 * @return Objekt, das die Parameter von Bob darstellt
	 */
	public GParamsBob getParamsBob() {
		return paramsBob;
	}

	/**
	 * gibt zur??ck, ob der erste Fall gesetzt ist.
	 *
	 * @return true, wenn Alice antwortet, sonst false
	 */
	public boolean isFirstcase() {
		return firstcase;
	}

	/**
	 * entfernt die Zeichenfl??che des Graphen H_G_b
	 */
	private void removeH_G_b() {
		if (graphHGb != null) {
			if (!graphHGb.isDisposed()) {
				graphHGb.setVisible(false);
				graphHGb.dispose();
			}
			graphHGb = null;
		}
		if (firstcase) {
			graphAlice.removeH_G_b();
		} else {
			graphCarol.removeH_G_b();
		}
	}

	/**
	 * entfernt die Zeichenfl??che der Graphen H und H_G_b
	 */
	private void removeMiddleGraphs() {
		if (graphH != null) {
			if (!graphH.isDisposed()) {
				graphH.setVisible(false);
				graphH.dispose();
			}
			graphH = null;
		}
		if (graphHGb != null) {
			if (!graphHGb.isDisposed()) {
				graphHGb.setVisible(false);
				graphHGb.dispose();
			}
			graphHGb = null;
		}
		if (graphAlice != null) {
			graphAlice.removeH();
			graphAlice.removeH_G_b();
		} else {
			graphCarol.removeH();
			graphCarol.removeH_G_b();
		}
	}

	/**
	 * macht das "Verifiziert"-Feld unsichtbar
	 */
	public void removeVerifingItem() {
		paramsBob.getVerifiziert().setVisible(false);
	}

	/**
	 * setzt das Protokoll auf seinen Startzustand
	 *
	 * @see Protocol#reset()
	 */
	@Override
	public void reset() {
		alice.reset();
		carol.reset();
		bob.reset();
		alice.generateSecret(6);
		carol.generateSecret(6);
		removeMiddleGraphs();
		removeVerifingItem();
		flow.enableFirst();
		flow.setStep(0);
		buttons.enableOK(false);
		paramsBob.verifizieren(false);
	}

	/**
	 * setzt alle Werte au??er dem Geheimnis, G<sub>0</sub> und G<sub>1</sub> zur??ck
	 *
	 * @see Protocol#resetNotSecret()
	 */
	@Override
	public void resetNotSecret() {
		removeMiddleGraphs();
		alice.resetNotSecret();
		bob.resetNotSecret();
		carol.resetNotSecret();
		buttons.enableOK(false);
		flow.enableFirst();
		flow.setStep(0);
		removeVerifingItem();
		paramsBob.verifizieren(false);
	}

	/**
	 * macht in Abh??ngigkeit von b die graphischen Komponenten sichtbar
	 *
	 * @param b
	 *            true, wenn die Komponenten f??r den ersten Fall sichtbar sein
	 *            sollen, false sonst
	 * @see Protocol#setFirstCase(boolean)
	 */
	@Override
	public void setFirstCase(boolean b) {
		firstcase = b;
		resetNotSecret();
		flow.setFirstCase(b);

		if (b) {
			paramsCarol.getGroup().dispose();
			paramsCarol = null;
			graphCarol.dispose();
			flow.getGroup().dispose();
			flow = null;
			buttons.getGroup().dispose();
			buttons = null;

			paramsAlice = new GParamsAliceCarol(alice, info);
			graphAlice = new ShowGraphen(action, alice.getG0(), alice.getG1(), alice);
		} else {
			paramsAlice.getGroup().dispose();
			paramsAlice = null;
			graphAlice.dispose();
			flow.getGroup().dispose();
			flow = null;
			buttons.getGroup().dispose();
			buttons = null;

			paramsCarol = new GParamsAliceCarol(carol, info);
			graphCarol = new ShowGraphen(action, alice.getG0(), alice.getG1(), carol);
		}
		flow = new GFlow(this, action);
		buttons = new Buttons(this, action, null, null);
		resetNotSecret();
		flow.setFirstCase(b);

		info.layout(true);
		action.layout(true);
	}

	@Override
	public void setFocus() {
		parent.setFocus();
	}

	/**
	 * setzt die Zeichenfl??che des Graphen H (der Graph, den Bob von Alice bzw.
	 * Carol erh??lt)
	 *
	 * @param g
	 *            Graph, den Bob bei seiner ??berpr??fung erh??lt und der gezeichnet
	 *            werden soll
	 */
	public void setH(Graph g) {
		if (graphH != null && !graphH.isDisposed())
			removeMiddleGraphs();
		// if case=alice then set H to alice else to carol
		if (firstcase) {
			graphAlice.setH(g, alice);
			graphH = graphAlice.getH();
		} else {
			graphCarol.setH(g, carol);
			graphH = graphCarol.getH();
		}
	}

	/**
	 * setzt die Zeichenfl??che des Graphen H_G_b (der Graph, den Bob bei seiner
	 * ??berpr??fung erh??lt)
	 *
	 * @param g
	 *            Graph, den Bob bei seiner ??berpr??fung erh??lt und der gezeichnet
	 *            werden soll
	 */
	public void setH_G_b(Graph g) {
		if (graphHGb != null && !graphH.isDisposed()) {
			removeH_G_b();
		}
		if (firstcase) {
			graphAlice.setH_G_b(g, bob);
			graphHGb = graphAlice.getH_G_b();
		} else {
			graphCarol.setH_G_b(g, bob);
			graphHGb = graphCarol.getH_G_b();
		}
	}

	/**
	 * Methode zum Updaten der Hauptframes. Dies geschieht in erster Linie durch das
	 * Updaten der einzelnen Komponenten des MainFrame
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		this.paramsBob.update();
		if (paramsAlice != null) {
			this.paramsAlice.update();
			this.graphAlice.update();
			parent.layout(new Control[] { paramsAlice.getA().getComp(), paramsAlice.getF().getComp(),
					paramsAlice.getG().getComp(), paramsAlice.getH().getComp() });
		} else {
			this.paramsCarol.update();
			this.graphCarol.update();
			parent.layout(new Control[] { paramsCarol.getA().getComp(), paramsCarol.getF().getComp(),
					paramsCarol.getG().getComp(), paramsCarol.getH().getComp() });
		}
	}
}
