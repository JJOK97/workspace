import java.util.*;

class Solution {
    static Map<String, PriorityQueue<String>> map = new HashMap<>();
    static List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] ticket : tickets){
            
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
            
        }
        
        dfs("ICN");
        
        Collections.reverse(result);
        return result.toArray(new String[result.size()]);
    }
    
    public static void dfs(String airport){
        
        PriorityQueue<String> pq = map.get(airport);
        
        while(pq != null && !pq.isEmpty()){
            String s = pq.poll();
            dfs(s);
        }
        
        result.add(airport);
        
    }
}