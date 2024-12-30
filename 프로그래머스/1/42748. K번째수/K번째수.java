import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int answerIndex = 0;
        
        for(int index = 0; index < commands.length; index++){
            
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];
            
            int size = j - i + 1;
            
            int[] num = new int[size];
            int arrIndex = 0;
            for(int start = i - 1; start < j; start++){
                num[arrIndex++] = array[start];
            }
            
            Arrays.sort(num);
            
            if(index < commands.length - 1){
                answer[answerIndex++] = num[k - 1];
            } else {
                answer[answerIndex] = num[k - 1];
            }
            
        }
        
        return answer;
    }
}