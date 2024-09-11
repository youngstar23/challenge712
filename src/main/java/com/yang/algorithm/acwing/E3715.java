package com.yang.algorithm.acwing;

import java.util.Scanner;

public class E3715 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n+1];
        int[] exchanges = new int[n+1];
        int sum = 0;
        for(int i = 1; i <= n; i++){
            nums[i] = scanner.nextInt();
        }
        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(nums[j] > nums[i]) ++exchanges[nums[i]];
            }
        }
        for (int i = 1; i < exchanges.length; i++) {
            System.out.print(exchanges[i] + " ");
            sum += exchanges[i];
        }
        System.out.println("\n" + sum);
    }
}
