package com.testalgorithm.test.wangling;

class LeetCode110 {

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
//        treeNode.left = treeNode1;

        System.out.println(isBalanced(treeNode));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }else {
            return Math.abs(height(root.left)-height(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int height(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }else {
            return Math.max(height(treeNode.left), height(treeNode.right)) +1;
        }
    }

}
