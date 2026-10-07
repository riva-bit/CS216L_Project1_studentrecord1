package studentrecord;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentLinkedList list = new StudentLinkedList();

        StudentStack stack = new StudentStack();

        int choice;

        do {

            System.out.println("\n===== STUDENT RECORD SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort Students by GPA");
            System.out.println("6. Undo Last Delete");
            System.out.println("7. Update Student");
            System.out.println("8. Undo Last Update");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Student ID: ");

                int id = input.nextInt();

                input.nextLine();

                System.out.print("Enter Student Name: ");

                String name = input.nextLine();

                System.out.print("Enter GPA: ");

                double gpa = input.nextDouble();

                if (gpa < 0 || gpa > 4) {

                    System.out.println("Invalid GPA.");

                } else {

                    Student student = new Student(id, name, gpa);

                    list.add(student);
                }

                break;

            case 2:

                list.display();

                break;

            case 3:

                System.out.print("Enter ID to search: ");

                int searchId = input.nextInt();

                Student found = list.search(searchId);

                if (found != null) {

                    System.out.println("Student found:");

                    found.display();

                } else {

                    System.out.println("Student not found.");
                }

                break;

            case 4:

                System.out.print("Enter ID to delete: ");

                int deleteId = input.nextInt();

                Student deleted = list.delete(deleteId);

                if (deleted != null) {

                    stack.push(deleted);

                    System.out.println("Student deleted.");

                } else {

                    System.out.println("Student not found.");
                }

                break;

            case 5:

                list.sortByGPA();

                break;

            case 6:

                Student undoStudent = stack.pop();

                if (undoStudent != null) {

                    list.add(undoStudent);

                    System.out.println("Last delete undone.");

                } else {

                    System.out.println("Nothing to undo.");
                }

                break;

            case 7:

                System.out.print("Enter Student ID to update: ");

                int updateId = input.nextInt();

                input.nextLine();

                System.out.print("Enter New Name: ");

                String newName = input.nextLine();

                System.out.print("Enter New GPA: ");

                double newGpa = input.nextDouble();

                if (newGpa < 0 || newGpa > 4) {

                    System.out.println("Invalid GPA.");

                } else {

                    list.update(updateId, newName, newGpa);
                }

                break;

            case 8:

                list.undoUpdate();

                break;

            case 9:

                System.out.println("Program ended.");

                break;

            default:

                System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        input.close();
    }
}