import java.util.Date;
import java.util.EventObject;

public class ProfEvent extends EventObject {
    private Date midtermDate, assignmentDeadline;
    private String assignmentText;
    private Prof prof;

    public ProfEvent(Prof p, Date midtermDate) {
        super(p);
        this.prof = p;
        this.midtermDate= midtermDate;
    }

    public ProfEvent(Object source, String text, Date assignmentDeadline) {
        super(source);
        this.assignmentText = text;
        this.assignmentDeadline = assignmentDeadline;
    }

    public Date getMidtermDate(){
        return midtermDate;
    }

    public Prof getProfName(){ return prof; }

    public Date getAssignmentDeadline(){
        return assignmentDeadline;
    }

    public String getAssignmentText(){
        return assignmentText;
    }
}
