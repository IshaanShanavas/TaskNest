import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager manager = new TaskManager("tasks.txt");
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("=== Task Tracker ===");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Mark task done");
            System.out.println("4. Delete task");
            System.out.println("5. Quit");
            System.out.print("Choose: ");
            String choice = input.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Description: ");
                String description = input.nextLine().trim();
                if (description.length() == 0) {
                    System.out.println("Description cannot be empty.");
                } else {
                    manager.addTask(description);
                    System.out.println("Task added.");
                }
            } else if (choice.equals("2")) {
                manager.listTasks();
            } else if (choice.equals("3")) {
                System.out.print("Task id: ");
                try {
                    int id = Integer.parseInt(input.nextLine().trim());
                    if (manager.markDone(id)) {
                        System.out.println("Marked as done.");
                    } else {
                        System.out.println("No task with that id.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                }
            } else if (choice.equals("4")) {
                System.out.print("Task id: ");
                try {
                    int id = Integer.parseInt(input.nextLine().trim());
                    if (manager.deleteTask(id)) {
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("No task with that id.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                }
            } else if (choice.equals("5")) {
                running = false;
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid choice.");
            }
        }
        input.close();
    }
}
