import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][N][3]; // 3차원 배열로 dp 선언 (가로, 세로, 대각선 방향)

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 1, 0)); // 0, 1에서 가로(0) 상태로 시작
    }

    // dfs로 경로를 탐색하면서 dp 테이블을 갱신
    public static int dfs(int x, int y, int direction) {
        // 종료 조건: 도착점에 도달하면 경로 1개 반환
        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        // 이미 계산된 경로가 있다면 그 값을 반환
        if (dp[x][y][direction] != 0) {
            return dp[x][y][direction];
        }

        int count = 0;

        // 가로 방향일 때
        if (direction == 0 || direction == 2) {
            if (y + 1 < N && board[x][y + 1] == 0) {
                count += dfs(x, y + 1, 0); // 가로 이동
            }
        }

        // 세로 방향일 때
        if (direction == 1 || direction == 2) {
            if (x + 1 < N && board[x + 1][y] == 0) {
                count += dfs(x + 1, y, 1); // 세로 이동
            }
        }

        // 대각선으로 이동할 수 있는지 확인
        if (x + 1 < N && y + 1 < N && board[x + 1][y] == 0 && board[x][y + 1] == 0 && board[x + 1][y + 1] == 0) {
            count += dfs(x + 1, y + 1, 2); // 대각선 이동
        }

        // 계산된 경로 수를 DP 테이블에 저장
        dp[x][y][direction] = count;
        return count;
    }
}