import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        String num = Long.toString(n);
        int[] answer = new int[num.length()];

        int index = 0;
        
        for (int i = num.length() - 1; i >= 0; i--) {
            answer[index++] = num.charAt(i) - '0';
        }

        return answer;
    }
}
