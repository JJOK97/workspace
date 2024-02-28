package study;

import java.util.Arrays;

public class 분할정복_병합정렬2{
    public static void main(String[] args) {
        // 병합정렬 
        // - 분할정복 - 정렬
        // - Arrays.sort()
        // - O(nlogn)
        
        // - 아이디어: 이미 정렬된 두개의 배열이 있다면
        //   이 둘을 합쳐서 새로운 정렬된 배열을 만드는 것은 쉽다(O(n))
        
        int[] L = { 3, 6, 11, 33, 75};
        int[] R = { 1, 23, 42, 55, 66};
        
        // int[] A = { 1, 3, 6, 11, 23, 
        // 두 수를 비교해서 작은 수를 순서대로 써 나가면 된다.
        
        int[] A = new int[L.length + R.length]; // 새로 만들 배열.
        
        // 포인터(idx를 가리는 변수)
        int i = 0; // L
        int j = 0; // R
        int k = 0; // A
        
        // L의 i번째와 R의 j번째를 비교해서 작은 수를 A의 k번째에 넣는다.
        
        while(i < L.length && j < R.length) { // 두 수를 비교할 수 있다면.
            if(L[i] < R[j]) 
                A[k++] = L[i++];
            else 
                A[k++] = R[j++];
        }
        // i 또는 j가 배열의 범위 밖으로 벗어낫다.
        for(; i< L.length; i++) 
            A[k++] = L[i];
        
        
        for(; j < R.length; j++)
            A[k++] = R[j];
        
        
        System.out.println(Arrays.toString(A));
        
    }
}
