
public class Solution1259 {

	public static void main(String[] args) throws Exception {
		byte[] arr = read();
		int c = 0;
		StringBuilder sb = new StringBuilder();

		while ((c = arr[0]) != 48) {
			if (c == 1)
				sb.append("yes\n");
			else if (c == 2)
				if (arr[1] == arr[2])
					sb.append("yes\n");
				else
					sb.append("no\n");
			else if (c == 3)
				if (arr[1] == arr[3])
					sb.append("yes\n");
				else
					sb.append("no\n");
			else if (c == 4)
				if (arr[1] == arr[4] && arr[2] == arr[3])
					sb.append("yes\n");
				else
					sb.append("no\n");
			else if (arr[1] == arr[5] && arr[2] == arr[4])
				sb.append("yes\n");
			else
				sb.append("no\n");
			arr = read();
		}
		System.out.print(sb);
	}

	static byte[] read() throws Exception {
		byte d;

		if ((d = (byte) System.in.read()) == 48) {
			byte[] arr = { 48 };
			return arr;
		}

		int i = 0;
		byte d2;
		byte[] arrByte = { 0, d, -1, -1, -1, -1 };
		for (i = 2; (d2 = (byte) System.in.read()) > 32; i++) {
			arrByte[i] = d2;
		}
		arrByte[0] = (byte) --i;
		System.in.skip(1);
		return arrByte;
	}
}
