package com.yang.algorithm.acwing;

import java.util.Scanner;

public class E3588 {
    public static void main(String[] args) {
        /*String s = "111011000100000";
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 2 + s.charAt(i)-'0';
        }
        System.out.println(res);*/

        Scanner scanner = new Scanner(System.in);
        int n, m, res;
        while(true){
            n = scanner.nextInt();
            m = scanner.nextInt();
            res = 0;
            if(n == 0 && m == 0){
                break;
            }
            for(int i = n-m+1; i <= n; i++){
                res += countZero(i);
            }
            System.out.println(res);
        }
    }

    private static int countZero(int val) {
        /*String s = "";
        while(val != 0){
            s = val % 2 + s;
            val /= 2;
        }
        System.out.println(s);*/

        int res = 0;
        while(val != 0){
            if(val % 2 == 0) ++ res;
            else break;
            val /= 2;
        }
        return res;
    }
}
