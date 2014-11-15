# Host: localhost  (Version: 5.6.21)
# Date: 2014-11-05 16:42:52
# Generator: MySQL-Front 5.3  (Build 4.123)

CREATE DATABASE `pacs` /*!40100 DEFAULT CHARACTER SET utf8 */;

#
# Structure for table "approval"
#

CREATE TABLE `pacs`.`approval` (
  `Ai_ID` int(11) NOT NULL AUTO_INCREMENT,
  `As_Type` int(11) DEFAULT NULL,
  `As_Name` varchar(255) DEFAULT NULL,
  `As_ApplyUser` varchar(255) DEFAULT NULL,
  `As_HandleUser` varchar(255) DEFAULT NULL,
  `Hs_ID` varchar(255) DEFAULT NULL,
  `Es_ID` varchar(255) DEFAULT NULL,
  `As_Status` varchar(255) DEFAULT NULL,
  `As_ApplyTime` datetime DEFAULT NULL,
  `Ad_HandleTime` datetime DEFAULT NULL,
  `Ad_Desp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Ai_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "expert"
#

CREATE TABLE `pacs`.`expert` (
  `Es_ID` varchar(64) NOT NULL,
  `Es_Name` varchar(64) DEFAULT NULL,
  `Es_Sex` varchar(4) DEFAULT NULL,
  `Es_Age` varchar(16) DEFAULT NULL,
  `Es_PhoneNO` varchar(16) DEFAULT NULL,
  `Es_TelephoneNO` varchar(32) DEFAULT NULL,
  `Es_Email` varchar(64) DEFAULT NULL,
  `Es_QQ` varchar(16) DEFAULT NULL,
  `Es_WeiXin` varchar(32) DEFAULT NULL,
  `Es_Resume` text,
  `Eb_ExPhoto` blob,
  `Es_JobTitle` varchar(32) DEFAULT NULL,
  `Es_WorkPlace` varchar(128) DEFAULT NULL,
  `Es_Province` varchar(32) DEFAULT NULL,
  `Es_City` varchar(32) DEFAULT NULL,
  `Es_County` varchar(32) DEFAULT NULL,
  `Es_Expertise` varchar(128) DEFAULT NULL,
  `Es_Remark` text,
  `Eb_SignName` blob,
  `Ei_Authority` smallint(16) DEFAULT NULL,
  `Ei_State` smallint(16) DEFAULT NULL,
  `Ei_OnlineState` smallint(16) DEFAULT NULL,
  `Ed_Login` datetime DEFAULT NULL,
  `Ed_Apply` datetime DEFAULT NULL,
  `Ed_Reg` datetime DEFAULT NULL,
  `Es_Auditor` varchar(64) DEFAULT NULL,
  `Ei_CTCount` smallint(16) DEFAULT NULL,
  `Ei_DRCount` smallint(16) DEFAULT NULL,
  `Ei_MRCount` smallint(16) DEFAULT NULL,
  `Es_Reserve1` varchar(64) DEFAULT NULL,
  `Es_Reserve2` varchar(128) DEFAULT NULL,
  `Ei_Reserve3` int(32) DEFAULT NULL,
  `Ei_Reserve4` smallint(16) DEFAULT NULL,
  PRIMARY KEY (`Es_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "hospital"
#

CREATE TABLE `pacs`.`hospital` (
  `Hs_ID` varchar(64) NOT NULL,
  `Hs_Name` varchar(64) DEFAULT NULL,
  `Hs_Province` varchar(64) DEFAULT NULL,
  `Hs_City` varchar(32) DEFAULT NULL,
  `Hs_County` varchar(32) DEFAULT NULL,
  `Hs_Address` varchar(255) DEFAULT NULL,
  `Hs_HospitalPhone` varchar(16) DEFAULT NULL,
  `Hs_ContactWay` varchar(32) DEFAULT NULL,
  `Hs_Contacts` varchar(64) DEFAULT NULL,
  `Hs_ContactsPhone` varchar(255) DEFAULT NULL,
  `Hs_Rank` varchar(32) DEFAULT NULL,
  `Hs_Resume` text,
  `Hs_Remark` text,
  `Hd_Apply` datetime DEFAULT NULL,
  `Hd_Reg` datetime DEFAULT NULL,
  `Hs_Auditor` varchar(64) DEFAULT NULL,
  `Hi_State` smallint(16) DEFAULT NULL,
  `Hi_Authority` smallint(16) DEFAULT NULL,
  `Hs_Reserve1` varchar(64) DEFAULT NULL,
  `Hs_Reserve2` varchar(128) DEFAULT NULL,
  `Hi_Reserve3` int(32) DEFAULT NULL,
  `Hi_Reserve4` smallint(16) DEFAULT NULL,
  PRIMARY KEY (`Hs_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "imagearchiving"
#

CREATE TABLE `pacs`.`imagearchiving` (
  `Pi_SerialNO` int(32) NOT NULL,
  `Hs_ID` varchar(64) NOT NULL,
  `Is_ImageAchName` varchar(255) NOT NULL,
  `Is_ImageID` varchar(64) DEFAULT NULL,
  `Is_Modality` varchar(16) DEFAULT NULL,
  `Ii_ImageNO` int(32) DEFAULT NULL,
  `Is_SOPInstanceUID` varchar(100) DEFAULT NULL,
  `Ii_SeriesID` int(32) DEFAULT NULL,
  `Is_SeriesDescription` varchar(255) DEFAULT NULL,
  `Is_SeriesUID` varchar(100) DEFAULT NULL,
  `Ii_ImageCount` smallint(16) DEFAULT NULL,
  `Ii_MinImageID` smallint(16) DEFAULT NULL,
  `Ii_MaxImageID` smallint(16) DEFAULT NULL,
  `Is_ImageSavePath` varchar(255) DEFAULT NULL,
  `Is_BodyPart` varchar(64) DEFAULT NULL,
  `Is_ProtocalName` varchar(64) DEFAULT NULL,
  `Is_OriImgName` varchar(255) NOT NULL,
  `Is_ImageCode` varchar(255) DEFAULT NULL,
  `Is_Reserve1` varchar(64) DEFAULT NULL,
  `Is_Reserve2` varchar(128) DEFAULT NULL,
  `Ii_Reserve3` int(32) DEFAULT NULL,
  `Ii_Reserve4` smallint(16) DEFAULT NULL,
  PRIMARY KEY (`Pi_SerialNO`,`Hs_ID`,`Is_ImageAchName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "link"
#

CREATE TABLE `pacs`.`link` (
  `Hs_ID` varchar(64) NOT NULL,
  `Hs_Name` varchar(64) NOT NULL,
  `Es_ID` varchar(64) NOT NULL,
  `Es_Name` varchar(64) NOT NULL,
  `LinkTime` datetime DEFAULT NULL,
  `Auditor` varchar(64) DEFAULT NULL,
  `LinkState` smallint(16) DEFAULT NULL,
  PRIMARY KEY (`Es_ID`,`Hs_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "misp_oper_log"
#

CREATE TABLE `pacs`.`misp_oper_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `USER` varchar(255) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `OBJECT` varchar(255) DEFAULT NULL,
  `RESULT` varchar(255) DEFAULT NULL,
  `OPER_DESP` varchar(255) DEFAULT NULL,
  `OPER_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "misp_privilege"
#

CREATE TABLE `pacs`.`misp_privilege` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `master_type` varchar(20) NOT NULL,
  `master_value` varchar(255) NOT NULL,
  `access_obj_type` varchar(20) NOT NULL,
  `access_obj_value` varchar(50) NOT NULL,
  `operation` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "misp_privilege"
#
INSERT INTO `pacs`.`misp_privilege` VALUES (1,'ROLE','1','MENU','1',''),(2,'ROLE','1','MENU','2',''),(3,'ROLE','1','MENU','9',''),(4,'ROLE','1','MENU','10',''),(5,'ROLE','1','MENU','11',NULL),(6,'ROLE','2','MENU','1',NULL),(7,'ROLE','2','MENU','3',NULL),(8,'ROLE','2','MENU','4',NULL),(9,'ROLE','2','MENU','7',NULL),(10,'ROLE','2','MENU','9',NULL),(11,'ROLE','2','MENU','10',NULL),(12,'ROLE','2','MENU','11',NULL),(16,'ROLE','99','MENU','4',NULL),(17,'ROLE','99','MENU','5',NULL),(18,'ROLE','99','MENU','6',NULL),(19,'ROLE','99','MENU','7',NULL),(20,'ROLE','99','MENU','8',NULL),(21,'ROLE','99','MENU','9',NULL),(22,'ROLE','99','MENU','10',NULL),(23,'ROLE','99','MENU','11',NULL),(24,'ROLE','99','MENU','12',NULL),(25,'ROLE','99','MENU','13',NULL),(26,'ROLE','88','MENU','4',''),(27,'ROLE','88','MENU','5',NULL),(28,'ROLE','88','MENU','6',NULL),(29,'ROLE','88','MENU','7',NULL),(30,'ROLE','88','MENU','8',NULL),(31,'ROLE','88','MENU','9',NULL),(32,'ROLE','88','MENU','10',NULL),(33,'ROLE','88','MENU','11',NULL),(34,'ROLE','88','MENU','12',NULL),(35,'ROLE','88','MENU','13',NULL);




#
# Structure for table "misp_system_id_type"
#

CREATE TABLE `pacs`.`misp_system_id_type` (
  `NAME` varchar(20) NOT NULL,
  `STEP` int(11) NOT NULL,
  `LENGTH` int(11) NOT NULL,
  `INC_MODE` int(11) NOT NULL,
  `CURRENT_ID` int(11) NOT NULL,
  `PREFIX` varchar(255) DEFAULT NULL,
  `SUFFIX` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "misp_system_menu"
#

CREATE TABLE `pacs`.`misp_system_menu` (
  `MENU_ID` varchar(20) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `VALUE` varchar(50) NOT NULL,
  `TYPE` varchar(10) DEFAULT NULL,
  `ICON` varchar(50) DEFAULT NULL,
  `EXTERNAL` varchar(255) DEFAULT NULL,
  `FRESH` varchar(255) DEFAULT NULL,
  `URL` varchar(100) DEFAULT NULL,
  `PARENT_ID` varchar(20) DEFAULT NULL,
  `FUNCTION_ID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "misp_system_menu"
#

INSERT INTO `pacs`.`misp_system_menu` VALUES ('1','个人信息','个人信息',NULL,NULL,NULL,NULL,NULL,'0','1'),('10','诊断统计','诊断统计',NULL,NULL,NULL,NULL,'report/ReportManage','9','10'),('11','费用统计','费用统计',NULL,NULL,NULL,NULL,'report/ReportManage!costCount.action','9','11'),('12','日志管理','日志管理',NULL,NULL,NULL,NULL,NULL,'0','12'),('13','操作日志','操作日志',NULL,NULL,NULL,NULL,'log/LogManage','12','13'),('2','专家信息','专家信息',NULL,NULL,NULL,NULL,'ExpertManage!infoEdit.action','1','2'),('3','医院信息','医院信息',NULL,NULL,NULL,NULL,'HospitalManage!infoEdit.action','1','3'),('4','用户管理','用户管理',NULL,NULL,NULL,NULL,NULL,'0','4'),('5','系统用户','系统用户',NULL,NULL,NULL,NULL,'user/UserManage','4','5'),('6','修改申请','修改申请',NULL,NULL,NULL,NULL,'user/ApprovalManage','4','6'),('7','专家管理','专家管理',NULL,NULL,NULL,NULL,'user/ExpertManage','4','7'),('8','医院管理','医院管理',NULL,NULL,NULL,NULL,'user/HospitalManage','4','8'),('9','统计信息','统计信息',NULL,NULL,NULL,NULL,NULL,'0','9');


CREATE TABLE `pacs`.`patient` (
  `Pi_SerialNO` int(32) NOT NULL,
  `Hs_ID` varchar(64) NOT NULL,
  `Ps_PatientID` varchar(64) DEFAULT NULL,
  `Ps_Name` varchar(64) DEFAULT NULL,
  `Ps_EName` varchar(64) DEFAULT NULL,
  `Ps_Sex` varchar(4) DEFAULT NULL,
  `Ps_Birthday` varchar(10) DEFAULT NULL,
  `Ps_Age` varchar(16) DEFAULT NULL,
  `Ps_Modality` varchar(16) DEFAULT NULL,
  `Ps_StudyDescription` varchar(255) DEFAULT NULL,
  `Pi_StudyID` int(32) DEFAULT NULL,
  `Ps_StudyInstanceUID` varchar(128) DEFAULT NULL,
  `Ps_AccessionNO` varchar(64) DEFAULT NULL,
  `Ps_OperatorsName` varchar(64) DEFAULT NULL,
  `Ps_StudyDate` varchar(10) DEFAULT NULL,
  `Ps_StudyTime` varchar(10) DEFAULT NULL,
  `Pi_MaxSeriesNo` smallint(16) DEFAULT NULL,
  `Ps_ImageID` varchar(64) DEFAULT NULL,
  `Ps_Height` varchar(16) DEFAULT NULL,
  `Ps_Weight` varchar(16) DEFAULT NULL,
  `Pi_Marriage` smallint(16) DEFAULT NULL,
  `Ps_Nation` varchar(16) DEFAULT NULL,
  `Ps_Country` varchar(64) DEFAULT NULL,
  `Ps_Reserve1` varchar(64) DEFAULT NULL,
  `Ps_Reserve2` varchar(64) DEFAULT NULL,
  `Ps_Reserve3` varchar(128) DEFAULT NULL,
  `Ps_Reserve4` text,
  `Pi_Reserve5` int(32) DEFAULT NULL,
  `Pi_Reserve6` smallint(16) DEFAULT NULL,
  PRIMARY KEY (`Pi_SerialNO`,`Hs_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "report"
#

CREATE TABLE `pacs`.`report` (
  `Pi_SerialNO` int(32) NOT NULL,
  `Hs_ID` varchar(64) NOT NULL,
  `Rs_ReportNO` varchar(64) NOT NULL,
  `Rs_PatientID` varchar(64) DEFAULT NULL,
  `Rs_PatientName` varchar(64) DEFAULT NULL,
  `Rs_PatientSex` varchar(4) DEFAULT NULL,
  `Rs_PatientAge` varchar(16) DEFAULT NULL,
  `Rs_Modality` varchar(16) DEFAULT NULL,
  `Rs_Department` varchar(20) DEFAULT NULL,
  `Rs_HospitalNO` varchar(10) DEFAULT NULL,
  `Rs_BedNO` varchar(6) DEFAULT NULL,
  `Rs_BodyPart` varchar(64) DEFAULT NULL,
  `Rs_PreView` varchar(255) DEFAULT NULL,
  `Rs_Diagnosis` varchar(255) DEFAULT NULL,
  `Rs_StudyContent` text,
  `Rs_StudyConclusion` text,
  `Rs_ExStudyContent` text,
  `Rs_ExStudyConclusion` text,
  `Rs_ExStudyContentCode` varchar(255) DEFAULT NULL,
  `Rs_ExStudyConclusionCode` varchar(255) DEFAULT NULL,
  `Rd_StudyDate` datetime DEFAULT NULL,
  `Rd_ReportDate` datetime DEFAULT NULL,
  `Rd_ReviewDate` datetime DEFAULT NULL,
  `Rs_OperatorPhysician` varchar(64) DEFAULT NULL,
  `Rs_ReportPhysician` varchar(64) DEFAULT NULL,
  `Rs_ReviewPhysician` varchar(64) DEFAULT NULL,
  `Ri_ImageCount` smallint(16) DEFAULT NULL,
  `Rs_ImagePathWL` varchar(255) DEFAULT NULL,
  `Rd_ExApply` datetime DEFAULT NULL,
  `Rd_ExStartUpImg` datetime DEFAULT NULL,
  `Rd_ExEndUpImg` datetime DEFAULT NULL,
  `Rd_ExGetReport` datetime DEFAULT NULL,
  `Rd_ExReport` datetime DEFAULT NULL,
  `Rd_ExDownReport` datetime DEFAULT NULL,
  `Rs_ExApplyDoctor` varchar(64) DEFAULT NULL,
  `Rs_ExpertID`	varchar(64) DEFAULT NULL,
  `Rs_ExpertDoctor` varchar(64) DEFAULT NULL,
  `Ri_ExState` smallint(16) DEFAULT NULL,
  `Ri_ExReportState` smallint(16) DEFAULT NULL,
  `Rs_Positive` varchar(4) DEFAULT NULL,
  `Rs_Reserve1` varchar(64) DEFAULT NULL,
  `Rs_Reserve2` varchar(128) DEFAULT NULL,
  `Rs_Reserve3` varchar(255) DEFAULT NULL,
  `Rs_Reserve4` text,
  `Ri_Reserve5` int(32) DEFAULT NULL,
  `Ri_Reserve6` smallint(16) DEFAULT NULL,
  PRIMARY KEY (`Pi_SerialNO`,`Hs_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "user"
#

CREATE TABLE `pacs`.`user` (
  `Ui_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Us_Account` varchar(64) NOT NULL,
  `Us_PassWord` varchar(64) NOT NULL,
  `Ui_AccountType` int(32) DEFAULT NULL,
  `Ui_Grade` smallint(16) DEFAULT NULL,
  `Ud_RegDate` datetime DEFAULT NULL,
  PRIMARY KEY (`Ui_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `pacs`.`user` VALUES (1,'admin','1234',99,NULL,'2014-10-31 21:00:40');

CREATE VIEW `pacs`.`view_report` AS 
  select concat(`pacs`.`report`.`Hs_ID`,`pacs`.`report`.`Pi_SerialNO`) AS `id`,`pacs`.`report`.`Hs_ID` AS `Hs_ID`,`pacs`.`report`.`Pi_SerialNO` AS `Pi_SerialNO`,`pacs`.`report`.`Rs_ReportNO` AS `Rs_ReportNO`,`pacs`.`report`.`Rs_PatientID` AS `Rs_PatientID`,`pacs`.`report`.`Rs_PatientName` AS `Rs_PatientName`,`pacs`.`report`.`Rs_PatientSex` AS `Rs_PatientSex`,`pacs`.`report`.`Rs_PatientAge` AS `Rs_PatientAge`,`pacs`.`report`.`Rs_Modality` AS `Rs_Modality`,`pacs`.`report`.`Rs_Department` AS `Rs_Department`,`pacs`.`report`.`Rs_HospitalNO` AS `Rs_HospitalNO`,`pacs`.`report`.`Rs_BedNO` AS `Rs_BedNO`,`pacs`.`report`.`Rs_BodyPart` AS `Rs_BodyPart`,`pacs`.`report`.`Rs_PreView` AS `Rs_PreView`,`pacs`.`report`.`Rs_Diagnosis` AS `Rs_Diagnosis`,`pacs`.`report`.`Rs_StudyContent` AS `Rs_StudyContent`,`pacs`.`report`.`Rs_StudyConclusion` AS `Rs_StudyConclusion`,`pacs`.`report`.`Rs_ExStudyContent` AS `Rs_ExStudyContent`,`pacs`.`report`.`Rs_ExStudyConclusion` AS `Rs_ExStudyConclusion`,`pacs`.`report`.`Rs_ExStudyContentCode` AS `Rs_ExStudyContentCode`,`pacs`.`report`.`Rs_ExStudyConclusionCode` AS `Rs_ExStudyConclusionCode`,`pacs`.`report`.`Rd_StudyDate` AS `Rd_StudyDate`,`pacs`.`report`.`Rd_ReportDate` AS `Rd_ReportDate`,`pacs`.`report`.`Rd_ReviewDate` AS `Rd_ReviewDate`,`pacs`.`report`.`Rs_OperatorPhysician` AS `Rs_OperatorPhysician`,`pacs`.`report`.`Rs_ReportPhysician` AS `Rs_ReportPhysician`,`pacs`.`report`.`Rs_ReviewPhysician` AS `Rs_ReviewPhysician`,`pacs`.`report`.`Ri_ImageCount` AS `Ri_ImageCount`,`pacs`.`report`.`Rs_ImagePathWL` AS `Rs_ImagePathWL`,`pacs`.`report`.`Rd_ExApply` AS `Rd_ExApply`,`pacs`.`report`.`Rd_ExStartUpImg` AS `Rd_ExStartUpImg`,`pacs`.`report`.`Rd_ExEndUpImg` AS `Rd_ExEndUpImg`,`pacs`.`report`.`Rd_ExReport` AS `Rd_ExReport`,`pacs`.`report`.`Rd_ExDownReport` AS `Rd_ExDownReport`,`pacs`.`report`.`Rs_ExApplyDoctor` AS `Rs_ExApplyDoctor`,`pacs`.`report`.`Rs_ExpertID` AS `Rs_ExpertID`,`pacs`.`report`.`Ri_ExState` AS `Ri_ExState`,`pacs`.`report`.`Ri_ExReportState` AS `Ri_ExReportState`,`pacs`.`expert`.`Es_Name` AS `Es_Name`,`pacs`.`expert`.`Es_PhoneNO` AS `Es_PhoneNO`,`pacs`.`hospital`.`Hs_Name` AS `Hs_Name`,`pacs`.`hospital`.`Hs_ContactsPhone` AS `Hs_ContactsPhone` from ((`pacs`.`report` join `pacs`.`expert`) join `pacs`.`hospital`) where (`pacs`.`report`.`Rs_ExpertID` = `pacs`.`expert`.`Es_ID`) and (`pacs`.`report`.`Hs_ID` = `pacs`.`hospital`.`Hs_ID`);
  