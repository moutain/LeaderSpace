package com.testalgorithm.test.tianjin;

import java.util.Arrays;

/**
 * Created by tianjin on 2021/2/4
 *
 * 242. 有效的字母异位词 = (翻译：字符长度相等，内部的字符一样，但是顺序可能不对)
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
class LC242 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }

    public static void main(String[] args) {
        String s = "anagram";
//        String t = "nagaram";
//        String t = "anagram";
        String t = "bagaram";
        System.out.println("s and t isAnagram = " + isAnagram(s,t));
        System.out.println("s and t isAnagram = " + isAnagram2(s,t));
    }

    /**
     * https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i=0; i< s.length();i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i=0; i< t.length();i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }



}
