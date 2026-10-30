import java.io.*;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private String fileName;
    private int nextId = 1;

    public TaskManager(String fileName) {
        this.fileName = fileName;
        load();
    }

    private void load() {
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("\\|", 3);
                int id = Integer.parseInt(parts[0]);
                boolean done = Boolean.parseBoolean(parts[1]);
                tasks.add(new Task(id, parts[2], done));
                if (id >= nextId) {
                    nextId = id + 1;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Could not load tasks: " + e.getMessage());
        }
    }

    private void save() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < tasks.size(); i++) {
                writer.println(tasks.get(i).toFileLine());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Could not save tasks: " + e.getMessage());
        }
    }

    public void addTask(String description) {
        tasks.add(new Task(nextId, description, false));
        nextId++;
        save();
    }

    public void listTasks() {
        if (tasks.size() == 0) {
            System.out.println("No tasks yet.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
    }

    public boolean markDone(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.get(i).setDone(true);
                save();
                return true;
            }
        }
        return false;
    }

    public boolean deleteTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                save();
                return true;
            }
        }
        return false;
    }
}
