/*
 * 2017.03.20
 * JAVA�� �ð��ʰ� �ȳ��� �ڵ�
 *
 * @problem https://www.acmicpc.net/problem/12430
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem12430 {
    static List<Node> list = new ArrayList<Node>(); //�迭 d�� �湮 �迭�� ����� ���̴�. ���� �̾ �� �ִ���..
    static boolean d[] = new boolean[101001]; // 101001�� ���� : �ִ밡�� ���ӽð� 100000 , �ִ� ������� 1000 �̹Ƿ�
    static int answer;                        // �ִ� ������ѱ��� ��Ƽ�� ���� ū ���ӽð��� ������ �Ծ��� ���� �ִ� ����̴�.

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String temp[];
        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            int max = 0; //max �ʱ�ȭ
            int n = Integer.parseInt(br.readLine());
            list.clear(); //list �ʱ�ȭ

            for (int i = 0; i < n; i++) {
                temp = br.readLine().split(" ");
                int pi = Integer.parseInt(temp[0]);
                int si = Integer.parseInt(temp[1]);
                list.add(new Node(pi, si));
            } //si �������, pi ���ӽð��� ���� Node�� �Է¹޴´�.

            Collections.sort(list); //si+pi ������ �����Ѵ�.
            max = list.get(n - 1).p + list.get(n - 1).s; //���� �ǵڿ� �ִ� Node�� p+s�� ���� max�� �����Ѵ�.
            //������ �� �ִ� ���� �ִ� ���� �� ���� �����Ƿ�.(��������� �����ȴٸ�)
            answer = 0; //��� �� �ʱ�ȭ
            Arrays.fill(d, false); //�湮 �迭 �ʱ�ȭ
            d[0] = true;

            for (int i = 0; i < n; i++) { //Node�� ����ŭ �ݺ�
                for (int j = list.get(i).p; j >= 0; j--) { //�ش� ����� ��������� ������ ���� �ڽ��� �տ��� ���ӵ�.. ������ �ִ���
                    if (d[j]) {                      //ã�Ƴ���.
                        d[j + list.get(i).s] = true; //���� ���� ����� ������Ѻ���. �̾�� ���ӵ� ������ �ִٸ�.
                    }                              //�� ������ ���ӵǴ� �ð� + ���ο� ������ ���ӽð��� �̿� �����ϴٰ� true�� ǥ���Ѵ�.
                }
            }
            for (int i = max; i >= 0; i--) { //max = ��������� ������ ���� ū ������ �����ؼ�.
                if (d[i]) { //�̿밡���� �ִ밪 true�� ���� ã�Ƽ�
                    answer = i; //ã�Ƴ��ڸ��� ���信 ������ ��
                    break; //�ݺ����� ��ģ��. �ڿ������� �����ϹǷ� ã�ڸ��ڰ� �ִ밪�̴�.
                }
            }
            sb.append("Case #" + t + ": " + answer + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static class Node implements Comparable<Node> {
        int p;
        int s;

        public Node(int p, int s) {
            this.p = p;
            this.s = s;
        }

        public int compareTo(Node n) {
            return p + s <= (n.p + n.s) ? -1 : 1;
        }
    }
}
