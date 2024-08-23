package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @Test
    void testIsUsername() {
        User user = new User("Seiya");
        assertTrue(user.isUsername("Seiya"));
        assertFalse(user.isUsername(""));
    }

    @Test
    void testSetPassword() {
        User user = new User("Seiya");
        user.setPassword("plain-p@ssw0rd");
        assertNotNull(user.getPassword());
        assertNotEquals("plain-p@ssw0rd", user.getPassword());
    }

    @Test
    void testValidatePassword() {
        User user = new User("Seiya", "plain-p@ssw0rd");
        assertTrue(user.validatePassword("plain-p@ssw0rd"));
        assertFalse(user.validatePassword(""));
    }

    @Test
    void testCreateUserWithPassword() {
        User user = new User("Seiya", "plain-p@ssw0rd");
        assertNotNull(user.getPassword());
        assertTrue(user.validatePassword("plain-p@ssw0rd"));
    }
}