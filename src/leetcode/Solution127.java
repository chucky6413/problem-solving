package leetcode;

import java.util.*;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        wordSet.remove(beginWord);
        int rs = 1;
        while (!queue.isEmpty()) {
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                String target = queue.poll();

                for (int j = 0; j < target.length(); j++) {
                    char[] cArr = target.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (cArr[j] == c) {
                            continue;
                        }

                        cArr[j] = c;
                        String transformed = String.valueOf(cArr);
                        if (wordSet.contains(transformed)) {
                            if (transformed.equals(endWord)) {
                                return rs + 1;
                            }
                            queue.add(transformed);
                            wordSet.remove(transformed);
                        }
                        cArr = target.toCharArray();
                    }
                }
            }

            rs++;
        }

        return 0;
    }
}