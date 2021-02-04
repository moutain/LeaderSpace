package com.testalgorithm.test.wangling;

/**
 * Created by tianjin on 2021/2/2
 * <p>
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode14 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        //解法一
        if(null == strs || strs.length <=0){
            return "";
        }

        String temp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            temp =compareStrings(temp, strs[i]);
            if (temp.length() == 0){
                break;
            }
        }
        return temp;


        //解法二
//        String mResult = strs[0];
//
//        for (int i = 0; i < mResult.length(); i++) {
//            char c = mResult.charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i)!= c){
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//        return mResult;

    }


    public static String compareStrings(String s1, String s2){
        int length = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index <length && s1.charAt(index) == s2.charAt(index)){
            index++;
        }
        return s1.substring(0, index);
    }

}
