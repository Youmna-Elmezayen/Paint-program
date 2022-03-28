
package paintprogram;

import java.awt.Color;


public class LineFactory extends ShapeFactory
{
    public Shape createShape(Color color, int x1, int y1, int x2, int y2)
    {
         return new Line(color, x1, y1,x2, y2);    
    }
}
