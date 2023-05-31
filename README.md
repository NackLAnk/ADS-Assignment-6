# [![Typing SVG](https://readme-typing-svg.herokuapp.com?font=Fira+Code&weight=100&size=40&duration=2700&pause=1000&color=F7B03B&background=DAFF6F00&multiline=true&width=450&height=80&lines=Algorithm+Graphs)](https://git.io/typing-svg)

This repository provides Java implementations of two fundamental graph algorithms: Breadth-First Search (BFS) and Dijkstra's Algorithm. These algorithms are used to traverse graphs and find the shortest path in weighted graphs.

## Classes

The repository consists of the following classes:

- `Vertex`: Represents a vertex in a graph and stores its associated data.
- `WeightedGraph`: Represents a weighted graph and provides methods for adding vertices, edges, and retrieving adjacent vertices.
- `Search`: An abstract class that serves as the base class for implementing graph search algorithms.
- `BreadthFirstSearch`: Implements the Breadth-First Search algorithm for graph traversal.
- `DijkstraSearch`: Implements Dijkstra's Algorithm for finding the shortest path in a weighted graph.

## Methods in Classes

### `Vertex` Class

- `getData()`: Returns the data associated with the vertex.
- `addAdjacentVertex(Vertex<V> destination, double weight)`: Adds an adjacent vertex with the specified weight.
- `getAdjacentVertices()`: Returns a map of adjacent vertices and their associated weights.
- `toString()`: Returns a string representation of the vertex.

### `WeightedGraph` Class

- `addVertex(Vertex<V> vertex)`: Adds a vertex to the graph.
- `addEdge(Vertex<V> source, Vertex<V> destination, double weight)`: Adds an edge between two vertices with the specified weight.
- `getAdjacentVertices(Vertex<V> vertex)`: Returns a list of adjacent vertices for the given vertex.
- `getWeight(Vertex<V> source, Vertex<V> destination)`: Returns the weight of the edge between the source and destination vertices.
- `getVertices()`: Returns a list of all vertices in the graph.

### `Search` Class

- `traverse(Vertex<V> startVertex)`: Performs a graph traversal starting from the specified start vertex. This method is abstract and needs to be implemented by subclasses.

### `BreadthFirstSearch` Class

- `traverse(Vertex<V> startVertex)`: Performs a Breadth-First Search traversal starting from the specified start vertex and returns a list of visited vertices in the order they were traversed.

### `DijkstraSearch` Class

- `traverse(Vertex<V> startVertex)`: Performs Dijkstra's Algorithm starting from the specified start vertex to compute the shortest path to all other vertices.
- `getShortestDistance(Vertex<V> vertex)`: Returns the shortest distance from the start vertex to the specified vertex.
- `getShortestPath(Vertex<V> destination)`: Returns a list of vertices representing the shortest path from the start vertex to the specified destination vertex.

## Usage

```java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        // Create a weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);

        // Connect vertices with edges and weights
        graph.addEdge(vertexA, vertexB, 1.0);
        graph.addEdge(vertexB, vertexC, 2.0);
        graph.addEdge(vertexC, vertexD, 3.0);
        graph.addEdge(vertexD, vertexE, 4.0);
        graph.addEdge(vertexA, vertexC, 1.5);
        graph.addEdge(vertexC, vertexE, 2.5);

        // Perform BFS traversal
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        List<Vertex<String>> bfsTraversal = bfs.traverse(vertexA);
        System.out.println("BFS traversal: " + bfsTraversal);

        // Find the shortest path using Dijkstra's Algorithm
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        dijkstra.traverse(vertexA);
        List<Vertex<String>> shortestPath = dijkstra.getShortestPath(vertexE);
        System.out.println("Shortest path from A to E: " + shortestPath);
    }
}
```

## Output

[![Typing SVG](https://readme-typing-svg.herokuapp.com?font=Fira+Code&weight=300&size=25&duration=2700&pause=1000&color=F7B03B&background=DAFF6F06&multiline=true&width=600&height=80&lines=BFS+traversal%3A+%5BA%2C+B%2C+C%2C+D%2C+E%5D+;Shortest+path+from+A+to+E%3A+%5BA%2C+C%2C+E%5D)](https://git.io/typing-svg)
