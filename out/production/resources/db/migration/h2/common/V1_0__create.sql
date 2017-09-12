CREATE TABLE USR (
	ldap varchar(20) PRIMARY KEY,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	slack_handle varchar(50) NULL,
	email_address varchar(100) null,
	phone_number VARCHAR (15) null
);

create table SEVERITY (
  sev_level VARCHAR(20) PRIMARY KEY,
  description VARCHAR(200)
);

create table SEVERITY_SCHEDULE (
  id int PRIMARY KEY,
  days_of_week VARCHAR(30) null,
  start_time TIME not null,
  end_time TIME not null,
  sev_level VARCHAR(20) not NULL,
  FOREIGN KEY (sev_level) REFERENCES SEVERITY(sev_level)
);

CREATE TABLE INCIDENT (
  id int PRIMARY KEY,
  description VARCHAR(500) not null,
  created_by VARCHAR(100) not null,
  contact_info VARCHAR(200) null,
  assigned_to varchar(20) NULL,
  parent_id int null,
  sev_level VARCHAR(20) not NULL,
  FOREIGN KEY (parent_id) REFERENCES INCIDENT(id),
  FOREIGN KEY (assigned_to) REFERENCES USR(ldap),
  FOREIGN KEY (sev_level) REFERENCES SEVERITY(sev_level)
);

create table INCIDENT_STATUS (
  id int PRIMARY KEY,
  description VARCHAR(50) not null
);

CREATE TABLE INCIDENT_STATUS_EVENT (
  incident_status_event_id int PRIMARY key,
  create_time TIMESTAMP not null,
  status_id int not null,
  incident_id int not null,
  usr_id varchar(20) not null,
  FOREIGN KEY (status_id) REFERENCES INCIDENT_STATUS(id),
  FOREIGN KEY (incident_id) REFERENCES INCIDENT(id),
  FOREIGN KEY (usr_id) REFERENCES USR(ldap)
);

CREATE TABLE ACKNOWLEDGEMENT_SNOOZE (
  id int PRIMARY key,
  create_time TIMESTAMP not null,
  duration int not null,
  incident_status_event_id int not null,
  FOREIGN KEY (incident_status_event_id) REFERENCES INCIDENT_STATUS_EVENT(incident_status_event_id)
);


create table ON_CALL_SCHEDULE (
  id int PRIMARY KEY,
  primary_on_call varchar(20) not null,
  secondary_on_call varchar(20) not null,
  create_timestamp TIMESTAMP not null,
  schedule_start_time TIMESTAMP not null,
  schedule_end_time TIMESTAMP not null,
  FOREIGN KEY (primary_on_call) REFERENCES USR(ldap),
  FOREIGN KEY (secondary_on_call) REFERENCES USR(ldap)
);

create table USR_SCHEDULE_PREFERENCES (
    id int PRIMARY KEY,
    days_of_week VARCHAR(30) null,
    preference_start_time TIME not null,
    preference_end_time TIME not null,
    usr_id varchar(20) not null,
    FOREIGN KEY (usr_id) REFERENCES USR(ldap)
);

create table PROCEDURE_TYPE (
  id int PRIMARY KEY,
  procedure_type VARCHAR(50) not null,
  param_1 VARCHAR(100) null,
  param_2 VARCHAR(100) null,
  param_3 VARCHAR(100) null,
  param_4 VARCHAR(100) null,
  param_5 VARCHAR(100) null
);

create table ESCALATION_PROCEDURE (
  id int PRIMARY KEY,
  procedure_sequence_number int not null,
  usr_schedule_preference_id int not null,
  procedure_type_id int not NULL,
  duration int not null,
  FOREIGN KEY (usr_schedule_preference_id) REFERENCES USR_SCHEDULE_PREFERENCES(id),
  FOREIGN KEY (procedure_type_id) REFERENCES PROCEDURE_TYPE(id)
);

