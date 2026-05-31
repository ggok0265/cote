package bj.q11724;

import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;   // 인접 리스트
    static boolean[] visited;       // 방문 여부

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 (방향 없는 그래프 - 양방향 연결)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1];
        int answer = 0;

        // 모든 정점을 순회하며 방문하지 않은 정점에서 DFS 시작
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);                     // DFS 1회 실행 = 연결 요소 1개 탐색
                answer++;                   // 연결 요소 개수 증가
            }
        }

        System.out.println(answer);
    }

    static void dfs(int i) {
        visited[i] = true;                  // 현재 정점 방문 처리

        for (int next : graph[i]) {
            if (!visited[next]) {           // 방문하지 않은 인접 정점이면 재귀 호출
                dfs(next);
            }
        }
    }
}
