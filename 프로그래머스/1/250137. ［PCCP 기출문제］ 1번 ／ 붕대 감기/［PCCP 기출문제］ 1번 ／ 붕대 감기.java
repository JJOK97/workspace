class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage: t(시전 시간), x(초당 회복량), y(추가 회복량)
        // attacks: 공격 시간, 피해량
        // 죽으면 -1 return
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int continuousTime = 0;
        int currentTime = 0;
        int currHealth = health;
        
        for(int i = 0; i < attacks.length; i++) {
            
            int atkTime = attacks[i][0];
            int dmg = attacks[i][1];
            
            while(currentTime < atkTime) {
                
                currentTime++;
                
                // 공격시간일때
                if(currentTime == atkTime) {
                    
                    continuousTime = 0;
                    currHealth -= dmg;
                    
                    if(currHealth <= 0) return -1;
                    
                // 공격시간이 아닐때
                } else {
                    
                    // 현재 체력이 최대체력이면
                    if(currHealth >= health) {
                        currHealth = health;
                        continue;
                        
                    // 최대 체력이 아니면
                    } else {
                                                    currHealth += x;
                                    
                        continuousTime++;
                        
                        // 현재 체력이 최대체력이면
                        if(currHealth > health){
                        currHealth = health;
                            continue;
                    } 
                        
                        if(continuousTime == t) {
                            currHealth += y;
                            continuousTime = 0;
                        }
                    }
                }
                
            } // while
            
        } // for
        
        return currHealth;
        
    }
}