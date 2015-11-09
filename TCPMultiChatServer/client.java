import java.io.*;
import java.net.*;
import java.util.Scanner;

class client{
	public static void main(String ar[]) throws Exception{
		int port=6783;
		Socket clientSocket=new Socket("127.0.0.1",port);			
		Scanner in=new Scanner(System.in);
		//Socket clientSocket=new Socket("127.0.0.1",port);
		PrintStream socketOutput=new PrintStream(clientSocket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream( )));		
		while(true){
			String n=in.nextLine();
			socketOutput.println(n);
			System.out.println(br.readLine( ));
		}
		//clientSocket.close();
	}
}
