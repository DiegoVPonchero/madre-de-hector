import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StackManager stackManager = new StackManager();
        QueueManager queueManager = new QueueManager();
        ListManager listManager = new ListManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSeleccione una estructura de datos:");
            System.out.println("1. Pila");
            System.out.println("2. Cola");
            System.out.println("3. Lista");
            System.out.println("4. Salir");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    stackOperations(stackManager, scanner);
                    break;
                case 2:
                    queueOperations(queueManager, scanner);
                    break;
                case 3:
                    listOperations(listManager, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void stackOperations(StackManager stackManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nSeleccione una operación de pila:");
            System.out.println("1. Push (Agregar tarea)");
            System.out.println("2. Pop (Remover tarea)");
            System.out.println("3. Peek (Ver tarea en la cima)");
            System.out.println("4. Ver todas las tareas");
            System.out.println("5. Volver al menú principal");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Ingrese la tarea a agregar:");
                    String task = scanner.nextLine();
                    stackManager.push(task);
                    break;
                case 2:
                    System.out.println("Tarea removida: " + stackManager.pop());
                    break;
                case 3:
                    System.out.println("Tarea en la cima: " + stackManager.peek());
                    break;
                case 4:
                    stackManager.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 5);
    }

    private static void queueOperations(QueueManager queueManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nSeleccione una operación de cola:");
            System.out.println("1. Enqueue (Agregar tarea con prioridad)");
            System.out.println("2. Dequeue (Remover tarea)");
            System.out.println("3. Front (Ver primera tarea)");
            System.out.println("4. Ver todas las tareas");
            System.out.println("5. Volver al menú principal");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Ingrese la tarea a agregar:");
                    String task = scanner.nextLine();
                    System.out.println("Ingrese la prioridad de la tarea (entero):");
                    // Debug output for priority input
                    int priority = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Debug: Tarea -> " + task + ", Prioridad -> " + priority); // Debug line
                    queueManager.enqueue(task); // Corrected line
                    break;
                case 2:
                    System.out.println("Tarea removida: " + queueManager.dequeue());
                    break;
                case 3:
                    System.out.println("Primera tarea: " + queueManager.front());
                    break;
                case 4:
                    queueManager.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 5);
    }

    private static void listOperations(ListManager listManager, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nSeleccione una operación de lista:");
            System.out.println("1. Insert (Agregar tarea con prioridad)");
            System.out.println("2. Delete (Remover tarea)");
            System.out.println("3. Find (Buscar tarea)");
            System.out.println("4. Ver todas las tareas");
            System.out.println("5. Volver al menú principal");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Ingrese la tarea a agregar:");
                    String task = scanner.nextLine();
                    System.out.println("Ingrese la prioridad de la tarea (entero):");
                    // Debug output for priority input
                    int priority = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Debug: Tarea -> " + task + ", Prioridad -> " + priority); // Debug line
                    listManager.insert(task + " " + priority); // Corrected line
                    break;
                case 2:
                    System.out.println("Ingrese la tarea a eliminar:");
                    String taskToDelete = scanner.nextLine();
                    listManager.delete(taskToDelete);
                    break;
                case 3:
                    System.out.println("Ingrese la tarea a buscar:");
                    String taskToFind = scanner.nextLine();
                    if (listManager.find(taskToFind)) {
                        System.out.println("Tarea encontrada: " + taskToFind);
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 4:
                    listManager.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (choice != 5);
    }
}