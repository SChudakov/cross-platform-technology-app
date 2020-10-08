package com.chudakov;

public class Main {
    private static final String FILE_PATH = "/home/semen/drive/9th-semester/cross-platform-technologies-app/src/main/resources/graph.txt";

    public static void main(String[] args) {
        writeGraph();
        Graph graph = readGraph();

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        BFSShortestPath bfsShortestPath = new BFSShortestPath(graph);
        AStarShortestPath aStarShortestPath = new AStarShortestPath(graph, (source, target) -> 0);

        System.out.println("Dijkstra shortest path:");
        System.out.println(dijkstraShortestPath.getShortestPath(0, 4));
        System.out.println("BFS shortest path:");
        System.out.println(bfsShortestPath.getShortestPath(0, 4));
        System.out.println("AStar shortest path:");
        System.out.println(aStarShortestPath.getShortestPath(0, 4));
    }

    private static Graph readGraph() {
        GraphReader reader = new GraphReader();
        return reader.readGraph(FILE_PATH);
    }

    private static void writeGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.addEdge(0, 2);
        graph.addEdge(2, 4);

        GraphWriter writer = new GraphWriter();
        writer.writeGraph(FILE_PATH, graph);
    }
}
