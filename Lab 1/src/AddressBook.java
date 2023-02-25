import java.util.ArrayList;

public class AddressBook {
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
    }

    /**
     *
     * Removes BuddyInfo object from the Address Book
     *
     * @param b
     */
    public void removeBuddy(BuddyInfo b) {
        for(BuddyInfo buddy : this.buddyInfoList) {
            if(buddy.equals(b)) {
                this.buddyInfoList.remove(buddy);
            }
        }
    }

    public void newMethod() {}

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        BuddyInfo buddy = new BuddyInfo();

        book.addBuddy(buddy);
        book.removeBuddy(buddy);

        System.out.println("Address Book:");
        //testing editing on website
    }
}
