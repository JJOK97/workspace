import java.util.*;

class Solution {
    
    class Job implements Comparable<Job> {
        int request;
        int process;
        
        Job(int request, int process){
            this.request = request;
            this.process = process;
        }
        
        @Override
        public int compareTo(Job other){
            
            // 요청시간이 같으면 작업시간으로 비교
            if(this.request == other.request){
                return this.process - other.process;
            }
            
            return this.request - other.request;

        }
        
    }
    
    class shortTime implements Comparator<Job> {
        
        @Override
        public int compare (Job job1, Job job2){
            return job1.process - job2.process;
        }
        
    }
    
    public int solution(int[][] jobs) {

        PriorityQueue<Job> readyQ = new PriorityQueue<>();
        PriorityQueue<Job> HD = new PriorityQueue<>(new shortTime());
        
        for(int[] job : jobs){
            readyQ.offer(new Job(job[0], job[1]));
        }
        
        int currentTime = 0;
        int totalTime = 0;
            
        while(!readyQ.isEmpty() || !HD.isEmpty()){
            while(!readyQ.isEmpty() && readyQ.peek().request <= currentTime){
                HD.offer(readyQ.poll());
            }

            if(HD.isEmpty()){
                currentTime = readyQ.peek().request;
                continue;
            }

            Job job = HD.poll();
            totalTime += currentTime + job.process - job.request;
            currentTime += job.process;
        }
        
        return totalTime / jobs.length;
    }
}