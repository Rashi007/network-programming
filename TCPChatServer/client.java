import java.io.*;
import java.net.*;
import java.util.Scanner;

class client{
	public static void main(String ar[]) throws Exception{
		int port=6783;
		Scanner in=new Scanner(System.in);
		while(true){
		Socket clientSocket=new Socket("127.0.0.1",port);
		String n=in.nextLine();
		PrintStream socketOutput=new PrintStream(clientSocket.getOutputStream());
		socketOutput.println(n);
		BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream( )));
		System.out.println(br.readLine( ));
		clientSocket.close();
		}		
	}
}
