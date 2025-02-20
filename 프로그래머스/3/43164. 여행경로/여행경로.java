import java.util.*;

class Solution {
    
    static Map<String, PriorityQueue<String>> graph = new HashMap<>();
    static List<String> route = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
       
        for(String[] ticket : tickets){
            
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
            
        }
        
        dfs("ICN");
        
        Collections.reverse(route);
        return route.toArray(new String[route.size()]);
        
    }
    
    public static void dfs(String airport){
        
        PriorityQueue<String> pq = graph.get(airport);
        while (pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        
        route.add(airport);
        
    }

}