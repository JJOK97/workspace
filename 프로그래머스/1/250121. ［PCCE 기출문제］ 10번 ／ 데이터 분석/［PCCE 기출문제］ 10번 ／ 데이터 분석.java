import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>() {
        {
            put("code", 0);
            put("date", 1);
            put("maximum", 2);
            put("remain", 3);
        }
    };
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> dataList = new ArrayList<>();
        int extIndex = map.get(ext);
        
        for(int[] datas : data){
            if(datas[extIndex] < val_ext){
                dataList.add(datas);
            }    
        }   
        
        int sortIndex = map.get(sort_by);
        
        Collections.sort(dataList, (a, b) -> a[sortIndex] - b[sortIndex]);
        
        return dataList.toArray(new int[0][]);
    }
}