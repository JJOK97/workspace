package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열_원재의메모리복구 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int index = 1; index <= T; index++) {
			StringBuilder sb = new StringBuilder(br.readLine());

			int result = 0;
			for (int i = 0; i < sb.length(); i++) {

				result = 복구(i); 
						
			}

			System.out.printf("#%d %d", index, result);
			System.out.println();
		}
	}

	public static int 복구(int i) {
		
		int result = 0;
		
		
		
		return result;
		
	}

}
