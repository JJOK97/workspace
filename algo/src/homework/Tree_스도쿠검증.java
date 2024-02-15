package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tree_스도쿠검증 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int arr[][] = new int[9][9];

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 1;

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 9; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 0; j < 9; j++) {
					rowSum += arr[i][j];
					colSum += arr[j][i];
				}

				if (rowSum != 45 || colSum != 45) {
					answer = 0;
					break;
				}
			}

			if (answer == 0) {
				System.out.println("#" + test_case + " " + answer);
				continue;
			}

			for (int i = 1; i <= 3; i++) {
				int squareSum = 0;
				for (int j = (i - 1) * 3; j < i * 3; j++) {
					for (int k = (i - 1) * 3; k < i * 3; k++) {
						squareSum += arr[j][k];
					}
				}
				if (squareSum != 45) {
					answer = 0;
					break;
				}
				if (answer == 0) {
					break;
				}
			}

			System.out.println("#" + test_case + " " + answer);
		}
	}

}
