import java.util.*;
class Process {
    int priority;
    int location;
    
    Process(int priority, int location){
        this.priority = priority;
        this.location = location;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Process> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++){
            queue.add(new Process(priorities[i],i));
        }
        
        int order = 0;
        
        while (!queue.isEmpty()){
            Process current = queue.poll();
            
            boolean hasHigherPriority = false;
            
            for(Process process : queue){
                if(process.priority > current.priority){
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if(hasHigherPriority){
                queue.add(current);
            } else {
                order++;
                if(current.location == location){
                    return order;
                }
            }
        }
        
        return -1;
    }
    
}