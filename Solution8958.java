import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = new String[Integer.parseInt(br.readLine())];
		int[] score = new int[input.length];
		int weight = 0;

		for (int i = 0; i < input.length; i++) {
			input[i] = br.readLine();
			char[] ch = input[i].toCharArray();
			for (char c : ch) {
				if (c == 'O') {
					weight++;
					score[i] += weight;
				} else
					weight = 0;
			}
			weight = 0;
		}
		for (int a : score) {
			System.out.println(a);
		}
	}

}
