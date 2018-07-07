/*
 * 2017.04.20
 * Ž��
 * �� ������ - ������
 * �� ���� a,b,c / ���� s
 * �������� ������ r = (a*b*c)/(4*s)
 * ���� l = 2*r*PI
 * ���� s = ((x1*y2) + (x2*y3) + (x3*y1) - (x2*y1) + (x1*y3) + (x3*y2))/2.0
 * 
 * @problem https://www.acmicpc.net/problem/1568
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.*;

public class Problem6600 {
    static double x[] = new double[3];
    static double y[] = new double[3];
    static double mx, my, r, s;
    static final String NEWLINE = "\n";
    static final double PI = 3.141592653589793;

    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (input.hasNext()) {
            for (int i = 0; i < 3; i++) {
                x[i] = input.nextDouble();
                y[i] = input.nextDouble();
            }
            r = (len(x[0] - x[1], y[0] - y[1]) * len(x[1] - x[2], y[1] - y[2]) * len(x[2] - x[0], y[2] - y[0]));
            s = Math.abs((((x[0] * y[1]) + (x[1] * y[2]) + (x[2] * y[0])) - ((x[1] * y[0]) + (x[0] * y[2]) + (x[2] * y[1]))) / 2.0);
            r = r / (4 * s);
            String str = String.format("%.2f", (2 * r * PI));
            sb.append(str + NEWLINE);
        }

        System.out.println(sb);
    }

    public static double len(double a, double b) {
        return Math.sqrt((a * a) + (b * b));
    }
}
