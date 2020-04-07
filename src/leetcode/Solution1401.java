package leetcode;

public class Solution1401 {
	public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
		int closeX = getClosePoint(x_center, x1, x2);
		int closeY = getClosePoint(y_center, y1, y2);

		int distanceX = x_center - closeX;
		int distanceY = y_center - closeY;

		return (distanceX * distanceX) + (distanceY * distanceY)
			<= (radius * radius);
	}

	private int getClosePoint(int center, int min, int max) {
		if (center < min) {
			return min;
		} else if (center > max) {
			return max;
		} else {
			return center;
		}
	}
}