package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시간복잡도_점근적표기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		
		if(a1 * n + a2 <= c * n && c >= a1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
	}

}
