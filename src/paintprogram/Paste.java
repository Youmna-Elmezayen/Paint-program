
package paintprogram;


public class Paste 
{
    public void press(int x1,int y1)
    {
        if (Draw.shapes.get(Draw.index) instanceof Line) 
        {
                Line l1 = (Line) Draw.shapes.get(Draw.index);
                if (l1.getX1() < l1.getX2() && l1.getY1() < l1.getY2()) 
                {
                     LineFactory lf=new LineFactory();
                    Line l = (Line)lf.createShape(l1.getColor(), x1, y1, x1+Math.abs(l1.getX2() - l1.getX1()), y1+Math.abs(l1.getY2() - l1.getY1()));
                  Draw.shapes.add(l);
                    Draw.shapes.remove(Draw.index);
                    Draw.figures = 0;
                } 
                else if (l1.getX1()>l1.getX2() && l1.getY1() > l1.getY2()) 
                {
                    LineFactory lf=new LineFactory();
                    Line l = (Line)lf.createShape(l1.getColor(), x1, y1, x1-Math.abs(l1.getX2() - l1.getX1()), y1-Math.abs(l1.getY2() - l1.getY1()));
                    Draw.shapes.add(l);
                    Draw.shapes.remove(Draw.index);
                    Draw.figures = 0;
                }
                else if (l1.getX2() > l1.getX1() && l1.getY1() > l1.getY2()) 
                {
                    LineFactory lf=new LineFactory();
                    Line l = (Line)lf.createShape(l1.getColor(), x1, y1, x1+Math.abs(l1.getX2() - l1.getX1()), y1-Math.abs(l1.getY2() - l1.getY1()));
                    Draw.shapes.add(l);
                    Draw.shapes.remove(Draw.index);
                    Draw.figures = 0;
                }
                else if (l1.getX1() > l1.getX2() && l1.getY2() > l1.getY1()) 
                {
                    LineFactory lf=new LineFactory();
                    Line l = (Line)lf.createShape(l1.getColor(), x1, y1, x1-Math.abs(l1.getX2() - l1.getX1()), y1+Math.abs(l1.getY2() - l1.getY1()));
                    Draw.shapes.add(l);
                    Draw.shapes.remove(Draw.index);
                    Draw.figures = 0;
                }
            }
        else if (Draw.shapes.get(Draw.index) instanceof Rectangle) 
           {
                Rectangle r1 = (Rectangle) Draw.shapes.get(Draw.index);
                QuadFactory lf=new QuadFactory();
                Rectangle r =(Rectangle)  lf.createShape(r1.getColor(), x1, y1, x1+(r1.getX2() - r1.getX1()), y1+(r1.getY2() - r1.getY1()));
                Draw.shapes.add(r);
                Draw.shapes.remove(Draw.index);
                Draw.figures = 0;
            }
        else if (Draw.shapes.get(Draw.index) instanceof Circle) 
            {
                Circle r1 = (Circle) Draw.shapes.get(Draw.index);
                CircleFactory lf=new CircleFactory();
                Circle r =  (Circle)lf.createShape(r1.getColor(), x1, y1, x1+Math.abs(r1.getX2() - r1.getX1()), y1+Math.abs(r1.getX2() - r1.getX1()));
                Draw.shapes.add(r);
                Draw.shapes.remove(Draw.index);
                Draw.figures = 0;
            }
        else if (Draw.shapes.get(Draw.index) instanceof Square) 
            {
                Square r1 = (Square) Draw.shapes.get(Draw.index);
                QuadFactory lf=new QuadFactory();
                Square r =(Square) lf.createShape(r1.getColor(), x1, y1, x1+(r1.getX2() - r1.getX1()), y1+(r1.getX2() - r1.getX1()));
                Draw.shapes.add(r);
                Draw.shapes.remove(Draw.index);
                Draw.figures = 0;
            }
        else if (Draw.shapes.get(Draw.index) instanceof Triangle) 
        {
                Triangle r1 = (Triangle) Draw.shapes.get(Draw.index);
                if(r1.getY3()>r1.getY1())
                {
                    TriFactory lf=new TriFactory();
                    lf.setX3(x1+(Math.abs(r1.getX1() - r1.getX3())));
                    lf.setY3(y1+Math.abs(r1.getY1() - r1.getY2()));
                     Triangle t = (Triangle)lf.createShape(r1.getColor(), x1, y1, x1-(Math.abs(r1.getX1() - r1.getX3())), y1+Math.abs(r1.getY1() - r1.getY2()));
                    Draw.shapes.add(t);
                    Draw.shapes.remove(Draw.index);
                    Draw.figures = 0;
                }
                else if(r1.getY1()>r1.getY3())
                {
                TriFactory lf=new TriFactory();
                lf.setX3(x1+(Math.abs(r1.getX1() - r1.getX3())));
                lf.setY3(y1-Math.abs(r1.getY1() - r1.getY2()));
                Triangle t =  (Triangle)lf.createShape(r1.getColor(), x1, y1, x1-(Math.abs(r1.getX1() - r1.getX3())), y1-Math.abs(r1.getY1() - r1.getY2()));
                Draw.shapes.add(t);
                Draw.shapes.remove(Draw.index);
                Draw.figures = 0;
                }
        
    }
         
}
}
