package project;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinningWindow extends JFrame{
	public WinningWindow() {
		setTitle("University Conquest");
		setAlwaysOnTop(true);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		
		String winPlayer ="";
		/*if(Driver.getGameState().getPlayer().getSchoolNumber()==6){
			winPlayer=Driver.getGameState().getPlayer().getName();
		}*/
		JLabel lblNewLabel = new JLabel(winPlayer+" has conquered the university! "+winPlayer+" has won the game!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 65, 414, 74);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("University Conquest");
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setBounds(106, 11, 205, 59);
		getContentPane().add(label);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(167, 169, 89, 23);
		getContentPane().add(btnExit);
		
		
	}
}
