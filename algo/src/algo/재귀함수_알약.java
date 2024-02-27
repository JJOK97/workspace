package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 재귀함수_알약 {

	static int N,  W, H;
	static long count = 0;
	static long[][] day;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			
			count = 0; W = 0; H = 0;
			
			countPill(N, 0);
			
			System.out.println(count);
		}
		
	}

	public static void countPill(int W, int H) {

		countPill(W-1, H+1);
		
	}

}
