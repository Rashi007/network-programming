import java.io.*;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.Arrays;

class fileclient{
	public static void main(String ar[]) throws Exception{
		int port=6783;
		Socket clientSocket=new Socket("127.0.0.1",port);
		BufferedReader fil=new BufferedReader((new FileReader("text.txt")),100);
		String ack="200";
		String wr;
		PrintStream toserver =new PrintStream(clientSocket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		while((wr=fil.readLine())!=null){
			toserver.println(wr);
			ack=br.readLine();
			System.out.println(ack);
			if(!ack.equals("200")){
				toserver.println(wr);
			}
			}
		clientSocket.close();
	}
}
