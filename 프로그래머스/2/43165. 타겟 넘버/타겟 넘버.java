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

import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
    
        bfs(numbers, target);
        
        return answer;
        
    }
    
    static class Node{
        int i;
        int cal;
        
        Node(int i, int cal){
            this.i = i;
            this.cal = cal;
        }
    }
    
    static void bfs(int[] numbers, int target){
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        
        while(!queue.isEmpty()){
            
            Node now = queue.poll();
            
            if(now.i == numbers.length){
                if(now.cal == target){
                    answer++;
                }
                continue;
            }
            
            queue.add(new Node(now.i + 1, now.cal + numbers[now.i]));
            queue.add(new Node(now.i + 1, now.cal - numbers[now.i]));
            
        }        
    }
    
}