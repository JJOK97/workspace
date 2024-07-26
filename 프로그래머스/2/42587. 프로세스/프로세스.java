import java.util.*;

class Process {
    int priority;
    int location;
    
    Process (int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
    
}
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            queue.add(new Process(priorities[i], i));
        }
        
        int count = 0;
        
        while(!queue.isEmpty()){
            Process current = queue.poll();
            boolean check = false;
            
            for(Process process : queue){
                if(process.priority > current.priority){
                    check = true;
                    break;
                }
            }
            
            if(!check){
                count++;
                if(current.location == location){
                    return count;
                }
            } else {
                queue.add(current);
            }
            
            
        }
        
        return -1;
    }
}