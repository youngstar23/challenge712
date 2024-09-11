package com.yang.algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/9/12 0:13
 * @Version: 1.0
 */
public class LC0215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public static int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            while (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static int findKthLargest(int[] nums, int k) {
        int[] dp = new int[20010];
        for (int num : nums) {
            ++dp[num + 10000];
        }
        for (int j = dp.length - 1; j >= 0; j--) {
            if (k > dp[j]) {
                k -= dp[j];
            } else {
                return j - 10000;
            }
        }
        return -1;
    }
}
