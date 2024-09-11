package com.yang.algorithm.acwing;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), ans = 0;
        int[] nums = new int[n+1];
        int[] res = new int[n+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[i]) ++res[nums[i]];
            }
        }
        for (int i = 1; i < res.length; i++) {
            System.out.print(res[i] + " ");
            ans += res[i];
        }
        System.out.println("\n" + ans);*/

        String[] strArr = {null, "123"};
        for (String str : strArr) {
            Optional<String> optionalStr = Optional.ofNullable(str);
            if (optionalStr.isPresent()) {
                System.out.println(optionalStr.get());
            } else {
                System.out.println("N");
            }
        }
    }
}
