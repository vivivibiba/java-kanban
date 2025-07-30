import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private final HashMap<Integer, SubTask> subtasks = new HashMap<>();

    private int idTask = 0;

    public ArrayList<Task> showTasks() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<SubTask> showSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public ArrayList<Epic> showEpics() {
        return new ArrayList<>(epics.values());
    }

    public ArrayList<SubTask> showEpicSubtasks(int id) {
        return new ArrayList<SubTask>(epics.get(id).epicSubtasks);
    }


    public Task getTaskId(int id) {
        return tasks.get(id);
    }

    public SubTask getSubtaskId(int id) {
        return subtasks.get(id);
    }

    public Epic getEpicId(int id) {
        return epics.get(id);
    }


    public void updateTask(Task task) {
        tasks.put(task.id, task);
    }

    public void updateSubtask(SubTask subTask) {
        subTask.id = subtasks.get(subTask.taskId).id;
        epics.get(subTask.id).epicSubtasks.set(epics.get(subTask.id).epicSubtasks.indexOf(subtasks.get(subTask.taskId)),
                subTask);
        subtasks.put(subTask.taskId, subTask);
        epics.get(subTask.id).status = Epic.calculateStatus(epics.get(subTask.id));
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.id, epic);
    }


    public void createTask(Task task) {
        idTask += 1;
        task.id = idTask;
        tasks.put(idTask, task);
    }

    public void createSubtask(int id, SubTask subTask) {
        idTask += 1;

        subTask.taskId = idTask;
        subtasks.put(idTask, subTask);

        epics.get(id).epicSubtasks.add(subTask);
        epics.get(id).status = Epic.calculateStatus(epics.get(id));
    }

    public void createEpic(Epic epic) {
        idTask += 1;
        epic.id = idTask;
        epics.put(idTask, epic);
    }


    public void delTask(int id) {
        tasks.remove(id);
    }

    public void delSubtask(int idSub) {
        epics.get(subtasks.get(idSub).id).epicSubtasks.remove(subtasks.get(idSub));
        epics.get(subtasks.get(idSub).id).status = Epic.calculateStatus(epics.get(subtasks.get(idSub).id));
        subtasks.remove(idSub);
    }

    public void delEpic(int id) {
        for (SubTask subTask : epics.get(id).epicSubtasks) {
            subtasks.values().remove(subTask);
        }
        epics.remove(id);
    }


    public void delTasks() {
        tasks.clear();
    }

    public void delSubtasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.epicSubtasks.clear();
            epic.status = Epic.calculateStatus(epic);
        }
    }

    public void delEpics() {
        epics.clear();
        subtasks.clear();
    }
}