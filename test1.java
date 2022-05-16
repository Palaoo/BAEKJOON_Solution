import java.io.IOException;

public class test1 {

	public static void main(String[] args) throws IOException {
		int M = readDigits();
		int N = readDigits();
		int[] board = new int[M * N];

		System.in.skip(1);		// ���� ** eclipse���� ���� �Է½� ĳ���� ����(<CR> : 13 carrige return)��
								// ����(<LF>  : 10 Line feed) �ΰ��� ���޾� ��������,
								// ���� ����Ʈ���� ���� �ѹ��� ���´�.
		for (int i = 0; i < M * N; i++) {
			if (i % N == 0 && i != 0)	
				System.in.skip(2);		// ���� ����ÿ��� skip�� 1���� ����� �Ѵ�.

			board[i] = System.in.read();
		}

		int x = 0, y = 0;
		int wrong = 70;

		for (int i = 0; i < (M - 7) * (N - 7); i++) {
			int xTemp = x;
			int yTemp = y;
			int wrongTemp = 0;
			int isWhite = 87;

			while (xTemp - x < 8) {
				if (board[(N * xTemp) + yTemp] != isWhite)
					wrongTemp++;

				if (yTemp - y < 7) {
					yTemp++;
					if (isWhite == 87)
						isWhite = 66;
					else
						isWhite = 87;
				} else {
					yTemp = y;
					xTemp++;
				}
			}

			if (wrong > wrongTemp)
				wrong = wrongTemp;
			wrongTemp = 0;
			isWhite = 66;
			xTemp = x;
			yTemp = y;

			while (xTemp - x < 8) {
				if (board[(N * xTemp) + yTemp] != isWhite)
					wrongTemp++;

				if (yTemp - y < 7) {
					yTemp++;
					if (isWhite == 87)
						isWhite = 66;
					else
						isWhite = 87;
				} else {
					yTemp = y;
					xTemp++;
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
