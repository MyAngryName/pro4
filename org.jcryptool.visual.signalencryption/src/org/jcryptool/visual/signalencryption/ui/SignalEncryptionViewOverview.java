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
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionAlgorithmState.STATE;
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

    // TableLabels
    private Label label_column;
    private Label text_column;
    private Label value_column_alice;
    private Label value_column_bob;

    private Label label_b_private;
    private Label label_b_public;
    private Label label_c;
    private Label label_d;
    private Label label_e;
    private Label label_f;
    private Label label_g;

    // TableTexts

    private Text text_b_private;
    private Text text_b_public;
    private Text text_c;
    private Text text_d;
    private Text text_e;
    private Text text_f;
    private Text text_g;

    // TableValues
    private Text value_b_alice_private;
    private Text value_b_alice_public;
    private Text value_c_alice;
    private Text value_d_alice;
    private Text value_e_alice;
    private Text value_f_alice;
    private Text value_g_alice;

    // TableValues
    private Text value_b_bob_private;
    private Text value_b_bob_public;
    private Text value_c_bob;
    private Text value_d_bob;
    private Text value_e_bob;
    private Text value_f_bob;
    private Text value_g_bob;
    
    private SignalEncryptionAlgorithm signalEncryptionAlgorithm;
    private SignalEncryptionAlgorithmState signalEncryptionState;

    private Button btn_regenerate;
    
    //Variables for the used keys
    private String aliceRatchetPublicKey;
    private String aliceRatchetPrivateKey;
    
    private String bobRatchetPublicKey;
    private String bobRatchetPrivateKey;
    
    private String aliceSharedKey;
    private String bobSharedKey;
    
    private String aliceRootKey;
    private String bobRootKey;
    
    private String aliceSendingChainKey;
    private String bobSendingChainKey;
    
    private String aliceReceivingChainKey;
    private String bobReceivingChainKey;
    
    private String aliceSenderMsgKey;
    private String bobSenderMsgKey;

    private Button btn_prekeysignalmessage;
    
    /**
     * 
     **/
    public SignalEncryptionViewOverview(final Composite parent, int style, SignalEncryptionAlgorithmState signalEncryptionState) {
        super(parent, style);
        this.signalEncryptionState = signalEncryptionState;
        this.signalEncryptionAlgorithm = signalEncryptionState.getSignalEncryptionAlgorithm();

        setLayout(new GridLayout());

        setTitleAndDescription();
        setParameter();
        createOverViewComposite();

    }

    private void createDescriptionGroup() {
        gl_descriptionGroup = new GridLayout(1, false);
        gd_descriptionGroup = new GridData(SWT.FILL, SWT.FILL, false, true);
    }

    private void createTable() {
        

        gd_text = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
        gd_value = gd_text;
        gd_text.widthHint = 300;

        //Title fields of the columns
        label_column = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        label_column.setText(Messages.SignalEncryption_TblTitel_Key);

        text_column = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        text_column.setLayoutData(gd_text);
        text_column.setText(Messages.SignalEncryption_TblTitel_Description);

        value_column_alice = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        value_column_alice.setLayoutData(gd_text);
        value_column_alice.setText(Messages.SignalEncryption_TblTitel_ValuesAlice);
        
        value_column_bob = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        value_column_bob.setLayoutData(gd_text);
        value_column_bob.setText(Messages.SignalEncryption_TblTitel_ValuesBob);

        //First line of the table - DH Private Key
        label_b_private = new Label(keyTableGroup, SWT.READ_ONLY);
        label_b_private.setText(Messages.SignalEncryption_KeyName_Diffie_Private);

        text_b_private = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_b_private.setLayoutData(gd_text);
        text_b_private.setText(Messages.SignalEncryption_DescText_Diffie_Private);

        value_b_alice_private = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_b_alice_private.setLayoutData(gd_value);
        value_b_alice_private.setText(aliceRatchetPrivateKey); 
        
        value_b_bob_private = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_b_bob_private.setLayoutData(gd_value);
        value_b_bob_private.setText(bobRatchetPrivateKey);
        
        //First line of the table - DH Public Key
        label_b_public = new Label(keyTableGroup, SWT.READ_ONLY);
        label_b_public.setText(Messages.SignalEncryption_KeyName_Diffie_Public);

        text_b_public = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_b_public.setLayoutData(gd_text);
        text_b_public.setText(Messages.SignalEncryption_DescText_Diffie_Public);

        value_b_alice_public = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_b_alice_public.setLayoutData(gd_value);
        value_b_alice_public.setText(aliceRatchetPublicKey); 
        
        value_b_bob_public = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_b_bob_public.setLayoutData(gd_value);
        value_b_bob_public.setText(bobRatchetPublicKey);
        
        //Second line of the table - Shared Secret Keys
        /*
        label_c = new Label(keyTableGroup, SWT.READ_ONLY);
        label_c.setText(Messages.SignalEncryption_KeyName_Shared);

        text_c = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_c.setLayoutData(gd_text);
        text_c.setText(Messages.SignalEncryption_DescText_Shared);
        		
        value_c_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_c_alice.setLayoutData(gd_value);
        value_c_alice.setText(aliceSharedKey);
        
        value_c_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_c_bob.setLayoutData(gd_value);
        value_c_bob.setText(bobSharedKey);
        */
        
        //Third line of the table - Root Keys
        label_d = new Label(keyTableGroup, SWT.READ_ONLY);
        label_d.setText(Messages.SignalEncryption_KeyName_Root);

        text_d = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_d.setLayoutData(gd_text);
        text_d.setText(Messages.SignalEncryption_DescText_Root);

        value_d_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_d_alice.setLayoutData(gd_value);
        value_d_alice.setText(aliceRootKey);
        
        value_d_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_d_bob.setLayoutData(gd_value);
        value_d_bob.setText(bobRootKey);

        //Fourth line of the table - Sending Chain Key
        label_e = new Label(keyTableGroup, SWT.READ_ONLY);
        label_e.setText(Messages.SignalEncryption_KeyName_Sending);

        text_e = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_e.setLayoutData(gd_text);
        text_e.setText(Messages.SignalEncryption_DescText_Sending);

        value_e_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_e_alice.setLayoutData(gd_value);
        value_e_alice.setText(aliceSendingChainKey);
        
        value_e_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_e_bob.setLayoutData(gd_value);
        value_e_bob.setText(bobSendingChainKey);

        //Fifth line of the table - Receiving Chain Keys
        label_f = new Label(keyTableGroup, SWT.READ_ONLY);
        label_f.setText(Messages.SignalEncryption_KeyName_Receiving);

        text_f = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_f.setLayoutData(gd_text);
        text_f.setText(Messages.SignalEncryption_DescText_Receiving);

        value_f_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_f_alice.setLayoutData(gd_value);
        value_f_alice.setText(aliceReceivingChainKey);
        
        value_f_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_f_bob.setLayoutData(gd_value);
        value_f_bob.setText(bobReceivingChainKey);

        //Sixt line of the table - Messages Keys
        label_g = new Label(keyTableGroup, SWT.READ_ONLY);
        label_g.setText(Messages.SignalEncryption_KeyName_MsgKey);

        text_g = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_g.setLayoutData(gd_text);
        text_g.setText(Messages.SignalEncryption_DescText_MsgKey);

        value_g_alice = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_g_alice.setLayoutData(gd_value);
        value_g_alice.setText(aliceSenderMsgKey);
        
        value_g_bob = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_g_bob.setLayoutData(gd_value);
        value_g_bob.setText(bobSenderMsgKey);
        
        //Button for generating all keys new
        btn_regenerate = new Button(keyTableGroup, SWT.PUSH);
        btn_regenerate.setText(Messages.SignalEncryption_btn_generateBoth);
        btn_regenerate.addSelectionListener(new SelectionAdapter() {

        	
            @Override
            public void widgetSelected(SelectionEvent e) {
                generateBoth();                
            }
        });
        
        //Button for generating new keys for Alice
        btn_regenerate = new Button(keyTableGroup, SWT.PUSH);
        btn_regenerate.setText(Messages.SignalEncryption_btn_generateAlice);
        btn_regenerate.addSelectionListener(new SelectionAdapter() {

        	
            @Override
            public void widgetSelected(SelectionEvent e) {
                generateAlice();                
            }
        });
        
        //Button for generation new keys for Bob
        btn_regenerate = new Button(keyTableGroup, SWT.PUSH);
        btn_regenerate.setText(Messages.SignalEncryption_btn_generateBob);
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
        keyTableGroup.setText(Messages.SignalEncryption_TblTitel_Key);
        keyTableGroup.setLayoutData(gd_keyTableGroup);

        createTable();

    }
    
    private void setTitleAndDescription() {

        titleAndDescription = new TitleAndDescriptionComposite(this);
        titleAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        titleAndDescription.setTitle(Messages.SignalEncryption_TabTitle1);
        titleAndDescription.setDescription(Messages.SignalEncryption_TabDesc1);
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
        signalEncryptionState.generateBoth();
        setParameter();
        textReset();
    }
    public void generateAlice() {
        signalEncryptionState.generateAlice();
        setParameter();
        textReset();
    }
    public void generateBob() {
        signalEncryptionState.generateBob();
        setParameter();
        textReset();
    }
    public void textReset() {
        value_b_alice_private.setText(aliceRatchetPrivateKey); 
        value_b_alice_public.setText(aliceRatchetPublicKey); 
        value_d_alice.setText(aliceRootKey);
        value_e_alice.setText(aliceSendingChainKey);
        value_f_alice.setText(aliceReceivingChainKey);
        value_g_alice.setText(aliceSenderMsgKey);

        value_b_bob_private.setText(bobRatchetPrivateKey); 
        value_b_bob_public.setText(bobRatchetPublicKey); 
        value_d_bob.setText(bobRootKey);
        value_e_bob.setText(bobSendingChainKey);
        value_f_bob.setText(bobReceivingChainKey);
        value_g_bob.setText(bobSenderMsgKey);
    }
    public void setParameter() {
        aliceRatchetPrivateKey = signalEncryptionState.getAliceRatchetPrivateKey();
        aliceRatchetPublicKey = signalEncryptionState.getAliceRatchetPublicKey();
        aliceRootKey = signalEncryptionState.getaliceRootKey();
        aliceSendingChainKey = signalEncryptionState.getAliceSendingChainKey();
        aliceSenderMsgKey = signalEncryptionState.getAliceSenderMsgKey();
        aliceReceivingChainKey = signalEncryptionState.getAliceReceivingChainKey();
        
        bobRatchetPrivateKey = signalEncryptionState.getBobRatchetPrivateKey();
        bobRatchetPublicKey = signalEncryptionState.getBobRatchetPublicKey();
        bobRootKey = signalEncryptionState.getBobRootKey();
        bobSendingChainKey = signalEncryptionState.getBobSendingChainKey();
        bobReceivingChainKey = signalEncryptionState.getBobReceivingChainKey();
        bobSenderMsgKey = signalEncryptionState.getBobSenderMsgKey();
        

        
    }
    /*
     *     public void textReset() {
        value_b_alice_private.setText(signalEncryptionState.getAliceRatchetPrivateKey()); 
        value_b_alice_public.setText(signalEncryptionState.getAliceRatchetPublicKey()); 
        value_d_alice.setText(signalEncryptionState.getaliceRootKey());
        value_e_alice.setText(signalEncryptionState.getAliceSendingChainKey());
        value_f_alice.setText(signalEncryptionState.getAliceSenderMsgKey());
        value_g_alice.setText(signalEncryptionState.getAliceReceivingChainKey());

        value_b_bob_private.setText(signalEncryptionState.getBobRatchetPrivateKey()); 
        value_b_bob_public.setText(signalEncryptionState.getBobRatchetPublicKey()); 
        value_d_bob.setText(signalEncryptionState.getBobRootKey());
        value_e_bob.setText(signalEncryptionState.getBobSendingChainKey());
        value_f_bob.setText(signalEncryptionState.getBobReceivingChainKey());
        value_g_bob.setText(signalEncryptionState.getBobSenderMsgKey());
    }
     */
    
}
