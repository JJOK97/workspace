package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 브루트포스_영화감독숌 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int count = 0;
		int number = 665;

		while (count < N) {
			number++;
			if (String.valueOf(number).contains("666")) {
				count++;
			}
		}

		System.out.println(number);
	}

}
