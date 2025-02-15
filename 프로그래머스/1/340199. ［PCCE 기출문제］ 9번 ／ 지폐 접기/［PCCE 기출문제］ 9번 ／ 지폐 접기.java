class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
         
        int min = Math.min(wallet[0], wallet[1]);
        int max = Math.max(wallet[0], wallet[1]);
        
        int billMin = Math.min(bill[0], bill[1]);
        int billMax = Math.max(bill[0], bill[1]);
  
        while(billMin > min || billMax > max){
            
            if(bill[0] > bill[1]){
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
                            
            billMin = Math.min(bill[0], bill[1]);
            billMax = Math.max(bill[0], bill[1]);
            
            answer++;
        }
        
        return answer;
    }
}