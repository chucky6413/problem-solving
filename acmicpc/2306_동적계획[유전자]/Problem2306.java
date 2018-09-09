/*
 * 2017.01.23
 * ������ȹ
 *
 * @problem https://www.acmicpc.net/problem/2306
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.Arrays;
import java.util.Scanner;

public class Problem2306 {
    static char str[];
    static int dp[][];
    static String at = "at", gc = "gc";

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        str = input.next().toCharArray(); //�Է�
        int length = str.length;
        dp = new int[length][length];
        for (int i = 0; i < length; i++) Arrays.fill(dp[i], -1); //��� �ȵ� �� -1 �ʱ�ȭ
        int result = solve(0, length - 1); //����Լ� ȣ��
        System.out.println(result); //���
    }

    public static int solve(int front, int back) {
        if (front >= back) return 0;
        String ans = str[front] + "" + str[back];
        if (dp[front][back] == -1) { //������ �ʾ��� ����
            dp[front][back] = 0;
            if (ans.equals(at) || ans.equals(gc)) {
                dp[front][back] = solve(front + 1, back - 1) + 2; //a...t or g...c �� ����~ �� ������ dp�� + 2
            }
            for (int i = front; i < back; i++) {
                dp[front][back] = Math.max(solve(front, i) + solve(i + 1, back), dp[front][back]); //�̾� ���� ������ ū�� �˻�. (�ִ밪 ã��)
            }
        }

        return dp[front][back];
    }
}