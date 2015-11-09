import java.net.*;
import java.io.*;

class server{
	public static void main(String[] args) throws Exception{
		ServerSocket connect=new ServerSocket(6783);
		int count=0;
		while(true){
			Socket clSocket=connect.accept();
			count++;
			chat thread=new chat(clSocket,count);
			thread.start();
		}
	}
}
