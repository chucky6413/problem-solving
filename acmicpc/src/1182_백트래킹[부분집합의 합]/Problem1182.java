/*
 * 2017.03.23
 * ��Ʈ��ŷ,����Ž��
 *
 * @problem https://www.acmicpc.net/problem/1182
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem1182 {
    static int N, S, result = 0, count = 0;
    static List<Integer> list = new LinkedList<Integer>();
    static String temp[];

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        S = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");
        for (int i = 0; i < temp.length; i++) {
            list.add(Integer.parseInt(temp[i]));
        }

        solve(0); //Ž��
        System.out.println(count);
    }

    public static void solve(int index) {
        if (index == N) return; //������ ����
        if (result + list.get(index) == S) count++;

        solve(index + 1); //���� ���� �ֱ�

        result += list.get(index); //�̹� �� �����ؼ�
        solve(index + 1); //���� ���� �ֱ�

        result -= list.get(index); //�� ���ֱ�
    }
}