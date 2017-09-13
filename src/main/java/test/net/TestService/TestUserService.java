package test.net.TestService;


import net.model.User;
import net.model.UserLoginDTO;
import net.service.UserService.UserServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.junit.Assert;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

    @InjectMocks
    private UserServiceImp userServiceImp = new UserServiceImp();


    private UserServiceImp userServiceImpMock = mock(UserServiceImp.class);

    @Test
        public void takeInfoTestWorkingStatus() {
            UserLoginDTO userLoginDTO = new UserLoginDTO();

            userLoginDTO.setUserLogin("login");
            userLoginDTO.setUserPassword("123");
            userLoginDTO.setUserEmail("123@gmail.com");

            User user = userServiceImp.takeInfo(userLoginDTO);

            User userMain = new User();
            userMain.setUserLogin("login");
            userMain.setUserPassword("123");
            userMain.setUserEmail("123@gmail.com");
            userMain.setUserStatus("checked");

            Assert.assertEquals(user.getUserLogin(),userMain.getUserLogin());
            Assert.assertEquals(user.getUserPassword(),userMain.getUserPassword());
            Assert.assertEquals(user.getUserEmail(),userMain.getUserEmail());
    }

    @Test
    public void takeInfoTestWorkingType() {
        UserLoginDTO userLoginDTO = new UserLoginDTO();

        userLoginDTO.setUserLogin("login");
        userLoginDTO.setUserPassword("123");
        userLoginDTO.setUserEmail("123@gmail.com");

        User user = userServiceImp.takeInfo(userLoginDTO);

        User userMain = new User();
        userMain.setUserLogin("login");
        userMain.setUserPassword("123");
        userMain.setUserEmail("123@gmail.com");


        when(userServiceImpMock.takeInfo(userLoginDTO)).thenReturn(user);
    }

    @Test
    public void emailValidationTest() {
        User user = new User();
        int i = 0;
        when(userServiceImpMock.generateCode(user)).thenReturn(i);
    }

    @Test
    public void setContextTest() {
        User user1 = new User();
        User user2 = new User();
        user2.setUserStatus("checked");

        User user = userServiceImp.setContext(user1);

        Assert.assertEquals(user.getUserStatus(),user2.getUserStatus());

        when(userServiceImpMock.setContext(user)).thenReturn(user);

    }

    @Test(expected = NullPointerException.class)
    public void setContextTestNull() {
        userServiceImp.setContext(null);
    }

}
