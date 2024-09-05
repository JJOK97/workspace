import java.io.*;
import java.util.*;

public class Main {
    static int n, min;
    static int[] people;
    static boolean[] check;
    static int[] arr; // 인덱스:지역 , 요소값:선거구
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();// 간선표시

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        people = new int[n];
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            people[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Integer>());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++)
                graph.get(i).add(Integer.parseInt(st.nextToken()));
        }
        /////////////////////////////////////////////////////////////////// 입력

        // 선거구 조합
        back(1);
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    public static void back(int depth){

        if(depth == n + 1){

            check = new boolean[n + 1];

            int a = 0, b = 0;

            for(int i = 0; i < n; i++){
                if(arr[i + 1] == 1){
                    a += people[i];
                } else {
                    b += people[i];
                }
            }

            int cnt = 0;

            for(int i = 1; i <= n; i++){
                if(check[i]){
                    continue;
                }
                link(i , arr[i]);
                cnt++;
            }
            
            if(cnt == 2){
                min = Math.min(min, Math.abs(a - b));
            }
            
            return;

        }

        arr[depth] = 1;
        back(depth + 1);

        arr[depth] = 0;
        back(depth + 1);

    }
    
    public static void link(int num, int local){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(num);
        check[num] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph.get(cur)){
                
                if(arr[next] == local && !check[next]){
                    check[next] = true;
                    q.add(next);
                }
                
            }
        }
        
    }
    
}