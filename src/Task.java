public class Task {
    public String name;
    public String description;  //описание
    public Integer id;
    public TasksStatus.Status status = TasksStatus.Status.NEW;

    public Task (Integer id, String name, String description) {  // конструктор задач
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Task (Integer id, String name, String description, TasksStatus.Status status) {  // конструктор для смены статуса
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Task (Task epic) {  // конструктор для смены статуса
        this.id = epic.id;
        this.name = epic.name;
        this.description = epic.description;
        this.status = epic.status;
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
