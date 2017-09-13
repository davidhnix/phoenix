package com.nixsoft.suicideleague.jpa.team;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GenericGenerator(name = "nextUp", strategy = "increment")
    @GeneratedValue(generator = "nextUp")
    Integer id;
    String name;
    String location;

    /* GETTERS AND SETTERS */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

}
