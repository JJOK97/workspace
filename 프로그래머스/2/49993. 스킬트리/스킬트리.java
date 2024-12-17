import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] skills = skill.split("");
        Set<String> hs = new HashSet<>();

        for(String s : skills){
            hs.add(s);
        }

        for(String skillTree : skill_trees){
            Stack<String> sk = new Stack<>();
            for(int i = skills.length-1; i >= 0; i--){
                sk.push(skills[i]);
            }

            boolean isValid = true;
            for(char c : skillTree.toCharArray()) {
                String currentSkill = String.valueOf(c);

                if(hs.contains(currentSkill)) {
                    if(sk.isEmpty() || !currentSkill.equals(sk.peek())) {
                        isValid = false;
                        break;
                    }
                    sk.pop();  
                }
            }

            if(isValid) {
                answer++;
            }
        }

        return answer;
    }
}