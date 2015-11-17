import java.io.*;
import java.net.*;
import java.util.*;

class udpB{
	public static void main(String ar[]) throws Exception{
		Scanner in=new Scanner(System.in);
		DatagramSocket asock=new DatagramSocket(6789);
		InetAddress IPAddress;
		byte[] senddata=new byte[1024];
		byte[] rcvdata=new byte[1024];
		while(true){
			DatagramPacket rcvpct=new DatagramPacket(rcvdata,rcvdata.length);
			asock.receive(rcvpct);
			System.out.println("from A: "+new String(rcvpct.getData()));
			IPAddress=rcvpct.getAddress();
			int port=rcvpct.getPort();
			String snd=in.nextLine();
			senddata=snd.getBytes();
			DatagramPacket sendpct =new DatagramPacket(senddata,senddata.length,IPAddress,port);
			asock.send(sendpct);
		}
	}
	
}
