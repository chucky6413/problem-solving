import java.util.LinkedList;

public class Solution682 {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) return 0;

        int sum = 0;
        LinkedList<Integer> scoreOfRound = new LinkedList<>();

        for (String e : ops) {
            switch (e) {
                case "+":
                    scoreOfRound.add(scoreOfRound.get(scoreOfRound.size() - 2) + scoreOfRound.peekLast());
                    sum += scoreOfRound.peekLast();
                    break;

                case "D":
                    scoreOfRound.add(scoreOfRound.peekLast() * 2);
                    sum += scoreOfRound.peekLast();
                    break;

                case "C":
                    sum -= scoreOfRound.removeLast();
                    break;

                default:
                    scoreOfRound.add(Integer.parseInt(e));
                    sum += scoreOfRound.peekLast();
                    break;
            }
        }

        return sum;
    }
}