import java.util.*;
    
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] line : wires){
            int v1 = line[0];
            int v2 = line[1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        for(int[] line : wires){
            int v1 = line[0];
            int v2 = line[1];
            
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            int one = bfs(v1, graph, n);
            int diff = Math.abs(n-2*one);
            answer = Math.min(answer, diff);
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return answer;
    }
    
    private int bfs(int v1, List<List<Integer>> graph, int n){
        boolean check[] = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v1);
        check[v1] = true;
        int count = 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int line : graph.get(node)){
                if(!check[line]){
                    queue.add(line);
                    check[line] = true;
                }
            }
        }
        
        return count;
    }
}