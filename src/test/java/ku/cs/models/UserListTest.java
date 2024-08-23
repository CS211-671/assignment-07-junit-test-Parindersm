package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("Seiya", "Seiya01");
        userList.addUser("Oat", "Oat02");
        userList.addUser("Shoyu", "Shoyu03");


        // TODO: find one of them
        User findUser = userList.findUserByUsername("Shoyu");

        // TODO: assert that UserList found User
        assertNotNull(findUser);
        assertEquals("Shoyu", findUser.getUsername());
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // เพิ่มผู้ใช้ 3 คน
        UserList userList = new UserList();
        userList.addUser("Seiya", "Seiya01");
        userList.addUser("Oat", "Oat02");
        userList.addUser("Shoyu", "Shoyu03");

        // เปลี่ยนรหัสผ่าน
        boolean passwordChanged = userList.changePassword("Shoyu", "Shoyu03", "NewShoyu");
        assertTrue(passwordChanged);

        // ตรวจสอบการเข้าสู่ระบบด้วยรหัสผ่านใหม่
        User loggedUser = userList.login("Shoyu", "NewShoyu");
        assertNotNull(loggedUser);
        assertEquals("Shoyu", loggedUser.getUsername());
    }


    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("Seiya", "Seiya01");
        userList.addUser("Oat", "Oat02");
        userList.addUser("Shoyu", "Shoyu03");

        // TODO: call login() with correct username and password
        User loggedInUser = userList.login("Seiya", "Seiya01");


        // TODO: assert that User object is found
        assertNotNull(loggedInUser);
        assertEquals("Seiya", loggedInUser.getUsername());
        // assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("Seiya", "Seiya01");
        userList.addUser("Oat", "Oat02");
        userList.addUser("Shoyu", "Shoyu03");

        // TODO: call login() with incorrect username or incorrect password
        User loggedInUser = userList.login("Seiya", "WrongPassword");

        // TODO: assert that the method return null
        assertNull(loggedInUser);
        // assertNull(actual);
    }

}