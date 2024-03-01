package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학_도로와신호등 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] x = new int[N + 1][3];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				x[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		int result = 0;
		int j = 0;

		for (int i = 0; i < L; i++) {

			result++;

			if (i == (x[j][0] - 1)) {

				int T = result % (x[j][1] + x[j][2]);

				boolean check = T / x[j][1] == 0;

				if (check) {

					result += Math.abs(T - x[j][1]);

				}

				j++;

			}

		}

		System.out.println(result);
	}

}