package com.nixsoft.suicideleague.jpa.season;

import com.nixsoft.suicideleague.jpa.week.Week;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Season {

    @Id
    @GenericGenerator(name = "nextUp", strategy = "increment")
    @GeneratedValue(generator = "nextUp")
    Integer id;
    Integer startYear;

    @OneToMany
    @JoinColumn(name = "SEASON_ID", referencedColumnName = "id")
    List<Week> weeks;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartYear() {
        return startYear;
    }
    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public List<Week> getWeeks() {
        return weeks;
    }
    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }
}
