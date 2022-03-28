
package paintprogram;

import java.awt.Color;




public abstract class ShapeFactory 
{
     public abstract Shape createShape(Color color, int x1, int y1, int x2, int y2);
}
