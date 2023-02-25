import java.util.Date;

public interface ProfListener {
    void handleMidtermDateSet(ProfEvent profEvent);
    void handleMidtermPostponed(ProfEvent profEvent);
    // void handleAssignmentPosted(CourseEvent ce);
}
