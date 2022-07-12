////create circle
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Circle extends JPanel
{
   private int diameter = 25; // set a default diameter

   @Override
   public void paintComponent(Graphics graph)
   {
      super.paintComponent(graph);
      graph.fillOval(25, 25, diameter, diameter);
   }

   public void setDiameter(int circleDia)
   {
      // defaults diamater to 25 if invalid
      diameter = (circleDia >= 0 ? circleDia : 25);
      repaint();
   }

   // determine preferred size
   public Dimension getPreferredSize()
   {
      return new Dimension(300, 300);
   }

	// determine minimum size
   public Dimension getMinimumSize()
   {
      return getPreferredSize();
   }

}
