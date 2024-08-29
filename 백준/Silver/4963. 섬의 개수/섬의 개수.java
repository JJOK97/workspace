import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dY = {-1, 0, 1, -1, 1, -1, 1, 0};
    static int count = 0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = -1;
        int y = -1;

        while(true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            if(x == 0 && y == 0){
                break;
            }

            int[][] map = new int[x][y];
            boolean[][] check = new boolean[x][y];
            count = 0;

            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < y; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (!check[i][j] && map[i][j] == 1) {
                        bfs(i, j, map, check, x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }


    }

    public static void bfs(int sX, int sY, int[][] map, boolean[][] check, int x, int y){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(map[sX][sY]);
        check[sX][sY] = true;

        while(!queue.isEmpty()){

            queue.poll();

            for(int i = 0; i < 8; i++){
                int nX = sX + dX[i];
                int nY = sY + dY[i];

                if(0 <= nX && nX < x && 0 <= nY && nY < y && map[nX][nY] == 1 && !check[nX][nY]){
                    queue.add(map[nX][nY]);
                    check[nX][nY] = true;
                    bfs(nX, nY, map, check, x, y);
                }

            }

        }


    }

}