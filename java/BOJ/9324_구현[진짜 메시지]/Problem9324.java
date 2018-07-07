/*
 * 2017.01.10
 * ����
 *
 * @problem https://www.acmicpc.net/problem/9324
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.Scanner;
import java.util.Arrays;

public class Problem9324 {
    static int[] count = new int[26];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int test_case = input.nextInt();

        for (int i = 0; i < test_case; i++) {
            String s = input.next();
            String result = "OK";
            for (int j = 0; j < s.length(); j++) { //�۾�
                char c = s.charAt(j);
                int index = (int) c - 65;

                count[index]++; //���ڿ� �ش��ϴ� �ڸ� ����
                if ((count[index] % 3) == 0) { //3��° ��Ÿ�� �� ����
                    if (j != s.length() - 1 && s.charAt(j + 1) == c) {//���� �ڸ��� �ѹ� �� ���� �Ǿ��°�?
                        j++;
                    } else { //�ƴ϶�� ����
                        result = "FAKE";
                        break;
                    }
                }
            }
            sb.append(result + "\n");
            Arrays.fill(count, 0); //�ʱ�ȭ
        }
        System.out.println(sb);
    }
}