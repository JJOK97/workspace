package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 브루트포스_주사위쌓기 {

	static int T, max, sum, result;
	static int[][] dice;
	static int[] path = { 5, 3, 4, 1, 2, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		dice = new int[T][6];

		for (int index = 0; index < T; index++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int row = 0; row < 6; row++) {

				dice[index][row] = Integer.parseInt(st.nextToken());

			}

		}

 

		for (int i = 0; i < 6; i++) {

			max = 0;
			sum = 0;

			int topPath = i;
			int downPath = path[i];

			for (int j = 0; j < 6; j++) {
				if (dice[0][j] != dice[0][topPath] && dice[0][j] != dice[0][downPath]) {
					max = dice[0][j] > max ? dice[0][j] : max;
				}
			}

			sum += max;

			for (int j = 1; j < T; j++) {

				max = 0;

				for (int k = 0; k < 6; k++) {

					if (dice[j][k] == dice[j - 1][topPath]) {

						downPath = k;
						topPath = path[k];
						break;

					}

				}

				for (int k = 0; k < 6; k++) {

					if (k != topPath && k != downPath) {
						max = dice[j][k] > max ? dice[j][k] : max;
					}

				}

				sum += max;

			}

			result = sum > result ? sum : result;

		}

		System.out.println(result);
	}

}
