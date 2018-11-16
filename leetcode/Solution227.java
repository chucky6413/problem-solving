import java.util.ArrayDeque;
import java.util.Deque;

public class Solution227 {
    public int calculate(String s) {
        int rs = 0;
        Deque<Integer> stack = new ArrayDeque();

        int num = 0;
        char prevExp = '+';
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            if (isNumChar(cArr[i])) {
                num = num * 10 + cArr[i] - '0';
            }
            if (!isNumChar(cArr[i]) && cArr[i] != ' ' || i == (cArr.length - 1)) {
                switch (prevExp) {
                    case ' ':
                        continue;
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                prevExp = cArr[i];
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            rs += stack.pop();
        }
        return rs;
    }

    private boolean isNumChar(char c) {
        return '0' <= c && c <= '9';
    }
}