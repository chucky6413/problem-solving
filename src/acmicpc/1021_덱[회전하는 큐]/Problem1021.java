/*
 * 2017.04.09
 * DEQUE
 * 
 * @problem https://www.acmicpc.net/problem/1021
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem1021 {
    static int n, m, count = 0;
    static int question[];

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];

        temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        question = new int[m];
        temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            question[i] = Integer.parseInt(temp[i]);
        }
        br.close();

        ArrayDeque<Integer> rotateLeft = new ArrayDeque<Integer>();
        ArrayDeque<Integer> rotateRight = new ArrayDeque<Integer>();

        for (int i = 1; i <= n; i++) {
            rotateLeft.offer(i);
            rotateRight.offer(i);
        }

        for (int item : question) {
            int size = rotateLeft.size();
            for (int i = 0; i < size; i++) {
                //����
                int leftItem = rotateLeft.pollFirst(); //1�� ����.

                //���ٸ�
                if (leftItem == item) {
                    count += i; //2�� ���� Ƚ�� +1�� �����ִ� ���� -> ���� 1�� ���� �ۿ� ���ߴ�.
                    rotateRight = rotateLeft.clone(); //���� ��ġ ��Ŵ.
                    break;
                }

                int rightItem = rotateRight.pollLast();

                if (rightItem == item) {
                    count += i + 1; //3�� ������ ���� Ƚ��
                    rotateLeft = rotateRight.clone();
                    break;
                }

                //�Ѵ� �ƴϸ�.
                rotateLeft.offerLast(leftItem);
                rotateRight.offerFirst(rightItem);
            }
        }
        System.out.println(count);
    }
}