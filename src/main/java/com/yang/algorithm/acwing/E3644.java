package com.yang.algorithm.acwing;

import java.util.ArrayList;
import java.util.Scanner;

public class E3644 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 100; i <= 999; i++){
            int num = i, res = 0, val;
            while(num != 0){
                val = num % 10;
                num /= 10;
                res += val * val * val;
            }
            if(i == res) arrayList.add(res);
        }
        while(true){
            int m, n, flag = 0;
            m = scanner.nextInt();
            n = scanner.nextInt();
            if(m == 0 && n == 0) break;
            for (Integer val : arrayList) {
                if(val.intValue() >= m && val.intValue() <= n){
                    System.out.print(val.intValue() + " "); flag = 1;
                }
            }
            if(flag == 0) System.out.println("no");
            else System.out.println();
        }
    }
}
