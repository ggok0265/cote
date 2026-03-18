package pg.q42748;

import java.util.ArrayList;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];        // 답을 받는 배열의 크기를 commands 배열의 크기로 설정
        for (int i = 0; i < commands.length; i++) {     // commands 배열의 크기 동안 반복
            var tmp = new ArrayList<Integer>();         // Integer 값을 저장할 ArrayList 선언
            for (int j = commands[i][0]-1; j <= commands[i][1]-1; j++) {    // commands[][] 배열에서 의미하는 0번, 1번 원소는
                tmp.add(array[j]);
            }
            tmp.sort(Integer::compareTo);
            answer[i] = tmp.get(commands[i][2]-1);
            tmp.clear();
        }

        return answer;
    }
}
