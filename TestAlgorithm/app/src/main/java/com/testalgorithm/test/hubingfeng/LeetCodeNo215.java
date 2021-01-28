package com.testalgorithm.test.hubingfeng;

public class LeetCodeNo215 {

    public static void main(String[] args) {
        int[] inits = {3, 2, 1, 5, 6, 4, 3, 3, 4,0};
        System.out.println("第K大：" + findKthLargest(inits, 10));
    }

    public static int findKthLargest(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            makeBigHeap(arr, 0, arr.length - 1 - i);
            swap(arr, 0, arr.length - 1 - i);
        }
        return arr[arr.length - k];
    }

    public static void makeBigHeap(int[] arr, int start, int end) {
        for (int i = end - start / 2 - 1; i >= 0; i--) { //完全二叉树第i个节点的左右子树2i+1 2i+2 从最后一个非叶子节点出发
            adjustHeap(arr, i, end - start);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {///如果子节点大于父节点，将子节点值赋给父节点
                arr[i] = arr[k];
                i = k; //
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
