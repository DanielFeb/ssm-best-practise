package indi.daniel.archessm;

import indi.daniel.archessm.domain.model.user.Sex;
import indi.daniel.archessm.domain.model.user.User;
import indi.daniel.archessm.domain.model.user.UserRepository;
import indi.daniel.archessm.domain.model.user.exception.UserNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCRUD() {
        User user = new User(userRepository.getNextId(),
                "Daniel",
                Sex.MALE,
                "Shanghai",
                18);
        userRepository.store(user);

        try {
            User fromDB = userRepository.get(user.id());
            assertNotNull(fromDB.traceInformation());
            assertNotNull(fromDB.traceInformation());
            assertTrue(user.sameIdentityAs(fromDB));
            assertEquals(user.name(), fromDB.name());
            assertEquals(user.sex(), fromDB.sex());
            assertEquals(user.birthDay(), fromDB.birthDay());
            assertEquals(user.address(), fromDB.address());
            assertEquals(18, fromDB.age());
        } catch (UserNotFoundException e) {
            Assert.fail();
        }
        user.changeName("Daniel Xu");
        userRepository.store(user);

        try {
            User fromDB = userRepository.get(user.id());
            assertEquals(user.name(), fromDB.name());
        } catch (UserNotFoundException e) {
            Assert.fail();
        }

        try {
            userRepository.remove(user);
        } catch (UserNotFoundException e) {
            Assert.fail();
        }

        try {
            userRepository.get(user.id());
            Assert.fail();
        } catch (UserNotFoundException ignored) {
        }

    }

}
