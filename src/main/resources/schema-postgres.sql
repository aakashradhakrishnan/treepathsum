DROP TABLE IF EXISTS userlist;
CREATE TABLE userlist(id serial PRIMARY KEY, first_name VARCHAR(100), last_name VARCHAR(100), password VARCHAR(100), email VARCHAR(100), enabled BOOLEAN DEFAULT TRUE);