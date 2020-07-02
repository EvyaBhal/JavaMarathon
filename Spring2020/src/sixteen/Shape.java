package sixteen;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Shape (color, type(rect or oval), point and size)
 *
 */
public class Shape {

    public static Color[] colors = { Color.red, Color.blue, Color.black, Color.yellow };

    public final static int MIN_SHAPE_SIZE = 30;

    public enum ShapeType {
        OVAL, RECTANGLE
    };

    Color color;
    ShapeType type;
    Point p;
    Dimension d;

    public Shape(Color color, ShapeType type, Point p, Dimension d) {
        super();
        this.color = color;
        this.type = type;
        this.p = p;
        this.d = d;
    }

    /**
     * Create a shape with random type, random color, random position, and random
     * size.
     *
     * @param maxDimShape
     *            - the maximum size of the randomized shape.
     */
    public Shape(Dimension maxDimShape) {
        initShape(maxDimShape);
    }

    private void initShape(Dimension maxDimShape) {
        Point pointShape = choosePosition(maxDimShape);
        Dimension dimShape = chooseDimension(pointShape, maxDimShape);
        initShape(pointShape, dimShape);
    }

    /**
     * Create a shape with random type and random color. The position and the
     * size of the shape equal to the parameters' values.
     *
     * @param pointShape
     * @param dimShape
     *
     */
    public Shape(Point pointShape, Dimension dimShape) {
        initShape(pointShape, dimShape);
    }

    private void initShape(Point pointShape, Dimension dimShape) {
        color = chooseColor();
        type = ShapeType.values()[randInt(2)];
        this.p = (Point) pointShape.clone();
        this.d = (Dimension) dimShape.clone();
    }

    public void draw(Graphics g) {
        g.setColor(color);
        switch (type) {
            case RECTANGLE:
                g.fillRect(p.x, p.y, d.width, d.height);
                break;
            case OVAL:
                g.fillOval(p.x, p.y, d.width, d.height);
                break;
        }
    }

    public boolean isPointInShape(Point point) {
        return ((point.x >= p.x) && (point.x < p.x + d.width) && (point.y >= p.y) && (point.y < p.y + d.height));
    }

    private static Color chooseColor() {
        return (colors[randInt(colors.length)]);
    }

    private Dimension chooseDimension(Point p, Dimension panelDim) {
        int w = Math.max(randInt((int) panelDim.getWidth() - p.x), MIN_SHAPE_SIZE);
        int h = Math.max(randInt((int) panelDim.getHeight() - p.y), MIN_SHAPE_SIZE);

        return (new Dimension(w, h));
    }

    private Point choosePosition(Dimension panelDim) {
        int x = randInt((int) panelDim.getWidth() - MIN_SHAPE_SIZE);
        int y = randInt((int) panelDim.getHeight() - MIN_SHAPE_SIZE);

        return (new Point(x, y));
    }

    private static int randInt(int range) throws IllegalArgumentException {
        if (range < 0)
            throw new IllegalArgumentException("negative range " + range);
        return ((int) (((double) range) * Math.random()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Shape other = (Shape) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (type != other.type)
            return false;
        return true;
    }


}
