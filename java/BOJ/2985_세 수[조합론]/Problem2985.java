/*
 * 2017.01.10
 * ���շ�
 *
 * @problem https://www.acmicpc.net/problem/2985
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.Scanner;

public class Problem2985 {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        if ((a + b) == c) {
            sb.append(a + "+" + b + "=" + c);
        } else if ((a - b) == c) {
            sb.append(a + "-" + b + "=" + c);
        } else if ((a * b) == c) {
            sb.append(a + "*" + b + "=" + c);
        } else if ((a / b) == c) {
            sb.append(a + "/" + b + "=" + c);
        } else if (a == (b + c)) {
            sb.append(a + "=" + b + "+" + c);
        } else if (a == (b - c)) {
            sb.append(a + "=" + b + "-" + c);
        } else if (a == (b * c)) {
            sb.append(a + "=" + b + "*" + c);
        } else if (a == (b / c)) {
            sb.append(a + "=" + b + "/" + c);
        }

        System.out.println(sb);
    }
}