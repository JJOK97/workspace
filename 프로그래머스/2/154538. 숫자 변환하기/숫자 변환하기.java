class Solution {
    
    private final static int MAX = Integer.MAX_VALUE;
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        
        int[] dp = new int[y + 1];
        
        for(int i = x + 1; i < y + 1; i++){
            int a = MAX, b = MAX, c = MAX, d;
            if (isDivided(i, 2) && aboveX(x, i / 2)) a = dp[i / 2];
            if (isDivided(i, 3) && aboveX(x, i / 3)) b = dp[i / 3];
            if (aboveX(x, i - n)) c = dp[i - n];
            
            d = Math.min(a, b);
            d = Math.min(d, c);
            
            dp[i] = ( d < MAX ) ? d + 1 : MAX;
            
        }
        
        answer = (dp[y] < MAX) ? dp[y] : -1;
        
        return answer;
    }
    
    private static boolean aboveX(int x, int num){
        return (num >= x);
    }
    
    private static boolean isDivided(int num, int divide){
        return ( num / divide > 0 && num % divide == 0 );
    }
}