
package paintprogram;

import java.awt.Color;


public class TriFactory 
{
    private int x3,y3;

    public int getX3() 
    {
        return x3;
    }

    public void setX3(int x3) 
    {
        this.x3 = x3;
    }

    public int getY3() 
    {
        return y3;
    }

    public void setY3(int y3) 
    {
        this.y3 = y3;
    }
    public Shape createShape(Color color, int x1, int y1, int x2, int y2)
    {
        
        if(Draw.figures == 5)
        {
              return new Triangle(color, x1, y1, x2, y2, x3, y3);
        }  
         if(Draw.index!=0)
         {   
            if(Draw.shapes.get(Draw.index) instanceof Triangle)
            return new Triangle(color, x1, y1, x2, y2, x3, y3);
         }
        if(Draw.indexR!=0)
       {
        if(Draw.shapes.get(Draw.indexR) instanceof Triangle)
        return new Triangle(color, x1, y1, x2, y2, x3, y3);
       }
        
        return null;
    }
}
