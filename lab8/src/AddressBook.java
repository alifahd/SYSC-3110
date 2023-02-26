import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook extends DefaultListModel {
    private ArrayList<BuddyInfo> buddyInfoList;

    public AddressBook() {
        this.buddyInfoList = new ArrayList<>();
    }

    /**
     * Adds BuddyInfo object to the Address Book
     *
     * @param b
     */
    public void addBuddy(BuddyInfo b) {
        buddyInfoList.add(b);
        super.addElement(b);
    }

    /**
     * Removes BuddyInfo object from the Address Book
     *
     * @param description
     */
    public void removeBuddy(String description) {
        for (BuddyInfo buddy : this.buddyInfoList) {
            if (description.equals("[" + buddy.toString() + "]")) {
                this.buddyInfoList.remove(buddy);
                super.removeElement(buddy);
            }
        }
    }

    public ArrayList<BuddyInfo> getBuddies() {
        return buddyInfoList;
    }


    public void importBuddies(String filename) {
        filename += ".txt";
        try {
            FileInputStream fis = new FileInputStream(filename);
            Scanner lineScanner = new Scanner(fis);
            while (lineScanner.hasNextLine()) {
                String[] vals = lineScanner.nextLine().split("#");
                BuddyInfo b = new BuddyInfo(vals[0], vals[1], Integer.parseInt(vals[2]));
                buddyInfoList.add(b);
                super.addElement(b);
            }
            lineScanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void save(String filename, Boolean xml) {
        filename += ".txt";
        try {
            File myObj = new File(filename);
            if (!myObj.createNewFile()) {
                myObj.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (BuddyInfo b : buddyInfoList) {
                if (xml) {
                    exportToXmlFile(writer);
                } else {
                    writer.write(b.toString());
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String toXML() {
        String buddiesXML = "";
        for (BuddyInfo b : buddyInfoList) {
            buddiesXML += b.toXML();
        }
        return "<AddressBook>\n" + buddiesXML + "</AddressBook>";
    }

    public void exportToXmlFile(BufferedWriter writer) {
        try {
            writer.write(toXML());
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void importFromXmlFile(String argv[]) {
    }
}