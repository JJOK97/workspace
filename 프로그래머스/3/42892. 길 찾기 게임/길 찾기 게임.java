import java.util.*;


public class Solution {

    class TreeNode {
        int x, y, idx;
        TreeNode left, right;

        TreeNode(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void main(int[][] nodeinfo) {
        Solution sol = new Solution();
        int[][] result = sol.solution(nodeinfo);
        System.out.println(Arrays.deepToString(result));
    }

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        Arrays.sort(nodes, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode a, TreeNode b) {
                if (b.y == a.y) {
                    return a.x - b.x;
                } else {
                    return b.y - a.y;
                }
            }
        });

        TreeNode root = nodes[0];
        for (int i = 1; i < n; i++) {
            insertNode(root, nodes[i]);
        }

        List<Integer> preorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();
        preorderTraversal(root, preorderList);
        postorderTraversal(root, postorderList);

        int[][] answer = new int[2][];
        answer[0] = preorderList.stream().mapToInt(i -> i).toArray();
        answer[1] = postorderList.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    private void insertNode(TreeNode parent, TreeNode child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    private void preorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.idx);
            preorderTraversal(node.left, result);
            preorderTraversal(node.right, result);
        }
    }

    private void postorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            postorderTraversal(node.left, result);
            postorderTraversal(node.right, result);
            result.add(node.idx);
        }
    }
}
