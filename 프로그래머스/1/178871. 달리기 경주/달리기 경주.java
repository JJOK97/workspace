import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> playerIndexMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = playerIndexMap.get(calling);
            
            if (players[idx].equals(calling)) {
                
                String temp = players[idx];
                players[idx] = players[idx - 1];
                players[idx - 1] = temp;
                
                playerIndexMap.put(players[idx], idx);
                playerIndexMap.put(players[idx - 1], idx - 1);
            }
        }
        
        return players;
    }
}