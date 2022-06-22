DROP TABLE IF EXISTS ensemble_performers;
DROP TABLE IF EXISTS ensemble_performances;
DROP TABLE IF EXISTS song_performances;
DROP TABLE IF EXISTS performers;
DROP TABLE IF EXISTS ensembles;
DROP TABLE IF EXISTS songs;
DROP TABLE IF EXISTS composers;
DROP TABLE IF EXISTS performances;

CREATE TABLE performances (
    performance_pk int NOT NULL AUTO_INCREMENT,
    performance_name varchar(50),
    performance_date date NOT NULL,
    PRIMARY KEY (performance_pk)
);

CREATE TABLE composers (
    composer_pk int NOT NULL AUTO_INCREMENT,
    first_name varchar(40) NOT NULL,
    last_name varchar(40) NOT NULL,
    PRIMARY KEY (composer_pk)
);

CREATE TABLE songs (
    song_pk int NOT NULL AUTO_INCREMENT,
    composer_fk int NOT NULL,
    song_title varchar(80) NOT NULL,
    song_type enum('SOLO', 'DUET', 'TRIO', 'QUARTET', 'QUINTET') NOT NULL,
    PRIMARY KEY (song_pk),
    FOREIGN KEY (composer_fk) REFERENCES composers (composer_pk)
);

CREATE TABLE ensembles (
    ensemble_pk int NOT NULL AUTO_INCREMENT,
    ensemble_name varchar(50) NOT NULL,
    member_size int NOT NULL,
    PRIMARY KEY (ensemble_pk)
);

CREATE TABLE performers (
    performer_pk int NOT NULL AUTO_INCREMENT,
    first_name varchar(40) NOT NULL,
    last_name varchar(40) NOT NULL,
    instrument_voice_type enum('FLUTE', 'CLARINET', 'SAXOPHONE', 'TRUMPET', 'FRENCH_HORN', 'TROMBONE', 'EUPHONIUM', 'TUBA', 'PERCUSSION', 'SOPRANO', 'ALTO', 'TENOR', 'BASS') NOT NULL,
    PRIMARY KEY (performer_pk)
);

CREATE TABLE song_performances (
    performance_fk int NOT NULL,
    song_fk int NOT NULL,
    FOREIGN KEY (performance_fk) REFERENCES performances (performance_pk),
    FOREIGN KEY (song_fk) REFERENCES songs (song_pk)
);

CREATE TABLE ensemble_performances (
    performance_fk int NOT NULL,
    ensemble_fk int NOT NULL,
    FOREIGN KEY (performance_fk) REFERENCES performances (performance_pk),
    FOREIGN KEY (ensemble_fk) REFERENCES ensembles (ensemble_pk)
);

CREATE TABLE ensemble_performers (
    ensemble_fk int NOT NULL,
    performer_fk int NOT NULL,
    FOREIGN KEY (ensemble_fk) REFERENCES ensembles (ensemble_pk),
    FOREIGN KEY (performer_fk) REFERENCES performers (performer_pk)
);