package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
    private Table keyTable;

    // TableColumn
    private TableColumn keyTableColumn;

    // TableItems
    private TableItem keyTableItem;

    // TableLabels
    private Label label_column;
    private Label text_column;

    private Label value_column;
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
    private Text value_b;
    private Text value_c;
    private Text value_d;
    private Text value_e;
    private Text value_f;
    private Text value_g;

    /**
     * 
     **/
    public SignalEncryptionViewOverview(final Composite parent, int style) {
        super(parent, style);

        setLayout(new GridLayout());

        setTitleAndDescription();
        createOverViewComposite();

    }

    private void createDescriptionGroup() {

        descriptionGroup = new Group(overViewComposite, SWT.NONE);
        gl_descriptionGroup = new GridLayout(1, false);
        gd_descriptionGroup = new GridData(SWT.FILL, SWT.FILL, false, true);

        descriptionGroup.setLayout(gl_descriptionGroup);
        descriptionGroup.setText("Schlüssel");
        descriptionGroup.setLayoutData(gd_descriptionGroup);

    }

    private void createTable() {

        // Table Variante

        // keyTable = new Table(parent, SWT.MULTI | SWT.BORDER);
        // keyTable.setHeaderVisible(true);
        //
        // String[] titles = { "Schlüssel", "Beschreibung", "Wert" };
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
        // keyTableItem.setText(0, "SchlüsselName");
        // keyTableItem.setText(1, "SchlüsselBeschreibung");
        // keyTableItem.setText(2, "SchlüsselWert");
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
        label_column.setText("Schlüssel");

        text_column = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        text_column.setLayoutData(gd_text);
        text_column.setText("Beschreibung");

        value_column = new Label(keyTableGroup, SWT.READ_ONLY | SWT.CENTER);
        value_column.setLayoutData(gd_text);
        value_column.setText("Wert");

        label_b = new Label(keyTableGroup, SWT.READ_ONLY);
        label_b.setText("Diffie Hellman Key Pair");

        text_b = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_b.setLayoutData(gd_text);
        text_b.setText("Besteht aus einem öffentlichen und privaten Teil.");

        value_b = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_b.setLayoutData(gd_value);
        value_b.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");

        label_c = new Label(keyTableGroup, SWT.READ_ONLY);
        label_c.setText("Shared Secret Key");

        text_c = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_c.setLayoutData(gd_text);
        text_c.setText("Geheimer Schlüssel der von den Kommunikationspartnern mittels einem "
                + "vereinbarten Schlüsselaustausch erstellt wird. Dieser Schlüssel dient als erster Root" + "Key.");

        value_c = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_c.setLayoutData(gd_value);
        value_c.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");

        label_d = new Label(keyTableGroup, SWT.READ_ONLY);
        label_d.setText("Root Chain Key");

        text_d = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_d.setLayoutData(gd_text);
        text_d.setText("Der Root Chain Key dient als Schlüssel für die Root Chain.");

        value_d = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_d.setLayoutData(gd_value);
        value_d.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");

        label_e = new Label(keyTableGroup, SWT.READ_ONLY);
        label_e.setText("Sending Chain Key");

        text_e = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_e.setLayoutData(gd_text);
        text_e.setText("Der Sending Chain Key wird verwendet um einen Message Key zu" + "generieren.");

        value_e = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_e.setLayoutData(gd_value);
        value_e.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");

        label_f = new Label(keyTableGroup, SWT.READ_ONLY);
        label_f.setText("Receiving Chain Key");

        text_f = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_f.setLayoutData(gd_text);
        text_f.setText("Der Receiving Chain Key wird verwendet um einen Message Key zu" + "generieren.");

        value_f = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_f.setLayoutData(gd_value);
        value_f.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");

        label_g = new Label(keyTableGroup, SWT.READ_ONLY);
        label_g.setText("Message Key");

        text_g = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        text_g.setLayoutData(gd_text);
        text_g.setText("Der Message Key ist ein Output aus der Sending Chain bzw. der Receiving"
                + "Chain und wird verwendet um eine Nachricht zu ver- oder entSchlüsseln.");

        value_g = new Text(keyTableGroup, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
        value_g.setLayoutData(gd_value);
        value_g.setText(
                "7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF7FFFFFFFFFFFFFFF");
    }

    private void createTableGroup() {

        keyTableGroup = new Group(overViewComposite, SWT.NONE);
        gl_keyTableGroup = new GridLayout(5, false);
        gd_keyTableGroup = new GridData(SWT.LEFT, SWT.TOP, false, false);
        gd_keyTableGroup.minimumWidth = 1000;

        keyTableGroup.setLayout(gl_keyTableGroup);
        keyTableGroup.setText("Schlüssel");
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
}
