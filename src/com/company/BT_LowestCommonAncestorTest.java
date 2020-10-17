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
    
}