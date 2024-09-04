import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[][] board;

    static int[][][] dp;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(dfs( 0, 1, 0));
    }

    public static int dfs(int x, int y, int direction){

        if( x == N - 1 && y == N - 1 ) {
            return 1;
        }

        if(dp[x][y][direction] != 0){
            return dp[x][y][direction];
        }

        int count = 0;

        if(direction == 0 || direction == 2){
            if( y + 1 < N && board[x][y + 1] == 0){
                count += dfs( x, y + 1, 0);
            }
        }

        if(direction == 1 || direction == 2){
            if( x + 1 < N && board[x + 1][y] == 0){
                count += dfs(x + 1, y, 1);
            }
        }

        if(x + 1 < N && y + 1 < N && board[x + 1][y] == 0 && board [x][y + 1] == 0 && board[x + 1][y + 1] == 0){
            count += dfs(x + 1, y + 1, 2);
        }

        dp[x][y][direction] = count;
        return count;

    }

}