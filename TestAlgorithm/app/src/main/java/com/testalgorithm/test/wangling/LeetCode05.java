package com.testalgorithm.test.wangling;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode05 {


    public static void main(String[] args) {

        String s = "bacdc";
        System.out.println(longestPalindrome(s));

    }

    public static String longestPalindrome2(String s){
        int len = s.length();
        if (len < 2){
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < len - 1; i++) {
            String oddString = centerSpread(s, i,i);
            String evenString = centerSpread(s, i, i+1);
            String maxLenString = oddString.length() > evenString.length()?oddString: evenString;
            if (maxLenString.length() > maxLen){
                maxLen = maxLenString.length();
                res = maxLenString;
            }

        }
        return  res;

    }

    public static String centerSpread(String s, int left, int right){
        int len = s.length();
        int i = left;
        int j = right;
        while(i >= 0 && j < len){
            if (s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else {
                break;
            }
        }
        return s.substring(i+1, j);
    }





    /**
     * 暴力解法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        int maxLength = 1;
        int begin = 0;

        char[] charArrays = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j <len; j++) {
                if (j - i +1 > maxLength && validPalindromic(charArrays, i, j)){
                    maxLength = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLength);
    }

    public static boolean validPalindromic(char[] charArray, int left, int right){
        while (left < right){
            if (charArray[left]  != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }





}
