package com.nixsoft.suicideleague.jpa.game;

import com.nixsoft.suicideleague.jpa.team.Team;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class GameParticipant {

    @Id
    @GenericGenerator(name = "nextUp", strategy = "increment")
    @GeneratedValue(generator = "nextUp")
    Integer id;
    Integer score;

    @OneToOne
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "id")
    Team team;

    /* GETTERS AND SETTERS */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }

    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
}
