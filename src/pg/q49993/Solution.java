package pg.q49993;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;                          // 가능한 스킬트리의 수를 카운트

        for (String tree : skill_trees) {
            // skill에 포함되지 않는 문자를 [^ ] 정규식으로 제거
            String filtered = tree.replaceAll("[^" + skill + "]", "");

            if (skill.startsWith(filtered)) {   // 남은 문자열이 skill의 접두사인지 확인
                count++;                        // 가능한 스킬트리이면 카운트 증가
            }
        }

        return count;                           // 가능한 스킬트리의 총 개수 반환
    }
}
