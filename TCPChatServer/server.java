import java.net.*;
import java.io.*;
import java.util.Scanner;

class server{
	public static void main(String[] args) throws Exception{
		ServerSocket connect=new ServerSocket(6783);
		Scanner in=new Scanner(System.in);
		while(true){
			Socket dataSocket=connect.accept();
		BufferedReader br = new BufferedReader(new
InputStreamReader(dataSocket.getInputStream( )));
		System.out.println(br.readLine());
		PrintStream ps = new PrintStream(dataSocket.getOutputStream());
		String ine=in.nextLine();
		ps.println(ine);
		ps.flush( );
		dataSocket.close( );
		}
	}
}
