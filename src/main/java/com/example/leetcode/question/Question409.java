package com.example.leetcode.question;

import java.util.HashMap;
import java.util.Map;

/**
 * Question409
 *
 * @author shentao
 * @date 2020/2/18
 */
public class Question409 {

    public static int longestPalindrome(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.merge(c, 1, Integer :: sum);
        }
        boolean flagOne = true;
        boolean flagOdd = true;
        boolean hasOneChar = map.containsValue(1);
        for (Character key : map.keySet()) {
            int i = map.get(key);
            if (i % 2 == 0) {
                count += i;
            } else if (i == 1 && flagOne) {
                count += i;
                flagOne = false;
            } else if (i % 2 == 1) {
                if (hasOneChar || !flagOdd) {
                    count += (i - 1);
                } else {
                    flagOdd = false;
                    count += i;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel");
        System.out.println(i);
    }

}
