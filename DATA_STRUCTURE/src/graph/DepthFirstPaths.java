package graph;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex

    /** find paths in G from source s */
    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /** depth first search from v */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /** Is there a path from s to v */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /** Returns a path between the s and v, or null if no such path.*/
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])//backtracking the parent
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
    	/*DepthFirstPaths paths = new DepthFirstPaths(G, s);
    	for(int v = 0; v < G.V(); v++) {
    		if(paths.hasPathTo(v)) {
    			System.out.println(v);
    		}
    	}*/
    }
}
