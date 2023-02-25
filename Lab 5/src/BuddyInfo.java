public class BuddyInfo {
    private String name;
    private String address;
    private int tele;

    public BuddyInfo (String name, String address, int tele){
        this.name = name;
        this.address = address;
        this.tele = tele;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getTele() {
        return tele;
    }

    public String toString() {
        return "Buddy Info:           Name: " + name + "           Address: " + address + "           Tele: " + tele;
    }
}
