SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

USE sakilatest;

SET AUTOCOMMIT=0;
TRUNCATE TABLE staff;
TRUNCATE TABLE store;
TRUNCATE TABLE address;
TRUNCATE TABLE city;
TRUNCATE TABLE country;

-- Insert 1 country
INSERT INTO country VALUES (1,'Afghanistan','2006-02-15 04:44:00');
-- insert 3 cities
INSERT INTO city VALUES (1,'A Corua (La Corua)',1,'2006-02-15 04:45:25'),(2,'Abha',1,'2006-02-15 04:45:25'),(3,'Abu Dhabi',1,'2006-02-15 04:45:25');
-- insert 5 addresses
INSERT INTO address VALUES (1,'47 MySakilatest Drive',NULL,'Alberta',1,'','','2006-02-15 04:45:30'),(2,'28 MySQL Boulevard',NULL,'QLD',2,'','','2006-02-15 04:45:30'),(3,'23 Workhaven Lane',NULL,'Alberta',3,'','14033335568','2006-02-15 04:45:30'),(4,'1411 Lillydale Drive',NULL,'QLD',3,'','6172235589','2006-02-15 04:45:30'),(5,'1913 Hanoi Way','','Nagasaki',2,'35200','28303384290','2006-02-15 04:45:30');
-- insert 2 stores
INSERT INTO store VALUES (1,1,1,'2006-02-15 04:57:12'),(2,2,2,'2006-02-15 04:57:12');

-- 5 active users
INSERT INTO staff VALUES (1, 'Mark', 'Garcia', 1, null, 'umaba@miss.com', 1, 1, 'userguy1', SHA1( 'password123' ) , NOW());
INSERT INTO staff VALUES (2, 'Adam', 'Folskss', 2, null, 'me@gmail.com', 2, 1, 'testacct', SHA1( 'password123' ) , NOW());
INSERT INTO staff VALUES (3, 'Mary', 'Somelastp', 3, null, 'afaf@msn.com', 2, 1, 'safdafa', SHA1( 'password123' ) , NOW());
INSERT INTO staff VALUES (4, 'Sharon', 'Smith', 4, null, 'Sharo@yahoo.com', 1, 1, 'someuser', SHA1( 'password123' ) , NOW());
INSERT INTO staff VALUES (5, 'Demitia', 'Alsowd', 5, null, 'demei@here.com', 1, 1, 'emacs', SHA1( 'password123' ) , NOW());

-- 2 inactive users
INSERT INTO staff VALUES (6, 'bill', 'user', 1, null, 'me@here.com', 1, 0, 'emacsuser', SHA1( 'password123' ) , NOW());
INSERT INTO staff VALUES (7, 'Makaa', 'Micaaaa', 2, null, 'abcd@google.com', 2, 0, 'viuser', SHA1( 'password123' ) , NOW());

COMMIT;

