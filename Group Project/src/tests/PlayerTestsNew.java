/**
 * This class contains a suite of tests to test certain methods that are inside the Player class.
 * These tests include this class's ability to set and get it's own name, its ability to get and assign a
 * color to the player, its ability to properly keep count of the player's unassigned students, and its
 * ability to assign its unassigned students to a desired department.
 */

package tests;

import java.awt.Color;

import org.junit.Test;

import project.Player;
import static org.junit.Assert.assertTrue;

public class PlayerTestsNew {
	public PlayerTestsNew(){}
	
	/**
	 * This method tests this class's ability to set and get its assigned Player name
	 * @author mjmcguir, norbertl
	 */
	@Test
	public void testSetAndGetName(){
		Player p = new Player();
		p.setName("Mike");
		String expected = "Mike";
		String actual = p.getName();
		assertTrue("Expected: "+expected+"Actual: "+actual, expected==actual);
	}
	
	/** @Test
	public void testIsChairOf(){
		Player p = new Player();
		boolean actual = p.isChairOf(p.shuffleChair());
		boolean expected = true;
		assertTrue("Expected: " +expected+ "Actual: " +actual, expected==actual);
	}**/
	
	/**
	 * A method to test the functionality of the getColor() method in the Player class
	 * @author mjmcguir, norbertl
	 */
	@Test
	public void testGetColor(){
		Player p = new Player();
		int playerNum = 3;
		java.awt.Color actual = p.getColor(playerNum);
		java.awt.Color expected = Color.PINK;
		assertTrue("Expected: " +expected+ "Actual: " +actual, expected==actual);
	}
	
	/**
	 * A method to test the getUnassignedStudent() method. This also requires correct execution of the
	 * getStudent() method in the Player class because a player must get players before he/she assigns them
	 * @author mjmcguir, norbertl
	 */
	@Test
	public void testGetUnassignedStudent(){
		Player p = new Player();
		p.getStudent(5);
		int expected = 8;
		int actual = p.getUnassignedStudent();
		assertTrue("Expected: " +expected+ "Actual: " +actual, expected==actual);
	}
	
	/**
	 * Following very closely to the above method, this method tests the assignStudent() method. This also
	 * requires correct functionality from both the getStudent() method and the getUnassignedStudent() method
	 * because we need to receive students, assign them, and then test if they were properly assigned by 
	 * making sure that the number of unassigned students decreased by the number of students assigned before
	 * hand.
	 * @author mjmcguir, norbertl
	 */
	@Test
	public void testAssignStudent01(){
		Player p = new Player();
		p.getStudent(5);
		p.assignStudent(2,"Chemistry");
		int expected = 6;
		int actual = p.getUnassignedStudent();
		assertTrue("Expected: " +expected+ "Actual: " +actual, expected==actual);
	}

}
