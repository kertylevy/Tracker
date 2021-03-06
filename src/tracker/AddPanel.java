package tracker;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This object is a panel for creating and adding new defects to the system.
 */

/**
 * @author Erin Harris
 */

public class AddPanel extends JPanel {

	JLabel title = new JLabel("NEW DEFECT DATA ENTRY");
	JLabel submitter = new JLabel("Submitter");
	JComboBox subSelect = new JComboBox();
	JLabel assignee = new JLabel("Assignee");
	JComboBox assignSelect = new JComboBox();
	JLabel date = new JLabel("Date Detected");// Add a format, mask with / /
	JTextField dateEnter = new JTextField(10);
	JLabel summary = new JLabel("Enter a brief summary describing the defect");
	JTextField summaryEntry = new JTextField(255);
	JLabel status = new JLabel("Defect Status");
	JTextField statusEntry = new JTextField(25);
	JLabel description = new JLabel("Enter a detail description of the defect");
	JTextField descEntry = new JTextField(2500);
	JLabel priority = new JLabel("Enter a priority level");
	JTextField priorityEntry = new JTextField(2);
	JLabel comments = new JLabel("Comments");
	JTextField commentsEntry = new JTextField(2500);

	JButton submit = new JButton("Submit");
	JButton clear = new JButton("Clear");
	JButton back = new JButton("Back");

	UserDAO userDAO = new UserDAO(); // need to access UserDAO to get submitter
										// and assignee lists

	public AddPanel(TrackerPane tracker) {

		ButtonListener AP = new ButtonListener();
		submit.addActionListener(AP);
		clear.addActionListener(AP);
		//back.addActionListener(AP);

		setLayout(new BorderLayout());

		title.setFont(new Font("Arial", Font.PLAIN, 16));
		add(title, BorderLayout.NORTH);

		//******I think you want to make one grid that is (8, 2)******
		JPanel buttonLabels = new JPanel(new GridLayout(2, 0));
		JPanel textBoxes = new JPanel(new GridLayout(2, 0));

		buttonLabels.add(submitter);
		buttonLabels.add(assignee);
		buttonLabels.add(date);
		textBoxes.add(dateEnter);
		buttonLabels.add(summary);
		textBoxes.add(summaryEntry);
		buttonLabels.add(status);
		textBoxes.add(statusEntry);
		buttonLabels.add(description);
		textBoxes.add(descEntry);
		buttonLabels.add(priority);
		textBoxes.add(priorityEntry);
		buttonLabels.add(comments);
		textBoxes.add(commentsEntry);

		add(buttonLabels, BorderLayout.WEST);// labels on top of text box
		add(textBoxes, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		buttonPanel.add(submit);
		// buttonPanel.add(clear);
		//buttonPanel.add(back);

		add(buttonPanel, BorderLayout.SOUTH);// put buttons at the bottom of
												// panel

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent AP) {

			if (AP.getSource() == submit) {

				Toolkit tempSubmitter = subSelect.getToolkit();// get from combo
																// box
				Toolkit tempAssignee = assignSelect.getToolkit();
				String tempDate = dateEnter.getText();
				String tempSummary = summaryEntry.getText();
				String tempDescription = descEntry.getText();
				int tempPriority = Integer.parseInt(priorityEntry.getText());
				String tempComments = commentsEntry.getText();

				//*****Commented out this section just until we create these, so it will run.
				
				// Don't know if ListDefect is class name yet. Will change if
				// needed. *** We need to create this! ***
				//ListDefect d = new ListDefect(tempSubmitter, tempAssignee, tempDate, tempSummary, tempDescription,
				//		tempPriority, tempComments);
				//DefectDAO.insertNewDefect(d);// Don't know if DefectDAO is class
												// name. Will change if needed.  Must create!

				subSelect.setToolTipText("");
				assignSelect.setToolTipText("");
				dateEnter.setText("");
				summaryEntry.setText("");
				descEntry.setText("");
				priorityEntry.setText("");
				commentsEntry.setText("");

				System.out.println("Defect Submitted");
			}
			//Don't need a "back" -  will just change tab.
		}
	}
}
