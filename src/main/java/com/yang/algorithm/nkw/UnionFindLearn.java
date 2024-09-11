package com.yang.algorithm.nkw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UnionFindLearn {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //https://www.jb51.net/article/231504.htm
        String str;
        List<String> list = new ArrayList<>();
        while(!"abc".equals(str = bf.readLine())){ //(str = bf.readLine()) != null
            list.add(str);
        }

        int N = list.size();
        int[][] adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = list.get(i).split(" ");
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(split[j]);
            }
        }

        UnionFind uf = new UnionFind(N);
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if(adj[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }

        System.out.println("连通子图的数量为"+uf.count);
    }

    public static class UnionFind{
        int[] parent;
        int count; //count是连通图的数量

        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
        }

        public int find(int x){
            if(x == parent[x]) return x;
            else{
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }

        public void union(int x, int y){
            int xPar = find(x);
            int yPar = find(y);
            if(xPar == yPar) return; //如果拥有共同的祖先就跳出
            parent[xPar] = yPar;
            count--;
        }
    }
}
