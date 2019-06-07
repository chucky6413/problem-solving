package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder( TreeNode root ) {
        List<List<Integer>> rs = new ArrayList<>();
        if ( root == null ) {
            return rs;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer( root );
        boolean left = true;

        while ( !queue.isEmpty() ) {
            List<Integer> subList = new ArrayList<>();
            int sz = queue.size();

            while ( sz-- > 0 ) {
                TreeNode node = queue.poll();

                if ( left ) {
                    subList.add( node.val );
                } else {
                    subList.add( 0, node.val );
                }

                if ( node.left != null ) {
                    queue.offer( node.left );
                }
                if ( node.right != null ) {
                    queue.offer( node.right );
                }
            }
            rs.add( subList );
            left = !left;
        }

        return rs;
    }
}