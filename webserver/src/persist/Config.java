package persist;

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
	
	public String getSettings(String keyName) {
		return "";
	}
	
	public void setSettings(String keyName, String keyValue) {
		
	}
	
}
