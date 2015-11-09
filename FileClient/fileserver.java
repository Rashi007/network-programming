import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class fileserver {
	public static void main(String ar[])throws Exception{
		ServerSocket sock=new ServerSocket(6783);
		Socket connect=sock.accept();
		BufferedReader br = new BufferedReader(new	InputStreamReader(connect.getInputStream( )));
		String x=br.readLine();
		while(x!=null){
			System.out.println(x);
			PrintStream ps = new PrintStream(connect.getOutputStream());
			ps.println("200");
			x=br.readLine();
		}
		connect.close();
	}
}
