package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 진기붕어빵 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arrivalTimes = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrivalTimes[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrivalTimes);

            boolean possible = true;
            for (int i = 0; i < N; i++) {
                if (arrivalTimes[i] / M * K < i + 1) {
                    possible = false;
                    break;
                }
            }

            System.out.println("#" + t + " " + (possible ? "Possible" : "Impossible"));
        }
    }
}