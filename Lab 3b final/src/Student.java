import java.util.Date;

public class Student implements ProfListener {
    private String name;
    private Date midterm;
    private Prof prof;

    public Student(String aName) { this.name = aName; }

    public String getName() { return this.name; }

    public void study(ProfEvent profEvent){
        this.midterm = profEvent.getMidtermDate();
        this.prof = profEvent.getProfName();
        System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm + " for Prof. "+ this.prof);
    }

    public void party(ProfEvent profEvent){
        this.midterm = profEvent.getMidtermDate();
        this.prof = profEvent.getProfName();
        System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm + " for Prof. "+ this.prof);
    }

    @Override
    public void handleMidtermDateSet(ProfEvent profEvent){
        study(profEvent);
    }
    @Override
    public void handleMidtermPostponed(ProfEvent profEvent){
        party(profEvent);
    }

    /*@Override
    public void handleAssignmentPosted(ProfEvent ce){
        Object source = ce.getSource();
        Prof p;
        if (source instanceof Prof) {
            p = (Prof) source;
            System.out.println(p.getName());
        }
    }*/
}