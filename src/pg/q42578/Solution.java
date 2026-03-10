package pg.q42578;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothe : clothes) {
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (int num : clothesMap.values()) {
            answer *= (num + 1);
        }

        return answer - 1;
    }
}
