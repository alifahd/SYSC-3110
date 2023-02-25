public class BuddyInfo {
    private String name;
    private String address;
    private int tele;
    public static void main(String[] args) {
        BuddyInfo buddyInfo = new BuddyInfo();
        System.out.println("Hello World!");
        System.out.println(buddyInfo.getName());
    }

    public String getName() {
        return name;
    }
}
