package project;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

/**
 * This class stores information and current states of the game
 */
public class GameState {
	
	private int _numberOfPlayers;
	private ArrayList<Player> _playerList;
	private String[] _playerNameList;
	private Color _color;
	private ArrayList<Color> _colorList;
	private ArrayList<String> _stringColorList;
	private ArrayList<Department> _departmentList;
	private HashMap<String,Color> _colorMap;
	private int _turn;
	private School _sciences, _arts,_medicine,_humanities,_engineering,_law;
	private ArrayList<School> _schoolList;
	private HashMap<String,School> _schoolMap;
	private HashMap<String,Department> _departmentMap;
	private ArrayList<Button> _buttonList;
	private GameBoard _gameBoard;
	private GameState _gameState;
	private ArrayList<String> _stepList;
	private int _step;
	private Department d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19,d20,d21,d22,d23,d24;
	private Department _selectedDepartment;
	private int _numberOfNewStudents;
//***************************************** Constructor ***********************************************************************
	/**
	 * Constructor that initializes the collections that store current information. Also adds colors to
	 * a HashMap which will store them to be converted to String at a later point
	 * @author xingidta
	 */
	
	public GameState(){
		
			//Initializations
		_step=1;
				//SchoolList
		_schoolList = new ArrayList<School>();
				//GameBoard
		_gameBoard = Driver.getGameBoard();
				//_stepList
		_stepList = new ArrayList<String>(); _stepList.add("Put Students"); _stepList.add("Transfer Students");_stepList.add("Election");
				//_playerList
		_playerList = new ArrayList<Player>();

						//_Get the number of players
		_numberOfPlayers=Driver.getNumberOfPlayers();
				//_Co\\lorList
		_colorList = new ArrayList<Color>();
				//Departments.
		_departmentMap = new HashMap<String,Department>();
				//Schools.
		_schoolMap = new HashMap<String,School>();
		createSchools();
				

		
		_stringColorList = new ArrayList<String>();
			
			//Create an HashMap that stores colors for converting String to Color.
		_colorMap = new HashMap<String,Color>();
		_colorMap.put("DARK_GRAY", Color.DARK_GRAY);_colorMap.put("CYAN", Color.CYAN);
		_colorMap.put("GRAY", Color.GRAY);_colorMap.put("PINK", Color.PINK);
		_colorMap.put("RED", Color.RED);_colorMap.put("ORANGE", Color.ORANGE);
		_colorMap.put("YELLOW", Color.YELLOW);_colorMap.put("GREEN", Color.GREEN);
		_colorMap.put("BLUE", Color.BLUE);_colorMap.put("WHITE", Color.WHITE);
		_colorMap.put("MAGENTA", Color.MAGENTA);_colorMap.put("LIGHT_GRAY", Color.LIGHT_GRAY);
		_colorMap.put("Color(178,200,217)", new Color(178,200,217));_colorMap.put("Color(230,165,164)", new Color(230,165,164));
		_colorMap.put("Color(250,225,107)", new Color(250,225,107));_colorMap.put("Color(130,177,106)", new Color(130,177,106));
		_colorMap.put("Color(216,64,0)", new Color(216,64,0));_colorMap.put("Color(179,0,35)", new Color(179,0,35));
		_colorMap.put("Color(247,179,87)", new Color(247,179,87));_colorMap.put("Color(67,76,67)", new Color(67,76,67));
		
		_playerNameList = Driver.getPlayerNameList();
		_turn = 1;
	}
	

//***************************************** Private Methods *******************************************************************	
	private void createSchools() {
		_buttonList = new ArrayList<Button>();
		_departmentList = new ArrayList<Department>();
		ArrayList<String> name = new ArrayList<String>();
		name.add("Sciences");name.add("Arts");name.add("Medicine");
		name.add("Humanities");name.add("Engineeringts");name.add("Law");
		for(int ii=0; ii<6;ii++){
			int i=ii;
			String n =name.get(ii);
			School s = new School();
			s.setName(n);


					//Add Department.
				 d1 = new Department("Biology"); d2=new Department("Chemistry"); d3=new Department("Mathmetics");
				 d4=new Department("Physics"); d5 = new Department("Music"); d6=new Department("Dance");
				 d7=new Department("Theatre"); d8=new Department("Visual Arts"); d9 = new Department("Anesthesia");
				 d10=new Department("Otolaryngology"); d11=new Department("Pediatrics"); d12=new Department("Pathology");
				 d13 = new Department("Religion"); d14=new Department("Linguistics"); d15=new Department("Literature");
				 d16=new Department("History"); d17 = new Department("Electrical");  d18=new Department("Mechanical");
				 d19=new Department("Computer"); d20=new Department("Civil"); d21 = new Department("Business");
				 d22=new Department("Criminal"); d23=new Department("Immigration"); d24=new Department("Family");
				
				if(i==0){
					 d1.setButton(_gameBoard.getButton(0));_gameBoard.getButton(0).setDepartment(d1);
					 _departmentMap.put("Biology", d1); _buttonList.add(_gameBoard.getButton(0));
					 _departmentList.add(d1);
					d2.setButton(_gameBoard.getButton(1));_gameBoard.getButton(1).setDepartment(d2);d2.addNeighbor(d9);
					_departmentMap.put("Chemistry", d2);_buttonList.add(_gameBoard.getButton(1));
					_departmentList.add(d2);
					d3.setButton(_gameBoard.getButton(2));_gameBoard.getButton(2).setDepartment(d3);d3.addNeighbor(d13);
					_departmentMap.put("Mathmetics", d3);_buttonList.add(_gameBoard.getButton(2));
					_departmentList.add(d3);
					d4.setButton(_gameBoard.getButton(3));_gameBoard.getButton(3).setDepartment(d4);d4.addNeighbor(d5);
					_departmentMap.put("Physics", d4);_buttonList.add(_gameBoard.getButton(3));
					_departmentList.add(d4);
				
					s.addDepartment(d1);s.addDepartment(d2);
					s.addDepartment(d3);s.addDepartment(d4);
				}
				if(i==1){
					 d5.setButton(_gameBoard.getButton(4));_gameBoard.getButton(4).setDepartment(d5);d5.addNeighbor(d4);
					 _departmentMap.put("Music", d5);_buttonList.add(_gameBoard.getButton(4));
					 _departmentList.add(d5);
					d6.setButton(_gameBoard.getButton(5));_gameBoard.getButton(5).setDepartment(d6);
					_departmentMap.put("Dance", d6);_buttonList.add(_gameBoard.getButton(5));
					_departmentList.add(d6);
					d7.setButton(_gameBoard.getButton(6));_gameBoard.getButton(6).setDepartment(d7);
					_departmentMap.put("Theatre", d7);_buttonList.add(_gameBoard.getButton(6));
					_departmentList.add(d7);
					d8.setButton(_gameBoard.getButton(7));_gameBoard.getButton(7).setDepartment(d8);d8.addNeighbor(d18);
					_departmentMap.put("Visual Arts", d8);_buttonList.add(_gameBoard.getButton(7));
					_departmentList.add(d8);
				
					s.addDepartment(d5);s.addDepartment(d6);
					s.addDepartment(d7);s.addDepartment(d8);
				}
				if(i==2){
					 d9.setButton(_gameBoard.getButton(8));_gameBoard.getButton(8).setDepartment(d9);d9.addNeighbor(d2);
					 _departmentMap.put("Anesthesia", d9);_buttonList.add(_gameBoard.getButton(8));
					 _departmentList.add(d9);
					d10.setButton(_gameBoard.getButton(9));_gameBoard.getButton(9).setDepartment(d10);
					_departmentMap.put("Otolaryngology", d10);_buttonList.add(_gameBoard.getButton(9));
					_departmentList.add(d10);
					d11.setButton(_gameBoard.getButton(10));_gameBoard.getButton(10).setDepartment(d11);
					_departmentMap.put("Pediatrics", d11);_buttonList.add(_gameBoard.getButton(10));
					_departmentList.add(d11);
					d12.setButton(_gameBoard.getButton(11));_gameBoard.getButton(11).setDepartment(d12);d12.addNeighbor(d22);
					_departmentMap.put("Pathology", d12);_buttonList.add(_gameBoard.getButton(11));
					_departmentList.add(d12);
				
					s.addDepartment(d9);s.addDepartment(d10);
					s.addDepartment(d11);s.addDepartment(d12);
				}
				if(i==3){
					 d13.setButton(_gameBoard.getButton(12));_gameBoard.getButton(12).setDepartment(d13);d13.addNeighbor(d3);
					 _departmentMap.put("Religion", d13);_buttonList.add(_gameBoard.getButton(12));
					 _departmentList.add(d13);
					d14.setButton(_gameBoard.getButton(13));_gameBoard.getButton(13).setDepartment(d14);d14.addNeighbor(d19);
					_departmentMap.put("Linguistics", d14);_buttonList.add(_gameBoard.getButton(13));
					_departmentList.add(d14);
					d15.setButton(_gameBoard.getButton(14));_gameBoard.getButton(14).setDepartment(d15);
					_departmentMap.put("Literature", d15);_buttonList.add(_gameBoard.getButton(14));
					_departmentList.add(d15);
					d16.setButton(_gameBoard.getButton(15));_gameBoard.getButton(15).setDepartment(d16);
					_departmentMap.put("History", d16);_buttonList.add(_gameBoard.getButton(15));
					_departmentList.add(d16);
				
					s.addDepartment(d13);s.addDepartment(d14);
					s.addDepartment(d15);s.addDepartment(d16);
					
					
					
					
				}
				if(i==4){
					d17.setButton(_gameBoard.getButton(16));_gameBoard.getButton(16).setDepartment(d17);
					_departmentMap.put("Electrical", d17);_buttonList.add(_gameBoard.getButton(16));
					_departmentList.add(d17);
					d18.setButton(_gameBoard.getButton(17));_gameBoard.getButton(17).setDepartment(d18);d18.addNeighbor(d8);
					_departmentMap.put("Mechanical", d18);_buttonList.add(_gameBoard.getButton(17));
					_departmentList.add(d18);
					d19.setButton(_gameBoard.getButton(18));_gameBoard.getButton(18).setDepartment(d19);d19.addNeighbor(d14);
					_departmentMap.put("Computer", d19);_buttonList.add(_gameBoard.getButton(18));
					_departmentList.add(d19);
					d20.setButton(_gameBoard.getButton(19));_gameBoard.getButton(19).setDepartment(d20);d20.addNeighbor(d21);
					_departmentMap.put("Civil", d20);_buttonList.add(_gameBoard.getButton(19));
					_departmentList.add(d20);
				
					s.addDepartment(d17);s.addDepartment(d18);
					s.addDepartment(d19);s.addDepartment(d20);
				}
				if(i==5){
					d21.setButton(_gameBoard.getButton(20));_gameBoard.getButton(20).setDepartment(d21);d21.addNeighbor(d20);
					_departmentMap.put("Business", d21);_buttonList.add(_gameBoard.getButton(20));
					_departmentList.add(d21);
					d22.setButton(_gameBoard.getButton(21));_gameBoard.getButton(21).setDepartment(d22);d22.addNeighbor(d12);
					_departmentMap.put("Criminal", d22);_buttonList.add(_gameBoard.getButton(21));
					_departmentList.add(d22);
					d23.setButton(_gameBoard.getButton(22));_gameBoard.getButton(22).setDepartment(d23);
					_departmentMap.put("Immigration", d23);_buttonList.add(_gameBoard.getButton(22));
					_departmentList.add(d23);
					d24.setButton(_gameBoard.getButton(23));_gameBoard.getButton(23).setDepartment(d24);
					_departmentMap.put("Family", d24);_buttonList.add(_gameBoard.getButton(23));
					_departmentList.add(d24);
				
					s.addDepartment(d21);s.addDepartment(d22);
					s.addDepartment(d23);s.addDepartment(d24);
				}
			

			
			_schoolMap.put(n, s);
			s.setName(n);
			_schoolList.add(s);
		}
		
	}
	
	
	private void setTurnBar() {
		_gameBoard =Driver.getGameBoard();

		_gameBoard.setTurnName(this.getTurnPlayer().getName());
		_gameBoard.setTurnStringColor(this.getTurnStringColor());
		_gameBoard.setTurnColor(this.getTurnPlayer().getColor());
		
		_gameBoard.setTurnStudentNumber(this.getTurnPlayer().getUnassignedStudent());
		_gameBoard.setTurnDepartmentNumber(this.getTurnPlayer().getDepartmentNumber());
		_gameBoard.setTurnSchoolNumber(this.getTurnPlayer().getSchoolNumber());
		


	}
	
	
	
	
//***************************************** Public Methods ********************************************************************
	
	




	/**
	 * Create Players and add them into ArrayList _playerList.
	 * @author Xingdi Tan
	 */
	public void createPlayer(){
		for(int i=0;i<_numberOfPlayers;i++){
				//Create new players and add them into ArrayList.
			_playerList.add(new Player());
				//put players into playerColorMap.
			_playerList.get(i).setColor(_colorList.get(i));
				//set name
			_playerList.get(i).setName(_playerNameList[i]);
		}
		
	}
	
	

	
	
	
	
	/**
	 * give a color to a player that stored in ArrayList
	 * @param i determine which player.
	 * @param playerColor player's color
	 * @author xingdita
	 */
	public void giveColor(String playerColor) {
		_stringColorList.add(playerColor);
		_color = _colorMap.get(playerColor);
		_colorList.add(_color);
		
	}
	
	/**
	 * Tells whose turn it is.
	 * @return The name of that player.
	 * @author xingdita
	 */
	public String getTurnName() {
		
		return _playerList.get(_turn-1).getName();
		
	}



	/**
	 * The game goes to the next turn.
	 * @author xingdita
	 */
	public void toNextTurn(){
		_turn = _turn+1;
		setTurnBar();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * The game goes to the next round.
	 * @author xingdita
	 */
	public void toNextRound(){
		_turn = 1;
		setTurnBar();
	
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 * @return the name of the that player's color
	 * @author xingdita
	 */
	public String getTurnStringColor() {
		
		return _stringColorList.get(_turn-1);
		
	}


	/**
	 * 
	 * @return that player's color
	 * @author xingdita
	 */
	public Color getTurnColor() {
		
		return _playerList.get(_turn-1).getColor();
	}
	
	/**
	 * get whose turn it is
	 * @return
	 * @author xingdita
	 */
	public Player getTurnPlayer(){
		return _playerList.get(_turn-1);
	}
	
	/**
	 * get what the step is for player
	 * @return int what step player is on
	 */
	public int getStepInteger(){
		return _step;
	}
	
	/**
	 * Set the string for the set
	 * @return String what the step for player is
	 * @author xingdita
	 */
	public String getStepString(){
		return _stepList.get(_step-1);
	}
	
	public void toNextStep(){
		_step = _step + 1;
	}
	public void toFirstStep(){
		_step = 1;
	}


	public int getTurn() {
	
		return _turn;
	}


	public int getNumberOfPlayers() {
	
		return _numberOfPlayers;
	}
	
	public ArrayList<Player> getPlayerList(){
		return _playerList;
	}
	
	public Player getPlayer(){
		return _playerList.get(_turn-1);
	}


	public HashMap<String, Department> getDepartmentMap() {
		
		return _departmentMap;
	}
	
	public ArrayList<Button> getButtonList(){
		return _buttonList;
	}


	public ArrayList<Department> getDepartmentList() {
		return _departmentList;
	}

	public int getNumberOfNewStudents(){
		_numberOfNewStudents = this.getTurnPlayer().getDepartmentNumber()*3+this.getTurnPlayer().getSchoolNumber()*18;
		
		return _numberOfNewStudents;
	}
	
	public void setSelectedDepartment(Department d){
		_selectedDepartment = d;
	}
	
	public Department getSelectedDepartment(){
		return _selectedDepartment;
	}
	
	/**
	 * The method that check there is a winnner or not;
	 * if there is the game is over.
	 */
	/*
	public void checkWinner(){
		if(
		_schoolList.get(0).getDean() == _schoolList.get(1).getDean()&&
		_schoolList.get(0).getDean() == _schoolList.get(2).getDean()&&
		_schoolList.get(0).getDean() == _schoolList.get(3).getDean()){
			new WinningWindow();
		}
	}*/
}
