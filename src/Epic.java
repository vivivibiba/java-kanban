import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Epic extends Task {

    public HashMap<Integer, SubTask> subtasks = new HashMap<>();



    public Epic(Integer id, String name, String description) {  // конструктор задач
        super(id, name, description);
    }


    public Epic(Integer id, String name, String description, TasksStatus.Status status, HashMap<Integer, SubTask> subtasks) {  // конструктор для смены статуса
        super(id, name, description, status);
        this.subtasks = subtasks;
    }

    public Epic(Task task, HashMap<Integer, SubTask> subtasks) {   // превращение Задачи в Эпик
        super(task.id, task.name, task.description, task.status);
        this.subtasks = subtasks;
    }


    public static TasksStatus.Status calculateStatus(Epic epic) {
        if (!Objects.equals(epic.subtasks, new ArrayList<>())) {
            int New = 0;
            int done = 0;

            for (SubTask subTask : epic.subtasks.values()) {
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
                ", subtasks=" + subtasks + '\'' +
                '}';
    }

}