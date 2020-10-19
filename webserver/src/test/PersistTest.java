package test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import persist.Persist;

public class PersistTest {

	@Test 
	public void testGetPortNumber() {
		Persist persist = new Persist();
		persist.setPortNumber(12);
		assertEquals(12, persist.getPortNumber());
	}
	
	@Test 
	public void testGetRootDir() {
		Persist persist = new Persist();
		persist.setRootDir("./www_root");
		assertEquals("./www_root", persist.getRootDir());
	}
	
	@Test 
	public void testGetMaintDir() {
		Persist persist = new Persist();
		persist.setMaintDir("C:/maint");
		assertEquals("C:/maint", persist.getMaintDir());
	}
	
	@Test(expected = InvalidPortNumberException.class) 
	public void testPortNumberNegative() {
		Persist persist = new Persist();
		persist.setPortNumber(-1);
	}
	
	@Test(expected = InvalidPortNumberException.class) 
	public void testPortNumberTaken() {
		Persist persist = new Persist();
		persist.setPortNumber(1);
	}
	
	@Test(expected = InvalidPortNumberException.class) 
	public void testPortNumberHigher() {
		Persist persist = new Persist();
		persist.setPortNumber(65540);
	}
	
	@Test(expected = InvalidPathException.class)
	public void testSetRootDirInvalidCharacter() {
		Persist persist = new Persist();
		persist.setRootDir("???mama???");
	}
	
	@Test(expected = InvalidPathException.class)
	public void testSetMaintDirInvalidCharacter() {
		Persist persist = new Persist();
		persist.setMaintDir("???mama???");
	}
	
	@Test(expected = InvalidPathException.class)
	public void testSetRootDirInvalidPath() {
		Persist persist = new Persist();
		persist.setRootDir("D:///adam");
	}
	
	@Test(expected = InvalidPathException.class)
	public void testSetMaintDirInvalidPath() {
		Persist persist = new Persist();
		persist.setMaintDir("D:///adam");
	}
}
