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

public class DoubleRatchetAliceReceivingContent implements DoubleRatchetEntityContent {
    
    private String aliceReceivingStep0 = Messages.SignalEncryption_aliceDescriptionText0;
    private String aliceReceivingStep5 = Messages.SignalEncryption_stepText1;
    private String aliceReceivingStep6 = Messages.SignalEncryption_stepText2;
    private String aliceReceivingStep7 = Messages.SignalEncryption_stepText3;
    private String aliceReceivingStep8 = Messages.SignalEncryption_stepText4;
    private String aliceReceivingStep9 = Messages.SignalEncryption_aliceStepText5;
   
    Text txt_aliceReceivingStep0;
    Text txt_aliceReceivingStep5;
    Text txt_aliceReceivingStep6;
    Text txt_aliceReceivingStep7;
    Text txt_aliceReceivingStep8;
    Text txt_aliceReceivingStep9;
    
    FlowChartNode txt_aliceRootChain1;
    FlowChartNode txt_aliceRootChain2;
    FlowChartNode txt_aliceRootChain3;
    FlowChartNode txt_aliceReceivingChain1;
    FlowChartNode txt_aliceReceivingChain2;
    FlowChartNode txt_aliceReceivingChain3;
    FlowChartNode txt_aliceReceivingChain4;
    FlowChartNode txt_aliceReceivingChain5;
    FlowChartNode txt_aliceDiffieHellman1;
    FlowChartNode txt_aliceDiffieHellman2;
    FlowChartNode txt_aliceDiffieHellman3;
    
    Text txt_alicePlainText;
    Text txt_aliceCipherText;
    
    private String aliceDiffieHellmanLabel1 = Messages.SignalEncryption_aliceDiffieHellmanLabel1;
    private String aliceDiffieHellmanLabel2 = Messages.SignalEncryption_aliceDiffieHellmanLabel2;
    private String aliceDiffieHellmanLabel3 = Messages.SignalEncryption_aliceDiffieHellmanLabel3;
    private String aliceRootChainLabel1 = Messages.SignalEncryption_aliceRootChainLabel1;
    private String aliceRootChainLabel2 = Messages.SignalEncryption_aliceRootChainLabel2;
    private String aliceRootChainLabel3 = Messages.SignalEncryption_aliceRootChainLabel3;
    private String aliceReceivingChainLabel1 = Messages.SignalEncryption_aliceReceivingChainLabel1;
    private String aliceReceivingChainLabel2 = Messages.SignalEncryption_aliceReceivingChainLabel2;
    private String aliceReceivingChainLabel3 = Messages.SignalEncryption_aliceReceivingChainLabel3;
    private String aliceReceivingChainLabel4 = Messages.SignalEncryption_aliceReceivingChainLabel4;
    private String aliceReceivingChainLabel5 = Messages.SignalEncryption_aliceReceivingChainLabel5;

    protected Canvas arr_aliceReceivingChainArrow1;
    protected Canvas arr_aliceReceivingChainArrow2;
    protected Canvas arr_aliceReceivingChainArrow3;
    protected Canvas arr_aliceReceivingChainArrow4;
    protected Canvas arr_aliceDiffieHellmanArrow1;
    protected Canvas arr_aliceDiffieHellmanArrow2;
    protected Canvas arr_aliceRootChainArrow1;
    protected Canvas arr_aliceRootChainArrow2;
    protected Canvas arr_aliceSpace1;
    protected Canvas arr_aliceSpace2;

    Group grp_aliceReceivingChain;
    Group grp_aliceSpace2;
    Group grp_aliceRootChain;
    Group grp_aliceSpace1;
    Group grp_aliceDiffieHellman;
    Group grp_aliceMessagebox;
    Group grp_aliceDecryptedMessage;
    
    Composite cmp_aliceDiffieHellman;
    Composite cmp_aliceRootChain;
    Composite cmp_aliceArrowSpace1;
    Composite cmp_aliceArrowSpace2;

    private String MessageboxCipherText = "The Ciphertext";
    private String MessageboxDescription = Messages.SignalEncryption_MessageboxDescription;
    private String RootChainDescription = Messages.SignalEncryption_RootChainDescription;
    private String MessageboxPlainText = "Geben Sie hier Ihre Nachricht an Alice ein.";
    private String DiffieHellmanGroupDescription = Messages.SignalEncryption_DiffieHellmanGroupDescription;
    private String ReceivingChainDescription = Messages.SignalEncryption_ReceivingChainDescription;
    



    @Override
    public Composite buildStepsContent(Composite parent, COMMUNICATION_STATE state) {
        Composite cmp_aliceReceivingSteps = new Composite(parent, SWT.NONE);
        cmp_aliceReceivingSteps.setLayout(Layout.gl_stepsComposite());
        
        txt_aliceReceivingStep0 = new Text(cmp_aliceReceivingSteps, SWT.WRAP | SWT.READ_ONLY);
        txt_aliceReceivingStep0.setText("Alice wartet auf eine Nachricht von Bob");
        txt_aliceReceivingStep0.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_aliceReceivingStep5 = new Text(cmp_aliceReceivingSteps, SWT.WRAP | SWT.READ_ONLY);
        txt_aliceReceivingStep5.setText("Nachricht von Bob empfangen");
        txt_aliceReceivingStep5.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_aliceReceivingStep6 = new Text(cmp_aliceReceivingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_aliceReceivingStep6.setText("Schritt 6 Diffie Hellman Ratchet: Alice führt mit dem in der Nachricht enthaltenen Schlüsselinformationen den nächsten Diffie Hellman-Schritt durch.");
        txt_aliceReceivingStep6.setLayoutData(Layout.gd_longDescriptionTexts());
        txt_aliceReceivingStep7 = new Text(cmp_aliceReceivingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_aliceReceivingStep7.setText("Schritt 7 Root Chain: Der Diffie Hellman-Schlüssel und der Output der letzten KDF der Root Chain wird genutzt um einen neuen Root Chain Key zu erzeugen.");
        txt_aliceReceivingStep7.setLayoutData(Layout.gd_longDescriptionTexts());
        txt_aliceReceivingStep8 = new Text(cmp_aliceReceivingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_aliceReceivingStep8.setText("Schritt 8 Receiving Chain: Der Root Chain-Schlüssel und der Output der letzten KDF in der Receiving Chain wird genutzt um einen neuen Receiving Chain Key (Message Key) zu erzeugen.");
        txt_aliceReceivingStep8.setLayoutData(Layout.gd_shortDescriptionTexts());
        txt_aliceReceivingStep9 = new Text(cmp_aliceReceivingSteps, SWT.READ_ONLY | SWT.WRAP);
        txt_aliceReceivingStep9.setText("Schritt 9 Nachricht entschlüsseln: Alice nutzt den Message Key um die Nachricht zu entschlüssln.");
        txt_aliceReceivingStep9.setLayoutData(Layout.gd_longDescriptionTexts());
        return cmp_aliceReceivingSteps;
    }

    
    @Override
    public Composite buildAlgorithmContent(Composite parent, COMMUNICATION_STATE state) {
        var cmp_aliceSendingAlgorithm = new Composite(parent, SWT.NONE);
        cmp_aliceSendingAlgorithm.setLayout(Layout.gl_algorithmGroup());
        cmp_aliceSendingAlgorithm.setLayoutData(Layout.gd_algorithmGroup());
        
        UiUtils.insertExcessiveSpacers(cmp_aliceSendingAlgorithm, 1);
        grp_aliceDecryptedMessage = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceReceivingChain = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        cmp_aliceArrowSpace2 = new Composite(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceRootChain = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        cmp_aliceArrowSpace1 = new Composite(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceDiffieHellman = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        grp_aliceMessagebox = new Group(cmp_aliceSendingAlgorithm, SWT.NONE);
        
        createAliceReceivingChain();
        createAliceRootChain();
        createAliceDiffieHellmanChain();
        createAliceEncryptedMessagebox();
        createAliceDecryptedMessagebox();
        createAliceArrowSpaces();
        return cmp_aliceSendingAlgorithm;
    }

    private void createAliceReceivingChain() {
        grp_aliceReceivingChain.setLayout(Layout.gl_sendingReceivingChainComposite(SWT.RIGHT));
        grp_aliceReceivingChain.setLayoutData(Layout.gd_sendingReceivingChainComposite());
        grp_aliceReceivingChain.setText(ReceivingChainDescription);
        
        UiUtils.insertSpacers(grp_aliceReceivingChain, 1);

        txt_aliceReceivingChain1 = new FlowChartNode.Builder(grp_aliceReceivingChain)
                .title(aliceReceivingChainLabel1)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceReceivingChain1.setLayoutData(Layout.gd_algorithmLabels());

        arr_aliceReceivingChainArrow4 = new Canvas(grp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow4.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 2, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceReceivingChainArrow4.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawLeftArrow(
                        arr_aliceReceivingChainArrow4, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        UiUtils.insertSpacers(grp_aliceReceivingChain, 1);
        
        // arrow down
        arr_aliceReceivingChainArrow1 = new Canvas(grp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceReceivingChainArrow1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownArrow(
                        arr_aliceReceivingChainArrow1, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        UiUtils.insertSpacers(grp_aliceReceivingChain, 3);

        txt_aliceReceivingChain2 = new FlowChartNode.Builder(grp_aliceReceivingChain)
                .title(aliceReceivingChainLabel2)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceReceivingChain2.setLayoutData(Layout.gd_algorithmLabels());

        // arrow left
        arr_aliceReceivingChainArrow2 = new Canvas(grp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceReceivingChainArrow2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawLeftArrow(
                        arr_aliceReceivingChainArrow2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });

        txt_aliceReceivingChain3 = new FlowChartNode.Builder(grp_aliceReceivingChain)
                .title(aliceReceivingChainLabel3)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceReceivingChain3.setLayoutData(Layout.gd_algorithmLabels());

        txt_aliceReceivingChain4 = new FlowChartNode.Builder(grp_aliceReceivingChain)
                .title(aliceReceivingChainLabel4)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceReceivingChain4.setLayoutData(Layout.gd_algorithmLabels());

        // arrow left
        arr_aliceReceivingChainArrow3 = new Canvas(grp_aliceReceivingChain, SWT.DOUBLE_BUFFERED);
        arr_aliceReceivingChainArrow3.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.ARROW_CANVAS_WIDTH
        ));
        arr_aliceReceivingChainArrow3.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawDownLeftArrow(
                        arr_aliceReceivingChainArrow3, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
        
        UiUtils.insertSpacers(grp_aliceReceivingChain, 3);

        txt_aliceReceivingChain5 =new FlowChartNode.Builder(grp_aliceReceivingChain)
                .title(aliceReceivingChainLabel5)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceReceivingChain5.setLayoutData(Layout.gd_algorithmLabels());

    }

    private void createAliceRootChain() {
        grp_aliceRootChain.setText(RootChainDescription);
        grp_aliceRootChain.setLayout(Layout.gl_rootChainComposite());
        grp_aliceRootChain.setLayoutData(Layout.gd_rootChainComposite());

        txt_aliceRootChain1 = new FlowChartNode.Builder(grp_aliceRootChain)
                .title(aliceRootChainLabel1)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceRootChain1.setLayoutData(Layout.gd_algorithmLabels());

        // arrow down
        arr_aliceRootChainArrow1 = new Canvas(grp_aliceRootChain, SWT.DOUBLE_BUFFERED);
        arr_aliceRootChainArrow1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.UP_DOWN_ARROW_SIZE
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
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceRootChain2.setLayoutData(Layout.gd_algorithmLabels());

        // arrow down
        arr_aliceRootChainArrow2 = new Canvas(grp_aliceRootChain, SWT.DOUBLE_BUFFERED);
        arr_aliceRootChainArrow2.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.UP_DOWN_ARROW_SIZE
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
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceRootChain3.setLayoutData(Layout.gd_algorithmLabels());

    }

    private void createAliceDiffieHellmanChain() {
        grp_aliceDiffieHellman.setText(DiffieHellmanGroupDescription);
        grp_aliceDiffieHellman.setLayout(Layout.gl_diffieHellmanComposite());
        grp_aliceDiffieHellman.setLayoutData(Layout.gd_diffieHellmanComposite());

        txt_aliceDiffieHellman1 = new FlowChartNode.Builder(grp_aliceDiffieHellman)
                .title(aliceDiffieHellmanLabel1)
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceDiffieHellman1.setLayoutData(Layout.gd_algorithmLabels());

        // arrow down
        arr_aliceDiffieHellmanArrow1 = new Canvas(grp_aliceDiffieHellman, SWT.DOUBLE_BUFFERED);
        arr_aliceDiffieHellmanArrow1.setLayoutData(ArrowCanvas.canvasData(
                SWT.FILL, SWT.FILL, false, false, 1, 1, ViewConstants.UP_DOWN_ARROW_SIZE
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
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
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
                .popupProvider(createShowValueFunction("DH key calculation", "0"))
                .buildOperationNode();
        txt_aliceDiffieHellman3.setLayoutData(Layout.gd_algorithmLabels());

    }
        private void createAliceArrowSpaces() {
        cmp_aliceArrowSpace1.setLayout(Layout.gl_arrowSpaceComposite());
        cmp_aliceArrowSpace1.setLayoutData(Layout.gd_arrowSpaceComposite());

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
                Layout.calculateConnectingArrowHeight(txt_aliceDiffieHellman1.getBorderWidth())
        ));
        arr_aliceSpace1.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawLeftUpLeftArrow(
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
                Layout.calculateConnectingArrowHeight(txt_aliceDiffieHellman1.getBorderWidth())
        ));
        arr_aliceSpace2.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent event) {
                event.gc.setBackground(event.display.getSystemColor(SWT.COLOR_DARK_GRAY));
                Path path = ArrowCanvas.drawLeftUpLeftLine(
                        arr_aliceSpace2, ViewConstants.ARROW_THICKNESS, ViewConstants.ARROW_HEAD_THICKNESS
                );
                event.gc.fillPath(path);
                path.dispose();
            }
        });
    }

    private void createAliceEncryptedMessagebox() {
        grp_aliceMessagebox.setLayout(Layout.gl_messageboxGroup());
        grp_aliceMessagebox.setLayoutData(Layout.gd_messageboxComposite());
        grp_aliceMessagebox.setText(MessageboxDescription);

        txt_aliceCipherText = new Text(grp_aliceMessagebox,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_aliceCipherText.setText(MessageboxCipherText);
        txt_aliceCipherText.setLayoutData(Layout.gd_Messagebox());
    }


    private void createAliceDecryptedMessagebox() {
        grp_aliceDecryptedMessage.setLayout(Layout.gl_messageboxGroup());
        grp_aliceDecryptedMessage.setLayoutData(Layout.gd_messageboxComposite());
        grp_aliceDecryptedMessage.setText("Entschlüsselte Nachricht");
        
        txt_alicePlainText = new Text(grp_aliceDecryptedMessage,
                SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
        txt_alicePlainText.setText(MessageboxPlainText);
        txt_alicePlainText.setLayoutData(Layout.gd_Messagebox());
    }
}
