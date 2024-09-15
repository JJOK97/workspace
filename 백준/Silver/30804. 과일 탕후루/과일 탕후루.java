import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        int left = 0, result = 0;

        for (int right = 0; right < N; right++) {
            set.add(fruits[right]);

            while (set.size() > 2) {
                set.remove(fruits[left]);
                left++;

                if (set.size() == 2 && !set.contains(fruits[left-1])) {
                    for (int i = left; i <= right; i++) {
                        set.add(fruits[i]);
                        if (set.size() > 2) break;
                    }
                }
            }

            result = Math.max(result, right - left + 1);
        }

        System.out.println(result);
    }
}