package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BT_LowestCommonAncestorTest {

    @Test
    public void testJUnitTests() {
        assertEquals(2, 2, "Testing Actual JUnit assertEquals Function");
    }

    @Test
    public void testTreeConstructor() {
        BT_LowestCommonAncestor tree = new BT_LowestCommonAncestor();
        System.out.println();
        assertEquals(tree.root, null, "Test the root of an empty tree");
    }

    @Test
    public void testAddingNodes() {
        BT_LowestCommonAncestor tree = new BT_LowestCommonAncestor();
        tree.root = new BT_LowestCommonAncestor.TreeNode(6);
        tree.root.left = new BT_LowestCommonAncestor.TreeNode(2);

        assertEquals(tree.root.value, 6, "Root Node should be 6");
        assertEquals(tree.root.left.value, 2, "Root.left should be 2");

        tree.root.left.left = new BT_LowestCommonAncestor.TreeNode(0);
        tree.root.left.right = new BT_LowestCommonAncestor.TreeNode(4);

        assertEquals(tree.root.left.left.value, 0, "Root Node should be 0");
        assertEquals(tree.root.left.right.value, 4, "Root.left should be 4");
    }

    @Test
    public void testLowestCommonAncestor() {
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

        /*
        System.out.print("Visual Representation of Tree \n" +
                "           6\n" +
                "        |      | \n"+
                "      2           8 \n" +
                "     | |         | | \n"+
                "    0   4       7   9 \n"+
                "       | | \n" +
                "      3   5 \n");

        */

        BT_LowestCommonAncestor.TreeNode p = tree.root.left.left; //0
        BT_LowestCommonAncestor.TreeNode q = tree.root.left.right.right; //5
        BT_LowestCommonAncestor.TreeNode result = BT_LowestCommonAncestor.lowestCommonAncestor(tree.root, p, q);
        assertEquals(p.value, 0);
        assertEquals(q.value, 5);
        assertEquals(2, result.value, "lowestCommonAncestor(0, 5) = 2");
        //Node Nodes as above but using different syntax
        assertEquals(2, BT_LowestCommonAncestor.lowestCommonAncestor(tree.root, p, q).value, "lowestCommonAncestor(0, 5) = 2");
        // Another example test
        assertEquals(6, BT_LowestCommonAncestor.lowestCommonAncestor(tree.root, tree.root.right.left, tree.root.left.right.left).value, "lowestCommonAncestor(9, 3) = 6");
    }

}