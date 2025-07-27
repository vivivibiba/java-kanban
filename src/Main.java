import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Получение списка всех задач.");
            System.out.println("2. Получение сведений задачи по id.");
            System.out.println("3. Создать задачу или подзадачу.");
            System.out.println("4. удаление всех задач.");
            System.out.println("5. Удаление по id.");
            System.out.println("6. Обновить статус.");

            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println(Manager.TasksSubtasks);
                for (TasksStatus.Status status : TasksStatus.getStatus()) {
                    System.out.println("Задачи со статусом " + status + ":");
                    for (Task object : Manager.showTasks().values()) {
                        if (object.getClass() == Epic.class) {
                            object.status = Epic.calculateStatus((Epic) object);
                        }
                        if (object.status == status) {
                            System.out.println(object);
                            System.out.println("------------");
                        }
                    }
                    System.out.println();
                }
            } else if (command == 2) {
                System.out.println("id");
                int id = scanner.nextInt();
                System.out.println(Manager.showTasksId(id));

            } else if (command == 3) {
                System.out.println("1. Задачу");
                System.out.println("2. Подзадачу");
                int TaskOrSubtask = scanner.nextInt();

                String n = scanner.nextLine();
                System.out.println("Введите название: ");
                String name = scanner.nextLine();

                System.out.println("Введите описание: ");
                String description = scanner.nextLine();

                if (TaskOrSubtask == 1) {
                    Manager.createTask(name, description);
                } else if (TaskOrSubtask == 2) {
                    System.out.println("id: ");
                    int id = scanner.nextInt();
                    Manager.createSubTask(id, name, description);
                }

            } else if (command == 4) {
                Manager.Tasks.clear();
                Manager.TasksSubtasks.clear();

            } else if (command == 5) {
                System.out.println("id: ");
                int delId = scanner.nextInt();
                Manager.delSubTask(delId);

            } else if (command == 6) {
                System.out.println("У задачи с каким id сменить статус: ");
                int id = scanner.nextInt();

                System.out.println("На какой статус сменить: \n1. NEW\n2. IN_PROGRESS\n3. DONE");
                int stat = scanner.nextInt();
                TasksStatus.Status Status = null;

                if (stat == 1) {
                    Status = TasksStatus.Status.NEW;
                } else if (stat == 2) {
                    Status = TasksStatus.Status.IN_PROGRESS;
                } else if (stat == 3) {
                    Status = TasksStatus.Status.DONE;
                } else {
                    return;
                }
                Manager.status(id, Status);
            }
        }
    }
}