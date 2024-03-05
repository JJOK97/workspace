package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 브루트포스_난쟁이 {

	static int[] dwarfs = new int[9];
	static boolean[] result = new boolean[9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(dwarfs);

		findShort(0, 0, 0);

		for (int i = 0; i < 9; i++) {
			if (result[i])
				System.out.println(dwarfs[i]);
		}
	}

	static boolean findShort(int index, int count, int sum) {

		if (index > 9)
			return false;
		
		if (sum > 100)
			return false;

		if (count == 7 && sum == 100)
			return true;

		for (int i = index; i < 9; i++) {
			result[i] = true;
			if (findShort(i + 1, count + 1, sum + dwarfs[i]))
				return true;
			result[i] = false;
		}

		return false;
	}
}
