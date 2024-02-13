package study;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Stack_계산기 {

	public static void main(String[] args) {

		Map<Character, Integer> priority = new HashMap<>();

		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);

		Scanner sc = new Scanner(System.in);

		String expression = sc.next();

		// 중위표기식 -> 후위표기식
		String postfix = "";
		Stack<Character> op = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (c == '(') {
				op.push(c);
			} else if (c == ')') {
				while (op.peek() != '(') {
					postfix += op.pop();
				}
				op.pop();
			} else if ('0' <= c && c <= '9') {
				postfix += c;
			} else {
				// +, -, *, /
				if (op.isEmpty()) {
					op.push(c);
				} else {
					// 우선순위가 낮은 연산자가 마지막에 위치할 때까지 pop
					while (!op.isEmpty() && priority.get(c) <= priority.get(op.peek())) {
						postfix += op.pop();
					}
					op.push(c);
				}
			}
		}
		System.out.println(postfix);
		sc.close();
	}

}
