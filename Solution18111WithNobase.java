/* Brute force 알고리즘을 통해 풀어야 한다는 사실을 모른채, 직접 가설을 세워 알고리즘을 작성했다. 결과는 실패.
 * 가설 : 기장 낮은 땅 높이 min 과 가장 높은 땅 높이 max, 그리고 모든 땅 높이의 평균 avg를 구하고, avg와 min의 중간값으로 땅 높이를 통일한다.
 * 땅을 높이는것이 땅을 낮추는것보다 2배 빠르기때문에, min과 avg의 중간값 어딘가에 최적값이 존재한다고 생각함.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution18111WithNobase {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]), B = Integer.parseInt(input[2]);
		int[][] ground = new int[N][M];
		int min = 10000, max = 0, sec = 0;
		double avg = 0;

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(input[j]);
				if (ground[i][j] < min)
					min = ground[i][j];
				if (ground[i][j] > max)
					max = ground[i][j];
				avg += ground[i][j];
			}
		}

		avg /= (N * M);
		avg = Math.round(avg);
		avg = Math.ceil((avg + min) / 2);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ground[i][j] == avg)
					continue;
				else if (ground[i][j] < avg)
					B -= (int) (avg - ground[i][j]);
				else
					B += (int) (ground[i][j] - avg);
			}
		}

		if (B < 0)
			avg = avg - B / (N * M);
		if (B % (N * M) != 0)
			avg--;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ground[i][j] == avg) {
					continue;

				} else if (ground[i][j] < avg) {
					sec += (int) (avg - ground[i][j]);
					B -= (int) (avg - ground[i][j]);
					ground[i][j] += (int) (avg - ground[i][j]);
				} else {
					sec += (int) (ground[i][j] - avg) * 2;
					B += (int) (ground[i][j] - avg);
					ground[i][j] -= (int) (ground[i][j] - avg);
				}

			}
		}

		System.out.println(sec + " " + ground[0][0]);
	}

}
