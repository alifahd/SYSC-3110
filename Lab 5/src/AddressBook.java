import java.util.*;
import javax.swing.*;

public class AddressBook extends DefaultListModel{
    private ArrayList<BuddyInfo> buddyInfoList;

    public AddressBook() {
        this.buddyInfoList = new ArrayList<BuddyInfo>();
    }

    /**
     *
     * Adds BuddyInfo object to the Address Book
     *
     * @param b
     */
    public void addBuddy(BuddyInfo b) {
        buddyInfoList.add(b);
        super.addElement(b);
    }

    /**
     *
     * Removes BuddyInfo object from the Address Book
     *
     * @param description
     */
    public void removeBuddy(String description) {
        for(BuddyInfo buddy : this.buddyInfoList) {
            if(description.equals("["+buddy.toString()+"]")) {
                this.buddyInfoList.remove(buddy);
                super.removeElement(buddy);
            }
        }
    }

}
