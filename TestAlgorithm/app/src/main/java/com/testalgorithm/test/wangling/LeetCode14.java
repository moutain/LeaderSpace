package com.testalgorithm.test.wangling;


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
