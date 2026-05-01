USE testdb;

DROP TABLE IF EXISTS `EMPLOYEES`;

CREATE TABLE `EMPLOYEES` (
  `emp_no` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `first_name` varchar(14) NOT NULL,
  `last_name` varchar(16) NOT NULL,
  `gender` enum('M','F') NOT NULL,
  `hire_date` date NOT NULL,
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_no`),
  KEY `FK_EMPLOYEES` (`manager_id`)
-- ,
--  CONSTRAINT `FK_EMPLOYEES` FOREIGN KEY (`manager_id`) REFERENCES `EMPLOYEES` (`emp_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*
-- Query: select *
from EMPLOYEES
-- Date: 2018-08-23 21:33
*/
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10001,'1953-09-02','Georgi','Facello','M','1986-06-26',NULL);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10002,'1964-06-02','Bezalel','Simmel','F','1985-11-21',null);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10003,'1959-12-03','Parto','Bamford','M','1986-08-28',10002);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10004,'1954-05-01','Chirstian','Koblick','M','1986-12-01',10003);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10005,'1955-01-21','Kyoichi','Maliniak','M','1989-09-12',10004);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10006,'1953-04-20','Anneke','Preusig','F','1989-06-02',10005);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10007,'1957-05-23','Tzvetan','Zielinski','F','1989-02-10',10006);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10008,'1958-02-19','Saniya','Kalloufi','M','1994-09-15',10008);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10009,'1952-04-19','Sumant','Peac','F','1985-02-18',10007);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10010,'1963-06-01','Duangkaew','Piveteau','F','1989-08-24',10007);
INSERT INTO `EMPLOYEES` (`emp_no`,`birth_date`,`first_name`,`last_name`,`gender`,`hire_date`,`manager_id`) VALUES (10011,'1953-11-07','Mary','Sluis','F','1990-01-22',10007);


ALTER TABLE `EMPLOYEES` 
ADD CONSTRAINT `FK_EMPLOYEES` 
FOREIGN KEY (`manager_id`) 
REFERENCES `EMPLOYEES` (`emp_no`);