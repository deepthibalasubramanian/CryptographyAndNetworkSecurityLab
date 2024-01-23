import java.util.*;
import java.net.*;
import java.io.*;

public class server1{
    public static int[] p10(int arr[]){
        int newArr[] = new int[10];
        newArr[0] = arr[2];
        newArr[1] = arr[4];
        newArr[2] = arr[1];
        newArr[3] = arr[6];
        newArr[4] = arr[3];
        newArr[5] = arr[9];
        newArr[6] = arr[0];
        newArr[7] = arr[8];
        newArr[8] = arr[7];
        newArr[9] = arr[5];
        return newArr;
    }
    public static int[] p8(int arr[]){
        int newArr[] = new int[8];
        newArr[0] = arr[5];
        newArr[1] = arr[2];
        newArr[2] = arr[6];
        newArr[3] = arr[3];
        newArr[4] = arr[7];
        newArr[5] = arr[4];
        newArr[6] = arr[9];
        newArr[7] = arr[8];
        return newArr;
    }
    public static int[] lcs1(int arr[]) {
        int lcsarr[] = new int[5];
        for (int i=1;i<5;i++){
            lcsarr[i-1] = arr[i];
        }
        lcsarr[4] = arr[0];
        return lcsarr;
    }
    public static int[] lcs2(int arr[]) {
        int lcsarr[] = new int[5];
        for (int i=2;i<5;i++){
            lcsarr[i-2] = arr[i];
        }
        lcsarr[3] = arr[0];
        lcsarr[4] = arr[1];
        return lcsarr;
    }
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(1000);
			Socket s=ss.accept();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String string = (String)dis.readUTF();
            dos.writeUTF("Received: "+string);
			System.out.println("Client sent: "+string);
            String[] str = string.split("");
            int[] arr = new int[str.length];
            for(int i = 0; i < str.length; i++) {
                arr[i] = Integer.valueOf(str[i]);
            }
            //System.out.println("Integer array: "+ Arrays.toString(arr));
            //p10
            int newArr[] = p10(arr);
            //System.out.println("Array after p10: "+ Arrays.toString(newArr));
            //split array into two halves

            int[] leftArr = new int[5];
            int[] rightArr = new int[5];

            for(int i = 0; i<5; i++) {
                leftArr[i] = newArr[i];
            }

            for(int i = 0; i<5; i++) {
                rightArr[i] = newArr[5+i];
            }

            //System.out.println("Left half: "+ Arrays.toString(leftArr));
            //System.out.println("Right half: "+ Arrays.toString(rightArr));

            // lcs1
            int[] leftArrLCS1 = lcs1(leftArr);
            int[] rightArrLCS1 = lcs1(rightArr);

            //System.out.println("Left half LCS1: "+ Arrays.toString(leftArrLCS1));
            //System.out.println("Right half LCS1: "+ Arrays.toString(rightArrLCS1));

            // sk1 by combining LCS1 results

            int[] lcs1combined = new int[10];
            System.arraycopy(leftArrLCS1, 0 , lcs1combined, 0, 5);
            System.arraycopy(rightArrLCS1, 0 , lcs1combined, 5, 5);
            //System.out.println("LCS1 combined: "+ Arrays.toString(lcs1combined));

            int[] sk1 = p8(lcs1combined);
            System.out.println("SK1: "+ Arrays.toString(sk1));

            //lcs2 on the 2 halves
            int[] leftArrLCS2 = lcs2(leftArrLCS1);
            int[] rightArrLCS2 = lcs2(rightArrLCS1);
            //System.out.println("Left half LCS2: "+ Arrays.toString(leftArrLCS2));
            //System.out.println("Right half LCS2: "+ Arrays.toString(rightArrLCS2));

            // sk2 generation
            int[] lcs2combined = new int[10];
            System.arraycopy(leftArrLCS2, 0 , lcs2combined, 0, 5);
            System.arraycopy(rightArrLCS2, 0 , lcs2combined, 5, 5);
            //System.out.println("LCS2 combined: "+ Arrays.toString(lcs2combined));

            int[] sk2 = p8(lcs2combined);
            System.out.println("SK2: "+ Arrays.toString(sk2));
			ss.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
