import java.util.LinkedList;
import java.util.List;

public class ListManager {
    private List<String> list;

    public ListManager() {
        list = new LinkedList<>();
    }

    public void insert(String task) {
        list.add(task);
        System.out.println("Tarea agregada: " + task);
    }

    public void delete(String task) {
        if (list.remove(task)) {
            System.out.println("Tarea eliminada: " + task);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    public boolean find(String task) {
        return list.contains(task);
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Tareas en la lista:");
            for (String task : list) {
                System.out.println("- " + task);
            }
        }
    }
}