INSERT INTO composers (first_name, last_name) VALUES ('LUDWIG', 'BEETHOVEN');
INSERT INTO composers (first_name, last_name) VALUES ('JOHANN', 'BACH');
INSERT INTO composers (first_name, last_name) VALUES ('WOLFGANG', 'MOZART');
INSERT INTO composers (first_name, last_name) VALUES ('RICHARD', 'WAGNER');
INSERT INTO composers (first_name, last_name) VALUES ('CLAUDE', 'DEBUSSY');
INSERT INTO composers (first_name, last_name) VALUES ('FREDERIC', 'CHOPIN');
INSERT INTO composers (first_name, last_name) VALUES ('PYOTR', 'TCHAIKOVSKY');
INSERT INTO composers (first_name, last_name) VALUES ('JOHANNES', 'BRAHMS');

INSERT INTO performers (first_name, last_name, instrument_voice_type) VALUES ('JORDAN', 'LADYMAN', 'CLARINET');
INSERT INTO performers (first_name, last_name, instrument_voice_type) VALUES ('CHELSEA', 'PERRINE', 'PERCUSSION');
INSERT INTO performers (first_name, last_name, instrument_voice_type) VALUES ('JOHN', 'SMITH', 'BASS');

INSERT INTO performances (performance_date) VALUES ('2017-06-15');
INSERT INTO performances (performance_date) VALUES ('2017-06-15');
INSERT INTO performances (performance_date) VALUES ('2018-06-15');
INSERT INTO performances (performance_date) VALUES ('2019-06-15');
INSERT INTO performances (performance_date) VALUES ('2020-06-15');
INSERT INTO performances (performance_date) VALUES ('2020-02-02');

INSERT INTO ensembles (ensemble_name, member_size) VALUES ('Duet1', '2');
INSERT INTO ensembles (ensemble_name, member_size) VALUES ('Duet2', '2');
INSERT INTO ensembles (ensemble_name, member_size) VALUES ('Trio1', '3');
INSERT INTO ensembles (ensemble_name, member_size) VALUES ('Trio2', '3');

INSERT INTO songs (composer_fk, song_title, song_type) VALUES ('1','Fur Elise', 'Solo');
INSERT INTO songs (composer_fk, song_title, song_type) VALUES ('3', 'Twinkle Twinkle', 'Duet');
INSERT INTO songs (composer_fk, song_title, song_type) VALUES ('4', 'Elsas Dream', 'Trio');

INSERT INTO performances (performance_name, performance_date) VALUES ('Jordans Senior Recital', '2019-05-05');
INSERT INTO performances (performance_name, performance_date) VALUES ('Jordans Senior Recital', '2019-05-05'); 
INSERT INTO performances (performance_name, performance_date) VALUES ('Chelseas Senior Recital', '2011-05-05');
UPDATE `music_dept_perf_library`.`performances` SET `performance_name` = 'Johns Senior Recital' WHERE (`performance_pk` = '6');





















