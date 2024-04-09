package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_치즈2 {

    static int[] dx = { 0, 1, 0, -1 }; // 상하좌우 이동을 위한 x 좌표 변화량
    static int[] dy = { 1, 0, -1, 0 }; // 상하좌우 이동을 위한 y 좌표 변화량
    static boolean[][] visited; // 방문 여부를 저장하는 배열
    static int[][] board; // 치즈 판의 상태를 저장하는 배열
    static int n, m; // 치즈 판의 크기
    static int cheese; // 남은 치즈의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 치즈 판의 크기 입력 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        cheese = 0;

        // 치즈 판의 상태 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) // 치즈가 있는 칸인 경우 치즈 개수 증가
                    cheese++;
            }
        }

        int cheeseCount = 0; // 이전 시간대의 치즈 개수
        int time = 0; // 치즈가 모두 녹는데 걸리는 시간

        // 치즈가 모두 녹을 때까지 반복
        while (cheese != 0) {
            cheeseCount = cheese;
            time++;
            visited = new boolean[n][m]; // 방문 배열 초기화
            bfs(); // BFS 탐색으로 치즈 녹이기

            // 현재 시간대의 치즈 판 상태 출력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            // 현재 시간과 남은 치즈 개수 출력
            System.out.println("cheeseCount = " + cheeseCount);
            System.out.println("time = " + time);
        }

        // 치즈가 모두 녹은 시간과 이전 시간대의 치즈 개수 출력
        System.out.println(time);
        System.out.println(cheeseCount);
    }

    // BFS 탐색 메서드
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 }); // 출발 지점을 큐에 추가
        visited[0][0] = true; // 출발 지점 방문 표시

        while (!q.isEmpty()) {
            int[] current = q.poll(); // 현재 위치 꺼내기

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i]; // 다음 x 좌표 계산
                int ny = current[1] + dy[i]; // 다음 y 좌표 계산

                // 다음 위치가 범위 내에 있고, 아직 방문하지 않았다면
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true; // 방문 표시
                    if (board[nx][ny] == 0) { // 치즈가 없는 경우
                        q.offer(new int[] { nx, ny }); // 큐에 추가하여 탐색 계속
                    } else { // 치즈가 있는 경우
                        cheese--; // 치즈 개수 감소
                        board[nx][ny] =  0; // 치즈 녹음
                    }
                }
            }
        }
    }
}
