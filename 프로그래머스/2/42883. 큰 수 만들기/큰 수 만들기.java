import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // 스택이 비어있지 않고, k가 0보다 크고, 
            // 스택의 top이 현재 숫자보다 작으면 제거
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // k가 남아있다면 스택의 뒤에서부터 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 결과 문자열 생성
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        
        return new String(result);
    }
}