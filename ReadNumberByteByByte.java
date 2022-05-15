import java.io.IOException;

public class ReadNumberByteByByte {

	public static void main(String[] args) throws IOException {
		int n = read();
	}

	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) // ASCII 코드상 10은 개행(Enter), 32는 " "(스페이스바)이다.
			n = (n << 3) + (n << 1) + (c & 15); // 엔터나 스페이스바가 들어오기 전까지 몇 자리가 되었든 숫자를 n으로 반환하는 함수
		return n;
	}
}
