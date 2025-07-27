public class SubTask extends Task {
    int taskId;

    public SubTask(int id, int taskId, String name, String description) {
        super(id, name, description);
        this.taskId = taskId;
    }

    public SubTask(Integer id, int taskId, String name, String description, TasksStatus.Status status) {
        super(id, name, description, status);
        this.taskId = taskId;
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
