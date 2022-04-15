package com.testalgorithm.test.wangling;
import java.util.*;

public class HJ58 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){

            String input = scanner.nextLine();
            char[] chars=input.toCharArray();
            for(int i = 0; i < chars.length; i++){
                if(chars[i]>='A' && chars[i]<'Z'){
                    chars[i]= (char) (chars[i] + 32+1);
                }else if(chars[i] =='Z'){
                    chars[i] = 'a';
                }else if(chars[i]>='a' && chars[i]<='c'){
                    chars[i] = '2';
                }else if(chars[i]>='d' && chars[i]<='f'){
                    chars[i] = '3';
                }else if(chars[i]>='g' && chars[i]<='i'){
                    chars[i] = '4';
                }else if(chars[i]>='j' && chars[i]<='l'){
                    chars[i] = '5';
                }else if(chars[i]>='m' && chars[i]<='o'){
                    chars[i] = '6';
                }else if(chars[i]>='p' && chars[i]<='s'){
                    chars[i] = '7';
                }else if(chars[i]>='t' && chars[i]<='v'){
                    chars[i] = '8';
                }else if(chars[i]>='w' && chars[i]<='z'){
                    chars[i] = '9';
                }
                System.out.print(chars[i]);
            }
            System.out.println();

        }

    }
}