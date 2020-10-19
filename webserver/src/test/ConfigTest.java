package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import exceptions.ConfigInitException;
import persist.Config;

public class ConfigTest {

	@Test(expected = ConfigInitException.class)
	public void testGetSettingsNotInit() {
		Config conf = null;
		conf.getSettings("root");
	}
	
	@Test(expected = ConfigInitException.class)
	public void testSetSettingsNotInit() {
		Config conf = null;
		conf.setSettings("root","www_root");
	}
	
	@Test
	public void testGetSettings() {
		Config conf = new Config();
		conf.setSettings("root", "www_root");
		assertEquals("www_root", conf.getSettings("root"));
	}
	
	@Test
	public void testLoadConfig() {
		Config conf = new Config("WebServerConfig.ini");
		assertTrue(conf.loadConfiguration("WebServerConfig.ini"));
	}
	
	@Test
	public void testSaveConfig() {
		Config conf = new Config("WebServerConfig.ini");
		assertTrue(conf.saveConfiguration("WebServerConfig.ini"));
	}
	
	@Test
	public void testMakeDefaultConfig() {
		Config conf = new Config();
		assertTrue(conf.makeDefaultConfig());
	}
	
	@Test
	public void testValidConfigPath() {
		String configFileName = "../WebServerConfig.ini";
		
		File f = new File(configFileName);
		f.delete();
		assertFalse(f.isFile());
		
		new Config(configFileName);
		assertTrue(f.isFile());
	}
	
	@Test
	public void testValidConfigPath2() throws IOException {
		String configFileName = "../WebServerConfig.ini";
		
		File f = new File(configFileName);
		f.createNewFile();
		assertTrue(f.isFile());
		
		new Config(configFileName);
		assertTrue(f.isFile());
	}
}
