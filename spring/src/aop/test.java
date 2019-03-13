package aop;

import org.junit.Test;

public class test {

	@Test
    public void demo01(){
        UserService userService = MyBeanFactory.createService();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
