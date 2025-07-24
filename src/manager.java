import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class manager {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Task> Tasks = new ArrayList<>();
    static int Id = 0;

    public static void menu() {
        System.out.println("1. Получение списка всех задач.");
        System.out.println("2. Получение сведений задачи по ид.");
        System.out.println("3. Создать задачу или подзадачу.");
        System.out.println("4. удаление всех задач");
        System.out.println("5. Удаление по ид.");
        System.out.println("6. Обновить статус.");
    }

    public static void commands(int command) {
        if (command == 1) {
            int schet = 1;

            for (TaskStatus.Status status : TaskStatus.getStatus()) {
                System.out.println("Задачи со статусом " + status + ":\n");
                for (Task task : Tasks) {
                    task.status = task.calculateStatus(task);
                    if (task.status == status) {
                        System.out.println("Задача номер: " + schet);
                        schet += 1;
                        System.out.println("Название: " + task.name);
                        System.out.println("Описание: " + task.description);
                        System.out.println("Id: " + task.id);

                        System.out.println("Статус: " + task.status);

                        System.out.println("Подзадачи: ");
                        System.out.println();

                        int schet1 = 1;

                        if (task.subtasks != null) {
                            for (SubTask subTask : task.subtasks) {
                                System.out.println("Подзадача " + schet1 + ": " + subTask.name);
                                System.out.println("Описание: " + subTask.description);
                                System.out.println("id: " + subTask.taskId);
                                System.out.println("Является подзадачей задачи с id: " + subTask.id);
                                System.out.println("Статус: " + subTask.status);
                                System.out.println();
                                schet1 += 1;
                            }
                        } else {
                            System.out.println("Отсутствуют");
                            System.out.println();
                        }
                        System.out.println();
                    }
                }
            }
        } else if (command == 2) {
            System.out.println("Введите id: ");
            int id = scanner.nextInt();

            for (Task task : Tasks) {
                if (task.id == id) {
                    System.out.println("Задача c id " + id);
                    System.out.println("Название: " + task.name);
                    System.out.println("Описание: " + task.description);
                    System.out.println("id: " + task.id);

                    task.status = task.calculateStatus(task);
                    System.out.println("Статус: " + task.status + "\n");

                    if (task.subtasks != null) {
                        int schet = 0;

                        for (SubTask subtask : task.subtasks) {
                            schet += 1;
                            System.out.println("Подзадача " + schet);
                            System.out.println("Название подзадачи: " + subtask.name);
                            System.out.println("Описание: " + subtask.description);
                            System.out.println("id: " + subtask.taskId);
                            System.out.println("Является подзадачей задачи с id: " + subtask.id);
                            System.out.println("Статус: " + subtask.status);
                            System.out.println();
                        }
                    }
                    System.out.println();
                    return;
                }
            }

            for (Task task : Tasks) {
                for (SubTask subTask : task.subtasks) {
                    if (subTask.taskId == id) {
                        System.out.println("Подзадача: " + subTask.name);
                        System.out.println("Описание: " + subTask.description);
                        System.out.println("id: " + subTask.taskId);
                        System.out.println("Является подзадачей задачи с id: " + subTask.id);
                        System.out.println("Статус: " + subTask.status);
                        System.out.println();
                    }
                }

            }
        } else if (command == 3) {
            System.out.println("1. Задачу");
            System.out.println("2. Если подзадачу, ввести id");

            int VC = scanner.nextInt();

            if (VC == 1) {
                System.out.println("Введите название:");
                String n = scanner.nextLine();
                String n1 = scanner.nextLine();
                System.out.println("Введите описание:");
                String n2 = scanner.nextLine();
                Id += 1;
                Tasks.add(new Task(Id, n1, n2));

            } else if (VC == 2) {
                System.out.println("Введите id");
                int id = scanner.nextInt();

                for (Task task : Tasks) {
                    if (task.id == id) {
                        String n = scanner.nextLine();

                        System.out.println("Введите название:");
                        String n1 = scanner.nextLine();

                        System.out.println("Введите описание:");
                        String n2 = scanner.nextLine();

                        ArrayList<SubTask> List = task.subtasks;
                        Id += 1;
                        List.add(new SubTask(id, Id, n1, n2));
                    }
                }
            }
        } else if (command == 4) {
            Tasks = new ArrayList<>();

        } else if (command == 5) {

            System.out.println("Задачу с каким ид удалить: ");
            int del = scanner.nextInt();

            for (Task task : Tasks) {
                if (task.id == del) {
                    Tasks.remove(task);
                    return;
                }
                for (SubTask subTask : task.subtasks) {
                    if (subTask.taskId == del) {
                        System.out.println(subTask.name);
                        task.subtasks.remove(subTask);
                        return;
                    }
                }
            }
        }  else if (command == 6) {
            System.out.println("У задачи с каким id сменить статус: ");
            int ids = scanner.nextInt();

            System.out.println("На какой статус сменить: \n1. NEW\n2. IN_PROGRESS\n3. DONE");
            int stat = scanner.nextInt();
            TaskStatus.Status tStatus = null;

            if (stat == 1) {
                tStatus = TaskStatus.Status.NEW;
            } else if (stat == 2) {
                tStatus = TaskStatus.Status.IN_PROGRESS;
            } else if (stat == 3) {
                tStatus = TaskStatus.Status.DONE;
            } else {
                return;
            }

            for (Task task : Tasks) {
                if (task.id == ids) {
                    ArrayList<SubTask> taskSubtask = task.subtasks;
                    // Tasks.add(new Task(task.id, task.name, task.description, tStatus, taskSubtask));
                    Tasks.set(Tasks.indexOf(task), new Task(task.id, task.name, task.description, tStatus, taskSubtask));
                    // Tasks.remove(task);
                    return;
                }
                for (SubTask subTask : task.subtasks) {
                    if (subTask.taskId == ids) {
                        System.out.println(subTask.name);
                        subTask.status = tStatus;

                        task.subtasks.set(task.subtasks.indexOf(subTask), new SubTask(subTask.id, subTask.taskId,
                                subTask.name, subTask.description,
                                tStatus));

                        return;
                    }
                }
            }
        }
    }
}
