import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class chat extends Thread{
	Socket clientSocket;
	int tc;
	chat(Socket cs,int tc){
		clientSocket=cs;
		this.tc=tc;
	}
	
	public void run(){
		try{
			Scanner in=new Scanner(System.in);
			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream( )));
			PrintStream ps = new PrintStream(clientSocket.getOutputStream());
			while(true){
			System.out.println("Thread "+tc+" : "+br.readLine());
			String ine=in.nextLine();
			ps.println(ine);
			ps.flush();
			//clientSocket.close();
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
