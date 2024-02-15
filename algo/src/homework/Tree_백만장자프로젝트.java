package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tree_백만장자프로젝트 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int index = 1; index <= T; index++) {

			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < N; i++) {
				stack.add(Integer.parseInt(st.nextToken()));
			}

			long result = 0;

			while (!stack.isEmpty()) {
				int pop = stack.pop();

				if (stack.isEmpty()) {
					break;
				}

				if (stack.peek() > pop) {
					continue;
				}

				while (!stack.isEmpty()) {
					if (stack.peek() < pop) {
						result += pop - stack.pop();
					} else {
						break;
					}
				}
			}

			System.out.printf("#%d %d\n", index, result);

		}

	}

}
