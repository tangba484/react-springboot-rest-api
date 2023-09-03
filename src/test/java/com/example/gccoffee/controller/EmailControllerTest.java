package com.example.gccoffee.controller;


import com.example.gccoffee.model.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@AutoConfigureMockMvc
public class EmailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidEmail() throws Exception {
        Email validEmail = Email.builder().address("test123@example.com").build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/validateEmail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"address\":\"" + validEmail.getAddress() + "\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("유효한 이메일 주소입니다."));
    }

    @Test
    public void testInvalidEmail() throws Exception {
        Email invalidEmail = Email.builder().address("invalidemail").build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/validateEmail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"address\":\"" + invalidEmail.getAddress() + "\"}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()); // 예상되는 응답 상태는 "400 Bad Request"
    }

    @Test
    public void testEqualityEmail(){
        Email asd = Email.builder().address("asd").build();
        Email asd1 = Email.builder().address("asd").build();
        assertTrue(asd.equals(asd1));
    }

}
