package test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import exceptions.InvalidPathException;
import exceptions.InvalidPortNumberException;
import webserver.Config;
import webserver.WebServer;

public class WebServerTest {
	@Test
	public void testGetSetPort() throws InvalidPortNumberException {
		WebServer.setPort(8080);
		assertEquals("8080",WebServer.getPort());
	}
	
	@Test
	public void testSetPath() throws InvalidPathException {
		WebServer.setPath("C:\\");
		assertEquals("C:\\",Config.DEFAULT_PATH);
	}

	@Ignore
	@Test
	public void testStart() throws Exception {
		WebServer.start();
	}
	
	@Ignore
	@Test
	public void testStopServer() {
		WebServer.stopServer();
	}
	
	@Ignore
	@Test
	public void testMaintenance() throws Exception {
		WebServer.maintenance();
	}
}
