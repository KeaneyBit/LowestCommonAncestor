package com.company;

public class BT_LowestCommonAncestor {

    TreeNode root;

    public static class TreeNode{
        int value;
        TreeNode left, right;
        TreeNode(int x) {
            value = x;
            left = right = null;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p.value < root.value && q.value < root.value)
            return lowestCommonAncestor(root.left, p, q);
        else if(p.value < root.value && q.value < root.value){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        BT_LowestCommonAncestor tree = new BT_LowestCommonAncestor();
        tree.root = new TreeNode(6);
        tree.root.left = new TreeNode(2);
        tree.root.left.left = new TreeNode(0);

        tree.root.left.right = new TreeNode(4);
        tree.root.left.right.left = new TreeNode(3);
        tree.root.left.right.right = new TreeNode(5);

        tree.root.right = new TreeNode(8);
        tree.root.right.left = new TreeNode(7);
        tree.root.right.left = new TreeNode(9);

        TreeNode p = tree.root.left.left;
        TreeNode q = tree.root.left.right.right;
        TreeNode result = lowestCommonAncestor(tree.root, p, q);
        System.out.print("Lowest Common Ancestor of Node " + p.value + " and Node " +
        q.value + " is: Node " + result.value);
    }

}
