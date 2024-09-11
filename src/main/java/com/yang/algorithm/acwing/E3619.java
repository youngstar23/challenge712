package com.yang.algorithm.acwing;

import java.util.Scanner;

public class E3619 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m, d, res = 6;
        m = scanner.nextInt();
        d = scanner.nextInt();
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] outputs = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for(int i = 4; i < m; i++){
            res += days[i];
        }
        res += d;
        System.out.println(outputs[res % 7]);
    }
}