package pg.q12977;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static int answer;      // 답 개수를 담을 변수 생성

    public static int solution(int[] nums) {
        answer = 0;
        DFS(nums, 0, new ArrayList<>(), 3);     // n개 중 3개를 고를 것이기에, r = 3으로 설정
        return answer;
    }

    private static void DFS(int[] nums, int index, List<Integer> selected, int r) {
        if (selected.size() == r) {                                 // r개를 선택했으면 소수 판별
            int sum = selected.stream().mapToInt(Integer::intValue).sum();
            if (isPrimeNumber(sum)) answer++;
            return;
        }
        if (selected.size() + nums.length - index < r) return;      // 남은 원소가 부족하면 return

        selected.add(nums[index]);                                  // nums[index]를 선택 목록에 추가
        DFS(nums, index + 1, selected, r);                    // nums[index]를 선택한 경우로 재귀호출
        selected.remove(selected.size() - 1);                 // 재귀 완료 후 nums[index]를 선택 목록에서 제거
        DFS(nums, index + 1, selected, r);                    // nums[index]를 선택하지 않은 경우로 재귀호출
    }

    private static boolean isPrimeNumber(int n) {
        if (n == 1) return false;                   // 1은 소수일 수 없으므로 false 반환
        double limit = Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {          // 2부터 √n까지만 나누어 확인
            if (n % i == 0) return false;           // 나누어 떨어지는 수는 소수가 아니므로 false 반환
        }
        return true;
    }
}
