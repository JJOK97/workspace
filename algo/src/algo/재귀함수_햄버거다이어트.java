package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재귀함수_햄버거다이어트 {

	static int N, L, result;
	static int[] food, kcals;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int index = 1; index <= T; index++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			food = new int[N];
			kcals = new int[N];

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());

				kcals[i] = Integer.parseInt(st.nextToken());
				food[i] = Integer.parseInt(st.nextToken());

			}
			
			result = 0;

			pig(0, 0, 0);
			System.out.printf("#%d %d\n", index, result);
		}

	}

	public static void pig(int idx, int total, int sum) {

		
		if (total > L) return;

		if (idx >= N) {
			
			if(sum > result) {
				result = sum;
			}
			
			return;
		}
		
		pig(idx + 1, total + food[idx], sum + kcals[idx]);
		pig(idx + 1, total, sum);

	}

}
