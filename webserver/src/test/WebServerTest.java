package test;

import static org.junit.Assert.*;

import org.junit.Test;

import webserver.Status;
import webserver.WebServer;

public class WebServerTest {

	@Test
	public void testStatusStart() {
		WebServer webServer = new WebServer();
		webServer.start();
		assertEquals(Status.RUNNING, webServer.getStatus());
	}
	
	@Test
	public void testStatusMaintenance() {
		WebServer webServer = new WebServer();
		webServer.maintenance();
		assertEquals(Status.MAINTENANCE, webServer.getStatus());
	}
	
	@Test
	public void testStatusStop() {
		WebServer webServer = new WebServer();
		webServer.stopServer();
		assertEquals(Status.CLOSED, webServer.getStatus());
	}

}
