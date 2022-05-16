/* Brute force �˰����� ���� Ǯ��� �Ѵٴ� ����� ��ä, ���� ������ ���� �˰����� �ۼ��ߴ�. ����� ����.
 * ���� : ���� ���� �� ���� min �� ���� ���� �� ���� max, �׸��� ��� �� ������ ��� avg�� ���ϰ�, avg�� min�� �߰������� �� ���̸� �����Ѵ�.
 * ���� ���̴°��� ���� ���ߴ°ͺ��� 2�� �����⶧����, min�� avg�� �߰��� ��򰡿� �������� �����Ѵٰ� ������.
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
