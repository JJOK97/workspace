package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수학_직사각형 {

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=1; i<n+1; i++)
			for(int j=1; j<=i; j++)
				if(i*j <= n)
					cnt++;
		System.out.println(cnt);
    }
}
