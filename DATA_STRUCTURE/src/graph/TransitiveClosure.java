package graph;

public class TransitiveClosure {
    private DirectedDFS[] tc;  // tc[v] = reachable from v

    /**
     * Computes the transitive closure of the digraph <tt>G</tt>.
     * @param G the digraph
     */
    public TransitiveClosure(Digraph G) {
        tc = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++)
            tc[v] = new DirectedDFS(G, v);
    }

    /**
     * Is there a directed path from vertex <tt>v</tt> to vertex <tt>w</tt> in the digraph?
     * @param v the source vertex
     * @param w the target vertex
     * @return <tt>true</tt> if there is a directed path from <tt>v</tt> to <tt>w</tt>,
     *    <tt>false</tt> otherwise
     */
    public boolean reachable(int v, int w) {
        return tc[v].marked(w);
    }


}
