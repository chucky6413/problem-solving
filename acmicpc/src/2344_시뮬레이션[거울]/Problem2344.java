/*
 * 2017.04.10
 * �ùķ��̼�
 * 
 * @problem https://www.acmicpc.net/problem/2344
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem2344 {
    static int n, m;
    static final int dx[] = {0, 0, -1, 1};
    static final int dy[] = {1, -1, 0, 0};
    static int isMirror[][];

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];
        StringBuilder sb = new StringBuilder();

        temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        isMirror = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                isMirror[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }
        br.close();
        //isMirror Ȯ���Ͽ�, �ⱸ ��ȣ�� ����.
        int num = 1;
        for (int i = 1; i <= n; i++) { //����
            isMirror[i][0] = num++;
        }
        for (int i = 1; i <= m; i++) { //�Ʒ�
            isMirror[n + 1][i] = num++;
        }
        for (int i = n; i >= 1; i--) { //������
            isMirror[i][m + 1] = num++;
        }
        for (int i = m; i >= 1; i--) { //��
            isMirror[0][i] = num++;
        }

        //                ������ 0 , ���� 1, �� 2, �Ʒ� 3
        // /�ſ� ������,        2         3     0        1   (+2%4)
        // �ⱸ ã��
        int index = 0;
        int curX, curY; //���� ��ǥ
        for (int i = 1; i <= n; i++) { //����
            index = 0;
            curX = i;
            curY = 1;

            while (curX > 0 && curX < n + 1 && curY > 0 && curY < m + 1) {
                if (isMirror[curX][curY] == 1) { //�ſ��� ������
                    index = (index + 2) % 4;
                }
                curX += dx[index];
                curY += dy[index];
            }
            sb.append(isMirror[curX][curY] + " ");
        }
        for (int i = 1; i <= m; i++) { //�Ʒ�
            index = 2;
            curX = n;
            curY = i;

            while (curX > 0 && curX < n + 1 && curY > 0 && curY < m + 1) {
                if (isMirror[curX][curY] == 1) { //�ſ��� ������
                    index = (index + 2) % 4;
                }
                curX += dx[index];
                curY += dy[index];
            }
            sb.append(isMirror[curX][curY] + " ");
        }
        for (int i = n; i >= 1; i--) { //������
            index = 1;
            curX = i;
            curY = m;
            while (curX > 0 && curX < n + 1 && curY > 0 && curY < m + 1) {
                if (isMirror[curX][curY] == 1) { //�ſ��� ������
                    index = (index + 2) % 4;
                }
                curX += dx[index];
                curY += dy[index];
            }
            sb.append(isMirror[curX][curY] + " ");
        }
        for (int i = m; i >= 1; i--) { //��
            index = 3;
            curX = 1;
            curY = i;

            while (curX > 0 && curX < n + 1 && curY > 0 && curY < m + 1) {
                if (isMirror[curX][curY] == 1) { //�ſ��� ������
                    index = (index + 2) % 4;
                }
                curX += dx[index];
                curY += dy[index];
            }
            sb.append(isMirror[curX][curY] + " ");
        }
        System.out.println(sb);
    }
}