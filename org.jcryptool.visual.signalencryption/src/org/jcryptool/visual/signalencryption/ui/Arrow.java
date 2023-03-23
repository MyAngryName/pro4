package org.jcryptool.visual.signalencryption.ui;

import java.util.Objects;
import java.util.function.BiFunction;

import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.jcryptool.visual.signalencryption.ui.CompositeWithArrowSupport.Side;

public class Arrow {
	
	private static final String DEFAULT_ID_TEMPLATE = "arrow-%s-%s%n";
	private final static BiFunction<Point, Point, Integer> CORNER_AT_MIDDLE = (start, end) -> {
		return (int) Math.round((end.x - start.x) * 0.5);
	};
	
	private final ArrowProperties properties;
	private boolean visible;
	private final String id;

	public Arrow(ArrowProperties properties, boolean visible) {
		this(properties, visible, String.format(DEFAULT_ID_TEMPLATE, properties.startSide, properties.endSide));
	}
	
	public Arrow(ArrowProperties properties, boolean visible, String id) {
		this.properties = properties;
		this.visible = visible;
		this.id = id;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public String getId() {
		return id;
	}

	public Path path() {
		return CompositeWithArrowSupport.createPath(properties);
	}

	@Override
	public int hashCode() {
		return Objects.hash(properties);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arrow other = (Arrow) obj;
		return Objects.equals(properties, other.properties);
	}

	public static class ArrowProperties {
		final Anchor xStart;
		final Anchor yStart;
		final Side startSide;

		final Anchor xEnd;
		final Anchor yEnd;
		final Side endSide;

		final int lineWidth;
		final int headWidth;
		final int headSize;
		final CompositeWithArrowSupport canvas;
		final BiFunction<Point, Point, Integer> cornerPosition;

		public ArrowProperties(
				Anchor xStart, Anchor yStart, Side outgoingSide,
				Anchor xEnd, Anchor yEnd, Side incomingSide,
				int lineWidth,
				int headWidth,
				int headSize,
				CompositeWithArrowSupport canvas,
				BiFunction<Point, Point, Integer> cornerPosition
			) {
			this.xStart = xStart;
			this.yStart = yStart;
			this.startSide = outgoingSide;
			this.xEnd = xEnd;
			this.yEnd = yEnd;
			this.endSide = incomingSide;
			this.lineWidth = lineWidth;
			this.headWidth = headWidth;
			this.headSize = headSize;
			this.canvas = canvas;
			this.cornerPosition = cornerPosition;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(lineWidth, headWidth, xEnd, xStart, yEnd, yStart, startSide, endSide);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ArrowProperties other = (ArrowProperties) obj;
			return lineWidth == other.lineWidth && Objects.equals(xEnd, other.xEnd)
					&& Objects.equals(xStart, other.xStart) && Objects.equals(yEnd, other.yEnd)
					&& Objects.equals(yStart, other.yStart) && startSide == other.startSide && endSide == other.endSide
					&& headWidth == other.headWidth;
		}
	}
	
	/** The more complex alternative to {@link Arrow#from(Control)} */
	public static FromBuilder fromAnchors() {
		return new FromBuilder(new ArrowLocationContext());
	}
	
	public static class FromBuilder {
		private final ArrowLocationContext location;

		public FromBuilder(ArrowLocationContext location) {
			this.location = location;
		}
		
		public FromBuilder fromAnchorX(Control control, Side side) {
			location.fromX = new Anchor(control, side);
			return this;
		}
		
		public FromBuilder fromAnchorY(Control control, Side side) {
			location.fromY = new Anchor(control, side);
			return this;
		}

		/**
		 * Set the outgoing (at source) direction. Then continue with the destination location.
		 * Make sure that both to anchors are set before calling this
		 */
		public ToBuilder outgoingDirection(Side outgoingDirection) {
			location.outgoingDirection = outgoingDirection;
			assert location.fromX != null;
			assert location.fromY != null;
			return new ToBuilder(location);
		}
	}

	public static class ToBuilder {
		private final ArrowLocationContext location;

		public ToBuilder(ArrowLocationContext location) {
			this.location = location;
		}
		
		public ToBuilder toAnchorX(Control control, Side side) {
			location.toX = new Anchor(control, side);
			return this;
		}
		
		public ToBuilder toAnchorY(Control control, Side side) {
			location.toY = new Anchor(control, side);
			return this;
		}
		/**
		 * Set the incoming (at destination) direction. Then continue with the target canvas.
		 * Make sure that both to anchors are set before calling this
		 */
		public To incomingDirection(Side incomingDirection) {
			location.incomingDirection = incomingDirection;
			assert location.toX != null;
			assert location.toY != null;
			return new To(location);
		}
	}



	public static FromControl from(Control from) {
		return init(from, from);
	}

	public static FromControl from(Control fromX, Control fromY) {
		return init(fromX, fromY);
	}
	
	private static FromControl init(Control fromX, Control fromY) {
		var location = new ArrowLocationContext();
		location.fromX = new Anchor(fromX, null);
		location.fromY = new Anchor(fromY, null);
		return new FromControl(location);
	}
	
	public static class FromControl {
		private final ArrowLocationContext location;

		FromControl(ArrowLocationContext location) {
			this.location = location;
		}

		public From south() {
			return set(Side.SOUTH);
		}

		public From east() {
			return set(Side.EAST);
		}

		public From north() {
			return set(Side.NORTH);
		}

		public From west() {
			return set(Side.WEST);
		}
		
		private From set(Side side) {
			location.fromX.side = side;
			location.fromY.side = side;
			location.outgoingDirection = side;
			return new From(location);
		}
	}

	public static class From {
		private final ArrowLocationContext location;

		public From(ArrowLocationContext location) {
			this.location = location;
		}

		public ToControl to(Control to) {
			return init(to, to);
		}

		public ToControl to(Control toX, Control toY) {
			return init(toX, toY);
		}
		
		private ToControl init(Control toX, Control toY) {
			this.location.toX = new Anchor(toX, null);
			this.location.toY = new Anchor(toY, null);
			return new ToControl(location);
		}
	}

	public static class ToControl {
		private final ArrowLocationContext location;

		ToControl(ArrowLocationContext location) {
			this.location = location;
		}

		public To south() {
			return set(Side.SOUTH);
		}

		public To east() {
			return set(Side.EAST);
		}

		public To north() {
			return set(Side.NORTH);
		}

		public To west() {
			return set(Side.WEST);
		}
		
		private To set(Side side) {
			location.toX.side = side;
			location.toY.side = side;
			location.incomingDirection = side;
			return new To(location);
		}
	}

	public static class To {
		private final ArrowLocationContext location;

		public To(ArrowLocationContext location) {
			this.location = location;
		}

		PropertiesBuilder on(CompositeWithArrowSupport canvas) {
			return new PropertiesBuilder(location, canvas);
		}
	}

	public static class PropertiesBuilder {
		final Anchor fromX;
		final Anchor fromY;
		final Anchor toX;
		final Anchor toY;
		final Side outgoingSide;
		final Side incomingSide;
		final CompositeWithArrowSupport canvas;

		private int lineWidth = ViewConstants.ARROW_THICKNESS;
		private int headWidth = ViewConstants.ARROW_HEAD_THICKNESS;
		private int headSize = ViewConstants.ARROW_HEAD_SIZE;
		private String id = null;
		private BiFunction<Point, Point, Integer> cornerLocationSupplier = CORNER_AT_MIDDLE;

		public PropertiesBuilder(ArrowLocationContext location, CompositeWithArrowSupport canvas) {
			this.fromX = location.fromX;
			this.fromY = location.fromY;
			this.outgoingSide = location.outgoingDirection;
			this.toX = location.toX;
			this.toY = location.toY;
			this.incomingSide = location.incomingDirection;
			this.canvas = canvas;
		}

		public PropertiesBuilder lineWidth(int lineWidth) {
			this.lineWidth = lineWidth;
			return this;
		}

		public PropertiesBuilder headWidth(int headWidth) {
			this.headWidth = headWidth;
			return this;
		}

		public PropertiesBuilder headSize(int headSize) {
			this.headSize = headSize;
			return this;
		}
		
		
		public PropertiesBuilder arrowId(String id) {
			this.id = id;
			return this;
		}

		public CornerLocationBuilder breakBetween() {
			return new CornerLocationBuilder(this);
		}
		
		Arrow withDefaults() {
			// Override defaults and create
			lineWidth(ViewConstants.ARROW_THICKNESS);
			headWidth(ViewConstants.ARROW_HEAD_THICKNESS);
			headSize(ViewConstants.ARROW_HEAD_SIZE);
			arrowId(null);
			return create();
		}

		Arrow create() {
			var arrowProps = new ArrowProperties(fromX, fromY, outgoingSide, toX, toY, incomingSide, lineWidth, headWidth,
					headSize, canvas, cornerLocationSupplier);
			return createAndRegister(arrowProps);
		}

		/** Create an arrow Object and register it for drawing */
		private Arrow createAndRegister(ArrowProperties arrowProps) {
			var arrow = id == null ? new Arrow(arrowProps, true) : new Arrow(arrowProps, true, id);
			arrowProps.canvas.addArrow(arrow);
			return arrow;
		}
	}
	
	public static class Anchor {
		Control control;
		Side side;
		
		public Anchor(Control control, Side side) {
			this.control = control;
			this.side = side;
		}
		
		public Point resolve(CompositeWithArrowSupport canvas) {
		return new Point(side.getX(control, canvas), side.getY(control, canvas));
	}
	}
	
	private static class ArrowLocationContext {
		Anchor fromX;
		Anchor fromY;
		Side outgoingDirection;
		Anchor toX;
		Anchor toY;
		Side incomingDirection;
	}
	
	private static class HorizontalBetweenProvider implements BiFunction<Point, Point, Integer> {
		
		private final Anchor from;
		private final Anchor to;
		private final CompositeWithArrowSupport canvas;
		private final double split;
		
		public HorizontalBetweenProvider(Anchor from, Anchor to, CompositeWithArrowSupport canvas, double split) {
			this.from = from;
			this.to = to;
			this.canvas = canvas;
			this.split  = split;
			
			assert Double.compare(split, 0.0) >= 0 && Double.compare(split, 1.0) <= 0;
		}

		@Override
		public Integer apply(Point arg0, Point arg1) {
			var cornerOffset = resolveCornerX();
			if (!isBetween(arg0, cornerOffset, arg1)) {
				throw new IllegalArgumentException("The given corner location is outside the arrow location");
			}
			return cornerOffset;
		}
		
		private int resolveCornerX() {
			Point resolvedFrom = from.resolve(canvas);
			Point resolvedTo = to.resolve(canvas);
			return (int) Math.round((resolvedTo.x - resolvedFrom.x) * split);
		}
		
		private boolean isBetween(Point from, int offset, Point to) {
			int x = from.x + offset;
			return x >= from.x && x <= to.x;
		}
	}
	
	public static class CornerLocationBuilder {
		
		public static final double CENTER = 0.5;
		
		private final PropertiesBuilder parentBuilder;
		private Anchor from;
		private Anchor to;
		
		private CornerLocationBuilder(PropertiesBuilder parentBuilder) {
			this.parentBuilder = parentBuilder;
		}
		
		public CornerLocationBuilder first(Control control, Side side) {
			this.from = new Anchor(control, side);
			return this;
		}
		public CornerLocationBuilder second(Control control, Side side) {
			this.to = new Anchor(control, side);
			return this;
		}
		
		public PropertiesBuilder at(double split) {
			 parentBuilder.cornerLocationSupplier = new HorizontalBetweenProvider(from, to, parentBuilder.canvas, split);
			 return parentBuilder;
		}
	}

}
