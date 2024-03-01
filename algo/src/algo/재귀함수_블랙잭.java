package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 재귀함수_블랙잭 {
    private static int[] cards;
    private static int N;
    private static int M;
	
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        cards = new int[N];
		
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	
            cards[i] = Integer.parseInt(st.nextToken());
            
        }
		
        System.out.println(solution(0, 0, 0));
    }
 
    private static int solution(int sum, int idx, int cnt) {
    	
        if(cnt == 3) {
        	
            return sum > M ? 0 : sum;
            
        }
        
        if(idx >= N) {
        	
            return 0;
            
        }
        
        int max = 0;
        
        for(int i = idx; i < N; i++) {
        	
            max = Math.max(max, solution(sum+cards[i], i+1, cnt+1));
            
        }
        
        return max;
    }
}