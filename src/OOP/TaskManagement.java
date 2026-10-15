package OOP;
//Design a Task class for a task management application.
//Requirements
//1. Each task has an id, title, and completed status.
//2. The id and title must not be accessible for direct modification from outside the class.
//        3. A task's title cannot be null, empty, or blank.
//        4. A task starts as incomplete.
//5. Provide a method to mark the task as completed.
//6. Provide a method to retrieve its current completion status.
//7. Write a main() method that creates two tasks and demonstrates that completing one does not affect the other.
//Constraints
//- Use Java.
//        - Use encapsulation properly.
//- Don't add unnecessary design patterns or inheritance yet.
//        - Don't copy the earlier Task implementation directly; build your own solution.
class Task{
    private String id,title;
    boolean isCompleted;


    public void markCompleted(){
        if(isCompleted) return;
        isCompleted=true;
    }
    public boolean getStatus(){
        return this.isCompleted;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setTitle(String title){
        if(title == null || title.isBlank()) throw new IllegalArgumentException();
        this.title=title;
    }
}

public class TaskManagement {
    static void main() {
        Task task1= new Task();
        task1.setId("123");
        task1.setTitle("Hello 123");
        Task task2 = new Task();
        task2.setId("234");
        task2.setTitle("Hello 345");
        task1.markCompleted();
        System.out.println(task1.getStatus());
        System.out.println(task2.getStatus());
    }
}
