package com.example.demo;

import com.example.demo.controller.PhoneNumberController;
import com.example.demo.service.ModifyNumberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class PhoneNumberControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    PhoneNumberController phoneNumberController;

    @MockBean
    ModifyNumberService modifyNumberService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(phoneNumberController).build();
    }

    @Test
    public  void  testPhonenumber() throws Exception {
        this.mockMvc.perform(get("/modify/0123456789")
                .contentType("application/json"))
                .andExpect(status().isOk());

    }
}
