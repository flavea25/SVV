package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import exceptions.InvalidPathException;
import exceptions.InvalidRequestException;
import requests.RequestHandler;
import requests.RequestType;

public class RequestHandlerTest {

	@Test
	public void testGetRequestType() {
		RequestHandler rh = new RequestHandler();
		rh.setRequestType("GET");
		assertEquals(RequestType.GET, rh.getRequestType());
	}
	
	@Test(expected = InvalidRequestException.class)
	public void testGetRequestTypeNotInit() {
		RequestHandler rh = new RequestHandler();
		rh.getRequestType();
	}
	
	@Test(expected = InvalidRequestException.class)
	public void testSetRequestTypeInvalid() {
		RequestHandler rh = new RequestHandler();
		rh.setRequestType("UNKNOWN");
	}
	
	@Test
	public void testGetRequestPath() {
		RequestHandler rh = new RequestHandler();
		rh.setRequestPath("aaa.html");
		assertEquals("aaa.html", rh.getRequestPath());
	}
	
	@Test(expected = InvalidRequestException.class)
	public void testGetRequestPathNotInit() {
		RequestHandler rh = new RequestHandler();
		rh.getRequestPath();
	}
	
	@Test(expected = InvalidPathException.class)
	public void testSetRequestPathInvalid() {
		RequestHandler rh = new RequestHandler();
		rh.setRequestPath("aaa.ppt");
	}
	
	@Test
	public void testGetParam() {
		RequestHandler rh = new RequestHandler();
		rh.setParam("student","true");
		assertEquals("true", rh.getParam("student"));
	}
	
	@Test(expected = InvalidRequestException.class)
	public void testGetParamNotInit() {
		RequestHandler rh = new RequestHandler();
		rh.getParam("student");
	}
	
	@Test(expected = InvalidRequestException.class)
	public void testSetParamInvalid() {
		RequestHandler rh = new RequestHandler();
		rh.setParam("character","?!@()#*@");
	}
	
	@Test
	public void testGetParams() {
		RequestHandler rh = new RequestHandler();
		Map<String,String> params = new HashMap<String, String>();
		params.put("student", "true");
		rh.setParams(params);
		assertEquals(params, rh.getParams());
	}
	
	@Test
	public void testGetParamsEmpty() {
		RequestHandler rh = new RequestHandler();
		assertEquals(new HashMap<String,String>(), rh.getParams());
	}
	
	@Test(expected = InvalidRequestException.class)
	public void testSetParamsInvalid() {
		RequestHandler rh = new RequestHandler();
		Map<String,String> params = new HashMap<String, String>();
		params.put("invalidChar", "?!@()#*@");
		rh.setParams(params);
	}
	
	@Test(expected = InvalidRequestException.class)
	public void testParseRequestInvalid() {
		RequestHandler rh = new RequestHandler("POST nothing");
		rh.parseRequest();
	}
	
	@Test
	public void testParseRequest() {
		RequestHandler rh = new RequestHandler("GET aaa.html");
		assertTrue(rh.parseRequest());
	}

}
