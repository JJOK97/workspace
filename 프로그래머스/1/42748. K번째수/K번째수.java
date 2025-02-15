import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = -1;
        
        for(int i = 0; i < commands.length; i++){
                
            int k = commands[i][1] - commands[i][0] + 1;

            int[] z = new int[k];
            
            int check = -1;
            

            for(int w = commands[i][0] - 1; w < commands[i][1]; w++){
                z[++check] = array[w];
            }

            Arrays.sort(z);
            answer[++index] = z[commands[i][2]-1];
            
        }
        
        return answer;
    }
}