import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestConnectToScratch{
	public static void main(String[] args){
		String messageToSend = "broadcast \"start\"";
	
		int len = messageToSend.length();
		byte[] b = new byte[4];
		b[0] = (byte) ((len >> 24) & 0xFF);
		b[1] = (byte) ((len >> 16) & 0xFF);
		b[2] = (byte) ((len >> 8) & 0xFF);
		b[3] = (byte) (len & 0xFF);
		
		
		
		System.out.println();
		try{
		Socket s = new Socket("localhost", 42001);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		OutputStream outstream = s.getOutputStream();
		
		System.out.println("Start to send data....");
		
		out.write(b);
		out.write(messageToSend.getBytes());
		out.writeTo(outstream);
		s.close();
		
		}catch(UnknownHostException e){
			
		}catch(IOException e){
			
		}	
		
	
	}
}