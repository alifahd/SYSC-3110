import java.util.*;

public class Prof {
    private String name;
    private Date midtermDate;
    private List<ProfListener> profListeners;

    public Prof(String aName) {
        this.name = aName;
        this.profListeners = new ArrayList<>();
    }

    public Date getMidterm() { return this.midtermDate; }

    public String getName() { return this.name; }

    public void setMidterm(Date date) {
        this.midtermDate = date;
        for(ProfListener pl: profListeners) pl.handleMidtermDateSet(new ProfEvent(this, date));
    }

    public void postponeMidterm(Date date){
        this.midtermDate = date;
        for(ProfListener pl: profListeners) pl.handleMidtermPostponed(new ProfEvent(this, date));
    }

    /*public void postAssignment(String text, Date deadline){
        for(ProfListener pl: profListeners)
            pl.handleAssignmentPosted(new ProfEvent(source: this, text, deadline));
    }*/

    public void addProfListener(ProfListener pl){
        this.profListeners.add(pl);
    }

    public void removeProfListener(ProfListener pl){
        this.profListeners.remove(pl);
    }

    public static void main(String[] args) {

        Prof p = new Prof("Babak");
        Student s = new Student("Homer");
        Student s2 = new Student("Bart");
        TeachingAssistant ta = new TeachingAssistant("Michael");


        p.addProfListener(s);
        p.addProfListener(s2);
        p.addProfListener(ta);

        Date midterm = new Date();
        p.setMidterm(midterm);

        p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
    }

}