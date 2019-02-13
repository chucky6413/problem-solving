import java.util.LinkedList;
import java.util.Queue;

public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<NodeWrapper> queue = new LinkedList<>();
        queue.offer(new NodeWrapper(1, root));

        int width = 0;
        while (!queue.isEmpty()) {
            int begin = queue.peek().seq;

            int curQueueSize = queue.size();
            for (int i = 0; i < curQueueSize; i++) {
                NodeWrapper nw = queue.poll();

                if (nw.node.left != null) {
                    queue.offer(new NodeWrapper(nw.seq * 2 - 1, nw.node.left));
                }

                if (nw.node.right != null) {
                    queue.add(new NodeWrapper(nw.seq * 2, nw.node.right));
                }

                if (i == curQueueSize - 1) {
                    width = Math.max(width, nw.seq - begin + 1);
                }
            }
        }

        return width;
    }

    class NodeWrapper {
        int seq;
        TreeNode node;

        public NodeWrapper(int seq, TreeNode node) {
            this.seq = seq;
            this.node = node;
        }
    }
}