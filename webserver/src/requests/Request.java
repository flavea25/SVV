package requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import exceptions.InvalidRequestException;

public class Request {
    private RequestType requestType;
    private String path;
    
    public RequestType getRequestType() {
		return this.requestType;
	}
    
    public String getRequestPath() {
		return this.path;
	}
    
    public void setRequestPath(String path) {
    	this.path = path;
    }

    public Request(InputStream inputStream) throws IOException, InvalidRequestException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
        String tmp = bufferReader.readLine();
        parseRequest(tmp);
    }

    public void parseRequest(String request) throws InvalidRequestException {
    	String[] split = request.split("\\s+");
        try {
        	requestType = RequestType.valueOf(split[0]);
        } catch (Exception e) {
        	requestType = null;
        	throw new InvalidRequestException();
        }
        path = split[1];
    }
}
