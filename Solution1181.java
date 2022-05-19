import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution1181 {

	public static void main(String[] args) throws Exception {
		int N = read();
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<String> stringList = new LinkedList<String>();
		int compare;
		stringList.

		str = br.readLine();
		for (int i = 0; i < N; i++) {
			if ((compare = compareTo(str.getBytes(), str.length(), (str = br.readLine()).getBytes(), str.length())) > 0)
				
				str = br.readLine();
		}
	}

	public static int compareTo(byte[] value, int len1, byte[] other, int len2) {
		int lim = Math.min(len1, len2);
		for (int k = 0; k < lim; k++) {
			if (value[k] != other[k]) {
				return getChar(value, k) - getChar(other, k);
			}
		}
		return len1 - len2;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
