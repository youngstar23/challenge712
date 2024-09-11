package com.yang.algorithm.acwing.Week24025;

import java.util.*;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/6/24 23:41
 * @Version: 1.0
 */
public class LC0503 {
    public static void main(String[] args) {

    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            int x = nums[i % n];
            while (!stack.isEmpty() && x > nums[stack.peek()]) {
                res[stack.pop()] = x;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }
}
