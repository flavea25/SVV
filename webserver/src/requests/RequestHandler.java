package requests;

import java.util.HashMap;
import java.util.Map;

public class RequestHandler {
	
	public RequestHandler() {
			
	}
	
	public RequestHandler(String request) {
		
	}
	
	public RequestType getRequestType() {
		return null;
	}
	
	public void setRequestType(String requestType) {
		
	}
	
	public String getRequestPath() {
		return null;
	}
	
	public void setRequestPath(String path) {
		
	}
	
	public String getParam(String key) {
		return null;
	}
	
	public Map<String, String> getParams(){
		return null;
	}
	
	public void setParam(String key, String value) {
		
	}
	
	public void setParams(Map<String, String> params) {
		
	}
	
	public boolean parseRequest() {
		//throws InvalidRequestExceptions WITH CODES (404 401 500 etc)
		return false;
	}
}
