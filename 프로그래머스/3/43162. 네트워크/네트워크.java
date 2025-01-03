import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!check[i]){
                // Queue를 for문 안에서 초기화
                Queue<Integer> network = new LinkedList<>();
                network.add(i);
                check[i] = true;  // 시작 노드 방문 처리
                
                while(!network.isEmpty()){
                    int now = network.poll();
                    for(int j = 0; j < n; j++){
                        if(computers[now][j] == 1 && !check[j]){
                            network.add(j);
                            check[j] = true;  // 방문 처리
                        }
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}