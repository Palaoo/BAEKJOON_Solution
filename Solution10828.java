
public class Solution10828 {
	static int index = -1;
	static int[] stack;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		int N = read();
		System.in.skip(1);
		sb = new StringBuilder();
		stack = new int[N];
		
		for (int i = 0; i < N; i++) {
			switch (read()) {
			case 538:
				push();
				System.in.skip(1);
				break;
			case 150:
				pop();
				System.in.skip(1);
				break;
			case 4005:
				size();
				System.in.skip(1);
				break;
			case 63049:
				empty();
				System.in.skip(1);
				break;
			case 550:
				top();
				System.in.skip(1);
				break;
			}
		}

		System.out.print(sb);
	}

	static void push() throws Exception {
		stack[++index] = read();
	}

	static void pop() {
		if (index == -1)
			sb.append(-1).append("\n");
		else
			sb.append(stack[index--]).append("\n");
	}

	static void size() {
		sb.append(index + 1).append("\n");
	}

	static void empty() {
		if (index == -1)
			sb.append(1).append("\n");
		else
			sb.append(0).append("\n");
	}

	static void top() {
		if (index == -1)
			sb.append(-1).append("\n");
		else
			sb.append(stack[index]).append("\n");
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
