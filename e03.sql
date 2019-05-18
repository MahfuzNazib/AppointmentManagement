-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2019 at 06:23 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e03`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctorinfo`
--

CREATE TABLE `doctorinfo` (
  `doctorId` varchar(30) NOT NULL,
  `fullName` varchar(30) NOT NULL,
  `age` varchar(30) NOT NULL,
  `department` varchar(30) NOT NULL,
  `degree` varchar(30) NOT NULL,
  `specialist` varchar(30) NOT NULL,
  `visitingFee` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `contactNo` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `gander` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctorinfo`
--

INSERT INTO `doctorinfo` (`doctorId`, `fullName`, `age`, `department`, `degree`, `specialist`, `visitingFee`, `email`, `contactNo`, `address`, `gander`) VALUES
('d0002', 'M.N.Alam', '58', 'Medicine', 'FCPSC,MBBS', 'Diabatics', '700', 'mnalam@gmail.com', '0177785555', 'Uttara', 'Male'),
('d001', 'S.M. Sha Newaz', '30', 'Medicine', 'MBBS,PLAB,MRCP', 'cadriac', '1000', 'newaz@pmain.com', '01735648726', 'Somewhare', 'Male'),
('d1020', 'Hasib', '26', 'Neourology', 'MBBS', 'abc', '900', 'nill30@gmail.com', '0187774545', 'Mirpur-10', 'Male'),
('d1589', 'Abdullah', '36', 'Medicine', 'MBBS', 'Medicine', '700', 'abdullah@gmail.com', '01488555', 'Gazipur', 'Male'),
('d2233', 'Talukder Bristy', '21', 'Dental', 'MBBS,FCPSC', 'Dentist', '1200', 'bristy@gmail.com', '0155888', 'Basundhara', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('pntJahid', '10119239', 2),
('d001', '12090968', 1),
('e001', '12345', 0),
('d2233', '13729678', 1),
('d0002', '14670196', 1),
('d1589', '15635152', 1),
('pntAIUB', '15837952', 2),
('pntTest', '18086629', 2),
('pntSir', '18273669', 2),
('pntNazib', '18506418', 2),
('pntKauser', '19094142', 2),
('d1020', '19874523', 1),
('admin', 'admin', 0);

-- --------------------------------------------------------

--
-- Table structure for table `patientinfo`
--

CREATE TABLE `patientinfo` (
  `patientid` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `patientname` varchar(20) NOT NULL,
  `age` varchar(6) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `address` varchar(40) NOT NULL,
  `doctorId` varchar(30) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patientinfo`
--

INSERT INTO `patientinfo` (`patientid`, `password`, `patientname`, `age`, `gender`, `contact`, `address`, `doctorId`, `date`) VALUES
('pntJahid', '10119239', 'Jahid', '21', 'Male', '0147888', 'djcbdjkcb', 'd001', '24.02.19'),
('pntNazib', '18506418', 'Nazib', '22', 'Male', '01775552`', 'dvknjf', 'd1050', '14.02.19'),
('pntSir', '18273669', 'Sir', '30', 'male', '01777', 'djkbd', 'd1050', '20.05.19');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `Time` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`Time`) VALUES
('10.00-10.30 am'),
('10.30-11.00 am'),
('11.00-11.30am'),
('11.30-12.00 pm'),
('12.00-12.30pm'),
('2.30-3.00 pm'),
('3.00-3.30 pm'),
('3.30-4.00 pm'),
('4.00-4.30 pm'),
('4.30-5.00 pm'),
('5.00-5.30 pm'),
('5.30-6.00 pm'),
('6.00-6.30 pm'),
('6.30-7.00 pm'),
('7.00-7.30 pm'),
('7.30-8.00 pm'),
('8.00-8.30 pm'),
('8.30-9.00 pm'),
('9.00 - 9.30 am'),
('9.30 - 10.00 am');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctorinfo`
--
ALTER TABLE `doctorinfo`
  ADD UNIQUE KEY `id` (`doctorId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `Upass` (`password`);

--
-- Indexes for table `patientinfo`
--
ALTER TABLE `patientinfo`
  ADD UNIQUE KEY `ID` (`patientid`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD UNIQUE KEY `UTime` (`Time`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
