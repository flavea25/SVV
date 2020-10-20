package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import exceptions.ConfigInitException;
import persist.Config;

public class ConfigTest {

	@Test(expected = ConfigInitException.class)
	public void testGetSettingNotInit() {
		Config conf = null;
		conf.getSetting("root");
	}
	
	@Test(expected = ConfigInitException.class)
	public void testGetSettingsNotInit() {
		Config conf = null;
		conf.getSettings();
	}
	
	@Test(expected = ConfigInitException.class)
	public void testSetSettingNotInit() {
		Config conf = null;
		conf.setSetting("root","www_root");
	}
	
	@Test(expected = ConfigInitException.class)
	public void testSetSettingsNotInit() {
		Config conf = null;
		Map<String,String> settings = new HashMap<String,String>();
		settings.put("root","www_root");
		conf.setSettings(settings);
	}
	
	@Test
	public void testGetSetting() {
		Config conf = new Config();
		conf.setSetting("root", "www_root");
		assertEquals("www_root", conf.getSetting("root"));
	}
	
	@Test
	public void testGetSettings() {
		Config conf = new Config();
		Map<String,String> settings = new HashMap<String,String>();
		settings.put("root","www_root");
		conf.setSettings(settings);
		assertEquals("www_root", conf.getSettings());
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
