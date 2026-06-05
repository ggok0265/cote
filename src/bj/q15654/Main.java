package bj.q15654;

import java.io.*;
import java.util.*;

public class Main {
    static int N, R;
    static int[] A;
    static List<Integer> selected = new ArrayList<>();          // 선택된 인덱스를 담는 리스트
    static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

    static void DFS() throws IOException {
        if (selected.size() == R) {                             // R개를 모두 골랐으면 수열 출력
            for (int i : selected) wr.write(A[i] + " ");       // selected의 값은 A 배열의 인덱스
            wr.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!selected.contains(i)) {                        // 아직 선택하지 않은 인덱스만 탐색
                selected.add(i);                                // 인덱스를 선택 목록에 추가
                DFS();
                selected.removeLast();                          // 백트래킹: 마지막 인덱스 제거
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        st.nextToken(); N = (int) st.nval;                      // 자연수의 개수
        st.nextToken(); R = (int) st.nval;                      // 수열의 길이

        A = new int[N];
        for (int i = 0; i < N; i++) {
            st.nextToken();
            A[i] = (int) st.nval;
        }

        Arrays.sort(A);                                         // 사전 순 출력을 위해 정렬

        DFS();
        wr.close();
    }
}
