import javax.swing.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map; // 0과 1의 맵
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static List<int[]> bridges;
    static int islandCount = 0;
    static int[][] islandMap; // 0과 islandCount의 맵
    static List<int[]>[] adjList;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        islandMap = new int[N][M];
        bridges = new ArrayList<>();

        for (int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        // 1. 섬을 구분하기 위한 DFS
        islandCount = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    islandCount++;
                    dfs(i, j, islandCount); // 섬을 구분하고 각 섬에 islandCount 부여
                }
            }
        }

        // 2. 다리 후보 찾기
        findBridges();

        // 3. 유니온 파인드 초기화
        initUnionFind(islandCount + 1);

        // 4. 크루스칼 알고리즘으로 최소 스패닝 트리 계산
        int result = kruskal();

        // 결과 출력
        System.out.println(result);

    }

    // 섬을 구분하는 DFS 함수
    public static void dfs(int x, int y, int islandId){
        visited[x][y] = true;
        islandMap[x][y] = islandId;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny, islandId);
            }
        }
    }

    // 다리를 찾는 함수 (한 섬에서 다른 섬으로 갈 수 있는 다리 탐색)
    public static void findBridges() {
        for (int  x = 0; x < N; x++){
            for(int y = 0; y < M; y++){
                if(islandMap[x][y] != 0){
                    int fromIsland = islandMap[x][y];
                    for(int dir = 0; dir < 4; dir++){
                        int length = 0;
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        while (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) { // 바다를 지나는 중
                            length++;
                            nx += dx[dir];
                            ny += dy[dir];
                        }

                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1) { // 다른 섬에 도달
                            int toIsland = islandMap[nx][ny];
                            if(fromIsland != toIsland && length >= 2){ // 다른 섬이고 다리 길이가 2 이상이어야 함
                                bridges.add(new int[]{fromIsland, toIsland, length});
                            }
                        }
                    }
                }
            }
        }
    }

    // 3
    // 유니온 파인드를 위한 배열과 함수들
    public static int[] parent;

    // 유니온 파인드 초기화
    static void initUnionFind(int size){
        parent = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
        }
    }

    // 4
    public static int kruskal() {
        Collections.sort(bridges, (a, b) -> Integer.compare(a[2], b[2])); // 다리 길이 기준으로 정렬

        int totalLength = 0;
        int edgesUsed = 0;

        for (int[] bridge : bridges){
            int fromIsland = bridge[0];
            int toIsland = bridge[1];
            int length = bridge[2];

            if(find(fromIsland) != find(toIsland)) { // 두 섬이 아직 연결되지 않았다면 연결
                union(fromIsland, toIsland);
                totalLength += length;
                edgesUsed++;
            }

            if(edgesUsed == islandCount - 1) break; // 모든 섬이 연결되었으면 종료
        }

        for (int i = 1; i <= islandCount; i++) {
            if (find(i) != find(1)) {
                return -1; // 연결되지 않은 섬이 있으면 -1 반환
            }
        }

        return totalLength;
    }

    // 두 섬을 연결하는 유니온 함수
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            parent[rootA] = rootB;
        }
    }

    // 유니온 파인드의 find 함수 (부모 노드를 찾음)
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }




}