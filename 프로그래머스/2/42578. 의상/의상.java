import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 0;
        
        Map<String, Integer> hashset = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            String cloth = clothes[i][1];
            
            hashset.put(cloth, hashset.getOrDefault(cloth, 0) + 1);
        }
        
        int[] dp = new int[hashset.size() + 1];
        
        dp[0] = 1;
        
        int i = 1;
        for(int v : hashset.values()){
            
            dp[i] = dp[i-1] * (v + 1); 
            i++;
                
        }
        
        
        return dp[dp.length-1] - 1;
    }
}