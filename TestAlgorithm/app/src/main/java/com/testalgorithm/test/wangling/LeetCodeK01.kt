package com.testalgorithm.test.wangling

import java.util.*
import kotlin.collections.HashMap
import kotlin.coroutines.*
class LeetCodeK01 {

}

fun main(args: Array<String>) {
    var nums = intArrayOf(2, 7, 3,4)
    var result = twoSum(nums, 9)
    for (i in result){
        println(result[i])
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray{
    val map : MutableMap<Int, Int> = HashMap()
    for (i in nums.indices){
        if (map.containsKey(target-nums[i])){
            return intArrayOf(map[target-nums[i]]!!, i)
        }
        map[nums[i]] = i
    }
    return IntArray(0)
}


//fun twoSum(nums: IntArray, target: Int): IntArray? {
//    val map: MutableMap<Int, Int?> = HashMap()
//    for (i in nums.indices) {
//        if (map.containsKey(target - nums[i])) {
//            return intArrayOf(map[target - nums[i]]!!, i)
//        }
//        map[nums[i]] = i
//    }
//    return IntArray(0)
//}