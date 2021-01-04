 package webserver;

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import exceptions.InvalidPortNumberException;
import requests.RequestHandler;

public class WebServer {
	protected static ServerSocket serverSocket = null;
	private static Config configuration = new Config();
	private static ExecutorService executor = Executors.newFixedThreadPool(2);
	public static Status STATUS = Status.STOPPED; //initial status
	static WebServerGUI wsg = new WebServerGUI();

	public static void main(String[] args) throws Exception {
		//uncomment and change the following lines, if necessary
		//initialize.setDefaultPath(...); //or just modify the static variable DEFAULT_PATH in class Config
		//initialize.setPortNumber(...); //default is 10008
		
		//uncomment the line below to test the stopServer() method
		//start();
	}

	public static void start() throws Exception {
		if(!STATUS.equals(Status.RUNNING)) {
			if(STATUS.equals(Status.STOPPED)) {
				serverSocket = new ServerSocket(configuration.getPortNumber());
				System.out.println("Connection Socket Created; Port = " + configuration.getPortNumber());
			}
			
			System.out.println("New Communication Thread Started");
			STATUS = Status.RUNNING;
			wsg.statusLabel.setText("Status: " + WebServer.STATUS.toString());
			
	        while(STATUS == Status.RUNNING) {
	        	executor.submit(new RequestHandler(serverSocket.accept()));
	        }
		}
	}
	
	public static void stopServer() {
		if(!STATUS.equals(Status.STOPPED)) {
			try {
				serverSocket.close();
				STATUS = Status.STOPPED;
				wsg.statusLabel.setText("Status: " + WebServer.STATUS.toString());
				System.out.println("Communication Thread Stopped");
			} catch (Exception e) {
				System.err.println("Error at STOP");
				System.exit(1);
			}
		}
	}
	
	public static void maintenance() throws Exception {
		if(!STATUS.equals(Status.MAINTENANCE)) {
			if(STATUS.equals(Status.STOPPED)) {
				serverSocket = new ServerSocket(configuration.getPortNumber());
				System.out.println("Connection Socket Created; Port = " + configuration.getPortNumber());
			}
			
			System.out.println("Entered Maintenance Mode");
			STATUS = Status.MAINTENANCE;
			wsg.statusLabel.setText("Status: " + WebServer.STATUS.toString());

	        while(STATUS == Status.MAINTENANCE) {
	        	executor.submit(new RequestHandler(serverSocket.accept()));
	        }
		}
	}
	
	public static String getPort() {
		return String.valueOf(configuration.getPortNumber());
	}
	
	public static void setPort(int port) throws InvalidPortNumberException {
		configuration.setPortNumber(port);
	}
	
	public static void setPath(String path) {
		configuration.setDefaultPath(path);
	}
}