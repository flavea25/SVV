 package webserver;

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import requests.RequestHandler;

import java.io.*;

public class WebServer {
	protected static ServerSocket serverSocket = null;
	private static Config configuration = new Config();
	private static ExecutorService executor = Executors.newFixedThreadPool(2);
	public static Status STATUS = Status.STOPPED; //initial status

	public static void main(String[] args) throws IOException, InvalidPathException, InvalidPortNumberException {
		//uncomment and change the following lines, if necessary
		//initialize.setDefaultPath(...); //or just modify the static variable DEFAULT_PATH in class Config
		//initialize.setPortNumber(...); //default is 10008
		
		try {
			serverSocket = new ServerSocket(configuration.getPortNumber());
			System.out.println("Connection Socket Created; Port = " + configuration.getPortNumber());
			start();
        } catch (Exception e) {
        	System.err.println("Error at START");
			System.exit(1);
        } finally {
			stopServer();
		} 
	}

	public static void start() throws Exception {
		System.out.println("New Communication Thread Started");
		STATUS = Status.RUNNING;
		
        while(STATUS == Status.RUNNING) {
        	executor.submit(new RequestHandler(serverSocket.accept()));
        }
	}
	
	public static void stopServer() {		
		try {
			serverSocket.close();
			STATUS = Status.STOPPED;
			System.out.println("Communication Thread Stopped");
		} catch (Exception e) {
			System.err.println("Error at STOP");
			System.exit(1);
		}
	}
	
	public void maintenance() throws Exception {
		System.out.println("Entered Maintenance Mode");
		STATUS = Status.MAINTENANCE;

        while(STATUS == Status.MAINTENANCE) {
        	executor.submit(new RequestHandler(serverSocket.accept()));
        }
	}
}