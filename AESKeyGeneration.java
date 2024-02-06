// AES key generation

public class AESKeyGeneration{

    public static void AESKeyGen(String plaintext) {
        // split into words, each of length 16 bytes
        String w1 = plaintext.substring(0,8);
        System.out.println(w1);
    }

	public static void main(String[] args) {
		String plaintext = "00112233445566778899AABBCDDEEFF";
		AESKeyGen(plaintext);
	}
}
