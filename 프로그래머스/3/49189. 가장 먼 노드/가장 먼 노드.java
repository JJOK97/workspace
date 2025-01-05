import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 1. 그래프 생성: 각 노드의 인접 노드를 저장할 ArrayList 배열
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 양방향 간선 정보 저장
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]); // 양방향이므로 both ways로 추가
        }

        // 3. 각 노드까지의 최단 거리를 저장할 배열
        int[] distance = new int[n + 1];
        // 방문하지 않은 노드는 -1로 초기화
        Arrays.fill(distance, -1);

        // 4. BFS 시작
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 시작점인 1번 노드 추가
        distance[1] = 0; // 시작점의 거리는 0

        // 최대 거리를 저장할 변수
        int maxDistance = 0;

        // BFS 실행
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 노드의 모든 인접 노드 확인
            for (int next : graph[current]) {
                // 아직 방문하지 않은 노드라면
                if (distance[next] == -1) {
                    // 현재 노드의 거리 + 1을 저장
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                    // 최대 거리 업데이트
                    maxDistance = Math.max(maxDistance, distance[next]);
                }
            }
        }

        // 5. 최대 거리에 해당하는 노드의 개수 계산
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }

        return count;
    }
}