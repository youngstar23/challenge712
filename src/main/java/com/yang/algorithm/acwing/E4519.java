package com.yang.algorithm.acwing;

/*import java.util.*;

public class E4519 {
    private static int n;
    private static int[] val;
    private static int[] place;
    private static boolean[] visited;
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        val = new int[n];
        place = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            val[i] = scanner.nextInt();
            if(map.containsKey(val[i])){
                map.put(val[i], map.get(val[i])+1);
            }
            else map.put(val[i], 1);
        }

        int deno = 1;
        for (Integer ele : map.keySet()) {
            deno *= factorialRecursive(map.get(ele.intValue()));
        }
        dfs(0);

        System.out.println(res/deno);
    }

    private static void dfs(int i) {
        if(i == n){
            if(judge()) ++res;
        }else{
            for(int j = 0; j < n; j++){
                if(!visited[j]){
                    visited[j] = true;
                    place[i] = val[j];
                    dfs(i+1);
                    visited[j] = false;
                }
            }
        }
    }

    private static boolean judge() {
        for (int i = 0; i < n-1; i++) {
            int tmp = (int) Math.sqrt(place[i]+place[i+1]);
            if(tmp * tmp != place[i] + place[i+1]) return false;
        }
        return true;
    }

    public static long factorialRecursive(int n) {
        // 阶乘对整数才有意义
        if (n < 0) {
            return -1;
        }

        // 0！=1，（0 的阶乘是存在的）
        if (n == 0) {
            return 1;
        }

        if (n < 2)
            return n * 1;
        return n * factorialRecursive(n - 1);
    }
}*/


import java.util.*;

public class E4519 {
    private static int n;
    private static int[] val;
    private static int[] place;
    private static boolean[] visited;
    private static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        val = new int[n];
        place = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            val[i] = scanner.nextInt();
            place[i] = -1;
        }
        Arrays.sort(val);

        dfs(0, -1);

        System.out.println(res);
    }

    private static void dfs(int u, int last) {
        if(u == n){
            ++res;
        }else{
            for(int j = 0; j < n; j++){
                if(j > 0 && !visited[j-1] && val[j] == val[j-1]) continue;
                if(!visited[j] && (judge(j, last) || u == 0)){
                    visited[j] = true;
                    place[u] = val[j];
                    dfs(u+1, val[j]);
                    visited[j] = false;
                }
            }
        }
    }

    private static boolean judge(int i, int last) {
        int tmp = (int) Math.sqrt(val[i] + last);
        return tmp * tmp == val[i] + last;
    }
}