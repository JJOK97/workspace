package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 시간복잡도_수행시간6 {

	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());

		long a = 0;
		long b = 0;
		
		for(int i = 1; i < n - 1; i++) {
			a += i;
			b += a;
		}
		
		System.out.println(b);
		System.out.println(3);
		
		br.close();
	}

}
