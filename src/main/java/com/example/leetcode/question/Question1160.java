package com.example.leetcode.question;

/**
 * Question1160
 *
 * @author shentao
 * @date 2020/3/1
 */
public class Question1160 {
    /*public static int countCharacters(String[] words, String chars) {
        int count = 0;
        for (String word : words) {
            String spell = chars;
            for (int i = 0; i < word.length(); i++) {
                String s = word.substring(i, i + 1);
                if (spell.indexOf(s) >= 0) {
                    spell = spell.replaceFirst(s, "");
                }
            }
            if (spell.length() + word.length() == chars.length()) {
                count += word.length();
            }
        }
        return count;
    }*/

    public static int countCharacters(String[] words, String chars) {
        int[] table = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            table[chars.charAt(i) - 'a']++;
        }
        // 单词长度
        int count = 0;
        for (String str : words) {
            if (canSpellWords(str, table)) {
                count += str.length();
            }
        }
        return count;
    }

    public static boolean canSpellWords(String str, int[] table) {
        int[] tmp = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            // 临时表 和 字母表值相等，代表字母不存在
            if (tmp[now - 'a'] == table[now - 'a']) {
                return false;
            }
            tmp[now - 'a']++;
        }
        return true;
    }

    public static void main(String[] args) {
        int i = countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr");
        System.out.println(i);
    }
}
