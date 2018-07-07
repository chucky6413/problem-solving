/*
 * 2016.8.29
 * �ּҰ� ã��,�ּ� �����̵� ������ �˰���
 *
 * @problem https://www.acmicpc.net/problem/11003
 * @github https://github.com/chucky6413
 * @author chucky3
 *
 * deque(��) �ڷᱸ���� ����Ͽ� ���� ������ array�� index�� �����ϰ�
 * �� ����� ������ �ε����� ���Ͽ� ���� ���� ������ Ŭ ��� ��� ����.. �ּڰ��� �ε������� ���� ���� �˰���..
 */

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem11003 {
    public static void main(String arg[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine(), " ");
        int nums[] = new int[n];
        int k = 0;
        while (st.hasMoreTokens()) {
            nums[k] = Integer.parseInt(st.nextToken());
            k++;
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - l) // l �� 3�� �ɶ����� �Ǿ� �� ����
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
                deque.removeLast();
            }

            deque.offer(i);

            sb.append(nums[deque.peek()] + " ");
        }
        System.out.println(sb);
    }
}