import java.util.Arrays;

public class Solution1920 {

	public static void main(String[] args) throws Exception {
		int N = read();
		System.in.skip(1);
		int[] arrN = read(N);
		int M = read();
		System.in.skip(1);
		StringBuilder sb = new StringBuilder();

		Arrays.sort(arrN);

		for (int i = 0; i < M; i++) {
			if (Arrays.binarySearch(arrN, read()) >= 0)
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.in.skip(1);

		System.out.print(sb);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;

		boolean isNegative = n == 13;

		if (isNegative)
			n = System.in.read() & 15;

		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return isNegative ? ~n + 1 : n;
	}

	static int[] read(int i) throws Exception {
		int[] arr = new int[i];
		for (int j = 0; j < i; j++) {
			arr[j] = read();
		}
		System.in.skip(1);
		return arr;
	}

}
