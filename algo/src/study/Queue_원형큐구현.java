package study;

import java.util.Arrays;

public class Queue_원형큐구현 {

	static String[] queue = new String[5];
	static int front = 0, rear = 0;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(queue));
		enQueue("옥진석");
		enQueue("옥진석");
		enQueue("옥진석");
		enQueue("옥진석");
		deQueue();
		deQueue();
		enQueue("옥진석");
		enQueue("김진석");
		System.out.println(Arrays.toString(queue));
	}

	// 공백상태
	// front와 rear가 같은 위치를 가리키고 있다.
	public static boolean isEmpty() {
		return front == rear;
	}

	// 포화상태
	// front가 rear보다 한 칸 앞서있는가를 확인
	public static boolean isFull() {
		return front == (rear + 1) % queue.length;
	}

	// 삽입
	public static void enQueue(String data) {
		if (isFull()) {
			System.out.println("큐가 포화상태입니다");
			return;
		}
		rear = (rear + 1) % queue.length;
		queue[rear] = data;
	}

	// 삭제
	public static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다");
			return null;
		}
		front = (front + 1) % queue.length;
		return queue[front];
	}

}
