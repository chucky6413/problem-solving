/*
 * 2017.04.13
 * �ùķ��̼�
 * 
 * @problem https://www.acmicpc.net/problem/10875
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem10875 {
    static int L, N;
    static List<Line> lineList = new LinkedList<Line>();
    static List<Rotate> rotateList = new LinkedList<Rotate>();
    static final int DIR_X[] = {0, -1, 0, 1}; // 0 - �� / 1 - ���� / 2 - �Ʒ� / 3 - ������
    static final int DIR_Y[] = {1, 0, -1, 0}; //�ݽð� ����

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];
        L = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            rotateList.add(new Rotate(Integer.parseInt(temp[0]), temp[1].charAt(0)));
        }

        //�׵θ��� �������� ������ ���´�.
        lineList.add(new Line(-L - 1, -L - 1, L + 1, -L - 1));
        lineList.add(new Line(-L - 1, -L - 1, -L - 1, L + 1));
        lineList.add(new Line(-L - 1, L + 1, L + 1, L + 1));
        lineList.add(new Line(L + 1, -L - 1, L + 1, L + 1));

        int x = 0, y = 0, dir = 3; //�� �Ӹ� x,y ��ǥ. �̵� ����
        long answer = 0; //���

        for (int i = 0; i <= N; i++) {
            int min = 1000000001;
            for (int j = 0; j < lineList.size(); j++) { //��� ���� �� ���� �� �ִ� ���� ����� ������ �˻��Ѵ�.
                min = Math.min(min, cross(dir, x, y, lineList.get(j)));
            }

            if (i == N || min <= rotateList.get(i).time) { //���� �� �ִ� �Ÿ���ŭ ���� Ŀ���ٸ�
                answer += min; //�� �Ÿ���ŭ �ð� �߰�.
                break; //����
            }

            answer += rotateList.get(i).time; //�ð� �߰�
            int mx = x + DIR_X[dir] * rotateList.get(i).time; //���� ��ġ + ���� * ������ �ð�
            int my = y + DIR_Y[dir] * rotateList.get(i).time;
            // 0 - �� / 1 - ���� / 2 - �Ʒ� / 3 - ������
            //�Ʒ��� ���� �� ���� 2 -> 3 �� �Ǿ�� ��. 2+(1)+4 %4 -> 3
            //�Ʒ��� ���� �� ������ 2->1 �� �Ǿ�� ��. 2+(-1)+4 % 4 -> 1  ���� ��ȯ ��Ģ.
            dir = (dir + rotateList.get(i).dir + 4) % 4; //���� ����
            lineList.add(new Line(x, y, mx, my)); //������(x,y) ������(mx,my)
            x = mx; //�Ӹ� ��ġ ����
            y = my; //�Ӹ� ��ġ ����
        }
        System.out.println(answer);
    }

    /*
     * dir : ���� ���� , x,y ���� ����� ��ġ
     * line : �˻��� ����
     * ������������� ���а�, �˻��� ������ ��´ٸ� ��� �������� �Ÿ��� ��ȯ�Ѵ�.
     * ���� ���а� ������ ������ �ʴ´ٸ�, default ���� ��ȯ�Ѵ�.
     */
    public static int cross(int dir, int x, int y, Line line) {
        int gap = 1000000001;
        if (line.dir == 0) { //������ ��,
            if (dir == 0) { //���� �ö� ����
                if (x == line.x1 && y < line.y1) { //x�� ����, ���� �Ʒ��� �����ϸ�
                    gap = Math.min(gap, line.y1 - y);
                }
            } else if (dir == 1) { //�������� ������
                if (line.y1 <= y && y <= line.y2 && line.x1 < x) {
                    gap = Math.min(gap, x - line.x1);
                }
            } else if (dir == 2) { //�Ʒ��� ������
                if (x == line.x1 && line.y2 < y) {
                    gap = Math.min(gap, y - line.y2);
                }
            } else {
                if (line.y1 <= y && y <= line.y2 && x < line.x1) {
                    gap = Math.min(gap, line.x1 - x);
                }
            }
        } else { //������ ��
            if (dir == 0) {
                if (line.x1 <= x && x <= line.x2 && y < line.y1) {
                    gap = Math.min(gap, line.y1 - y);
                }
            } else if (dir == 1) {
                if (line.y1 == y && line.x2 < x) {
                    gap = Math.min(gap, x - line.x2);
                }
            } else if (dir == 2) {
                if (line.x1 <= x && x <= line.x2 && line.y1 < y) { //�Ʒ��� ����
                    gap = Math.min(gap, y - line.y1);
                }
            } else {
                if (line.y1 == y && x < line.x1) {
                    gap = Math.min(gap, line.x1 - x);
                }
            }
        }
        return gap;
    }

    static class Rotate { //ȸ�� ��Ģ
        int time;
        int dir;

        public Rotate(int time, char L) {
            this.time = time;
            if (L == 'L') //�����̸� 1, �������̸� -1
                dir = 1;
            else
                dir = -1;
        }
    }

    static class Line { //����
        int x1, y1, x2, y2; // (x1,y1) , (x2,y2) �� ��.
        int dir; // 0 or 1  ����,����

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;

            if (x1 == x2) { //����
                dir = 0;
            } else {
                dir = 1;
            }
            swapPoint();
        }

        void swapPoint() { // x2, y2�� ū������ ����.
            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }

            if (y1 > y2) {
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }
        }
    }
}
