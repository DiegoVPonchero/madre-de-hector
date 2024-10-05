import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {
    private Queue<String> queue;

    public QueueManager() {
        queue = new LinkedList<>();
    }

    public void enqueue(String task) {
        queue.add(task);
        System.out.println("Tarea agregada: " + task);
    }

    public String dequeue() {
        if (queue.isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return queue.poll();
    }

    public String front() {
        if (queue.isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return queue.peek();
    }

    public void display() {
        if (queue.isEmpty()) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Tareas en la cola:");
            for (String task : queue) {
                System.out.println("- " + task);
            }
        }
    }
}