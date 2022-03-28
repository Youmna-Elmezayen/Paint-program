
package paintprogram;

import java.awt.geom.Line2D;


public class Delete 
{
     public void press(int x1 ,int y1,int x2,int y2)
     {
        for (int i = 0; i < Draw.shapes.size(); i++) 
        {
               if (Draw.shapes.get(i) instanceof Line) 
               {
                Line l = (Line) Draw.shapes.get(i);
                Line2D lin = new Line2D.Double(l.getX1(), l.getY1(), l.getX2(), l.getY2());
                if(lin.intersectsLine(x1, y1, x2, y2)){
                Draw.shapes.remove(i);
                 break;
                }
                }
               else if(Draw.shapes.get(i).contains(x1, y1))
               {
                 Draw.shapes.remove(i);
                 break;
                }
           }
    }
}
