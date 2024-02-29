package study;

import java.util.Arrays;

public class 순열_3_방문체크 {

	static int[] nums;
	static int N;
	static boolean[] visited; // 해당 원소 사용 유무
	static int[] result; // 순열결과 저장

	public static void main(String[] args) {
		
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		
	}
	
	// idx : 현재 내가 뽑을 위치
	public static void perm(int idx) {
		
		if (idx == N) { // 다 뽑았어~~
			
			System.out.println(Arrays.toString(result));
			return;
			
		}
		
		// N개의 원소를 가지고 판단하려고!
		for(int i = 0; i < N; i++) {

			if(visited[i]) continue;
			// 아래의 코드가 실행이 된다는 뜻은?
			result[idx] = nums[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
			result[idx] = 0;
		}
		
	}

}
