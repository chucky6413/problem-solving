/*
 * 2017.04.09
 * Ž��,����
 * 
 * @problem https://www.acmicpc.net/problem/1026
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem1026 {
    static int n, s = 0;
    static int a[];
    static Integer b[];

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tempA[], tempB[];

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new Integer[n];

        tempA = br.readLine().split(" ");
        tempB = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tempA[i]);
            b[i] = Integer.parseInt(tempB[i]);
        }
        //b�� ���� ū �͵�� a�� ���� ���� �͵��� ��Ī���ָ� �ȴ�.

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        for (int i = 0; i < n; i++) { //���.. function s()
            s += (a[i] * b[i]);
        }
        System.out.println(s);
    }
}