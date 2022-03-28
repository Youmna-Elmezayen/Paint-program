/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintprogram;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Uzer
 */
public class Draw extends JPanel implements MouseListener, MouseMotionListener
{
    private int x1, y1, x2, y2, x3, y3;
    static ArrayList<Shape> shapes = new ArrayList<Shape>();
    Color def = Color.BLACK;
    static int figures;
    static int index, indexR;
    boolean first = false;
    public Draw()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {

       super.paintComponent(g);
       for(int i = 0; i < shapes.size(); i++)
       {
           if(shapes.get(i) instanceof Line)
           {
               Line line = (Line) shapes.get(i);
               g.setColor(line.getColor());
               g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
           }
           else if(shapes.get(i) instanceof Rectangle)
           {
               Rectangle rectangle = (Rectangle) shapes.get(i);
               g.setColor(rectangle.getColor());
               if(rectangle.getX1() < rectangle.getX2() && rectangle.getY1() < rectangle.getY2())
               {
                g.drawRect(rectangle.getX1(), rectangle.getY1(), 
                        (rectangle.getX2() - rectangle.getX1()), (rectangle.getY2() - rectangle.getY1()));
               }
               else if(rectangle.getX1() > rectangle.getX2() && rectangle.getY1() > rectangle.getY2())
               {
                g.drawRect(rectangle.getX2(), rectangle.getY2(), 
                        (rectangle.getX1() - rectangle.getX2()), (rectangle.getY1() - rectangle.getY2()));
               }
               else if(rectangle.getX1() < rectangle.getX2() && rectangle.getY1() > rectangle.getY2())
               {
                g.drawRect(rectangle.getX1(), rectangle.getY2(), 
                        (rectangle.getX2() - rectangle.getX1()), (rectangle.getY1() - rectangle.getY2()));
               }
               else if(rectangle.getX1() > rectangle.getX2() && rectangle.getY1() < rectangle.getY2())
               {
                g.drawRect(rectangle.getX2(), rectangle.getY1(), 
                        (rectangle.getX1() - rectangle.getX2()), (rectangle.getY2() - rectangle.getY1()));
               }
           }
            else if (shapes.get(i) instanceof Triangle) 
            {
                Triangle l = (Triangle) shapes.get(i);
                g.setColor(l.getColor());
                int[] xs = {l.getX1(), l.getX2(), l.getX3()};
                int[] ys = {l.getY1(), l.getY2() , l.getY3()};
                g.drawPolygon(xs, ys, 3);
            }
           else if(shapes.get(i) instanceof Square)
           {
               Square square = (Square) shapes.get(i);
               g.setColor(square.getColor());
               if(square.getX1() < square.getX2() && square.getY1() < square.getY2())
               {
                g.drawRect(square.getX1(), square.getY1(), 
                        (square.getX2() - square.getX1()), (square.getX2() - square.getX1()));
               }
               else if(square.getX1() > square.getX2() && square.getY1() > square.getY2())
               {
                g.drawRect(square.getX2(), square.getY2(), 
                        (square.getX1() - square.getX2()), (square.getX1() - square.getX2()));
               }
               else if(square.getX1() < square.getX2() && square.getY1() > square.getY2())
               {
                g.drawRect(square.getX1(), square.getY2(), 
                        (square.getX2() - square.getX1()), (square.getX2() - square.getX1()));
               }
               else if(square.getX1() > square.getX2() && square.getY1() < square.getY2())
               {
                g.drawRect(square.getX2(), square.getY1(), 
                        (square.getX1() - square.getX2()), (square.getX1() - square.getX2()));
               }
           }
           else if(shapes.get(i) instanceof Circle)
           {
               Circle circle = (Circle) shapes.get(i);
               g.setColor(circle.getColor());
               if(circle.getX1() < circle.getX2() && circle.getY1() < circle.getY2())
               {
                g.drawOval(circle.getX1(), circle.getY1(), 
                        (circle.getX2() - circle.getX1()), (circle.getX2() - circle.getX1()));
               }
               else if(circle.getX1() > circle.getX2() && circle.getY1() > circle.getY2())
               {
                g.drawOval(circle.getX2(), circle.getY2(), 
                        (circle.getX1() - circle.getX2()), (circle.getX1() - circle.getX2()));
               }
               else if(circle.getX1() < circle.getX2() && circle.getY1() > circle.getY2())
               {
                g.drawOval(circle.getX1(), circle.getY2(), 
                        (circle.getX2() - circle.getX1()), (circle.getX2() - circle.getX1()));
               }
               else if(circle.getX1() > circle.getX2() && circle.getY1() < circle.getY2())
               {
                g.drawOval(circle.getX2(), circle.getY1(), 
                        (circle.getX1() - circle.getX2()), (circle.getX1() - circle.getX2()));
               }
           }
           }
       if(figures == 7)
       {
          if (shapes.get(index) instanceof Line) 
            {
                Line l = (Line) shapes.get(index);
                g.setColor(l.getColor());
                g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
            }
            else if (shapes.get(index) instanceof Rectangle) 
            {
            Rectangle r = (Rectangle) shapes.get(index);
            g.setColor(r.getColor());
            g.drawRect(x1, y1,Math.abs(r.getX2() - r.getX1()),Math.abs(r.getY2() - r.getY1()));
            
            }
            else if (shapes.get(index) instanceof Circle) 
            {
                Circle c = (Circle) shapes.get(index);
                g.setColor(c.getColor());
                g.drawOval(x1, y1, Math.abs(c.getX2() - c.getX1()), Math.abs(c.getX2() - c.getX1()));
                
                
            }else if (shapes.get(index) instanceof Square) {
                Square r = (Square) shapes.get(index);
                g.setColor(r.getColor());
                g.drawRect(x1, y1, Math.abs(r.getX2() - r.getX1()),Math.abs(r.getX2() - r.getX1()));
               
            }
            else if (shapes.get(index) instanceof Triangle) 
            {
                Triangle r = (Triangle) shapes.get(index);
                if(r.getX1()==r.getX2())
                {
                    int z[]={x1,x1,x1+(Math.abs(r.getX1() - r.getX3()))};
                    int y []={y1 ,y1+Math.abs(r.getY1() - r.getY2()) ,y1+Math.abs(r.getY1() - r.getY2()) };
                    g.setColor(r.getColor());
                    g.drawPolygon(z,y,3);
                }
                else
                {
               int z[]={x1,x1-(Math.abs(r.getX1() - r.getX3())),x1+(Math.abs(r.getX1() - r.getX3()))};
                int y []={y1 ,y1+Math.abs(r.getY1() - r.getY2()) ,y1+Math.abs(r.getY1() - r.getY2()) };
                g.setColor(r.getColor());
                    g.drawPolygon(z,y,3);
                }  
           }
                        
        }
       if(figures == 9)
       {
            if (shapes.get(indexR) instanceof Square) 
            {
                Square r = (Square) shapes.get(indexR);
                g.setColor(r.getColor());
                
                if (r.getX1() < r.getX2() && r.getY1() < r.getY2()) 
                {
                    g.drawRect(r.getX1(), r.getY1(), r.getX2() - r.getX1(), r.getY2() - r.getY1());
                } 
                else if (r.getX1() > r.getX2() && r.getY1() > r.getY2()) 
                {
                    g.drawRect(r.getX2(), r.getY2(), Math.abs(r.getX2() - r.getX1()),Math.abs(r.getY2() - r.getY1()));

                }
                else if (r.getX2() > r.getX1() && r.getY1() > r.getY2()) 
                {
                    g.drawRect(r.getX1(), r.getY2(), Math.abs(r.getX2() - r.getX1()), Math.abs(r.getY2() - r.getY1()));

                }
                else if (r.getX1() > r.getX2() && r.getY2() > r.getY1()) 
                {
                    g.drawRect(r.getX2(), r.getY1(), Math.abs(r.getX2() - r.getX1()),Math.abs(r.getY2() - r.getY1()));

                }
            }
            else  if (shapes.get(indexR) instanceof Circle) 
            {
                Circle c = (Circle) shapes.get(indexR);
                g.setColor(c.getColor());
                if (c.getX1() < c.getX2() && c.getY1() < c.getY2()) 
                {
                   
                    g.drawOval(c.getX1(), c.getY1(), c.getX2() - c.getX1(), c.getY2() - c.getY1());
                    
                } 
                else if (c.getX1() > c.getX2() && c.getY1() > c.getY2()) 
                {
                    
                    g.drawOval(c.getX2(), c.getY2(), Math.abs(c.getX2() - c.getX1()), Math.abs(c.getY2() - c.getY1()));
                    
                }
                else if (c.getX2() > c.getX1() && c.getY1() > c.getY2()) 
                {
                    
                    g.drawOval(c.getX1(), c.getY2(), Math.abs(c.getX2() - c.getX1()), Math.abs(c.getY2() - c.getY1()));
                    
                }
                else if (c.getX1() > c.getX2() && c.getY2() > c.getY1()) 
                {
                    
                    g.drawOval(c.getX2(), c.getY1(), Math.abs(c.getX2() - c.getX1()), Math.abs(c.getY2() - c.getY1()));
                    

                }
            }
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {

    }
            
       
    
    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        if (figures == 1) 
        {
            LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(def, x1, y1, x1, y1);
            shapes.add(l);
            repaint();
        } 
        else if (figures == 2) 
        {
            QuadFactory lf=new QuadFactory();
            Rectangle r =(Rectangle)  lf.createShape(def, x1, y1, x1, y1);
            shapes.add(r);
            repaint();
        }
        else if (figures == 3) 
        {
            CircleFactory lf=new CircleFactory();
            Circle r =  (Circle)lf.createShape(def, x1, y1, x1, y1);
            shapes.add(r);
            repaint();
        }
        else if (figures == 4) 
        {
            QuadFactory lf=new QuadFactory();
            Square r =  (Square) lf.createShape(def, x1, y1, x1, y1);
            shapes.add(r);
            repaint();
        }
        else if (figures == 5) 
        {
            TriFactory lf=new TriFactory();
            lf.setX3(x1);
            lf.setY3(y1);
            Triangle t =  (Triangle)lf.createShape(def, x1, y1, x1, y1);
            shapes.add(t);
            repaint();
        }
        else if (figures == 6) 
        {
            x1=e.getX();
            y1=e.getY();
           Copy c=new Copy();
           c.press(x1, y1, x2, y2);
            repaint();
            
        } 
        else  if (figures == 7) 
        {

            repaint();
            Paste p = new Paste();
            p.press(x1, y1);
       
        }
        else if(figures == 8)
        {
             x1=e.getX();
            y1=e.getY();
           Move m=new Move();
           m.press(x1, y1, x2, y2);
          
        }
        else if(figures == 9)
        {
             x1=e.getX();
            y1=e.getY();
          Resize r=new Resize();
          r.press(x1, y1, x2, y2);
          repaint();
        }
         if(figures == 10)
         {
          x1=e.getX();
          y1=e.getY();
           Delete d=new Delete();
           d.press(x1, y1, x2, y2);
          repaint();
     }
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
       if(figures == 8)
            repaint();
       
        figures = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        if (figures == 1) 
        {
            x2 = e.getX();
            y2 = e.getY();
            Shape s = shapes.get(shapes.size() - 1);
            if (s instanceof Line) 
            {
                Line l = (Line) s;
                l.setX2(x2);
                l.setY2(y2);
            }

            repaint();
        } 
        else if (figures == 2) 
        {
            x2 = e.getX();
            y2 = e.getY();
            Shape s = shapes.get(shapes.size() - 1);
            if (s instanceof Rectangle) 
            {
                Rectangle r = (Rectangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }

            repaint();
        }
        else if (figures == 3) 
        {
            x2 = e.getX();
            y2 = e.getY();
            Shape s = shapes.get(shapes.size() - 1);
            if (s instanceof Circle) 
            {
                Circle r = (Circle) s;
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
        }
        else if (figures == 4) 
        {
            x2 = e.getX();
            y2 = e.getY();
            Shape s = shapes.get(shapes.size() - 1);
            if (s instanceof Square) 
            {
                Square r = (Square) s;
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
        }
        else if (figures == 5) 
        {
            x3=e.getX();
            y3=e.getY();
            y2=y3;
            if(x1<x3)
            {
              x2=x3-2*(x3-x1);
            Shape s = shapes.get(shapes.size() - 1);
            if (s instanceof Triangle) 
            {
                Triangle r = (Triangle) s;
                r.setX3(x3);
                r.setY3(y3);
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
           }
            else if(x1>x3)
            {
                x2=x3+2*(x1-x3);
                Shape s = shapes.get(shapes.size() - 1);
            if (s instanceof Triangle) 
            {
                Triangle r = (Triangle) s;
                r.setX3(x3);
                r.setY3(y3);
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
            }
        }
        else if (figures == 8) 
        {
            x1 = e.getX();
            y1 = e.getY();
            Move m=new Move();
            m.drag(x1, y1);
        }
        else if (figures == 9) 
        {
            x2 = e.getX();
            y2 = e.getY();
            x3=e.getX();
            y3=e.getY();
            Resize r=new Resize();
            r.drag(x2, y2, x3, y3);
            repaint();
        }
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
    
}
