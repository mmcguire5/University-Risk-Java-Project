/**
 * This class contains a suite of tests to test the functionality of the Department class.
 * It tests the functionality of the Department's methods which set and/or determine the Department's name,
 * its chair, the assignment of neighbors, and the execution of the adjacency rules.
 */

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import project.Department;
import project.Player;

public class DepartmentTestsNew {
	
	public DepartmentTestsNew(){}
	
	/**
	 * This method tests the functionality of the getName() method. It also tests the functionality of
	 * the Department constructor as it requires the constructor to assign the correct name to the
	 * Department
	 * @author mjmcguir, xingdita
	 */
	@Test
	public void testGetName(){
		Department dept = new Department ("Mike");
		String expected = "Mike";
		String actual = dept.getName();
		assertTrue("Expected: "+expected+"Actual: "+actual, expected==actual);
	}
	
	/**
	 * Method to test the functionality of the setChair() and getChair() methods.
	 * This also requires the proper execution of the setName() method in the Player class as the setChair()
	 * method in Department depends on information received, indirectly, from the setName() method in Player.
	 * @author mjmcguir, xingdita
	 */
	@Test
	public void testSetAndGetChair(){
		Department dept = new Department ("Mike");
		Player player = new Player();
		player.setName("Mike");
		dept.setChair(player);
		String expected = "Mike";
		String actual = dept.getChair().getName();
		assertTrue("Expected: "+expected+"Actual: "+actual, expected==actual);
	}
	
	/**
	 * This method tests the functionality of the addNeighbor() and canMoveTo() methods which are required
	 * to enforce the adjacency specifications
	 * @author mjmcguir, xingdita
	 */
	@Test
	public void testNeighborFunctionality(){
		Department dept =new Department("mike");
		Department dept2 = new Department("mike");
		dept.addNeighbor(dept2);
		boolean expected = true;
		boolean actual = dept.canMoveTo(dept2);
		assertTrue("Expected: "+expected+"Actual: "+actual, expected==actual);
	}
	
	
}