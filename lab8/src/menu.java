import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame implements ActionListener {

    // menubar 
    static JMenuBar mb;

    // JMenu 
    static JMenu x;

    // Menu items 
    static JMenuItem m1, m2, m3, m4, m5, m6;

    // create a frame 
    static JFrame f;

    // a label 
    static JLabel l;

    // a list
    static JList b;

    public menu(){
        AddressBook addressBook = new AddressBook();

        // create a frame
        f = new JFrame("Address Book");

        // create a menubar
        mb = new JMenuBar();

        // create a menu
        x = new JMenu("Menu");

        b = new JList(addressBook);


        // create menuitems
        m1 = new JMenuItem("Add a Buddy");
        m2 = new JMenuItem("Remove a Buddy");
        m3 = new JMenuItem("New Address Book");
        m4 = new JMenuItem("Display");
        m5 = new JMenuItem("Save");
        m6 = new JMenuItem("Import Buddies");

        // add ActionListener to menuItems
        m1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField name = new JTextField(8);
                JTextField address = new JTextField(8);
                JTextField tele = new JTextField(8);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(name);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("Address:"));
                myPanel.add(address);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("Telephone:"));
                myPanel.add(tele);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "Please Enter Buddy Info Values", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try{
                        Integer.parseInt(tele.getText());
                        BuddyInfo b = new BuddyInfo(name.getText(), address.getText(), Integer.parseInt(tele.getText()));
                        addressBook.addBuddy(b);
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Telephone needs to be made up of only numbers");
                    }
                }
            }
        });
        m2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Are you sure you want to remove this buddy?:"));

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "Remove Buddy from Address Book", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    addressBook.removeBuddy(b.getSelectedValuesList().toString());
                }
            }
        });
        m3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new menu();
            }
        });
        m4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(b.isVisible()){
                    b.setVisible(false);
                }else{
                    b.setVisible(true);
                }
            }
        });
        m5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField fileName = new JTextField(8);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("File Name:"));
                myPanel.add(fileName);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "Please enter name of file: ", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try{
                        addressBook.save(fileName.getText(), false);
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Didn't save properly");
                    }
                }

            }
        });
        m6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField fileName = new JTextField(8);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("File Name:"));
                myPanel.add(fileName);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "Please enter name of file: ", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try{
                        addressBook.importBuddies(fileName.getText());
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Didn't import properly");
                    }
                }

            }
        });


        // add menu items to menu
        x.add(m1);
        x.add(m6);
        x.add(m2);
        x.add(m3);
        x.add(m4);
        x.add(m5);

        // add menu to menu bar
        mb.add(x);

        // add menubar to frame
        f.setJMenuBar(mb);

        //add list to frame
        f.add(b);

        // set the size of the frame
        f.setSize(500, 500);
        f.setVisible(true);
    }

    /**
     *
     * @param args
     */
    // main class 
    public static void main(String[] args)
    {
        new menu();
    }

    /**
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {}
} 