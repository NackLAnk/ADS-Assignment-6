import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    /**
     * Constructs a new vertex with the specified data.
     * @param data the data associated with the vertex
     */
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Returns the data associated with the vertex.
     * @return the data of the vertex
     */
    public V getData() {
        return data;
    }

    /**
     * Adds an adjacent vertex with the specified weight.
     * @param destination the destination vertex
     * @param weight      the weight of the edge connecting the vertices
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    /**
     * Returns a map of adjacent vertices and their corresponding edge weights.
     * @return the map of adjacent vertices and weights
     */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}