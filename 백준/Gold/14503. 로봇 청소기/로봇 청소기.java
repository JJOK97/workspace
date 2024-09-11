import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1}; // 북, 동, 남, 서
    static int N, M, cr, cc, dir, cnt;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        cr = Integer.parseInt(st.nextToken());
        cc = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if(tmp == 1) visited[i][j] = true;
            }
        }

        cnt = 0;

        while(true) {
            // 1. 현재 칸이 더러울 경우
            if(isDirty(cr,cc)) {
                cnt++;
            }

            // 2. 주변 4칸 모두 깨끗할 경우
            if(isAllClean(cr, cc)) {
                // 2-1. 후진할 수 있다면 후진하고 1번으로 돌아감
                if(canGoBack(cr, cc)) {
                    continue;
                    // 2-2. 뒤쪽이 벽이라면 작동 멈춤
                } else {
                    break;
                }
            }
            // 3. 주변이 더러울 경우
            else {
                // 3-1. 반시계 방향 회전
                dir = (dir + 3) % 4;
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                // 3-2. 앞 칸이 청소되지 않은 빈 칸일 경우 전진
                if(dirCheck(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
                    cr = nr;
                    cc = nc;
                }
                // 3-3. 1번으로 돌아감
            }
        }
        System.out.println(cnt);
    }

    static boolean isDirty(int r, int c) {
        if(map[r][c] == 0 && !visited[r][c]) {
            visited[r][c] = true;
            return true;
        }
        return false;
    }

    static boolean isAllClean(int r, int c) {
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(dirCheck(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
                return false;
            }
        }
        return true;
    }

    static boolean canGoBack(int r, int c) {
        int backDir = (dir + 2) % 4;
        int nr = r + dr[backDir];
        int nc = c + dc[backDir];
        if(dirCheck(nr, nc) && map[nr][nc] == 0) {
            cr = nr;
            cc = nc;
            return true;
        }
        return false;
    }

    public static boolean dirCheck(int nX, int nY){
        return 0 <= nX && 0 <= nY && nX < N && nY < M;
    }
}