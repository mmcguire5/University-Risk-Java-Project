package project;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttackWindow extends JFrame {
	private JComboBox comboBox = new JComboBox();
	private ArrayList<Department> dptlist;
	public AttackWindow() {
		setSize(600,300);
		setVisible(true);
		Player attackingPlayer = Driver.getGameState().getTurnPlayer();
		HashMap<String,Integer> attackingPlayerDepartments = attackingPlayer.getStudentMap();
		dptlist = Driver.getGameState().getDepartmentList();
		ArrayList<String> nameList = new ArrayList<String>();
		for(int i=0; i<24;i++){
			String s = dptlist.get(i).getName();
			nameList.add(s);
		}
		
		String[] comboOptions = nameList.toArray(new String[nameList.size()]);
		final DefaultComboBoxModel model = new DefaultComboBoxModel(comboOptions);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select a Department which you would like to battle for");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 424, 66);
		getContentPane().add(lblNewLabel);
		
		
		comboBox.setModel(model);
		comboBox.setBounds(131, 106, 172, 34);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				Department d = dptlist.get(index);
				Player p = Driver.getGameState().getTurnPlayer();
				d.elect(p);
				Driver.getGameBoard().setMiniMap();
				dispose();
	/////////////////////////////////////////////////////////////////////
				
				//Check dean.
				if(d.getSchool().getDpt().get(0).getChair() == d.getSchool().getDpt().get(1).getChair()
				&& d.getSchool().getDpt().get(0).getChair() == d.getSchool().getDpt().get(2).getChair()
				&&	d.getSchool().getDpt().get(0).getChair() == d.getSchool().getDpt().get(3).getChair()){
				
					d.getSchool().setDean(p);
					Driver.getGameBoard().setTurnSchoolNumber(p.getSchoolNumber());
				}
				//Driver.getGameState().checkWinner();
			}
		});
		btnNewButton.setBounds(177, 194, 89, 23);
		getContentPane().add(btnNewButton);
		//Driver.getGameState().checkWinner();
	}
}