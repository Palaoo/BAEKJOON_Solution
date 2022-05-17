
public class Solution1874 {

	public static void main(String[] args) throws Exception {
		int length = read();
		int[] stack = new int[length + 1];
		int index = 0;
		int seq = length;
		int input = 0;
		StringBuilder str = new StringBuilder();
		System.in.skip(1);
		input = read();
		System.in.skip(1);
		for (int i = 1; i < length; i++) {
			stack[i] = 0;
		}

		for (int i = 0; i < length; i++) {
			while (true) {
				if (index == input) {
					stack[index] = 2;
					index--;
					str.append("-").append("\n");
					break;
				}

				if (index != length && stack[index + 1] == 0) {
					index++;
					stack[index] = 1;
					str.append("+").append("\n");
				} else if (index > input) {
					index--;
					continue;
				} else {
					index++;
					continue;
				}
			}

			if (i != length - 1 && (input = read()) < index) {
				for (int j = input + 1; j <= index; j++) {
					if (stack[j] != 2) {
						str.setLength(0);
						str.append("\nNO");
						break;
					}
				}

				if (str.length() == 3)
					break;
			}
			System.in.skip(1);
		}

		System.out.print(str + "" + str.length());

	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}
