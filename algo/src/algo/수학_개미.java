package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학_개미 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		String[] antCor = br.readLine().split(" ");

		int time = Integer.parseInt(br.readLine());

		int[] result = new int[2];

		for (int i = 0; i < 2; i++) {
			result[i] = Integer.parseInt(antCor[i]);
		}

		String way = "북동";

		for (int i = 0; i < time; i++) {

			switch (way) {
			case "북동":

				result[0]++;
				result[1]++;

				if (result[0] == x && result[1] == y) {
					way = "남서";
				} else if (result[0] == x) {
					way = "북서";
				} else if (result[1] == y) {
					way = "동남";
				}

				break;

			case "동남":
				result[0]++;
				result[1]--;

				if (result[0] == x && result[1] == 0) {
					way = "북서";
				} else if (result[0] == x) {
					way = "남서";
				} else if (result[1] == 0) {
					way = "북동";
				}
				break;

			case "북서":
				result[0]--;
				result[1]++;
				if (result[0] == 0 && result[1] == y) {
					way = "동남";
				} else if (result[0] == 0) {
					way = "북동";
				} else if (result[1] == y) {
					way = "남서";
				}

				break;

			case "남서":
				result[0]--;
				result[1]--;
				if (result[0] == 0 && result[1] == 0) {
					way = "북동";
				} else if (result[0] == 0) {
					way = "동남";
				} else if (result[1] == 0) {
					way = "북서";
				}
				 
				break;

			}

		}

		for (int i : result) {
			System.out.print(i + " ");
		}

	}

}
