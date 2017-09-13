package com.nixsoft.suicideleague.jpa.season;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class SeasonManagerTest {

    @Autowired
    SeasonManager seasonManager;

    @Test
    @Transactional
    public void seasons() throws Exception {

        List<Season> seasons = seasonManager.seasons();
        assertEquals(1, seasons.size());
        assertEquals(5, seasons.get(0).getWeeks().size());

        // WEEK1
        assertEquals(2, seasons.get(0).getWeeks().get(0).getGames().size());
        //     GAME1
        assertEquals("Falcons", seasons.get(0).getWeeks().get(0).getGames().get(0).getHome().getTeam().getName());
        assertEquals(31, seasons.get(0).getWeeks().get(0).getGames().get(0).getHome().getScore().longValue());
        assertEquals("Bears", seasons.get(0).getWeeks().get(0).getGames().get(0).getAway().getTeam().getName());
        assertEquals(28, seasons.get(0).getWeeks().get(0).getGames().get(0).getAway().getScore().longValue());
        // GAME2
        assertEquals("Giants", seasons.get(0).getWeeks().get(0).getGames().get(1).getHome().getTeam().getName());
        assertEquals(3, seasons.get(0).getWeeks().get(0).getGames().get(1).getHome().getScore().longValue());
        assertEquals("Cowboys", seasons.get(0).getWeeks().get(0).getGames().get(1).getAway().getTeam().getName());
        assertEquals(27, seasons.get(0).getWeeks().get(0).getGames().get(1).getAway().getScore().longValue());


        // WEEK2
        assertEquals(2, seasons.get(0).getWeeks().get(1).getGames().size());
    }

}