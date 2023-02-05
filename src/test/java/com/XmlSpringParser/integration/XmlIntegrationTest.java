package com.XmlSpringParser.integration;

import com.XmlSpringParser.XmlSpringParserApplication;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {XmlSpringParserApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class XmlIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void should_return_users() throws Exception {
        final var file = new MockMultipartFile("file", "users.xml",
                MediaType.TEXT_PLAIN_VALUE,
                this.getClass().getClassLoader().getResourceAsStream("user/users.xml"));

        mockMvc.perform(multipart("/upload").file(file))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Kalle Anka"))
                .andExpect(jsonPath("$[0].email").value("donald@email.dt"))
                .andExpect(jsonPath("$[0].username").value("donaldd"))
                .andExpect(jsonPath("$[1].name").value("Joakim von Anka"))
                .andExpect(jsonPath("$[1].email").value("scrooge@email.dt"))
                .andExpect(jsonPath("$[1].username").value("onkelscrooge"))
                .andExpect(jsonPath("$[2].name").value("Arne Anka"))
                .andExpect(jsonPath("$[2].email").value("arne@email.com"))
                .andExpect(jsonPath("$[2].username").value("arneanka"));
    }

    @Test
    void should_return_error_when_input_is_csv() throws Exception {
        final var file = new MockMultipartFile("file", "users.csv",
                MediaType.TEXT_PLAIN_VALUE,
                this.getClass().getClassLoader().getResourceAsStream("user/users.csv"));

        mockMvc.perform(multipart("/upload").file(file))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").value("Could not upload the file! You need to parse XML File."));
    }
}