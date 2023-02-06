-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 11, 2016 at 06:40 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `valetine`
--
CREATE DATABASE IF NOT EXISTS `valetine` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `valetine`;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `mobile_number` varchar(13) NOT NULL,
  `password` varchar(35) NOT NULL,
  `hint` varchar(40) NOT NULL,
  `email_id` varchar(40) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `age` varchar(10) NOT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`mobile_number`, `password`, `hint`, `email_id`, `uname`, `age`, `id`) VALUES
('0789105998', 'bams', 'Goods', 'bams@gmail.com', 'sheeba', '45', 1);

-- --------------------------------------------------------

--
-- Table structure for table `love_song`
--

CREATE TABLE IF NOT EXISTS `love_song` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `icon` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `love_song`
--

INSERT INTO `love_song` (`id`, `name`, `file_name`, `icon`) VALUES
(1, 'Agende', 'Agende.mp4', 'Agende.png'),
(2, 'Akabimbi', 'Akabimbi.mp4', 'dian.png'),
(3, 'Am Bad', 'Am Bad.mp4', 'aziz.png'),
(4, '02 I''m in Love With a DJ', '02 I''m in Love With a DJ.mp3', 'mp3.PNG'),
(5, '04 Right Here (Departed)', '04 Right Here (Departed).mp3', 'mp3.PNG'),
(6, '04 Umqombothi', '04 Umqombothi.mp3', 'mp3.PNG'),
(7, 'Breathless', 'Breathless.mp3', 'mp3.PNG'),
(8, 'If That''s OK With You', 'If That''s OK With You.mp3', 'mp3.PNG'),
(9, 'kasuku', 'kasuku.mp3', 'mp3.PNG');

-- --------------------------------------------------------

--
-- Table structure for table `love_tips`
--

CREATE TABLE IF NOT EXISTS `love_tips` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `aurthor` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `love_tips`
--

INSERT INTO `love_tips` (`id`, `name`, `aurthor`) VALUES
(1, 'love your boy', 'tonny'),
(2, 'never give up on love', 'chris'),
(3, 'always love one person', 'crays');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
