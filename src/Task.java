import java.util.ArrayList;
import java.util.Objects;

public class Task {
    public String name;
    public String description;  //описание
    public Integer id;
    public TaskStatus.Status status = TaskStatus.Status.NEW;
    public ArrayList<SubTask> subtasks = new ArrayList<>();


    public Task (Integer id, String name, String description) {  // конструктор задач
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public Task (Integer id, String name, String description, TaskStatus.Status status, ArrayList<SubTask> subtasks) {  // конструктор для смены статуса
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.subtasks = subtasks;
    }


    public TaskStatus.Status calculateStatus(Task TAsk) {

        if (!Objects.equals(TAsk.subtasks, new ArrayList<>())) {

            int New = 0;
            int inProgress = 0;
            int done = 0;

            for (SubTask subTask : TAsk.subtasks) {
                if (subTask.status == TaskStatus.Status.NEW) {
                    New += 1;
                } else if (subTask.status == TaskStatus.Status.IN_PROGRESS) {
                    inProgress += 1;
                } else if (subTask.status == TaskStatus.Status.DONE) {
                    done += 1;
                }
            }

            // System.out.println(New + " new\n" + inProgress + " inProgress\n" + done + " done\n");

            if (inProgress == 0) {
                if (done == 0) {
                    return TaskStatus.Status.NEW;
                }
            }

            if (New == 0) {
                if (inProgress == 0) {
                    return TaskStatus.Status.DONE;
                }
            }
            return TaskStatus.Status.IN_PROGRESS;
        }
        return TAsk.status;
    }
}
