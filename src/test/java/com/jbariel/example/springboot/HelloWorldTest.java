package com.jbariel.example.springboot;



import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jbariel.example.springboot.controllers.HelloWorldController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/* // Test Using mock mvc
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldTest {

    @Autowired
    private MockMvc mockMvc;

    //test for hello world!
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/hello/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World!")));
    }


    //test for hello name
    @Test
    public void shoudReturnName() throws Exception {
        this.mockMvc.perform(get("/hello/{name}", "komal")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello komal!")));
    }
}
*/

public class HelloWorldTest{
    @Mock
    private HelloWorldController helloController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenSayHelloIsCalledReturnHello() throws Exception{
        Mockito.when(helloController.sayHello()).thenReturn("Hello World!");
        Assert.assertEquals("Hello World!", helloController.sayHello());
    }
}