import java.io.IOException;

public class Solution1018 {

	public static void main(String[] args) throws IOException {
		int M = readDigits();
		int N = readDigits();
		int[] board = new int[M * N];

		System.in.skip(1);

		int input;
		for (int i = 0; i < M * N; i++) {
			if (i % N == 0 && i != 0)
				System.in.skip(2);

			board[i] = System.in.read();
		}

		int x = 0, y = 0;
		int wrong = 70;

		for (int i = 0; i < (M - 7) * (N - 7); i++) {
			int z = 0;
			int xTemp = x;
			int yTemp = y;
			int isWhite = 87; // white = 87 / black = 66
			int wrongTemp = 0;

			while (xTemp < 8) { // ¸Ç À§ ¸Ç ¿Þ¦UÀÌ white
				if (board[N * xTemp + yTemp] == isWhite && isWhite == 87)
					isWhite = 66;
				else if (board[N * xTemp + yTemp] == isWhite && isWhite == 66)
					isWhite = 87;
				else if (board[N * xTemp + yTemp] != isWhite && isWhite == 87) {
					isWhite = 66;
					wrongTemp++;
				} else if (board[N * xTemp + yTemp] != isWhite && isWhite == 66) {
					isWhite = 87;
					wrongTemp++;
				}

				if (yTemp - y < 7)
					yTemp++;
				else if (yTemp - y == 7) {
					yTemp = 0;
					xTemp++;
					if (isWhite == 87)
						isWhite = 66;
					else
						isWhite = 87;
				}
			}

			if (wrong > wrongTemp)
				wrong = wrongTemp;
			wrongTemp = 0;
			isWhite = 66;
			xTemp = x;
			yTemp = y;

			while (xTemp < 8) { // ¸Ç À§ ¸Ç ¿Þ¦UÀÌ white
				if (board[N * xTemp + yTemp] == isWhite && isWhite == 87)
					isWhite = 66;
				else if (board[N * xTemp + yTemp] == isWhite && isWhite == 66)
					isWhite = 87;
				else if (board[N * xTemp + yTemp] != isWhite && isWhite == 87) {
					isWhite = 66;
					wrongTemp++;
				} else if (board[N * xTemp + yTemp] != isWhite && isWhite == 66) {
					isWhite = 87;
					wrongTemp++;
				}

				if (yTemp - y < 7)
					yTemp++;
				else if (yTemp - y == 7) {
					yTemp = 0;
					xTemp++;
					if (isWhite == 87)
						isWhite = 66;
					else
						isWhite = 87;
				}
			}

			if (wrong > wrongTemp)
				wrong = wrongTemp;

			y++;

			if (y + 8 > N) {
				y = 0;
				x++;
			}
		}
		System.out.print(new StringBuilder().append(wrong));

	}

	static int readDigits() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}
