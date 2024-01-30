import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
    // public static int[] IP(int[] arr) {
    //     int[] newArr = new int[64];

    // }
    public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(1000);
			Socket s=ss.accept();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String plaintext = (String)dis.readUTF();
            dos.writeUTF("Received Plaintext: "+plaintext);
			System.out.println("Client sent Plaintext: "+plaintext);
            String key = (String)dis.readUTF();
            dos.writeUTF("Received Key: "+key);
			System.out.println("Client sent key: "+key);
            
			ss.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
