import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double[] score = new double[Integer.parseInt(br.readLine())];
		int M = 0;
		float sum = 0;
		String[] str = br.readLine().split(" ");

		for (int i = 0; i < score.length; i++) {
			score[i] = Double.parseDouble(str[i]);
			if (score[i] >= M)
				M = (int) score[i];
		}

		for (int i = 0; i < score.length; i++) {
			score[i] = (score[i] / M) * 100;
			sum += score[i];
		}
		System.out.println(sum / score.length);
	}

}
