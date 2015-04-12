package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import project.Player;
import project.School;

public class SchoolTests {
	public SchoolTests(){}
	
	@Test
	public void testGetDean(){
		School s =  new School();
		Player p = new Player();
		p.setName("mike");
		s.appointDean(p);
		String expected = "mike";
		String actual = s.getDean().getName();
		assertTrue("Expected: "+expected+"Actual: "+actual, expected==actual);
	}
	
	@Test
	public void testGetName(){
		School s = new School();
		s.setName("mike");
		String expected = "mike";
		String actual = s.getName();
		assertTrue("Expected: "+expected+"Actual: "+actual, expected==actual);
	}

}
