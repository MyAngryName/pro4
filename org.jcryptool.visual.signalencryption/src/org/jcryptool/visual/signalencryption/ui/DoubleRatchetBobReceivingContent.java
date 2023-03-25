package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.visual.signalencryption.graphics.ArrowComponent;
import org.jcryptool.visual.signalencryption.graphics.ComponentDrawComposite;
import org.jcryptool.visual.signalencryption.graphics.Positioning.Side;
import org.jcryptool.visual.signalencryption.util.UiUtils;
import static org.jcryptool.visual.signalencryption.ui.PopupUtil.createShowValueFunction;

public class DoubleRatchetBobReceivingContent implements DoubleRatchetEntityContent {
    
    Text txt_bobReceivingStep0;
    Text txt_bobReceivingStep5;
    Text txt_bobReceivingStep6;
    Text txt_bobReceivingStep7;
    Text txt_bobReceivingStep8;
    Text txt_bobReceivingStep9;
    
    FlowChartNode txt_bobRootChain1;
    FlowChartNode txt_bobRootChain2;
    FlowChartNode txt_bobRootChain3;
    FlowChartNode txt_bobReceivingChain1;
    FlowChartNode txt_bobReceivingChain2;
    FlowChartNode txt_bobReceivingChain3;
    FlowChartNode txt_bobReceivingChain4;
    FlowChartNode txt_bobReceivingChain5;
    FlowChartNode txt_bobDiffieHellman1;
    FlowChartNode txt_bobDiffieHellman2;
    FlowChartNode txt_bobDiffieHellman3;
    
    Text txt_bobPlainText;
    Text txt_bobCipherText;
    
    private String bobStep0 = Messages.SignalEncryption_bobDescriptionText0;
    private String bobStep5 = Messages.SignalEncryption_bobStepText5;
    private String step6 = Messages.SignalEncryption_stepText6;
    private String step7 = Messages.SignalEncryption_stepText7;
    private String step8 = Messages.SignalEncryption_stepText8;
    private String step9 = Messages.SignalEncryption_stepText9;
    
    private String bobDiffieHellmanLabel1 = Messages.SignalEncryption_bobDiffieHellmanLabel1;
    private String bobDiffieHellmanLabel2 = Messages.SignalEncryption_bobDiffieHellmanLabel2;
    private String bobDiffieHellmanLabel3 = Messages.SignalEncryption_bobDiffieHellmanLabel3;
    private String bobRootChainLabel1 = Messages.SignalEncryption_bobRootChainLabel1;
    private String bobRootChainLabel2 = Messages.SignalEncryption_bobRootChainLabel2;
    private String bobRootChainLabel3 = Messages.SignalEncryption_bobRootChainLabel3;
    private String bobReceivingChainLabel1 = Messages.SignalEncryption_bobReceivingChainLabel1;
    private String bobReceivingChainLabel2 = Messages.SignalEncryption_bobReceivingChainLabel2;
    private String bobReceivingChainLabel3 = Messages.SignalEncryption_bobReceivingChainLabel3;
    private String bobReceivingChainLabel4 = Messages.SignalEncryption_bobReceivingChainLabel4;
    private String bobReceivingChainLabel5 = Messages.SignalEncryption_bobReceivingChainLabel5;

    protected ArrowComponent arr_bobReceivingChainArrow1;
    protected ArrowComponent arr_bobReceivingChainArrow2;
    protected ArrowComponent arr_bobReceivingChainArrow3;
    protected ArrowComponent arr_bobReceivingChainArrow4;
    protected ArrowComponent arr_bobDiffieHellmanArrow1;
    protected ArrowComponent arr_bobDiffieHellmanArrow2;
    protected ArrowComponent arr_bobRootChainArrow1;
    protected ArrowComponent arr_bobRootChainArrow2;
    protected ArrowComponent arr_bobSpace1;
    protected ArrowComponent arr_bobSpace2;

    Group grp_bobReceivingChain;
    Group grp_bobSpace2;
    Group grp_bobRootChain;
    Group grp_bobSpace1;
    Group grp_bobDiffieHellman;
    Group grp_bobMessagebox;
    Group grp_bobDecryptedMessage;
    
    ComponentDrawComposite cmp_bobReceivingAlgorithm;
    Composite cmp_bobDiffieHellman;
    Composite cmp_bobRootChain;
    ArrowComponent cmp_bobArrowSpace1;
    ArrowComponent cmp_bobArrowSpace2;

    private String MessageboxCipherText = "The Ciphertext";
    private String MessageboxDescription = Messages.SignalEncryption_MessageboxDescription;
    private String RootChainDescription = Messages.SignalEncryption_RootChainDescription;
    private String MessageboxPlainText = "Geben Sie hier Ihre Nachricht an Bob ein.";
    private String DiffieHellmanGroupDescription = Messages.SignalEncryption_DiffieHellmanGroupDescription;
    private String ReceivingChainDescription = Messages.SignalEncryption_ReceivingChainDescription;
    

    @Override
    public Composite buildStepsContent(Composite parent, COMMUNICATION_STATE state) {
        Composite cmp_bobSendingSteps = new Composite(parent, SWT.NONE);
        cmp_bobSendingSteps.setLayout(Layout.gl_stepsComposite());
        
        txt_bobReceivingStep0 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobReceivingStep0.setText(bobStep0);
        txt_bobReceivingStep0.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobReceivingStep5 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobReceivingStep5.setText(bobStep5);
        txt_bobReceivingStep5.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobReceivingStep6 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobReceivingStep6.setText(step6);
        txt_bobReceivingStep6.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobReceivingStep7 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobReceivingStep7.setText(step7);
        txt_bobReceivingStep7.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobReceivingStep8 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobReceivingStep8.setText(step8);
        txt_bobReceivingStep8.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobReceivingStep9 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobReceivingStep9.setText(step9);
        txt_bobReceivingStep9.setLayoutData(Layout.gd_shortDescriptionTexts());
        return cmp_bobSendingSteps;
    }

    @Override
    public Composite buildAlgorithmContent(Composite parent, COMMUNICATION_STATE state) {
    	cmp_bobReceivingAlgorithm = new ComponentDrawComposite(parent, SWT.NONE);
        cmp_bobReceivingAlgorithm.setLayout(Layout.gl_algorithmGroup());
        cmp_bobReceivingAlgorithm.setLayoutData(Layout.gd_algorithmGroup());
        
        grp_bobMessagebox = new Group(cmp_bobReceivingAlgorithm, SWT.NONE);
        grp_bobDiffieHellman = new Group(cmp_bobReceivingAlgorithm, SWT.NONE);
        grp_bobRootChain = new Group(cmp_bobReceivingAlgorithm, SWT.NONE);
        grp_bobReceivingChain = new Group(cmp_bobReceivingAlgorithm, SWT.NONE);
        grp_bobDecryptedMessage = new Group(cmp_bobReceivingAlgorithm, SWT.NONE);
        
        createBobEncryptedMessagebox();
        createBobDiffieHellmanChain();
        createBobRootChain();
        createBobReceivingChain();
        createBobDecryptedMessagebox();
        createBobArrowSpaces();
        return cmp_bobReceivingAlgorithm;
    }

    private void createBobEncryptedMessagebox() {
	    grp_bobMessagebox.setLayout(Layout.gl_messageboxGroup());
	    grp_bobMessagebox.setLayoutData(Layout.gd_messageboxComposite());
	    grp_bobMessagebox.setText(MessageboxDescription);
	
	    txt_bobCipherText = new Text(
	            grp_bobMessagebox,
	            SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY
	    );
	    txt_bobCipherText.setText(MessageboxCipherText);
	    txt_bobCipherText.setLayoutData(Layout.gd_Messagebox());
	    txt_bobCipherText.setEditable(false);
	}
    
    public void setEncryptedMessageBoxVisible(boolean visible) {
    	grp_bobMessagebox.setVisible(visible);
    }

	private void createBobDiffieHellmanChain() {
	    grp_bobDiffieHellman.setText(DiffieHellmanGroupDescription);
	    grp_bobDiffieHellman.setLayout(Layout.gl_diffieHellmanComposite());
	    grp_bobDiffieHellman.setLayoutData(Layout.gd_diffieHellmanComposite());
	
	    txt_bobDiffieHellman1 =  new FlowChartNode.Builder(grp_bobDiffieHellman)
	            .title(bobDiffieHellmanLabel1)
	            .popupProvider(createShowValueFunction("DH key calculation", "0"))
	            .buildOperationNode();
	    txt_bobDiffieHellman1.setLayoutData(Layout.gd_algorithmLabels());
	    
	    UiUtils.insertSpacers(grp_bobDiffieHellman, 1, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);
	
	    txt_bobDiffieHellman2 =  new FlowChartNode.Builder(grp_bobDiffieHellman)
	            .title(bobDiffieHellmanLabel2)
	            .popupProvider(createShowValueFunction("DH key calculation", "0"))
	            .buildOperationNode();
	    txt_bobDiffieHellman2.setLayoutData(Layout.gd_algorithmLabels());
	
	    UiUtils.insertSpacers(grp_bobDiffieHellman, 1, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);
	
	    txt_bobDiffieHellman3 =  new FlowChartNode.Builder(grp_bobDiffieHellman)
	            .title(bobDiffieHellmanLabel3)
	            .popupProvider(createShowValueFunction("DH key calculation", "0"))
	            .buildOperationNode();
	    txt_bobDiffieHellman3.setLayoutData(Layout.gd_algorithmLabels());
	
	    arr_bobDiffieHellmanArrow1 = ArrowComponent
	    	.from(txt_bobDiffieHellman1).south()
	    	.to(txt_bobDiffieHellman2).north()
	    	.on(cmp_bobReceivingAlgorithm)
	    	.withDefaults();
	
	    arr_bobDiffieHellmanArrow2 = ArrowComponent
	    	.from(txt_bobDiffieHellman3).north()
	    	.to(txt_bobDiffieHellman2).south()
	    	.on(cmp_bobReceivingAlgorithm)
	    	.withDefaults();
	
	}
	
    public void setDiffieHellmanChainVisible(boolean visible) {
    	grp_bobDiffieHellman.setVisible(visible);
    	arr_bobDiffieHellmanArrow1.setVisible(visible);
    	arr_bobDiffieHellmanArrow2.setVisible(visible);
    }

	private void createBobRootChain() {
	    grp_bobRootChain.setText(RootChainDescription);
	    grp_bobRootChain.setLayout(Layout.gl_rootChainComposite());
	    grp_bobRootChain.setLayoutData(Layout.gd_rootChainComposite());
	
	    txt_bobRootChain1 =  new FlowChartNode.Builder(grp_bobRootChain)
	            .title(bobRootChainLabel1)
	            .popupProvider(createShowValueFunction("DH key calculation", "0"))
	            .buildOperationNode();
	    txt_bobRootChain1.setLayoutData(Layout.gd_algorithmLabels());
	    
	    UiUtils.insertSpacers(grp_bobRootChain, 1, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);
	
	    txt_bobRootChain2 =  new FlowChartNode.Builder(grp_bobRootChain)
	            .title(bobRootChainLabel2)
	            .popupProvider(createShowValueFunction("DH key calculation", "0"))
	            .buildOperationNode();
	    txt_bobRootChain2.setLayoutData(Layout.gd_algorithmLabels());
	
	    UiUtils.insertSpacers(grp_bobRootChain, 1, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);
	    
	    txt_bobRootChain3 =  new FlowChartNode.Builder(grp_bobRootChain)
	            .title(bobRootChainLabel3)
	            .popupProvider(createShowValueFunction("DH key calculation", "0"))
	            .buildOperationNode();
	    txt_bobRootChain3.setLayoutData(Layout.gd_algorithmLabels());
	    arr_bobRootChainArrow1 = ArrowComponent
	    	.from(txt_bobRootChain1).south()
	    	.to(txt_bobRootChain2).north()
	    	.on(cmp_bobReceivingAlgorithm)
	    	.withDefaults();
	
	    arr_bobRootChainArrow2 = ArrowComponent
	    	.from(txt_bobRootChain2).south()
	    	.to(txt_bobRootChain3).north()
	    	.on(cmp_bobReceivingAlgorithm)
	    	.withDefaults();
	
	}
	
	public void setRootChainVisible(boolean visible) {
		cmp_bobArrowSpace1.setVisible(visible);
		grp_bobRootChain.setVisible(visible);
		arr_bobRootChainArrow1.setVisible(visible);
		arr_bobRootChainArrow2.setVisible(visible);
	}

	private void createBobReceivingChain() {
        grp_bobReceivingChain.setLayout(Layout.gl_sendingReceivingChainComposite(SWT.RIGHT));
        grp_bobReceivingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());
        grp_bobReceivingChain.setText(ReceivingChainDescription);
        
	    UiUtils.insertSpacers(grp_bobReceivingChain, 2);

        txt_bobReceivingChain1 = new FlowChartNode.Builder(grp_bobReceivingChain)
                .title(bobReceivingChainLabel1)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobReceivingChain1.setLayoutData(Layout.gd_algorithmLabels());

	    UiUtils.insertSpacers(grp_bobReceivingChain, 2, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);
	    UiUtils.insertSpacers(grp_bobReceivingChain, 1, ViewConstants.CONSTANT_INLINE);
	    UiUtils.insertSpacers(grp_bobReceivingChain, 2, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);
        
        txt_bobReceivingChain2 =  new FlowChartNode.Builder(grp_bobReceivingChain)
                .title(bobReceivingChainLabel3)
                .popupProvider(createShowValueFunction("Constant", "0"))
                .buildOperationNode();
        txt_bobReceivingChain2.setLayoutData(Layout.gd_algorithmLabels());

        UiUtils.insertSpacers(grp_bobReceivingChain, 1, ViewConstants.ARROW_CANVAS_WIDTH);

        txt_bobReceivingChain3 =  new FlowChartNode.Builder(grp_bobReceivingChain)
                .title(bobReceivingChainLabel2)
                .popupProvider(createShowValueFunction("KDF function", "0"))
                .buildOperationNode();
        txt_bobReceivingChain3.setLayoutData(Layout.gd_algorithmLabels());
        
	    arr_bobReceivingChainArrow1 = ArrowComponent
	    	.from(txt_bobReceivingChain2).east()
	    	.to(txt_bobReceivingChain3).west()
	    	.on(cmp_bobReceivingAlgorithm)
	    	.withDefaults();
	    
	    arr_bobReceivingChainArrow2 = ArrowComponent
	    	.from(txt_bobReceivingChain1).south()
	    	.to(txt_bobReceivingChain3).north()
	    	.on(cmp_bobReceivingAlgorithm)
	    	.withDefaults();

        UiUtils.insertSpacers(grp_bobReceivingChain, 4);

        txt_bobReceivingChain4 =  new FlowChartNode.Builder(grp_bobReceivingChain)
                .title(bobReceivingChainLabel4)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobReceivingChain4.setLayoutData(Layout.gd_algorithmLabels());
        
	    UiUtils.insertSpacers(grp_bobReceivingChain, 2);

        txt_bobReceivingChain5 =  new FlowChartNode.Builder(grp_bobReceivingChain)
                .title(bobReceivingChainLabel5)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobReceivingChain5.setLayoutData(Layout.gd_algorithmLabels());
        
        arr_bobReceivingChainArrow3 = ArrowComponent
	    	.from(txt_bobReceivingChain3).south()
	    	.to(txt_bobReceivingChain5).north()
	    	.on(cmp_bobReceivingAlgorithm)
	    	.withDefaults();
	    arr_bobReceivingChainArrow4 = ArrowComponent.fromAnchors()
	    	.fromAnchorX(txt_bobReceivingChain1, Side.SOUTH)
	    	.fromAnchorY(txt_bobReceivingChain4, Side.WEST)
	    	.outgoingDirection(Side.EAST)
	    	.toAnchorX(txt_bobReceivingChain4, Side.WEST)
	    	.toAnchorY(txt_bobReceivingChain4, Side.WEST)
	    	.incomingDirection(Side.WEST)
	    	.on(cmp_bobReceivingAlgorithm)
	    	.withDefaults();
    }

	public void setReceivingChainVisible(boolean visible) {
		cmp_bobArrowSpace2.setVisible(visible);
		grp_bobReceivingChain.setVisible(visible);
		arr_bobReceivingChainArrow1.setVisible(visible);
		arr_bobReceivingChainArrow2.setVisible(visible);
		arr_bobReceivingChainArrow3.setVisible(visible);
		arr_bobReceivingChainArrow4.setVisible(visible);
    }
	
    private void createBobDecryptedMessagebox() {
	    grp_bobDecryptedMessage.setLayout(Layout.gl_messageboxGroup());
	    grp_bobDecryptedMessage.setLayoutData(Layout.gd_messageboxComposite());
	    grp_bobDecryptedMessage.setText("Entschlüsselte Nachricht");
	    txt_bobPlainText = new Text(
	            grp_bobDecryptedMessage,
	            SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY
	    );
	    txt_bobPlainText.setText(MessageboxPlainText);
	    txt_bobPlainText.setLayoutData(Layout.gd_Messagebox());
	    txt_bobPlainText.setEditable(false);
	}
    
    public void setDecryptedMessageboxVisible(boolean visible) {
    	grp_bobDecryptedMessage.setVisible(visible);
    }

	private void createBobArrowSpaces() {
		cmp_bobArrowSpace1 = ArrowComponent
				.from(grp_bobDiffieHellman, txt_bobDiffieHellman2).east()
				.to(grp_bobRootChain, txt_bobRootChain1).west()
				.on(cmp_bobReceivingAlgorithm)
				.withDefaults();
		cmp_bobArrowSpace2 = ArrowComponent
				.from(grp_bobRootChain, txt_bobRootChain2).east()
				.to(txt_bobReceivingChain1, txt_bobReceivingChain1).west()
				.on(cmp_bobReceivingAlgorithm)
				.breakBetween()
	    	    	.first(grp_bobRootChain, Side.EAST)
	    	    	.second(grp_bobReceivingChain, Side.WEST)
	    	    	.at(ArrowComponent.BREAK_CENTER)
	    	    .arrowId("cmp_bobArrowSpace2")
				.withDefaults();
    }
	
	public void setAllVisible(boolean visible) {
		setEncryptedMessageBoxVisible(visible);
		setDiffieHellmanChainVisible(visible);
		setRootChainVisible(visible);
		setReceivingChainVisible(visible);
		setDecryptedMessageboxVisible(visible);
	}

}
