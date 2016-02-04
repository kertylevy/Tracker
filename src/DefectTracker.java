import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Kristin Clark
 *
 */
public class DefectTracker extends JFrame {
	
	
	/**
	 * @param args
	 */

	private static final int FRAME_WIDTH = 1900;
	private static final int FRAME_HEIGHT = 1000;
	private static final int TOP_BORDER = 50;
	private static Dimension dimension = new Dimension(FRAME_WIDTH, FRAME_HEIGHT-TOP_BORDER);
	private static JFrame frame = new JFrame("The Tracker");
	

	
	public static void main(String[] args) {

		//Set up the frame
		frame.setSize(dimension);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Create an opaque panel
		JPanel content = new JPanel();
		content.setOpaque(true);
		content.setPreferredSize(dimension);
		
		//Make the panel the content pane and add the tracker to it.
		frame.setContentPane(content);
		content.add(new TrackerPane(content), BorderLayout.CENTER);
		frame.setVisible(true);	
		
	}//end main
	
	}// end DefectTracker
