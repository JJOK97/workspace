class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int i = n; i >= 1; i--){
            if(n % i == 1){
                min = min > i ? i : min;
            }
        }
        
        answer = min; 
        
        return answer;
    }
}