package com.example.leetcode.question;

/**
 * @ClassName: Question67
 * @Description: TODO
 * @author: shentao
 * @date: 2020/2/8  19:24
 */
public class Question67 {
    public static void main(String[] args) {
        String a = new String("110110"), b = new String("1001");
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sbf = new StringBuilder();
        carry(a, b, sbf, 1, false);
        return sbf.toString();
    }

    private static void carry(String a, String b, StringBuilder sbf, int i, boolean isAddOne) {
        if (i > a.length()) {
            if (!isAddOne) {
                sbf.insert(0, b.substring(0, b.length() - i + 1));
            } else {
//                System.out.println("1a:" + a + ",b:" + b + ",isAddOne:" + isAddOne);
                carry(b.substring(0, b.length() + 1 - i), "1", sbf, 1, false);
            }
            return;
        }
        if (i > b.length()) {
            if (!isAddOne) {
                sbf.insert(0, a.substring(0, a.length() - i + 1));
            } else {
//                System.out.println("2a:" + a + ",b:" + b + ",isAddOne:" + isAddOne);
                carry(a.substring(0, a.length() + 1 - i), "1", sbf, 1, false);
            }
            return;
        }
        char achar = a.charAt(a.length() - i);
        char bchar = b.charAt(b.length() - i);
        int count = 0;
        if (isAddOne) {
            count++;
            isAddOne = false;
        }
        if (achar == '1') {
            count++;
        }
        if (bchar == '1') {
            count++;
        }
        if (count == 3) {
            sbf.insert(0, "1");
            isAddOne = true;
        }
        if (count == 2) {
            sbf.insert(0, "0");
            isAddOne = true;
        }
        if (count == 1) {
            sbf.insert(0, "1");
        }
        if (count == 0) {
            sbf.insert(0, "0");
        }
        i++;
        if (a.length() < i && b.length() < i) {
            if (isAddOne) {
                sbf.insert(0, "1");
            }
            return;
        } else {
            carry(a, b, sbf, i, isAddOne);
        }
    }
}
