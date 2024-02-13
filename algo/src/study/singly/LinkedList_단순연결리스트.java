package study.singly;

class Node {
	String data;
	Node link;

	Node() {

	}

	Node(String data) {
		this.data = data;
		// link = null;
	}

}

class SinglyLinkedList {
	Node head;

	SinglyLinkedList() {
		head = new Node();
	}

	// 삽입
	// 제일 앞에 삽입
	void addFirst(String data) {

		Node newNode = new Node(data);

		newNode.link = head.link;
		head.link = newNode;

	}

	// 제일 뒤에 삽입
	void addLast(String data) {
		Node newNode = new Node(data);

		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		// 반복문이 끝나면 curr는 마지막 노드를 가리킴

		curr.link = newNode;
		// newNode가 마지막이 됨
	}

	// 중간 삽입
	void add(int idx, String data) {
		if (idx < 0 || getSize() < idx) {
			System.out.println("삽입 할 수 없는 위치입니다.");
			return;
		}
		
		Node curr = head;

		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		
		// curr가 삽입하고자 하는 위치 앞 노드를 가리킴
		Node newNode = new Node(data);
		
		newNode.link = curr.link;
		curr.link = newNode;
		
	}
	
	// 삭제
	void remove(int idx) {

		if (idx < 0 || getSize() <= idx) {
			System.out.println("삭제할 수 잇는 범위를 벗어났습빈다.");
			return;
		}

		Node curr = head;

		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}

		// 반복문이 끝나면 curr는 삭제할 노드 앞 노드를 가리킴
		curr.link = curr.link.link;

	}

	// 모든 데이터 조회
	void printList() {
		Node curr = head.link;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}
		System.out.println();
	}

	int getSize() {
		Node curr = head;
		int size = 0;
		while (curr != null) {
			curr = curr.link;
			size++;
		}
		return size;
	}
}

public class LinkedList_단순연결리스트 {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		list.addFirst("옥진석1");
		list.printList();
		list.addLast("옥진석2");
		list.printList();
		list.addFirst("옥진석3");
		list.addLast("옥진석4");
		list.add(4, "옥진석5");
		list.remove(1);
		list.printList();

	}

}
