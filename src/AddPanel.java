import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Kristin Clark
 *
 */
public class AddPanel extends JPanel {
	
	JPanel addPanel = new JPanel();

	public AddPanel(TrackerPane tracker) {
		JButton button = new JButton("fake add");
		this.add(button);

	}

}