package org.jcryptool.visual.signalencryption.graphics;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.jcryptool.core.logging.utils.LogUtil;
import org.jcryptool.core.util.images.ImageService;
import org.jcryptool.visual.signalencryption.graphics.Positioning.Anchor;
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionView;

public class ImageComponent implements Component {

	private static final String OUTGOING_MAIL_BASE = "icons/mailOutgoing";
	private static final String INCOMING_MAIL_BASE = "icons/mailIncoming";
	private static final String DARK_MODE_PATH_COMPONENT = "_light";
	private static final String FILE_ENDING = ".png";

	private boolean visible;
	private final LocationProps location;
	private final Image image;

	public static ImageComponentBuilder on(ComponentDrawComposite canvas) {
		return new ImageComponentBuilder(canvas);
	}
	
	public int imageWidth() {
		return image.getBounds().width;
	}
	public int imageHeight() {
		return image.getBounds().height;
	}

	private ImageComponent(String imagePath, Anchor location, Point offset, ComponentDrawComposite canvas) {
		this.location = new LocationProps(location, offset, canvas);
		this.visible = true;
		this.image = loadImage(imagePath);
	}

	@Override
	public void draw(GC gc) {
		var drawLocation = this.location.resolve(image);
		gc.drawImage(image, drawLocation.x, drawLocation.y);
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	private Image loadImage(String path) {
		var image = ImageService.getImage(SignalEncryptionView.ID, path);
		if (image == null) {
			LogUtil.logWarning(String.format("Could not load image '%s'. Displaying empty instead...%n", path));
			image = new Image(location.canvas.getDisplay(), 0, 0);
		}
		return image;
	}

	private class LocationProps {
		final Anchor anchor;
		final Point offset;
		final ComponentDrawComposite canvas;

		LocationProps(Anchor anchor, Point offset, ComponentDrawComposite canvas) {
			this.anchor = anchor;
			this.offset = offset;
			this.canvas = canvas;
		}

		/**
		 * Note that this resolving anchors at the image's west point, instead of
		 * north-west
		 */
		Point resolve(Image image) {
			return anchor.resolve(canvas, offset.x, offset.y - (image.getImageData().height / 2));
		}
	}

	public static class ImageComponentBuilder {

		private ComponentDrawComposite canvas;
		private Anchor anchor;
		private int offsetX = 0;
		private int offsetY = 0;

		public ImageComponentBuilder(ComponentDrawComposite canvas) {
			this.canvas = canvas;
		}

		public ImageComponentBuilder offsetX(int offsetX) {
			this.offsetX = offsetX;
			return this;
		}

		public ImageComponentBuilder offsetY(int offsetY) {
			this.offsetY = offsetY;
			return this;
		}

		public ImageComponentBuilder relativeTo(Control control, Positioning.Side side) {
			this.anchor = new Anchor(control, side);
			return this;
		}

		public ImageComponent outgoingMail() {
			return create(resolveForDarkMode(OUTGOING_MAIL_BASE, canvas));
		}

		public ImageComponent incomingMail() {
			return create(resolveForDarkMode(INCOMING_MAIL_BASE, canvas));
		}

		private static String resolveForDarkMode(String path, ComponentDrawComposite canvas) {
			if (Display.isSystemDarkTheme()) {
				return path + DARK_MODE_PATH_COMPONENT + FILE_ENDING;
			} else {
				return path + FILE_ENDING;
			}
		}

		private ImageComponent create(String path) {
			return canvas.addComponent(new ImageComponent(path, anchor, new Point(offsetX, offsetY), canvas));
		}
	}
}
