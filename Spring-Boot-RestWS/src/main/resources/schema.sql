DROP TABLE IF EXISTS TBL_COUNTRIES; 
 
CREATE TABLE TBL_COUNTRIES (
  population INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  capital VARCHAR(250) NOT NULL,
  currency VARCHAR(250) DEFAULT NULL
);