import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();
		int[] alphabet = new int[26];
		int index = 0;
		boolean isSame = false;

		for (char c : ch) {
			if (c - 65 >= 32)
				alphabet[c - 97]++;
			else
				alphabet[c - 65]++;
		}

		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] > alphabet[index]) {
				isSame = false;
				index = i;
			} else if (alphabet[i] == alphabet[index] && alphabet[i] != 0 && i != 0) {
				isSame = true;
				index = i;
			} else if (alphabet[i] == 0)
				continue;
		}
		
		if (isSame == true)
			System.out.println("?");
		else
			System.out.println((char) (index + 65));
	}

}
