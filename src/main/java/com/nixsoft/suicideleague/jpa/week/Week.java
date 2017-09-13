package com.nixsoft.suicideleague.jpa.week;

import com.nixsoft.suicideleague.jpa.game.Game;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Week {

    @Id
    @GenericGenerator(name = "nextUp", strategy = "increment")
    @GeneratedValue(generator = "nextUp")
    Integer id;
    Integer weekNumber;

    @OneToMany
    @JoinColumn(name="WEEK_ID", referencedColumnName = "id")
    List<Game> games;


    /* GETTERS AND SETTERS */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }
    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public List<Game> getGames() {
        return games;
    }
    public void setGames(List<Game> games) {
        this.games = games;
    }
}
