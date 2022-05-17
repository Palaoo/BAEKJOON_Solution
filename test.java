
public class test {

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

		
		
		
			
		
		System.out.print(str);

	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}
