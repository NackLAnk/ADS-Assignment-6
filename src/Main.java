import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating vertices
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        // Creating weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();

        // Adding vertices to the graph
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);

        // Adding edges with weights to the graph
        graph.addEdge(vertexA, vertexB, 1.0);
        graph.addEdge(vertexB, vertexC, 2.0);
        graph.addEdge(vertexC, vertexD, 3.0);
        graph.addEdge(vertexD, vertexE, 4.0);
        graph.addEdge(vertexA, vertexC, 1.5);
        graph.addEdge(vertexC, vertexE, 2.5);

        // Performing breadth-first search
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        List<Vertex<String>> bfsTraversal = bfs.traverse(vertexA);
        System.out.println("BFS traversal: " + bfsTraversal);

        // Performing Dijkstra's algorithm
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        dijkstra.traverse(vertexA);
        List<Vertex<String>> shortestPath = dijkstra.getShortestPath(vertexE);
        System.out.println("Shortest path from A to E: " + shortestPath);
    }
}