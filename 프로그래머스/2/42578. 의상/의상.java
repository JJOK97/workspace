import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        for(String[] item : clothes){
            String type = item[1];
            
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        for(int count : clothesMap.values()){
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}