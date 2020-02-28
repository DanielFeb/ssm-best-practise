package indi.daniel.archessm.domain.auth.model;

import indi.daniel.archessm.domain.auth.model.exception.UserNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserTest {
    @Test
    public void testCRUD() {
        User user = Users.create("daniel", "daniel123123");
        user.setNickname("Daniel");
        user.setSex(Sex.MALE);
        user.setAddress("Shanghai");
        user.setAge(18);
        Users.store(user);

        try {
            User fromDB = Users.get(user.id());
            assertNotNull(fromDB.traceInformation());
            assertNotNull(fromDB.traceInformation());
            assertTrue(user.sameIdentityAs(fromDB));
            assertEquals(user.nickname(), fromDB.nickname());
            assertEquals(user.sex(), fromDB.sex());
            assertEquals(user.birthDay(), fromDB.birthDay());
            assertEquals(user.address(), fromDB.address());
            assertEquals(18, fromDB.age());
        } catch (UserNotFoundException e) {
            Assert.fail();
        }
        user.setNickname("Daniel Xu");
        Users.store(user);

        try {
            User fromDB = Users.get(user.id());
            assertEquals(user.nickname(), fromDB.nickname());
        } catch (UserNotFoundException e) {
            Assert.fail();
        }

        try {
            Users.remove(user);
        } catch (UserNotFoundException e) {
            Assert.fail();
        }

        try {
            Users.get(user.id());
            Assert.fail();
        } catch (UserNotFoundException ignored) {
        }

    }

}
