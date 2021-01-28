package com.testalgorithm.test.tianjin;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为较小和较大的2个子序列，然后递归地排序两个子序列。
 *
 * 步骤为：
 *
 * 1:挑选基准值：从数列中挑出一个元素，称为“基准”（pivot），
 * 2:分割：重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（与基准值相等的数可以到任何一边）。在这个分割结束之后，对基准值的排序就已经完成，
 * 3:递归排序子序列：递归地将小于基准值元素的子序列和大于基准值元素的子序列排序。
 * 4:递归到最底部的判断条件是数列的大小是零或一，此时该数列显然已经有序。
 *
 * https://juejin.cn/post/6844903763044483086#heading-23
 */
public class QuickSort {

    public static void main(String[] args) {
//        int arr[] = {72, 6, 57, 88, 60, 42,83,73,48,85};
        int arr[] = {8, 10, 2, 3, 6, 1, 5};
        quickSort(arr, 0 ,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right){
            int temp = qSort(arr, left, right);
            // 这边分区
            quickSort(arr, left, temp-1);
            quickSort(arr, temp+1, right);
        }
    }

    /**
     * 排序过程, 过程分区
     *
     * 思路：每一轮分区以左边第一个为基准，先从右边找到一个小于基准的数（如果大于right的位置-1一直找到小于基准的），放到左边位置，左边位置+1，
     * 然后从左边找到一个大于基准的数（如果一直小于等于，left就+1），放到右边位置，左边继续+1，结束一轮分区以最后的left=right，让temp给基准的位置
     *
     * @param arr
     * @param left 带排序最小下标
     * @param right 带排序最大下标
     * @return 排好序之后基准数的位置下标，方便下次的分区
     */
    public static int qSort(int[] arr, int left, int right) {
        int temp=arr[left];//定义基准数，默认为数组的第一个元素
        while(left<right) {//循环执行的条件
            //因为默认的基准数是在最左边，所以首先从右边开始比较进入while循环的判断条件
            //如果当前arr[right]比基准数大，则直接将右指针左移一位，当然还要保证left<right
            while(left<right && arr[right]>temp) {
                right--;
            }
            // 跳出循环说明一个数当前的arr[right]比基准数要小，那么直接将当前数移动到基准数所在的位置，并且左指针向右移一位（left++）
            // 这时当前数（arr[right]）所在的位置空出，需要从左边找一个比基准数大的数来填充。
            if(left<right) {
                arr[left]=arr[right];
                left++;
            }
            //下面的步骤是为了在左边找到比基准数大的数填充到right的位置。
            //因为现在需要填充的位置在右边，所以左边的指针移动，如果arr[left]小于或者等于基准数，则直接将左指针右移一位
            while(left<right && arr[left]<=temp) {
                left++;
            }
            //跳出上一个循环说明当前的arr[left]的值大于基准数，需要将该值填充到右边空出的位置，然后当前位置空出。
            if(left<right) {
                arr[right]=arr[left];
                right--;
            }
        }
        //当循环结束说明左指针和右指针已经相遇。并且相遇的位置是一个空出的位置，
        //这时候将基准数填入该位置，并返回该位置的下标，为分区做准备。
        arr[left]=temp;
        return left;
    }

    public static void quickSortPractice(int[] arr, int left, int right){
        if (left < right) {
            int temp = qSortPractice(arr, left, right);
            quickSortPractice(arr, left, temp);
            quickSortPractice(arr, temp+1, right);
        }
    }

    public static int qSortPractice2(int[] arr, int left, int right){
        int temp = arr[left];
        while (left < right){
            while (left<right && arr[right] > temp){
                right--;
            }
            if (left< right) {
                arr[left++] = arr[right];
            }
            while (left < right && arr[left] <= temp){
                left--;
            }
            if (left < right) {
                arr[right++] = arr[left];
            }
        }
        arr[left] = temp;
        return left;
    }

    public static int qSortPractice(int[] arr, int left, int right){
        int temp = arr[left];
        while(left<right){
            while (left<right && arr[right]>temp){
                right--;
            }
            if (left<right){
                arr[left++] = arr[right];
            }
            while (left<right && arr[left] <= temp){
                left++;
            }
            if (left<right) {
                arr[right--]= arr[left];
            }
        }
        arr[left] = temp;
        return left;
    }

    public static int qSortPracticeTwo(int[] arr, int left, int right){
        int temp = arr[left];
        while(left < right){
            while (left<right && arr[right] > temp) {
                right--;
            }

            if (left<right) {
                arr[left] = arr[right];
                left++;
            }

            while (left < right && arr[left] <= temp) {
                left++;
            }

            if (left<right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = temp;
        return left;
    }



}
