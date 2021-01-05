package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import webserver.Config;

public class ConfigTest {

	@Test
	public void testConstructor1() {
		Config c = new Config();
		assertTrue(c.getUnavailablePorts().contains(220));
	}
	
	@Test
	public void testConstructor2() {
		Config c = new Config();
		assertFalse(c.getUnavailablePorts().contains(2200));
	}
	
	@Test
	public void testGetPortNumber() {
		Config c = new Config();
		assertEquals(10008,c.getPortNumber());
	}
	
	@Test(expected = InvalidPortNumberException.class)
	public void testSetUnavailablePort() throws InvalidPortNumberException{
		Config c = new Config();
		c.setPortNumber(5);
	}
	
	@Test(expected = InvalidPortNumberException.class)
	public void testSetNegativePort() throws InvalidPortNumberException{
		Config c = new Config();
		c.setPortNumber(-1);
	}
	
	@Test(expected = InvalidPortNumberException.class)
	public void testSetHigherPort() throws InvalidPortNumberException{
		Config c = new Config();
		c.setPortNumber(70000);
	}
	
	@Test
	public void testSetCorrectPort() throws InvalidPortNumberException{
		Config c = new Config();
		c.setPortNumber(8080);
		assertEquals(8080,c.getPortNumber());
	}
	
	@Test(expected = InvalidPathException.class)
	public void testSetNullPath() throws InvalidPathException {
		Config c = new Config();
		c.setDefaultPath(null);
	}
	
	@Test(expected = InvalidPathException.class)
	public void testSetEmptyPath() throws InvalidPathException {
		Config c = new Config();
		c.setDefaultPath("");
	}
	
	@Test
	public void testSetCorrectPath() throws InvalidPathException {
		Config c = new Config();
		c.setDefaultPath("C:\\Users\\flavi\\OneDrive\\Desktop\\");
		assertEquals("C:\\Users\\flavi\\OneDrive\\Desktop\\", Config.DEFAULT_PATH);
	}

}
