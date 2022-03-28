
package paintprogram;

import java.util.ArrayList;


public class Do 
{
    static ArrayList<Shape> s = new ArrayList<Shape>();
    public void undo(paintprogram.Draw draw1)
    {

        if(Draw.shapes.size() >= 1)
        {
            int size = Draw.shapes.size();
            s.add(Draw.shapes.get(size - 1));
         draw1.remove(Draw.shapes.remove(size-1));
        }
    }  
    public void Redo(paintprogram.Draw draw1)
    {
         if(s.size() >= 1)
        {
            draw1.add(s.get(s.size() - 1));
            Draw.shapes.add(s.get(s.size() - 1));
            s.remove(s.get(s.size() - 1));
        }
    } 
}
