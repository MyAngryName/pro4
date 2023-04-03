package org.jcryptool.visual.signalencryption.ui;

import java.util.List;
import java.util.function.BiFunction;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.core.util.colors.ColorService;
import org.jcryptool.core.util.ui.layout.GridDataBuilder;

public class PopupUtil {

	private PopupUtil() {
		// Prevent instantiation of only static member class
	}
	
	public static BiFunction<Composite, Integer, Composite> createShowValueFunction(String key, String value) {
		return createShowValueFunction("Title", List.of(key), List.of(value));
	}

	public static BiFunction<Composite, Integer, Composite> createShowValueFunction(
			String title,
			String key,
			String value
	) {
		return createShowValueFunction(title, List.of(key), List.of(value));
	}

	public static BiFunction<Composite, Integer, Composite> createShowValueFunction(
			String title,
			List<String> keys,
			List<String> values
	) {
		assert keys.size() == values.size();
		return (parent, style) -> {
			var composite = new Composite(parent, style);

			for (int i = 0; i < keys.size(); ++i) {
				var label = new Label(composite, SWT.NONE);
				var txt = new StyledText(composite, SWT.BORDER);
				txt.setCaret(null);
				txt.setEditable(false);

				var layout = new GridLayout(2, false);

				composite.setLayout(layout);
				composite.setLayoutData(GridDataBuilder.with(SWT.FILL, SWT.FILL, true, true).get());
				label.setText(keys.get(i));
				label.setLayoutData(GridDataBuilder.with(SWT.FILL, SWT.TOP, false, false).get());
				txt.setLayoutData(GridDataBuilder.with(SWT.FILL, SWT.TOP, true, false).get());
				txt.setText(values.get(i));
			}
			return composite;
		};
	}
	
	public static void updatePopupFor(FlowChartNode node, String key) {
		node.setPopupProvider(createShowValueFunction(node.getTitle(), List.of(key), List.of("generic")));
	}
	
	public static void updatePopupFor(FlowChartNode node, String key, String value) {
		node.setPopupProvider(createShowValueFunction(node.getTitle(), List.of(key), List.of(value)));
	}

	public static void updatePopupFor(FlowChartNode node, List<String> keys, List<String> values) {
		node.setPopupProvider(createShowValueFunction(node.getTitle(), keys, values));
	}

}
