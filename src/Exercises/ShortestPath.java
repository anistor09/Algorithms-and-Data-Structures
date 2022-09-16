package Exercises;

import Exercises.Library.AdaptablePQ;
import Exercises.Library.Graph;
import Exercises.Library.Vertex;
import Exercises.Library.VertexNumPair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestPath {
    /**
     * Returns the list of vertices along the shortest path between vertex a and b in graph g.
     *
     * @param g
     *     Graph to consider.
     * @param a
     *     Vertex to start from.
     * @param b
     *     Vertex to go to.
     * @return The list of vertices along the shortest path between a and b, or null if no such path exists.
     */
    public static List<Vertex> shortestPath(Graph g, Vertex a, Vertex b) {
        int n = g.getAllVertices().size();
        boolean isPath=false;
        int[] distance=new int[n];
        Vertex[] parent = new Vertex[n];
        List<Vertex> path = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            distance[i]= Integer.MAX_VALUE;
        }

        distance[a.getId()]=0;
        parent[a.getId()]=a;
        AdaptablePQ pq = new AdaptablePQ();
        pq.insertOrReplace(a,0);
        while(!pq.isEmpty())
        {
            VertexNumPair vtnum = pq.removeMin();
            Vertex current = vtnum.getVertex();

            for(VertexNumPair vtnumnext:g.getNeighbours(current))
            {
                Vertex next= vtnumnext.getVertex();
                if(distance[current.getId()]+vtnumnext.getNum()<distance[next.getId()])
                {
                    distance[next.getId()]=distance[current.getId()]+vtnumnext.getNum();
                    parent[next.getId()]=current;
                    pq.insertOrReplace(next,distance[next.getId()]);
                }
            }
        }

        if(parent[b.getId()]==null)
            return null;

        Vertex current =b;
        while(current!=a)
        {
            path.add(current);
            current=parent[current.getId()];
        }
        path.add(a);
        Collections.reverse(path);
        return path;
    }
}
