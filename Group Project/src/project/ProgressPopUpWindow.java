package project;

import javax.swing.*;

import java.awt.Color;
//import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is a set of pop-up window.
 * @author Xingdi Tan
 *
 */
public class ProgressPopUpWindow extends JFrame {
	
	private JFrame _window;
	private GameState _gameState;
	private GameBoard _gameBoard;
	private ArrayList<Department> _departmentList;
	private ArrayList<Department> takenDpt;
	
		//Constructor
	public ProgressPopUpWindow(){
		setAlwaysOnTop(true);
		setResizable(false);
		setVisible(true);
		getContentPane().setLayout(null);
		setSize(310,134);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("The Game Has Started!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 304, 48);
		getContentPane().add(lblNewLabel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnOk.setBounds(104, 56, 86, 37);
		getContentPane().add(btnOk);
			
	
		
			//JButton ActionListener
		btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					_gameState.createPlayer();
					_gameBoard = Driver.getGameBoard();
					_gameBoard.setStep(_gameState.getStepString());
					takenDpt = new ArrayList<Department>();
			///////////////////////////////////////////////////////////////////////////////
					for(int i=0;i<24;i++){
						Department d = Driver.getGameState().getDepartmentList().get(i);
						d.createPlayerStudentNumberMap();
					}
			///////////////////////////////////////////////////////////////////////////////
					assignDepartmentRandomly();
					
					setTurnBar();
					
					Driver.getGameBoard().setMiniMap();
					dispose();
					
			}
		});
		
	
			
			//Get the GameState object.
		_gameState = Driver.getGameState();
	}
	/**
	 * Assign 3 departments randomly to each player.
	 * @author xingdita
	 */
	private void assignDepartmentRandomly(){
		ArrayList<Player> playerList = Driver.getGameState().getPlayerList();
		_departmentList = Driver.getGameState().getDepartmentList();
		for(int i=0;i<playerList.size();i++){
			
			Department d = shuffleDepartment(); /*shuffled department*/
			Player p = playerList.get(i);
			p.setDepartment(d);
			d.addStudentToButton(1);
			d.addStudentThatBelongsTo(p, 1);
		}
	}
	
	/**
	 * 
	 * @return Department that randomly assigned to the player
	 * @author xingdita
	 */
	private Department shuffleDepartment(){
		
		Department d = _departmentList.get((int)(Math.random()*24));
		while(takenDpt.contains(d)){
			d =  _departmentList.get((int)(Math.random()*24));
			
		}
		takenDpt.add(d);
		return d;
	}
	
	
	private void setTurnBar(){
		_gameBoard = Driver.getGameBoard();
		_gameBoard.setTurnName(_gameState.getTurnPlayer().getName());
		_gameBoard.setTurnStringColor(_gameState.getTurnStringColor());
		_gameBoard.setTurnColor(_gameState.getTurnPlayer().getColor());
		
		_gameBoard.setTurnStudentNumber(_gameState.getTurnPlayer().getUnassignedStudent());
		_gameBoard.setTurnDepartmentNumber(_gameState.getTurnPlayer().getDepartmentNumber());
		_gameBoard.setTurnSchoolNumber(_gameState.getTurnPlayer().getSchoolNumber());
	}
}
