import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    public int romanToInt(String s) {
        Map<Character, Integer> symbols = new HashMap<>();
        initSymbols(symbols);

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int prev = symbols.get(s.charAt(i));
            int next = symbols.get(s.charAt(i + 1));

            if (prev < next) {
                sum -= prev;
            } else {
                sum += prev;
            }
        }
        return sum + symbols.get(s.charAt(s.length() - 1));
    }

    private void initSymbols(Map<Character, Integer> symbols) {
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);
    }
}