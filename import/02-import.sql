COPY player_stats (name, team_name, number, nation, position, age)
FROM '/docker-entrypoint-initdb.d/player_stats.csv'
WITH (FORMAT csv, HEADER true, DELIMITER ';');