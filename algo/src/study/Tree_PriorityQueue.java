package study;

import java.util.Comparator;
import java.util.PriorityQueue;

class Person implements Comparable<Person> {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if (this.age == o.age) {
			return this.name.compareTo(name);
		}
		return this.age - o.age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

public class Tree_PriorityQueue {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
//				if (a > b) {
//					return 1;
//				} else if (a == b) {
//					return 0;
//				}
//				return -1;
				return b - a;
			}
		});

		// 우선순위 큐 : 기본 전렬 순서는 오름차순
		// 내림차순 바꾸고 싶으면 음수를 쓰자

		pq.add(12);
		pq.add(23);
		pq.add(32);
		pq.add(8);
		pq.offer(73);

		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());

		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
		pq2.add(12);
		pq2.add(23);
		pq2.add(32);
		pq2.add(8);
		pq2.offer(73);

		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());

		PriorityQueue<Person> pq3 = new PriorityQueue<>();
		
		pq3.add(new Person("진석", 22));
		pq3.add(new Person("진석2", 22));
		pq3.add(new Person("진석3", 22));
		pq3.add(new Person("진석4", 22));
		pq3.add(new Person("진석5", 22));
		
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		
	}

}