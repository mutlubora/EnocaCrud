CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`) 
);

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (department_id)
        REFERENCES department(id)
        ON DELETE SET NULL
);

INSERT INTO `department` VALUES 
	(1,'Product Management'),
	(2,'Software Engineering'),
	(3,'Network');

    
INSERT INTO `employee` VALUES 
	(1,'Mutlu','Bora','mutlubora@gmail.com', 1),
	(2,'Mert','Kadir','mertkadir@hotmail.com', 1),
	(3,'Tolga','Tokgoz','tolgatokgoz@gmail.com', 2),
	(4,'Salih','Cem','salihcem@hotmail.com', 2),
	(5,'Eren','Ilker','erenilker@gmail.com', 3);

