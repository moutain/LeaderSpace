package com.testalgorithm.test.wangling;
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
