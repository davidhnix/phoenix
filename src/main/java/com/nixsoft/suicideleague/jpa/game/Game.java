package com.nixsoft.suicideleague.jpa.game;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GenericGenerator(name = "nextUp", strategy = "increment")
    @GeneratedValue(generator = "nextUp")
    Integer id;

    @OneToOne
    @JoinColumn(name = "HOME_PARTICIPANT_ID", referencedColumnName = "id")
    GameParticipant home;

    @OneToOne
    @JoinColumn(name = "AWAY_PARTICIPANT_ID", referencedColumnName = "id")
    GameParticipant away;


    /* GETTERS AND SETTERS */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public GameParticipant getHome() {
        return home;
    }
    public void setHome(GameParticipant home) {
        this.home = home;
    }

    public GameParticipant getAway() {
        return away;
    }
    public void setAway(GameParticipant away) {
        this.away = away;
    }
}
