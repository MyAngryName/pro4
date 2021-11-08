package org.jcryptool.visual.signalencryption.ui;

/**
 * Holds various config constants for the Double Ratchet tab.
 */
public class SignalEncryptionViewDoubleRatchetConstants {

    /**
     * Estimated height of the algorithm composite.
     * 
     * <p>
     * <b>Note:</b> this is not used as minimum height, but as hint. A minimum
     * height can only be used when grabbing excess space, which we do not do. So in
     * edge cases it may actually be larger.
     */
    public static final int ALGORITHM_HEIGHT = 400;

    /**
     * This is the width hint of the algorithm boxes, a major part of the plugin's
     * flow elements.
     */
    public static final int BOX_WIDTH = 150;

    /**
     * This is the height hint of the algorithm boxes, a major part of the plugin's
     * flow elements.
     */
    public static final int BOX_HEIGHT = 60;

    /**
     * Default value of the SWT horizontal spacing.
     * 
     * We sometimes have to specify this manually, because we set the default to 0,
     * so that some arrows connect nicely to their neighbours.
     */
    public static final int HORIZONTAL_SPACING = 5;

    /**
     * The height hint of arrows which go either up or down
     */
    public static final int UP_DOWN_ARROW_SIZE = 60;
    /**
     * The default canvas width hint of all arrows
     */
    public static final int ARROW_CANVAS_WIDTH = 75;

    /**
     * Arrow line thickness
     */
    public static final int ARROW_THICKNESS = 6;

    /**
     * The thickness or the "broadness" of the arrow tip
     */
    public static final int ARROW_HEAD_THICKNESS = 12;

    /**
     * Arrow head size from base to the tip.
     */
    public static final float ARROW_HEAD_SIZE = 12;

    /**
     * Distance between tip of the arrow head and the border of the canvas
     */
    public static final float TARGET_MARGIN = 2;

    /**
     * Problematic variable used in the offset calculation for the connection
     * arrows.
     * 
     * <p>
     * The connection arrows are the big ones which have two corners and connect the
     * major components. One of them actually is drawn on two different canvases,
     * which have to be aligned. The problem is: one of the elements is in a Group,
     * the other on a Composite. And the Group has a header, for which we do not
     * know how big it is. I think we cannot programmatically access its height,
     * which is a little bit unfortunate.
     * 
     * <p>
     * The connection arrows are the big ones which have two corners and connect the
     * This value may accidentally cover other size factors as well (which it
     * shouldn't), so it should be replaced by something more robust if possible.
     */
    public static final int UNKNOWN_GROUP_HEIGHT_DEFAULT = 13;
    
    /**
     * See {@link UNKNOWN_GROUP_HEIGHT_DEFAULT}
     */
    public static final int UNKNOWN_GROUP_HEIGHT_LINUX = 17;

    /**
     * See {@link UNKNOWN_GROUP_HEIGHT_DEFAULT}
     */
    public static final int UNKNOWN_GROUP_HEIGHT_WINDOWS = 13;
}
