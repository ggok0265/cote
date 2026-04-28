package pg.q43238;

class Solution {
    int[] times; // 다른 메서드에도 사용하기 위해 전역변수 처리

    public long solution(int n, int[] times) {
        this.times = times;             // 전역변수에 값 대입
        long maxTime = 0;
        for (int t : times) {
            if (t > maxTime) maxTime = t; // times 배열에서 받아온 값 중 최대값을 maxTime으로 설정
        }
        maxTime *= n;                   // 최대 시간이 걸리는 심사관이, n명을 다 처리하는 시간을 최대로 걸리는 시간으로 설정
        return parametric_min(n, 1, maxTime); // 최소 1분부터 최대 maxTime으로 파라매트릭서치_최소값 메서드 실행
    }

    public long parametric_min(long n, long left, long right) {
        while (left <= right) {                 // left 또는 right 값을 조정한 이후에도 값이 같거나 순서가 바뀔때까지 반복
            long middle = (left + right) / 2;   // left와 right의 중앙값 설정
            if (compare(middle) >= n) {         // middle분 안에 n명 이상 처리가 가능하다면
                right = middle - 1;             // right 값을 중앙값으로 위치
            } else {                            // middle분 안에 n명도 처리 불가하다면
                left = middle + 1;              // left 값을 중앙값으로 위치
            }
        }
        return left;                            // 반복 종료 후, 최소값이 되는 left 값을 반환
    }

    public long compare(long middle) {
        long count = 0;
        for (int t : times) {       // 각 심사관이 처리하는 모든 시간을 반복
            count += middle / t;    // 각 심사관이 middle 분 동안 처리하는 인원을 count에 저장
        }
        return count;
    }
}
