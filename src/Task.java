public class Task {
    protected String name;
    protected String description;  //описание
    protected Integer id;
    protected TasksStatus.Status status = TasksStatus.Status.NEW;

    public Task (String name, String description) {  // конструктор задач
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id + '\'' +
                ", status=" + status + '\'' +
                ", Class=" + Task.class + '\'' +
                '}';
    }
}