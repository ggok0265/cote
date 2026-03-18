package bj.q11004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));  // BufferedReader 클래스를 통해 읽기
        var tokenizer = new StringTokenizer(reader.readLine());             // BufferedReader를 통해 읽어온 문자를 한줄 읽어서, 그것을 쪼개기 위한 StringTokenizer 선언
        int n = Integer.parseInt(tokenizer.nextToken());                    // 쪼개어진 첫 단어는 String 타입이기 때문에, int형으로 바꿔서 저장
        int k = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());                 // 다음 한줄을 읽기 위해 tokenizer 객체 다시 생성
        var list = new ArrayList<Integer>();                                // 정렬을 빠르게 하기 위해 ArrayList 선언
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(tokenizer.nextToken()));              // 크기 n만큼의 배열을 list에 저장
        }
        list.sort(Integer::compareTo);                                      // ArrayList의 sort 메서드를 통해 정수를 정렬
        System.out.println(list.get(k-1));                                  // k의 인덱스는 1부터 시작하기 때문에 k-1번째 값을 출력
    }
}
