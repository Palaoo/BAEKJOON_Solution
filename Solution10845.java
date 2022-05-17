
public class Solution10845 {
	static int[] queue;
	static int first;
	static int last;
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = read();
		queue = new int[N];
		first = 0;
		last = -1;

		for (int i = 0; i < N; i++) {
			readInstr();
		}
		System.out.print(str);
	}

	static void push() throws Exception {
		queue[++last] = read();
	}

	static void readInstr() throws Exception {
		System.in.read();
		switch (System.in.read()) {
		case 117:
			System.in.read();
			System.in.read();
			System.in.read();
			push();
			break;
		case 111:
			System.in.read();
			System.in.read();
			pop();
			break;
		case 105:
			System.in.read();
			System.in.read();
			System.in.read();
			size();
			break;
		case 109:
			System.in.read();
			System.in.read();
			System.in.read();
			System.in.read();
			empty();
			break;
		case 114:
			System.in.read();
			System.in.read();
			System.in.read();
			System.in.read();
			front();
			break;
		case 97:
			System.in.read();
			System.in.read();
			System.in.read();
			back();
			break;
		}

	}

	static void back() {
		if (first > last)
			str.append(-1).append("\n");
		else
			str.append(queue[last]).append("\n");
	}

	static void front() {
		if (first > last)
			str.append(-1).append("\n");
		else
			str.append(queue[first]).append("\n");
	}

	static void empty() {
		if (first > last)
			str.append(1).append("\n");
		else
			str.append(0).append("\n");
	}

	static void size() {
		str.append(last - first + 1).append("\n");
	}

	static void pop() {
		if (first > last)
			str.append(-1).append("\n");
		else
			str.append(queue[first++]).append("\n");
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}
