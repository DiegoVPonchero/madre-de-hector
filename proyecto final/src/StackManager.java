import java.util.Stack;

public class StackManager {
    private Stack<String> stack;

    public StackManager() {
        stack = new Stack<>();
    }

    public void push(String task) {
        stack.push(task);
        System.out.println("Tarea agregada: " + task);
    }

    public String pop() {
        if (stack.isEmpty()) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return stack.pop();
    }

    public String peek() {
        if (stack.isEmpty()) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return stack.peek();
    }

    public void display() {
        if (stack.isEmpty()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Tareas en la pila:");
            for (String task : stack) {
                System.out.println("- " + task);
            }
        }
    }
}
