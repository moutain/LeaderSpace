package com.testalgorithm.test.tianjin;

/**
 * Created by tianjin on 2021/2/18
 *
 * 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果是判断回文串，看leetcode 9. 回文串
 *
 */
class LC05 {

    public static void main(String[] args){
        String x1 = "1234554321";
        System.out.println("最长回文串:"+ longestPalindrome(x1));
        String x2 = "1234564321";
        System.out.println("最长回文串:"+ longestPalindrome(x2));
    }

    /**
     * 暴力解法
     *
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        // 先选中一个，然后从后排列，然后循环选择第二个，再排列
        for (int i=0; i < len -1;i++) {
            for (int j= i+1; j < len;j++) {
                // 如果是回文串，且当前长度大于之前的，就更新长度和begin
                if (j-i+1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i +1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

    /**
     * 通过字符的左右下标移动来验证内容，可以验证子串 s[left..right] 是否为回文串
     *
     */
    private static boolean validPalindromic(char[] charArray, int left, int right){
        while(left<right){
            if(charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 动态规划 还需看
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {


        return "";
    }

}
