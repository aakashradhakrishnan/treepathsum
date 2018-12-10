package com.aakash.treepathsum.service;

import com.aakash.treepathsum.model.User;
import com.aakash.treepathsum.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTests {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Before
    public void init(){

    }

    @Test
    public void createValidUserTest(){
        String firstName = "aakash";
        String lastName = "radhakrishnan";
        String email = "aakash123@gmail.com";
        String password = "password";

        User user = User.builder().email(email).firstName(firstName).lastName(lastName).password(password).build();
        User sampleUser = mock(User.class);
        when(userRepository.save(user)).thenReturn(sampleUser);

        boolean testFlag = false;

        try{
            userService.registerUser(user);
            testFlag = true;
        } catch (Exception e){

        }

        assertTrue(testFlag);

    }
}
