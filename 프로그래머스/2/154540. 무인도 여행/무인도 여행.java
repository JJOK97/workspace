import java.util.*;

class Solution {
    
    static boolean[][] check;
    static int[][] island;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    public int[] solution(String[] maps) {
        
        List<Integer> list = new ArrayList<>();
        
        int rows = maps.length;
        int cols = maps[0].length();
            
        island = new int[rows][cols];
        check = new boolean[rows][cols];
        
        // 맵을 정수 배열로 변환
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(maps[i].charAt(j) != 'X'){
                    island[i][j] = Character.getNumericValue(maps[i].charAt(j));
                } else {
                    island[i][j] = -1;
                }
            }
        }
        
        // 섬 탐색
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(island[i][j] != -1 && !check[i][j]){
                    list.add(BFS(i, j));
                }
            }
        }
                
        int[] answer;
        
        // 결과 배열 생성
        if (list.isEmpty()){
            answer = new int[]{-1};
        } else {
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    int BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        check[x][y] = true;
        
        int sum = island[x][y];
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nX = dx[i] + now[0];
                int nY = dy[i] + now[1];
                
                if(nX >= 0 && nY >= 0 && nX < island.length && nY < island[0].length && island[nX][nY] != -1 && !check[nX][nY]){
                    queue.add(new int[]{nX, nY});
                    check[nX][nY] = true;
                    sum += island[nX][nY];
                }
            }   
        }
        
        return sum;
    }
}
