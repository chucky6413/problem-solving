/*
 * 2017.02.17
 * ���׸�Ʈ Ʈ��.
 *
 * @problem https://www.acmicpc.net/problem/10868
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem10868 {
    static int minSegment[]; //���� �ּ� ���� ������ ���׸�Ʈ Ʈ��
    static int n, m, queryL, queryR, len = 1, answer;

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();

        while (n * 2 > len) {
            len *= 2; //���� ����Ʈ�� ���¸� ����� ���� len ���� ���Ѵ�.
        }
        minSegment = new int[len]; //�迭 ����
        for (int i = 0; i < n; i++) {
            minSegment[len / 2 + i] = input.nextInt(); // leaf ����� ���� �Է¹޾� �����Ѵ�.
        }
        segmentFill(1); // ���� ��Ʈ Ʈ���� ��� �Լ��� �̿��Ͽ� min ���� ä���.

        for (int i = 0; i < m; i++) {
            queryL = input.nextInt();
            queryR = input.nextInt();
            answer = minQuery(queryL, queryR, 1, 1, len / 2); // ���ϴ� ���� l,r ���� nodeIndex, ���� ����Ʈ���� ���� l,r �� �Ű������� �ѱ��.
            System.out.println(answer);
        }
    }

    public static int segmentFill(int nodeIndex) { // ���׸�Ʈ Ʈ���� ä���ִ� �Լ�
        if (nodeIndex >= len / 2) return minSegment[nodeIndex]; //���� ��忡 �ش��ϸ� ��ȯ
        minSegment[nodeIndex] = Math.min(segmentFill(nodeIndex * 2), segmentFill(nodeIndex * 2 + 1)); //�θ� ��忡 �ڽ� ��� �� �� ���� ����� ���� ����
        return minSegment[nodeIndex];
    }

    public static int minQuery(int queryL, int queryR, int nodeIndex, int nodeL, int nodeR) { // ������ �Ű������� �޾� �ش��ϴ� �ּ� ���� ��ȯ�ϴ� �Լ�
        if (queryR < nodeL || nodeR < queryL) return 1000000001; //���Ϸ��� ������ ������ node������ ���� ��ġ�� �ʴ� ���
        if (queryL <= nodeL && nodeR <= queryR) return minSegment[nodeIndex]; //������ �� ���� ��
        int middle = (nodeL + nodeR) / 2; //���� ������ node ������ �߰� ���� ���Ѵ�.
        //������ �� ���� �ʴ´ٸ�, �� �ڽ����� ������ �۾��� �Ͽ� ������ �ش��ϴ� ������ ���ؿ� �� �� �� �ּҰ��� ��ȯ�Ѵ�.
        return Math.min(minQuery(queryL, queryR, nodeIndex * 2, nodeL, middle), minQuery(queryL, queryR, nodeIndex * 2 + 1, middle + 1, nodeR));
    }
}