package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.model.nameday.NameDayResult;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class NamedayControllerIntegrationTest {

    @MockBean
    private ApiRequester apiRequester;

    @Autowired
    private MockMvc mockMvc;

    private NameDayResult sampleNameDayResult = new NameDayResult("Edit");

    @Test
    public void integrationTest_visitingNameDayApi_shouldReturnWellFormedJSONResponse() throws Exception {
        when(apiRequester.fetchDataPost(any(), any())).thenReturn(sampleNameDayResult);

        this.mockMvc.perform(get("/nameday/v1/today"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect((jsonPath("$.todaysNameDays").value("Edit")));
    }
}