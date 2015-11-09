import java.net.*;
import java.io.*;

class server{
	public static void main(String[] args) throws Exception{
		ServerSocket connect=new ServerSocket(6783);
		while(true){
			Socket dataSocket=connect.accept();
		BufferedReader br = new BufferedReader(new
InputStreamReader(dataSocket.getInputStream( )));
		String a=br.readLine();
		int a1=Integer.parseInt(a.substring(0,1));
		int b1=Integer.parseInt(a.substring(4,5));
		int res;
		if(a.substring(2, 3).equals("+")){
			res=a1+b1;
		}
		else if(a.substring(2, 3).equals("-")){
			res=a1-b1;
		}
		else if(a.substring(2, 3).equals("*")){
			res=a1*b1;
		}
		else{
			res=a1/b1;
		}
		PrintStream ps = new PrintStream(dataSocket.getOutputStream());
		ps.println("Output: "+res);
		ps.flush( );
		dataSocket.close( );
		}
	}
}
