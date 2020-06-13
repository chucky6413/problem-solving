package codejam.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2018A_2 {
	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] V = new int[N];
			for (int j = 0; j < N; j++) {
				V[j] = sc.nextInt();
			}

			rs.append(String.format("Case #%d: ", i))
				.append(String.format("%.6f", solve(N, K, V)))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	private static double solve(int n, int k, int[] v) {
		Arrays.sort(v);
		double[] partSum = makePartSum(v);

		double nextExpectedValue = sumOfElements(v) / n;
		for (int i = 0; i < k; i++) {
			int idx = findFirstIdxBiggerThanVal(v, nextExpectedValue);
			double sumOfBigElements = partSum[n] - partSum[idx];
			nextExpectedValue = ((idx * nextExpectedValue) / n) + (sumOfBigElements / n);
		}
		return nextExpectedValue;
	}

	private static double[] makePartSum(int[] v) {
		double[] partSum = new double[v.length + 1];
		partSum[1] = v[0];
		for (int i = 1; i < v.length; i++) {
			partSum[i + 1] = partSum[i] + v[i];
		}
		return partSum;
	}

	private static double sumOfElements(int[] elements) {
		double sumOfElements = 0;
		for (int element : elements) {
			sumOfElements += element;
		}
		return sumOfElements;
	}

	private static int findFirstIdxBiggerThanVal(int[] nums, double val) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] <= val) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}