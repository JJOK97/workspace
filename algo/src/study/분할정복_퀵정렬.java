package study;

public class 분할정복_퀵정렬 {

	public static void main(String[] args) {
		
		// 퀵 정렬
		// - 최악의 경우 : O(n^2), 평균적으로 o(nlogn)
		// - 아이디어 : 임의의 주어진 배열이 있을 때 정렬하는 것은 어렵지만
		//			이 중에서 한 개만 정렬된 위치에 놓는 것은 쉽다(O(n)).
		// - 정렬된 위치 : 배열이 정렬되었다고 가정했을 때 자기 위치

		int[] arr = new int[] {8, 14, 2, 15, 6, 10, 17, 1, 4};
		// ex) 8의 경우 정렬된 위치 : 5번째 위치 (idx == 4);

		// 호어 파티션 : 항상 가장 왼쪽을 피벗으로 사용
		// pivot : pivot을 정렬된 위치에 놓으면 배열이 둘로 분할됨.
		// 8을 피벗 삼아서 8을 정렬된 위치에 놓는다면?
		
		
		// 포인터 2개를 사용
		// j는 왼쪽부터 증가, j는 오른쪽 끝에서 감소
		
		// 목표 : 왼쪽에는 pivot보다 작은 수가, 오른쪽에는 pivot보다 큰 수가 오도록 하는게 목표.
		//		i는 큰 수를 찾아야 함, j는 작은 수를 찾아야함
		//		i < - > j
		int pivot = arr[0];
		
		int i = 0; // 왼쪽 끝 포인터
		 
		int j = arr.length; // 오른쪽 끝 포인터 
		// (맨 끝의 원소를 바로 가리키는 것이 아니라, 맨 끝 + 1 을 가리킴
		 
		// 이유 : do while문을 쓸 것이므로 
		while( i < j) {
			do i++;
			while(arr[i] <= pivot); // 큰 수를 만나면 거기서 멈추겠다.
			 
			do j--;
			while(arr[j] > pivot); // 작거나 같은 수를 찾으면 멈추겠다.
			
			if(i < j) { // 여전히 교차되지 않았다면?
				swap(arr, i, j);
			}
		}
		
		swap (arr, 0, j); // pivoit과 pivot보다 작은 수 중 가장 오른쪽 
		
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	} 

}
