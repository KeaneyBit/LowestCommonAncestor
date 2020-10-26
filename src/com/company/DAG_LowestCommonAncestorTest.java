package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DAG_LowestCommonAncestorTest {



    @Test
    public void testJUnitTests() {
        assertEquals(2, 2, "Testing Actual JUnit assertEquals Function");
    }

    @Test
    public void testEdgesAndVertices() {
        DAG_LowestCommonAncestor g = new DAG_LowestCommonAncestor(9);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        assertEquals(9,  g.E, "Number of Edges is 9");
        assertEquals(9,  g.V, "Number of Edges is 9");
    }


    public void testGraphConstructor () {
        DAG_LowestCommonAncestor g = new DAG_LowestCommonAncestor(-9);
        //Throws an exception
    }

    @Test
    public void testLCAofDAG() {
        DAG_LowestCommonAncestor g = new DAG_LowestCommonAncestor(9);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        assertEquals(7,  g.lowestCommonAncestor(g, 5, 1).getV(), "LCA of 5,1 = 7");
        assertEquals(7,  g.lowestCommonAncestor(g, 1, 5).getV(), "LCA of 1,5 = 7");

        assertEquals(4,  g.lowestCommonAncestor(g, 0, 2).getV(), "LCA of 0,2 = 4");
        assertEquals(1,  g.lowestCommonAncestor(g, 0, 0).getV(), "LCA of 0,0 = 1");
        assertEquals(8,  g.lowestCommonAncestor(g, 0, 7).getV(), "LCA of 0,7 = 8");
    }

    @Test
    public void testIsCyclic() {
        DAG_LowestCommonAncestor g = new DAG_LowestCommonAncestor(9);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
        g.addEdge(7, 8);

        DAG_LowestCommonAncestor cycle = new DAG_LowestCommonAncestor(9);
        cycle.addEdge(0, 1);
        cycle.addEdge(0, 2);
        cycle.addEdge(2, 1);
        cycle.addEdge(1, 2);
        cycle.addEdge(2, 4);
        cycle.addEdge(4, 3);
        cycle.addEdge(3, 1);
        cycle.addEdge(3, 6);
        cycle.addEdge(6, 8);
        cycle.addEdge(7, 8);

        assertEquals(true,  cycle.checkIfAcyclic(), "Cyclic Graph contains a Cycle");
        assertEquals(false,  g.checkIfAcyclic(), "G Graph does not contains a Cycle");

    }
}
