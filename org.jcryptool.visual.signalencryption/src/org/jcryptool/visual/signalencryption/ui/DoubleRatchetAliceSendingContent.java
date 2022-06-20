package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
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

    Composite cmp_aliceDiffieHellman;
    Composite cmp_aliceRootChain;
    Composite cmp_aliceSteps;
    Composite cmp_aliceMessagebox;
    Composite cmp_bobMessagebox;
    Composite cmp_aliceArrowSpace1;
    Composite cmp_aliceArrowSpace2;

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
    
    protected Canvas arr_aliceDiffieHellmanArrow1;
    protected Canvas arr_aliceDiffieHellmanArrow2;
    protected Canvas arr_aliceRootChainArrow1;
    protected Canvas arr_aliceRootChainArrow2;
    protected Canvas arr_aliceSendingChainArrow1;
    protected Canvas arr_aliceSendingChainArrow2;
    protected Canvas arr_aliceSendingChainArrow3;
    protected Canvas arr_aliceSendingChainArrow4;
    protected Canvas arr_aliceReceivingChainArrow1;
    protected Canvas arr_aliceReceivingChainArrow2;
    protected Canvas arr_aliceReceivingChainArrow3;
    protected Canvas arr_aliceReceivingChainArrow4;
    protected Canvas arr_aliceSpace1;
    protected Canvas arr_aliceSpace2;

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
    public Composite buildAlgorithmContent(Composite parent, COMMUNICATION_STATE state) {
        var cmp_aliceSendingAlgorithm = new Composite(parent, SWT.NONE);
        cmp_aliceSendingAlgorithm.setLayout(Layout.gl_algorithmGroup());
        cmp_aliceSendingAlgorithm.setLayoutData(Layout.gd_algorithmGroup());
        
        grp_aliceDiffieHellman = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        cmp_aliceArrowSpace1 = new Composite(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceRootChain = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        cmp_aliceArrowSpace2 = new Composite(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceSendingChain = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceMessagebox = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        
        createAliceDiffieHellmanChain();
        createAliceRootChain();
        createAliceSendingChain();
        createAliceMessagebox();
        createAliceArrowSpaces();
        
        return cmp_aliceSendingAlgorithm;
    }
    
    private void createAliceArrowSpaces() {
        cmp_aliceArrowSpace1.setLayout(Layout.gl_arrowSpaceComposite());
        cmp_aliceArrowSpace1.setLayoutData(Layout.gd_arrowSpaceComposite());
        
        //System.out.print(calculateConnectingArrowMargin());
        // arrow up
        arr_aliceSpace1 = new Canvas(cmp_aliceArrowSpace1, SWT.DOUBLE_BUFFERED);
        arr_aliceSpace1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL,
                SWT.FILL,
                false,
                false,
                1,
                1,
                ViewConstants.ARROW_CANVAS_WIDTH,
                // Note that we need the border width of any text, so we use an initialized one.
                Layout.calculateConnectingArrowHeight(txt_aliceDiffieHellman2.getBorderWidth())
        ));
        arr_aliceSpace1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawRightUpRightArrow(
                        arr_aliceSpace1, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        cmp_aliceArrowSpace2.setLayout(Layout.gl_arrowSpaceComposite());
        cmp_aliceArrowSpace2.setLayoutData(Layout.gd_arrowSpaceComposite());

        // arrow up
        arr_aliceSpace2 = new Canvas(cmp_aliceArrowSpace2, SWT.DOUBLE_BUFFERED);
        arr_aliceSpace2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL,
                SWT.FILL,
                false,
                false,
                1,
                1,
                ViewConstants.ARROW_CANVAS_WIDTH,
                // Note that we need the border width of any text, so we use an initialized one.
                Layout.calculateConnectingArrowHeight(txt_aliceDiffieHellman2.getBorderWidth())
        ));
        arr_aliceSpace2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawRightUpRightLine(
                        arr_aliceSpace2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
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

        // arrow down
        arr_aliceDiffieHellmanArrow1 = new Canvas(grp_aliceDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_aliceDiffieHellmanArrow1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, SWT.DEFAULT, ViewConstants.UP_DOWN_ARROW_SIZE
        ));
        arr_aliceDiffieHellmanArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownArrow(
                        arr_aliceDiffieHellmanArrow1, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceDiffieHellman2 = new FlowChartNode.Builder(grp_aliceDiffieHellman)
                .title(aliceDiffieHellmanLabel2)
                .popupProvider(createShowValueFunction("DH key calculation", "2"))
                .buildOperationNode();
        txt_aliceDiffieHellman2.setLayoutData(Layout.gd_algorithmLabels());

        // arrow up
        arr_aliceDiffieHellmanArrow2 = new Canvas(grp_aliceDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_aliceDiffieHellmanArrow2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceDiffieHellmanArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawUpArrow(
                        arr_aliceDiffieHellmanArrow2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceDiffieHellman3 = new FlowChartNode.Builder(grp_aliceDiffieHellman)
                .title(aliceDiffieHellmanLabel3)
                .popupProvider(createShowValueFunction("Bob Public Key", "2"))
                .buildOperationNode();
        txt_aliceDiffieHellman3.setLayoutData(Layout.gd_algorithmLabels());
    }

    private void createAliceRootChain() {
        grp_aliceRootChain.setText(RootChainDescription);
        grp_aliceRootChain.setLayout(Layout.gl_rootChainComposite());
        grp_aliceRootChain.setLayoutData(Layout.gd_rootChainComposite());

        txt_aliceRootChain1 = new FlowChartNode.Builder(grp_aliceRootChain)
                .title(aliceRootChainLabel1)
                .popupProvider(createShowValueFunction("Root chain key", "4"))
                .buildValueNode();
        txt_aliceRootChain1.setLayoutData(Layout.gd_algorithmLabels());

        // arrow down
        arr_aliceRootChainArrow1 = new Canvas(grp_aliceRootChain, SWT.DOUBLE_BUFFERED);
        arr_aliceRootChainArrow1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceRootChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownArrow(
                        arr_aliceRootChainArrow1, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceRootChain2 = new FlowChartNode.Builder(grp_aliceRootChain)
                .title(aliceRootChainLabel2)
                .popupProvider(createShowValueFunction("Key Derivation Function", "5"))
                .buildOperationNode();
        txt_aliceRootChain2.setLayoutData(Layout.gd_algorithmLabels());

        // arrow down
        arr_aliceRootChainArrow2 = new Canvas(grp_aliceRootChain, SWT.DOUBLE_BUFFERED);
        arr_aliceRootChainArrow2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceRootChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownArrow(
                        arr_aliceRootChainArrow2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceRootChain3 = new FlowChartNode.Builder(grp_aliceRootChain)
                .title(aliceRootChainLabel3)
                .popupProvider(createShowValueFunction("New root chain key", "6"))
                .buildValueNode();
        txt_aliceRootChain3.setLayoutData(Layout.gd_algorithmLabels());

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

    }

    private void createAliceSendingChain() {
        grp_aliceSendingChain.setLayout(Layout.gl_sendingReceivingChainComposite(SWT.LEFT));
        grp_aliceSendingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());
        grp_aliceSendingChain.setText(SendingChainDescription);

        // arrow down
        arr_aliceSendingChainArrow4 = new Canvas(grp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow4.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 2, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceSendingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawRightArrow(
                        arr_aliceSendingChainArrow4, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceSendingChain1 = new FlowChartNode.Builder(grp_aliceSendingChain)
                .title(aliceSendingChainLabel1)
                .popupProvider(createShowValueFunction("Sending Chain Key", "7"))
                .buildValueNode();
        txt_aliceSendingChain1.setLayoutData(Layout.gd_algorithmLabels());
        
        UiUtils.insertSpacers(grp_aliceSendingChain, 3);

        // arrow down
        arr_aliceSendingChainArrow1 = new Canvas(grp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceSendingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownArrow(
                        arr_aliceSendingChainArrow1, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        UiUtils.insertSpacers(grp_aliceSendingChain, 1);

        txt_aliceSendingChain2 = new FlowChartNode.Builder(grp_aliceSendingChain)
                .title(aliceSendingChainLabel2)
                .popupProvider(createShowValueFunction("Konstanter Wert", "8 (konstant)"))
                .buildValueNode();
        txt_aliceSendingChain2.setLayoutData(Layout.gd_algorithmLabels());

        // arrow right
        arr_aliceSendingChainArrow2 = new Canvas(grp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceSendingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawRightArrow(
                        arr_aliceSendingChainArrow2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceSendingChain3 = new FlowChartNode.Builder(grp_aliceSendingChain)
                .title(aliceSendingChainLabel3)
                .popupProvider(createShowValueFunction("KDF", "9"))
                .buildOperationNode();
        txt_aliceSendingChain3.setLayoutData(Layout.gd_algorithmLabels());
        
        UiUtils.insertSpacers(grp_aliceSendingChain, 3);

        // arrow down
        arr_aliceSendingChainArrow3 = new Canvas(grp_aliceSendingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceSendingChainArrow3.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceSendingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownRightArrow(
                        arr_aliceSendingChainArrow3, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceSendingChain4 = new FlowChartNode.Builder(grp_aliceSendingChain)
                .title(aliceSendingChainLabel4)
                .popupProvider(createShowValueFunction("Neuer Sending Chain Key", "10"))
                .buildValueNode();
        txt_aliceSendingChain4.setLayoutData(Layout.gd_algorithmLabels());

        UiUtils.insertSpacers(grp_aliceSendingChain, 2);

        txt_aliceSendingChain5 = new FlowChartNode.Builder(grp_aliceSendingChain)
                .title(aliceSendingChainLabel5)
                .popupProvider(createShowValueFunction("Message Key", "11"))
                .buildValueNode();
        txt_aliceSendingChain5.setLayoutData(Layout.gd_algorithmLabels());
    }
}
