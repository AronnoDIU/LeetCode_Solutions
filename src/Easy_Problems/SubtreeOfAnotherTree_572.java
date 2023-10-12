package Easy_Problems;

public class SubtreeOfAnotherTree_572 {
    TreeNode root, subRoot;

    boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        /* Check if the data of both roots is same and data
           of left and right subtrees are also same */
        if (root.val == subRoot.val) {
            return isIdentical(root.left, subRoot.left)
                    && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

    boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        /* Check the tree with root as current node */

        if (isIdentical(root, subRoot)) {
            return true;
        }
        /* If the tree with root as current node doesn't match,
        then try left and right subtrees one by one */
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree_572 tree = new SubtreeOfAnotherTree_572();

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        tree.root = new TreeNode(26);
        tree.root.right = new TreeNode(3);
        tree.root.right.right = new TreeNode(3);
        tree.root.left = new TreeNode(10);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.left.right = new TreeNode(30);
        tree.root.left.right = new TreeNode(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        tree.subRoot = new TreeNode(10);
        tree.subRoot.right = new TreeNode(6);
        tree.subRoot.left = new TreeNode(4);
        tree.subRoot.left.right = new TreeNode(30);

        if (tree.isSubtree(tree.root, tree.subRoot))
            System.out.println(
                    "Tree 2 is subtree of Tree 1 ");
        else
            System.out.println(
                    "Tree 2 is not a subtree of Tree 1");
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

/*Expected Output:

Tree 2 is subtree of Tree 1

* */