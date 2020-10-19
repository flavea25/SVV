package persist;

public class Persist {	//manager of Config (makes checks as well)
	//private Config config = new Config();
	
	public int getPortNumber() {
		return 0;
	}
	
	public void setPortNumber(int portNumber) {
		//if(port<0) throw exception
		//other checks for the port
		//if everything is ok: config.setPort(new String(portNumber)) sau idk;
	}
	
	public String getRootDir() {
		return "";
	}
	
	public void setRootDir(String rootDir) {
		//checks
	}
	
	public String getMaintDir() {
		return "";
	}
	
	public void setMaintDir(String maintDir) {
		//checks
	}
}
