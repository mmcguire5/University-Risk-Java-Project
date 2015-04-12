package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;


/**
 * Driver of the game.
 * Create the window(JFrame) of the Game.
 */
public class Driver {
	
	private static PlayersSetUpPopUpWindow _popupwindow;
	private static GameState _gameState;
	private static int _numberOfPlayers;
	private static String[] _playerList;
	private static GameBoard _gameBoard;
	

//************************************ Main Method *******************************************************************
	 /**
	  * Main method that specifies what happens when the game begins
	  * @param args the Strings which represent the names of the players
	  * @author xingdita, mjmcguir, norbertl
	  */
	public static void main(String[] args) {
		
				
				//Test args
			System.out.println("args.length is "+args.length);
			for (int i=0; i<args.length; i++) {
				System.out.println("args["+i+"] is \""+args[i]+"\"");
			}
			_playerList = args;
			
				//Get the number of players.
			_numberOfPlayers = args.length;
		
			JFrame window;
			window = new JFrame ("College Conquest - by Team j");
			window.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
			_gameBoard = new GameBoard();
			window.getContentPane().add(_gameBoard);
			window.pack();
			window.setVisible(true);
			window.setSize(1280,900);
			//window.setExtendedState(JFrame.MAXIMIZED_BOTH);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//MENU BAR
			JMenuBar menuBar = new JMenuBar();
			JMenu fileMenu = new JMenu("Menu");
			fileMenu.setMnemonic(KeyEvent.VK_F);
		    menuBar.add(fileMenu);
		    JMenuItem menuItem_Exit = new JMenuItem("Exit");
		    //ActionListener of MenuItems
		    menuItem_Exit.addActionListener(new ActionListener(){
		    	@Override
		    	public void actionPerformed(ActionEvent e){
		    		System.exit(0);
		    	}
		    });
		    
		    JMenuItem mntmPlay = new JMenuItem("Play");
		    mntmPlay.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		_popupwindow =new PlayersSetUpPopUpWindow();
		    			//Set GameState
		    		_gameState = new GameState();
		    			//Set button next visible.
		    		_gameBoard.setNextButtonVisible(true);
		    	}
		    });
		    fileMenu.add(mntmPlay);
		    fileMenu.add(menuItem_Exit);
		    window.setJMenuBar(menuBar);
		    _gameBoard.getWindow(_popupwindow);
		    
		    
		}
	
//*********************************** Public Methods *****************************************************************
	
	/**
	 * Method that sets the current game state
	 * @return the current GameState
	 * @author xingdita
	 */
	public static GameState getGameState(){
		return _gameState;
	}
	
	/**
	 * Method that gets the Game Board
	 * @return the GameBoard
	 * @author xingdita
	 */
	public static GameBoard getGameBoard(){
		return _gameBoard;
	}
	
	/**
	 * Method that gets the number of players so it can be displayed on the game board
	 * @return the number of players as an int
	 * @auther xingdita, mjmcguir
	 */
	public static int getNumberOfPlayers(){
		return _numberOfPlayers;
	}
	
	/**
	 * Method that gets the names of the players to display on the board
	 * @return the list of the players as a String[]
	 * @author xingdita, mjmcguir
	 */
	public static String[] getPlayerNameList(){
		return _playerList;
	}
	
	/**
	 * Method that individually fetches a player's name
	 * @param i and int that represents the index of the player who's name is being pulled
	 * @return the name of the player as a String
	 * @author xingdita, mjmcguir
	 */
	public static String getPlayerName(int i){
		
		return _playerList[i];
	}
	
}


