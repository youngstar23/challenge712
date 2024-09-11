package com.yang.algorithm.leetcode.SlidingWindows;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/7/13 18:39
 * @Version: 1.0
 */
public class LC_05_2516 {
    public static void main(String[] args) {
        System.out.println(takeCharacters("aabaaaacaabc", 2));
    }

    public static int takeCharacters(String s, int k) {
        if (s.length() * 2 < k) {
            return -1;
        }
        int[] counts = new int[3];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            ++counts[c - 'a'];
        }
        for (int i = 0; i < 3; i++) {
            counts[i] -= 2;
        }
        int res = 0;
        for (int right = 0, left = 0; right < chars.length; right++) {
            int index = chars[right] - 'a';
            --counts[index];
            while (counts[index] < 0 && left < s.length()) {
                ++counts[chars[left++] - 'a'];
            }
            res = Math.max(res, right - left + 1);
        }
        return s.length() - res;
    }
}
