package com.testalgorithm.test.wangling

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.HashMap

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