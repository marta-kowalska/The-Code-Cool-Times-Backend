package com.codecool.thecodecooltimesbackend.dao.namedayDAO;

import com.codecool.thecodecooltimesbackend.model.nameday.NameDayResult;
import com.codecool.thecodecooltimesbackend.util.ApiRequester;
import org.springframework.stereotype.Repository;

@Repository("nameDayMemory")
public class NameDayDAOMemory implements NameDayDAO {

    private static final String NAMEDAY_API = "https://nameday.abalin.net/today";

    @Override
    public NameDayResult getTodaysNameDay() {
        return ApiRequester.fetchDataPost(NAMEDAY_API, NameDayResult.class);
    }
}
