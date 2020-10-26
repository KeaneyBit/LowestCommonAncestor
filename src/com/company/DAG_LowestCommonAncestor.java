package com.company;

//For my implementation of DAG it makes much more sense to use a 2D array
//so that I can compare my graph to a matrix

import java.util.LinkedList;
import java.util.List;

public class DAG_LowestCommonAncestor {
    //Node Class
    class AdjListNode {
        private int v;
        private int weight;

        AdjListNode(int _v, int _w) {
            v = _v;
            weight = _w;
        }

        int getV() {
            return v;
        }
        int getWeight() {
            return weight;
        }
        void setWeight(int newWeight) {
            weight = newWeight;
            return;
        }

    }

    //DAG Graph
    int E;
    int V;
    private LinkedList<AdjListNode> adj[];
    private int[] visited;

    DAG_LowestCommonAncestor(int v) {
        if(v < 0) {throw new IllegalArgumentException("Needs more vertices to be a graph.");}
        V = v;
        E = 0;
        adj = new LinkedList[V];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<AdjListNode>();
        }
        visited = new int[v];

    }
    void incE () {
        E++;
        return;
    }

    public void addEdge(int u, int v) {
        AdjListNode node = new AdjListNode(v, 1);
        adj[u].add(node);// Add v to u's list
        incE();
    }

    // I wasn't able to think of a way to create a lowestCommonAncestor function using
    // recursion so I went an used a matrix method instead
    public static AdjListNode lowestCommonAncestor(DAG_LowestCommonAncestor g, int v, int w) {
        if(g.checkIfAcyclic()) { return null; }
        int[] vArr = new int[g.E];
        int[] wArr = new int[g.E];
        boolean[] vMarked = new boolean[g.V];
        boolean[] wMarked = new boolean[g.V];
        int vCount =0;
        int wCount = 0;
        vArr[vCount]=v;
        wArr[wCount]=w;
        for(int j=0; j<g.V;j++){//mark all vertices as not been visited yet
            vMarked[j]=false;
            wMarked[j]=false;
        }
        for(int i =0;i<g.V;i++){
            vMarked[v] =true;
            wMarked[w] =true;
            for(int j = 0; j<g.adj[i].size();j++){
                if(g.adj[i].get(j)!=null && vMarked[i]){
                    vCount++;
                    vArr[vCount]=j;
                    vMarked[j]=true;
                }
                if(g.adj[i].get(j)!=null && wMarked[i]){
                    wCount++;
                    wArr[wCount]=j;
                    wMarked[j]=true;
                }
                if(wArr[wCount]==vArr[vCount]){
                    //return wArr[wCount];
                    return g.adj[i].get(wArr[wCount]);
                }
            }
        }
        return null;//returns -1 if no ancestor found
    }

    public boolean isCyclic(int i, boolean[] visited, boolean[] recStack) {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        LinkedList<AdjListNode> children = adj[i];

        for (AdjListNode c: children)
            if (isCyclic(c.getV(), visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }
    boolean checkIfAcyclic () {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i = 0; i<V;i++)
            if(isCyclic(i, visited, recStack))
                return true;

        return false;
    }
    public static void printGraph(DAG_LowestCommonAncestor cycle) {
        for(int i =0; i < cycle.V; i++) {
            if(cycle.adj[i].size() != 0) {
                for(int j=0; j < cycle.adj[i].size(); j++) {
                    System.out.print(i + "-> " + cycle.adj[i].get(j).getV() + " ");
                }
                System.out.println("");
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        DAG_LowestCommonAncestor b = new DAG_LowestCommonAncestor(6);
        b.addEdge(0, 1);
        b.addEdge(0, 2);
        if(b.checkIfAcyclic()) {System.out.println("hello there b");}
        printGraph(b);
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
        //Print Graph
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

        printGraph(cycle);
        printGraph(g);
        if(cycle.checkIfAcyclic()) {
            System.out.println("Mama Mia! There's a cycle!");
        }
        if(g.checkIfAcyclic()) {
            System.out.println("Mama Mia! There's a cycle!");
        }
        System.out.println(g.lowestCommonAncestor(g, 1, 5).getV()); //7
        System.out.println(g.lowestCommonAncestor(g, 5, 2).getV()); //7
    }
}
