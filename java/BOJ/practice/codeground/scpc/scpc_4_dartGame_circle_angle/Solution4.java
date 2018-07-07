import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dart[] = {6, 13, 4, 18, 1, 20, 5, 12, 9, 14, 11, 8, 16, 7, 19, 3, 17, 2, 15, 10};

        int t = input.nextInt(); //test case

        for (int i = 1; i <= t; i++) {
            int a = input.nextInt(); //bull�� ������
            int b = input.nextInt(); //triple ����
            int c = input.nextInt(); //triple ��
            int d = input.nextInt(); //double ����
            int e = input.nextInt(); //double ��

            int n = input.nextInt(); //��Ʈ ���� Ƚ��
            int score = 0;
            for (int j = 0; j < n; j++) {
                int x = input.nextInt(); //���� ��Ʈ�� x��ǥ
                int y = input.nextInt(); //���� ��Ʈ�� y��ǥ

                double len = Math.sqrt((x * x) + (y * y));
                if (len < a) { //bull �ȿ� �� ���
                    score += 50;
                    continue;
                } else if (len > e) { //������ ���� ���� ���
                    continue;
                }

                int m = 1; //�⺻���� single ����
                if (len > b && len < c) {
                    m = 3; //triple 3��
                } else if (len > d && len < e) {
                    m = 2; //double 2��
                }

                double theta = Math.atan((double) y / x);
                System.out.println(theta);
                theta *= (180 / Math.PI);
                theta += 9; //���� 9���� ���.. 0��°�� �ƴ� 1��°�� score�� ���� �ϹǷ� ..18�� ��������.. 9�� ������� �Ѵ�.
                if (x < 0) //������ ���
                    theta += 180;
                System.out.println(theta);
                theta = (theta + 360) % 360;
                System.out.println(theta);
                int spot = (int) (theta / 18);
                score += m * dart[spot];
                System.out.println(spot);
            }
            System.out.println("Case #" + i);
            System.out.println(score);
        }
    }
}
