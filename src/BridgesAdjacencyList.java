import java.util.ArrayList;
import java.util.List;

/**
 * Find all bridges in an undirected graph
 */
public class BridgesAdjacencyList {
    private int n, id;
    private int[] low, ids;
    private boolean solved;
    private boolean[] visited;
    private List<List<Integer>> graph;
    private List<Integer> bridges;

    public BridgesAdjacencyList(List<List<Integer>> graph, int n) {
        if (graph == null || n <= 0 || graph.size() != n) throw new IllegalArgumentException();
        this.graph = graph;
        this.n = n;
    }

    public List<Integer> findBridges() {

    }

    public static void main(String[] args) {

        int n = 9;
        List<List<Integer>> graph = createGraph(n);

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 2, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 6, 7);
        addEdge(graph, 7, 8);
        addEdge(graph, 8, 5);

        BridgesAdjacencyList solver = new BridgesAdjacencyList(graph, n);
        List<Integer> bridges = solver.findBridges();

        // Prints:
        // Bridge between nodes: 3 and 4
        // Bridge between nodes: 2 and 3
        // Bridge between nodes: 2 and 5
        for (int i = 0; i < bridges.size() / 2; i++) {
            int node1 = bridges.get(2 * i);
            int node2 = bridges.get(2 * i + 1);
            System.out.printf("Bridge between nodes: %d and %d\n", node1, node2);
        }
    }

    // Initialize graph with 'n' nodes.
    public static List<List<Integer>> createGraph(int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        return graph;
    }

    // Add undirected edge to graph.
    public static void addEdge(List<List<Integer>> graph, int from, int to) {
        graph.get(from).add(to);
        graph.get(to).add(from);
    }
}
