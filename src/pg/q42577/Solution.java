package pg.q42577;

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
//        for (int i = 0; i < phone_book.length; i++) {
//            for (int j = 0; j < phone_book.length; j++) {
//                if (i == j) {
//                    continue;
//                }
//                if (phone_book[i].length() > phone_book[j].length()) {
//                    continue;
//                }
//                if (phone_book[j].startsWith(phone_book[i])) {
//                    return false;
//                }
//            }
//        }
//
//        return true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
