import java.util.*;

class Solution {
    
    // 이동 방향 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        return bfs(maps, n, m);
    }
    
    private int bfs(int[][] maps, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 시작 좌표 (0,0) 추가

        int[][] dist = new int[n][m]; // 거리 저장 배열
        boolean[][] visited = new boolean[n][m]; // 방문 여부 체크
        dist[0][0] = 1; // 시작점 거리 1
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            // 목표 지점 도착하면 거리 반환
            if (x == n - 1 && y == m - 1) {
                return dist[x][y];
            }

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크 && 방문 안 했으며 && 벽이 아닌 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1; // 이전 거리 +1
                }
            }
        }

        // 도달할 수 없는 경우
        return -1;
    }
}
