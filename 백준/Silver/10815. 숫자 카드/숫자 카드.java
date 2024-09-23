import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 입력: 상근이가 가진 숫자 카드의 개수 N
        int N = sc.nextInt();
        int[] cards = new int[N];

        // 두 번째 입력: 상근이가 가진 카드 리스트
        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        // 카드 리스트 정렬
        Arrays.sort(cards);

        // 세 번째 입력: 질문할 숫자의 개수 M
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        // 네 번째 입력: M개의 질문 숫자 리스트
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            // 이분 탐색으로 해당 숫자가 cards에 있는지 확인
            if (binarySearch(cards, target)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }

    // 이분 탐색 메소드
    public static boolean binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}