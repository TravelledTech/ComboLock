import java.awt.event.*;
import javax.swing.*;

/* Wentao
 * April 14, 2022 
 * Creates a combo lock where you enter a specified number
 */

public class ComboLock {
	
	//All the variavles
	JList<Integer> list1 = new JList<>();
	
	JList<Integer> list2 = new JList<>();
	
	JList<Integer> list3 = new JList<>();
	
	JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JSplitPane splitPane4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	DefaultListModel<Integer> model = new DefaultListModel<>();
	JLabel label = new JLabel("", JLabel.CENTER);
	JButton button = new JButton("Enter");
	JFrame frame = new JFrame("Combo Lock");
	
	//the password
	Integer password = 182;
	
	public ComboLock() {
		list1.setModel(model);
		list2.setModel(model);
		list3.setModel(model);
		
		//sets all the numbers in the list
		for(int i = 1; i < 10; i++) {
			model.addElement(i);
		}
		
		//Detects button pressed
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//if password is correct, change text to correct
				if(list1.getSelectedValue()*100 + list2.getSelectedValue()*10 + list3.getSelectedValue() == password) {
					label.setText("Correct!");
				}
				else {
					label.setText("Try again!");
				}
			}
		});
		
		//puts everything in the split panels
		splitPane1.setLeftComponent(new JScrollPane(list1));
		splitPane1.setRightComponent(new JScrollPane(list2));
		splitPane2.setLeftComponent(splitPane1);
		splitPane2.setRightComponent(new JScrollPane(list3));
		splitPane3.setLeftComponent(splitPane2);
		splitPane3.setRightComponent(button);
		splitPane4.setTopComponent(label);
		splitPane4.setBottomComponent(splitPane3);
		
		splitPane4.setResizeWeight(1);
		
		//creates the frame
		frame.add(splitPane4);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack(); 
		frame.setSize(300, 130); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//runs
		SwingUtilities.invokeLater(ComboLock :: new);
	}
}
