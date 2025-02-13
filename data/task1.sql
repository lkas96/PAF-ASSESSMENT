create database movies;

use movies;

create table imdb (
    imdb_id varchar(16),
    vote_average float default 0,
    vote_count int default 0,
    release_date date,
    revenue decimal(15,2) default 1000000,
    budget decimal(15,2) default 1000000,
    runtime int default 90,
    
    PRIMARY KEY (imdb_id)
);