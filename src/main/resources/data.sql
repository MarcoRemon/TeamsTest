CREATE TABLE IF NOT EXISTS TEAMS (id BIGINT AUTO_INCREMENT PRIMARY KEY,
nombre varchar(255),
liga varchar(255),
pais varchar(255));

CREATE TABLE IF NOT EXISTS USERS (id BIGINT AUTO_INCREMENT PRIMARY KEY,
username varchar(255),
password varchar(255));

INSERT INTO USERS (username,password) VALUES ('test','$2a$10$3DHfmCLIyI60MCDMRbGTg.FSXYS8ngR8dokl3tw3GbuTQZaG3pbKe');

INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Real Madrid', 'La Liga', 'España');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('FC Barcelona', 'La Liga', 'España');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Manchester United', 'Premier League', 'Inglaterra');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Liverpool FC', 'Premier League', 'Inglaterra');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Juventus FC', 'Serie A', 'Italia');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('AC Milan', 'Serie A', 'Italia');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Bayern Munich', 'Bundesliga', 'Alemania');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Borussia Dortmund', 'Bundesliga', 'Alemania');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Paris Saint-Germain', 'Ligue 1', 'Francia');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Olympique de Marseille', 'Ligue 1', 'Francia');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('FC Porto', 'Primeira Liga', 'Portugal');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Sporting CP', 'Primeira Liga', 'Portugal');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Ajax Amsterdam', 'Eredivisie', 'Países Bajos');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Feyenoord', 'Eredivisie', 'Países Bajos');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Celtic FC', 'Scottish Premiership', 'Escocia');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Rangers FC', 'Scottish Premiership', 'Escocia');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Galatasaray SK', 'Süper Lig', 'Turquía');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Fenerbahçe SK', 'Süper Lig', 'Turquía');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('FC Zenit Saint Petersburg', 'Premier League Rusa', 'Rusia');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Spartak Moscow', 'Premier League Rusa', 'Rusia');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('SL Benfica', 'Primeira Liga', 'Portugal');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Besiktas JK', 'Süper Lig', 'Turquía');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('SSC Napoli', 'Serie A', 'Italia');
INSERT INTO TEAMS (nombre, liga, pais) VALUES ('Atlético Madrid', 'La Liga', 'España');
