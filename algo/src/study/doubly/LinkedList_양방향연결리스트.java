package study.doubly;

class Node {
	String data;
	Node prev;
	Node next;

	Node() {

	}

	Node(String data) {
		this.data = data;
	}

}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	// 삽입
	// 제일 마지막에 삽입
	void addLast(String data) {

		Node newNode = new Node(data);

		// newNode 먼저 연결
		newNode.next = tail;
		newNode.prev = tail.prev;

		// newNode 양 옆에 있는 노드가 newNode를 가리키도록 바꿈
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;

		size++;
	}

	// 삭제
	void remove(int idx) {
		// idx 범위 확인
		if (!(0 <= idx && idx < size)) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}

		Node rmNode = head.next;

		for (int i = 0; i < idx; i++) {
			rmNode = rmNode.next;
		}
		// 반복문이 끝나면 curr는 삭제할 노드를 가리킴

		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;

		size--;
	}

	// 모든 데이터 조회
	void printList() {
		Node curr = head.next;
		while (curr != tail) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println();
	}
}

public class LinkedList_양방향연결리스트 {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		list.addLast("옥진석2");
		list.addLast("옥진석4");
		list.remove(1);
		list.printList();

	}

}
