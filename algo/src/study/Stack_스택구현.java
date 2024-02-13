package study;

import java.util.Stack;

public class Stack_스택구현 {

	static int[] stack = new int[5];
	static int top = -1;

	public static void main(String[] args) {
		
		Stack<Integer> intStack = new Stack<>();
		
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		push(6);
		
		System.out.println(intStack);
	}

	// 스택이 비었는지 확인 : isEmpty
	public static boolean isEmpty() {
		return top == -1;
	}

	// 스택이 찼는지 확인 : isFull
	public static boolean isFull() {
		return top == stack.length - 1;
	}

	// 삽입
	public static void push(int data) {
		if (isFull()) {
			System.out.println("더 이상 추가 할 수가 없습니다.");
			return;
		}
		stack[++top] = data;
	}

	// 삭제
	public static int pop() {
		if (isEmpty()) {
			System.out.println("더 이상 뽑을 데이터가 없습니다.");
			return Integer.MIN_VALUE;
		}
		return stack[top--];
	}

}
