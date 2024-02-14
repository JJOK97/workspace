package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 시간복잡도_수행시간4 {

	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());
		
		long sum = (n*n-n)/2;

		System.out.println(sum);

		System.out.println(2);
		
		br.close();
	}

}
