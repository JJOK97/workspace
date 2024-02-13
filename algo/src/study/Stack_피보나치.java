package study;

public class Stack_피보나치 {

	static long[] memoization = new long[100];
	
	public static void main(String[] args) {
		long result = fibo(50);
		System.out.println(result);
	}
	
	public static long fibo(int N) {
		
		if (N <= 1) return N;
		
		if(memoization[N] != 0) return memoization[N];
		
		memoization[N] = fibo(N - 1) + fibo(N - 2);
		
		return memoization[N];
	}

}
