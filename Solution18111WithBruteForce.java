// 가설 : 모든 땅 높이의 평균보다 높은 땅높이는 해에서 배제한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution18111WithBruteForce {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		double N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]), B = Integer.parseInt(input[2]);
		int[][] ground = new int[(int) N][(int) M];
		int min = 501, max = 0, avg = 0, secFinal = 214751650, secTemp = 0, BTemp = (int) B, finalHeigh = 0;
		double sum = 0;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(input[j]);
				if (ground[i][j] <= min)
					min = ground[i][j];
				if (ground[i][j] >= max)
					max = ground[i][j];
				sum += ground[i][j];
			}
		}

		avg = (int) Math.ceil(sum / (N * M));

		for (int i = min; i <= max; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (i > ground[j][k]) {
						secTemp += i - ground[j][k];
						BTemp -= i - ground[j][k];
					} else if (i == ground[j][k]) {
						continue;
					} else {
						secTemp += (ground[j][k] - i) * 2;
						BTemp += ground[j][k] - i;
					}
				}
			}
			if (BTemp < 0) {
				BTemp = (int) B;
				secTemp = 0;
				continue;
			}
			if (secFinal >= secTemp) {
				secFinal = secTemp;
				finalHeigh = i;
			}
			BTemp = (int) B;
			secTemp = 0;
		}
		System.out.println(secFinal + " " + finalHeigh);

	}

}
