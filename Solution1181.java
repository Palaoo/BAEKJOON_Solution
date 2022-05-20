import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1181 {
	static StringBuilder sb = new StringBuilder();
	static Node[] length = new Node[51];

	public static void main(String[] args) throws Exception {
		int N = read();
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution1181 t = new Solution1181();

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			if (length[str.length()] == null)
				length[str.length()] = t.new Node(str);
			else if (length[str.length()] != null) {
				length[str.length()] = length[str.length()].compareTo(str);
			}
		}

		for (int i = 1; i < 51; i++) {
			if (length[i] != null)
				length[i].append();
		}

		System.out.print(sb);
	}

	class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
		}

		Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}

		void append() {
			sb.append(this.data + "\n");
			if (this.next != null)
				this.next.append();
		}

		Node compareTo(String other) {
			byte[] thisB = this.data.getBytes(), otherB = other.getBytes();
			Node newN = length[other.length()];
			for (int k = 0; k < other.length(); k++) {
				if (thisB[k] > otherB[k]) {
					if (0 == this.search(length[other.length()], this.data, (newN = new Node(other, this))))
						return length[other.length()];
					else
						return newN;
				} else if (thisB[k] == otherB[k]) {
					continue;
				}
				else {
					if (this.next != null)
						return this.next.compareTo(other);
					else if (this.next == null)
						this.next = new Node(other);
				}
			}

			return newN;
		}

		int search(Node prev, String data, Node next) {
			int result = 0;
			if (prev.data == data) {
				return result = 1;
			} else if (prev.next.data == data) {
				prev.next = next;
				return result = 0;
			} else
				search(prev.next, data, next);
			return result;

		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		System.in.skip(1);
		return n;
	}
}
