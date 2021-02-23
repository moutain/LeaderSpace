package com.testalgorithm.test.tianjin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by tianjin on 2021/2/23
 * 层级遍历
 *
 * 可以看binaryTree-TreeNode
 */
class LC102 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);

        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrderDFS(treeNode);
        System.out.println("result:"+result.toString());

        List<List<Integer>> result2= levelOrderBFS(treeNode);
        System.out.println("result:"+result2.toString());
    }

    /**
     * 层次遍历(DFS 深度优先遍历)
     *
     * @param root
     * @return
     */
    static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res , 0);
        return res;
    }

    /**
     *
     * 通过递归方式先遍历左边再遍历右边，一级一级的
     *
     * @param root 树
     * @param res 结果
     * @param level 层数
     */
    static void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        // 创建层的，第一次level为0
        if (level == res.size()) {
            // 当层数和加入对象相等时，说明将加入新的，那么要加入空的对象List<Integer>
            res.add(new ArrayList<Integer>());
        }
        // 获取到当前层级的，加入节点, 因为深度是左边，同层的右边后加入
        res.get(level).add(root.val);

        // 递归左边
        dfs(root.left, res, level + 1);
        // 递归右边
        dfs(root.right, res, level + 1);
    }

    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

          TreeNode() {}
          TreeNode(int val) {
              this.val = val;
          }

          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    /**
     * 层次遍历(BFS 广度优先遍历)
     *
     * 用队列(先进先出)作为辅助结构，我们先将根节点放到队列中，然后不断遍历队列
     *
     * @param root
     * @return
     */
    static List<List<Integer>> levelOrderBFS(TreeNode root) {
        List result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // offer 添加根节点，第一层
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                // 获取并移除此列表的头
                TreeNode head = queue.poll();
                // 当前层节点数据
                level.add(head.val);

                if (head.left != null) {
                    // 下一层的左边节点加入到队列
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    // 下一层的右边节点加入到队列
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }




}
