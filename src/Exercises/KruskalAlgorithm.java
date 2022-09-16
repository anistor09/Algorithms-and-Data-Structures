package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import Exercises.Library.Edge;
import Exercises.Library.UnionFind;


public class KruskalAlgorithm {

    /**
     * Builds a Minimum Spanning Tree (MST) using
     * Kruskal's Algorithm (as learned in class).
     * Nodes are numbered from 0 to n - 1.
     *
     * @param n     the amount of nodes in the graph
     * @param edges the edges that comprise the graph
     * @return the list of edges that should be included in the MST
     */
    public static List<Edge> buildMST(int n, List<Edge> edges) {
        // TODO
        List<Edge> finalMST = new ArrayList();
        UnionFind clusters = new UnionFind(n);
        PriorityQueue<Edge> pq = new PriorityQueue<>();


        for (Edge edge : edges) {
            pq.add(edge);
        }
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int from = edge.getFrom();
            int to = edge.getTo();
            if (clusters.union(from, to)) {
                finalMST.add(edge);

            }
        }
        return finalMST;
    }
}





