import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer> q = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int result = 0;

		while (!q.isEmpty()) {

			if (q.size() > 1) {
				q.poll();

				int data = q.peek();

				q.add(data);

				q.poll();
			} else {
				result = q.peek();
				break;
			}

		}

		System.out.println(result);

	}

}