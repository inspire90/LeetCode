package com.example.leetcode.question;

import com.sun.org.apache.xerces.internal.xinclude.XPointerElementHandler;

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
        long time = System.currentTimeMillis();
        System.out.println("----------------------start-----------------");
        List<Integer> list = findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
                new String[]{"fooo", "barr", "wing", "ding", "wing"});
        System.out.println("duration = " + (System.currentTimeMillis() - time) / 1000);
        list.forEach(System.out::println);
    }

    /*public static List<Integer> findSubstring(String s, String[] words) {
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
    }*/

    /*public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if ("".equals(s) || words.length == 0) {
            return result;
        }
        int step = words[0].length();
        int len = step * words.length;
        for (int i = 0; i <= s.length() - len; i++) {
            String temp = s.substring(i, i + len);
            Map<Integer, Integer> map = new HashMap<>(words.length);
            for (int count = 0; count < words.length; count++) {
                int begin = count * step;
                String stepStr = temp.substring(begin, begin + step);
                for (int j = 0; j < words.length; j++) {
                    String word = words[j];
                    if (stepStr.equals(word) && !map.containsKey(begin) && !map.containsValue(j)) {
                        map.put(begin, j);
                    }
                }
                if (map.entrySet().size() == words.length) {
                    result.add(i);
                }
            }
        }
        return result;
    }*/

    /*public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if ("".equals(s) || words.length == 0) {
            return result;
        }
        int step = words[0].length();
        int len = step * words.length;
        for (int i = 0; i <= s.length() - len; i++) {
            String temp = s.substring(i, i + len);
            Map<String, Integer> map = new LinkedHashMap<>(words.length);
            int position = 0;
            for (int count = 0; count < words.length; count++) {
                int index = temp.indexOf(words[count], position);
                if (index == -1 || index % step != 0) {
                    break;
                }
                if (map.containsKey(words[count])) {
                    position = index + step;
                    index = temp.indexOf(words[count], position);
                    if (index == -1 || index % step != 0) {
                        break;
                    }

                }
                map.put(words[count], index);
                if (map.keySet().size() == words.length) {
                    result.add(i);
                }
            }
        }
        return result;
    }*/

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if ("".equals(s) || words.length == 0) {
            return result;
        }
        int step = words[0].length();
        int len = step * words.length;
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            if (countMap.containsKey(word)) {
                int count = countMap.get(word);
                count++;
                countMap.put(word, count);
            } else {
                countMap.put(word, 1);
            }
        }
        for (int i = 0; i <= s.length() - len; i++) {
            String word = s.substring(i, i + len);
            for (int j = 0; j < words.length; j++) {
                String temp = word.substring(j, j + step);
                if (countMap.containsKey(temp)) {
                    int count = countMap.get(temp);
                    if (count == 1) {
                        countMap.remove(temp);
                    } else {
                        count--;
                        countMap.put(temp, count);
                    }
                } else {
                    break;
                }
            }
            if (countMap.keySet().size() == 0) {
                result.add(i);
            }
        }
        return result;
    }

}
