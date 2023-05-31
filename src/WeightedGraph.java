import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> adjacencyMap;

    /**
     * Constructs a new weighted graph.
     */
    public WeightedGraph() {
        this.adjacencyMap = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex the vertex to add
     */
    public void addVertex(Vertex<V> vertex) {
        adjacencyMap.put(vertex, new ArrayList<>());
    }

    /**
     * Adds an edge with the specified weight between the source and destination vertices.
     * @param source      the source vertex
     * @param destination the destination vertex
     * @param weight      the weight of the edge
     * @throws IllegalArgumentException if the source or destination vertex is not found in the graph
     */
    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        if (!adjacencyMap.containsKey(source) || !adjacencyMap.containsKey(destination)) {
            throw new IllegalArgumentException("Исходная или целевая вершина не найдена в графе.");
        }

        source.addAdjacentVertex(destination, weight);
        adjacencyMap.get(source).add(destination);
    }

    /**
     * Returns a list of adjacent vertices for the specified vertex.
     * @param vertex the vertex to get the adjacent vertices for
     * @return the list of adjacent vertices
     * @throws IllegalArgumentException if the vertex is not found in the graph
     */
    public List<Vertex<V>> getAdjacentVertices(Vertex<V> vertex) {
        if (!adjacencyMap.containsKey(vertex)) {
            throw new IllegalArgumentException("Вершина не найдена в графе.");
        }

        return adjacencyMap.get(vertex);
    }

    /**
     * Returns the weight of the edge between the source and destination vertices.
     * @param source      the source vertex
     * @param destination the destination vertex
     * @return the weight of the edge
     * @throws IllegalArgumentException if the source or destination vertex is not found in the graph
     */
    public double getWeight(Vertex<V> source, Vertex<V> destination) {
        if (!adjacencyMap.containsKey(source) || !adjacencyMap.containsKey(destination)) {
            throw new IllegalArgumentException("Исходная или целевая вершина не найдена в графе.");
        }

        return source.getAdjacentVertices().get(destination);
    }

    /**
     * Returns a list of all vertices in the graph.
     * @return the list of vertices
     */
    public List<Vertex<V>> getVertices() {
        return new ArrayList<>(adjacencyMap.keySet());
    }
}