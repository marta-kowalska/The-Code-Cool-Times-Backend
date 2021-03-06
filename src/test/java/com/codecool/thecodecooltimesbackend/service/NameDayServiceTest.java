package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.controller.NamedayController;
import com.codecool.thecodecooltimesbackend.dao.namedayDAO.NameDayDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NameDayServiceTest {

    @Autowired
    private NameDayDAO namedayDAO;

    @Test
    public void contextLoads() throws Exception {
        assertThat(namedayDAO).isNotNull();
    }

}