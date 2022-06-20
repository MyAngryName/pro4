package org.jcryptool.visual.signalencryption.ui;

import java.util.Objects;
import java.util.function.BiFunction;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.core.util.colors.ColorService;
import org.jcryptool.core.util.images.ImageService;
import org.jcryptool.core.util.ui.layout.GridDataBuilder;

public class FlowChartNode extends Composite {
    
    private static final int POPUP_STYLE = SWT.MODELESS;
    private static final Image buttonImage = ImageService.getImage(SignalEncryptionView.ID, "icons/searchIcon.png");

    private final Text txt_title;
    private final Button btn_action;
    private final Shell parentShell;
    private final String title;
    private boolean showing;
    private Shell popup;
    private BiFunction<Composite, Integer, Composite> popupProvider;
    
    

    private FlowChartNode(Composite parent, int style, String title, String actionName, Type type, BiFunction<Composite, Integer, Composite> popupProvider) {
        super(parent, style);
        this.popupProvider = popupProvider;
        this.parentShell = getShell();
        this.setBackground(ColorService.getColor(SWT.COLOR_LIST_BACKGROUND));
        
        setLayout(new GridLayout(1, true));
        
        txt_title = new Text(this, SWT.NONE);
        txt_title.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        txt_title.setText(title);
        this.title = title;

        btn_action = new Button(this, SWT.TOGGLE);
        btn_action.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        btn_action.setImage(buttonImage);
        
        if (!Objects.isNull(actionName) && !actionName.isEmpty()) {
            btn_action.setText(actionName);
        }
        
        btn_action.addSelectionListener(showPopupListener());
        }
    
    public void setPopupProvider(BiFunction<Composite, Integer, Composite> popupProvider) {
        this.popupProvider = popupProvider;
    }
    
    public String getTitle() {
        return title;
    }
    
    private SelectionAdapter showPopupListener() {
        return new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (showing) {
                    disposePopup();
                    btn_action.setSelection(false);
                } else {
                    showPopup();
                    btn_action.setSelection(true);
                }
            }
        };
    }
    
    private void showPopup() {
        popup = new Shell(parentShell, POPUP_STYLE);
        popup.setLayout(new GridLayout());
        popup.setText("Title");
        var baseComposite = new Composite(popup, SWT.NONE);
        baseComposite.setLayout(new GridLayout(1, true));
        baseComposite.setLayoutData(
                GridDataBuilder.with(SWT.FILL, SWT.FILL, true, true)
                .minimumHeight(400)
                .minimumWidth(800)
                .get()
        );
        baseComposite.setVisible(true);
        popupProvider.apply(baseComposite, SWT.NONE);
        setCenterLocation(popup);
        popup.forceActive();
        popup.forceFocus();
        popup.pack();
        popup.open();
        showing = true;
        
        popup.addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                btn_action.setSelection(false);
                showing = false;
            }
        });
    }
    
    private void disposePopup() {
        popup.dispose();
        showing = false;
    }
    
    
    private void setCenterLocation(Shell shell) {
        var parentLocation = parentShell.getLocation();
        var parentSize = parentShell.getSize();
        var shellSize = shell.getSize();
        var x = parentLocation.x + (parentSize.x / 2) - (shellSize.x / 2);
        var y = parentLocation.y + (parentSize.y / 2) - (shellSize.y / 2);
        shell.setLocation(x, y);
    }
    
    public static class Builder {
        
        
        public Builder(Composite parent) {
            this.parent = parent;
        }
        
        private Composite parent;
        private int style = SWT.BORDER;
        private String title = "NO TITLE";
        private String actionName = "";
        private BiFunction<Composite, Integer, Composite> popupProvider = (shell, style) -> {
            var composite = new Composite(shell, style);
            var text = new Text(composite, SWT.NONE);
            text.setText("no content");
            return composite;
        };
        
        public Builder style(int style) {
            this.style = style;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder actionName(String actionName) {
            this.actionName = actionName;
            return this;
        }
        public Builder popupProvider(BiFunction<Composite, Integer, Composite> popupProvider) {
            this.popupProvider = popupProvider;
            return this;
        }
        
        public FlowChartNode buildOperationNode() {
            return new FlowChartNode(
                    parent, style, title, actionName, Type.OPERATION, popupProvider
            );
        }
        
        public FlowChartNode buildValueNode() {
            return new FlowChartNode(
                    parent, style, title, actionName, Type.VALUE, popupProvider
            );
        }
        
    }

    public static enum Type {
        OPERATION,
        VALUE
    }

}
