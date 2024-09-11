package com.yang.algorithm.acwing;

import java.util.Scanner;

public class E4518 {
    private static int[] days;
    private static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        days = new int[n+1];
        dp = new int[n+1];
        for (int i = 1; i < days.length; i++) {
            days[i] = scanner.nextInt();
        }
        int[] costs = new int[3];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = scanner.nextInt();
        }

        for (int i = 1; i < days.length; i++) {
            dp[i] = dp[i-1] + costs[0];
            dp[i] = Math.min(dp[i], getValue(i, 7) + costs[1]);
            dp[i] = Math.min(dp[i], getValue(i, 30) + costs[2]);
        }

        System.out.println(dp[n]);
    }

    private static int getValue(int i, int interval) {
        int fore = i;
        while(fore > 0 && (days[i] - days[fore] + 1 <= interval)) --fore;
        return dp[fore];
    }
}
