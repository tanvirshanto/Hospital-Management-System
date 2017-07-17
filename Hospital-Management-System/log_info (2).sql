-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2016 at 07:38 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `log_info`
--

-- --------------------------------------------------------

--
-- Table structure for table `drug_info`
--

CREATE TABLE `drug_info` (
  `Drug_Id` int(20) NOT NULL,
  `Drug_Name` varchar(20) NOT NULL,
  `Purchase_Date` varchar(20) NOT NULL,
  `Drug_Type` varchar(20) NOT NULL,
  `Exp_Date` varchar(20) NOT NULL,
  `Unit_price` int(20) NOT NULL,
  `Company_Name` varchar(20) NOT NULL,
  `Company_Address` varchar(20) NOT NULL,
  `Phone_no` int(20) NOT NULL,
  `Mail_Address` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drug_info`
--

INSERT INTO `drug_info` (`Drug_Id`, `Drug_Name`, `Purchase_Date`, `Drug_Type`, `Exp_Date`, `Unit_price`, `Company_Name`, `Company_Address`, `Phone_no`, `Mail_Address`) VALUES
(1, 'Napa', '12/16/2015', 'Tablet', '12/16/2018', 1000, 'Square', 'Gazipur', 74548877, 'square.com'),
(2, 'H+', '12/16/2015', 'Tablet', '12/16/2015', 500, 'Square', 'Nrayangonj', 5489666, 'square.com'),
(3, 'Tuska', '12/16/2015', 'Syrup', '12/16/2018', 1200, 'ACE', 'Mohakhali', 4788888, 'Ace.com'),
(4, 'Abordon', '12/16/2015', 'Tablet', '12/16/2018', 700, 'Acme', 'Bonani', 9876555, 'Acme.com'),
(5, 'Napa Extra', '12/16/2015', 'Tablet', '12/16/1998', 1000, 'square', 'Savar', 45897999, 'square.com'),
(6, 'Eco', '12/16/2015', 'Tablet', '12/16/2018', 900, 'Acme', 'Borisal', 9879665, 'Acme.com');

-- --------------------------------------------------------

--
-- Table structure for table `dr_room_information`
--

CREATE TABLE `dr_room_information` (
  `Dr_ID` varchar(20) NOT NULL,
  `Dr_Name` varchar(30) NOT NULL,
  `Visit_time` varchar(20) NOT NULL,
  `Visit_Fee` varchar(20) NOT NULL,
  `Specialist` varchar(20) NOT NULL,
  `Room_No` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dr_room_information`
--

INSERT INTO `dr_room_information` (`Dr_ID`, `Dr_Name`, `Visit_time`, `Visit_Fee`, `Specialist`, `Room_No`) VALUES
('1', 'Hasan', '9am-2pm', '500', 'Eye', '412'),
('2', 'Tawfiq', '10am-2pm', '500', 'Heart', '124'),
('3', 'Rafiq', '5pm-8pm', '500', 'Kidney', '541'),
('4', 'Martian', '4pm-7pm', '800', 'Psycology', '112'),
('5', 'Alesso', '1pm-3pm', '500', 'Ear', '421');

-- --------------------------------------------------------

--
-- Table structure for table `log_info`
--

CREATE TABLE `log_info` (
  `firstName` varchar(10) NOT NULL,
  `Age` int(10) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log_info`
--

INSERT INTO `log_info` (`firstName`, `Age`, `username`, `password`) VALUES
('shanto', 21, 'shanto', 123),
('Arif', 22, 'arif', 321),
('admin', 32, 'admin', 123);

-- --------------------------------------------------------

--
-- Table structure for table `patientinfo`
--

CREATE TABLE `patientinfo` (
  `Patient_ID` int(15) NOT NULL,
  `Patient_type` varchar(15) NOT NULL,
  `Name` varchar(15) NOT NULL,
  `Age` int(15) NOT NULL,
  `Gender` varchar(15) NOT NULL,
  `Birth_Date` varchar(15) NOT NULL,
  `Occupation` varchar(15) NOT NULL,
  `REF_By` varchar(15) NOT NULL,
  `Address` varchar(15) NOT NULL,
  `phone` int(15) NOT NULL,
  `Person_Name` varchar(15) NOT NULL,
  `Contact_No` int(15) NOT NULL,
  `Relation` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientinfo`
--

INSERT INTO `patientinfo` (`Patient_ID`, `Patient_type`, `Name`, `Age`, `Gender`, `Birth_Date`, `Occupation`, `REF_By`, `Address`, `phone`, `Person_Name`, `Contact_No`, `Relation`) VALUES
(1, 'normal', 'Akmal', 25, 'Male', '1/5/1992', 'student', 'shahid', 'Dhaka', 7845666, 'Tawfiq', 7415322, 'Friend'),
(2, 'normal ', ' Rony ', 34, ' Male ', ' 12/16/1991 ', ' Service ', ' Dr.Mind ', ' Savar ', 7783999, ' shanto ', 7896587, ' Brother '),
(3, 'normal ', 'Rubel     ', 35, ' Male ', ' 12/16/1980  ', 'Service     ', 'Babul     ', 'Bonani     ', 7896544, 'Rahman     ', 9876548, 'Father     '),
(5, 'normal', 'Sahadat', 30, 'Male', '12/16/1980', 'service', 'Akbar', 'Tangail', 98655455, 'Kornel', 6865555, 'Uncle'),
(6, 'normal', 'Shimu', 19, 'Female', '12/16/1996', 'student', 'Tanvir', 'Savar', 7788854, 'kornel', 4588789, 'Husband');

-- --------------------------------------------------------

--
-- Table structure for table `serial_no`
--

CREATE TABLE `serial_no` (
  `Serial_No` int(11) NOT NULL,
  `Dr_Name` varchar(20) NOT NULL,
  `Patient_Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff_info`
--

CREATE TABLE `staff_info` (
  `staff_ID` int(15) NOT NULL,
  `staff_type` varchar(15) NOT NULL,
  `Name` varchar(15) NOT NULL,
  `Age` int(15) NOT NULL,
  `Birthdate` varchar(15) NOT NULL,
  `Religion` varchar(15) NOT NULL,
  `Gender` varchar(15) NOT NULL,
  `Blood_Group` varchar(15) NOT NULL,
  `Marital_Status` varchar(15) NOT NULL,
  `Salary` int(15) NOT NULL,
  `Address` varchar(15) NOT NULL,
  `phone` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff_info`
--

INSERT INTO `staff_info` (`staff_ID`, `staff_type`, `Name`, `Age`, `Birthdate`, `Religion`, `Gender`, `Blood_Group`, `Marital_Status`, `Salary`, `Address`, `phone`) VALUES
(1, ' Regular ', '   1   ', 1, '   1   ', '   1   ', ' Female ', '   1   ', '   1   ', 1, '   11   ', 1),
(2, 'Regular', 'Tanvir', 19, '19/4/1994', 'Muslims', 'Male', 'A+', 'Unmarried', 2000, 'Mohakhali', 3214555),
(3, 'Regular', 'Riyad', 23, '12/5/1994', 'Muslims', 'Male', 'B+', 'Unmarried', 19000, 'Mogbazar', 9314456),
(6, 'Irregular', 'Asif', 30, '12/16/1988', 'Muslims', 'Male', 'O-', 'Married', 20000, 'Tangail', 6999999);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `drug_info`
--
ALTER TABLE `drug_info`
  ADD PRIMARY KEY (`Drug_Id`);

--
-- Indexes for table `dr_room_information`
--
ALTER TABLE `dr_room_information`
  ADD PRIMARY KEY (`Dr_ID`);

--
-- Indexes for table `patientinfo`
--
ALTER TABLE `patientinfo`
  ADD PRIMARY KEY (`Patient_ID`);

--
-- Indexes for table `serial_no`
--
ALTER TABLE `serial_no`
  ADD PRIMARY KEY (`Serial_No`);

--
-- Indexes for table `staff_info`
--
ALTER TABLE `staff_info`
  ADD PRIMARY KEY (`staff_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
