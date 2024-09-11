package com.yang.algorithm.acwing;

import java.util.Scanner;

class Node{
    int val;
    Node next;
}

public class E3559 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int num;
        for (int i = 0; i < T; i++) {
            num = scanner.nextInt();
            Node pCur = new Node();
            pCur.val = 1;
            Node head = pCur;
            for(int j = 2; j <= num; j++){
                pCur.next = new Node();
                pCur = pCur.next;
                pCur.val = j;
            }
            pCur.next = head;

            while(pCur != pCur.next){
                Node tmp = pCur.next.next;
                System.out.print(tmp.next.val + " ");
                tmp.next = tmp.next.next;
                pCur = tmp;
            }
            System.out.println(pCur.val);
        }
    }
}
