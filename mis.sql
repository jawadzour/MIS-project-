/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.11-MariaDB : Database - mis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mis` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mis`;

/*Table structure for table `academic_information_board` */

DROP TABLE IF EXISTS `academic_information_board`;

CREATE TABLE `academic_information_board` (
  `academic_information_board_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `passing_year` year(4) DEFAULT NULL,
  `board` varchar(255) DEFAULT NULL,
  `marks` decimal(16,4) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `academic_type` enum('matriculation','intermediate') DEFAULT NULL,
  PRIMARY KEY (`academic_information_board_id`),
  KEY `personal_information_id` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `academic_information_board` */

/*Table structure for table `academic_information_graduate` */

DROP TABLE IF EXISTS `academic_information_graduate`;

CREATE TABLE `academic_information_graduate` (
  `academic_information_graduate_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `passing_year` year(4) DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  `marks` decimal(16,4) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `graduate_type` enum('bachelors','masters') DEFAULT NULL,
  PRIMARY KEY (`academic_information_graduate_id`),
  KEY `personal_information_id` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `academic_information_graduate` */

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  `faculty_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  KEY `faculty_id` (`faculty_id`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Data for the table `department` */

/*Table structure for table `department_faculty` */

DROP TABLE IF EXISTS `department_faculty`;

CREATE TABLE `department_faculty` (
  `department_faculty_id` int(11) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`department_faculty_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `department_faculty_ibfk_1` FOREIGN KEY (`department_faculty_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `department_faculty` */

/*Table structure for table `documents` */

DROP TABLE IF EXISTS `documents`;

CREATE TABLE `documents` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `matriculation_marksheet` blob DEFAULT NULL,
  `matriculation_certificate` blob DEFAULT NULL,
  `intermediate_marksheet` blob DEFAULT NULL,
  `intermediate_certificate` blob DEFAULT NULL,
  `graduate_transcript` blob DEFAULT NULL,
  `graduate_pass_certificate` blob DEFAULT NULL,
  PRIMARY KEY (`document_id`),
  KEY `personal_information_id` (`student_id`),
  CONSTRAINT `documents_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `documents` */

/*Table structure for table `experience` */

DROP TABLE IF EXISTS `experience`;

CREATE TABLE `experience` (
  `experience_id` int(11) NOT NULL AUTO_INCREMENT,
  `personal_information_id` int(11) NOT NULL,
  `company` varchar(255) NOT NULL,
  `position_held` varchar(255) NOT NULL,
  `from` date NOT NULL,
  `to` date NOT NULL,
  `nature_of_work` varchar(255) NOT NULL,
  `remarks` varchar(255) NOT NULL,
  PRIMARY KEY (`experience_id`),
  KEY `personal_information_id` (`personal_information_id`),
  CONSTRAINT `experience_ibfk_1` FOREIGN KEY (`personal_information_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `experience` */

/*Table structure for table `faculty` */

DROP TABLE IF EXISTS `faculty`;

CREATE TABLE `faculty` (
  `faculty_id` int(11) NOT NULL AUTO_INCREMENT,
  `faculty_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `faculty` */

insert  into `faculty`(`faculty_id`,`faculty_name`) values (1,'Faculty Of Science'),(7,'Faculty of Computer Engineerings');

/*Table structure for table `fees` */

DROP TABLE IF EXISTS `fees`;

CREATE TABLE `fees` (
  `fees_id` int(11) NOT NULL,
  `fees_title` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `announcement_date` timestamp NULL DEFAULT NULL,
  `due_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`fees_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `fees` */

/*Table structure for table `seminar` */

DROP TABLE IF EXISTS `seminar`;

CREATE TABLE `seminar` (
  `seminar_id` int(11) NOT NULL,
  `seminar_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seminar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `seminar` */

/*Table structure for table `seminar_group` */

DROP TABLE IF EXISTS `seminar_group`;

CREATE TABLE `seminar_group` (
  `seminar_group_id` int(11) NOT NULL,
  `seminar_id` int(11) DEFAULT NULL,
  `thesis_group_id` int(11) DEFAULT NULL,
  `date_applied` date DEFAULT NULL,
  `date_conducted` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `comments` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`seminar_group_id`),
  KEY `seminar_id` (`seminar_id`),
  KEY `thesis_group_id` (`thesis_group_id`),
  CONSTRAINT `seminar_group_ibfk_1` FOREIGN KEY (`seminar_id`) REFERENCES `seminar` (`seminar_id`),
  CONSTRAINT `seminar_group_ibfk_2` FOREIGN KEY (`thesis_group_id`) REFERENCES `thesis_group` (`thesis_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `seminar_group` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `roll_number` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `fathers_name` varchar(255) DEFAULT NULL,
  `legal_id` varchar(255) DEFAULT NULL,
  `legal_id_no` varchar(255) DEFAULT NULL,
  `nationality` int(11) DEFAULT NULL,
  `place_of_issue_of_legal_id` varchar(255) DEFAULT NULL,
  `date_of_issue_of_legal_id` date DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `domicile` varchar(255) DEFAULT NULL,
  `country_of_birth` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `religion` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `current_address` varchar(255) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `batch` varchar(255) DEFAULT NULL,
  `admission_date` date DEFAULT NULL,
  `supervisor_id` int(11) DEFAULT NULL,
  `program` varchar(255) DEFAULT NULL,
  `field_program` varchar(255) DEFAULT NULL,
  `shift` varchar(255) DEFAULT NULL,
  `timing` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `nationality` (`nationality`),
  KEY `domicile_id` (`domicile`),
  KEY `country_of_birth` (`country_of_birth`),
  KEY `blood_group_id` (`blood_group`),
  KEY `religion_id` (`religion`),
  KEY `supervisor_id` (`supervisor_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `academic_information_board` (`academic_information_board_id`),
  CONSTRAINT `student_ibfk_3` FOREIGN KEY (`student_id`) REFERENCES `academic_information_graduate` (`academic_information_graduate_id`),
  CONSTRAINT `student_ibfk_6` FOREIGN KEY (`supervisor_id`) REFERENCES `department_faculty` (`department_faculty_id`),
  CONSTRAINT `student_ibfk_7` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

/*Table structure for table `student_fees` */

DROP TABLE IF EXISTS `student_fees`;

CREATE TABLE `student_fees` (
  `student_fees_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `fees_id` int(11) DEFAULT NULL,
  `date_paid` date DEFAULT NULL,
  `amount_paid` int(11) DEFAULT NULL,
  `late_fees` int(11) DEFAULT NULL,
  `challan_no` int(11) DEFAULT NULL,
  `challan_image` blob DEFAULT NULL,
  KEY `student_id` (`student_id`),
  KEY `fees_id` (`fees_id`),
  CONSTRAINT `student_fees_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `student_fees_ibfk_2` FOREIGN KEY (`fees_id`) REFERENCES `fees` (`fees_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student_fees` */

/*Table structure for table `thesis_documents` */

DROP TABLE IF EXISTS `thesis_documents`;

CREATE TABLE `thesis_documents` (
  `thesis_document_id` int(11) NOT NULL AUTO_INCREMENT,
  `thesis_document_title` varchar(255) DEFAULT NULL,
  `thesis_group_id` int(11) DEFAULT NULL,
  `thesis_document` blob DEFAULT NULL,
  PRIMARY KEY (`thesis_document_id`),
  KEY `thesis_group_id` (`thesis_group_id`),
  CONSTRAINT `thesis_documents_ibfk_1` FOREIGN KEY (`thesis_group_id`) REFERENCES `thesis_group` (`thesis_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `thesis_documents` */

/*Table structure for table `thesis_group` */

DROP TABLE IF EXISTS `thesis_group`;

CREATE TABLE `thesis_group` (
  `thesis_group_id` int(11) NOT NULL,
  `thesis_title` varchar(255) DEFAULT NULL,
  `thesis_exam_date` date DEFAULT NULL,
  `final_results` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`thesis_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `thesis_group` */

/*Table structure for table `thesis_group_members` */

DROP TABLE IF EXISTS `thesis_group_members`;

CREATE TABLE `thesis_group_members` (
  `thesis_group_members_id` int(11) NOT NULL,
  `thesis_group_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`thesis_group_members_id`),
  KEY `thesis_group_id` (`thesis_group_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `thesis_group_members_ibfk_1` FOREIGN KEY (`thesis_group_id`) REFERENCES `thesis_group` (`thesis_group_id`),
  CONSTRAINT `thesis_group_members_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `thesis_group_members` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
