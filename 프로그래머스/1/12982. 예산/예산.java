import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 1;
        
        Arrays.sort(d);
        int sum = d[0];
        
        if(sum > budget) return 0; 
        
        for(int i = 1; i < d.length; i++){
            if(sum + d[i] > budget) break;
            else {
                sum += d[i];
                answer++;
            }
        }
        
        return answer;
    }
}