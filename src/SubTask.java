public class SubTask extends Task {
    int taskId;


    public SubTask(int id, String name, String description, TasksStatus.Status status) {
        super(name, description);
        this.id = id;
        this.status = status;
    }

    public SubTask(String name, String description, TasksStatus.Status status) {
        super(name, description);
        this.status = status;
    }


    @Override
    public String toString() {
        return "SubTask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id + '\'' +
                ", status=" + status + '\'' +
                ", taskId=" + taskId + '\'' +
                ", Class=" + SubTask.class + '\'' +
                '}';
    }
}