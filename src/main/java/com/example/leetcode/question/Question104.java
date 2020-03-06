package com.example.leetcode.question;

import com.example.leetcode.entity.TreeNode;

/**
 * Question104
 *
 * @author shentao
 * @date 2020/2/28
 */
public class Question104 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.addLeft(9);
        TreeNode treeNode = root.addRight(20);
        treeNode.addRight(7);
        treeNode.addLeft(15);
        int count = maxDepth(root);
        System.out.println(count);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = hasChildNode(root) + 1;
        return count;
    }

    private static int hasChildNode(TreeNode treeNode) {
        if (treeNode.left != null || treeNode.right != null) {
            int left = 0;
            int right = 0;
            if (treeNode.left != null) {
                left = hasChildNode(treeNode.left);
            }
            if (treeNode.right != null) {
                right = hasChildNode(treeNode.right);
            }
            return left > right ? ++left : ++right;
        } else {
            return 0;
        }
    }

}
