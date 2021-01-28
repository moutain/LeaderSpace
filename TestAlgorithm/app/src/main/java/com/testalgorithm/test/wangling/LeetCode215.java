package com.testalgorithm.test.wangling;

/**
 * 快速排序后 倒数第K个值即为 答案
 */
class LeetCode215 {

    public static void main(String[] args) {
        int[] inits = {3,2,1,5,6,4,3,4};
        System.out.println("第K大：" + findKthLargest(inits, 5));
    }

    public static int findKthLargest(int[] inits, int k){
        sort(inits, 0, inits.length -1);
        for (int num: inits){
            System.out.println(num);
        }
        return inits[inits.length - k];
    }

    public static void sort(int[] nums, int left, int right){
        if (left > right){
            return;
        }

        int i = left, j = right;
        int base = nums[left];

        while (i != j){
            while (nums[j] >=base && i < j){
                j--;
            }
            while (nums[i] <=base && i < j){
                i++;
            }
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        nums[left] = nums[i];
        nums[i] = base;
        sort(nums, left, i -1);
        sort(nums, i + 1, right);

    }






}
