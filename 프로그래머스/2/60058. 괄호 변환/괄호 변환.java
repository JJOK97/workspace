import java.util.*;

class Solution {
    public static String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }

        int balance = 0;
        int splitIndex = 0;
        
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                splitIndex = i + 1;
                break;
            }
        }

        String u = p.substring(0, splitIndex);
        String v = p.substring(splitIndex);

        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            u = u.substring(1, u.length() - 1);
            sb.append(reverseBrackets(u));
            return sb.toString();
        }
    }

    private static boolean isCorrect(String str) {
        int balance = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    private static String reverseBrackets(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}