package com.example.leetcode.question;

public class Question1346 {
    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                    System.out.println(i + "," + j);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean exist = checkIfExist1(new int[]{-2, 0, 10, -19, 4, 6, -8});
        System.out.println(exist);
    }

    public static boolean checkIfExist1(int[] arr) {
        int offset = 2001;
        boolean[] flag = new boolean[4002];
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (flag[curr * 2 + offset] ||
                    (((curr & 1) == 0) && flag[curr / 2 + offset])
            )
                return true;
            flag[arr[i] + offset] = true;
        }
        return false;
    }
}
