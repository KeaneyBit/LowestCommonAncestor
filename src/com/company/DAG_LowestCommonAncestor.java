package com.company;

public class DAG_LowestCommonAncestor {
    BT_LowestCommonAncestor.TreeNode root;

    public static class TreeNode{
        int value;
        BT_LowestCommonAncestor.TreeNode left, right;
        TreeNode(int x) {
            value = x;
            left = right = null;
        }
    }

    public static BT_LowestCommonAncestor.TreeNode lowestCommonAncestor(BT_LowestCommonAncestor.TreeNode root, BT_LowestCommonAncestor.TreeNode p, BT_LowestCommonAncestor.TreeNode q){
        if(p.value < root.value && q.value < root.value)
            return lowestCommonAncestor(root.left, p, q);
        else if(p.value > root.value && q.value > root.value)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {

        /* Visual Representation of Tree
        |   |   |   |   |   |   |   |   |
        "
                          6
                      /      \
                    2           8
                  /   \       /   \
                0       4    7     9
                      /   \
                     3     5
         "
         */
        BT_LowestCommonAncestor tree = new BT_LowestCommonAncestor();
        tree.root = new BT_LowestCommonAncestor.TreeNode(6);
        tree.root.left = new BT_LowestCommonAncestor.TreeNode(2);
        tree.root.left.left = new BT_LowestCommonAncestor.TreeNode(0);

        tree.root.left.right = new BT_LowestCommonAncestor.TreeNode(4);
        tree.root.left.right.left = new BT_LowestCommonAncestor.TreeNode(3);
        tree.root.left.right.right = new BT_LowestCommonAncestor.TreeNode(5);

        tree.root.right = new BT_LowestCommonAncestor.TreeNode(8);
        tree.root.right.left = new BT_LowestCommonAncestor.TreeNode(7);
        tree.root.right.left = new BT_LowestCommonAncestor.TreeNode(9);


        System.out.print("Visual Representation of Tree \n" +
                "           6\n" +
                "        |      | \n"+
                "      2           8 \n" +
                "     | |         | | \n"+
                "    0   4       7   9 \n"+
                "       | | \n" +
                "      3   5 \n");

        BT_LowestCommonAncestor.TreeNode p = tree.root.left.left;
        BT_LowestCommonAncestor.TreeNode q = tree.root.left.right.right;
        BT_LowestCommonAncestor.TreeNode result = lowestCommonAncestor(tree.root, p, q);
        System.out.println("Result should be: Lowest Common Ancestor of Node 0 and Node 5 is: Node 2");
        System.out.println("Lowest Common Ancestor of Node " + p.value + " and Node " +
                q.value + " is: Node " + result.value);


        // Added more Test Cases
        p = tree.root.right.left;
        q = tree.root.left.right.left;
        result = lowestCommonAncestor(tree.root, p, q);
        System.out.println("Result should be: Lowest Common Ancestor of Node 9 and Node 3 is: Node 6");
        System.out.println("Lowest Common Ancestor of Node " + p.value + " and Node " +
                q.value + " is: Node " + result.value);

        p = tree.root.right;
        q = tree.root.right.left;
        result = lowestCommonAncestor(tree.root, p, q);
        System.out.println("Result should be: Lowest Common Ancestor of Node 8 and Node 9 is: Node 8");
        System.out.println("Lowest Common Ancestor of Node " + p.value + " and Node " +
                q.value + " is: Node " + result.value);

    }
}
