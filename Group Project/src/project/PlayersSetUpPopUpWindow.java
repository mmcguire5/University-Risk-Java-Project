package project;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 *     @author Xingdi Tan
 */   
public class PlayersSetUpPopUpWindow{
	private JFrame _window;
	private int _numberOfPlayers;
	private JComboBox comboBox,comboBoxForColor;
	private JLabel lblNewLabel;
	private boolean _visible;
	private String _playerName;
	private Color _playerColor;
	private GameBoard _gameBoard;
	private GameState  _gameState;
	private ProgressPopUpWindow _progressPopUpWindow;

	/**
	 * @wbp.parser.entryPoint
	 */
	public PlayersSetUpPopUpWindow(){
			
				
			
					//Create ComboBox.
				String[] colors = new String[] {"DARK_GRAY", "CYAN", "GRAY", "PINK", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "WHITE", "MAGENTA", "LIGHT_GRAY", "Color(178,200,217)", "Color(230,165,164)", "Color(250,225,107)", "Color(130,177,106)", "Color(216,64,0)", "Color(179,0,35)", "Color(247,179,87)","Color(67,76,67)"};
				final DefaultComboBoxModel model = new DefaultComboBoxModel(colors);
				
					//for loop to let the amount of the pop-up windows equals to the number of the players.
				
				for(int i=1; i<= Driver.getNumberOfPlayers(); i=i+1){
					final int ii=i;	
						//Create Window;
					final JFrame window = new JFrame("Give Name"); 
					window.setVisible(true);
					window.setAlwaysOnTop(true);
					window.setResizable(false);
					window.setSize(305,110);
					JPanel panel = new JPanel();
					window.getContentPane().add(panel);
					window.setLocationRelativeTo(null);
					window.setMinimumSize(new Dimension(305,110));
						//Create components
					JLabel nameLabel =new JLabel("Please Choose the Color of Player"+Integer.toString(Driver.getNumberOfPlayers()+1-i)+" "+Driver.getPlayerName(Driver.getNumberOfPlayers()-i));
					panel.add(nameLabel);
						
			
						//ComboBox
					comboBoxForColor = new JComboBox();
					comboBoxForColor.setMaximumRowCount(5);
					comboBoxForColor.setModel(model);
					DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
				    dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
				    comboBoxForColor.setRenderer(dlcr);
				    panel.add(comboBoxForColor);
						//JButton
				    JButton button = new JButton("Confirm");
					panel.add(button);
							
					
					
						
					
					
							//JButton's ActionListener
					button.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
								//Get GameState from Driver.
							_gameState = Driver.getGameState();
							
								//Pass color to GameState
							_gameState.giveColor((String) comboBoxForColor.getSelectedItem());
							
								//remove selected color from string[]
							model.removeElement(comboBoxForColor.getSelectedItem());
							window.dispose();
							
							if(ii==1){
									//Player set up is over, another set of pop-up window appears.
								_progressPopUpWindow = new ProgressPopUpWindow();
							}
						}
					});
				}
				
					
				
			}
				

	
	
	
	
	
	


	
	
	
}
