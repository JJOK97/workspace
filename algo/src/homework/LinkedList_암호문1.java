package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LinkedList_암호문1 {

	static LinkedList<Integer> code;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int index = 1; index <= 10; index++) {
			int T = Integer.parseInt(br.readLine());

			code = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < T; i++) {
				code.addLast(Integer.parseInt(st.nextToken()));
			}

			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				st.nextToken();
				int position = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for (int j = 0; j < count; j++) {
					code.add(position, Integer.parseInt(st.nextToken()));
					position++;
				}
			}

			System.out.printf("#%d ", index);
			for (int i = 0; i < 10; i++) {
				System.out.print(code.get(i) + " ");
			}
			System.out.println();

		}

	}

}
