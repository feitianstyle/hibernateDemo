package com.feitian.pojo;

import com.feitian.service.UserService;
import org.junit.Test;



/**
 * @Author: feitian
 * @Date: 2018-04-16  16:12
 * @description:
 */
public class UserTest {
    @Test
    public void testSave(){
        User user = new User();
        user.setSex("femal");
        user.setName("王钢铁");
        new UserService().addUser(user);

    }

}