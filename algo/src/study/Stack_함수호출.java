package study;

import java.util.Arrays;

public class Stack_함수호출 {

	public static void main(String[] args) {
		System.out.println("main이 호출되었습니다.");
		int a = 10;
		int[] arr = {1, 2, 3};
		func1(a, arr);
		// 지역 변수기때문에 값이 변경 x;
		System.out.println(a);
		// 배열은 참조 자료형이기때문에 변경
		System.out.println(Arrays.toString(arr));
		System.out.println("main이 종료되었습니다.");
	}

	public static void func1(int a, int[] arr) {
		System.out.println("func1이 호출되었습니다.");
		a = 20;
		arr[0] = 4;
		func2();
		System.out.println("func1이 종료되었습니다.");
	}

	public static void func2() {
		System.out.println("func2이 호출되었습니다.");
		System.out.println("func2이 종료되었습니다.");
	}
}
