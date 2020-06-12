package codejam.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2020_ROUND2_B_1 {
	//	private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	private static final PrintWriter w = new PrintWriter(System.out);
	private static final StringBuilder rs = new StringBuilder();

	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) throws FileNotFoundException {
		final Scanner sc = new Scanner(
			new BufferedReader(new FileReader(new File(".").getAbsolutePath() + "/src/codejam/input.txt")));

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();

			rs.append(String.format("Case #%d: ", i))
				.append(solve(X, Y))
				.append(NEW_LINE);
		}
		w.print(rs.toString());
		w.close();
	}

	// S, N, E, W
	private static final int[][] dirs = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
	private static final String[] ds = new String[] {"S", "N", "E", "W"};
	private static final int limit = 20;

	private static String solve(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, ""));

		int d = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node n = q.poll();

				if (n.x == x && n.y == y) {
					return n.s;
				}

				for (int j = 0; j < 4; j++) {
					int[] dir = dirs[j];
					int nx = (d * dir[0]) + n.x;
					int ny = (d * dir[1]) + n.y;
					String ns = n.s + ds[j];

					if ((nx >= -limit && nx <= limit) && (ny >= -limit && ny <= limit)) {
						System.out.println(nx + "/" + ny + "/" + ns);
						q.offer(new Node(nx, ny, ns));
					}
				}
			}
			d *= 2;
		}

		return "IMPOSSIBLE";
	}

	private static class Node {
		int x;
		int y;
		String s;

		public Node(int x, int y, String s) {
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}
}
