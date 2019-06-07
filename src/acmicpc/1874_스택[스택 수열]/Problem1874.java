/*
 * 2016.11.5
 * ���� ����.
 *
 * @problem https://www.acmicpc.net/problem/1874
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.Scanner;
import java.util.Stack;

public class Problem1874 {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); //������ �Է�

        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder(); //+,- ��� ������ ����
        int seq[] = new int[N]; //�Էµ� ���� ������ ����

        for (int i = 0; i < N; i++) {
            seq[i] = input.nextInt();
        }

        int number = 1; //1~N ����
        int pointer = 0; //������ ���� index

        while (pointer != N && number != N + 2) { //number�� N+1�� ��� ������ �۾��� ��� pop�̾�� ��.
            if (!stack.isEmpty()) {
                if (stack.peek() == seq[pointer]) {
                    stack.pop();
                    pointer++;
                    sb.append("-\n");
                } else {
                    stack.push(number);
                    number++;
                    sb.append("+\n");
                }
            } else {
                stack.push(number);
                number++;
                sb.append("+\n");
            }
        }
        if (pointer == N)
            System.out.println(sb.toString()); //���
        else
            System.out.println("NO");
    }
}
