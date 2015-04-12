/** 
 * This class is meant to represent each player of the game.
 * It allows a player to do what the game says one can do.
 * Several methods in this class will be called when a player of the game wishes to execute some
 * specific task.
 */

package project;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    
	private String _name;//Name of the player
	private Color  _color;//Color assigned to this player for the board
	private int  _numberOfSchools;//Number of schools that this player is dean of
	private ArrayList<Department> _departmentList; //Collection of depts that the player has student in.
	private ArrayList<School> _schoolList;
	
	private Department originalChair;//The random chair that this Player is assigned to at beginning of game
    //private Department de;
    private Department music, theatre, dance, visualArts, biology, physics, chemistry, mathematics, history, linguistics, 
    		religion, literature, computer, electrical, mechanical, civil, business, family, criminal, immigration, anesthesia, otolaryngology, pathology, pediatrics;//Department objects
    private int chairCount;//Number of chairs this player holds
    private int studentCount = 0;//Number of students loyal to this player
    private int unassignedStudents = 2;//Number of students that this player has received but has not assigned to a Department yet
    private HashMap<String,Integer> studentMap;//Collection of how many students this player has in each department
    private java.util.ArrayList<Department> depts;//Array of departments to be shuffled for beginning of game


    
    /**
     * This is the constructor method. It has no arguments. This method sets the player's name (user input),
     * sets a count of departments that the player chairs, gives each player a random chair at the start
     * of the game (as specified), and sets up a HashMap that specifies how many students are in which
     * department (most likely moving this part of the method to a different class)
     * @param n a String which represents the player's name
     * @author mjmcguir, xingdita, norbertl
     */
    public Player (){
    	_schoolList = new ArrayList<School>();
        _departmentList = new ArrayList<Department>();
        this.setOriginalChair();
        chairCount = 1;
       
        
        studentMap = new HashMap <String,Integer>();
        studentMap.put("Music", 0);
        studentMap.put("Theatre", 0);
        studentMap.put("Dance", 0);
        studentMap.put("Visual Arts", 0);
        studentMap.put("Biology", 0);
        studentMap.put("Physics", 0);
        studentMap.put("Chemistry", 0);
        studentMap.put("Mathematics", 0);
        studentMap.put("History", 0);
        studentMap.put("Religion", 0);
        studentMap.put("Literature", 0);
        studentMap.put("Linguistics", 0);
        studentMap.put("Computer", 0);
        studentMap.put("Electrical", 0);
        studentMap.put("Mechanical", 0);
        studentMap.put("Civil", 0);
        studentMap.put("Business", 0);
        studentMap.put("Family", 0);
        studentMap.put("Criminal", 0);
        studentMap.put("Immigration", 0);
        studentMap.put("Anesthesia", 0);
        studentMap.put("Otolaryngology", 0);
        studentMap.put("Pathology", 0);
        studentMap.put("Pediatrics", 0);
    }
    
    /**
     * This method simply shuffles an array list of departments for the purpose of assigning each player
     * a random chair at the start of the game.
     * @author mjmcguir, norbertl, xingdita    
     * @return A random Department from the array list
     */
    public Department shuffleChair(){ //Create an array of departments and shuffle in order to randomly assign
        depts = new java.util.ArrayList<Department>();//players as department chairs at beginning of game
        depts.add(music);
        depts.add(theatre);
        depts.add(dance);
        depts.add(visualArts);
        depts.add(biology);
        depts.add(physics);
        depts.add(chemistry);
        depts.add(mathematics);
        depts.add(history);
        depts.add(linguistics);
        depts.add(religion);
        depts.add(literature);
        depts.add(computer);
        depts.add(electrical);
        depts.add(mechanical);
        depts.add(civil);
        depts.add(business);
        depts.add(family);
        depts.add(criminal);
        depts.add(immigration);
        depts.add(anesthesia);
        depts.add(otolaryngology);
        depts.add(pathology);
        depts.add(pediatrics);
        
        java.util.Collections.shuffle(depts);
        
        return depts.get(0);
    }
    
    /**
     * This method takes the return from the shufleChair() method and makes the Player chair of it
     * @author mjmcguir, xingdita
     */
    public void setOriginalChair(){
        originalChair = shuffleChair();
    }
    
    /**
     * Method that allows for one player to take over a chair from another player
     * @param d of type Department that has the changing chair
     * @author mjmcguir, xingdita
     */
  /*  public void takeChair(Department d){
    	deptsChaired.add(d);
    	chairCount = chairCount +1;
    }*/
    
    /**
     * Method that allows one player to lose his chair to another player
     * @author mjmcguir, norbertl
     * @param d of type Department that has the changing chair
     */
  /*  public void leaveChair(Department d){
    	deptsChaired.remove(d);
    	chairCount = chairCount -1;
    }*/
    
    /**
     * Method that returns true if the player is chair of the specified Department
     * @param d of type Department whos chair is in question
     * @return true if player IS the chair, false is player IS NOT the chair
     * @author mjmcguir, norbertl, xingdita
     */
   /* public boolean isChairOf(Department d){
        boolean result = false;
    	for(int j=0; j<deptsChaired.size(); j++){
        	if(deptsChaired.get(j) == d){
        		result = true;
        	}
        	else{
        		result = false;
        	}
        }
    	return result;
    }*/
    
    /**
     * Method that assigns a color to each player for the game board (may be removed or moved)
     * @param playerNumber which will specifiy his/her color
     * @return the color that the player will be
     * @author mjmcguir, xingdita
     */
    public java.awt.Color getColor(int playerNumber){
        java.util.ArrayList<java.awt.Color> colorArray = new java.util.ArrayList<java.awt.Color>();
        colorArray.add(Color.DARK_GRAY);
        colorArray.add(Color.CYAN);
        colorArray.add(Color.GRAY);
        colorArray.add(Color.PINK);
        colorArray.add(Color.RED);
        colorArray.add(Color.ORANGE);
        colorArray.add(Color.YELLOW);
        colorArray.add(Color.GREEN);
        colorArray.add(Color.BLUE);
        colorArray.add(Color.WHITE);
        colorArray.add(Color.MAGENTA);
        colorArray.add(Color.LIGHT_GRAY);
        colorArray.add(new Color(178,200,217));
        colorArray.add(new Color(230,165,164));
        colorArray.add(new Color(250,225,107));
        colorArray.add(new Color(130,177,106));
        colorArray.add(new Color(216,64,0));
        colorArray.add(new Color(179,0,35));
        colorArray.add(new Color(247,179,87));
        colorArray.add(new Color(67,76,67));
        
        return colorArray.get(playerNumber);
    }
    
    /**
     * Method that sets a players number of students at the beginning of each turn (3*(number of depts chaired))
     * @author mjmcguir, norbertl
     */
    public void setNumStudents(){ //Call this method at the beginning of each turn to give each player 3 students
        studentCount = studentCount + (3*chairCount);//per dept. that they chair
        unassignedStudents = unassignedStudents + (3*chairCount);
        }
    
    /**
     * Method that allows a player to give students to another player
     * @param a the number of students to be moved
     * @param s dept that the students will go to
     * @author mjmcguir, norbertl
     */
    public void giveStudent(int a, String s){ //Possibly work on user input to how many student will be given
        studentCount = studentCount - a; //int a is the number of students to be given
        int count = studentMap.get(s); //String s is the dept that the student(s) will go to
        count = count - a;
        studentMap.put(s,count);
    }
    
    /**
     * method that allows a player to receive students from another player
     * @param a number of students received
     * @author mjmcguir, xingidta
     */
    public void getStudent(int a){ //Possibly work on user input to how many students will be received
        studentCount = studentCount + a;
        unassignedStudents = unassignedStudents + a;
    }
    
    /**
     * Allows a player to move his students from one of his departments to another of his departments
     * @param numStudents number of students displaced
     * @param deptFrom dept that the students will be coming from
     * @param deptTo dept that the students will be going to
     * @author mjmcguir, xingdita
     */
    public void transferStudent(int numStudents, String deptFrom, String deptTo){
    	if (Student.canTransfer(deptFrom, deptTo)){
    		int countFrom = studentMap.get(deptFrom);
    		countFrom = countFrom - numStudents;
    		studentMap.put(deptFrom,countFrom);
    		int countTo = studentMap.get(deptTo);
    		countTo = countTo + numStudents;
    		studentMap.put(deptTo, countTo);
    	}
    }
    
    /**
     * Method that, if there are any unassigned students, allows a player to assign his students to the
     * department that he specifies
     * @param a number of students to assign
     * @param s department that they are being assigned to
     * @author mjmcguir, xingdita
     */
    public void assignStudent(int a, String s){ //Assigns NEW students to specified department (represented by HashMap)
        if(unassignedStudents > 0){
            int pos = studentMap.get(s);
            pos = pos + a;
            studentMap.put(s,pos);
            unassignedStudents = unassignedStudents - a;
        }
    }
    
    /**
     * Method that sets the name of this player
     * @param s of type String that will be the player's name
     * @author xingdita, mjmcguir, norbertl
     */
	public void setName(String s){
		_name = s;
	}
	
	/**
	 * Method that gets the name of this player
	 * @return the name of this player as a String
	 * @author xingdita, mjmcguir, norbertl
	 */
	public String getName(){
		return _name;
	}
	
	/**
	 * Method that sets the color of this player on the game board
	 * @param c of type Color that the player will be assigned to
	 * @author xingdita, mjmcguir, norbertl
	 */
	public void setColor(Color c){
		_color =c;
	}
	
	/**
	 * Method that gets the color of the player
	 * @return the color of the player as type Color
	 * @author xingdita, mjmcguir, norbertl
	 */
	public Color getColor(){
		return _color;
	}
	
	/**
	 * Method that gets the number of students that this player has but is yet to assign to one of their depts
	 * @return the number of unassigned students as an int
	 * @author xingdita, mjmcguir, norbertl
	 */
	public int getUnassignedStudent() {
		// TODO Auto-generated method stub
		return unassignedStudents;
	}
	
	/**
	 * A method that gets the number of schools that this player is dean of
	 * @return the number of schools this school is dean of as an int
	 * @author xingdita, mjmcguir, norbertl
	 */
	public int getSchoolNumber() {
		_numberOfSchools = _schoolList.size();
		return _numberOfSchools;
	}
	
	/**
	 * Method that gets the number of depts that this player chairs
	 * @return the number of depts this player chairs as an int
	 * @author xingdita, mjmcguir, norbertl
	 */
	public int getDepartmentNumber() {
		chairCount = _departmentList.size();
		return chairCount;
	}
	/**
	 * 
	 * @param d the Department that we are looking for
	 * @return true if we have d in _departmentList; else return false.
	 * @author xingdita
	 */
	public boolean isChairOf(Department d){
		return this==d.getChair();
	}
	
	
	
	public boolean hasStudentIn(Department d){
		for(int i=0; i<_departmentList.size();i++){
			return d==_departmentList.get(i);
		}
		return false;
	}
	/**
	 * Set the player as the chair of a department
	 * @param d The department that the player is chairing.
	 * @author xingdita
	 */
	public void setDepartment(Department d){
		_departmentList.add(d);
		d.setChair(this);
	}

	public void decreaseUnsignedStudent() {
		unassignedStudents = unassignedStudents-1;
		Driver.getGameBoard().setTurnStudentNumber(unassignedStudents);
	}
	
	public void addUnsignedStudent(int i){
		unassignedStudents = unassignedStudents+i;
	}
	
	public void setSchool(School s){
		_schoolList.add(s);
	}
	
	public ArrayList<Department> getDepartmentList(){
		return _departmentList;
	}
	
	public HashMap<String,Integer> getStudentMap(){
		return studentMap;
	}
}
