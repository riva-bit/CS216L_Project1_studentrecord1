package studentrecord;

public class StudentLinkedList {

    StudentNode head;

    // For undo update
    Student lastUpdatedStudent;

    // Add student
    public void add(Student student) {

        StudentNode newNode = new StudentNode(student);

        if (head == null) {

            head = newNode;

        } else {

            StudentNode current = head;

            while (current.next != null) {

                current = current.next;

            }

            current.next = newNode;
        }

        System.out.println("Student added successfully.");
    }

    // Display students
    public void display() {

        if (head == null) {

            System.out.println("No students found.");

            return;
        }

        StudentNode current = head;

        while (current != null) {

            current.data.display();

            current = current.next;
        }
    }

    // Linear search
    public Student search(int id) {

        StudentNode current = head;

        while (current != null) {

            if (current.data.id == id) {

                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    // Delete student
    public Student delete(int id) {

        if (head == null) {

            return null;
        }

        if (head.data.id == id) {

            Student deleted = head.data;

            head = head.next;

            return deleted;
        }

        StudentNode current = head;

        while (current.next != null) {

            if (current.next.data.id == id) {

                Student deleted = current.next.data;

                current.next = current.next.next;

                return deleted;
            }

            current = current.next;
        }

        return null;
    }

    // Update student
    public boolean update(int id, String name, double gpa) {

        Student student = search(id);

        if (student != null) {

            // Save old data for undo
            lastUpdatedStudent = new Student(
                    student.id,
                    student.name,
                    student.gpa
            );

            student.name = name;
            student.gpa = gpa;

            System.out.println("Student updated successfully.");

            return true;
        }

        System.out.println("Student not found.");

        return false;
    }

    // Undo last update
    public boolean undoUpdate() {

        if (lastUpdatedStudent == null) {

            System.out.println("Nothing to undo.");

            return false;
        }

        Student student = search(lastUpdatedStudent.id);

        if (student != null) {

            student.name = lastUpdatedStudent.name;
            student.gpa = lastUpdatedStudent.gpa;

            lastUpdatedStudent = null;

            System.out.println("Last update undone successfully.");

            return true;
        }

        return false;
    }

    // Bubble Sort by GPA
    public void sortByGPA() {

        if (head == null || head.next == null) {

            return;
        }

        boolean swapped;

        do {

            swapped = false;

            StudentNode current = head;

            while (current.next != null) {

                if (current.data.gpa > current.next.data.gpa) {

                    Student temp = current.data;

                    current.data = current.next.data;

                    current.next.data = temp;

                    swapped = true;
                }

                current = current.next;
            }

        } while (swapped);

        System.out.println("Students sorted by GPA.");
    }
}