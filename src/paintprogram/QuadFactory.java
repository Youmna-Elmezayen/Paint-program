/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintprogram;

import java.awt.Color;


public class QuadFactory extends ShapeFactory
{
    public Shape createShape(Color color, int x1, int y1, int x2, int y2)
    {
        if(Draw.figures == 2)
        {
             return new Rectangle(color, x1, y1, x2, y2);
        }  
        if(Draw.figures==4)
        {
         return new Square(color, x1, y1,x2, y2);
        }
           if(Draw.index!=0)
           {
                if(Draw.shapes.get(Draw.index) instanceof Rectangle)
                    return new Rectangle(color, x1, y1,x2, y2);
                else if(Draw.shapes.get(Draw.index) instanceof Square)
                    return new Square(color, x1, y1,x2, y2);
           }
                    if(Draw.indexR!=0)
                    {
                    if(Draw.shapes.get(Draw.indexR) instanceof Rectangle)
                    return new Rectangle(color, x1, y1,x2, y2); 
                    else if(Draw.shapes.get(Draw.indexR) instanceof Square)
                    return new Square(color, x1, y1,x2, y2);
                    }
        
        return null;
        
     }
}


