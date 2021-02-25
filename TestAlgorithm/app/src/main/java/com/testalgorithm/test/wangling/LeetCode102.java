package com.testalgorithm.test.wangling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
class LeetCode102 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 3;

        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 9;

        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 20;

        TreeNode treeNode3 = new TreeNode();
        treeNode3.val = 15;

        TreeNode treeNode4 = new TreeNode();
        treeNode4.val = 7;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        treeNode.right =  treeNode2;
        treeNode.left = treeNode1;

        List<List<Integer>> listList = levelOrder(treeNode);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;

    }

}
