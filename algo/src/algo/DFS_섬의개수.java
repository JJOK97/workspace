package algo;

import java.util.*;
import java.io.*;

public class DFS_섬의개수 {
    static int map[][];
    static boolean visit[][];
    static int dirX[] = {0, 0, -1 ,1, -1, 1, -1, 1};
    static int dirY[] = {-1, 1, 0, 0, 1, 1, -1, -1};

    static int w, h, nowX, nowY;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = " ";
        while( !(str = br.readLine()).equals("0 0") ) {
            st = new StringTokenizer(str);

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visit = new boolean[h][w];

            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                }
            }

            int island_count = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {

                    if(!visit[i][j] && map[i][j] == 1) {
                        island_count++;
                        DFS(i, j);
                    }
                }
            }

            sb.append(island_count).append('\n');
        }

        System.out.println(sb);
    }

    static void DFS(int startX, int startY) {
    	
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        visit[startX][startY] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            for(int i=0; i<8; i++) {
                nowX = dirX[i] + x;
                nowY = dirY[i] + y;

                if(range_check() && !visit[nowX][nowY] && map[nowX][nowY] == 1) {
                    stack.push(new int[]{nowX, nowY});
                    visit[nowX][nowY] = true;
                }
            }
        }
    }

    static boolean range_check() {
        return (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w);
    }

}
