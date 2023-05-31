import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    /**
     * Constructs a BreadthFirstSearch object with the given weighted graph.
     * @param graph the weighted graph to perform breadth-first search on
     */
    public BreadthFirstSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    /**
     * Performs breadth-first search traversal starting from the specified start vertex.
     * @param startVertex the start vertex for the traversal
     * @return the list of vertices visited during the traversal in the order they were visited
     */
    public List<Vertex<V>> traverse(Vertex<V> startVertex) {
        List<Vertex<V>> visited = new ArrayList<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            List<Vertex<V>> adjacentVertices = getGraph().getAdjacentVertices(currentVertex);

            for (Vertex<V> adjacentVertex : adjacentVertices) {
                if (!visited.contains(adjacentVertex)) {
                    visited.add(adjacentVertex);
                    queue.offer(adjacentVertex);
                }
            }
        }

        return visited;
    }
}