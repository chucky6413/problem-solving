/*
 * 2016.12.04
 *
 * @problem https://www.acmicpc.net/problem/10799
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.Scanner;

public class Problem10799 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int height = 0, result = 0;
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { //���� ���� ����
                height++;
            } else {
                height--;
                if (s.charAt(i - 1) == '(') { //������
                    result += height;
                } else
                    result++;
            }
        }
        System.out.println(result);
    }
}