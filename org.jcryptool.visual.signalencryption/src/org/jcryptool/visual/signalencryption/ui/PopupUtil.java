package org.jcryptool.visual.signalencryption.ui;

import java.util.function.BiFunction;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.core.util.ui.layout.GridDataBuilder;

public class PopupUtil {

    private PopupUtil() {
        // Prevent instantiation of only static member class
    }
    
    public static BiFunction<Composite, Integer, Composite> createShowValueFunction(String title, String value) {
        return (parent, style) -> {
            var composite = new Composite(parent, style);
            var txt = new Text(composite, SWT.CENTER);
            composite.setLayout(new GridLayout(1, true));
            composite.setLayoutData(GridDataBuilder.with(SWT.FILL, SWT.FILL, true, true).get());
            txt.setText(String.format("%s = %s", title, value));
            txt.setLayoutData(GridDataBuilder.with(SWT.FILL,SWT.FILL, true, true).get());
            return composite;
        };
    }
    
    public static void updatePopupFor(FlowChartNode node, String newValue) {
        node.setPopupProvider(createShowValueFunction(node.getTitle(), newValue));
    }

}
