package com.codecool.thecodecooltimesbackend.service;

import com.codecool.thecodecooltimesbackend.dao.namedayDAO.NameDayDAO;
import com.codecool.thecodecooltimesbackend.model.nameday.NameDayResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NameDayService {

    private final NameDayDAO nameDayDAO;

    @Autowired
    public NameDayService(@Qualifier("nameDayMemory") NameDayDAO nameDayDAO) {
        this.nameDayDAO = nameDayDAO;
    }

    public NameDayResult getTodaysNamedays() {
        return nameDayDAO.getTodaysNameDay();
    }
}
