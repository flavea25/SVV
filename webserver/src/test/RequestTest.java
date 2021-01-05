package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ServerSocket;

import org.junit.Ignore;
import org.junit.Test;

import exceptions.InvalidRequestException;
import requests.Request;

public class RequestTest {

	@Ignore
	@Test
	public void testSetRequestPath() throws IOException, InvalidRequestException {
		ServerSocket ss = new ServerSocket(8080);
		Request r = new Request(ss.accept().getInputStream());
		r.setRequestPath("C:\\Users\\flavi\\");
		String tmp = r.getRequestPath();
		ss.close();
		assertEquals("C:\\Users\\flavi\\", tmp);
	}
	
	@Ignore
	@Test(expected = InvalidRequestException.class)
	public void testParseInvalidRequest() throws InvalidRequestException, IOException {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8080);
			Request r = new Request(ss.accept().getInputStream());
			r.parseRequest("Nono");
		} catch (IOException e) {
		} finally {
			ss.close();
		}
	}
	
	@Ignore
	@Test(expected = InvalidRequestException.class)
	public void testParseInvalidRequestType() throws InvalidRequestException, IOException {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8080);
			Request r = new Request(ss.accept().getInputStream());
			r.parseRequest("HET /a.html");
		} catch (IOException e) {
		} finally {
			ss.close();
		}
	}
	
	@Ignore
	@Test
	public void testParseRequest() throws InvalidRequestException, IOException {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8080);
			Request r = new Request(ss.accept().getInputStream());
			r.parseRequest("GET /a.html");
		} catch (IOException e) {
		} finally {
			ss.close();
		}
	}

}
