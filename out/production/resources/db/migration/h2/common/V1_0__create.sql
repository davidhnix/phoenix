CREATE TABLE SEASON (
    id int PRIMARY KEY,
    start_year YEAR not null
);

CREATE TABLE WEEK (
    id int PRIMARY KEY,
    week_number int not null,
    season_id int not null,
    FOREIGN KEY (season_id) REFERENCES SEASON(id)
);

CREATE TABLE TEAM (
    id int PRIMARY KEY,
    name varchar(50) not null,
    location varchar(50) not null
);

CREATE TABLE GAME_PARTICIPANT (
    id int PRIMARY KEY,
    team_id int not null,
    score int not null,
    FOREIGN KEY (team_id) REFERENCES TEAM(id)
);

CREATE TABLE GAME (
    id int PRIMARY KEY,
    home_participant_id int not null,
    away_participant_id int not null,
    week_id int not null,
    FOREIGN KEY (home_participant_id) REFERENCES GAME_PARTICIPANT(id),
    FOREIGN KEY (away_participant_id) REFERENCES GAME_PARTICIPANT(id),
    FOREIGN KEY (week_id) REFERENCES WEEK(id)
);


CREATE TABLE USR (
	id int PRIMARY KEY,
	user_alias varchar(25) not null
);

CREATE TABLE LEAGUE (
    id int PRIMARY KEY,
    league_alias varchar(100) not null
);


--JUNCTION TABLE
CREATE TABLE LEAGUE_USR (
    id int PRIMARY KEY,
    league_id int not null,
    usr_id int not null,
    FOREIGN KEY (league_id) REFERENCES LEAGUE(id),
    FOREIGN KEY (usr_id) REFERENCES USR(id)
);
