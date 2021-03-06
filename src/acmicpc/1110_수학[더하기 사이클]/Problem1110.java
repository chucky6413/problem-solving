/*
 * 2016.11.26
 * ����.
 *
 * @problem https://www.acmicpc.net/problem/1110
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.Scanner;
import java.util.Arrays;

public class Problem1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first, result, temp;

        first = sc.nextInt();

        int count = 0;
        result = first;
        do {
            temp = (result % 10) * 10;
            temp += (result / 10 + temp / 10) % 10;
            result = temp;
            count++;
        } while (first != result);

        System.out.println(count);
    }
}