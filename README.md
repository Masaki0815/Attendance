# PGSQL
CREATE TABLE data(
  "id" SERIAL NOT NULL,
  "start_time" VARCHAR(100),
  "end_time" VARCHAR(100),
  "year" VARCHAR(100),
  "work_space" INTEGER,
  "start_break" VARCHAR(100),
  "end_break" VARCHAR(100),
  PRIMARY KEY ("id"));
