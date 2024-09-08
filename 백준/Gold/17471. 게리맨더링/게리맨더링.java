import java.util.*;
import java.io.*;

public class Main {

    static int n, min;
    static int[] people, arr;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        people = new int[n];
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < cnt; j++){
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        back(1);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

    static boolean[] check;

    public static void back(int depth){

        if(depth == n + 1){

            check = new boolean[n + 1];

            int cnt = 0;

            for(int i = 1; i <= n; i++){
                if(!check[i]){
                    link(i , arr[i]);
                    cnt++;
                }

            }

            int a = 0, b = 0;

            for(int i = 0; i < n; i++){
                if(arr[i + 1] == 1){
                    a += people[i];
                } else {
                    b += people[i];
                }
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

    public static void link(int depth, int local){
        Queue<Integer> q = new LinkedList<>();
        q.add(depth);
        check[depth] = true;

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