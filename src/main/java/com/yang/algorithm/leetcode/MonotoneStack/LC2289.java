package com.yang.algorithm.leetcode.MonotoneStack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/9/3 23:12
 * @Version: 1.0
 */
public class LC2289 {
    public static void main(String[] args) {
        System.out.println(totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
    }

    public static int totalSteps(int[] nums) {
        Stack<List<Integer>> stack = new Stack<>();
        int res = 0;
        for (int num : nums) {
            int curMax = 0;
            while(!stack.isEmpty() && stack.peek().get(0) <= num) {
                curMax = Math.max(curMax, stack.pop().get(1));
            }
            curMax = stack.isEmpty() ? 0 : curMax + 1;
            res = Math.max(res, curMax);
            stack.push(Arrays.asList(num, curMax));
        }
        return res;
    }
}
