import java.util.*;

public class Solution638 {
    private Map<List<Integer>, Integer> cache = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return backtrack(price, special, needs);
    }

    private int backtrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (cache.containsKey(needs)) {
            return cache.get(needs);
        }

        int result = getOriginalPrice(price, needs);

        int i = 0;
        for (List<Integer> s : special) {
            ArrayList<Integer> remainNeeds = new ArrayList<>(needs);
            for (i = 0; i < needs.size(); i++) {
                int remainCount = needs.get(i) - s.get(i);
                if (remainCount < 0) {
                    break;
                }
                remainNeeds.set(i, remainCount);
            }

            if (i == needs.size()) {
                result = Math.min(result, s.get(i) + backtrack(price, special, remainNeeds));
            }
        }

        cache.put(needs, result);
        return result;
    }

    private int getOriginalPrice(List<Integer> price, List<Integer> needs) {
        int op = 0;
        for (int i = 0; i < price.size(); i++) {
            op += price.get(i) * needs.get(i);
        }
        return op;
    }
}