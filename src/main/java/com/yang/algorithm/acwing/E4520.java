package com.yang.algorithm.acwing;

import java.util.Scanner;

public class E4520 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, x;
        boolean flag;
        t = scanner.nextInt();
        while(t-- != 0){
            x = scanner.nextInt();
            flag = false;
            for(int i = 10; ; i=i*10){
                for (int j = i/10; j < i; j++){
                    int val = x * i + j;
                    if(judge(val)) {
                        flag = true;
                        System.out.println(val);
                        break;
                    }
                }
                if(flag) break;
            }
        }
    }

    private static boolean judge(int val) {
        for(int i = 2; i <= val / i; i++){
            if(val % i == 0) return false;
        }
        return true;
    }
}
