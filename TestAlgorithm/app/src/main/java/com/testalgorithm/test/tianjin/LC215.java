package com.ttjj.datastructureandalgorithm.sort;

import com.testalgorithm.test.tianjin.QuickSort;

/**
 * Created by tianjin on 2021/1/28
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 如果要求高点：编程实现 O(n) 时间复杂度内找到一组数据的第 K 大元素？
 *
 * 需要时间复杂度在O（n）内，需要使用《快速排序方法，并且优化》，思路：我们选择数组区间 A[0...n-1]的最后一个元素 A[n-1]作为 pivot，对数组 A[0...n-1]原地分区，这样数组就分成了三部分，A[0...p-1]、A[p]、A[p+1...n-1]。
 *
 * 关键点：如果 p+1=K，那 A[p]就是要求解的元素；如果 K>p+1, 说明第 K 大元素出现在 A[p+1...n-1]区间，我们再按照上面的思路递归地在 A[p+1...n-1]这个区间内查找。
 *
 * 我们再来看，为什么上述解决思路的时间复杂度是 O(n)？第一次分区查找，我们需要对大小为 n 的数组执行分区操作，需要遍历 n 个元素。
 * 第二次分区查找，我们只需要对大小为 n/2 的数组执行分区操作，需要遍历 n/2 个元素。依次类推，分区遍历元素的个数分别为、n/2、n/4、n/8、n/16.……直到区间缩小为 1。
 * 如果我们把每次分区遍历的元素个数加起来，就是：n+n/2+n/4+n/8+...+1。这是一个等比数列求和，最后的和等于 2n-1。所以，上述解决思路的时间复杂度就为 O(n)。
 *
 * 从leetcode题解中看，还有其他方法
 *
 */
class LC215 {

    /**
     *
     * 先用冒泡排序,时间复杂度在O(n的2次方)，然后n-k得到第K大元素
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestByBubbleSort(int[] nums, int k) {
        int length = nums.length;
        // 冒泡排序每次计算得到最大的放到最后
        for (int i= 0; i < length-1; i++) {
            // 出现问题，j=0开始，不是j=i
            for (int j=0; j< length -i -1; j++ ) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

//        for (int h=0; h< length;h++) {
//            System.out.println("num[h]" + nums[h]);
//        }
        return nums[length-k];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,1,5,6,4};
        int find1 = findKthLargestByBubbleSort(nums1, 2);
        System.out.println("find1 = " + find1);


        int[] nums2 = new int[]{3,2,3,1,2,4,5,5,6};
        int find2 = findKthLargestByBubbleSort(nums2, 4);
        System.out.println("find1 = " + find2);

        int[] nums3 = new int[]{3,2,1,5,6,4};
        int find3 = findKthLargestByQuickSort(nums3, 2);
        System.out.println("find3 = " + find3);

        int[] nums4 = new int[]{3,2,3,1,2,4,5,5,6};
        int find4 = findKthLargestByQuickSort(nums4, 4);
        System.out.println("find4 = " + find4);
    }

    /**
     * 通过快速排序O(nlogn)来排序，并且通过二分，优化一下为O（n）
     *
     * 代码参考：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
     *
     * 题解2
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestByQuickSort(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len -1;

        // 转换一下，第K大的元素索引就是len - k，关键
        int target = len - k;

        // 一直循环
        while (true) {
            // 分区的下标
//            int index = partition(nums, left, right);
            // 获取分区基准下标，喜欢这种方式
            int index = QuickSort.qSort(nums, left, right);
            if (index == target) {
                // 直到分区的基准下标正好等于第K大元素的下标
                return nums[index];
            } else if (index < target) {
                left = index +1 ;
            } else if (index > target){
                right = index -1;
            }
        }
    }

    /**
     * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的语义
     * 1、[left + 1, j] < nums[left]
     * 2、(j, i] >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] nums, int left, int right) {
        // 左边基准
        int pivot = nums[left];
        int j = left;
        for (int i = left+1; i <= right ; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}


