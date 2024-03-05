package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 브루트포스_숫자야구 {

	static int[][] trial, ballCount;
	static int[] nums = new int[10];
	static int T, result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		trial = new int[T][3];
		ballCount = new int[T][2];

		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			String[] change = st.nextToken().split("");

			for (int j = 0; j < 3; j++) {
				trial[i][j] = Integer.parseInt(change[j]);
			}

			for (int j = 0; j < 2; j++) {
				ballCount[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		for (int index = 0; index < T; index++) {
			if (ballCount[index][0] != 0) {
				strikeCase(index, 0);
			}
		}

		System.out.println(result);

	}

	static void strikeCase(int index, int i) {
		

	}

}
