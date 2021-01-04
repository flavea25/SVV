package requests;

import java.net.Socket;

public class RequestHandler implements Runnable{
	private Socket socket;
	
	public RequestHandler(Socket socket) {
        this.socket = socket;
    }
	
	public void run() {
        try {
            Request request = new Request(socket.getInputStream());
            Response response = new Response(request);
            
            response.write(socket.getOutputStream());
            socket.close();
        } catch (Exception e) {
        	System.err.println("Error at Request Handling: " + e);
			System.exit(1);
        }
    }
}
