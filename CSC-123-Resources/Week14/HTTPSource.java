import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HTTPSource extends CSVReader {

	public HTTPSource() {
		super();
	}

	@Override
	protected InputStream getInputStream() throws Exception {
		Socket socket = new Socket("www.usman.cloud", 80);
		
		//Sending request
		OutputStream out=socket.getOutputStream();
		out.write("GET /banking/exchange-rate.csv HTTP/1.1\r\n".getBytes());			
		out.write("Host: www.usman.cloud\r\n".getBytes());
		out.write("\r\n".getBytes());
		
		//Reading  response
		
		return socket.getInputStream();
	}

}
