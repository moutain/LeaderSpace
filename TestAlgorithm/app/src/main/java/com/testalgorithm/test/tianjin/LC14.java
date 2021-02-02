package com.testalgorithm.test.tianjin;

import java.util.ArrayList;
import java.util.List;


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
class LC14 {

    /**
     * 手写，一直有问题，方向错了！
     *
     * 求最长公共前缀，"前缀"记住了，就是任何两个字符串的前缀要一样，不然就是空。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1){
            return strs[0];
        }
        String strFirst = strs[0];
        String publicStr = "";
        boolean isALLContain = false;
        boolean isNever = true;
        List<String> listResult = new ArrayList<>();
        // 第一个字符串中每一个字符，和后面的字符串中每一个字符比较
        for (int i = 0; i < strFirst.length(); i++) {
            // 一个字符
            char temp = strFirst.charAt(i);
            String tempStr = String.valueOf(temp);

            // 循环后面的字符串
            for (int j = 1; j < length; j++) {
                // 第二个字符串等
                String strOther = strs[j];
                if (!strOther.contains(tempStr)) {
                    isALLContain = false;
                    isNever = false;
                    break;
                }
                isALLContain = true;
            }

            if (isALLContain) {
                publicStr += tempStr;
            }else{
                listResult.add(publicStr);
                publicStr = "";
            }
        }
        if (isNever) {
            return publicStr;
        }
        int max = 0;
        int position = 0;
        for (int k=0;k<listResult.size();k++) {
            String temp = listResult.get(k);
            if (temp.length() > max) {
                max = temp.length();
                position = k;
            }
        }
        return listResult.size() == 0 || position > 0? "" :listResult.get(position);

    }


    /**
     * 横向比较方法，通过相邻两个字符串比较内容
     * @param strs
     * @return
     */
    public static String longestCommonPrefixByLC(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;// 数组长度
        for (int i=1; i < count; i++) {
            prefix = longestCommonPrefixByLC(prefix, strs[i]);
            if (prefix.length() == 0) break;
        }
        return prefix;
    }

    public static String longestCommonPrefixByLC(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        // 比较两个字符串，相等的部分，加加
        while(index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        // 取前缀中的相同部分
        return str1.substring(0, index);
    }

    public static void main(String[] args){
//        String[] strs = new String[]{"flower","flow","flight"};
//        String[] strs = new String[]{"dog","racecar","car"};
//        String[] strs = new String[]{"a"};
//        String[] strs = new String[]{"cir","car"};
//        String[] strs = new String[]{"",""};
//        String[] strs = new String[]{"reflower","flow","flight"};
//        String[] strs = new String[]{"flower","flower","flower"};
//        String pubStr = longestCommonPrefix(strs);
//        System.out.println("最长公共前缀:"+pubStr);


        String[] strs = new String[]{"flower","flow","flight"};
//        String[] strs = new String[]{"dog","racecar","car"};
//        String[] strs = new String[]{"a"};
//        String[] strs = new String[]{"cir","car"};
//        String[] strs = new String[]{"",""};
//        String[] strs = new String[]{"reflower","flow","flight"};
//        String[] strs = new String[]{"flower","flower","flower"};
        String pubStr = longestCommonPrefixByLC(strs);
        System.out.println("最长公共前缀:"+pubStr);
    }
}
