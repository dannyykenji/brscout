DROP TABLE IF EXISTS player_stats CASCADE;

CREATE TABLE player_stats (
    name VARCHAR(255),
    team_name VARCHAR(255),
    number INTEGER,
    nation VARCHAR(255),
    position VARCHAR(255),
    age INTEGER
);