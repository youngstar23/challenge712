package com.yang.algorithm.leetcode.MonotoneStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/8/25 11:16
 * @Version: 1.0
 */
public class LC0853 {
    public static void main(String[] args) {
        // System.out.println(carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        double[][] arr = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = (target - position[i]) * 1.0 / speed[i];
        }
        Arrays.sort(arr, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[0] == o2[0]) {
                    return (int) (o1[1] - o2[1]);
                }
                return (int) (o1[0] - o2[0]);
            }
        });
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()][1] <= arr[i][1]) {
                stack.pop();
            }
            stack.push(i);
        }
        return stack.size();
    }
}
