import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer((br.readLine()));
            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] min = new int[N][3];

        min[0][0] = map[0][0];
        min[0][1] = map[0][1];
        min[0][2] = map[0][2];

        int[][] max = new int[N][3];

        max[0][0] = map[0][0];
        max[0][1] = map[0][1];
        max[0][2] = map[0][2];

        for(int i = 1; i < N; i++){
            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + map[i][0];
            min[i][1] = Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + map[i][1];
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + map[i][2];

            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + map[i][0];
            max[i][1] = Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]) + map[i][1];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + map[i][2];
        }

        int minResult = Math.min(Math.min(min[N-1][0], min[N-1][1]), min[N - 1][2]);
        int maxResult = Math.max(Math.max(max[N-1][0], max[N-1][1]), max[N - 1][2]);

        System.out.println(maxResult + " " + minResult);
    }

}