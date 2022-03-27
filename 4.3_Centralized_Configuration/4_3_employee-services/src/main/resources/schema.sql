DROP TABLE IF EXISTS `EMPLOYEES`;
CREATE TABLE `EMPLOYEES` (
  `emp_id` number(20) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar2(50) DEFAULT NULL,
  `emp_desig` varchar2(50) DEFAULT NULL,
  `emp_address` varchar2(50) DEFAULT NULL,
  `emp_sal` number(20) DEFAULT NULL,
  `bu_id` number(20) NOT NULL,
  PRIMARY KEY (`emp_id`)
);