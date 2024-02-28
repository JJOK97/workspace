package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분할정복_거듭제곱 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {

			int T = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			System.out.printf("#%d %d\n", i, pow(N, M));

		}

	}

	static int pow(int N, int M) {

		// 기저 조건
		if (M == 1)
			return N;

		int tmp = pow(N, M / 2);
		// 재귀 부분 : 짝수일때와 아닐때를 나누어서 생각 하겠다.
		if (M % 2 == 0) {
			return tmp * tmp;
		} else {
			return tmp * tmp * N;
		}
	}

}
