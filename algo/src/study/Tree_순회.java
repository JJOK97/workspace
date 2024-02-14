package study;

public class Tree_순회 {

	// 트리 배열로 표현
	static char[] tree = new char[] { '\0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'I' };

	public static void main(String[] args) {
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		preorder(1);
	}

	// 전위 순회
	// VLR
	static void preorder(int i) {

		if (tree.length <= i || tree[i] == 0) {
			return;
		}

		// 부모 노드 방문(출력)
		System.out.print(tree[i] + " ");

		// 왼쪽 자식
		preorder(i * 2);
		// 오른쪽 자식
		preorder(i * 2 + 1);
	}

	// 중위 순회
	// LVR
	static void inorder(int i) {
		if (tree.length <= i || tree[i] == 0) {
			return;
		}
		// 왼쪽 자식
		inorder(i * 2);
		// 부모 노드 방문(출력)
		System.out.print(tree[i] + " ");
		// 오른쪽 자식
		inorder(i * 2 + 1);
	}

	// 후위 순회
	// RVL
	static void postorder(int i) {
		if (tree.length <= i || tree[i] == 0) {
			return;
		}

		// 왼쪽 자식
		postorder(i * 2);
		// 오른쪽 자식
		postorder(i * 2 + 1);
		
		// 부모 노드 방문(출력)
		System.out.print(tree[i] + " ");

	}

}
