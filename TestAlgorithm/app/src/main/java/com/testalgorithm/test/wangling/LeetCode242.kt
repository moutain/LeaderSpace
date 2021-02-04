package com.testalgorithm.test.wangling

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.HashMap

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode242 {

}

@RequiresApi(Build.VERSION_CODES.N)
fun mainTest(){
    val s = "anaram"
    val t = "naraam"
    println(isAnagram(s, t).toString())
}

@RequiresApi(Build.VERSION_CODES.N)
fun isAnagram(s: String, t:String): Boolean {
    if (null == s || null == t || s.length != t.length) {
        return false
    }

    var map : MutableMap<Char, Int>  = HashMap()
    for (i in 0 until  s.length){
        var value = s[i]
        map[value] = map.getOrDefault(value, 0) + 1
    }
    for (i in 0 until t.length){
        var value = t[i]
        map[value] = map.getOrDefault(value, 0) -1
        if (map[value]!! < 0) {
            return false
        }
    }

    return true
}


//fun isAnagram(s: String, t:String): Boolean {
//    if (null == s || null == t || s.length != t.length) {
//        return false
//    }
//    var tables = IntArray(26)
//    for (i in 0 until s.length) {
//        tables[s[i] - 'a']++
//    }
//    for (i in 0 until t.length) {
//        tables[t[i] - 'a']--
//        if (tables[t[i] - 'a'] < 0) {
//            return false
//        }
//    }
//    return true
//}
//
//fun isAnagram(s: String, t:String): Boolean {
//    if (null == s || null == t || s.length != t.length) {
//        return false
//    }
//    val chars = s.toCharArray()
//    val chart = t.toCharArray()
//    Arrays.sort(chars)
//    Arrays.sort(chart)
//    return Arrays.equals(chars, chart)
//
//}


@RequiresApi(Build.VERSION_CODES.N)
fun main(args: Array<String>) {
    mainTest()
}