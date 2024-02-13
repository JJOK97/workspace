package homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


	class Node {
		int data;
		Node next;
		Node prev;

		Node() {
		}

		Node(int data) {
			this.data = data;
		}
	}

	class linkedList {
		Node head;
		Node tail;
		int size;

		public linkedList() {
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
		}

		void addLast(int data) {
			Node newNode = new Node(data);

			newNode.next = tail;
			newNode.prev = tail.prev;

			newNode.next.prev = newNode;
			newNode.prev.next = newNode;

			size++;
		}

		void add(int idx, int data) {
			Node newNode = new Node(data);

			Node curr = head;
			for (int i = 0; i < idx; i++) {
				curr = curr.next;
			}

			newNode.prev = curr;
			newNode.next = curr.next;
			newNode.next.prev = newNode;
			newNode.prev.next = newNode;

			size++;
		}

		void remove(int idx) {
			Node curr = head.next;
			for (int i = 0; i < idx; i++) {
				curr = curr.next;
			}

			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;

			size--;

		}

		void printList() {
			StringBuilder sb = new StringBuilder();

			Node curr = head.next;
			for (int i = 0; i < 10; i++) {
				sb.append(curr.data + " ");
				curr = curr.next;
			}
			System.out.println(sb);
		}

	}

	public class LinkedList_암호문_ {
		public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int size = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			linkedList list = new linkedList();
			for (int i = 0; i < size; i++) {
				list.addLast(Integer.parseInt(st.nextToken()));
			}
			int addNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < addNum; n++) {
				char c = st.nextToken().charAt(0);
				switch (c) {
				case 'I':
					int idx = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for (int i = 0; i < num; i++) {
						list.add(idx++, Integer.parseInt(st.nextToken()));
					}
					break;
				case 'D':
					idx = Integer.parseInt(st.nextToken());
					num = Integer.parseInt(st.nextToken());
					for (int i = 0; i < num; i++) {
						list.remove(idx);
					}
					break;
				case 'A':
					num = Integer.parseInt(st.nextToken());
					for (int i = 0; i < num; i++) {
						list.addLast(Integer.parseInt(st.nextToken()));
					}
				}
			}
			System.out.print("#" + t + " ");
			list.printList();
		}

	}

}
