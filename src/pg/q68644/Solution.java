package pg.q68644;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;                 // 총 배열의 길이를 저장
        List<Integer> list = new ArrayList<>(); // 모든 경우를 담을 배열 저장

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                list.add(numbers[i] + numbers[j]); // 중복되지 않는 인덱스의 두 수릐 합을 리스트에 저장
            }
        }

        Set<Integer> set = new HashSet<>(list); // 중복된 값을 제거하기 위해 Set 자료구조 사용

        return set.stream()                     // Java의 Stream 사용
                .mapToInt(v -> v)               // set에 담긴 value를 int로 변환
                .sorted()                       // 변환된 정수를 정렬
                .toArray();                     // 이후 이 정수를 배열로 만들어 리턴
    }
}
