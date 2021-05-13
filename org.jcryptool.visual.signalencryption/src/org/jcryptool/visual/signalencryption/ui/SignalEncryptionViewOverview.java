package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.ui.part.ViewPart;
import org.jcryptool.core.util.ui.TitleAndDescriptionComposite;
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionAlgorithm.STATE;
import org.jcryptool.visual.signalencryption.util.ToHex;
import org.whispersystems.libsignal.protocol.PreKeySignalMessage;
import org.whispersystems.libsignal.util.Hex;

/**
 * 
 * @author Dan-Kerko Ciudin
 * 
 */

public class SignalEncryptionViewOverview extends Composite {

    //
    
    private Composite overViewComposite;
    
    // Title and description
    private TitleAndDescriptionComposite titleAndDescription;

    // Groups
    private Group keyTableGroup;
    private Group descriptionGroup;

    // GridLayouts
    private GridLayout gl_overViewComposite;
    private GridLayout gl_keyTableGroup;
    private GridLayout gl_descriptionGroup;

    // GridData
    private GridData gd_overViewComposite;
    private GridData gd_keyTableGroup;
    private GridData gd_descriptionGroup;
    private GridData gd_text;
    private GridData gd_value;

    // Table
//    private Table keyTable;

    // TableColumn
//    private TableColumn keyTableColumn;

    // TableItems
//    private TableItem keyTableItem;

    // TableLabels
    private Label label_column;
    private Label text_column;
    private Label value_column_alice;
    private Label value_column_bob;

    private Label label_b;
    private Label label_c;
    private Label label_d;
    private Label label_e;
    private Label label_f;
    private Label label_g;

    // TableTexts

    private Text text_b;
    private Text text_c;
    private Text text_d;
    private Text text_e;
    private Text text_f;
    private Text text_g;

    // TableValues
    private Text value_b_alice;
    private Text value_c_alice;
    private Text value_d_alice;
    private Text value_e_alice;
    private Text value_f_alice;
    private Text value_g_alice;

    // TableValues
    private Text value_b_bob;
    private Text value_c_bob;
    private Text value_d_bob;
    private Text value_e_bob;
    private Text value_f_bob;
    private Text value_g_bob;
    
    private SignalEncryptionAlgorithm signalEncryptionAlgorithm;

    private Button btn_regenerate;
    
    private String aliceRootKey;
    private String bobRootKey;
    
    private String aliceSendingChainKey;
    private String bobSendingChainKey;
    
    private String aliceReceivingChainKey;
    private String bobReceivingChainKey;

    private Button btn_prekeysignalmessage;
    
    /**
     * 
     **/
    public SignalEncryptionViewOverview(final Composite parent, int style, 
            SignalEncryptionAlgorithm signalEncryptionAlgorithm) {
        super(parent, style);
        this.signalEncryptionAlgorithm = signalEncryptionAlgorithm;

        setLayout(new GridLayout());

        setTitleAndDescription();
        parameter();
        createOverViewComposite();

    }

    private void createDescriptionGroup() {

//        descriptionGroup = new Group(overViewComposite, SWT.NONE);
        gl_descriptionGroup = new GridLayout(1, false);
        gd_descriptionGroup = new GridData(SWT.FILL, SWT.FILL, false, true);

//        descriptionGroup.setLayout(gl_descriptionGroup);
//        descriptionGroup.setText("Schl�ssel");
//        descriptionGroup.setLayoutData(gd_descriptionGroup);

    }

    private void createTable() {

        // Table Variante

        // keyTable = new Table(parent, SWT.MULTI | SWT.BORDER);
        // keyTable.setHeaderVisible(true);
        //
        // String[] titles = { "Schl�ssel", "Beschreibung", "Wert" };
        //
        // for (int i = 0; i < titles.length; i++) {
        // keyTableColumn = new TableColumn(keyTable, SWT.NONE);
        // keyTableColumn.setText(titles[i]);
        // }
        //
        // // Loop that inserts inserts data into keyTable
        // int count = 6;
        // for (int i = 0; i < count; i++) {
        // keyTableItem = new TableItem(keyTable, SWT.NONE);
        // keyTableItem.setText(0, "Schl�sselName");
        // keyTableItem.setText(1, "Schl�sselBeschreibung");
        // keyTableItem.setText(2, "Schl�sselWert");
        // }
        // for (int i = 0; i < titles.length; i++) {
        // keyTable.getColumn(i).pack();
        // }
        // keyTable.setSize(keyTable.computeSize(SWT.DEFAULT, 200));

        // Label und Text Variante
        


        

        gd_text = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
        gd_value = gd_text;
        gd_text.widthHint = 300;

        label_column = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        label_column.setText("Schl�ssel");

        text_column = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        text_column.setLayoutData(gd_text);
        text_column.setText("Beschreibung");

        value_column_alice = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        value_column_alice.setLayoutData(gd_text);
        value_column_alice.setText("Wert Alice");
        
        value_column_bob = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        value_column_bob.setLayoutData(gd_text);
        value_column_bob.setText("Wert Bob");

        label_b = new Label(keyTableGroup, SWT.READ_ONLY);
        label_b.setText("Diffie Hellman Key Pair");

        text_b = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_b.setLayoutData(gd_text);
        text_b.setText("Besteht aus einem �ffentlichen und privaten Teil.");

        value_b_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_b_alice.setLayoutData(gd_value);
        value_b_alice.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");
        
        value_b_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_b_bob.setLayoutData(gd_value);
        value_b_bob.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");

        label_c = new Label(keyTableGroup, SWT.READ_ONLY);
        label_c.setText("Shared Secret Key");

        text_c = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_c.setLayoutData(gd_text);
        text_c.setText("Geheimer Schl�ssel der von den Kommunikationspartnern mittels einem "
                + "vereinbarten Schl�sselaustausch erstellt wird. Dieser Schl�ssel dient als erster Root" + "Key.");

        value_c_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_c_alice.setLayoutData(gd_value);
        value_c_alice.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");
        
        value_c_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_c_bob.setLayoutData(gd_value);
        value_c_bob.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");

        label_d = new Label(keyTableGroup, SWT.READ_ONLY);
        label_d.setText("Root Chain Key");

        text_d = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_d.setLayoutData(gd_text);
        text_d.setText("Der Root Chain Key dient als Schl�ssel f�r die Root Chain.");

        value_d_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_d_alice.setLayoutData(gd_value);
        value_d_alice.setText(aliceRootKey);
        
        value_d_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_d_bob.setLayoutData(gd_value);
        value_d_bob.setText(bobRootKey);

        label_e = new Label(keyTableGroup, SWT.READ_ONLY);
        label_e.setText("Sending Chain Key");

        text_e = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_e.setLayoutData(gd_text);
        text_e.setText("Der Sending Chain Key wird verwendet um einen Message Key zu" + "generieren.");

        value_e_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_e_alice.setLayoutData(gd_value);
        value_e_alice.setText(aliceSendingChainKey);
        
        value_e_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_e_bob.setLayoutData(gd_value);
        value_e_bob.setText(bobSendingChainKey);

        label_f = new Label(keyTableGroup, SWT.READ_ONLY);
        label_f.setText("Receiving Chain Key");

        text_f = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_f.setLayoutData(gd_text);
        text_f.setText("Der Receiving Chain Key wird verwendet um einen Message Key zu" + "generieren.");

        value_f_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_f_alice.setLayoutData(gd_value);
        value_f_alice.setText(aliceReceivingChainKey);
        
        value_f_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_f_bob.setLayoutData(gd_value);
        value_f_bob.setText(bobReceivingChainKey);

        label_g = new Label(keyTableGroup, SWT.READ_ONLY);
        label_g.setText("Message Key");

        text_g = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_g.setLayoutData(gd_text);
        text_g.setText("Der Message Key ist ein Output aus der Sending Chain bzw. der Receiving"
                + "Chain und wird verwendet um eine Nachricht zu ver- oder entSchl�sseln.");

        value_g_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_g_alice.setLayoutData(gd_value);
        value_g_alice.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");
    
        value_g_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_g_bob.setLayoutData(gd_value);
        value_g_bob.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");
        
        btn_regenerate = new Button(keyTableGroup, SWT.PUSH);
        btn_regenerate.setText("Generate Keys");
        btn_regenerate.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                generateBoth();                
            }
        });
        btn_regenerate = new Button(keyTableGroup, SWT.PUSH);
        btn_regenerate.setText("Generate Alice");
        btn_regenerate.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                generateAlice();                
            }
        });
        btn_regenerate = new Button(keyTableGroup, SWT.PUSH);
        btn_regenerate.setText("Generate Bob");
        btn_regenerate.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                generateBob();                
            }
        });
        
    }

    private void createTableGroup() {

        keyTableGroup = new Group(overViewComposite, SWT.NONE);
        gl_keyTableGroup = new GridLayout(7, false);
        gd_keyTableGroup = new GridData(SWT.LEFT, SWT.TOP, false, false);
        gd_keyTableGroup.minimumWidth = 1000;

        keyTableGroup.setLayout(gl_keyTableGroup);
        keyTableGroup.setText("Schl�ssel");
        keyTableGroup.setLayoutData(gd_keyTableGroup);

        createTable();

    }
    
    private void setTitleAndDescription() {

        titleAndDescription = new TitleAndDescriptionComposite(this);
        titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        titleAndDescription.setTitle("Title");
        titleAndDescription.setDescription("Description");
    }
    
    private void createOverViewComposite() {
        overViewComposite = new Composite(this, SWT.NONE);
        gl_overViewComposite = new GridLayout(2, false);
        gl_overViewComposite.marginWidth = 0;
        gd_overViewComposite = new GridData(SWT.FILL, SWT.FILL, false, true);
        overViewComposite.setLayout(gl_overViewComposite);
        overViewComposite.setLayoutData(gd_overViewComposite);

        createTableGroup();
        createDescriptionGroup();

    }
    public void generateBoth() {
        signalEncryptionAlgorithm.generateBoth();
        parameter();
        textReset();
    }
    public void generateAlice() {
        signalEncryptionAlgorithm.generateAlice();
        parameter();
        textReset();
    }
    public void generateBob() {
        signalEncryptionAlgorithm.generateBob();
        parameter();
        textReset();
    }
    public void textReset() {
        value_d_alice.setText(aliceRootKey);
        value_e_alice.setText(aliceSendingChainKey);
        value_f_alice.setText(aliceReceivingChainKey);
        
        value_d_bob.setText(bobRootKey);
        value_e_bob.setText(bobSendingChainKey);
        value_f_bob.setText(bobReceivingChainKey);
    }
    public void parameter() {
        if(signalEncryptionAlgorithm.getCurrentState() == STATE.PARAMETER) {
            aliceRootKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().
                    getKeyBytes());
            aliceSendingChainKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().
                            getKey());
            aliceReceivingChainKey = "No Key received";
                    

            bobRootKey = "No Session initialized";
            bobSendingChainKey = "No Session initialized";
            bobReceivingChainKey = "No Session initialized";
        } else {
            aliceRootKey = Hex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().
                    getKeyBytes());
            aliceSendingChainKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().
                            getKey());
            aliceReceivingChainKey = ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().
                            getKey());
                    

            bobRootKey = signalEncryptionAlgorithm.getBobKeys().getRootKey().
                                getKeyBytes().toString();
            bobSendingChainKey = signalEncryptionAlgorithm.getBobKeys().getChainKey().
                                getKey().toString();
            bobReceivingChainKey = signalEncryptionAlgorithm.getAliceKeys().getChainKey().
                            getKey().toString();
        }
        
    }
    
}
