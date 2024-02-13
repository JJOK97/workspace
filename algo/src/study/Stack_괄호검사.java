package study;

import java.util.Stack;

public class Stack_괄호검사 {

	public static void main(String[] args) {
		String text = "()()((()))";

		Stack<Character> stack = new Stack<>();

		boolean isOk = true;

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c == '(') {
				stack.add(c);
			} else {
				if (stack.isEmpty()) {
					System.out.println("닫는 괄호가 많습니다.");
					isOk = false;
					break;
				}
				stack.pop();
			}
		}

		// 다 끝난 후 스택이 비어있는지 확인
		if (isOk) {
			if (stack.isEmpty()) {
				System.out.println("짝이 맞습니다.");
			} else {
				System.out.println("여는 괄호가 많습니다.");
			}
		}

	}

}
