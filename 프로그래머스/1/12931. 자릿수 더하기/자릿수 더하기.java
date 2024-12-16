import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int number = 100000000;
        int temp = 0;

        for ( int i = 0; i < 9; i++ ){

            temp = (n / number) * number;
            answer += n / number;
            n -= temp;

            number /= 10;

        }
        return answer;
    }
}