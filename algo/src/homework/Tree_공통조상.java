package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Nod {
	int number;
	int data;
	Nod left;
	Nod right;

	Nod() {
	}

	Nod(int number) {
		this.number = number;
	}

	Nod(int number, int data) {
		this.number = number;
		this.data = data;
	}
}

public class Tree_공통조상 {

	static Nod findV(Nod root, int x, int y) {
		
		if (root == null || root.number == x || root.number == y) {
			return root;
		}

		Nod left = findV(root.left, x, y);
		Nod right = findV(root.right, x, y);

		if (left != null && right != null) {
			return root;
		}

		return (left != null) ? left : right;
	}

	static int size(Nod node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			Nod[] nodes = new Nod[V + 1];

			for (int i = 1; i <= V; i++) {
				nodes[i] = new Nod(i);
			}

			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= E; i++) {

				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				if (nodes[p].left == null) {
					nodes[p].left = nodes[c];
				} else {
					nodes[p].right = nodes[c];
				}
			}

			Nod root = nodes[1];
			Nod findV = findV(root, x, y);

			int size = size(findV);

			System.out.printf("#%d %d %d\n", tc, findV.number, size);
		}
	}
}
