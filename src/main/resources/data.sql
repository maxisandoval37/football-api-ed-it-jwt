INSERT INTO team (name, capacity) VALUES ('trueno verde', 100000);
INSERT INTO team (name, capacity) VALUES ('boca juniors', 54000);
INSERT INTO team (name, capacity) VALUES ('river plate', 84567);
INSERT INTO team (name, capacity) VALUES ('racing club', 42000);
INSERT INTO team (name, capacity) VALUES ('independiente', 48069);
INSERT INTO team (name, capacity) VALUES ('san lorenzo', 47964);
INSERT INTO team (name, capacity) VALUES ('rosario central', 46955);
INSERT INTO team (name, capacity) VALUES ('newells old boys', 42000);
INSERT INTO team (name, capacity) VALUES ('estudiantes', 32530);
INSERT INTO team (name, capacity) VALUES ('gimnasia lp', 30970);

INSERT INTO player (name, team_id) VALUES ('Priscila', 1);
INSERT INTO player (name, team_id) VALUES ('Lucas', 1);
INSERT INTO player (name, team_id) VALUES ('Nico', 1);
INSERT INTO player (name, team_id) VALUES ('Maxi', 1);

INSERT INTO player (name, team_id) VALUES ('Pedro', 2);

--password: password
INSERT INTO app_user (username, password, role) VALUES ('user1', '$2a$12$TyKhWAyOFxo3PIh0ppkSze.6iIb/DAFlzh2QlNQZNfNBnI1U3E4IW', 'USER');
INSERT INTO app_user (username, password, role) VALUES ('admin', '$2a$12$TyKhWAyOFxo3PIh0ppkSze.6iIb/DAFlzh2QlNQZNfNBnI1U3E4IW', 'ADMIN');