package com.testalgorithm.test.wangling

class LeetCodeK110 {

}

fun main(args: Array<String>) {
    val treeNode = TreeNodeK()
    treeNode.value = 3

    val treeNode1 = TreeNodeK()
    treeNode1.value = 9

    val treeNode2 = TreeNodeK()
    treeNode2.value = 20

    val treeNode3 = TreeNodeK()
    treeNode3.value = 15

    val treeNode4 = TreeNodeK()
    treeNode4.value = 7

    treeNode2.left = treeNode3
    treeNode2.right = treeNode4

    treeNode.right = treeNode2
//        treeNode.left = treeNode1;
    println(isBalanced(treeNode))
    
    
}

fun isBalanced(root : TreeNodeK?) : Boolean{
    if (root == null){
        return true
    }else {
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)
    }
}

fun height(root: TreeNodeK?): Int {
    if (null == root){
        return 0
    }else {
        return Math.max(height(root.left), height(root.right)) + 1
    }
}

