package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution783 {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        makeSortingList(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(list.get(i) - list.get(i - 1), min);
        }
        return min;
    }

    private void makeSortingList(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        makeSortingList(node.left, list);
        list.add(node.val);
        makeSortingList(node.right, list);
    }
}