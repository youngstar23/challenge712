package com.yang.algorithm.acwing.Week24025;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: YangHaoDong
 * @Description:
 * @Date: 2024/6/25 23:40
 * @Version: 1.0
 */
public class LC2732 {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0}, {0,0,0,1}, {1,1,1,1}};
        System.out.println(goodSubsetofBinaryMatrix(grid));
    }

    public static List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            if (Arrays.stream(grid[i]).sum() == 0) {
                res.add(i);
                return res;
            }

            for (int j = 0; j < grid.length; j++) {
                if (i == j) {
                    continue;
                }
                boolean flag = true;
                for (int k = 0; k < grid[j].length; k++) {
                    if (grid[i][k] + grid[j][k] > 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        return res;
    }
}
