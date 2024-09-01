import java.io.*;
import java.util.*;

public class Main {

    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, 1, 0, -1};

    static int[][] map;
    static int[][] check;

    static int N, M, r, c, dir;

    static int result = 0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if( map[i][j] == 1 ){
                    check[i][j] = 1;
                }
            }
        }

        firstCase();

        System.out.println(result);

    }

    public static void firstCase(){

        if(check[r][c] == 0) {
            result++;
            check[r][c] = 2;
        }

        boolean checkMove = false;

        for(int i = 0; i < 4; i++){
            int nX = r + dX[i];
            int nY = c + dY[i];

            if(checkMap(nX, nY) && map[nX][nY] == 0 && check[nX][nY] == 0){
                checkMove = true;
                break;
            }
        }

        if(!checkMove){

            if(secondCase()){
                return;
            }

        } else {

            thirdCase();

        }
    }

    public static boolean secondCase(){

        int backDir = (dir + 2) % 4;
        int nX = r + dX[backDir];
        int nY = c + dY[backDir];

        if(checkMap(nX, nY) && map[nX][nY] == 0){
            r = nX;
            c = nY;
            firstCase();
        } else {
            return true;
        }

        return false;

    }

    public static void thirdCase(){

        for(int i = 0; i < 4; i++){
            dir = (dir + 3) % 4;
            int nX = r + dX[dir];
            int nY = c + dY[dir];

            if(checkMap(nX, nY) && map[nX][nY] == 0 && check[nX][nY] == 0){
                r = nX;
                c = nY;
                firstCase();
                return;
            }
        }

        firstCase();

    }

    public static boolean checkMap(int nX, int nY){
        return 0 <= nX && nX < N && 0 <= nY && nY < M;
    }

}