public class TasksStatus {
    enum Status {
        NEW,
        IN_PROGRESS,
        DONE
    }

    public static Status[] getStatus() {
        return Status.values();
    }
}