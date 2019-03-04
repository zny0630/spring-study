package com.spring.IoC.di;

import com.spring.login.UserLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
/**
 * Created by Nan on 2019/3/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
public class UserLoginTest {
    @Autowired
    private UserLogin userLogin;

    @Test
    public void userLogin() throws Exception {
       assertEquals(false,userLogin.userLogin(userLogin.getUser()));
    }
}
