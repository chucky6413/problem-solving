package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1333 {
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
		return Arrays.stream(restaurants)
			.map(Restaurant::new)
			.filter(r -> r.needToFiltered(veganFriendly, maxPrice, maxDistance))
			.sorted()
			.map(Restaurant::getId)
			.collect(Collectors.toList());
	}

	static class Restaurant implements Comparable<Restaurant> {
		int id;
		int rating;
		int veganFriendly;
		int price;
		int distance;

		Restaurant(int[] restaurant) {
			this.id = restaurant[0];
			this.rating = restaurant[1];
			this.veganFriendly = restaurant[2];
			this.price = restaurant[3];
			this.distance = restaurant[4];
		}

		boolean needToFiltered(int veganFriendly, int maxPrice, int maxDistance) {
			return (veganFriendly == 0 || this.veganFriendly == 1)
				&& price <= maxPrice
				&& distance <= maxDistance;
		}

		int getId() {
			return id;
		}

		@Override
		public int compareTo(Restaurant other) {
			if (other.rating == rating) {
				return other.id - id;
			}
			return other.rating - rating;
		}
	}
}