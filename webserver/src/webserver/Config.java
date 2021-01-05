package webserver;

import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;

public class Config {
	//set to default
	private String path = "C:\\Users\\flavi\\OneDrive\\Desktop\\TestSite";
	private int portNumber = 10008;
	
	private static List<Integer> unavailablePortNumbers = new ArrayList<Integer>();
	
	public Config() {
		computeUnavailablePortNumbers();
	}
	
	public int getPortNumber() {
		return portNumber;
	}
	
	public void setPortNumber(int port) throws InvalidPortNumberException {
		if(port < 0 || port > 65535 || unavailablePortNumbers.contains(port)) {
			throw new InvalidPortNumberException();
		}
		else {
			portNumber = port;
		}
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) throws InvalidPathException{
		if(path == null || path.equals("")) {
			throw new InvalidPathException();
		}
		else {
			this.path = path;
		}
	}
	
	private void computeUnavailablePortNumbers() { //taken from Wikipedia
		//TODO: add from here: https://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers
		unavailablePortNumbers.add(0);
		unavailablePortNumbers.add(1);
		unavailablePortNumbers.add(5);
		unavailablePortNumbers.add(7);
		unavailablePortNumbers.add(9);
		unavailablePortNumbers.add(11);
		unavailablePortNumbers.add(13);
		unavailablePortNumbers.add(15);
		unavailablePortNumbers.add(17);
		unavailablePortNumbers.add(18);
		unavailablePortNumbers.add(19);
		unavailablePortNumbers.add(20);
		unavailablePortNumbers.add(21);
		unavailablePortNumbers.add(22);
		unavailablePortNumbers.add(23);
		unavailablePortNumbers.add(25);
		unavailablePortNumbers.add(28);
		unavailablePortNumbers.add(37);
		unavailablePortNumbers.add(42);
		unavailablePortNumbers.add(43);
		unavailablePortNumbers.add(47);
		unavailablePortNumbers.add(49);
		unavailablePortNumbers.add(51);
		unavailablePortNumbers.add(53);
		unavailablePortNumbers.add(54);
		unavailablePortNumbers.add(56);
		unavailablePortNumbers.add(58);
		unavailablePortNumbers.add(61);
		unavailablePortNumbers.add(67);
		unavailablePortNumbers.add(68);
		unavailablePortNumbers.add(69);
		unavailablePortNumbers.add(70);
		unavailablePortNumbers.add(71);
		unavailablePortNumbers.add(72);
		unavailablePortNumbers.add(73);
		unavailablePortNumbers.add(74);
		unavailablePortNumbers.add(79);
		unavailablePortNumbers.add(80);
		unavailablePortNumbers.add(81);
		unavailablePortNumbers.add(82);
		unavailablePortNumbers.add(83);
		unavailablePortNumbers.add(88);
		unavailablePortNumbers.add(90);
		unavailablePortNumbers.add(95);
		unavailablePortNumbers.add(101);
		unavailablePortNumbers.add(220);
		unavailablePortNumbers.add(401);
		unavailablePortNumbers.add(411);
		unavailablePortNumbers.add(412);
		unavailablePortNumbers.add(427);
		unavailablePortNumbers.add(433);
		unavailablePortNumbers.add(434);
		unavailablePortNumbers.add(443);
		unavailablePortNumbers.add(444);
		unavailablePortNumbers.add(445);
		unavailablePortNumbers.add(464);
		unavailablePortNumbers.add(465);
		unavailablePortNumbers.add(497);
		unavailablePortNumbers.add(500);
		unavailablePortNumbers.add(1080);
	}
	
	public List<Integer> getUnavailablePorts(){
		return unavailablePortNumbers;
	}
}
