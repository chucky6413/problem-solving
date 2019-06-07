/*
 * 2017.04.20
 * Ž��
 * 
 * @problem https://www.acmicpc.net/problem/1568
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem1568 {
    static long n;

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        long count = 0;
        long num = 0;
        while (n > 0) {
            num++;
            count++;
            n -= count;
            if (n <= count)
                count = 0;
        }
        System.out.println(num);

    }
}