package com.codecool.thecodecooltimesbackend.dao.namedayDAO;

import com.codecool.thecodecooltimesbackend.service.QuoteService;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class NameDayDAOMemoryTest {

    @Autowired
    private ApiRequester apiRequester;

    @Test
    public void contextLoads() throws Exception {
        assertThat(apiRequester).isNotNull();
    }

}