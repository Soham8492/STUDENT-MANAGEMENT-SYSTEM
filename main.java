import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.loadFromFile();

        while (true) {
            System.out.println("\n=== STUDENT GRADE MANAGEMENT ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Marks: "); int marks = sc.nextInt();
                    manager.addStudent(new Student(id, name, marks));
                    break;
                case 2:
                    manager.viewStudents(); break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    id = sc.nextLine();
                    System.out.print("New Marks: ");
                    marks = sc.nextInt();
                    manager.updateMarks(id, marks);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    id = sc.nextLine();
                    manager.deleteStudent(id);
                    break;
                case 5:
                    System.out.println("Exiting..."); return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
