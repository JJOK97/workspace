package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구현_롤케이크 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 길이
		int L = Integer.parseInt(br.readLine());

		// 방청객 수
		int N = Integer.parseInt(br.readLine());

		// 원하는 조각 수
		int[][] audience = new int[N+1][2];
		int[] needs = new int[N+1];

		for (int index = 0; index < N; index++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 2; i++) {
				audience[index][i] = Integer.parseInt(st.nextToken());
			}

			needs[index] = audience[index][1] - audience[index][0] + 1;

		}

		// 예상 최대 방청객
		int result = -1;
		int max = -1;

		for (int i = 0; i < N; i++) {

			if (needs[i] > max) {
				result = i + 1;
				max = needs[i];
			}

		}

		System.out.println(result);

		// 실제 최대 방청객
		boolean[] roll = new boolean[L+1];
		int[] cut = new int[N];

		for (int index = 0; index < N; index++) {
			int count = 0;

			for (int i = audience[index][0]; i <= audience[index][1]; i++) {
				if (!roll[i]) {
					roll[i] = true;
					count++;
				}
			}

			cut[index] = count;

		}

		result = -1;
		max = -1;

		for (int i = 0; i < N; i++) {

			if (cut[i] > max) {
				result = i + 1;
				max = cut[i];
			}

		}

		System.out.println(result);
	}

}
