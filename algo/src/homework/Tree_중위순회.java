package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree_중위순회 {

    static char[] tree;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < 11; i++) {
            int N = Integer.parseInt(br.readLine().trim());

            tree = new char[N+1];

            tree[0] = '\0';


            for (int j = 1; j <= N; j++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());

                String token = st.nextToken();
                tree[j] = token.charAt(0);

            }

            System.out.print("#" + i + " ");
            inorder(1, N);
            System.out.println();

        }
    }

    // 중위 순회
    // LVR
    static void inorder(int i, int N) {
        if (i <= N && tree[i] != 0) {
            // 왼쪽 자식
            inorder(i * 2, N);
            // 부모 노드 방문(출력)
            System.out.print(tree[i]);
            // 오른쪽 자식
            inorder(i * 2 + 1, N);
        }
    }

}
