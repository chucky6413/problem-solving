/*
 * 2017.03.18
 * ����,�����佺�׳׽��� ü
 *
 * @problem https://www.acmicpc.net/problem/2960
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem2960 {
    static int currentPrime;
    static int n, k, count, next, result;
    static int arr[];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();

        arr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        while (count != (n - 1)) { //���� ���� n-1�� �� �� ���� �ݺ�
            primeSearch();
            next = currentPrime;
            int multi = 2; //��� ���� ��.
            while (next <= n) {
                if (arr[next] != 0) { //������ ���� �ֵ�.
                    arr[next] = 0;
                    count++;
                }
                if (count == k) { //ã���� ��,
                    result = next;
                    break;
                }
                next = currentPrime * multi++; //��� ���ϱ�
            }
            if (result != 0) { //�ݺ��� ��.
                break;
            }
        }
        System.out.println(result);
    }

    public static void primeSearch() {
        for (int i = currentPrime; i <= n; i++) {
            if (arr[i] != 0) { //�������� �ʾ��� ����,
                if (isPrimeNumber(i)) {
                    currentPrime = i;
                    break;
                }
            }
        }
    }

    public static boolean isPrimeNumber(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}