package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.visual.signalencryption.graphics.ArrowComponent;
import org.jcryptool.visual.signalencryption.graphics.ComponentDrawComposite;
import org.jcryptool.visual.signalencryption.graphics.ImageComponent;
import org.jcryptool.visual.signalencryption.graphics.Positioning.Side;
import org.jcryptool.visual.signalencryption.util.UiUtils;
import static org.jcryptool.visual.signalencryption.ui.PopupUtil.createShowValueFunction;

public class DoubleRatchetAliceSendingContent implements DoubleRatchetEntityContent {
    
    Text txt_aliceSendingStep0;
    Text txt_aliceSendingStep1;
    Text txt_aliceSendingStep2;
    Text txt_aliceSendingStep3;
    Text txt_aliceSendingStep4;
    Text txt_aliceSendingStep5;
   
    FlowChartNode txt_aliceDiffieHellman1;
    FlowChartNode txt_aliceDiffieHellman2;
    FlowChartNode txt_aliceDiffieHellman3;
	FlowChartNode txt_aliceRootChain0;
    FlowChartNode txt_aliceRootChain1;
    FlowChartNode txt_aliceRootChain2;
    FlowChartNode txt_aliceRootChain3;
    FlowChartNode txt_aliceSendingChain1;
    FlowChartNode txt_aliceSendingChain2;
    FlowChartNode txt_aliceSendingChain3;
    FlowChartNode txt_aliceSendingChain4;
    FlowChartNode txt_aliceSendingChain5;

    Text txt_alicePlainText;
    Text txt_aliceCipherText;

    ComponentDrawComposite cmp_aliceSendingAlgorithm;
    Composite cmp_aliceDiffieHellman;
    Composite cmp_aliceRootChain;
    Composite cmp_aliceSteps;
    Composite cmp_aliceMessagebox;
    Composite cmp_bobMessagebox;

    Group grp_aliceDiffieHellman;
    Group grp_aliceRootChain;
    Group grp_aliceSendingChain;
    Group grp_aliceMessagebox;
    
    private String msg_aliceSendingStep0 = Messages.SignalEncryption_aliceDescriptionText0;
    private String msg_aliceSendingStep1 = Messages.SignalEncryption_stepText1;
    private String msg_aliceSendingStep2 = Messages.SignalEncryption_stepText2;
    private String msg_aliceSendingStep3 = Messages.SignalEncryption_stepText3;
    private String msg_aliceSendingStep4 = Messages.SignalEncryption_stepText4;
    private String msg_aliceSendingStep5 = Messages.SignalEncryption_aliceStepText5;
    
    private String aliceDiffieHellmanLabel1 = Messages.SignalEncryption_aliceDiffieHellmanLabel1;
    private String aliceDiffieHellmanLabel2 = Messages.SignalEncryption_aliceDiffieHellmanLabel2;
    private String aliceDiffieHellmanLabel3 = Messages.SignalEncryption_aliceDiffieHellmanLabel3;
    private String aliceRootChainLabel1 = Messages.SignalEncryption_aliceRootChainLabel1;
    private String aliceRootChainLabel2 = Messages.SignalEncryption_aliceRootChainLabel2;
    private String aliceRootChainLabel3 = Messages.SignalEncryption_aliceRootChainLabel3;
    private String aliceSendingChainLabel1 = Messages.SignalEncryption_aliceSendingChainLabel1;
    private String aliceSendingChainLabel2 = Messages.SignalEncryption_aliceSendingChainLabel2;
    private String aliceSendingChainLabel3 = Messages.SignalEncryption_aliceSendingChainLabel3;
    private String aliceSendingChainLabel4 = Messages.SignalEncryption_aliceSendingChainLabel4;
    private String aliceSendingChainLabel5 = Messages.SignalEncryption_aliceSendingChainLabel5;
    
    private String DiffieHellmanGroupDescription = Messages.SignalEncryption_DiffieHellmanGroupDescription;
    private String RootChainDescription = Messages.SignalEncryption_RootChainDescription;
    private String MessageboxDescription = Messages.SignalEncryption_MessageboxDescription;
    private String SendingChainDescription = Messages.SignalEncryption_SendingChainDescription;
    
    protected ArrowComponent arr_aliceDiffieHellmanArrow1;
    protected ArrowComponent arr_aliceDiffieHellmanArrow2;
    protected ArrowComponent arr_aliceRootChainArrow1;
    protected ArrowComponent arr_aliceRootChainArrow2;
    protected ArrowComponent arr_aliceSendingChainArrow1;
    protected ArrowComponent arr_aliceSendingChainArrow2;
    protected ArrowComponent arr_aliceSendingChainArrow3;
    protected ArrowComponent arr_aliceSendingChainArrow4;
    protected ArrowComponent arr_aliceReceivingChainArrow1;
    protected ArrowComponent arr_aliceReceivingChainArrow2;
    protected ArrowComponent arr_aliceReceivingChainArrow3;
    protected ArrowComponent arr_aliceReceivingChainArrow4;
    
    protected ArrowComponent cmp_aliceArrowSpace1;
    protected ArrowComponent cmp_aliceArrowSpace2;
    protected ImageComponent drw_outgoingMailIcon;

    @Override
    public Composite buildStepsContent(Composite parent, COMMUNICATION_STATE state) {
        var cmp_aliceSendingSteps = new Composite(parent, SWT.NONE);
        cmp_aliceSendingSteps.setLayout(Layout.gl_stepsComposite());
        
        txt_aliceSendingStep0 = new Text(cmp_aliceSendingSteps, SWT.WRAP | SWT.READ_ONLY);
        txt_aliceSendingStep0.setText(msg_aliceSendingStep0);
        txt_aliceSendingStep0.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_aliceSendingStep1 = new Text(cmp_aliceSendingSteps, SWT.WRAP | SWT.READ_ONLY);
        txt_aliceSendingStep1.setText(msg_aliceSendingStep1);
        txt_aliceSendingStep1.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_aliceSendingStep2 = new Text(cmp_aliceSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_aliceSendingStep2.setText(msg_aliceSendingStep2);
        txt_aliceSendingStep2.setLayoutData(Layout.gd_longDescriptionTexts());
        txt_aliceSendingStep3 = new Text(cmp_aliceSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_aliceSendingStep3.setText(msg_aliceSendingStep3);
        txt_aliceSendingStep3.setLayoutData(Layout.gd_longDescriptionTexts());
        txt_aliceSendingStep4 = new Text(cmp_aliceSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_aliceSendingStep4.setText(msg_aliceSendingStep4);
        txt_aliceSendingStep4.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_aliceSendingStep5 = new Text(cmp_aliceSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_aliceSendingStep5.setText(msg_aliceSendingStep5);
        txt_aliceSendingStep5.setLayoutData(Layout.gd_longDescriptionTexts());
        return cmp_aliceSendingSteps;
    }

    @Override
    public ComponentDrawComposite buildAlgorithmContent(Composite parent, COMMUNICATION_STATE state) {
        cmp_aliceSendingAlgorithm = new ComponentDrawComposite(parent, SWT.NONE);
        cmp_aliceSendingAlgorithm.setLayout(Layout.gl_algorithmGroup());
        cmp_aliceSendingAlgorithm.setLayoutData(Layout.gd_algorithmGroup());
        
        grp_aliceDiffieHellman = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceRootChain = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceSendingChain = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceMessagebox = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        
        createAliceDiffieHellmanChain();
        createAliceRootChain();
        createAliceSendingChain();
        createAliceMessagebox();
        createAliceArrowSpaces();
        
        return cmp_aliceSendingAlgorithm;
    }
    
    private void createAliceDiffieHellmanChain() {
	    grp_aliceDiffieHellman.setText(DiffieHellmanGroupDescription);
	    grp_aliceDiffieHellman.setLayout(Layout.gl_diffieHellmanComposite());
	    grp_aliceDiffieHellman.setLayoutData(Layout.gd_diffieHellmanComposite());
	
	    txt_aliceDiffieHellman1 = new FlowChartNode.Builder(grp_aliceDiffieHellman)
	            .title(aliceDiffieHellmanLabel1)
	            .popupProvider(createShowValueFunction("Alice Diffie Hellman Key", "1"))
	            .buildValueNode();
	    
	    txt_aliceDiffieHellman1.setLayoutData(Layout.gd_algorithmLabels());
	    
	    UiUtils.insertSpacers(grp_aliceDiffieHellman, 1, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);
	
	    txt_aliceDiffieHellman2 = new FlowChartNode.Builder(grp_aliceDiffieHellman)
	            .title(aliceDiffieHellmanLabel2)
	            .popupProvider(createShowValueFunction("DH key calculation", "2"))
	            .buildOperationNode();
	    txt_aliceDiffieHellman2.setLayoutData(Layout.gd_algorithmLabels());
	    
	    UiUtils.insertSpacers(grp_aliceDiffieHellman, 1, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);
	
	    txt_aliceDiffieHellman3 = new FlowChartNode.Builder(grp_aliceDiffieHellman)
	            .title(aliceDiffieHellmanLabel3)
	            .popupProvider(createShowValueFunction("Bob Public Key", "2"))
	            .buildOperationNode();
	    txt_aliceDiffieHellman3.setLayoutData(Layout.gd_algorithmLabels());
	
	    arr_aliceDiffieHellmanArrow1 = ArrowComponent
	    	.from(txt_aliceDiffieHellman1).south()
	    	.to(txt_aliceDiffieHellman2).north()
	    	.on(cmp_aliceSendingAlgorithm)
	    	.withDefaults();
	
	    arr_aliceDiffieHellmanArrow2 = ArrowComponent
	    	.from(txt_aliceDiffieHellman3).north()
	    	.to(txt_aliceDiffieHellman2).south()
	    	.on(cmp_aliceSendingAlgorithm)
	    	.withDefaults();
	}
    
    public void setDiffieHellmanChainVisible(boolean visible) {
    	grp_aliceDiffieHellman.setVisible(visible);
    	arr_aliceDiffieHellmanArrow1.setVisible(visible);
    	arr_aliceDiffieHellmanArrow2.setVisible(visible);
    }

	private void createAliceRootChain() {
        grp_aliceRootChain.setText(RootChainDescription);
        grp_aliceRootChain.setLayout(Layout.gl_rootChainComposite(SWT.LEFT));
        grp_aliceRootChain.setLayoutData(Layout.gd_rootChainComposite());
        
        txt_aliceRootChain0 = new FlowChartNode.Builder(grp_aliceRootChain)
        		.title(aliceSendingChainLabel2)
        		.popupProvider(createShowValueFunction("Root Chain constant", "WhisperChain"))
        		.buildValueNode();
        txt_aliceRootChain0.setLayoutData(Layout.gd_algorithmLabels());

        txt_aliceRootChain1 = new FlowChartNode.Builder(grp_aliceRootChain)
                .title(aliceRootChainLabel1)
                .popupProvider(createShowValueFunction("Root chain key", "4"))
                .buildValueNode();
        txt_aliceRootChain1.setLayoutData(Layout.gd_algorithmLabels());
        
	    UiUtils.insertSpacers(grp_aliceRootChain, 3, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);

        txt_aliceRootChain2 = new FlowChartNode.Builder(grp_aliceRootChain)
                .title(aliceRootChainLabel2)
                .popupProvider(createShowValueFunction("Key Derivation Function", "5"))
                .buildOperationNode();
        txt_aliceRootChain2.setLayoutData(Layout.gd_algorithmLabels());
        
        UiUtils.insertSpacers(grp_aliceRootChain, 3, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);

        txt_aliceRootChain3 = new FlowChartNode.Builder(grp_aliceRootChain)
                .title(aliceRootChainLabel3)
                .popupProvider(createShowValueFunction("New root chain key", "6"))
                .buildValueNode();
        txt_aliceRootChain3.setLayoutData(Layout.gd_algorithmLabels());

        arr_aliceRootChainArrow1 = ArrowComponent
        	.from(txt_aliceRootChain1).south()
        	.to(txt_aliceRootChain2).north()
        	.on(cmp_aliceSendingAlgorithm)
        	.withDefaults();

        arr_aliceRootChainArrow2 = ArrowComponent
        	.from(txt_aliceRootChain2).south()
        	.to(txt_aliceRootChain3).north()
        	.on(cmp_aliceSendingAlgorithm)
        	.withDefaults();
    }
	
	public void setRootChainVisible(boolean visible) {
		cmp_aliceArrowSpace1.setVisible(visible);
		grp_aliceRootChain.setVisible(visible);
		arr_aliceRootChainArrow1.setVisible(visible);
		arr_aliceRootChainArrow2.setVisible(visible);
	}

    private void createAliceSendingChain() {
	    grp_aliceSendingChain.setLayout(Layout.gl_sendingReceivingChainComposite(SWT.LEFT));
	    grp_aliceSendingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());
	    grp_aliceSendingChain.setText(SendingChainDescription);
	
	    txt_aliceSendingChain2 = new FlowChartNode.Builder(grp_aliceSendingChain)
	            .title(aliceSendingChainLabel2)
	            .popupProvider(createShowValueFunction("Konstanter Wert", "8 (konstant)"))
	            .buildValueNode();
	    txt_aliceSendingChain2.setLayoutData(Layout.gd_algorithmLabels());

	    txt_aliceSendingChain1 = new FlowChartNode.Builder(grp_aliceSendingChain)
	            .title(aliceSendingChainLabel1)
	            .popupProvider(createShowValueFunction("Sending Chain Key", "7"))
	            .buildValueNode();
	    txt_aliceSendingChain1.setLayoutData(Layout.gd_algorithmLabels());
	    
	    UiUtils.insertSpacers(grp_aliceSendingChain, 5, ViewConstants.BOX_WIDTH, ViewConstants.BOX_HEIGHT);
	
	    txt_aliceSendingChain3 = new FlowChartNode.Builder(grp_aliceSendingChain)
	            .title(aliceSendingChainLabel3)
	            .popupProvider(createShowValueFunction("KDF", "9"))
	            .buildOperationNode();
	    txt_aliceSendingChain3.setLayoutData(Layout.gd_algorithmLabels());
	    
	    arr_aliceSendingChainArrow1 = ArrowComponent
	    	.from(txt_aliceSendingChain2).east()
	    	.to(txt_aliceSendingChain1).west()
	    	.on(cmp_aliceSendingAlgorithm)
	    	.withDefaults();
	
	    arr_aliceSendingChainArrow2 = ArrowComponent
	    	.from(txt_aliceSendingChain1).south()
	    	.to(txt_aliceSendingChain3).north()
	    	.on(cmp_aliceSendingAlgorithm)
	    	.withDefaults();
	    
	    UiUtils.insertSpacers(grp_aliceSendingChain, 3);
	
	    txt_aliceSendingChain4 = new FlowChartNode.Builder(grp_aliceSendingChain)
	            .title(aliceSendingChainLabel4)
	            .popupProvider(createShowValueFunction("Neuer Sending Chain Key", "10"))
	            .buildValueNode();
	    txt_aliceSendingChain4.setLayoutData(Layout.gd_algorithmLabels());
	
	    UiUtils.insertSpacers(grp_aliceSendingChain, 1);
	
	    txt_aliceSendingChain5 = new FlowChartNode.Builder(grp_aliceSendingChain)
	            .title(aliceSendingChainLabel5)
	            .popupProvider(createShowValueFunction("Message Key", "11"))
	            .buildValueNode();
	    txt_aliceSendingChain5.setLayoutData(Layout.gd_algorithmLabels());
	    
	    arr_aliceSendingChainArrow3 = ArrowComponent
	    	.from(txt_aliceSendingChain3).south()
	    	.to(txt_aliceSendingChain5).north()
	    	.on(cmp_aliceSendingAlgorithm)
	    	.withDefaults();
	    arr_aliceSendingChainArrow4 = ArrowComponent.fromAnchors()
	    	.fromAnchorX(txt_aliceSendingChain1, Side.SOUTH)
	    	.fromAnchorY(txt_aliceSendingChain4, Side.WEST)
	    	.outgoingDirection(Side.EAST)
	    	.toAnchorX(txt_aliceSendingChain4, Side.WEST)
	    	.toAnchorY(txt_aliceSendingChain4, Side.WEST)
	    	.incomingDirection(Side.WEST)
	    	.on(cmp_aliceSendingAlgorithm)
	    	.withDefaults();
	}

    public void setSendingChainVisible(boolean visible) {
		cmp_aliceArrowSpace2.setVisible(visible);
		grp_aliceSendingChain.setVisible(visible);
		arr_aliceSendingChainArrow1.setVisible(visible);
		arr_aliceSendingChainArrow2.setVisible(visible);
		arr_aliceSendingChainArrow3.setVisible(visible);
		arr_aliceSendingChainArrow4.setVisible(visible);
    }

	private void createAliceMessagebox() {
	    grp_aliceMessagebox.setLayout(Layout.gl_messageboxGroup());
	
	    grp_aliceMessagebox.setLayoutData(Layout.gd_messageboxComposite());
	    grp_aliceMessagebox.setText(MessageboxDescription);
	
	    txt_alicePlainText = new Text(grp_aliceMessagebox,
	            SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    txt_alicePlainText.setLayoutData(Layout.gd_Messagebox());
	
	    txt_aliceCipherText = new Text(grp_aliceMessagebox,
	            SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
	    txt_aliceCipherText.setLayoutData(Layout.gd_Messagebox());
	
	    txt_aliceCipherText.setText("Encrypted Message");
	    txt_alicePlainText.setTextLimit(256);
	    txt_alicePlainText.setEditable(true);
	    
	    drw_outgoingMailIcon = ImageComponent.on(cmp_aliceSendingAlgorithm)
	    	.relativeTo(txt_aliceCipherText, Side.EAST)
	    	.offsetX(ViewConstants.MAIL_ICON_X_OFFSET)
	    	.outgoingMail();
	    
	    // This one is a special spacer: it doesn't have any content but ensures that the image drawn
	    // (which does NOT have a concept of layouting) has enough space to be drawn.
	    // This is necessary because the icon is the last element of the view.
	    var requiredWidth =  drw_outgoingMailIcon.imageWidth() + ViewConstants.MAIL_ICON_X_OFFSET - ViewConstants.ARROW_CANVAS_WIDTH;
	    // TODO Investigate the resizing-bug regarding this control
	    //   Note, I think the spacing comes from that I only adapted half of the composites.
	    //   Since it's a stacked layout it still uses the largest underneath which is invisible.
	    UiUtils.insertSpacers(cmp_aliceSendingAlgorithm, 1, requiredWidth - 5);
	}
	
	public void setMessageBoxVisible(boolean visible) {
		grp_aliceMessagebox.setVisible(visible);
		txt_alicePlainText.setVisible(visible);
		txt_aliceCipherText.setVisible(visible);
		drw_outgoingMailIcon.setVisible(visible);
	}
	
	public void showOnlyMessagePlaintext() {
		setMessageBoxVisible(true);
		txt_alicePlainText.setVisible(true);
		txt_aliceCipherText.setVisible(false);
		drw_outgoingMailIcon.setVisible(false);
	}
	
	private void createAliceArrowSpaces() {
		cmp_aliceArrowSpace1 = ArrowComponent
				.from(grp_aliceDiffieHellman, txt_aliceDiffieHellman2).east()
				.to(txt_aliceRootChain2, txt_aliceRootChain2).west()
				.on(cmp_aliceSendingAlgorithm)
				.withDefaults();
		
		cmp_aliceArrowSpace2 = ArrowComponent
				.from(grp_aliceRootChain, txt_aliceRootChain2).east()
				.to(txt_aliceSendingChain3, txt_aliceSendingChain3).west()
				.on(cmp_aliceSendingAlgorithm)
				// Check bug for off-by-one position
				.breakBetween()
	    	    	.first(grp_aliceRootChain, Side.EAST)
	    	    	.second(grp_aliceSendingChain, Side.WEST)
	    	    	.at(0.0)
	    	    .arrowId("cmp_aliceArrowSpace2")
				.withDefaults();
	}
	
	public void setAllVisible(boolean visible) {
		setDiffieHellmanChainVisible(visible);
		setRootChainVisible(visible);
		setSendingChainVisible(visible);
		setMessageBoxVisible(visible);
	}
}
