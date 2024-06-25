import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}

		Stack<Integer> wait = new Stack<>();
		Stack<Integer> result = new Stack<>();

		while (q.peek() != 1) {
			wait.add(q.poll());
		}

		result.add(q.poll());

		while (!q.isEmpty()) {

			int before = result.peek();

			if (!wait.isEmpty()) {
				if (before + 1 == wait.peek()) {
					result.add(wait.pop());
				} else if (before + 1 == q.peek()) {
					result.add(q.poll());
				} else {
					wait.add(q.poll());
				}
			} else {
				if (before + 1 == q.peek()) {
					result.add(q.poll());
				} else {
					wait.add(q.poll());
				}
			}

		}

		while(!wait.isEmpty()) {
			int before = result.peek();
			
			if(before + 1 == wait.peek()) {
				result.add(wait.pop());
			} else {
				break;
			}
			
		}
		
		if(!wait.isEmpty()) {
			System.out.println("Sad");
		} else {
			System.out.println("Nice");
		}
	}

}