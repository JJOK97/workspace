import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Set<String> set = new HashSet<>();
        
        // 모든 참가자와 완주자를 하나의 Set에 추가
        for (String part : participant) {
            if (!set.add(part)) {
                set.remove(part);
            }
        }
        
        for (String comp : completion) {
            if (!set.add(comp)) {
                set.remove(comp);
            }
        }
        
        // Set에 남아있는 유일한 요소가 완주하지 못한 선수
        return set.iterator().next();
    }
}