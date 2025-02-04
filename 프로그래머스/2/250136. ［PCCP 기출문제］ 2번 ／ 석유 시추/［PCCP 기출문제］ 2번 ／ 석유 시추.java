import java.util.*;

class Solution {

    class Oil {
        int reserve;
        boolean visited;

        public Oil(int reserve, boolean visited) {
            this.reserve = reserve;
            this.visited = visited;
        }

        public Oil() {
            this.reserve = 0;
            this.visited = false;
        }
    }

    public Oil findOil(Oil[][] oil, int[][] land, int[] pos) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        int x = pos[0];
        int y = pos[1];
        Deque<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[] { x, y });
        Oil o = new Oil(1, true);
        oil[x][y] = o;
        while (!queue.isEmpty()) {
            Integer[] qNow = queue.pollFirst();
            x = qNow[0];
            y = qNow[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!((nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length || oil[nx][ny].visited)
                        || land[nx][ny] == 0)) {
                    queue.add(new Integer[] { nx, ny });
                    oil[nx][ny] = o;
                    o.reserve++;
                }
            }
        }
        return o;
    }

    public int solution(int[][] land) {
        int answer = 0;
        Oil[][] oil = new Oil[land.length][land[0].length];
        for (Oil[] oils : oil) {
            Arrays.fill(oils, new Oil());
        }
        ArrayList<Oil> oils = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] != 0 && !oil[i][j].visited) {
                    oils.add(findOil(oil, land, new int[] { i, j }));
                }
            }
        }

        for (int y = 0; y < oil[0].length; y++) {
            for (Oil o : oils) {
                o.visited = false;
            }
            int answerNow = 0;
            oils = new ArrayList<>();
            for (int x = 0; x < oil.length; x++) {
                if (!oil[x][y].visited && oil[x][y].reserve > 0) {
                    answerNow += oil[x][y].reserve;
                    oil[x][y].visited = true;
                    oils.add(oil[x][y]);
                }
            }
            if (answer < answerNow) {
                answer = answerNow;
            }
        }
        return answer;
    }
}