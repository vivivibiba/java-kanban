public class TaskStatus {
    enum Status {
        NEW,
        IN_PROGRESS,
        DONE
    }
    
    public static Status[] getStatus() {
        return Status.values();
    }
}
