/*
 * 2016.11.14
 * ���̳������α׷���.
 *
 * @problem https://www.acmicpc.net/problem/2011
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.Scanner;

public class Problem2011 {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);

        String password = input.next();
        int len = password.length();
        int result[] = new int[len + 1];

        if (len >= 1) { //�ʱ� ��
            result[0] = 1;
            result[1] = 1;
        }

        if (password.charAt(0) == '0') {
            //0���� �����ϸ� X
            result[1] = 0;
        } else {
            for (int i = 2; i < len + 1; i++) {
                if (!(password.charAt(i - 2) == '1' || password.charAt(i - 2) == '2') && password.charAt(i - 1) == '0') { //���ܻ�Ȳ
                    result[len] = 0;
                    break;
                }
                if (password.charAt(i - 1) == '0') { // 10 or 20 �� ��
                    result[i] = result[i - 2];
                } else if ((password.charAt(i - 2) == '1' && password.charAt(i - 1) <= '9') || ((password.charAt(i - 2) == '2') && password.charAt(i - 1) <= '6')) {
                    result[i] = (result[i - 1] + result[i - 2]) % 1000000; // //2���� ���� ��, ������ ���� ������ ó��..
                } else {
                    result[i] = result[i - 1];
                }
            }
        }
        System.out.println(result[len]);
    }
}