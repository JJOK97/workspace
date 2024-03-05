package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학_개미2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int antX = Integer.parseInt(st.nextToken());
		int antY = Integer.parseInt(st.nextToken());

		int time = Integer.parseInt(br.readLine());

		int rX = (antX + time) % x;
		int rY = (antY + time) % y;

		int[] antCor = new int[2];

		antCor[0] = ((antX + time) / x) % 2 == 0 ? rX : x - rX;
		antCor[1] = ((antY + time) / y) % 2 == 0 ? rY : y - rY;

		StringBuilder sb = new StringBuilder();
		
		for(int i : antCor) {
			sb.append(i).append(" ");
		}
		
		System.out.print(sb);
	}

}
