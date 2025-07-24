


public class SubTask {
    public String name;
    public String description;  //описание
    public Integer id;
    public TaskStatus.Status status = TaskStatus.Status.NEW;
    public Integer taskId;


    public SubTask (int id, int taskId, String name, String description) {    // конструктор подзадач
        this.id = id;
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public SubTask (int id, int taskId, String name, String description, TaskStatus.Status status) {    // конструктор для смены статуса
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.taskId = taskId;
    }
}
