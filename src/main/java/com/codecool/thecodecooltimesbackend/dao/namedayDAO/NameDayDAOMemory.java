package com.codecool.thecodecooltimesbackend.dao.namedayDAO;

import com.codecool.thecodecooltimesbackend.model.nameday.NameDayResult;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("nameDayMemory")
public class NameDayDAOMemory implements NameDayDAO {

    private final ApiRequester apiRequester;

    @Autowired
    public NameDayDAOMemory(ApiRequester apiRequester) {
        this.apiRequester = apiRequester;
    }

    private static final String NAMEDAY_API = "https://nameday.abalin.net/today";

    @Override
    public NameDayResult getTodaysNameDay() {
        return apiRequester.fetchDataPost(NAMEDAY_API, NameDayResult.class);
    }
}
