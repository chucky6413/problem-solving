/*
 * 2017.04.22
 * �ùķ��̼�
 * 
 * @problem https://www.acmicpc.net/problem/3190
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.*;

public class Problem3190 {
    static int n, k, l;
    static int arr[][];
    static char lot[] = new char[10001];
    static int dx[] = {0, -1, 0, 1}; //�� , �� , �� , �Ʒ�
    static int dy[] = {1, 0, -1, 0}; //L - +1 , D - +3

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < k; i++) {
            temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]) - 1;
            int y = Integer.parseInt(temp[1]) - 1;
            arr[x][y] = 1;
        }
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            temp = br.readLine().split(" ");
            int t = Integer.parseInt(temp[0]);
            char c = temp[1].charAt(0);
            lot[t] = c;
        }
        br.close();

        int dir = 0;
        int x = 0, y = 0; //�Ӹ�
        int sec = 0;

        Queue<Snake> snake = new LinkedList<Snake>();
        int tx = 0, ty = 0; //����
        arr[x][y] = 2; //�ڽ��� ��
        snake.offer(new Snake(x, y));
        while (true) {
            sec++;
            x += dx[dir];
            y += dy[dir];

            if (inner(x, y)) {
                snake.offer(new Snake(x, y));
                if (arr[x][y] == 1) {
                    arr[x][y] = 2;
                } else if (arr[x][y] == 0) {
                    Snake tail = snake.poll();
                    tx = tail.x;
                    ty = tail.y;
                    arr[tx][ty] = 0;
                    arr[x][y] = 2;
                } else {
                    break;
                }
            } else {
                break;
            }

            if (lot[sec] == 'L') {
                dir = (dir + 1) % 4;
            } else if (lot[sec] == 'D') {
                dir = (dir + 3) % 4;
            }
        }
        System.out.println(sec);
    }

    public static boolean inner(int x, int y) {
        if (x < 0 || x > n - 1 || y < 0 || y > n - 1) {
            return false;
        }
        return true;
    }

    static class Snake {
        int x;
        int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
