package pg.q1844;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;        // 맵의 행 크기
        int m = maps[0].length;     // 맵의 열 크기

        // 동, 서, 남, 북 방향 이동을 위한 델타 배열
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        // BFS 탐색을 위한 큐, 시작 위치 (0, 0) 삽입
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        // 이동 횟수를 저장하는 배열, 시작 위치는 1로 초기화
        int[][] dist = new int[n][m];
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 맵 범위 내이고, 벽이 아니며, 아직 방문하지 않은 경우
                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                        && maps[nr][nc] == 1 && dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[r][c] + 1;  // 이동 횟수 누적
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        // 도착점의 이동 횟수가 0이면 도달 불가 -> -1 반환
        return dist[n - 1][m - 1] == 0 ? -1 : dist[n - 1][m - 1];
    }
}
