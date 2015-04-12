package project;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;

/** 
 * The JPanel,JButton and JLabel combo for each department.
 */
public class Button extends JPanel {
	
	private JButton _button; private JPanel _panel; private JLabel _label; 
	private int _studentNumber;
	private Department _department;
	private TransferWindow _transferWindow;
	private Player p;
	
	/**
	 * A JPanel holds one JButton and one JLabel. 
	 * @param Sting s is the name of the department displayed on the JButton.
	 * @param Color c is the Color of the Button; departments in the same school have the same color.
	 * @author xingdita
	 */
	public Button(String s,Color c){
			//Create GUI parts
		_button = new JButton(s);
		_panel = new JPanel();
		_studentNumber = 0;
		_label = new JLabel();
		_label.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		_label.setForeground(Color.BLACK);
		_label.setHorizontalAlignment(SwingConstants.CENTER);_label.setText(Integer.toString(_studentNumber));
			//set layout for _panel;
		GridLayout panelLayout = new GridLayout(2,1); _panel.setLayout(panelLayout);
			//set color for button;
		_button.setBackground(c);_button.setOpaque(true);_button.setBorderPainted(false);
			//Make combo
		_panel.add(_button); _panel.add(_label);
			//Add combo onto Button;
		this.add(_panel);
		
			//Give _button ActionListener
		_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Boolean b = _department.getSchool().checkSchoolHasDean();
					//ActionListener for put students
				if(Driver.getGameState().getStepInteger()==1){
					if(Driver.getGameState().getTurnPlayer().getUnassignedStudent()>0){
							//Can only put Students in Departments that they have already chaired.
						if(_department.getChair()==null){
							_department.setChair(Driver.getGameState().getTurnPlayer());
							addStudents(1);
							_department.addStudentThatBelongsTo(Driver.getGameState().getTurnPlayer(), 1);
							
								//Decrease unassigned students
							p = Driver.getGameState().getTurnPlayer();
							p.decreaseUnsignedStudent();
								//Add Department to player's _departmentList;
							p.setDepartment(_department);
							Driver.getGameBoard().setTurnDepartmentNumber(p.getDepartmentNumber());
						}
							
						else if(_department.getChair()== Driver.getGameState().getTurnPlayer()){
							_department.setChair(Driver.getGameState().getTurnPlayer());
							addStudents(1);
							_department.addStudentThatBelongsTo(Driver.getGameState().getTurnPlayer(), 1);
							
								//Decrease unassigned students
							p = Driver.getGameState().getTurnPlayer();
							p.decreaseUnsignedStudent();
						
						}
						
						
							
						
					
						
							
							//Add School to player's _departmentList;
						
							if(_department.getSchool().checkSchoolHasDean()&&b==false){
								p.setSchool(_department.getSchool());
							
								Driver.getGameBoard().setTurnSchoolNumber(p.getSchoolNumber());
							}
					
							
					}	
						//MiniMap
					Driver.getGameBoard().setMiniMap();
				}
				
				
					
				
				
					//ActionListener for transfer students.
				if(Driver.getGameState().getStepInteger()==2 /*&& Driver.getGameState().getPlayer().isChairOf(_department)*/){
					Driver.getGameState().setSelectedDepartment(_department);
					transferStudents();
					
				}
				
					//Election
				if(Driver.getGameState().getStepInteger()==3){
					
				}
			}
		}); 
	}
	
	
	
	
	
	/**
	 * A method to handle what happens when the button is clicked
	 * @author xingdita
	 * @param i 
	 */
	public void addStudents(int i){
		
		_studentNumber = _studentNumber+i;
		_label.setText(Integer.toString(_studentNumber));
		_label.setBackground(_department.getChair().getColor());_label.setOpaque(true);
		//if(_studentNumber==1){_department.setChair(Driver.getGameState().getTurnPlayer());}
	}
	
	public void decreaseStudents(int i){
		_studentNumber = _studentNumber-i;
		_label.setText(Integer.toString(_studentNumber));
	}
	
	/**
	 * The method in ActionListener when in step3(transfer students).
	 * @author xingdita
	 */
	private void transferStudents(){
		//pop up window;
		
		//comboBox -- departments
		//Neighbors
		//their own departments.
		_transferWindow = new TransferWindow();
		_transferWindow.setDepartmentName(_department.getName());
		_transferWindow.setStudentNumber(_studentNumber);
	}
	
	/**
	 * A method that assigns a department to this button
	 * @param d the Department to assigned to this button
	 * @author xingdita
	 */
	public void setDepartment(Department d) {
		_department=d;
		
	}





	public void setStudent(int i) {
		_studentNumber = i;
		_label.setText(Integer.toString(_studentNumber));
		_label.setBackground(_department.getChair().getColor());_label.setOpaque(true);
	}
	
}
