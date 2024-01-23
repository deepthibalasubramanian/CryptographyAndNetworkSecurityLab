import java.util.*;
import java.net.*;
import java.io.*;

public class client1{
	public static void main(String [] args){
		try{
			Socket s = new Socket("localhost",1000);
			DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter 10 bit binary value: ");
            String inp = sc.next();
			// dos.writeUTF("1011101011");
            dos.writeUTF(inp);
			dos.flush();
            String string = dis.readUTF();
            System.out.println(string);
			dos.close();
			s.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
