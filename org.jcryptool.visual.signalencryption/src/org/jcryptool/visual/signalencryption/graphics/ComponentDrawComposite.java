package org.jcryptool.visual.signalencryption.graphics;

import static org.jcryptool.visual.signalencryption.ui.ViewConstants.ARROW_HEAD_SIZE;
import static org.jcryptool.visual.signalencryption.ui.ViewConstants.TARGET_MARGIN;

import java.util.Set;
import java.util.function.Function;
import java.util.HashSet;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.jcryptool.visual.signalencryption.graphics.Arrow.ArrowProperties;
import org.jcryptool.visual.signalencryption.ui.MailShapes;
import org.jcryptool.visual.signalencryption.ui.ViewConstants;

public class ComponentDrawComposite extends Canvas {

	private static final int MARGIN = ARROW_HEAD_SIZE + TARGET_MARGIN;
	private static final Function<Integer, Integer> STRAIGHT_DIRECTION = i -> i;
	private static final Function<Integer, Integer> OPPOSITE_DIRECTION = i -> -i;

	private Set<Arrow> arrowsToDraw = new HashSet<>();
	private Set<MailShapes> shapesToDraw = new HashSet<>();
	private Set<Component> componentsToDraw = new HashSet<>();

	public ComponentDrawComposite(Composite parent, int style) {
		super(parent, style | SWT.DOUBLE_BUFFERED); // we want this always double buffered for smooth interaction
		this.addPaintListener(e -> paintControl(e));
	}

	private void paintControl(PaintEvent e) {
		//e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_DARK_RED));
		e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_WIDGET_BORDER));
		for (var arrow : arrowsToDraw) {
			if (arrow.isVisible()) {
				var path = arrow.path();
				e.gc.fillPath(path);
				path.dispose();
			}
		}
		
		for (var arrow : shapesToDraw) {
			if (arrow.isVisible()) {
				var path = arrow.path();
				e.gc.drawPath(path);
				e.gc.fillPath(path);
				path.dispose();
			}
		}
		
		for (var component: componentsToDraw) {
			if (component.isVisible()) {
				component.draw(e.gc);
			}
		}
	}

	public void addArrow(Arrow arrow) {
		arrowsToDraw.add(arrow);
	}

	public void removeArrow(Arrow arrow) {
		arrowsToDraw.remove(arrow);
	}

	public void addShape(MailShapes arrow) {
		shapesToDraw.add(arrow);
	}

	public void removeShape(MailShapes arrow) {
		shapesToDraw.remove(arrow);
	}
	
	public <C extends Component> C addComponent(C component) {
		componentsToDraw.add(component);
		return component;
	}

	public void removeComponent(Component component) {
		componentsToDraw.remove(component);
	}

	public static Path createPath(ArrowProperties props) {
		checkSideValidity(props.startSide, props.endSide);

		Point start = calculateStartPoint(props);
		Point end = calculateEndPoint(props);

		if (isHorizontalOrVertical(start, end)) {
			return drawStraightArrow(props, start, end);
		} else {
			return drawKinkedArrow(props, start, end);
		}
	}

	private static Path drawStraightArrow(ArrowProperties props, Point start, Point end) {
		Path resultPath = new Path(props.canvas.getDisplay());
		var width = getWidth(props, start, end);
		var height = getHeight(props, start, end);
		resultPath.addRectangle(start.x, start.y, width, height);
		return drawArrowHead(resultPath, props, centerEnd(props, end));
	}

	private static Path drawArrowHead(Path path, ArrowProperties props, Point end) {
		int x1, x2, x3;
		int y1, y2, y3;
		Function<Integer, Integer> direction = STRAIGHT_DIRECTION;

		int arrowHeadWidthHalf = props.headWidth / 2;

		switch (props.endSide) {
		case EAST:
			direction = OPPOSITE_DIRECTION; // In this case the arrow should point in the opposite direction
		case WEST:
			x1 = end.x;
			y1 = end.y + arrowHeadWidthHalf;
			x2 = end.x + direction.apply(ViewConstants.ARROW_HEAD_SIZE);
			y2 = end.y;
			x3 = end.x;
			y3 = end.y - arrowHeadWidthHalf;
			break;
		case NORTH:
			direction = OPPOSITE_DIRECTION; // In this case the arrow should point in the opposite direction
		case SOUTH:
			x1 = end.x + arrowHeadWidthHalf;
			y1 = end.y;
			x2 = end.x;
			y2 = end.y - direction.apply(ViewConstants.ARROW_HEAD_SIZE);
			x3 = end.x - arrowHeadWidthHalf;
			y3 = end.y;
			break;
		default:
			return path;
		}
		path.moveTo(x1, y1);
		path.lineTo(x2, y2);
		path.lineTo(x3, y3);
		path.lineTo(x1, y1);
		return path;
	}

	private static Path drawKinkedArrow(ArrowProperties props, Point start, Point end) {
		
		if (!attachesHorizontally(props)) {
			throw new UnsupportedOperationException("This arrow-type only supports horizontally offset arrows");
		}
		Path path = new Path(props.canvas.getDisplay());

		int width = getWidth(props, start, end);
		int height = props.lineWidth;

		var widthA = props.cornerPosition.apply(start, end);
		var widthB = width - (widthA + props.lineWidth);

		var heightCorrection = (end.y - start.y);

		path.addRectangle(start.x, start.y, widthA, height);
		path.addRectangle(start.x + widthA, start.y + props.lineWidth, props.lineWidth, heightCorrection - props.lineWidth);
		path.addRectangle(start.x + widthA + props.lineWidth, start.y + heightCorrection, widthB, height);

		return drawArrowHead(path, props, centerEnd(props, end));
	}

	private static int getWidth(ArrowProperties props, Point start, Point end) {
		var width = end.x - start.x;
		return width == 0 ? props.lineWidth : width;
	}

	private static int getHeight(ArrowProperties props, Point start, Point end) {
		var height = end.y - start.y;
		return height == 0 ? props.lineWidth: height;
	}

	private static boolean isHorizontalOrVertical(Point start, Point end) {
		return isStraightHorizontal(start, end) || isStraightVertical(start, end);
	}

	private static boolean isStraightHorizontal(Point start, Point end) {
		return start.y == end.y;
	}

	private static boolean isStraightVertical(Point start, Point end) {
		return start.x == end.x;
	}

	private static boolean attachesVertically(ArrowProperties props) {
		return props.endSide == Side.NORTH || props.endSide == Side.SOUTH;
	}

	private static boolean attachesHorizontally(ArrowProperties props) {
		return !attachesVertically(props);
	}

	private static Point centerEnd(ArrowProperties props, Point end) {
		int arrowWidthHalf = props.lineWidth / 2;
		if (attachesVertically(props)) {
			return new Point(end.x + arrowWidthHalf, end.y);
		} else {
			return new Point(end.x, end.y + arrowWidthHalf);
		}
	}

	private static Point calculateStartPoint(ArrowProperties props) {
		return new Point(props.xStart.side.getX(props.xStart.control, props.canvas),
				props.yStart.side.getY(props.yStart.control, props.canvas));
	}

	private static Point calculateEndPoint(ArrowProperties props) {
		var x = props.xEnd.side.getX(props.xEnd.control, props.canvas);
		var y = props.yEnd.side.getY(props.yEnd.control, props.canvas);
		switch (props.endSide) {
		case EAST:
			x += MARGIN;
			break;
		case NORTH:
			y -= MARGIN;
			break;
		case SOUTH:
			y += MARGIN;
			break;
		case WEST:
			x -= MARGIN;
			break;
		}
		return new Point(x, y);
	}

	/**
	 * This implementation only supports directly facing sides - throw an error if
	 * this is not the case.
	 */
	private static void checkSideValidity(Side start, Side end) {
		if (!start.faces(end)) {
			throw new UnsupportedOperationException("This impl only allows facing arrows (e.g. South to North)");
		}
	}

		public static enum Side {
		NORTH {

			@Override
			boolean faces(Side other) {
				return other == SOUTH;
			}

			@Override
			int getX(Control control, Control anchor) {
				var bounds = correctedBounds(control, anchor);
				return bounds.x + (bounds.width / 2);
			}

			@Override
			int getY(Control control, Control anchor) {
				return correctedBounds(control, anchor).y + CORRECTION_FACTOR;
			}

		},
		EAST {

			@Override
			boolean faces(Side other) {
				return other == WEST;
			}

			@Override
			int getX(Control control, Control anchor) {
				var bounds = correctedBounds(control, anchor);
				return bounds.x + bounds.width;
			}

			@Override
			int getY(Control control, Control anchor) {
				var bounds = correctedBounds(control, anchor);
				return bounds.y + (bounds.height / 2) + CORRECTION_FACTOR;
			}

		},
		SOUTH {

			@Override
			boolean faces(Side other) {
				return other == NORTH;
			}

			@Override
			int getX(Control control, Control anchor) {
				var bounds = correctedBounds(control, anchor);
				return bounds.x + (bounds.width / 2);
			}

			@Override
			int getY(Control control, Control anchor) {
				var bounds = correctedBounds(control, anchor);
				return bounds.y + bounds.height + CORRECTION_FACTOR;
			}

		},
		WEST {

			@Override
			boolean faces(Side other) {
				return other == EAST;
			}

			@Override
			int getX(Control control, Control anchor) {
				return correctedBounds(control, anchor).x;
			}

			@Override
			int getY(Control control, Control anchor) {
				var bounds = correctedBounds(control, anchor);
				return bounds.y + (bounds.height / 2) + CORRECTION_FACTOR;
			}

		};

		static final int CORRECTION_FACTOR = 20;

		abstract boolean faces(Side other);

		abstract int getX(Control control, Control anchor);

		abstract int getY(Control control, Control anchor);

		public static Rectangle correctedBounds(Control control, Control anchor) {
			Rectangle innerBounds = control.getBounds();
			var offsetX = 0;
			var offsetY = 0;
			while (control.getParent() != null && control != anchor) {
				control = control.getParent();
				var location = control.getLocation();
				offsetX += location.x;
				offsetY += location.y;
			}
			return new Rectangle(innerBounds.x + offsetX, innerBounds.y + offsetY, innerBounds.width,
					innerBounds.height);
		}
	}

}
