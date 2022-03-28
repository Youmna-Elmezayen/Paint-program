
package paintprogram;

import java.awt.Color;


public class Square extends Shape
{
    int x2, y2;
    public Square()
    {
        super(null, 0, 0);
        this.x2 = 0;
        this.y2 = 0;
    }
    public Square(Color color, int x1, int y1, int x2, int y2) 
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

        java.awt.Rectangle r = new java.awt.Rectangle(super.getX1(), super.getY1(), Math.abs(super.getX1() - this.x2),Math.abs(this.y2 - super.getY1()));
        if (r.contains(x, y)) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
}
