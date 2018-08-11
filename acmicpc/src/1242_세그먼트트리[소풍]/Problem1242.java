/*
 * 2017.01.20
 * ����
 *
 * @problem https://www.acmicpc.net/problem/1242
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem1242 {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();

        int cur = 0;
        int before = k - 1;

        for (int i = 0; i < n; i++) {
            cur = (cur + m - 1) % (n - i);
            if (cur == before) {
                System.out.println(i + 1);
                break;
            }
            if (cur < before) { //���� ��ġ���� ���� ����� �����ٸ�, �� ��ġ�� �پ���.
                before -= 1;
            }
        }
    }
}