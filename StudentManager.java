import java.io.*;
import java.util.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE = "data/students.csv";

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public void viewStudents() {
        if (students.isEmpty()) System.out.println("No records found.");
        else students.forEach(s -> System.out.println(s));
    }

    public void updateMarks(String id, int newMarks) {
        for (Student s : students)
            if (s.getId().equals(id)) {
                s.setMarks(newMarks);
                saveToFile();
                return;
            }
        System.out.println("Student not found.");
    }

    public void deleteStudent(String id) {
        students.removeIf(s -> s.getId().equals(id));
        saveToFile();
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (Student s : students)
                pw.println(s.toString());
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void loadFromFile() {
        try (Scanner sc = new Scanner(new File(FILE))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data.length >= 3)
                    students.add(new Student(data[0], data[1], Integer.parseInt(data[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing data found.");
        }
    }
}
