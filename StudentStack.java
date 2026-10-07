package studentrecord;



import java.util.Stack;

public class StudentStack {
    Stack<Student> stack = new Stack<>();

    // Push
    public void push(Student student) {
        stack.push(student);
    }

    // Pop
    public Student pop() {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}