import java.io.IOException;

public class Solution10845 {
	static int[] queue;
	static int first;
	static int last;

	public static void main(String[] args) throws Exception {
		int N = read();
		queue = new int[N];
		first = 0;
		last = -1;
		
	}

	static void push() throws Exception {
		
		queue[++last] = read();
	}

	static int readInstr() throws Exception {
		System.in.skip(1);
		int n;
		switch (n = System.in.read()) {
		case 117:
			System.in.skip(3);
			push();
			break;
		case 111:
			System.in.skip(3);
			pop();
			break;
		case 105:
			System.in.skip(4);
			size();
			break;
		case 109:
			System.in.skip(5);
			empty();
			break;
		case 110:
			System.in.skip(5);
			front();
			break;
		case 97:
			System.in.skip(4);
			back();
			break;
		}

		return n;
	}

	static void back() {

	}

	static void front() {

	}

	static void empty() {

	}

	static void size() {

	}

	static void pop() {

	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		System.in.skip(1);
		return n;
	}

}
