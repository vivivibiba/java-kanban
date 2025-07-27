import java.util.HashMap;

public class Manager {

    static HashMap<Integer, Task> Tasks = new HashMap<>();
    static HashMap<Integer, Integer> TasksSubtasks = new HashMap<>();
    static int Id = 0;

    public static HashMap<Integer, Task>  showTasks() {
        return Tasks;
    }

    public static Object showTasksId(int id) {
        if (TasksSubtasks.containsKey(id)) {
            return ((Epic) Tasks.get(TasksSubtasks.get(id))).subtasks.get(id);
        } else {
            return Tasks.get(id);
        }
    }

    public static void createTask(String name, String description) {    // создание Задачи
        Id += 1;
        Tasks.put(Id, new Task(Id, name, description));
    }

    public static void createSubTask(int id, String name, String description) { // добавление Подзадач
        if (Tasks.containsKey(id)) {
            Id += 1;
            if (Manager.Tasks.get(id).getClass() == Epic.class) {   // добавление Подзадач в Эпик
                HashMap<Integer, SubTask> sub;
                sub = ((Epic) Tasks.get(id)).subtasks;                          //  ! ((Epic) Tasks.get(id)).subtasks !
                sub.put(Id, new SubTask(id, Id, name, description));
                Tasks.put(id, new Epic(Manager.Tasks.get(id), sub));
            } else {
                HashMap<Integer, SubTask> sub = new HashMap<>();     // добавление Подзадач в Задачу
                sub.put(Id, new SubTask(id, Id, name, description));
                Tasks.put(id, new Epic(Manager.Tasks.get(id), sub));
            }
            TasksSubtasks.put(Id, id);
        }
    }

    public static void delSubTask(int id) {  // удаление по id
        if (TasksSubtasks.containsKey(id)) {    // удаление Подзадачи
            if (Tasks.get(TasksSubtasks.get(id)) != null) {
                if (((Epic) Tasks.get(TasksSubtasks.get(id))).subtasks.size() > 1) {
                    HashMap<Integer, SubTask> sub = new HashMap<>();
                    sub = ((Epic) Tasks.get(TasksSubtasks.get(id))).subtasks;       //  ! ((Epic) Tasks.get(id)).subtasks !
                    sub.remove(id);
                    Tasks.replace(Tasks.get(TasksSubtasks.get(id)).id, new Epic((Epic) Tasks.get(TasksSubtasks.get(id)),
                            sub));
                } else {
                    Tasks.replace(Tasks.get(TasksSubtasks.get(id)).id, new Task((Epic) Tasks.get(TasksSubtasks.get(id))));
                }
                TasksSubtasks.remove(id);
            }
        } else {    // удалить Задачу с Подзадачами
            if (Tasks.containsKey(id)) {
                for (SubTask subTask : ((Epic) Tasks.get(id)).subtasks.values()) {
                    TasksSubtasks.remove(subTask.taskId);
                }
                Tasks.remove(id);
            }
        }
    }

    public static void status(int id, TasksStatus.Status status) {
        if (TasksSubtasks.containsKey(id)) {
            ((Epic) Tasks.get(TasksSubtasks.get(id))).subtasks.get(id).status = status;
        } else {
            if (Tasks.containsKey(id)) {
                if (Tasks.get(id).getClass() != Epic.class) {
                    Tasks.get(id).status = status;
                }
            }
        }
    }
}