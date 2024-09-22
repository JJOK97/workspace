import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> graph;
    static int N, M, V;

    static boolean[] BFS;
    static Queue<Integer> q;

    static boolean[] DFS;
    static Stack<Integer> s;

    public static void main(String[] args) throws Exception {

        graph = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++ ){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i <= N; i++){
            Collections.sort(graph.get(i));
        }

        DFS = new boolean[N + 1];
        s = new Stack<>();
        for(int i = graph.get(V).size() - 1; i >= 0 ; i--){
            s.add(graph.get(V).get(i));
        }

        System.out.print(V + " ");
        DFS[V] = true;

        dfs();

        System.out.println();

        BFS = new boolean[N + 1];
        q = new LinkedList<>();
        for(int i = 0; i < graph.get(V).size(); i++){
            q.add(graph.get(V).get(i));
        }

        System.out.print(V + " ");
        BFS[V] = true;

        bfs();

    }

    public static void dfs(){
        while(!s.isEmpty()){
            int num = s.pop();

            if(!DFS[num]){
                System.out.print(num + " ");
                DFS[num] = true;
                for(int i = graph.get(num).size() - 1; i >= 0 ; i--){
                    s.add(graph.get(num).get(i));
                }
            }
        }
    }

    public static void bfs(){

        while(!q.isEmpty()){
            int num = q.poll();


            if(!BFS[num]){
                System.out.print(num + " ");
                BFS[num]= true;
                for(int i = 0; i < graph.get(num).size(); i++) {
                    q.add(graph.get(num).get(i));
                }
            }

        }

    }

}