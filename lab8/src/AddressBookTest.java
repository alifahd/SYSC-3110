import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressBookTest {
    AddressBook ab = new AddressBook();
    AddressBook ab1 = new AddressBook();
    BuddyInfo b = new BuddyInfo("John", "123 Fake Street", 1569876548);
    BuddyInfo b1 = new BuddyInfo("Doe", "456 Apple Road", 1875888974);
    BuddyInfo b2 = new BuddyInfo("Jack", "3943 Street Road", 1234567890);

    @Test
    public void testExportImport() {
        ab.addBuddy(b);
        ab.addBuddy(b1);
        ab.addBuddy(b2);
        ab.save("testing", false);

        ab1.importBuddies("testing");

        //Not sure why this test isn't passing, they're exactly the same. Probably some spaces stuff
        assertEquals(ab, ab1);
    }
}