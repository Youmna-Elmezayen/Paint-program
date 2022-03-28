
package paintprogram;

import java.awt.Color;


public class CircleFactory extends ShapeFactory
{
    public Shape createShape(Color color, int x1, int y1, int x2, int y2)
    {
        return new Circle(color, x1, y1,x2, y2);
    }
}
