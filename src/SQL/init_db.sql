DROP TABLE IF EXISTS worker;
CREATE TABLE worker (worker_id SERIAL PRIMARY KEY, name VARCHAR(1000) NOT NULL, birthday DATE CHECK ( birthday > '1900-01-01') NOT NULL, level VARCHAR CHECK ( level IN ('Trainee', 'Junior', 'Middle', 'Senior')), salary INT CHECK (99 < salary AND salary < 100001) NOT NULL);
DROP TABLE IF EXISTS project;
CREATE TABLE project (project_id SERIAL PRIMARY KEY, client_id INT, start_date DATE, finish_date DATE);
DROP TABLE IF EXISTS project_worker;
CREATE TABLE project_worker (project_id INT, worker_id INT, FOREIGN KEY (project_id) REFERENCES project, FOREIGN KEY (worker_id) REFERENCES worker, PRIMARY KEY (project_id, worker_id) );
DROP TABLE IF EXISTS client;
CREATE TABLE client (client_id SERIAL PRIMARY KEY, client_name VARCHAR (1000) NOT NULL );