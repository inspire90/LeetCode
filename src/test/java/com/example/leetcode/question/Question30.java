package com.example.leetcode.question;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * @ClassName: Question30
 * @Description: TODO
 * @author: shentao
 * @date: 2020/2/11  16:27
 */
public class Question30 {
    public static void main(String[] args) {
        List<Integer> list = findSubstring("ababaab", new String[]{"ab", "ba", "ba"});
        list.forEach(System.out::println);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if ("".equals(s) || words.length == 0) {
            return result;
        }
        int len = Stream.of(words).mapToInt(String::length).sum();
        int count = 0;
        Map<Integer, String> map = new LinkedHashMap<>(words.length);
        for (int i = 0; i <= s.length() - len; ) {
            String temp = s.substring(i, i + len);
            String word = words[count];
            int index = temp.indexOf(word);
            for (Integer key : map.keySet()) {
                if (map.get(key).equals(words[count])) {
                    int position = words[count].length() + key;
                    index = temp.indexOf(word, position);
                }
            }
            if (index == -1) {
                map.clear();
                count = 0;
                i++;
                continue;
            }
            map.put(index, words[count]);
            count++;
            if (map.keySet().size() == words.length && isMatch(map)) {
                result.add(i);
                map.clear();
                i++;
                count = 0;
            }
        }
        return result;
    }

    private static boolean isMatch(Map<Integer, String> map) {
        Map<Integer, String> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oleValue, newValue) -> oleValue, LinkedHashMap::new));
        Iterator<Integer> iterator = result.keySet().iterator();
        Integer first = iterator.next();
        int len = result.get(first).length() + first;
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            if (key != len) {
                return false;
            } else {
                len = result.get(key).length() + key;
            }
        }
        return true;
    }

    /*public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        return null;
    }

    private static int isMatch(String s, String[] words, int i) {
        if (s.indexOf(words[i]) == -1) {
            return -1;
        }
        String[] split = s.split(words[i]);
        for (int j = 0; j < split.length; j++) {
            if (isMatch(split[j], words, j) == -1) {
                return -1;
            }
        }
        return i;
    }*/
}
