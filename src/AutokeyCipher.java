import java.io.*;
import java.util.Scanner;

public class AutokeyCipher {
    public static void main(String args[]) throws IOException {
	// Read input plaintext from file
	FileReader plaintextFile = new FileReader("src/inputPlaintext.txt"); // source of plaintext file
	Scanner scanner = new Scanner(plaintextFile);
	String plaintext = "";
	if (scanner.hasNext()) {
	    while (scanner.hasNext()) {
		plaintext += scanner.nextLine();
	    }

	    plaintext = plaintext.toUpperCase();
	    // Keyword
	    String keyWord = "deceptive";
	    keyWord = keyWord.toUpperCase();

	    String cipherText = "";
	    plaintext = plaintext.replaceAll("\\s", "");
	    plaintext = plaintext.toUpperCase();
	    if (plaintext.matches("[a-zA-Z]+")) {

		// Append keyword with plaintext to make the key as long as plaintext
		String key = keyWord.concat(plaintext);
		key = key.substring(0, plaintext.length());
		System.out.println("Plaintext  : " + plaintext);
		System.out.println("Key        : " + key);
		cipherText = encrypt(key, plaintext);
		System.out.println("Ciphertext : " + cipherText);

		// Write Output Ciphertext to a text file
		FileWriter writeCipher = new FileWriter("src/outputCipher.txt");
		writeCipher.write(cipherText);
		writeCipher.flush();
		writeCipher.close();
		System.out.println("Output Ciphertext file is Created !!");
	    } else {
		System.out.println(
			"Cannot Encrypt!!\nAll the characters of input Plaintext should be alphabets (A - Z or a - z)");
	    }
	} else {
	    System.out.println("File is Empty");
	}

    }

    private static String encrypt(String key, String plaintext) throws IOException {
	String setOfAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String cipherText = "";
	for (int i = 0; i < plaintext.length(); i++) {
	    int cipher = (key.charAt(i) + plaintext.charAt(i)) % 26;
	    cipherText = cipherText + setOfAlphabets.charAt(cipher);
	}
	return cipherText;
    }

}
