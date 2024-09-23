import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // 입력 받기
            int N = sc.nextInt(); // 물건의 수
            int K = sc.nextInt(); // 배낭이 버틸 수 있는 최대 무게

            int[] dp = new int[K + 1]; // DP 배열 초기화
            int[] weight = new int[N]; // 물건의 무게 배열
            int[] value = new int[N];  // 물건의 가치 배열

            // 물건의 무게와 가치를 입력 받기
            for (int i = 0; i < N; i++) {
                weight[i] = sc.nextInt();
                value[i] = sc.nextInt();
            }

            // 동적 계획법을 통한 최대 가치 계산
            for (int i = 0; i < N; i++) {
                // 무게가 K부터 weight[i]까지 역순으로 계산
                for (int j = K; j >= weight[i]; j--) {

                    int a = dp[j];
                    int b = dp[j - weight[i]] + value[i];

                    dp[j] = Math.max(a, b);
                }
            }

            // 결과 출력: 배낭에 넣을 수 있는 물건들의 최대 가치
            System.out.println(dp[K]);

            sc.close();
        }

}