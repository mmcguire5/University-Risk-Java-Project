/**
 * This class represents every School object that will be created throughout the University Risk Game.
 * It contains several methods that deal with naming, assigning deans, assigning departments.
 */

package project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class School {
	
	private ArrayList<Department> _departments;/**Collection of Departments that are in this school**/
	private Player _dean; /** The dean of this school **/
	private String _name; /** The name of this school**/
	
	/**
	 * No argument constructor that initializes the HashSet that will hold all department that are in this school
	 * @author mjmcguir, xingdita, norbertl
	 */
	public School(){
		_departments = new ArrayList<Department>();
	}
	
	/**
	 * Method that assigns the dean of this school
	 * @param d of type Player that will be dean of this school
	 * @author xingdita, mjmcguir
	 */
	public void appointDean(Player d) {
		_dean = d;
	}
	
	/**
	 * Method that adds departments that are in this school to the _departments collection
	 * @param d of type Department that will be added to the HashSet
	 * @author xingdita, norbertl
	 */
	public void addDepartment(Department d){
		_departments.add(d);
		d.setSchool(this);
		makeSchoolInternalConnections();
	}
	
	/**
	 * Method that makes all departments within the same school adjacent to each other
	 * @author mjmcguir, xingdita, norbertl
	 */
	private void makeSchoolInternalConnections(){
		for(Department s: _departments){
			for(Department t: _departments){
				if(s != t){
					s.addNeighbor(t);
					t.addNeighbor(s);
				}
			}
		}
	}
	
	/**
	 * Method that sets the name of this school
	 * @param n of type String that is the name of this school
	 * @author xingdita
	 */
	public void setName(String n) {
		_name = n;	
	}
	
	public String getName(){
		return _name;
	}
	
	public void setDean(Player p){
		_dean = p;
		_dean.setSchool(this);
	}
	
	public Player getDean(){
		return _dean;
	}

	public boolean checkSchoolHasDean() {
		int i = _departments.size();
		if(i==4){
			if(dptsAreTheSame()){
				return true;
			}
		}
		return false;
	}
	
	private boolean dptsAreTheSame(){
		if(_departments.get(0).getChair()==_departments.get(1).getChair()&&_departments.get(0).getChair()==_departments.get(2).getChair()&&_departments.get(0).getChair()==_departments.get(3).getChair()){
			return true;
		}
		return false;
	}
	
	public ArrayList<Department> getDpt(){
		return _departments;
	}
}
