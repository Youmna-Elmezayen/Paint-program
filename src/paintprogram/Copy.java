
package paintprogram;

import java.awt.geom.Line2D;

public class Copy 
{
     public void press(int x1,int y1,int x2,int y2)
     {
           for (int i = 0; i < Draw.shapes.size(); i++) 
           {
            if (Draw.shapes.get(i) instanceof Line) {
                Line l = (Line) Draw.shapes.get(i);
                Line2D lin = new Line2D.Double(l.getX1(), l.getY1(), l.getX2(), l.getY2());
                if(lin.intersectsLine(x1, y1, x2, y2))
                {
                    Draw.shapes.add(l);
                    Draw.index=Draw.shapes.size()-1;
                    //System.out.println("sam");
                    break;}
            }
            else if(Draw.shapes.get(i).contains(x1, y1))
            {
               Shape s = Draw.shapes.get(i);

             if (s instanceof Rectangle) 
             {
                Rectangle r = (Rectangle) s;
                Draw.shapes.add(r);
                Draw.index=Draw.shapes.size()-1;
                break;
            }
             else if (s instanceof Circle) 
             {
                Circle r = (Circle) s;
                    Draw.shapes.add(r);
                 Draw.index=Draw.shapes.size()-1;
                 break;
             }
             else if (s instanceof Square) 
             {
                Square r = (Square) s;
                Draw.shapes.add(r);
                Draw.index=Draw.shapes.size()-1;
                 break;
            }
             else if (s instanceof Triangle) 
             {
                Triangle r = (Triangle) s;
                Draw.shapes.add(r);
                Draw.index=Draw.shapes.size()-1;
                break;
             }  
           }
           }
        
    }
}
