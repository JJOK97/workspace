package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heap_수정렬하기 {
	
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        int[] arr = new int[N];
	        
	        for(int i=0; i<N; i++) {
	            arr[i] = Integer.parseInt(br.readLine());
	        }
	        
	        // 힙 정렬 시작.
	        // heapify: 힙만들기 함수
	        // i번째 노드만 힙의 성질에 맞도록 부모 > 자식 대소관계 정렬.
	        // 부모 -> 자식으로 내려가면서 
	        // arr : 힙만들기를 할 배열
	        // N: 배열에서 어디까지를 힙으로 만들 것인지? 힙의 크기
	        // i: 몇번 인덱스의 부모 노드인지?      
	        for(int i=N/2-1; i >=0; i--) // 모든 부모 노드에 대해서만 힙만들기.
	            heapify(arr, N, i);
	        
	        // 이 과정이 수행되고 나면
	        // arr은 최대힙이 됨. 
	        
	        
	        // 실제 배열의 정렬이 일어나는 구간.
	        // N-1번만 최댓값을 맨마지막 값과 교환하면서 힙 크기를 줄여나가면 정렬이 완료됨
	        
	        for(int i=N-1; i > 0; i--) { // 맨마지막부터 최댓값을 채워나감.
	            // 루트노드와 맨 마지막 노드를 바꾸면 1개씩 정렬이됨.
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	            
	            // i: 힙의 크기
	            // N-1, N-2, ... , 1
	            // 힙의 크기를 줄여나감.
	            // 0번 루트 노드에 대해서만 힙만들기 수행하면 -> 다시 힙이됨.
	            heapify(arr, i, 0);
	        }
	        
	        
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i<N; i++) {
	            sb.append(arr[i]).append("\n");
	        }
	        System.out.println(sb);
	    }

	    private static void heapify(int[] arr, int M, int i) {
	        // 부모가 두 자식과 비교해가면서
	        // 큰쪽으로 교환해나감.
	        int largest = i;
	        int l = 2*i + 1;
	        int r = 2*i + 2;
	        
	        if(l < M && arr[l] > arr[largest])
	            largest = l;
	        
	        if(r < M && arr[r] > arr[largest])
	            largest = r;
	        
	        if(largest != i) {
	            int temp = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = temp;
	            // 재귀를 사용.
	            heapify(arr, M, largest);
	        }
	    }

	}