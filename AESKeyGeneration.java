// AES key generation

public class Main{

    public static void AESKeyGen(String plaintext) {
        // split into words, each of length 16 bytes
        String w1 = plaintext.substring(0,8);
        String w2 = plaintext.substring(8,16);
        String w3 = plaintext.substring(16,24);
        String w4 = plaintext.substring(24);
        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w3);
        System.out.println(w4);
    }

	public static void main(String[] args) {
		String plaintext = "00112233445566778899AABBCCDDEEFF";
		AESKeyGen(plaintext);
	}
}
