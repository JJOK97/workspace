import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] c = new char[s.length()];
            
        for(int i = 0; i < s.length(); i++){
           c[i] = s.charAt(i);
        }

        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < c.length; i++) {
            
            if(!st.isEmpty()) {
                if(c[i] == ')'){
                    if(st.peek() == '('){
                        st.pop();
                        continue;
                    } else {
                        answer = false;
                        break;
                    }
                } else {
                    st.add(c[i]);
                    continue;
                }
            } else {
                if(c[i] == '('){
                    st.add(c[i]);
                    continue;
                } else {
                    answer = false;
                    break;
                }
            }

        }
        
        if(!st.isEmpty()){
            answer = false;
        }
        return answer;
    }
}