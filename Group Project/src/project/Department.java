/**
 * This class represents every department that the game specifies. It contains several methods that deal with aspects such as names,
 * adjacent department, student transfer rules
 *
 */
package project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Department {
    
	private Player _chair;//The chair of this department
	private HashSet<Department> _neighbors;//The adjacent departments
	private String _name;//The name of this department
	private Button _button;//The button on the board assigned to this department
	private School _school;
	private ArrayList<Player> _playerList;
	private HashMap<Player,Integer> _playerStudentNumberMap;
//	private int _studentNumber;

    /**
     * Constructor method that initialized a HashSet which represents the adjacent neighbors to this Department object
     * @param s of type String is the name of this Department object
     * @author xingdita, mjmcguir
     */
	public Department(String s){
    	_neighbors = new HashSet<Department>();
    	_name = s;
    	_playerStudentNumberMap = new HashMap<Player,Integer>();
    }
    
    
//************************* Public Methods **************************************    
    
	/**
	 * Method that adds a given department to the _neighbors collection
	 * @param d of type Department that will be placed in the HashSet
	 * @author xingdita, norbertl
	 */
	public void addNeighbor(Department d){
        _neighbors.add(d);
        }
    
    /**
     * A method that decides whether a student can move from this Department to another given Department (based on given 
     * adjacency rules)
     * @param d of type Department that a student wished to transfer to
     * @return true if the student can transfer; false otherwise
     * @author norbertl, mjmcguir
     */
	public boolean canMoveTo(Department d){
    	return _neighbors.contains(d);
    }
    
	/**
	 * Method that sets a Player as chair of this department
	 * @param c the Player to be assigned chair of this dept
	 * @author xingdita, mjmcguir
	 */
    public void setChair(Player c){
    	_chair = c;
    }
    
    /**
     * Method that gets the chair of this dept
     * @return the chair of this dept as a Player object
     * @author xingdita, mjmcguir
     */
    public Player getChair(){
    	return _chair;
    }
    
    /**
     * Method that gets the name of this dept
     * @return the name of this dept as a String
     * @author mjmcguir, xingdita, norbertl
     */
    public String getName(){
    	return _name;
    }
    
    /**
     * Method that assigns this dept to a specific button on the game board
     * @param b of type Button that will be represent this dept
     * @author xingdita, mjmcguir, norbertl
     */
    public void setButton(Button b){
    	_button = b;
    }
    
    public Button getButton(){
    	return _button;
    }

    /**
	 * add students to this department.
	 * @param i the number of the students to be added.
	 * @author xingdita
	 */
	public void addStudentToButton(int i){
			_button.addStudents(i);
	}
	
	public void setSchool(School s){
		_school = s;
	}


	public School getSchool() {
		
		return _school;
	}
	
	public HashSet<Department> getNeighbor(){
		return _neighbors;
	}
    
	public int getPlayerStudentNumber(Player p){
		int studentNumber = _playerStudentNumberMap.get(p);
		return studentNumber;
	}
	
	public void addStudentThatBelongsTo(Player p,int i){
		int studentNumber=_playerStudentNumberMap.get(p)+i;
		_playerStudentNumberMap.put(p, studentNumber);		
	}
	
	public void decreaseStudentThatBelongsTo(Player p, int i){
		int studentNumber=_playerStudentNumberMap.get(p)-i;
		_playerStudentNumberMap.put(p, studentNumber);	
	}


	public int getStudentNumberOf(Player p) {
		
		return _playerStudentNumberMap.get(p);
	}
	
	public void createPlayerStudentNumberMap(){
		_playerList=Driver.getGameState().getPlayerList();
		for(int i=0;i<_playerList.size();i++){
			_playerStudentNumberMap.put(_playerList.get(i),0);
		}
	}
	
	public void decreaseChairStudent(int i){
		_button.decreaseStudents(i);
	}


	
	/**
	 * Election method.
	 * @param p the player that called the election;
	 */
	public void elect(Player p) {
		int result=0;
		Player caller = p;
		int newStudentNumber = _playerStudentNumberMap.get(p);
		int oriStudentNumber = _playerStudentNumberMap.get(this.getChair());
		//System.out.println(studentNumber);
		
			//create students and vote;
		for(int i=0;i<newStudentNumber;i++){
			Student s = new Student(p);
			if(s.vote(p)){
				result = result+1;
			}		
		}
		for(int i=0;i<oriStudentNumber;i++){
			Student s = new Student(getChair());
			if(s.vote(p)){
				result = result+1;
			}
		}
		if(result*2 > oriStudentNumber+newStudentNumber){
			_playerStudentNumberMap.put(_chair,0);
			this.setChair(p);
			p.setDepartment(this);
			_playerStudentNumberMap.put(_chair,newStudentNumber+oriStudentNumber);
			this.getButton().setStudent(newStudentNumber+oriStudentNumber);
		}else{
			this.getButton().setStudent(newStudentNumber+oriStudentNumber);
		}
		
			
	}
}
