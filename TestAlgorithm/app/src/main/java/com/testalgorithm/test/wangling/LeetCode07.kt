package com.testalgorithm.test.wangling

/**
 * 7. 整数反转
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。


示例 1：

输入：x = 123
输出：321
示例 2：

输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0
 */
class LeetCode07 {


}

fun reverse(x : Int): Int{
    var res = 0
    var x2 = x
    while (x2 != 0){
        var temp : Int = x2 % 10
        if (res > Int.MAX_VALUE /10 ||(res == Int.MAX_VALUE/10 && temp > 7)){
            return 0
        }
        if (res < Int.MIN_VALUE/10 || (res == Int.MIN_VALUE/10 && temp< -8)){
            return 0
        }
        res = res * 10 +temp
        x2 /= 10
    }
    return res
}

fun main(args: Array<String>) {

    println(Integer.MAX_VALUE)
    println(reverse(123))

}