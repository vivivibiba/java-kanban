
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.createTask(new Task("Задача 1", "Задача номер 1"));
        manager.createTask(new Task("Задача 2", "Задача номер 2"));

        manager.createEpic(new Epic("Эпик 1", "Эпик номер 1"));
        manager.createEpic(new Epic("Эпик 2", "Эпик номер 2"));

        manager.createSubtask(3, new SubTask(3, "Подзадача 1", "Подзадача номер 1",
                TasksStatus.Status.NEW));
        manager.createSubtask(4, new SubTask(4, "Подзадача 2", "Подзадача номер 2",
                TasksStatus.Status.NEW));
        manager.createSubtask(4, new SubTask(4, "Подзадача 3", "Подзадача номер 3",
                TasksStatus.Status.NEW));

        System.out.println(manager.showTasks());
        System.out.println(manager.showEpics());
        System.out.println(manager.showSubtasks());
        System.out.println(manager.getSubtaskId(6));
        System.out.println("----------------------");

        manager.updateSubtask(5, new SubTask("Подзадача 1", "Подзадача номер 1",
                TasksStatus.Status.DONE));
        manager.updateSubtask(6, new SubTask("Подзадача 2", "Подзадача номер 2",
                TasksStatus.Status.DONE));

        System.out.println(manager.showEpics());
        System.out.println(manager.showEpicSubtasks(4));
        System.out.println(manager.getSubtaskId(6));
        System.out.println("----------------------");

        manager.delSubtask(7);

        System.out.println(manager.showEpics());
        System.out.println("----------------------");

        manager.delEpic(4);

        System.out.println(manager.showEpics());
        System.out.println(manager.showSubtasks());
        System.out.println("----------------------");

        manager.delEpics();

        System.out.println(manager.showEpics());
        System.out.println(manager.showSubtasks());
        System.out.println("----------------------");

        System.out.println(manager.showTasks());
        System.out.println("----------------------");

        manager.delTask(1);

        System.out.println(manager.showTasks());

        manager.delTasks();

        System.out.println(manager.showTasks());
    }
}