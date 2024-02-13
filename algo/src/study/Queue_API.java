package study;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_API {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 실패했을 때 예외 발생
		queue.add(1);
		queue.remove();
		queue.element();
		
		// 예외 발생 X
		queue.offer(1); // false
		queue.poll(); // null
		queue.peek(); // null

	}

}
