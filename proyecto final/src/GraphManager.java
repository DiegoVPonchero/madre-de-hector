import java.util.*;

public class GraphManager {
    // Adjacency list to represent the graph
    private Map<String, List<String>> adjList;

    // Constructor initializes the graph structure
    public GraphManager() {
        adjList = new HashMap<>();
    }

    // Add a task to the graph
    public void addTask(String task) {
        if (!adjList.containsKey(task)) {
            adjList.put(task, new ArrayList<>());
            System.out.println("Tarea agregada: " + task);
        } else {
            System.out.println("La tarea ya existe: " + task);
        }
    }

    // Add a dependency between two tasks (from -> to)
    public void addDependency(String fromTask, String toTask) {
        if (adjList.containsKey(fromTask) && adjList.containsKey(toTask)) {
            adjList.get(fromTask).add(toTask);
            System.out.println("Dependencia agregada: " + fromTask + " -> " + toTask);
        } else {
            System.out.println("Ambas tareas deben existir para agregar una dependencia.");
        }
    }

    // Display all tasks and their dependencies
    public void displayDependencies() {
        System.out.println("Dependencias de tareas:");
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (String dependentTask : entry.getValue()) {
                System.out.print(dependentTask + " ");
            }
            System.out.println();
        }
    }

    // Perform a topological sort on the graph to find an order of tasks
    public void topologicalSort() {
        Map<String, Integer> indegree = new HashMap<>();
        for (String task : adjList.keySet()) {
            indegree.put(task, 0);
        }

        // Calculate in-degrees
        for (String task : adjList.keySet()) {
            for (String neighbor : adjList.get(task)) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }

        // Collect nodes with zero in-degree
        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        // Perform topological sorting
        List<String> sortedTasks = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            sortedTasks.add(current);

            for (String neighbor : adjList.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check if topological sorting is possible (no cycles)
        if (sortedTasks.size() != adjList.size()) {
            System.out.println("No es posible realizar un orden topológico debido a ciclos en las dependencias.");
        } else {
            System.out.println("Orden topológico de tareas:");
            for (String task : sortedTasks) {
                System.out.print(task + " ");
            }
            System.out.println();
        }
    }
}