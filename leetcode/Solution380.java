import java.util.*;

public class Solution380 {
    class RandomizedSet {
        private Random random;
        private Map<Integer, Integer> map;
        private List<Integer> keyList;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            this.random = new Random();
            this.map = new HashMap<>();
            this.keyList = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, keyList.size());
                keyList.add(val);
                return true;
            }
            return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int idx = map.get(val);
                int lastVal = keyList.get(keyList.size() - 1);

                map.put(lastVal, idx);
                keyList.set(idx, lastVal);

                map.remove(val);
                keyList.remove(keyList.size() - 1);
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return keyList.get(Math.abs(random.nextInt()) % keyList.size());
        }
    }
}