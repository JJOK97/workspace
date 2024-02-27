package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재귀함수_블랙잭 {
	
	static int N,S;
	static int[] arr;
	static int  result = 0; 

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		blackJack(0, 0);
		System.out.println(result);

	}

	public static void blackJack(int index, int sum) {

		
		blackJack(index + 1, sum + arr[index]);
		blackJack(index + 1, sum);
			
	}

}
