package study;

import java.util.Scanner;

class Node {

	int num;
	Node left;
	Node right;

	Node() {
	};

	Node(int data) {
		this.num = data;
	}

}

public class Tree_연습문제 {

	static Node[] nodes = new Node[14];
	static int[] count = new int[14];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i < 14; i++) {
			nodes[i] = new Node();
			nodes[i].num = i;
		}
		int V = sc.nextInt();
		// v - 1개 간선의 정보가 주어진다.
		for (int i = 0; i < V - 1; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();

			count[child]++;

			if (nodes[parent].left == null) {
				nodes[parent].left = nodes[child];
			} else {
				nodes[parent].right = nodes[child];
			}
			nodes[parent].left = nodes[child];
		}

		int root = -1;

		for (int i = 1; i < 14; i++) {
			if (count[i] == 0) {
				root = i;
			}
		}

		preorder(nodes[root]);

		sc.close();

	}

	// 전위 순회
	// VLR
	static void preorder(Node node) {

		if (node == null) {
			return;
		}

		System.out.println(node.num);
		preorder(node.left);
		preorder(node.right);

	}

}
