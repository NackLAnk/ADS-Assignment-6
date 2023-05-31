import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> shortestDistances;
    private Map<Vertex<V>, Vertex<V>> previousVertices;

    public DijkstraSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    /**
     * Initializes the shortest distances and previous vertices maps for Dijkstra's algorithm.
     */
    public void initializeDistances() {
        shortestDistances = new HashMap<>();
        previousVertices = new HashMap<>();

        for (Vertex<V> vertex : graph.getVertices()) {
            shortestDistances.put(vertex, Double.POSITIVE_INFINITY);
            previousVertices.put(vertex, null);
        }
    }

    /**
     * Returns the shortest distance to the specified vertex.
     * @param vertex the vertex
     * @return the shortest distance to the vertex
     */
    public double getShortestDistance(Vertex<V> vertex) {
        return shortestDistances.get(vertex);
    }

    /**
     * Sets the shortest distance to the specified vertex.
     * @param vertex   the vertex
     * @param distance the shortest distance to the vertex
     */
    public void setShortestDistance(Vertex<V> vertex, double distance) {
        shortestDistances.put(vertex, distance);
    }

    /**
     * Returns the previous vertex in the shortest path to the specified vertex.
     * @param vertex the vertex
     * @return the previous vertex in the shortest path
     */
    public Vertex<V> getPreviousVertex(Vertex<V> vertex) {
        return previousVertices.get(vertex);
    }

    /**
     * Returns the shortest path from the start vertex to the specified destination vertex.
     * @param destination the destination vertex
     * @return the shortest path as a list of vertices
     */
    public List<Vertex<V>> getShortestPath(Vertex<V> destination) {
        List<Vertex<V>> path = new ArrayList<>();
        Vertex<V> currentVertex = destination;

        while (currentVertex != null) {
            path.add(0, currentVertex);
            currentVertex = getPreviousVertex(currentVertex);
        }

        return path;
    }

    @Override
    public List<Vertex<V>> traverse(Vertex<V> startVertex) {
        dijkstra(startVertex);
        return null;
    }

    /**
     * Performs Dijkstra's algorithm to find the shortest paths from the start vertex to all other vertices in the graph.
     * @param startVertex the start vertex
     */
    public void dijkstra(Vertex<V> startVertex) {
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(this::getShortestDistance));

        initializeDistances();
        setShortestDistance(startVertex, 0);
        priorityQueue.offer(startVertex);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> currentVertex = priorityQueue.poll();
            double currentDistance = getShortestDistance(currentVertex);

            List<Vertex<V>> adjacentVertices = graph.getAdjacentVertices(currentVertex);

            for (Vertex<V> neighbor : adjacentVertices) {
                double edgeWeight = graph.getWeight(currentVertex, neighbor);
                double newDistance = currentDistance + edgeWeight;

                if (newDistance < getShortestDistance(neighbor)) {
                    priorityQueue.remove(neighbor);
                    setShortestDistance(neighbor, newDistance);
                    previousVertices.put(neighbor, currentVertex);
                    priorityQueue.offer(neighbor);
                }
            }
        }
    }
}