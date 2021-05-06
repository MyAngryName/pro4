// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2011, 2021 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----

package org.jcryptool.visual.aco.controller;

import org.jcryptool.visual.aco.model.CommonModel;
import org.jcryptool.visual.aco.view.AntColAnalysisComposite;
import org.jcryptool.visual.aco.view.AntColView;

public class AntColAnalysisController implements
		AntColEvents {

	private AntColEventController registry;
	private CommonModel model;
	private AntColAnalysisComposite analysisComp;

	public AntColAnalysisController(CommonModel model, AntColView view,
			AntColEventController antColControllerRegistry) {
		this.model = model;
		this.analysisComp = view.getAnalysisComp();
		this.registry = antColControllerRegistry;
	}

	public void onSelectShowMatrix() {
		analysisComp.setEnabledAnimationCheckbox(false);
		analysisComp.setAnimationCheckboxValue(false);
	}

	public void onSelectShowGraph() {
		analysisComp.setEnabledAnimationCheckbox(true);
		analysisComp.setAnimationCheckboxValue(true);
	}

	public void afterGraphDrawn() {
		analysisComp.setEnabled(true);
		if (model.isSingleStep()) {
			boolean isAtLastKnot = model.isAtLastKnot();
			analysisComp.setEnabledFinishCycleButton(!isAtLastKnot);
			analysisComp.setEnabledNextKnotButton(!isAtLastKnot);
			analysisComp.setEnabledPlaceAntButton(isAtLastKnot);
		} else {
			analysisComp.setEnabledAnimationCheckbox(false);
		}

		if (!model.isVisualizable()) {
			analysisComp.setEnabledAnimationCheckbox(false);
			analysisComp.setEnabledStepRadioGroup(false);
		}
		if(!model.isGraphDisplayed()){
			analysisComp.setEnabledAnimationCheckbox(false);
		}
	}

	public void onFinishCycle() {
		analysisComp.setEnabled(false);
	}

	public void onNextKnot() {
		analysisComp.setEnabled(false);
	}

	public void onSelectMultipleStep() {
		analysisComp.setEnabledPlaceAntButton(true);

		analysisComp.setEnabledAnimationCheckbox(false);
		analysisComp.setAnimationCheckboxValue(false);
		registry.onChangeAnimationCheckboxValue(false);
		analysisComp.setNumberOfIterationSpinner(1);
	}

	public void onSelectSingleStep() {
		refreshButtons();
		if (model.isVisualizable() && model.isGraphDisplayed()) {
			analysisComp.setEnabledAnimationCheckbox(true);
		} else {

			analysisComp.setEnabledAnimationCheckbox(false);
		}
		analysisComp.setNumberOfIterationSpinner(1);
	}

	public void onModifyConfiguration() {
		analysisComp.setEnabled(false);
	}

	public void onNewIteration() {
		if (model.getTrail().size() == model.getSize()) {
			model.replaceAnt();
		}

		analysisComp.setEnabledNewIterationButton(false);
		int counter = analysisComp.getNumberOfIterationSpinnerValue();
		while (counter > 0) {
			if (counter == 1) {
				analysisComp.setEnabledNewIterationButton(true);
			}

			registry.onFinishCycle();// model.finishCycle();
			if (counter != 1) {
				model.replaceAnt();
			}
			counter--;
		}
	}

	public void onPlaceNewAnt() {
		refreshButtons();
	}

	@Override
	public void onStartAnalyseButtonClick() {
		analysisComp.setEnabled(true);
		refreshButtons();

		if (!model.isVisualizable()) {
			analysisComp.setEnabledAnimationCheckbox(false);
			analysisComp.setAnimationCheckboxValue(false);
			
			analysisComp.setEnabledStepRadioGroup(false);
			analysisComp.setSingleStepSelected(false);
		}
		model.setAnimateable(analysisComp.getAnimationCheckboxValue());
		analysisComp.layout();
	}

	@Override
	public void onSelectMultipleSteps() {
	 

	}

	private void refreshButtons() {
		boolean atLastKnot = model.isAtLastKnot();
		analysisComp.setEnabledPlaceAntButton(atLastKnot);
		analysisComp.setEnabledNextKnotButton(!atLastKnot);
		analysisComp.setEnabledFinishCycleButton(!atLastKnot);
	}
	
	public void onKeyLengthChange(int value, int oldValue){
		if(value > 5){
			model.setSingleStep(false);
			analysisComp.setSingleStepSelected(false);
			analysisComp.setAnimationCheckboxValue(false);
			analysisComp.setTopLayout(analysisComp.getMultipleIterationComp());
		} else {
			model.setSingleStep(true);
			analysisComp.setSingleStepSelected(true);
			analysisComp.setAnimationCheckboxValue(true);
			analysisComp.setTopLayout(analysisComp.getStepByStepComp());
		}
	}

	@Override
	public void onChangeAnimationCheckboxValue(boolean value) {
	}

	@Override
	public void onConfigurationChange() {
	}

	@Override
	public void onGenerateText() {
	 
		
	}

	@Override
	public void onCipherTextModify(String text) {
	 
		
	}

	@Override
	public void onAlphaChanged(double value) {
	 
		
	}

	@Override
	public void onBetaChanged(double value) {
	 
		
	}

	@Override
	public void onPheromoneChanged(double value) {

		
	}

	@Override
	public void onStopAnalyseButtonClick() {	
		analysisComp.setEnabled(false);
	}

}
