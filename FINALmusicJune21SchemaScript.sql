CREATE SCHEMA IF NOT EXISTS `music_dept_perf_library`;
USE `music_dept_perf_library` ;

DROP TABLE IF EXISTS composer_song_title;
DROP TABLE IF EXISTS song_title_type;
DROP TABLE IF EXISTS performances;
DROP TABLE IF EXISTS performer;
DROP TABLE IF EXISTS song_title;
DROP TABLE IF EXISTS performance_type;
DROP TABLE IF EXISTS composer;

CREATE TABLE composer (
idcomposer int NOT NULL AUTO_INCREMENT,
composer_first_name VARCHAR(45),
composer_last_name VARCHAR(45) NOT NULL,
PRIMARY KEY (idcomposer)
);

CREATE TABLE performance_type (
idperformance_type int NOT NULL AUTO_INCREMENT,
performance_type VARCHAR(45) NOT NULL,
PRIMARY KEY (idperformance_type)
);

CREATE TABLE song_title 
idsong_title int NOT NULL AUTO_INCREMENT,
song_title VARCHAR(45) NOT NULL,
PRIMARY KEY (idsong_title)
);

CREATE TABLE performer (
idperformer int NOT NULL AUTO_INCREMENT,
artist_name VARCHAR(45) NOT NULL,
PRIMARY KEY (idperformer)
);

CREATE TABLE performances (
idperformances int NOT NULL AUTO_INCREMENT,
performance_date DATE NOT NULL, 
idperformer int, 
idsong_title int,
idperformance_type int,
idcomposer int,
PRIMARY KEY (idperformances),
FOREIGN KEY (idperformer) REFERENCES performer (ideperformer),
FOREIGN KEY (id_song_title) REFERENCES song_title (id_song_title),
FOREIGN KEY (idperformance_type) REFERENCES performance_type (idperformance_type),
FOREIGN KEY (idcomposer) REFERENCES composer (idcomposer)
);