package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구현_경비원 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		int market = Integer.parseInt(br.readLine());

		int maxDistance = 2 * width + 2 * height;

		int[] marketDistance = new int[market];
		int result = 0;

		for (int i = 0; i < market; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			switch (N) {

			case 1:
				marketDistance[i] = M;
				break;
			case 2:
				marketDistance[i] = width + height + (width - M);
				break;
			case 3:
				marketDistance[i] = width + height + width + (height - M);
				break;
			case 4:
				marketDistance[i] = width +  M;
				break;
				
			}

		}

		int dg = 0;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		switch (N) {

		case 1:
			dg = M;
			break;
		case 2:
			dg = width + height + (width - M);
			break;
		case 3:
			dg = width + height + width + (height - M);
			break;
		case 4:
			dg = width + M;
			break;

		}

		for (int i = 0; i < market; i++) {

			if (marketDistance[i] <= dg) {
				result += (dg - marketDistance[i]) < (maxDistance - dg) + marketDistance[i] ? dg - marketDistance[i]
						: (maxDistance - dg) + marketDistance[i];
			} else {
				result += (marketDistance[i] - dg) < (maxDistance - marketDistance[i]) + dg ? marketDistance[i] - dg
						: (maxDistance - marketDistance[i]) + dg;
			}
		}
		
		System.out.println(result);

	}

}
