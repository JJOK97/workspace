package study;

public class Queue_구현 {

	static int[] queue = new int[10];
	static int front = -1, rear = -1;

	public static void main(String[] args) {

		for (int i = 0; i < 11; i++) {
			enQueue(100);
		}

		int peekData = Qpeek();
		System.out.println(peekData);

	}

	// 포화상태 확인
	public static boolean isFull() {
		// 데이터가 추가로 들어갈 수 있는지 확인 -> rear
		return rear == queue.length - 1;
	}

	// 공백상태 확인
	public static boolean isEmpty() {
		// 빠져나올 데이터가 있는지 확인 -> front
		return front == rear;
	}

	// 삽입할 때 실패여부 확인을 위해 boolean타입으로 반환 가능
	public static void enQueue(int data) {
		// 삽입 : rear
		if (isFull()) {
			System.out.println("큐가 차있어요");
			return;
		}
		queue[++rear] = data;
	}

	public static int deQueue(int data) {
		// 삭제 : front
		if (isEmpty()) {
			System.out.println("큐가 비어있어요");
			return -1;
		}
		return queue[++front];
	}

	// 삭제하기 전에 삭제될 데이터를 확인하는 연산
	public static int Qpeek() {
		// front포인터를 변경 시킬 필요 없다.
		if (isEmpty()) {
			System.out.println("큐가 비어있어요");
			return -1;
		}
		return queue[front + 1];
	}

}
