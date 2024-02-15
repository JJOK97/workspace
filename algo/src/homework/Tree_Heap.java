package homework;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tree_Heap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int trial = sc.nextInt();
			PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < trial; i++) {
				int choice = sc.nextInt();
				if (choice == 1) {
					pqueue.add(sc.nextInt());
				} else {
					if (pqueue.isEmpty()) {
						System.out.print(-1 + " ");
					} else {
						System.out.print(pqueue.poll() + " ");
					}
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
