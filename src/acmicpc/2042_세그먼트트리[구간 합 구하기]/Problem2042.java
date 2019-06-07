/*
 * 2017.02.17
 * ���׸�Ʈ Ʈ��.
 *
 * @problem https://www.acmicpc.net/problem/2042
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem2042 {
    static long sumSegment[], answer; //���׸�Ʈ Ʈ�� , ����� ���� ����
    static int n, m, k, select, queryL, queryR, changeIndex, changeValue, len = 1;
    static String input[];

    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        while (n * 2 > len) {
            len *= 2; //���� ����Ʈ�� ���¸� ����� ���� len ���� ���Ѵ�.
        }
        sumSegment = new long[len]; //�迭 ����
        for (int i = 0; i < n; i++) {
            sumSegment[len / 2 + i] = Integer.parseInt(br.readLine()); // leaf ����� ���� �Է¹޾� �����Ѵ�.
        }
        segmentFill(1); // ���� ��Ʈ Ʈ���� ��� �Լ��� �̿��Ͽ� ���� ���� ä���.

        for (int i = 0; i < m + k; i++) {
            input = br.readLine().split(" ");
            select = Integer.parseInt(input[0]);
            if (select == 1) { //�� �ٲٱ�
                changeIndex = Integer.parseInt(input[1]); //�ٲ� ��ġ
                changeValue = Integer.parseInt(input[2]); //�ٲ� ��
                changeIndex = changeIndex + (len / 2 - 1); //���� ����� ��ġ�� �缳��
                sumSegment[changeIndex] = changeValue; //�� �ٲٱ�
                init(changeIndex); //�ʱ�ȭ
                subSegmentFill(1); //�κ� �� ä���.. �Լ� ������ �ش� �Լ���.
            } else if (select == 2) { //��
                queryL = Integer.parseInt(input[1]); //���� ����
                queryR = Integer.parseInt(input[2]); //���� ������
                answer = sumQuery(queryL, queryR, 1, 1, len / 2); // ���ϴ� ���� l,r ���� nodeIndex, ���� ����Ʈ���� ���� l,r �� �Ű������� �ѱ��.
                sb.append(answer + "\n"); //�� ���̱�
            }
        }
        System.out.println(sb.toString()); //�� ���
    }

    public static long segmentFill(int nodeIndex) { // ���׸�Ʈ Ʈ���� ä���ִ� �Լ�
        if (nodeIndex >= len / 2) return sumSegment[nodeIndex]; //���� ��忡 �ش��ϸ� ��ȯ
        sumSegment[nodeIndex] = segmentFill(nodeIndex * 2) + segmentFill(nodeIndex * 2 + 1); //�θ� ��忡 �ڽ� ��� ���� ���� ����
        return sumSegment[nodeIndex];
    }

    public static long subSegmentFill(int nodeIndex) { //���� ����� �κ��� �θ� �ش��ϴ� ������ �յ鸸 �ٽ� ä���ش�.
        if (sumSegment[nodeIndex] != -1) return sumSegment[nodeIndex];
        sumSegment[nodeIndex] = subSegmentFill(nodeIndex * 2) + subSegmentFill(nodeIndex * 2 + 1);
        return sumSegment[nodeIndex];
    }

    public static void init(int nodeIndex) { //��������� ���� �ٲ� �θ���� ������ �ʱ�ȭ ��Ų��.
        if (nodeIndex < 1) return;
        sumSegment[nodeIndex / 2] = -1;
        init(nodeIndex / 2);
    }

    public static long sumQuery(int queryL, int queryR, int nodeIndex, int nodeL, int nodeR) { // ������ �Ű������� �޾� �ش��ϴ� ���� ��ȯ�ϴ� �Լ�
        if (queryR < nodeL || nodeR < queryL) return 0; //���Ϸ��� ������ ������ node������ ���� ��ġ�� �ʴ� ���
        if (queryL <= nodeL && nodeR <= queryR) return sumSegment[nodeIndex]; //������ �� ���� ��
        int middle = (nodeL + nodeR) / 2; //���� ������ node ������ �߰� ���� ���Ѵ�.
        //������ �� ���� �ʴ´ٸ�, �� �ڽ����� ������ �۾��� �Ͽ� ������ �ش��ϴ� ������ ���ؿ� �� �� ���� ��ȯ�Ѵ�.
        return sumQuery(queryL, queryR, nodeIndex * 2, nodeL, middle) + sumQuery(queryL, queryR, nodeIndex * 2 + 1, middle + 1, nodeR);
    }
}