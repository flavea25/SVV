package requests;

public enum ResponseType {
	CODE200, CODE400, CODE404, CODE500;
	
	public static String toString(ResponseType rt) {
		switch(rt) {
		case CODE200:
			return "200 OK";
		case CODE400:
			return "400 Bad Request";
		case CODE404:
			return "404 Not Found";
		case CODE500:
			return "500 Server Error";
		default: return "UNKNOWN ERROR";
		}
	}
}
