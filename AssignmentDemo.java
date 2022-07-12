import javax.swing.JFrame;

public class AssignmentDemo extends JFrame
{
   public AssignmentDemo()
   		{
			getContentPane().add(new CircleSlider());

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ensures program doesn't run in background when finished
			setSize(650, 650); // width and height set
      		setVisible(true); // ensures frame window is shown/visible
		}

	public static void main(String[] args)
		{
			new AssignmentDemo();
		}
}