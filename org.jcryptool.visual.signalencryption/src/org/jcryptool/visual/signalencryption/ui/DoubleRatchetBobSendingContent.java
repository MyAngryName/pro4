package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.visual.signalencryption.util.UiUtils;

public class DoubleRatchetBobSendingContent implements DoubleRatchetEntityContent {
    
    Text txt_bobSendingStep0;
    Text txt_bobSendingStep1;
    Text txt_bobSendingStep2;
    Text txt_bobSendingStep3;
    Text txt_bobSendingStep4;
    Text txt_bobSendingStep5;
 
    
    FlowChartNode txt_bobRootChain1;
    FlowChartNode txt_bobRootChain2;
    FlowChartNode txt_bobRootChain3;
    FlowChartNode txt_bobSendingChain1;
    FlowChartNode txt_bobSendingChain2;
    FlowChartNode txt_bobSendingChain3;
    FlowChartNode txt_bobSendingChain4;
    FlowChartNode txt_bobSendingChain5;
    FlowChartNode txt_bobDiffieHellman1;
    FlowChartNode txt_bobDiffieHellman2;
    FlowChartNode txt_bobDiffieHellman3;
    
    Text txt_bobPlainText;
    Text txt_bobCipherText;
    
    private String bobDiffieHellmanLabel1 = Messages.SignalEncryption_bobDiffieHellmanLabel1;
    private String bobDiffieHellmanLabel2 = Messages.SignalEncryption_bobDiffieHellmanLabel2;
    private String bobDiffieHellmanLabel3 = Messages.SignalEncryption_bobDiffieHellmanLabel3;
    private String bobRootChainLabel1 = Messages.SignalEncryption_bobRootChainLabel1;
    private String bobRootChainLabel2 = Messages.SignalEncryption_bobRootChainLabel2;
    private String bobRootChainLabel3 = Messages.SignalEncryption_bobRootChainLabel3;
    private String bobSendingChainLabel1 = Messages.SignalEncryption_bobSendingChainLabel1;
    private String bobSendingChainLabel2 = Messages.SignalEncryption_bobSendingChainLabel2;
    private String bobSendingChainLabel3 = Messages.SignalEncryption_bobSendingChainLabel3;
    private String bobSendingChainLabel4 = Messages.SignalEncryption_bobSendingChainLabel4;
    private String bobSendingChainLabel5 = Messages.SignalEncryption_bobSendingChainLabel5;

    protected Canvas arr_bobReceivingChainArrow1;
    protected Canvas arr_bobReceivingChainArrow2;
    protected Canvas arr_bobReceivingChainArrow3;
    protected Canvas arr_bobReceivingChainArrow4;
    protected Canvas arr_bobSendingChainArrow1;
    protected Canvas arr_bobSendingChainArrow2;
    protected Canvas arr_bobSendingChainArrow3;
    protected Canvas arr_bobSendingChainArrow4;
    protected Canvas arr_bobDiffieHellmanArrow1;
    protected Canvas arr_bobDiffieHellmanArrow2;
    protected Canvas arr_bobRootChainArrow1;
    protected Canvas arr_bobRootChainArrow2;
    protected Canvas arr_bobSpace1;
    protected Canvas arr_bobSpace2;

    Group grp_bobSendingChain;
    Group grp_bobSpace2;
    Group grp_bobRootChain;
    Group grp_bobSpace1;
    Group grp_bobDiffieHellman;
    Group grp_bobMessagebox;
    
    Composite cmp_bobDiffieHellman;
    Composite cmp_bobReceivingChain;
    Composite cmp_bobRootChain;
    Composite cmp_bobArrowSpace1;
    Composite cmp_bobArrowSpace2;

    private String MessageboxCipherText = "The Ciphertext";
    private String MessageboxDescription = Messages.SignalEncryption_MessageboxDescription;
    private String RootChainDescription = Messages.SignalEncryption_RootChainDescription;
    private String DiffieHellmanGroupDescription = Messages.SignalEncryption_DiffieHellmanGroupDescription;
    private String SendingChainDescription = Messages.SignalEncryption_SendingChainDescription;
    

    @Override
    public Composite buildStepsContent(Composite parent, COMMUNICATION_STATE state) {
        Composite cmp_bobSendingSteps = new Composite(parent, SWT.NONE);
        cmp_bobSendingSteps.setLayout(Layout.gl_stepsComposite());
        
        txt_bobSendingStep0 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobSendingStep0.setText("Bob sendet eine Nachricht an Alice.");
        txt_bobSendingStep0.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobSendingStep1 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobSendingStep1.setText("Schritt 1 Diffie Hellman Ratchet: Nach jeder Nachricht wird ein neuer Diffie Hellman-Schlüssel erstellt. Bob erzeugt dazu Alices Public einen neuen Private Key.");
        txt_bobSendingStep1.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobSendingStep2 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobSendingStep2.setText("Schritt 2 Root Chain: Der Diffie Hellman-Schlüssel und der Output der letzten KDF der Root Chain wird genutzt um einen neuen Root Chain Key zu erzeugen.");
        txt_bobSendingStep2.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobSendingStep3 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobSendingStep3.setText("Schritt 3 Sending Chain: Der Root Chain-Schlüssel und der Output der letzten KDF in der Sending Chain wird genutzt um einen neuen Receiving Chain Key (Message Key) zu erzeugen.");
        txt_bobSendingStep3.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobSendingStep4 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobSendingStep4.setText("Schritt 4 Nachricht verfassen: Bob kann seine Nachricht an Alice schreiben.");
        txt_bobSendingStep4.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_bobSendingStep5 = new Text(cmp_bobSendingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_bobSendingStep5.setText("Schritt 5 Nachricht verschlüsseln & senden: Bob verschlüsselt die Nachricht mit dem Message Key und sendet diese mit seinem Diffie-Hellman-Schlüssel an Alice.");
        txt_bobSendingStep5.setLayoutData(Layout.gd_shortDescriptionTexts());
        return cmp_bobSendingSteps;
    }

    @Override
    public Composite buildAlgorithmContent(Composite parent, COMMUNICATION_STATE state) {
        var cmp_bobSendingAlgorithm = new Composite(parent, SWT.NONE);
        cmp_bobSendingAlgorithm.setLayout(Layout.gl_algorithmGroup());
        var layout = Layout.gd_algorithmGroup();
        layout.horizontalAlignment = SWT.RIGHT;
        cmp_bobSendingAlgorithm.setLayoutData(layout);
        
        //var spacer = new Composite(cmp_bobSendingAlgorithm, SWT.NONE);
        //spacer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
        UiUtils.insertExcessiveSpacers(cmp_bobSendingAlgorithm, 1);
        grp_bobMessagebox = new Group(cmp_bobSendingAlgorithm, SWT.NONE);
        grp_bobSendingChain = new Group(cmp_bobSendingAlgorithm, SWT.NONE);
        cmp_bobArrowSpace2 = new Composite(cmp_bobSendingAlgorithm, SWT.NONE);
        grp_bobRootChain = new Group(cmp_bobSendingAlgorithm, SWT.NONE);
        cmp_bobArrowSpace1 = new Composite(cmp_bobSendingAlgorithm, SWT.NONE);
        grp_bobDiffieHellman = new Group(cmp_bobSendingAlgorithm, SWT.NONE);
        
        createBobDiffieHellmanChain();
        createBobRootChain();
        createBobSendingChain();
        createBobMessagebox();
        createBobArrowSpaces();
        return cmp_bobSendingAlgorithm;
    }

    
    private void createBobSendingChain() {
        grp_bobSendingChain.setLayout(Layout.gl_sendingReceivingChainComposite(SWT.LEFT));
        grp_bobSendingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());
        grp_bobSendingChain.setText(SendingChainDescription);
        
        UiUtils.insertSpacers(grp_bobSendingChain, 1);

        txt_bobSendingChain1 = new FlowChartNode.Builder(grp_bobSendingChain)
                .title(bobSendingChainLabel1)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobSendingChain1.setLayoutData(Layout.gd_algorithmNodes());

        arr_bobSendingChainArrow4 = new Canvas(grp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow4.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 2, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_bobSendingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawLeftArrow(
                        arr_bobSendingChainArrow4, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        UiUtils.insertSpacers(grp_bobSendingChain, 1);

        // arrow down
        arr_bobSendingChainArrow1 = new Canvas(grp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_bobSendingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownArrow(
                        arr_bobSendingChainArrow1, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        UiUtils.insertSpacers(grp_bobSendingChain, 3);

        
        txt_bobSendingChain3 =  new FlowChartNode.Builder(grp_bobSendingChain)
                .title(bobSendingChainLabel3)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobSendingChain3.setLayoutData(Layout.gd_algorithmNodes());
        
        // arrow right
        arr_bobSendingChainArrow2 = new Canvas(grp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_bobSendingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawLeftArrow(
                        arr_bobSendingChainArrow2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        
        txt_bobSendingChain2 =  new FlowChartNode.Builder(grp_bobSendingChain)
                .title(bobSendingChainLabel2)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobSendingChain2.setLayoutData(Layout.gd_algorithmNodes());

        txt_bobSendingChain4 =  new FlowChartNode.Builder(grp_bobSendingChain)
                .title(bobSendingChainLabel4)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobSendingChain4.setLayoutData(Layout.gd_algorithmNodes());

        
        // arrow down
        arr_bobSendingChainArrow3 = new Canvas(grp_bobSendingChain, SWT.DOUBLE_BUFFERED);
        arr_bobSendingChainArrow3.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_bobSendingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownLeftArrow(
                        arr_bobSendingChainArrow3, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });


        UiUtils.insertSpacers(grp_bobSendingChain, 3);

        txt_bobSendingChain5 =  new FlowChartNode.Builder(grp_bobSendingChain)
                .title(bobSendingChainLabel5)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobSendingChain5.setLayoutData(Layout.gd_algorithmNodes());
    }


    private void createBobRootChain() {
        grp_bobRootChain.setText(RootChainDescription);
        grp_bobRootChain.setLayout(Layout.gl_rootChainComposite(SWT.RIGHT));
        grp_bobRootChain.setLayoutData(Layout.gd_rootChainComposite());

        txt_bobRootChain1 =  new FlowChartNode.Builder(grp_bobRootChain)
                .title(bobRootChainLabel1)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobRootChain1.setLayoutData(Layout.gd_algorithmNodes());

        // arrow down
        arr_bobRootChainArrow1 = new Canvas(grp_bobRootChain, SWT.DOUBLE_BUFFERED);
        arr_bobRootChainArrow1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.UP_DOWN_ARROW_SIZE
         ));
        arr_bobRootChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownArrow(
                        arr_bobRootChainArrow1, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobRootChain2 =  new FlowChartNode.Builder(grp_bobRootChain)
                .title(bobRootChainLabel2)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobRootChain2.setLayoutData(Layout.gd_algorithmNodes());

        // arrow down
        arr_bobRootChainArrow2 = new Canvas(grp_bobRootChain, SWT.DOUBLE_BUFFERED);
        arr_bobRootChainArrow2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.UP_DOWN_ARROW_SIZE
        ));
        arr_bobRootChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownArrow(
                        arr_bobRootChainArrow2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobRootChain3 =  new FlowChartNode.Builder(grp_bobRootChain)
                .title(bobRootChainLabel3)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobRootChain3.setLayoutData(Layout.gd_algorithmNodes());

    }

    private void createBobDiffieHellmanChain() {
        grp_bobDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_bobDiffieHellman.setLayout(Layout.gl_diffieHellmanComposite());
        grp_bobDiffieHellman.setLayoutData(Layout.gd_diffieHellmanComposite());

        txt_bobDiffieHellman1 =  new FlowChartNode.Builder(grp_bobDiffieHellman)
                .title(bobDiffieHellmanLabel1)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobDiffieHellman1.setLayoutData(Layout.gd_algorithmNodes());

        // arrow down
        arr_bobDiffieHellmanArrow1 = new Canvas(grp_bobDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_bobDiffieHellmanArrow1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.UP_DOWN_ARROW_SIZE
        ));
        arr_bobDiffieHellmanArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownArrow(
                        arr_bobDiffieHellmanArrow1, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobDiffieHellman2 =  new FlowChartNode.Builder(grp_bobDiffieHellman)
                .title(bobDiffieHellmanLabel2)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobDiffieHellman2.setLayoutData(Layout.gd_algorithmNodes());

        // arrow up
        arr_bobDiffieHellmanArrow2 = new Canvas(grp_bobDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_bobDiffieHellmanArrow2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_bobDiffieHellmanArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawUpArrow(
                        arr_bobDiffieHellmanArrow2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_bobDiffieHellman3 =  new FlowChartNode.Builder(grp_bobDiffieHellman)
                .title(bobDiffieHellmanLabel3)
                .popupProvider(FlowChartNodePopup.create("DH key calculation", "0"))
                .buildOperationNode();
        txt_bobDiffieHellman3.setLayoutData(Layout.gd_algorithmNodes());

    }
    
    
    private void createBobArrowSpaces() {
        cmp_bobArrowSpace1.setLayout(Layout.gl_arrowSpaceComposite());
        cmp_bobArrowSpace1.setLayoutData(Layout.gd_arrowSpaceComposite());
        
        // arrow up
        arr_bobSpace1 = new Canvas(cmp_bobArrowSpace1, SWT.DOUBLE_BUFFERED);
        arr_bobSpace1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL,
                SWT.FILL,
                false,
                false,
                1,
                1,
                ViewConstants.ARROW_CANVAS_WIDTH,
                // Note that we need the border width of any text, so we use an initialized one.
                Layout.calculateConnectingArrowHeight(txt_bobDiffieHellman1.getBorderWidth())
        ));
        arr_bobSpace1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawLeftUpLeftArrow(
                        arr_bobSpace1, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        cmp_bobArrowSpace2.setLayout(Layout.gl_arrowSpaceComposite());
        cmp_bobArrowSpace2.setLayoutData(Layout.gd_arrowSpaceComposite());

        // arrow up
        arr_bobSpace2 = new Canvas(cmp_bobArrowSpace2, SWT.DOUBLE_BUFFERED);
        arr_bobSpace2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL,
                SWT.FILL,
                false,
                false,
                1,
                1,
                ViewConstants.ARROW_CANVAS_WIDTH,
                // Note that we need the border width of any text, so we use an initialized one.
                Layout.calculateConnectingArrowHeight(txt_bobDiffieHellman1.getBorderWidth())
        ));
        arr_bobSpace2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawLeftUpLeftLine(
                        arr_bobSpace2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
    }

    private void createBobMessagebox() {

        grp_bobMessagebox.setLayout(Layout.gl_messageboxGroup());
        grp_bobMessagebox.setLayoutData(Layout.gd_messageboxComposite());
        grp_bobMessagebox.setText(MessageboxDescription);

        txt_bobPlainText = new Text(grp_bobMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_bobPlainText.setLayoutData(Layout.gd_Messagebox());
        txt_bobPlainText.addListener(SWT.Modify, new Listener() {

            @Override
            public void handleEvent(Event e) {
                txt_bobPlainText.setTextLimit(256);
            }
        });
        txt_bobPlainText.setEditable(true);
        
        txt_bobCipherText = new Text(grp_bobMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_bobCipherText.setText(MessageboxCipherText);
        txt_bobCipherText.setLayoutData(Layout.gd_Messagebox());
    }

}
