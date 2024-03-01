package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 브루트포스_View {

	static String[] building;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int index = 1; index < 11; index++) {

			int T = Integer.parseInt(br.readLine());

			building = br.readLine().split(" ");

			int result = 0;

			for (int i = 2; i < T - 2; i++) {

				int[] compare = new int[5];

				compare[0] = Integer.parseInt(building[i - 2]);
				
				compare[1] = Integer.parseInt(building[i - 1]);
				
				compare[2] = Integer.parseInt(building[i]);
				
				compare[3] = Integer.parseInt(building[i + 1]);
				
				compare[4] = Integer.parseInt(building[i + 2]);
				
				int[] sorted = Arrays.stream(compare).sorted().toArray();
				
				if (sorted[4] == Integer.parseInt(building[i])) {
					result += sorted[4] - sorted[3];
				}

			}

			System.out.printf("#%d %d\n", index, result);
		}

	}

}
