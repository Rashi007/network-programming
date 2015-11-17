import java.io.*;
import java.net.*;
import java.util.*;

class udpA{
	public static void main(String ar[]) throws Exception{
		Scanner in=new Scanner(System.in);
		DatagramSocket bsock=new DatagramSocket();
		InetAddress IPAddress=InetAddress.getByName("127.0.0.1");
		byte[] senddata=new byte[1024];
		byte[] rcvdata=new byte[1024];
		while(true){
			String mess=in.nextLine();
			senddata=mess.getBytes();
			DatagramPacket sendpct=new DatagramPacket(senddata,senddata.length,IPAddress,6789);
			bsock.send(sendpct);
			DatagramPacket rcvpct=new DatagramPacket(rcvdata,rcvdata.length);
			bsock.receive(rcvpct);
			System.out.println("from B: "+new String(rcvpct.getData()));
		}
		
	}

}
