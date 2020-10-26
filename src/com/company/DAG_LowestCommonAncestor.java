package com.company;

//For my implementation of DAG it makes much more sense to use a 2D array
//so that I can compare my graph to a matrix

import java.util.LinkedList;

public class DAG_LowestCommonAncestor {
    //Node Class
    class AdjListNode
    {
        private int v;
        private int weight;
        AdjListNode(int _v, int _w) { v = _v;  weight = _w; }
        int getV() { return v; }
        int getWeight()  { return weight; }
    }

    //DAG Graph
    int V;
    private LinkedList<AdjListNode>adj[];
    private int[] visited;

    DAG_LowestCommonAncestor(int v)
    {
        V=v;
        adj = new LinkedList[V];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<AdjListNode>();
        visited = new int[v];
    }
    void addEdge(int u, int v, int weight)
    {
        AdjListNode node = new AdjListNode(v,weight);
        adj[u].add(node);// Add v to u's list
    }



    public static void lowestCommonAncestor(){
        return;
    }

    public boolean checkIfAcyclic() {
        int count = 0;
        for(int i =0;i<V;i++){
            visited[count]=i;
            for(int j = 0; j<V;j++){
                for(int k=0;k<V;k++){
                    if(visited[k]==j && adj[i].get(j).getV()==1){
                        return true;
                    }
                }
            }
            count++;
        }
        return false;
    }

    public static void main(String[] args) {

        DAG_LowestCommonAncestor g = new DAG_LowestCommonAncestor(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(0, 5, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
        //Print Graph
        for(int i =0; i < g.V; i++) {
            for(int j=0; j < g.adj[i].size(); j++) {
                System.out.print(i + "-> " + g.adj[i].get(j).getV() + " ");
            }
            System.out.println("");
        }
        if(g.checkIfAcyclic()) {
            System.out.print("Mama Mia! There no cycle!");
        } else {
            System.out.println("Graph is not Acyclic, please re-create");
        }



        //
        //0 -> 1 -> 3
        //     !
        //  -> 2 -> 4
        //       -> 5
    }
}
