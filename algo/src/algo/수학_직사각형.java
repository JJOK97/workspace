package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수학_직사각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 0;

		for (int i = 1; i <= N; i++)
			for (int j = i; i * j <= N; j++)
				count++;

		System.out.println(count);
	}
}
