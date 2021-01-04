package test;

import static org.junit.Assert.*;

import org.junit.Test;

import webserver.Status;
import webserver.WebServer;

public class WebServerTest {

	@Test
	public void testStatusStart() throws Exception {
		WebServer.start();
		assertEquals(Status.RUNNING, WebServer.STATUS);
	}
	
	@Test
	public void testStatusMaintenance() throws Exception {
		WebServer webServer = new WebServer();
		webServer.maintenance();
		assertEquals(Status.MAINTENANCE, WebServer.STATUS);
	}
	
	@Test
	public void testStatusStop() {
		WebServer.stopServer();
		assertEquals(Status.STOPPED, WebServer.STATUS);
	}

}
