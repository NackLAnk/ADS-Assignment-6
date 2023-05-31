import java.util.List;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;

    /**
     * Constructs a new Search object with the specified graph.
     * @param graph the weighted graph to perform search on
     */
    public Search(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    /**
     * Performs a search traversal starting from the specified start vertex and returns the visited vertices.
     * @param startVertex the start vertex for the traversal
     * @return the list of visited vertices during the traversal
     */
    public abstract List<Vertex<V>> traverse(Vertex<V> startVertex);

    /**
     * Returns the weighted graph associated with this search.
     * @return the weighted graph
     */
    public WeightedGraph<V> getGraph() {
        return graph;
    }
}