import java.io.IOException;

public class ReadNumberByteByByte {

	public static void main(String[] args) throws IOException {
		int n = read();
	}

	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) // ASCII �ڵ�� 10�� ����(Enter), 32�� " "(�����̽���)�̴�.
			n = (n << 3) + (n << 1) + (c & 15); // ���ͳ� �����̽��ٰ� ������ ������ �� �ڸ��� �Ǿ��� ���ڸ� n���� ��ȯ�ϴ� �Լ�
		return n;
	}
}
