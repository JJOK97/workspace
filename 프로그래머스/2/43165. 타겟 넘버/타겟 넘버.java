// import java.util.*;

// class Solution {
    
//     static int answer = 0;
    
//     public int solution(int[] numbers, int target) {
        
//         DFS(numbers, target);
        
//         return answer;
//     }
    
//     static class Node{
//         int i;
//         int cal;
        
//         Node(int i, int cal){
//             this.i = i;
//             this.cal = cal;
//         }
//     }
    
//     static void DFS(int[] numbers, int target){
    
//         Stack<Node> stack = new Stack<>();
//         stack.push(new Node(0,0));
        
//         while(!stack.isEmpty()){
//             Node now = stack.pop();
            
//             if(now.i == numbers.length){
//                 if(now.cal == target){
//                     answer++;
//                 }
//                 continue;
//             }
            
//             int plus = now.cal + numbers[now.i];
//             int minus = now.cal - numbers[now.i];
            
//             stack.push(new Node(now.i + 1, plus));
//             stack.push(new Node(now.i + 1, minus));
            
//         }
        
//     }
    
// }

// import java.util.*;

// class Solution {
    
//     static int answer = 0;
    
//     public int solution(int[] numbers, int target) {
    
//         bfs(numbers, target);
        
//         return answer;
        
//     }
    
//     static class Node{
//         int i;
//         int cal;
        
//         Node(int i, int cal){
//             this.i = i;
//             this.cal = cal;
//         }
//     }
    
//     static void bfs(int[] numbers, int target){
        
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(new Node(0,0));
        
//         while(!queue.isEmpty()){
            
//             Node now = queue.poll();
        
            
//             if(now.i == numbers.length){
//                 if(now.cal == target){
//                     answer++;
//                 }
//                 continue;
//             }
            
//             queue.add(new Node(now.i + 1, now.cal + numbers[now.i]));
//             queue.add(new Node(now.i + 1, now.cal - numbers[now.i]));
            
//         }        
//     }
    
// }

import java.util.*;
class Solution {

    static int result = 0;

    public int solution(int[] numbers, int target) {

        //0 = 합, 1 = 인덱스
        calculate(numbers, target, new int[] {0, 0});

        return result;
    }

    public void calculate(int[] numbers, int target, int[] memory){
        
        if(memory[1] == numbers.length) {
            if(memory[0] == target){
                result++;  
                return;
            }
            return;
        }

        // 더하고, 빼기
        calculate(numbers, target, new int[] {memory[0] + numbers[memory[1]], memory[1]+1});
        calculate(numbers, target, new int[] {memory[0] - numbers[memory[1]], memory[1]+1});

    }


}