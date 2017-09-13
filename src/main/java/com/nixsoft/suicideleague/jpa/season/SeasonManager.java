package com.nixsoft.suicideleague.jpa.season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeasonManager {

    @Autowired
    SeasonRepo seasonRepo;

    public List<Season> seasons(){
        return seasonRepo.findAll();
    }
}
