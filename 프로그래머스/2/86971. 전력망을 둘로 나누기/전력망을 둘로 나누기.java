import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        // 그래프를 인접 리스트 형태로 생성
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<= n; i++){
            graph.add(new ArrayList<>());    
        }
        
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        // 각 전선을 하나씩 제거하면서 최소 차이를 계산
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 전선 하나를 제거
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            // BFS를 이용해 한쪽 서브트리의 크기를 계산
            int subtreeSize = bfs(v1, graph, n);
            int another = n - subtreeSize;
            int difference = Math.abs(subtreeSize  - another);
            
            //비교
            answer = Math.min(answer, difference);
            
            // 제거한 전선을 다시 복구
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return answer;
    }
    
    // BFS
    private int bfs(int start, List<List<Integer>> graph, int n){
        // 송전탑이 1부터 시작인걸 고려
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;
        
        while (!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        return count;
        
    }
}