
package paintprogram;

import java.awt.geom.Line2D;


public class Move 
{
    public void press(int x1,int y1,int x2,int y2)
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
                 break;
            
           }
           }
   }
   public void drag(int x1,int y1)
   {
        if (Draw.shapes.get(Draw.indexR) instanceof Line) 
        {
               Line l1 = (Line) Draw.shapes.get(Draw.indexR);
              
                if (l1.getX1() < l1.getX2() && l1.getY1() < l1.getY2()) 
                {
                    LineFactory lf=new LineFactory();
                    Line l = (Line)lf.createShape(l1.getColor(), x1, y1, x1+Math.abs(l1.getX2() - l1.getX1()), y1+Math.abs(l1.getY2() - l1.getY1()));
                    Draw.shapes.set(Draw.indexR,l);
                } 
                else if (l1.getX1()>l1.getX2() && l1.getY1() > l1.getY2()) 
                {
                     LineFactory lf=new LineFactory();
                    Line l = (Line)lf.createShape(l1.getColor(), x1, y1, x1-Math.abs(l1.getX2() - l1.getX1()), y1-Math.abs(l1.getY2() - l1.getY1()));
                    Draw.shapes.set(Draw.indexR,l);
                }
                else if (l1.getX2() > l1.getX1() && l1.getY1() > l1.getY2()) 
                {
                      LineFactory lf=new LineFactory();
                      Line l = (Line)lf.createShape(l1.getColor(), x1, y1, x1+Math.abs(l1.getX2() - l1.getX1()), y1-Math.abs(l1.getY2() - l1.getY1()));
                      Draw.shapes.set(Draw.indexR,l);
                }
                else if (l1.getX1() > l1.getX2() && l1.getY2() > l1.getY1()) 
                {
                     LineFactory lf=new LineFactory();
                    Line l = (Line)lf.createShape(l1.getColor(), x1, y1, x1-Math.abs(l1.getX2() - l1.getX1()), y1+Math.abs(l1.getY2() - l1.getY1()));
                    Draw.shapes.set(Draw.indexR,l);
                }
            }
          else if (Draw.shapes.get(Draw.indexR) instanceof Rectangle) 
          {
                
             Rectangle r1 = (Rectangle) Draw.shapes.get(Draw.indexR);
             QuadFactory lf=new QuadFactory();
             Rectangle r =(Rectangle)  lf.createShape(r1.getColor(), x1, y1, x1+(r1.getX2() - r1.getX1()), y1+(r1.getY2() - r1.getY1()));
             Draw.shapes.set(Draw.indexR,r);
            
            
            }
          else if (Draw.shapes.get(Draw.indexR) instanceof Circle) 
          {
                Circle r1 = (Circle) Draw.shapes.get(Draw.indexR);
                CircleFactory lf=new CircleFactory();
                Circle r =  (Circle)lf.createShape(r1.getColor(), x1, y1, x1+Math.abs(r1.getX2() - r1.getX1()), y1+Math.abs(r1.getX2() - r1.getX1()));
                Draw.shapes.set(Draw.indexR,r);
              
            }
          else if (Draw.shapes.get(Draw.indexR) instanceof Square) 
          {
                Square r1 = (Square) Draw.shapes.get(Draw.indexR);
                QuadFactory lf=new QuadFactory();
                Square r =  (Square) lf.createShape(r1.getColor(), x1, y1, x1+(r1.getX2() - r1.getX1()), y1+(r1.getX2() - r1.getX1()));
                Draw.shapes.set(Draw.indexR,r);
                
                
            }
          else if (Draw.shapes.get(Draw.indexR) instanceof Triangle) 
          {
                Triangle r1 = (Triangle) Draw.shapes.get(Draw.indexR);
                TriFactory lf=new TriFactory();
                lf.setX3(x1+(Math.abs(r1.getX1() - r1.getX3())));
                lf.setY3(y1+Math.abs(r1.getY1() - r1.getY2()));
                Triangle t =  (Triangle)lf.createShape(r1.getColor(), x1, y1, x1-(Math.abs(r1.getX1() - r1.getX3())), y1+Math.abs(r1.getY1() - r1.getY2()));
                Draw.shapes.set(Draw.indexR,t); 
                
           }

        }
}
