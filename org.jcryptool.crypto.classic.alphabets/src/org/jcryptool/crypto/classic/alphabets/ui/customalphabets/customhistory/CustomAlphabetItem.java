package org.jcryptool.crypto.classic.alphabets.ui.customalphabets.customhistory;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.jcryptool.core.operations.alphabets.AbstractAlphabet;
import org.jcryptool.crypto.classic.alphabets.composite.AtomAlphabet;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class CustomAlphabetItem extends Composite {
	private Label lblName;
	private Label lblContent;
	private Label lblName_1;
	private Label lblContent_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CustomAlphabetItem(Composite parent, AbstractAlphabet alpha) {
		super(parent, SWT.BORDER);
		setLayout(new GridLayout(2, false));
		MouseAdapter clickListener = new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				CustomAlphabetItem.this.notifyListeners(SWT.MouseDown, null);
			}
		};
		{
			lblName_1 = new Label(this, SWT.NONE);
			lblName_1.setText("Name:");
			lblName_1.addMouseListener(clickListener);
		}
		{
			lblName = new Label(this, SWT.NONE);
			lblName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			lblName.setText(alpha.getName());
			lblName.addMouseListener(clickListener);
		}
		{
			lblContent_1 = new Label(this, SWT.NONE);
			lblContent_1.setText("Content:");
			lblContent_1.addMouseListener(clickListener);
		}
		{
			lblContent = new Label(this, SWT.WRAP);
			GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
			layoutData.widthHint = 150;
			lblContent.setLayoutData(layoutData);
			lblContent.setText(AtomAlphabet.alphabetContentAsString(alpha.getCharacterSet()));
			lblContent.addMouseListener(clickListener);
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
