package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Node {
    int number;
    String data;
    Node left;
    Node right;
 
    Node() {
 
    }
 
    Node(int number) {
        this.number = number;
    }
 
    Node(int number, String data) {
        this.number = number;
        this.data = data;
    }
}
 
public class Tree_사칙연산 {
 
    static boolean isOperation(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
 
    static int calculate(Node node) {
        if (node.data == null) {
            return 0;
        }
 
        if (!isOperation(node.data)) {
            return Integer.parseInt(node.data);
        }
 
        int l = calculate(node.left);
        int r = calculate(node.right);
 
        switch (node.data.charAt(0)) {
        case '+':
            return l + r;
        case '-':
            return l - r;
        case '*':
            return l * r;
        case '/':
            return l / r;
        }
 
        return -1;
    }
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
 
            Node[] nodes = new Node[N + 1];
 
            for (int i = 1; i <= N; i++) {
                nodes[i] = new Node(i);
            }
 
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Node node = nodes[Integer.parseInt(st.nextToken())];
                node.data = st.nextToken();
 
                if (isOperation(node.data)) {
                    node.left = nodes[Integer.parseInt(st.nextToken())];
                    node.right = nodes[Integer.parseInt(st.nextToken())];
                }
            }
             
            System.out.printf("#%d ", tc);
            System.out.println(calculate(nodes[1]));
 
        }
    }
 
}
