
package paintprogram;

import java.awt.geom.Line2D;


public class Resize 
{
     public void press(int x1,int y1,int x2, int y2)
     {
         for (int i = 0; i < Draw.shapes.size(); i++) 
         {
               if (Draw.shapes.get(i) instanceof Line) 
               {
                    Line l = (Line) Draw.shapes.get(i);
                    Line2D lin = new Line2D.Double(l.getX1(), l.getY1(), l.getX2(), l.getY2());
                    if(lin.intersectsLine(x1, y1, x2, y2))
                    {
                    Draw.indexR=i;
                    break;
                    }
               }
               else if(Draw.shapes.get(i).contains(x1, y1))
               {
                 Draw.indexR=i;
                 System.out.println(Draw.shapes.get(i).getX1());
                 break;
                }
           }
    }
     
     
     public void drag(int x2,int y2,int x3, int y3)
     {
        if (Draw.shapes.get(Draw.indexR) instanceof Line) 
        {
               Line l1 = (Line) Draw.shapes.get(Draw.indexR);
                LineFactory lf=new LineFactory();
               Line l = (Line)lf.createShape(l1.getColor(), l1.getX1(),l1.getY1(), x2, y2);
              Draw.shapes.set(Draw.indexR,l);
        }
        else if (Draw.shapes.get(Draw.indexR) instanceof Rectangle) 
        {
                
             Rectangle r1 = (Rectangle) Draw.shapes.get(Draw.indexR);
             QuadFactory lf=new QuadFactory();
             Rectangle r =(Rectangle)  lf.createShape(r1.getColor(), r1.getX1(), r1.getY1(),x2, y2);
             Draw.shapes.set(Draw.indexR,r);
            
        }
        else if (Draw.shapes.get(Draw.indexR) instanceof Circle) 
        {
               
                Circle r = (Circle) Draw.shapes.get(Draw.indexR);
               if(Math.abs(x2 - r.getX1())==Math.abs(y2 - r.getY1())){
                r.setX2(x2);
                r.setY2(y2);
                Draw.shapes.set(Draw.indexR,r);
               }
        }
               else if (Draw.shapes.get(Draw.indexR) instanceof Square) 
               {
                Square r1 = (Square) Draw.shapes.get(Draw.indexR);
                if(Math.abs(x2 - r1.getX1())==Math.abs(y2 - r1.getY1()))
                {
                r1.setX2(x2);
                r1.setY2(y2);
                Draw.shapes.set(Draw.indexR,r1);
                }  
                }
               else if (Draw.shapes.get(Draw.indexR) instanceof Triangle) 
               {
                
                 Triangle r1 = (Triangle) Draw.shapes.get(Draw.indexR);
                
                    if(r1.getX1()<x3)
                        x2=x3-2*(x3-r1.getX1());
                    else if(r1.getX1()>x3)
                    {
                        x2=x3+2*(r1.getX1()-x3);
                    }
               TriFactory lf=new TriFactory();
                lf.setX3(x3);
                lf.setY3(y2);
                Triangle t =  (Triangle)lf.createShape(r1.getColor(), r1.getX1(), r1.getY1(), x2, y2);
                Draw.shapes.set(Draw.indexR,t);
            
            } 
                
           }
}
 

