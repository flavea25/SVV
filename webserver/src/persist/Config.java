package persist;

import java.util.Map;

public class Config { //works with files

	//private final String DEFAULT_CONFIG_FILE = "WebServerConfig.ini"
	
	public Config() {
		
	}
	
	public Config(String configFileName) {
		//new URI(configFileName)
	}
	
	public boolean loadConfiguration(String configFile) {
		return false;
	}
	
	public boolean saveConfiguration(String configFile) {
		return false;
	}
	
	public boolean makeDefaultConfig() {
		return false;
	}
	
	public String getSetting(String key) {
		return null;
	}
	
	public Map<String, String> getSettings(){
		return null;
	}
	
	public void setSetting(String key, String value) {
		
	}
	
	public void setSettings(Map<String,String> settings) {
		
	}
	
}
