package project;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferWindow extends JFrame {
	
	private JLabel _lblDepartment;
	private Department _department;
	private int _studentNumber;
	private JComboBox _numberBox, _dptBox;
	private HashSet<Department> dptList;
	private ArrayList<String> dptNameList;
	private String[] dptNameArray;
	private String[] dptNumberArray;
	private int numberOfStudent;
	private ArrayList<String> numberList;
	private Player _turnPlayer;
	private GameState _gameState;
	ArrayList<Department> arrList;
	
	public TransferWindow() {
		
		setAlwaysOnTop(true);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setSize(395, 236);
		
		JLabel lblTransfer = new JLabel("Transfer");
		lblTransfer.setForeground(Color.RED);
		lblTransfer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTransfer.setBounds(24, 21, 85, 35);
		getContentPane().add(lblTransfer);
		
		JLabel lblStudents = new JLabel("Students");
		lblStudents.setForeground(Color.BLACK);
		lblStudents.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStudents.setBounds(285, 22, 94, 32);
		getContentPane().add(lblStudents);
		
		
		
		JLabel lblFrom = new JLabel("From :");
		lblFrom.setForeground(Color.RED);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFrom.setBounds(24, 67, 85, 25);
		getContentPane().add(lblFrom);
		
		_lblDepartment = new JLabel();
		_lblDepartment.setForeground(Color.BLUE);
		_lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		_lblDepartment.setBounds(143, 69, 167, 23);
		getContentPane().add(_lblDepartment);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setForeground(Color.RED);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTo.setBounds(24, 117, 76, 27);
		getContentPane().add(lblTo);
		
			//ComboBox
		
				//The first box	
					//Creation
		_dptBox= new JComboBox();
		_dptBox.setBounds(110, 120, 144, 28);
		getContentPane().add(_dptBox);
					
					//Set model
		_gameState = Driver.getGameState();
		_turnPlayer = _gameState.getTurnPlayer();
		setCurrentDepartment(Driver.getGameState().getSelectedDepartment());
		dptList = _department.getNeighbor();
		dptNameList = new ArrayList<String>();
		transferDptToName();
		
		DefaultComboBoxModel dptModel = new DefaultComboBoxModel(dptNameArray);
		_dptBox.setModel(dptModel);
		DefaultListCellRenderer dlcr1 = new DefaultListCellRenderer();
		dlcr1.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		_dptBox.setRenderer(dlcr1);
		
		
		
		
		
		
		
				//The second box
					//Creation
		_numberBox = new JComboBox();
		_numberBox.setBounds(169, 29, 85, 27);
		getContentPane().add(_numberBox);
					//set model
		numberOfStudent = _department.getPlayerStudentNumber(_turnPlayer);  //get studentnumber
		ArrayList<String> studentNumber = new ArrayList<String>();
		if(_turnPlayer.isChairOf(_department)){
			if(numberOfStudent>1){
				for(int i=1;i<numberOfStudent;i++){
					studentNumber.add(Integer.toString(i));
				}	
			}
		}else{
			for(int i=1;i<=numberOfStudent;i++){
				studentNumber.add(Integer.toString(i));
			}
		}
		
		dptNumberArray = studentNumber.toArray(new String[studentNumber.size()]);
		DefaultComboBoxModel numberModel = new DefaultComboBoxModel(dptNumberArray);
		_numberBox.setModel(numberModel);
		DefaultListCellRenderer dlcr2 = new DefaultListCellRenderer();
		dlcr2.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		_numberBox.setRenderer(dlcr2);
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
				//OK Button
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Action performance////////////////////////////////////
					
					//Set Transfer Functions
				Department d = arrList.get(_dptBox.getSelectedIndex());
				int studentNumber =(int) _numberBox.getSelectedIndex()+1;
				Driver.getGameBoard().transferStudents(_department,d,studentNumber);
				
					//To Next Step
				Driver.getGameState().toNextStep();
				Driver.getGameBoard().setElectionButttonInvisible(true);
				Driver.getGameBoard().setCheckButttonInvisible(true);
				Driver.getGameBoard().setStep(_gameState.getStepString());
				dispose();
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOk.setBounds(135, 168, 102, 25);
		getContentPane().add(btnOk);
		
				
	}
	
	private void transferDptToName(){
		for(int i=0;i<dptList.size();i++){
			arrList= new ArrayList<Department>(dptList);

			String name = arrList.get(i).getName();
			dptNameList.add(name);
		}
		dptNameArray = dptNameList.toArray(new String[dptNameList.size()]);
	}
	
	public void setCurrentDepartment(Department d){
		_department = d;
	}
	public void setDepartmentName(String s){
		_lblDepartment.setText(s);
	}

	public void setStudentNumber(int studentNumber) {
		_studentNumber = studentNumber;
		
	}
}
