package bj.q1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        var minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num != 0) {
                minHeap.add(num);
                continue;
            }
            Integer poll = minHeap.poll();
            if (poll == null) {
                System.out.println(0);
                continue;
            }
            System.out.println(poll);
        }
    }
}
