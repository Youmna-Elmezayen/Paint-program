
package paintprogram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape
{ 
    int x2, y2;
    public Line()
    {
        super(null, 0, 0);
        this.x2 = x2;
        this.y2 = y2;
    }
    public Line(Color color, int x1, int y1, int x2, int y2) 
    {
        super(color, x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX2() 
    {
        return x2;
    }

    public void setX2(int x2) 
    {
        this.x2 = x2;
    }

    public int getY2() 
    {
        return y2;
    }

    public void setY2(int y2) 
    {
        this.y2 = y2;
    }
    
    public boolean contains(int x, int y) 
    {
        
        Point firstPoint= new Point(getX1(),getY1());
        Point secondPoint= new Point(getX2(),getY2());
        Point point =new Point(x,y);
         return (distance(firstPoint, point) + distance(secondPoint, point) == distance(firstPoint, secondPoint));
    }
    double distance(Point a, Point b) 
    {
        return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
    }
}
