import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {
    public ArrayList<SubTask> epicSubtasks = new ArrayList<>();

    public Epic(String name, String description) {   //
        super(name, description);
    }


    public static TasksStatus.Status calculateStatus(Epic epic) {
        if (!Objects.equals(epic.epicSubtasks, new ArrayList<>())) {
            int New = 0;
            int done = 0;

            for (SubTask subTask : epic.epicSubtasks) {
                if (subTask.status == TasksStatus.Status.NEW) {
                    New += 1;
                } else if (subTask.status == TasksStatus.Status.IN_PROGRESS) {
                    return TasksStatus.Status.IN_PROGRESS;
                } else if (subTask.status == TasksStatus.Status.DONE) {
                    done += 1;
                }
            }
            if (done == 0) {
                return TasksStatus.Status.NEW;
            }
            if (New == 0) {
                return TasksStatus.Status.DONE;
            }
            return TasksStatus.Status.IN_PROGRESS;
        }
        return epic.status;
    }


    @Override
    public String toString() {
        return "Epic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id + '\'' +
                ", status=" + status + '\'' +
                ", Class=" + Epic.class + '\'' +
                ", subtasks=" + epicSubtasks + '\'' +
                '}';
    }
}