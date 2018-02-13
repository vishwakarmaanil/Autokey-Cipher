import java.io.*;

public class AutokeyDecryption {
	public static void main(String args[]) throws IOException {

		// read input plaintext from file
		FileReader plaintextFile = new FileReader("d:/plaintext.txt");
		BufferedReader readPlaintextFile = new BufferedReader(plaintextFile);
		String plaintext = readPlaintextFile.readLine();
		readPlaintextFile.close();

		// take input Key
		String keyText = "deceptive";

		// append key and plaintext to match number of characters in both
		String key = keyText + plaintext;
		int match = key.length() - keyText.length();
		key = key.substring(0, match);

		if (isAlpha(plaintext)) {
			String cipherText = encrypt(key, plaintext);
			System.out.println(cipherText);
			plaintext = decrypt(key, cipherText);
			System.out.println(plaintext);
		} else {
			System.out.println(plaintext + " \nAll the characters should be Alphabets");
		}

	}

	public static boolean isAlpha(String plaintext) {
		return plaintext.matches("[a-zA-Z]+");
	}

	private static String encrypt(String key, String plaintext) throws IOException {
		key = key.toUpperCase();
		plaintext = plaintext.toUpperCase();
		System.out.println(plaintext);
		System.out.println(key);
		String setOfAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String cipherText = "";
		for (int i = 0; i < plaintext.length(); i++) {
			int cipher = (key.charAt(i) + plaintext.charAt(i)) % 26;
			cipherText = cipherText + setOfAlphabets.charAt(cipher);
		}
		FileWriter writeCipher = new FileWriter("d:/outputCipher.txt");
		BufferedWriter c = new BufferedWriter(writeCipher);
		c.write(cipherText);
		c.close();
		return cipherText;

	}

	private static String decrypt(String key, String cipherText) throws IOException {
		key = key.toUpperCase();
		String setOfAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String plainText = "";
		for (int i = 0; i < cipherText.length(); i++) {
			int text = (cipherText.charAt(i) - key.charAt(i)) % 26;
			if (text < 0)
				text = text + 26;

			plainText = plainText + setOfAlphabets.charAt(text);
		}
		FileWriter writePlainText = new FileWriter("d:/DecryptedText.txt");
		BufferedWriter c = new BufferedWriter(writePlainText);
		c.write(plainText);
		c.close();
		return plainText;
	}

}
