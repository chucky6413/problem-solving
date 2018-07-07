/*
 * 2017.03.01
 * ����Ʈ
 *
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

class QuickSort {
    public static void main(String[] args) {
        int arr[] = {5, 4, 2, 3, 1, 10, 9, 8, 15};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    public static int partition(int arr[], int left, int right) {
        int pivot, i, j;
        pivot = arr[left];
        i = left;
        j = right + 1;

        do {
            while (i < right && arr[++i] < pivot) ; //���ʺ���, pivot���� ������ i �� ����
            while (arr[--j] > pivot) ; //�����ʺ���, pivot���� ũ�� j�� ����
            if (i < j) { //�߰��� ����������, ���� pivot �������� ������ �������� ���� ��.
                int temp = arr[i]; // �� �ٲٰ� �ٽ� ���� �ݺ��� ������.
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } while (i < j); //������ pivot ��������, ���ʿ��� ���� ����, �����ʿ��� ū ������ ����Ǿ� ����.

        int temp = arr[left]; //pivot���� �����ֵ���, �������� �������Ƿ�, ���� ������ �� ����°�� pivot�� �ڸ��ٲ��ְ�
        arr[left] = arr[j];   //pivot�� �� �ڸ��� ������ ��, ���� �������� �ٽ� ���� ���� �� �� �̴�.
        arr[j] = temp;
        return j;
    }
}