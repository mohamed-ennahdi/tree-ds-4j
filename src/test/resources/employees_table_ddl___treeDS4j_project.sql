CREATE TABLE `employees` (
  `emp_no` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `first_name` varchar(14) NOT NULL,
  `last_name` varchar(16) NOT NULL,
  `gender` enum('M','F') NOT NULL,
  `hire_date` date NOT NULL,
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_no`),
  KEY `FK_employees` (`manager_id`),
  CONSTRAINT `FK_employees` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`emp_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
