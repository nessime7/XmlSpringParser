package com.XmlSpringParser.integration;

import XmlSpringParser.XmlSpringParserApplication;
import XmlSpringParser.service.XmlService;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {XmlSpringParserApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class XmlIntegrationTest {

    private final XmlService xmlService = mock(XmlService.class);

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

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
    void should_return_error() throws Exception {
        final var file = new MockMultipartFile("file", "users.csv",
                MediaType.TEXT_PLAIN_VALUE,
                this.getClass().getClassLoader().getResourceAsStream("user/users.csv"));

        mockMvc.perform(multipart("/upload").file(file))
                .andExpect(status().isExpectationFailed())
                .andReturn().getResponse().equals("Could not upload the file: users.csv! You need to parse XML File.");
    }
}