package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 시간복잡도_수행시간5 {

	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());
		
		long sum = n*n*n;

		System.out.println(sum);

		System.out.println(3);
		
		br.close();
	}

}
