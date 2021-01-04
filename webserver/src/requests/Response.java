package requests;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import webserver.Config;
import webserver.Status;
import webserver.WebServer;

public class Response {
	public static final String VERSION = "HTTP/1.1";
	public static final String INDEX_FILE = "\\a.html";
	public static final String MAINTENANCE_FILE = "\\maint.html";
	
    private List<String> headers = new ArrayList<String>();
    private byte[] content;

    public Response(Request request) throws IOException {
    	File file = null;
        switch (request.getRequestType()) {
            case GET:
                try {
                	if(WebServer.STATUS.equals(Status.RUNNING)) {
                		if(request.getRequestPath().equals("/")) {
                    		file = new File(Config.DEFAULT_PATH + INDEX_FILE); 
                    	}
                    	else {
                    		file = new File(Config.DEFAULT_PATH + modifyPath(request.getRequestPath())); 
                    	}
                	}
                	else if(WebServer.STATUS.equals(Status.MAINTENANCE)) {
                		file = new File(Config.DEFAULT_PATH + MAINTENANCE_FILE);
                	}
                	
                    
                    if (file.exists()) {
                    	headers.add(Response.VERSION + " " + ResponseType.toString(ResponseType.CODE200));
                        content = Files.readAllBytes(file.toPath());
                    } else {
                    	System.err.println("File not found: " + file.toPath());
                    	headers.add(Response.VERSION + " " + ResponseType.toString(ResponseType.CODE404));
                        content = ResponseType.toString(ResponseType.CODE404).getBytes();
                    }
                } catch (Exception e) {
                	System.err.println("Error at Request Type " + e);
                	headers.add(Response.VERSION + " " + ResponseType.toString(ResponseType.CODE400));
                    content = ResponseType.toString(ResponseType.CODE400).getBytes();
                }
                break;
            default: //TODO PUT, POST, DELETE
            	headers.add(Response.VERSION + " " + ResponseType.toString(ResponseType.CODE500));
                content = ResponseType.toString(ResponseType.CODE500).getBytes();
                break;
        }
    }

    public void write(OutputStream outputStream) throws IOException {
        DataOutputStream output = new DataOutputStream(outputStream);
        for (String header : headers) {
            output.writeBytes(header + "\r\n");
        }
        output.writeBytes("\r\n");
        if (content != null) {
            output.write(content);
        }
        output.writeBytes("\r\n");
        output.flush();
    }
    
    public String modifyPath(String path) {
    	String tmp = path.replace("/", "\\");
    	try {
			tmp = java.net.URLDecoder.decode(tmp, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	
    	return tmp;
    }
}
