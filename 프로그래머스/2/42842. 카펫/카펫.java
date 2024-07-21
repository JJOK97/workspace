class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int sum = brown + yellow;
        
        for(int i = 1; i <= sum; i++){
            if(sum % i == 0){
                int j = sum / i;
                if((i-2) * (j-2) == yellow) {
                    answer = new int[]{j, i};
                    break;
                }
            }
        }
        
        return answer;
    }
}

// brown, yellow의 약수중에
// x - 2 * y - 2 = yellow인거