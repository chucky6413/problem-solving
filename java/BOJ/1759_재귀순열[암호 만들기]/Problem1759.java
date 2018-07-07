/*
 * 2016.11.7
 * ��� ����
 * 
 * @problem https://www.acmicpc.net/problem/1759
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.Arrays;

public class Problem1759 {
    static String input[];
    static String output[] = new String[16]; //��� �� ������ �迭(���� ����)
    static int L, C;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]); //��ȣ ���� ��
        C = Integer.parseInt(input[1]); //���� ���� ��

        input = br.readLine().split(" ");
        Arrays.sort(input); //�������� ����
        permutation(0, 0);
    }

    public static void permutation(int index, int len) {
        if (len == L) { //�Ű����� len(���� ���� ������� ��ȣ�� ����)�� ���� ��ȣ�� ���� L�� ���ٸ� (base case)
            String s = "";
            int count = 0;
            for (int i = 0; i < L; i++) {
                s += output[i];
                if ("a".equals(output[i]) || "e".equals(output[i]) || "i".equals(output[i]) || "o".equals(output[i]) || "u".equals(output[i])) {
                    count++; //���� ���� �˻�
                }
            }
            if (count > 0 && L - count > 1) //���� 1�� ���� 2�� �̻� �´���
                System.out.println(s); //���ǿ� �´� ��ȣ ���
        } else {
            for (int i = index; i < C; i++) {
                output[len] = input[i];
                permutation(i + 1, len + 1);
            }
        }
    }
}
