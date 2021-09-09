package com.codecool.thecodecooltimesbackend.controller;

import com.codecool.thecodecooltimesbackend.dao.namedayDAO.NameDayDAO;
import com.codecool.thecodecooltimesbackend.service.NameDayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NamedayControllerTest {

    @Autowired
    private NameDayService nameDayService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(nameDayService).isNotNull();
    }

}