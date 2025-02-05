class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] video_timeParts = video_len.split(":");
        int[] video_time = new int[2];
        video_time[0] = Integer.parseInt(video_timeParts[0]);
        video_time[1] = Integer.parseInt(video_timeParts[1]);
        
        String[] pos_timeParts = pos.split(":");
        int[] pos_time = new int[2];
        pos_time[0] = Integer.parseInt(pos_timeParts[0]);
        pos_time[1] = Integer.parseInt(pos_timeParts[1]);
        
        String[] start_timeParts = op_start.split(":");
        int[] start_time = new int[2];
        start_time[0] = Integer.parseInt(start_timeParts[0]);
        start_time[1] = Integer.parseInt(start_timeParts[1]);
        
        String[] end_timeParts = op_end.split(":");
        int[] end_time = new int[2];
        end_time[0] = Integer.parseInt(end_timeParts[0]);
        end_time[1] = Integer.parseInt(end_timeParts[1]);
        
        if(((start_time[0] == pos_time[0] && start_time[1] <= pos_time[1])
          || (start_time[0] < pos_time[0])) &&
          ((end_time[0] > pos_time[0])
          || (end_time[0] == pos_time[0] && end_time[1] >= pos_time[1]))) {
            pos_time[0] = end_time[0];
            pos_time[1] = end_time[1];
        }
        
        for(int i = 0; i < commands.length; i++){
            
            if(commands[i].equals("prev")){
                
                if(pos_time[1] - 10 < 0){
                    
                    if(pos_time[0] == 0){
                        pos_time[1] = 0;
                    } else {
                        pos_time[1] = 60 + (pos_time[1] - 10);
                        pos_time[0]--;
                    }
                    
                    
                } else 
                    pos_time[1] -= 10;
                
                System.out.println(String.format("3. %02d:%02d", pos_time[0], pos_time[1]));
                
            } else {
                if(pos_time[1] + 10 > 59) {
                    
                    pos_time[0]++;
                    pos_time[1] = (pos_time[1] + 10) - 60;
                    
                    if(pos_time[0] == video_time[0] && pos_time[1] > video_time[1]){
                        pos_time[1] = video_time[1];
                    }
                    
                    System.out.println(String.format("1. %02d:%02d", pos_time[0], pos_time[1]));
                    
                } else {
                    pos_time[1] += 10;
                    
                    if(pos_time[0] == video_time[0] && pos_time[1] > video_time[1]){
                        pos_time[1] = video_time[1];
                    }
                    
                    System.out.println(String.format("2. %02d:%02d", pos_time[0], pos_time[1]));
                }
                
            }
            
            if(((start_time[0] == pos_time[0] && start_time[1] <= pos_time[1])
              || (start_time[0] < pos_time[0])) &&
              ((end_time[0] > pos_time[0])
              || (end_time[0] == pos_time[0] && end_time[1] >= pos_time[1]))) {
                pos_time[0] = end_time[0];
                pos_time[1] = end_time[1];
            }
            
        }
        
        answer = String.format("%02d:%02d", pos_time[0], pos_time[1]);
        
        return answer;
    }
}