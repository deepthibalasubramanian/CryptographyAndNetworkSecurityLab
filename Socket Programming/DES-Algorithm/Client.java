import java.util.*;
import java.net.*;
import java.io.*;

public class Client{
    public static void main(String [] args){
		try{
			Socket s = new Socket("localhost",1000);
			DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the hexadecimal PlainText: ");
            String inp1 = sc.next();
            dos.writeUTF(inp1);
			dos.flush();
            String string1 = dis.readUTF();
            System.out.println(string1);
            System.out.print("Enter the 64 bit key: ");
            String inp2 = sc.next();
            dos.writeUTF(inp2);
			dos.flush();
            String string2 = dis.readUTF();
            System.out.println(string2);
			dos.close();
			s.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
