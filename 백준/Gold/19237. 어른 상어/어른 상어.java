import java.util.*;
import java.io.*;

class Main {
    // 1, 2, 3, 4 는 각각 위, 아래, 왼쪽, 오른쪽
    static class Shark {
        int id, x, y, dir;
        int[][] priority = new int[5][5];

        Shark() { }

        int findNextDir(Set<Integer> candidates) {
            for (int i = 1; i < 5; i++) {
                if (candidates.contains(priority[dir][i])) {
                    return priority[dir][i];
                }
            }
            return 0;
        }
    }

    static int N, M, k;
    static int[][] arr = new int[21][21];
    static int[][] smellOwner = new int[21][21];
    static int[][] leftTime = new int[21][21];
    static Map<Integer, Shark> sharks = new HashMap<>();
    static int time = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] > 0) {
                    Shark s = new Shark();
                    s.id = arr[i][j];
                    s.x = i;
                    s.y = j;
                    sharks.put(s.id, s);
                    
                    smellOwner[i][j] = s.id;
                    leftTime[i][j] = k;
                }
            }
        }

        // direction of sharks
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Shark s = sharks.get(i + 1);
            s.dir = Integer.parseInt(st.nextToken());
        }

        // priority of sharks
        for (int i = 0; i < M; i++) {
            Shark s = sharks.get(i + 1);

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());

                for (int z = 0; z < 4; z++) {
                    s.priority[j + 1][z + 1] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // solution
        solution();
    }

    static void solution() {
        while (time++ < 1000) {
            moveShark();
            decreaseSmellTime();
            createSmell();

            if (sharks.size() == 1) {
                System.out.println(time);
                return;
            }
        }

        System.out.println(-1);
    }

    // 상어 이동 후 겹친 애 쫓아내기
    static void moveShark() {
        // dx dy 는 위, 아래, 왼쪽, 오른쪽 순서
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Integer> willRemove = new LinkedList<Integer>();

        for (Integer id : sharks.keySet()) {
            Set<Integer> noSmellSet = new HashSet<>();
            Set<Integer> mySmellSet = new HashSet<>();
            Shark s = sharks.get(id);

            for (int i = 0; i < 4; i++) {
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (smellOwner[nx][ny] == 0) {
                    noSmellSet.add(i + 1);
                } else if (smellOwner[nx][ny] == s.id) {
                    mySmellSet.add(i + 1);
                }
            }

            // 냄새 없는 곳부터 스캔하고 자기 냄새 있는 곳을 스캔해서 이동할 방향 구하기
            int nextDir = s.findNextDir(noSmellSet);

            if (nextDir == 0) {
                nextDir = s.findNextDir(mySmellSet);
            }

            // 상어 이동
            arr[s.x][s.y] = 0;
            if (nextDir == 1) {
                s.x -= 1;
            } else if (nextDir == 2) {
                s.x += 1;
            } else if (nextDir == 3) {
                s.y -= 1;
            } else if (nextDir == 4) {
                s.y += 1;
            }
            
            // 이동할 위치에 상어 있으면 경쟁 후 작은 번호가 승리
            if (arr[s.x][s.y] == 0 || s.id < arr[s.x][s.y]) {
                arr[s.x][s.y] = s.id;
                s.dir = nextDir;
            } else {
                willRemove.add(s.id);
            }
        }

        while (!willRemove.isEmpty()) {
            sharks.remove(willRemove.poll());
        }
    }

    // 맵 전체의 냄새 시간을 하나씩 감소 시키고 0 이 되면 냄새 주인 정보도 지움
    static void decreaseSmellTime() {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (leftTime[i][j] == 0) continue;

                leftTime[i][j]--;

                if (leftTime[i][j] == 0) {
                    smellOwner[i][j] = 0;
                }
            }
        }
    }

    // 상어가 이동한 곳에 새로운 냄새 생성
    static void createSmell() {
        for (Integer id : sharks.keySet()) {
            Shark s = sharks.get(id);

            smellOwner[s.x][s.y] = s.id;
            leftTime[s.x][s.y] = k;
        }
    }
}