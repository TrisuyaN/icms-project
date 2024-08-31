-- MySQL dump 10.13  Distrib 8.0.37, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: scdb_demo2
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `anomalies`
--
-- 删除已有的 anomalies 表
DROP TABLE IF EXISTS `anomalies`;

-- 创建 anomalies 表
CREATE TABLE `anomalies`
(
    `AnomalyID`        VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                         NOT NULL,
    `LocationID`       INT                                                                                  NOT NULL,
    `ErrorMessage`     TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                                NOT NULL,
    `Category`         ENUM ('水', '电') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                   NOT NULL,
    `UrgencyStatus`    ENUM ('低', '中', '高') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci             NOT NULL,
    `ProcessingStatus` ENUM ('未处理', '处理中', '已处理') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `RecordTime`       TIMESTAMP                                                                            NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`AnomalyID`) USING BTREE,
    KEY `LocationID` (`LocationID`) USING BTREE,
    CONSTRAINT `anomalies_ibfk_1` FOREIGN KEY (`LocationID`) REFERENCES `locationinfo` (`PointID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_anomalies`;

-- 创建序列表
CREATE TABLE `seq_anomalies`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_anomalies` (`next_id`)
VALUES (10000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_anomalies`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_anomalies
    BEFORE INSERT
    ON `anomalies`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_anomalies` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 AnomalyID
    SET NEW.AnomalyID = CONCAT('KY', LPAD(new_id, 5, '0'));
END$$

DELIMITER ;

-- 插入示例数据
INSERT INTO `anomalies` (`LocationID`, `ErrorMessage`, `Category`, `UrgencyStatus`, `ProcessingStatus`, `RecordTime`)
VALUES (40001, '水管漏水', '水', '中', '未处理', '2024-08-27 04:00:00'),
       (40002, '电缆损坏', '电', '高', '处理中', '2024-08-27 04:05:00'),
       (40003, '水表故障', '水', '低', '已处理', '2024-08-27 04:10:00'),
       (40004, '电表异常', '电', '中', '未处理', '2024-08-27 04:15:00'),
       (40005, '水泵噪音大', '水', '高', '处理中', '2024-08-27 04:20:00'),
       (40006, '电线短路', '电', '中', '已处理', '2024-08-27 04:25:00'),
       (40007, '水阀漏水', '水', '低', '未处理', '2024-08-27 04:30:00'),
       (40008, '电压不稳', '电', '高', '处理中', '2024-08-27 04:35:00'),
       (40009, '水管堵塞', '水', '中', '已处理', '2024-08-27 04:40:00'),
       (40010, '电气设备故障', '电', '低', '未处理', '2024-08-27 04:45:00'),
       (40011, '水池漏水', '水', '高', '处理中', '2024-08-27 04:50:00'),
       (40012, '电缆老化', '电', '中', '已处理', '2024-08-27 04:55:00'),
       (40013, '水压不稳', '水', '低', '未处理', '2024-08-27 05:00:00'),
       (40014, '电路不通', '电', '高', '处理中', '2024-08-27 05:05:00'),
       (40015, '水龙头漏水', '水', '中', '已处理', '2024-08-27 05:10:00'),
       (40016, '电气设备超负荷', '电', '低', '未处理', '2024-08-27 05:15:00'),
       (40017, '水表漏水', '水', '高', '处理中', '2024-08-27 05:20:00'),
       (40018, '电线接触不良', '电', '中', '已处理', '2024-08-27 05:25:00'),
       (40019, '水泵故障', '水', '低', '未处理', '2024-08-27 05:30:00'),
       (40020, '电力中断', '电', '高', '处理中', '2024-08-27 05:35:00'),
       (40021, '水管生锈', '水', '中', '已处理', '2024-08-27 05:40:00'),
       (40022, '电压过高', '电', '低', '未处理', '2024-08-27 05:45:00'),
       (40023, '水源污染', '水', '高', '处理中', '2024-08-27 05:50:00'),
       (40024, '电气短路', '电', '中', '已处理', '2024-08-27 05:55:00'),
       (40025, '水流量不足', '水', '低', '未处理', '2024-08-27 06:00:00'),
       (40026, '电缆损伤', '电', '高', '处理中', '2024-08-27 06:05:00'),
       (40027, '水泵漏油', '水', '中', '已处理', '2024-08-27 06:10:00'),
       (40028, '电力故障', '电', '低', '未处理', '2024-08-27 06:15:00'),
       (40029, '水管破裂', '水', '高', '处理中', '2024-08-27 06:20:00'),
       (40030, '电气元件老化', '电', '中', '已处理', '2024-08-27 06:25:00'),
       (40031, '水质异常', '水', '低', '未处理', '2024-08-27 06:30:00'),
       (40032, '电气设备故障', '电', '高', '处理中', '2024-08-27 06:35:00'),
       (40033, '水管破损', '水', '中', '已处理', '2024-08-27 06:40:00'),
       (40034, '电表故障', '电', '低', '未处理', '2024-08-27 06:45:00'),
       (40035, '水阀故障', '水', '高', '处理中', '2024-08-27 06:50:00'),
       (40036, '电缆损坏', '电', '中', '已处理', '2024-08-27 06:55:00'),
       (40037, '水池渗漏', '水', '低', '未处理', '2024-08-27 07:00:00'),
       (40038, '电线老化', '电', '高', '处理中', '2024-08-27 07:05:00'),
       (40039, '水管堵塞', '水', '中', '已处理', '2024-08-27 07:10:00'),
       (40040, '电力不足', '电', '低', '未处理', '2024-08-27 07:15:00'),
       (40041, '水龙头坏了', '水', '高', '处理中', '2024-08-27 07:20:00'),
       (40042, '电缆短路', '电', '中', '已处理', '2024-08-27 07:25:00'),
       (40043, '水管老化', '水', '低', '未处理', '2024-08-27 07:30:00'),
       (40044, '电表异常', '电', '高', '处理中', '2024-08-27 07:35:00'),
       (40045, '水泵故障', '水', '中', '已处理', '2024-08-27 07:40:00'),
       (40046, '电气设备问题', '电', '低', '未处理', '2024-08-27 07:45:00'),
       (40047, '水阀漏水', '水', '高', '处理中', '2024-08-27 07:50:00'),
       (40048, '电线断裂', '电', '中', '已处理', '2024-08-27 07:55:00'),
       (40049, '水质不佳', '水', '低', '未处理', '2024-08-27 08:00:00'),
       (40050, '电力波动', '电', '高', '处理中', '2024-08-27 08:05:00');

--
-- Table structure for table `complaintinfo`
--
-- 删除已有的 complaintinfo 表
DROP TABLE IF EXISTS `complaintinfo`;

-- 创建 complaintinfo 表
CREATE TABLE `complaintinfo`
(
    `ID`              VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                                             NOT NULL,
    `Content`         TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                                                    NOT NULL,
    `ComplaintStatus` ENUM ('Pending', 'In Progress', 'Resolved', 'Rejected') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `ComplainantID`   VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                                             NOT NULL,
    `Handler`         VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    `Title`           VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                                            NOT NULL,
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_complaintinfo`;

-- 创建序列表
CREATE TABLE `seq_complaintinfo`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_complaintinfo` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_complaintinfo`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_complaintinfo
    BEFORE INSERT
    ON `complaintinfo`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_complaintinfo` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 ID
    SET NEW.ID = CONCAT('TS', LPAD(new_id, 6, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 ID）
INSERT INTO `complaintinfo` (`Content`, `ComplaintStatus`, `ComplainantID`, `Handler`, `Title`)
VALUES ('The issue is with the building maintenance.', 'Pending', 'Anonymous123', 'John Doe', '示范'),
       ('电梯经常出现故障，需要维修。', 'In Progress', '匿名用户002', '李娜', '示例'),
       ('小区绿化不良，希望加强管理。', 'Resolved', '匿名用户003', '王磊', '示范'),
       ('停车位紧张，建议增加车位。', 'Rejected', '匿名用户004', '赵敏', '示例'),
       ('楼道灯光不亮，请尽快修复。', 'Pending', '匿名用户005', '孙杰', '示范'),
       ('水管漏水严重，影响使用。', 'In Progress', '匿名用户006', '刘婷', '示例'),
       ('空调噪音过大，请检查。', 'Resolved', '匿名用户007', '周强', '示范'),
       ('垃圾分类不规范，建议加强宣传。', 'Rejected', '匿名用户008', '吴倩', '示例'),
       ('房屋内墙体出现裂缝，请处理。', 'Pending', '匿名用户009', '郑芳', '示范'),
       ('社区噪音扰民，请采取措施。', 'In Progress', '匿名用户010', '陈龙', '示范'),
       ('健身房设备损坏，急需修理。', 'Resolved', '匿名用户011', '杨帆', '示范'),
       ('游泳池水质不佳，请检查处理。', 'Rejected', '匿名用户012', '张蕾', '示范'),
       ('楼顶花园设施破损，需要修理。', 'Pending', '匿名用户013', '李明', '示范'),
       ('社区活动经费使用不透明，希望改善。', 'In Progress', '匿名用户014', '王敏', '示范'),
       ('小区门禁系统经常失效，请解决。', 'Resolved', '匿名用户015', '赵阳', '示范'),
       ('楼道卫生间设施损坏，请修复。', 'Rejected', '匿名用户016', '孙丽', '示范'),
       ('物业服务态度不好，希望改进。', 'Pending', '匿名用户017', '刘军', '示范'),
       ('电梯按钮失灵，影响使用。', 'In Progress', '匿名用户018', '周静', '示范'),
       ('小区内绿化带杂草丛生，请清理。', 'Resolved', '匿名用户019', '吴强', '示范'),
       ('车库门常出现故障，请修理。', 'Rejected', '匿名用户020', '郑军', '示范'),
       ('园区内步道灯光不足，请改善。', 'Pending', '匿名用户021', '陈艳', '示范'),
       ('小区内路面破损严重，请修复。', 'In Progress', '匿名用户022', '杨华', '示范'),
       ('房屋漏水严重，请尽快处理。', 'Resolved', '匿名用户023', '张勇', '示范'),
       ('空调系统经常失效，需要检查。', 'Rejected', '匿名用户024', '李霞', '示范'),
       ('小区安保工作不到位，希望加强。', 'Pending', '匿名用户025', '王刚', '示范'),
       ('物业收费不透明，建议公开。', 'In Progress', '匿名用户026', '赵丽', '示范'),
       ('游乐场设施损坏，请尽快修复。', 'Resolved', '匿名用户027', '孙梅', '示范'),
       ('楼道地面不平整，存在安全隐患。', 'Rejected', '匿名用户028', '刘娜', '示范'),
       ('小区垃圾清理不及时，请改善。', 'Pending', '匿名用户029', '周波', '示范'),
       ('电梯检修不及时，请尽快解决。', 'In Progress', '匿名用户030', '吴霞', '示范'),
       ('停车场照明不足，请增加灯光。', 'Resolved', '匿名用户031', '郑艳', '示范'),
       ('物业管理人员不热情，希望改善。', 'Rejected', '匿名用户032', '陈明', '示范'),
       ('房屋门锁出现问题，请修理。', 'Pending', '匿名用户033', '杨敏', '示范'),
       ('小区围墙需要重新粉刷。', 'In Progress', '匿名用户034', '张丽', '示范'),
       ('健身房器材维护不到位，请加强管理。', 'Resolved', '匿名用户035', '李静', '示范'),
       ('小区内流浪动物较多，请处理。', 'Rejected', '匿名用户036', '王超', '示范'),
       ('花园内草坪修剪不及时，请处理。', 'Pending', '匿名用户037', '赵磊', '示范'),
       ('门禁系统故障频繁，请检查。', 'In Progress', '匿名用户038', '孙芳', '示范'),
       ('电梯运行不稳定，请尽快修理。', 'Resolved', '匿名用户039', '刘丽', '示范'),
       ('公共设施损坏严重，请修复。', 'Rejected', '匿名用户040', '周平', '示范'),
       ('车库地面油污较多，请清理。', 'Pending', '匿名用户041', '吴雷', '示范'),
       ('小区内交通标志不清晰，请更新。', 'In Progress', '匿名用户042', '郑强', '示范'),
       ('园区内噪音扰民，请处理。', 'Resolved', '匿名用户043', '陈美', '示范'),
       ('楼道地面滑，存在安全隐患。', 'Rejected', '匿名用户044', '杨洁', '示范'),
       ('社区内绿化带杂草丛生，请清除。', 'Pending', '匿名用户045', '张辉', '示范'),
       ('健身房设施老旧，请更新。', 'In Progress', '匿名用户046', '李华', '示范'),
       ('小区路面有坑洼，请尽快修复。', 'Resolved', '匿名用户047', '王磊', '示范'),
       ('空调外机噪音过大，请处理。', 'Rejected', '匿名用户048', '赵军', '示范'),
       ('物业收费不合理，请进行调整。', 'Pending', '匿名用户049', '孙丽', '示范'),
       ('楼道墙面有裂缝，请修复。', 'In Progress', '匿名用户050', '刘洋', '示范'),
       ('楼栋维修问题，请尽快处理。', 'Pending', '匿名用户001', '张伟', '示范');

-- 结束插入

--
-- Table structure for table `elevatorentries`
--
-- 删除已有的 elevatorentries 表
DROP TABLE IF EXISTS `elevatorentries`;

-- 创建 elevatorentries 表
CREATE TABLE `elevatorentries`
(
    `EntryID`   VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `MemberID`  INT(8) UNSIGNED ZEROFILL                                     NOT NULL,
    `EntryTime` DATETIME                                                     NOT NULL,
    PRIMARY KEY (`EntryID`) USING BTREE,
    KEY `MemberID` (`MemberID`) USING BTREE,
    CONSTRAINT `elevatorentries_ibfk_1` FOREIGN KEY (`MemberID`) REFERENCES `members` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_elevatorentries`;

-- 创建序列表
CREATE TABLE `seq_elevatorentries`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_elevatorentries` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_elevatorentries`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_elevatorentries
    BEFORE INSERT
    ON `elevatorentries`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_elevatorentries` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 EntryID
    SET NEW.EntryID = CONCAT('DC', LPAD(new_id, 6, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 EntryID）
INSERT INTO `elevatorentries` (`MemberID`, `EntryTime`)
VALUES (10000001, '2024-08-26 08:30:00'),
       (10000002, '2024-08-26 08:35:00'),
       (10000003, '2024-08-26 08:40:00'),
       (10000004, '2024-08-26 08:45:00'),
       (10000005, '2024-08-26 08:50:00'),
       (10000006, '2024-08-26 08:55:00'),
       (10000007, '2024-08-26 09:00:00'),
       (10000008, '2024-08-26 09:05:00'),
       (10000009, '2024-08-26 09:10:00'),
       (10000010, '2024-08-26 09:15:00'),
       (10000011, '2024-08-26 09:20:00'),
       (10000012, '2024-08-26 09:25:00'),
       (10000013, '2024-08-26 09:30:00'),
       (10000014, '2024-08-26 09:35:00'),
       (10000015, '2024-08-26 09:40:00'),
       (10000016, '2024-08-26 09:45:00'),
       (10000017, '2024-08-26 09:50:00'),
       (10000018, '2024-08-26 09:55:00'),
       (10000019, '2024-08-26 10:00:00'),
       (10000020, '2024-08-26 10:05:00'),
       (10000021, '2024-08-26 10:10:00'),
       (10000022, '2024-08-26 10:15:00'),
       (10000023, '2024-08-26 10:20:00'),
       (10000024, '2024-08-26 10:25:00'),
       (10000025, '2024-08-26 10:30:00'),
       (10000026, '2024-08-26 10:35:00'),
       (10000027, '2024-08-26 10:40:00'),
       (10000028, '2024-08-26 10:45:00'),
       (10000029, '2024-08-26 10:50:00'),
       (10000030, '2024-08-26 10:55:00'),
       (10000031, '2024-08-26 11:00:00');

-- 结束插入

--
-- Table structure for table `employeeinfo`
--

-- 删除已有的 employeeinfo 表
DROP TABLE IF EXISTS `employeeinfo`;

-- 创建 employeeinfo 表
CREATE TABLE `employeeinfo`
(
    `EmployeeID`  VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                       NOT NULL,
    `Name`        VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                      NOT NULL,
    `Position`    ENUM ('超级管理员','保安','保洁') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `Status`      ENUM ('在职','离职','休假') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci       NOT NULL,
    `Account`     VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                       NOT NULL,
    `Password`    VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                      NOT NULL,
    `PhoneNumber` VARCHAR(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                       NOT NULL,
    `HireDate`    DATE                                                                               NOT NULL,
    `LastLogin`   TIMESTAMP                                                                          NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`EmployeeID`) USING BTREE,
    UNIQUE KEY `Account` (`Account`) USING BTREE,
    UNIQUE KEY `PhoneNumber` (`PhoneNumber`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_employeeinfo`;

-- 创建序列表
CREATE TABLE `seq_employeeinfo`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_employeeinfo` (`next_id`)
VALUES (10000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_employeeinfo`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_employeeinfo
    BEFORE INSERT
    ON `employeeinfo`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_employeeinfo` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 EmployeeID
    SET NEW.EmployeeID = CONCAT('YG', LPAD(new_id, 5, '0'));
END$$

DELIMITER ;

-- 插入示例数据
INSERT INTO `employeeinfo` (`Name`, `Position`, `Status`, `Account`, `Password`, `PhoneNumber`, `HireDate`, `LastLogin`)
VALUES ('张三', '超级管理员', '在职', 'zhangsan', 'hashedpassword123', '13800138000', '2024-08-01',
        '2024-08-27 01:23:05'),
       ('李娜丽', '保安', '在职', 'guard1', 'password123', '18532510002', '2023-02-10', '2024-08-28 01:40:08');


--
-- Table structure for table `extremeweather`
--
-- 删除已有的 extremeweather 表
DROP TABLE IF EXISTS `extremeweather`;

-- 创建 extremeweather 表
CREATE TABLE `extremeweather`
(
    `WeatherID`        VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                           NOT NULL,
    `WeatherName`      VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                          NOT NULL,
    `WarningType`      ENUM ('蓝色', '黄色', '橙色', '红色') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `ResponseMeasures` TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                                  NOT NULL,
    `ExpectedTime`     DATETIME                                                                               NOT NULL,
    PRIMARY KEY (`WeatherID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_extremeweather`;

-- 创建序列表
CREATE TABLE `seq_extremeweather`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_extremeweather` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_extremeweather`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_extremeweather
    BEFORE INSERT
    ON `extremeweather`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_extremeweather` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 WeatherID
    SET NEW.WeatherID = CONCAT('C', LPAD(new_id, 6, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 WeatherID）
INSERT INTO `extremeweather` (`WeatherName`, `WarningType`, `ResponseMeasures`, `ExpectedTime`)
VALUES ('台风', '红色', '请提前做好防风准备，确保安全，避免外出。', '2024-09-15 14:00:00'),
       ('暴雨', '橙色', '加强排水系统检查，避免低洼区域聚集雨水。', '2024-08-20 10:00:00'),
       ('极端高温', '红色', '减少户外活动，多喝水，避免中暑。', '2024-08-25 12:00:00'),
       ('寒潮', '橙色', '注意保暖，防止冻伤和感冒。', '2024-08-30 18:00:00'),
       ('大雾', '黄色', '提高警惕，减少不必要的出行，注意交通安全。', '2024-09-05 08:00:00'),
       ('冰雹', '红色', '避免在户外停留，检查房屋和汽车的保护措施。', '2024-09-10 15:00:00'),
       ('雷暴', '橙色', '远离高大建筑物，避免户外活动。', '2024-09-15 16:00:00'),
       ('强风', '红色', '确保窗户门板牢固，远离易被风吹倒的物品。', '2024-09-20 20:00:00'),
       ('沙尘暴', '黄色', '佩戴口罩，尽量减少外出，保护呼吸道。', '2024-09-25 09:00:00'),
       ('洪水', '红色', '尽量到高处避难，避免涉水行驶。', '2024-09-30 11:00:00'),
       ('大雪', '橙色', '清理积雪，确保出行安全，防止滑倒。', '2024-10-05 07:00:00'),
       ('热浪', '红色', '待在凉爽的环境中，避免中暑。', '2024-10-10 13:00:00'),
       ('暴风雪', '橙色', '检查供暖设备，保持室内温暖，尽量避免出门。', '2024-10-15 14:00:00'),
       ('强降温', '黄色', '注意天气变化，及时调整穿衣。', '2024-10-20 06:00:00'),
       ('霜冻', '橙色', '防止冻伤，检查水管和电线的防护。', '2024-10-25 10:00:00'),
       ('雷电', '黄色', '远离电子设备，避免雷击。', '2024-11-01 17:00:00'),
       ('强降雨', '红色', '做好防洪准备，检查排水系统。', '2024-11-10 08:00:00'),
       ('极端寒冷', '橙色', '注意保暖，减少户外活动。', '2024-11-15 19:00:00'),
       ('极端高湿', '黄色', '保持室内通风，防止湿气损害物品。', '2024-11-20 12:00:00'),
       ('龙卷风', '红色', '寻找安全的避难所，远离窗户和门。', '2024-11-25 14:00:00'),
       ('沙尘', '黄色', '佩戴口罩，尽量减少外出。', '2024-12-01 09:00:00'),
       ('强雷阵雨', '橙色', '避免户外活动，注意雷电安全。', '2024-12-05 16:00:00'),
       ('极端干旱', '橙色', '节约用水，注意农业用水。', '2024-12-10 11:00:00'),
       ('大风', '黄色', '检查建筑物和车辆的固定，注意安全。', '2024-12-15 08:00:00'),
       ('霜冻', '红色', '加强防冻措施，检查农作物和供水设备。', '2024-12-20 07:00:00'),
       ('暴风雨', '橙色', '检查排水系统，避免出行。', '2024-12-25 13:00:00'),
       ('热浪', '红色', '保持凉爽，注意防暑。', '2025-01-01 15:00:00'),
       ('寒潮', '橙色', '注意保暖，预防感冒。', '2025-01-05 18:00:00'),
       ('强降雪', '红色', '清理积雪，确保道路畅通。', '2025-01-10 12:00:00'),
       ('极端高温', '橙色', '减少户外活动，注意水分补充。', '2025-01-15 10:00:00'),
       ('强雷暴', '红色', '避免户外活动，远离高大物体。', '2025-01-20 11:00:00'),
       ('大雾', '黄色', '注意交通安全，减少出行。', '2025-01-25 09:00:00'),
       ('暴风雪', '红色', '检查供暖设备，确保安全。', '2025-02-01 11:00:00'),
       ('极端降雨', '橙色', '做好防洪准备，检查排水系统。', '2025-02-05 14:00:00'),
       ('强风', '黄色', '固定户外物品，注意安全。', '2025-02-10 13:00:00'),
       ('极端寒冷', '红色', '增加取暖设备，确保安全。', '2025-02-15 16:00:00'),
       ('暴雨', '红色', '加强排水系统检查，避免低洼区域积水。', '2025-02-20 19:00:00'),
       ('极端干旱', '红色', '注意用水节约，保护水源。', '2025-02-25 08:00:00'),
       ('大雪', '橙色', '清理积雪，确保道路畅通。', '2025-03-01 12:00:00'),
       ('雷电', '红色', '避免接触电器，注意安全。', '2025-03-05 14:00:00'),
       ('寒潮', '红色', '防止冻伤，注意保暖。', '2025-03-10 10:00:00'),
       ('热浪', '橙色', '减少户外活动，补充水分。', '2025-03-15 11:00:00'),
       ('冰雹', '红色', '检查房屋和车辆保护，避免外出。', '2025-03-20 16:00:00'),
       ('大风', '橙色', '检查建筑物固定，注意安全。', '2025-03-25 12:00:00'),
       ('霜冻', '黄色', '检查水管防护，避免冻裂。', '2025-03-30 08:00:00'),
       ('雷暴', '红色', '避免户外活动，远离高大建筑。', '2025-04-01 14:00:00'),
       ('极端高温', '红色', '注意防暑，保持凉爽。', '2025-04-05 09:00:00'),
       ('沙尘暴', '黄色', '佩戴口罩，减少外出。', '2025-04-10 10:00:00'),
       ('大雾', '橙色', '注意交通安全，减少出行。', '2025-04-15 08:00:00'),
       ('暴风雪', '红色', '检查供暖设备，确保安全。', '2025-04-20 14:00:00');

-- 结束插入

--
-- Table structure for table `fallingobjects`
--
-- 删除已有的 fallingobjects 表
DROP TABLE IF EXISTS `fallingobjects`;

-- 创建 fallingobjects 表
CREATE TABLE `fallingobjects`
(
    `IncidentID`        VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci               NOT NULL,
    `Status`            ENUM ('未发生', '已发生') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `PropertyID`        INT                                                                        NOT NULL,
    `ResidentID`        INT(8) UNSIGNED ZEROFILL                                                   NOT NULL,
    `InjuryDescription` TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
    `IncidentDate`      TIMESTAMP                                                                  NULL DEFAULT CURRENT_TIMESTAMP,
    `handler`           VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                   DEFAULT NULL,
    `handled_at`        DATETIME                                                                        DEFAULT NULL,
    PRIMARY KEY (`IncidentID`) USING BTREE,
    KEY `PropertyID` (`PropertyID`) USING BTREE,
    KEY `ResidentID` (`ResidentID`) USING BTREE,
    CONSTRAINT `fallingobjects_ibfk_1` FOREIGN KEY (`PropertyID`) REFERENCES `propertyinfo` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `fallingobjects_ibfk_2` FOREIGN KEY (`ResidentID`) REFERENCES `members` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_fallingobjects`;

-- 创建序列表
CREATE TABLE `seq_fallingobjects`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_fallingobjects` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_fallingobjects`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_fallingobjects
    BEFORE INSERT
    ON `fallingobjects`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_fallingobjects` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 IncidentID
    SET NEW.IncidentID = CONCAT('GK', LPAD(new_id, 6, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 IncidentID）
INSERT INTO `fallingobjects` (`Status`, `PropertyID`, `ResidentID`, `InjuryDescription`, `IncidentDate`, `handler`,
                              `handled_at`)
VALUES ('已发生', 33, 10000001, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 34, 10000002, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 35, 10000003, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 36, 10000004, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 37, 10000005, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 38, 10000006, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 39, 10000007, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 40, 10000008, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 41, 10000009, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 42, 10000010, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 43, 10000011, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 44, 10000012, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 45, 10000013, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 46, 10000014, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 47, 10000015, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 48, 10000016, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 49, 10000017, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 50, 10000018, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 51, 10000019, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 52, 10000020, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 53, 10000021, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 54, 10000022, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 55, 10000023, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 56, 10000024, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 57, 10000025, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 58, 10000026, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 59, 10000027, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 60, 10000028, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 33, 10000029, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 34, 10000030, NULL, '2024-08-28 06:51:37', NULL, NULL),
       ('已发生', 35, 10000031, NULL, '2024-08-28 06:51:37', NULL, NULL);

-- 结束插入

--
-- Table structure for table `firehydrants`
--
-- 删除已有的 firehydrants 表
DROP TABLE IF EXISTS `firehydrants`;

-- 创建 firehydrants 表
CREATE TABLE `firehydrants`
(
    `HydrantID`          VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `LocationID`         INT                                                           NOT NULL,
    `LastInspectionDate` DATE                                                          NOT NULL,
    `NextInspectionDate` DATE                                                          NOT NULL,
    `Inspector`          VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `IsQualified`        TINYINT(1)                                                    NOT NULL,
    PRIMARY KEY (`HydrantID`) USING BTREE,
    KEY `LocationID` (`LocationID`) USING BTREE,
    CONSTRAINT `firehydrants_ibfk_1` FOREIGN KEY (`LocationID`) REFERENCES `locationinfo` (`PointID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_firehydrants`;

-- 创建序列表
CREATE TABLE `seq_firehydrants`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_firehydrants` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_firehydrants`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_firehydrants
    BEFORE INSERT
    ON `firehydrants`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_firehydrants` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 HydrantID
    SET NEW.HydrantID = CONCAT('XF', LPAD(new_id, 6, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 HydrantID）
INSERT INTO `firehydrants` (`LocationID`, `LastInspectionDate`, `NextInspectionDate`, `Inspector`, `IsQualified`)
VALUES (40001, '2024-01-15', '2024-07-15', 'Jane Smith', 1),
       (40002, '2024-02-10', '2024-08-10', '李娜', 1),
       (40003, '2024-03-05', '2024-09-05', '王刚', 0),
       (40004, '2024-04-20', '2024-10-20', '赵敏', 1),
       (40005, '2024-05-25', '2024-11-25', '陈辉', 1),
       (40001, '2024-06-30', '2025-01-30', '杨洋', 1),
       (40002, '2024-07-15', '2025-02-15', '刘洋', 0),
       (40003, '2024-08-10', '2025-03-10', '张婷', 1),
       (40004, '2024-09-05', '2025-04-05', '李娜', 1),
       (40005, '2024-10-20', '2025-05-20', '王刚', 0),
       (40001, '2024-11-25', '2025-06-25', '赵敏', 1),
       (40002, '2024-12-30', '2025-07-30', '陈辉', 1),
       (40003, '2024-01-15', '2024-07-15', '杨洋', 1),
       (40004, '2024-02-10', '2024-08-10', '刘洋', 0),
       (40005, '2024-03-05', '2024-09-05', '张婷', 1),
       (40001, '2024-04-20', '2024-10-20', '李娜', 1),
       (40002, '2024-05-25', '2024-11-25', '王刚', 0),
       (40003, '2024-06-30', '2025-01-30', '赵敏', 1),
       (40004, '2024-07-15', '2025-02-15', '陈辉', 1),
       (40005, '2024-08-10', '2025-03-10', '杨洋', 0),
       (40001, '2024-09-05', '2025-04-05', '刘洋', 1),
       (40002, '2024-10-20', '2025-05-20', '张婷', 1),
       (40003, '2024-11-25', '2025-06-25', '李娜', 0),
       (40004, '2024-12-30', '2025-07-30', '王刚', 1),
       (40005, '2024-01-15', '2024-07-15', '赵敏', 1),
       (40001, '2024-02-10', '2024-08-10', '陈辉', 0),
       (40002, '2024-03-05', '2024-09-05', '杨洋', 1),
       (40003, '2024-04-20', '2024-10-20', '刘洋', 1),
       (40004, '2024-05-25', '2024-11-25', '张婷', 0),
       (40005, '2024-06-30', '2025-01-30', '李娜', 1),
       (40001, '2024-07-15', '2025-02-15', '王刚', 1),
       (40002, '2024-08-10', '2025-03-10', '赵敏', 0),
       (40003, '2024-09-05', '2025-04-05', '陈辉', 1),
       (40004, '2024-10-20', '2025-05-20', '杨洋', 1),
       (40005, '2024-11-25', '2025-06-25', '刘洋', 0),
       (40001, '2024-12-30', '2025-07-30', '张婷', 1),
       (40002, '2024-01-15', '2024-07-15', '李娜', 1),
       (40003, '2024-02-10', '2024-08-10', '王刚', 0),
       (40004, '2024-03-05', '2024-09-05', '赵敏', 1),
       (40005, '2024-04-20', '2024-10-20', '陈辉', 1),
       (40001, '2024-05-25', '2024-11-25', '杨洋', 0),
       (40002, '2024-06-30', '2025-01-30', '刘洋', 1),
       (40003, '2024-07-15', '2025-02-15', '张婷', 1),
       (40004, '2024-08-10', '2025-03-10', '李娜', 0),
       (40005, '2024-09-05', '2025-04-05', '王刚', 1),
       (40001, '2024-10-20', '2025-05-20', '赵敏', 1),
       (40002, '2024-11-25', '2025-06-25', '陈辉', 0),
       (40003, '2024-12-30', '2025-07-30', '杨洋', 1),
       (40004, '2024-01-15', '2024-07-15', '刘洋', 1),
       (40005, '2024-02-10', '2024-08-10', '张婷', 0),
       (40001, '2024-01-15', '2024-07-15', '张伟', 1);

/*!40000 ALTER TABLE `firehydrants`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gasinfo`
--
-- 删除已有的 gasinfo 表
DROP TABLE IF EXISTS `gasinfo`;

-- 创建 gasinfo 表
CREATE TABLE `gasinfo`
(
    `GasID`         VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                         NOT NULL,
    `PropertyID`    INT                                                                                  NOT NULL,
    `Concentration` DECIMAL(5, 2)                                                                        NOT NULL,
    `UrgencyLevel`  ENUM ('低', '中', '高') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci             NOT NULL,
    `Status`        ENUM ('未处理', '处理中', '已处理') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    PRIMARY KEY (`GasID`) USING BTREE,
    KEY `PropertyID` (`PropertyID`) USING BTREE,
    CONSTRAINT `gasinfo_ibfk_1` FOREIGN KEY (`PropertyID`) REFERENCES `propertyinfo` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_gasinfo`;

-- 创建序列表
CREATE TABLE `seq_gasinfo`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_gasinfo` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_gasinfo`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_gasinfo
    BEFORE INSERT
    ON `gasinfo`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_gasinfo` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 GasID
    SET NEW.GasID = CONCAT('MQ', LPAD(new_id, 6, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 GasID）
INSERT INTO `gasinfo` (`PropertyID`, `Concentration`, `UrgencyLevel`, `Status`)
VALUES (33, 1.23, '低', '未处理'),
       (34, 2.34, '中', '处理中'),
       (35, 3.45, '高', '已处理'),
       (36, 0.56, '低', '未处理'),
       (37, 1.78, '中', '处理中'),
       (38, 2.89, '高', '已处理'),
       (39, 0.12, '低', '未处理'),
       (40, 1.34, '中', '处理中'),
       (41, 2.45, '高', '已处理'),
       (42, 0.67, '低', '未处理'),
       (43, 1.89, '中', '处理中'),
       (44, 2.99, '高', '已处理'),
       (45, 0.22, '低', '未处理'),
       (46, 1.56, '中', '处理中'),
       (47, 2.78, '高', '已处理'),
       (48, 0.33, '低', '未处理'),
       (49, 1.67, '中', '处理中'),
       (50, 2.89, '高', '已处理'),
       (51, 0.44, '低', '未处理'),
       (52, 1.78, '中', '处理中'),
       (53, 2.99, '高', '已处理'),
       (54, 0.55, '低', '未处理'),
       (55, 1.89, '中', '处理中'),
       (56, 2.34, '高', '已处理'),
       (57, 0.66, '低', '未处理'),
       (58, 1.45, '中', '处理中'),
       (59, 2.67, '高', '已处理'),
       (60, 0.78, '低', '未处理');

/*!40000 ALTER TABLE `gasinfo`
    ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `greenenvironmentinfo`
--
-- 删除已有的 greenenvironmentinfo 表
DROP TABLE IF EXISTS `greenenvironmentinfo`;

-- 创建 greenenvironmentinfo 表
CREATE TABLE `greenenvironmentinfo`
(
    `ID`              VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                         NOT NULL,
    `PointID`         INT                                                                                  NOT NULL,
    `MaintenanceType` ENUM ('种植', '修剪', '喷药') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci       NOT NULL,
    `Status`          ENUM ('未处理', '处理中', '已处理') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    PRIMARY KEY (`ID`) USING BTREE,
    KEY `PointID` (`PointID`) USING BTREE,
    CONSTRAINT `greenenvironmentinfo_ibfk_1` FOREIGN KEY (`PointID`) REFERENCES `locationinfo` (`PointID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_greenenvironmentinfo`;

-- 创建序列表
CREATE TABLE `seq_greenenvironmentinfo`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_greenenvironmentinfo` (`next_id`)
VALUES (10001);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_greenenvironmentinfo`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_greenenvironmentinfo
    BEFORE INSERT
    ON `greenenvironmentinfo`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_greenenvironmentinfo` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 ID
    SET NEW.ID = CONCAT('G', LPAD(new_id, 5, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 ID）
INSERT INTO `greenenvironmentinfo` (`PointID`, `MaintenanceType`, `Status`)
VALUES (40001, '修剪', '未处理'),
       (40002, '种植', '未处理'),
       (40003, '喷药', '未处理'),
       (40004, '修剪', '未处理'),
       (40005, '种植', '未处理'),
       (40006, '喷药', '未处理'),
       (40007, '修剪', '未处理'),
       (40008, '种植', '未处理'),
       (40009, '喷药', '未处理'),
       (40010, '修剪', '未处理'),
       (40001, '种植', '未处理'),
       (40002, '喷药', '未处理'),
       (40003, '修剪', '未处理'),
       (40004, '种植', '未处理'),
       (40005, '喷药', '未处理'),
       (40006, '修剪', '未处理'),
       (40007, '种植', '未处理'),
       (40008, '喷药', '未处理'),
       (40009, '修剪', '未处理'),
       (40010, '种植', '未处理'),
       (40001, '喷药', '未处理'),
       (40002, '修剪', '未处理'),
       (40003, '种植', '未处理'),
       (40004, '喷药', '未处理'),
       (40005, '修剪', '未处理'),
       (40006, '种植', '未处理'),
       (40007, '喷药', '未处理'),
       (40008, '修剪', '未处理'),
       (40009, '种植', '未处理'),
       (40010, '喷药', '未处理'),
       (40001, '修剪', '未处理'),
       (40002, '喷药', '未处理'),
       (40003, '种植', '未处理'),
       (40004, '修剪', '未处理'),
       (40005, '喷药', '未处理'),
       (40006, '种植', '未处理'),
       (40007, '修剪', '未处理'),
       (40008, '喷药', '未处理'),
       (40009, '种植', '未处理'),
       (40010, '修剪', '未处理'),
       (40001, '喷药', '未处理'),
       (40002, '修剪', '未处理'),
       (40003, '种植', '未处理'),
       (40004, '喷药', '未处理'),
       (40005, '修剪', '未处理'),
       (40006, '种植', '未处理'),
       (40007, '喷药', '未处理'),
       (40008, '修剪', '未处理'),
       (40009, '种植', '未处理'),
       (40010, '喷药', '未处理');

/*!40000 ALTER TABLE `greenenvironmentinfo`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locationinfo`
--

DROP TABLE IF EXISTS `locationinfo`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locationinfo`
(
    `PointID`      int                                                                       NOT NULL,
    `LocationName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci             NOT NULL,
    `Device`       enum ('Sensor','Camera') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    PRIMARY KEY (`PointID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationinfo`
--

LOCK TABLES `locationinfo` WRITE;
/*!40000 ALTER TABLE `locationinfo`
    DISABLE KEYS */;
INSERT INTO `locationinfo` (`PointID`, `LocationName`, `Device`)
VALUES (40001, 'Entrance Gate', 'Camera'),
       (40002, '主大厅', 'Camera'),
       (40003, '停车场 A', 'Sensor'),
       (40004, '停车场 B', 'Camera'),
       (40005, '1号楼大厅', 'Sensor'),
       (40006, '1号楼电梯', 'Camera'),
       (40007, '1号楼走廊', 'Sensor'),
       (40008, '2号楼大厅', 'Camera'),
       (40009, '2号楼电梯', 'Sensor'),
       (40010, '2号楼走廊', 'Camera'),
       (40011, '3号楼大厅', 'Sensor'),
       (40012, '3号楼电梯', 'Camera'),
       (40013, '3号楼走廊', 'Sensor'),
       (40014, '4号楼大厅', 'Camera'),
       (40015, '4号楼电梯', 'Sensor'),
       (40016, '4号楼走廊', 'Camera'),
       (40017, '5号楼大厅', 'Sensor'),
       (40018, '5号楼电梯', 'Camera'),
       (40019, '5号楼走廊', 'Sensor'),
       (40020, '6号楼大厅', 'Camera'),
       (40021, '6号楼电梯', 'Sensor'),
       (40022, '6号楼走廊', 'Camera'),
       (40023, '7号楼大厅', 'Sensor'),
       (40024, '7号楼电梯', 'Camera'),
       (40025, '7号楼走廊', 'Sensor'),
       (40026, '8号楼大厅', 'Camera'),
       (40027, '8号楼电梯', 'Sensor'),
       (40028, '8号楼走廊', 'Camera'),
       (40029, '9号楼大厅', 'Sensor'),
       (40030, '9号楼电梯', 'Camera'),
       (40031, '9号楼走廊', 'Sensor'),
       (40032, '10号楼大厅', 'Camera'),
       (40033, '10号楼电梯', 'Sensor'),
       (40034, '10号楼走廊', 'Camera'),
       (40035, '社区中心', 'Sensor'),
       (40036, '活动室', 'Camera'),
       (40037, '健身房', 'Sensor'),
       (40038, '游泳池', 'Camera'),
       (40039, '花园', 'Sensor'),
       (40040, '儿童游乐区', 'Camera'),
       (40041, '商业区', 'Sensor'),
       (40042, '餐厅', 'Camera'),
       (40043, '会议室', 'Sensor'),
       (40044, '管理办公室', 'Camera'),
       (40045, '保安室', 'Sensor'),
       (40046, '图书馆', 'Camera'),
       (40047, '洗衣房', 'Sensor'),
       (40048, '储藏室', 'Camera'),
       (40049, '邮政室', 'Sensor'),
       (40050, '药品储藏室', 'Camera'),
       (40051, '厨房', 'Sensor'),
       (40052, '音乐室', 'Camera'),
       (40053, '艺术室', 'Sensor'),
       (40054, '游戏室', 'Camera'),
       (40055, '户外休息区', 'Sensor'),
       (40056, '车库入口', 'Camera'),
       (40057, '车库出口', 'Sensor'),
       (40058, '电动车充电站', 'Camera'),
       (40059, '园艺区', 'Sensor'),
       (40060, '屋顶花园', 'Camera'),
       (40061, '门禁系统', 'Sensor'),
       (40062, '访客登记处', 'Camera'),
       (40063, '安全检查站', 'Sensor'),
       (40064, '垃圾处理区', 'Camera'),
       (40065, '中央空调机房', 'Sensor'),
       (40066, '电力控制室', 'Camera'),
       (40067, '水泵房', 'Sensor'),
       (40068, '消防控制室', 'Camera'),
       (40069, '广播室', 'Sensor'),
       (40070, '网络机房', 'Camera'),
       (40071, '储物柜区域', 'Sensor'),
       (40072, '自助售货区', 'Camera'),
       (40073, '清洁设备室', 'Sensor'),
       (40074, '安全巡逻区域', 'Camera'),
       (40075, '电梯机房', 'Sensor'),
       (40076, '空调机房', 'Camera'),
       (40077, '水处理室', 'Sensor'),
       (40078, '保养室', 'Camera'),
       (40079, '维护仓库', 'Sensor'),
       (40080, '控制中心', 'Camera'),
       (40081, '保安巡逻路径', 'Sensor'),
       (40082, '地下车库入口', 'Camera'),
       (40083, '地下车库出口', 'Sensor'),
       (40084, '废物回收区', 'Camera'),
       (40085, '办公区域', 'Sensor'),
       (40086, '员工休息室', 'Camera'),
       (40087, '会议大厅', 'Sensor'),
       (40088, '接待大厅', 'Camera'),
       (40089, '书画室', 'Sensor'),
       (40090, '电子图书馆', 'Camera'),
       (40091, '老年活动中心', 'Sensor'),
       (40092, '青少年活动中心', 'Camera'),
       (40093, '厨房入口', 'Sensor'),
       (40094, '厨房出口', 'Camera'),
       (40095, '仓库入口', 'Sensor'),
       (40096, '仓库出口', 'Camera'),
       (40097, '小区门口', 'Sensor'),
       (40098, '小区内部', 'Camera'),
       (40099, '花坛区域', 'Sensor'),
       (40100, '社区广播站', 'Camera'),
       (40101, '大门入口', 'Camera');
/*!40000 ALTER TABLE `locationinfo`
    ENABLE KEYS */;
UNLOCK TABLES;
-- 删除已有的 manholecovers 表
DROP TABLE IF EXISTS `manholecovers`;

-- 创建 manholecovers 表
CREATE TABLE `manholecovers`
(
    `CoverID`      VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                         NOT NULL,
    `LocationID`   INT                                                                                  NOT NULL,
    `CoverExists`  TINYINT(1)                                                                           NOT NULL,
    `CoverDamaged` TINYINT(1)                                                                           NOT NULL,
    `Status`       ENUM ('待处理', '处理中', '已处理') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    PRIMARY KEY (`CoverID`) USING BTREE,
    KEY `LocationID` (`LocationID`) USING BTREE,
    CONSTRAINT `manholecovers_ibfk_1` FOREIGN KEY (`LocationID`) REFERENCES `locationinfo` (`PointID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_manholecovers`;

-- 创建序列表
CREATE TABLE `seq_manholecovers`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_manholecovers` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_manholecovers`;

-- 创建触发器
DELIMITER $

CREATE TRIGGER before_insert_manholecovers
    BEFORE INSERT
    ON `manholecovers`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_manholecovers` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 CoverID
    SET NEW.CoverID = CONCAT('JG', LPAD(new_id, 6, '0'));
END$

DELIMITER ;

-- 插入示例数据
INSERT INTO `manholecovers` (`LocationID`, `CoverExists`, `CoverDamaged`, `Status`)
VALUES (40001, 1, 0, '待处理'),
       (40002, 1, 1, '处理中'),
       (40003, 0, 0, '已处理'),
       (40004, 1, 0, '待处理'),
       (40005, 1, 1, '处理中'),
       (40001, 1, 0, '已处理'),
       (40002, 0, 1, '待处理'),
       (40003, 1, 1, '处理中'),
       (40004, 0, 0, '已处理'),
       (40005, 1, 0, '待处理'),
       (40001, 1, 1, '处理中'),
       (40002, 1, 0, '已处理'),
       (40003, 0, 1, '待处理'),
       (40004, 1, 1, '处理中'),
       (40005, 0, 0, '已处理'),
       (40001, 1, 0, '待处理'),
       (40002, 1, 1, '处理中'),
       (40003, 1, 0, '已处理'),
       (40004, 0, 1, '待处理'),
       (40005, 1, 1, '处理中'),
       (40001, 1, 0, '已处理'),
       (40002, 0, 1, '待处理'),
       (40003, 1, 1, '处理中'),
       (40004, 1, 0, '已处理'),
       (40005, 0, 1, '待处理'),
       (40001, 1, 1, '处理中'),
       (40002, 1, 0, '已处理'),
       (40003, 0, 1, '待处理'),
       (40004, 1, 1, '处理中'),
       (40005, 1, 0, '已处理'),
       (40001, 0, 1, '待处理'),
       (40002, 1, 1, '处理中'),
       (40003, 1, 0, '已处理'),
       (40004, 0, 1, '待处理'),
       (40005, 1, 1, '处理中'),
       (40001, 1, 0, '已处理'),
       (40002, 1, 1, '待处理'),
       (40003, 0, 1, '处理中'),
       (40004, 1, 0, '已处理'),
       (40005, 0, 1, '待处理'),
       (40001, 1, 1, '处理中'),
       (40002, 0, 0, '已处理'),
       (40003, 1, 1, '待处理'),
       (40004, 1, 0, '处理中'),
       (40005, 0, 1, '已处理'),
       (40001, 1, 1, '待处理'),
       (40002, 1, 0, '已处理'),
       (40003, 0, 1, '处理中'),
       (40004, 1, 1, '待处理'),
       (40005, 1, 0, '已处理'),
       (40001, 1, 0, '待处理');

--
-- Table structure for table `memberproperty`
--
-- 删除已有的 memberproperty 表
DROP TABLE IF EXISTS `memberproperty`;

-- 创建 memberproperty 表
CREATE TABLE `memberproperty`
(
    `MemberID`         VARCHAR(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `PropertyID`       INT                                                          NOT NULL,
    `RelationshipType` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    PRIMARY KEY (`MemberID`, `PropertyID`) USING BTREE,
    KEY `PropertyID` (`PropertyID`) USING BTREE,
    CONSTRAINT `memberproperty_ibfk_1` FOREIGN KEY (`MemberID`) REFERENCES `members` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `memberproperty_ibfk_2` FOREIGN KEY (`PropertyID`) REFERENCES `propertyinfo` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_memberproperty`;

-- 创建序列表
CREATE TABLE `seq_memberproperty`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_memberproperty` (`next_id`)
VALUES (1);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_memberproperty`;

-- 创建触发器
DELIMITER $

CREATE TRIGGER before_insert_memberproperty
    BEFORE INSERT
    ON `memberproperty`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_memberproperty` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 MemberID
    SET NEW.MemberID = CONCAT('MP', LPAD(new_id, 8, '0'));
END$

DELIMITER ;

-- 插入示例数据
INSERT INTO `memberproperty` (`MemberID`, `PropertyID`, `RelationshipType`)
VALUES ('MP00000001', 1, 'Owner');


--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members`
(
    `id`              int(8) unsigned zerofill                                      NOT NULL AUTO_INCREMENT,
    `photo`           blob,
    `property`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci      DEFAULT NULL,
    `name`            varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `identity_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `contact_info`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci       DEFAULT NULL,
    `occupation`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci       DEFAULT NULL,
    `birth_date`      date                                                               DEFAULT NULL,
    `gender`          char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci           DEFAULT NULL,
    `member_type`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci       DEFAULT NULL,
    `remarks`         text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
    `status`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci       DEFAULT NULL,
    `created_at`      timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 10000032
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members`
    DISABLE KEYS */;
INSERT INTO `members` (`id`, `photo`, `property`, `name`, `identity_number`, `contact_info`, `occupation`, `birth_date`,
                       `gender`, `member_type`, `remarks`, `status`, `created_at`)
VALUES (10000001, NULL, 'yinf', 'John Doe', '123456789012345678', '123-456-7890', 'Engineer', '1980-01-01', 'M',
        'Owner', 'No remarks', 'Active', '2024-08-27 01:31:20'),
       (10000002, NULL, '华阳小区1栋', '张伟', '110101198501010011', '13812345678', '工程师', '1985-05-15', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000003, NULL, '华阳小区2栋', '李娜', '110101199001012345', '13987654321', '教师', '1990-02-10', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000004, NULL, '华阳小区3栋', '王芳', '110101199203011234', '13712349876', '医生', '1992-03-08', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000005, NULL, '华阳小区4栋', '刘强', '110101198306152345', '13698761234', '律师', '1983-06-15', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000006, NULL, '华阳小区5栋', '赵丽', '110101199507251234', '13587654312', '公务员', '1995-07-25', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000007, NULL, '华阳小区6栋', '孙超', '110101198708081234', '13456789012', '程序员', '1987-08-08', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000008, NULL, '华阳小区7栋', '周敏', '110101199302151234', '13398765432', '设计师', '1993-02-15', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000009, NULL, '华阳小区8栋', '吴涛', '110101198912081234', '13212348765', '医生', '1989-12-08', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000010, NULL, '华阳小区9栋', '郑爽', '110101199108011234', '13187654321', '教师', '1991-08-01', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000011, NULL, '华阳小区10栋', '王强', '110101198212041234', '13098765432', '建筑师', '1982-12-04', 'M',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000012, NULL, '华阳小区11栋', '刘梅', '110101199506151234', '13912345678', '护士', '1995-06-15', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000013, NULL, '华阳小区12栋', '李雷', '110101198706081234', '13876543210', '工程师', '1987-06-08', 'M',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000014, NULL, '华阳小区13栋', '韩红', '110101199306251234', '13709876543', '设计师', '1993-06-25', 'F',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000015, NULL, '华阳小区14栋', '吴昊', '110101198412051234', '13612340987', '律师', '1984-12-05', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000016, NULL, '华阳小区15栋', '赵鑫', '110101199207011234', '13587651234', '医生', '1992-07-01', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000017, NULL, '华阳小区16栋', '陈刚', '110101198611251234', '13456783210', '公务员', '1986-11-25', 'M',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000018, NULL, '华阳小区17栋', '杨帆', '110101199109121234', '13376549876', '程序员', '1991-09-12', 'M',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000019, NULL, '华阳小区18栋', '刘敏', '110101198809151234', '13212345698', '设计师', '1988-09-15', 'F',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000020, NULL, '华阳小区19栋', '王磊', '110101199310031234', '13198761234', '教师', '1993-10-03', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000021, NULL, '华阳小区20栋', '周婷', '110101199107081234', '13087654312', '护士', '1991-07-08', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000022, NULL, '华阳小区21栋', '李强', '110101198303151234', '13923456789', '建筑师', '1983-03-15', 'M',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000023, NULL, '华阳小区22栋', '赵敏', '110101199208121234', '13865432109', '律师', '1992-08-12', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000024, NULL, '华阳小区23栋', '孙杰', '110101198710091234', '13709876234', '医生', '1987-10-09', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000025, NULL, '华阳小区24栋', '吴静', '110101199105011234', '13612349876', '公务员', '1991-05-01', 'F',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000026, NULL, '华阳小区25栋', '郑军', '110101198612251234', '13598761234', '程序员', '1986-12-25', 'M',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000027, NULL, '华阳小区26栋', '李杰', '110101199312041234', '13476543210', '设计师', '1993-12-04', 'M',
        '业主', '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000028, NULL, '华阳小区27栋', '杨静', '110101198711051234', '13312348765', '护士', '1987-11-05', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000029, NULL, '华阳小区28栋', '刘辉', '110101199204181234', '13298761234', '教师', '1992-04-18', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000030, NULL, '华阳小区29栋', '陈芳', '110101199306151234', '13187654321', '医生', '1993-06-15', 'F', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28'),
       (10000031, NULL, '华阳小区30栋', '赵阳', '110101198904121234', '13012345678', '律师', '1989-04-12', 'M', '业主',
        '无备注', '活跃', '2024-08-28 01:25:28');
/*!40000 ALTER TABLE `members`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitoringinfo`
--

DROP TABLE IF EXISTS `monitoringinfo`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitoringinfo`
(
    `ID`      int                                                           NOT NULL AUTO_INCREMENT,
    `Video`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `PointID` int                                                           NOT NULL,
    PRIMARY KEY (`ID`) USING BTREE,
    KEY `PointID` (`PointID`) USING BTREE,
    CONSTRAINT `monitoringinfo_ibfk_1` FOREIGN KEY (`PointID`) REFERENCES `locationinfo` (`PointID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 31
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitoringinfo`
--

LOCK TABLES `monitoringinfo` WRITE;
/*!40000 ALTER TABLE `monitoringinfo`
    DISABLE KEYS */;
INSERT INTO `monitoringinfo` (`ID`, `Video`, `PointID`)
VALUES (1, 'camera_feed_01.mp4', 40001),
       (2, 'camera_feed_02.mp4', 40002),
       (3, 'camera_feed_03.mp4', 40003),
       (4, 'camera_feed_04.mp4', 40004),
       (5, 'camera_feed_05.mp4', 40005),
       (6, 'camera_feed_06.mp4', 40006),
       (7, 'camera_feed_07.mp4', 40007),
       (8, 'camera_feed_08.mp4', 40008),
       (9, 'camera_feed_09.mp4', 40009),
       (10, 'camera_feed_10.mp4', 40010),
       (11, 'camera_feed_11.mp4', 40011),
       (12, 'camera_feed_12.mp4', 40012),
       (13, 'camera_feed_13.mp4', 40013),
       (14, 'camera_feed_14.mp4', 40014),
       (15, 'camera_feed_15.mp4', 40015),
       (16, 'camera_feed_16.mp4', 40016),
       (17, 'camera_feed_17.mp4', 40017),
       (18, 'camera_feed_18.mp4', 40018),
       (19, 'camera_feed_19.mp4', 40019),
       (20, 'camera_feed_20.mp4', 40020),
       (21, 'camera_feed_21.mp4', 40021),
       (22, 'camera_feed_22.mp4', 40022),
       (23, 'camera_feed_23.mp4', 40023),
       (24, 'camera_feed_24.mp4', 40024),
       (25, 'camera_feed_25.mp4', 40025),
       (26, 'camera_feed_26.mp4', 40026),
       (27, 'camera_feed_27.mp4', 40027),
       (28, 'camera_feed_28.mp4', 40028),
       (29, 'camera_feed_29.mp4', 40029),
       (30, 'camera_feed_30.mp4', 40030);
/*!40000 ALTER TABLE `monitoringinfo`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propertyinfo`
--

DROP TABLE IF EXISTS `propertyinfo`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propertyinfo`
(
    `ID`             int                                                          NOT NULL AUTO_INCREMENT,
    `BuildingNumber` int                                                          NOT NULL,
    `PropertyCode`   varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `RoomNumber`     varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `OwnerName`      varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `ContactInfo`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `Area`           decimal(10, 2)                                               NOT NULL,
    `NumberOfRooms`  int                                                          NOT NULL,
    `Unit`           varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `FloorNumber`    int                                                          NOT NULL,
    `Description`    text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
    `MoveInDate`     date DEFAULT NULL,
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `PropertyCode` (`PropertyCode`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 154
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propertyinfo`
--

LOCK TABLES `propertyinfo` WRITE;
/*!40000 ALTER TABLE `propertyinfo`
    DISABLE KEYS */;
INSERT INTO `propertyinfo` (`ID`, `BuildingNumber`, `PropertyCode`, `RoomNumber`, `OwnerName`, `ContactInfo`, `Area`,
                            `NumberOfRooms`, `Unit`, `FloorNumber`, `Description`, `MoveInDate`)
VALUES (1, 1, 'HS2024110200001', 'A101', 'Jane Smith', '123-456-7890', 85.50, 3, 'Unit 1', 2, 'Near the park',
        '2024-01-15'),
       (33, 1, 'HS2024110200099', 'A102', '张伟', '13812345678', 88.50, 3, '单元1', 1, '靠近电梯', '2024-02-01'),
       (34, 2, 'HS2024110200003', 'B201', '李娜', '13987654321', 92.00, 3, '单元2', 2, '南北通透', '2024-03-01'),
       (35, 3, 'HS2024110200004', 'C302', '王芳', '13712349876', 75.80, 2, '单元3', 3, '安静区域', '2024-04-01'),
       (36, 4, 'HS2024110200005', 'D103', '刘强', '13698761234', 100.00, 4, '单元1', 1, '靠近花园', '2024-05-01'),
       (37, 5, 'HS2024110200006', 'E204', '赵丽', '13587654312', 68.00, 2, '单元2', 2, '宽敞明亮', '2024-06-01'),
       (38, 6, 'HS2024110200007', 'F305', '孙超', '13456789012', 85.50, 3, '单元3', 3, '高层视野好', '2024-07-01'),
       (39, 7, 'HS2024110200008', 'G406', '周敏', '13398765432', 120.00, 4, '单元1', 4, '顶层公寓', '2024-08-01'),
       (40, 8, 'HS2024110200009', 'H107', '吴涛', '13212348765', 95.00, 3, '单元2', 1, '朝向阳光', '2024-09-01'),
       (41, 9, 'HS2024110200010', 'I208', '郑爽', '13187654321', 80.50, 2, '单元3', 2, '生活便利', '2024-10-01'),
       (42, 10, 'HS2024110200011', 'J309', '王强', '13098765432', 105.00, 4, '单元1', 3, '靠近学校', '2024-11-01'),
       (43, 1, 'HS2024110200012', 'A110', '刘梅', '13912345678', 88.50, 3, '单元1', 1, '靠近电梯', '2024-12-01'),
       (44, 2, 'HS2024110200013', 'B211', '李雷', '13876543210', 92.00, 3, '单元2', 2, '南北通透', '2024-01-10'),
       (45, 3, 'HS2024110200014', 'C312', '韩红', '13709876543', 75.80, 2, '单元3', 3, '安静区域', '2024-02-15'),
       (46, 4, 'HS2024110200015', 'D113', '吴昊', '13612340987', 100.00, 4, '单元1', 1, '靠近花园', '2024-03-20'),
       (47, 5, 'HS2024110200016', 'E214', '赵鑫', '13587651234', 68.00, 2, '单元2', 2, '宽敞明亮', '2024-04-25'),
       (48, 6, 'HS2024110200017', 'F315', '陈刚', '13456783210', 85.50, 3, '单元3', 3, '高层视野好', '2024-05-30'),
       (49, 7, 'HS2024110200018', 'G416', '杨帆', '13376549876', 120.00, 4, '单元1', 4, '顶层公寓', '2024-06-15'),
       (50, 8, 'HS2024110200019', 'H117', '刘敏', '13212345698', 95.00, 3, '单元2', 1, '朝向阳光', '2024-07-20'),
       (51, 9, 'HS2024110200020', 'I218', '王磊', '13198761234', 80.50, 2, '单元3', 2, '生活便利', '2024-08-25'),
       (52, 10, 'HS2024110200021', 'J319', '周婷', '13087654312', 105.00, 4, '单元1', 3, '靠近学校', '2024-09-30'),
       (53, 1, 'HS2024110200022', 'A120', '李强', '13923456789', 88.50, 3, '单元1', 1, '靠近电梯', '2024-10-05'),
       (54, 2, 'HS2024110200023', 'B221', '赵敏', '13865432109', 92.00, 3, '单元2', 2, '南北通透', '2024-11-10'),
       (55, 3, 'HS2024110200024', 'C322', '孙杰', '13709876234', 75.80, 2, '单元3', 3, '安静区域', '2024-12-15'),
       (56, 4, 'HS2024110200025', 'D123', '吴静', '13612349876', 100.00, 4, '单元1', 1, '靠近花园', '2025-01-20'),
       (57, 5, 'HS2024110200026', 'E224', '郑军', '13598761234', 68.00, 2, '单元2', 2, '宽敞明亮', '2025-02-25'),
       (58, 6, 'HS2024110200027', 'F325', '李杰', '13476543210', 85.50, 3, '单元3', 3, '高层视野好', '2025-03-30'),
       (59, 7, 'HS2024110200028', 'G426', '杨静', '13312348765', 120.00, 4, '单元1', 4, '顶层公寓', '2025-04-15'),
       (60, 8, 'HS2024110200029', 'H127', '刘辉', '13298761234', 95.00, 3, '单元2', 1, '朝向阳光', '2025-05-20'),
       (61, 9, 'HS2024110200030', 'I228', '陈芳', '13187654321', 80.50, 2, '单元3', 2, '生活便利', '2025-06-25');
/*!40000 ALTER TABLE `propertyinfo`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roadenvironmentinspection`
--
-- 删除已有的 roadenvironmentinspection 表
DROP TABLE IF EXISTS `roadenvironmentinspection`;

-- 创建 roadenvironmentinspection 表
CREATE TABLE `roadenvironmentinspection`
(
    `ID`             VARCHAR(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                                             NOT NULL,
    `PointID`        INT                                                                                                      NOT NULL,
    `InspectionType` ENUM ('清洁', '障碍物清除', '流浪猫狗出没', '汽车占道') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `Status`         VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    `carID`          VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    PRIMARY KEY (`ID`) USING BTREE,
    KEY `PointID` (`PointID`) USING BTREE,
    KEY `carenvir` (`carID`) USING BTREE,
    CONSTRAINT `carenvir` FOREIGN KEY (`carID`) REFERENCES `vehicles` (`license_plate`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `roadenvironmentinspection_ibfk_1` FOREIGN KEY (`PointID`) REFERENCES `locationinfo` (`PointID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_roadenvironmentinspection`;

-- 创建序列表
CREATE TABLE `seq_roadenvironmentinspection`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_roadenvironmentinspection` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_roadenvironmentinspection`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_roadenvironmentinspection
    BEFORE INSERT
    ON `roadenvironmentinspection`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_roadenvironmentinspection` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 ID
    SET NEW.ID = CONCAT('R', LPAD(new_id, 6, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 ID）
INSERT INTO `roadenvironmentinspection` (`PointID`, `InspectionType`, `Status`, `carID`)
VALUES (40001, '汽车占道', '待处理', '京B23456'),
       (40002, '流浪猫狗出没', '处理中', NULL),
       (40003, '清洁', '已处理', NULL),
       (40004, '障碍物清除', '待处理', NULL),
       (40005, '清洁', '处理中', NULL),
       (40006, '障碍物清除', '已处理', NULL),
       (40007, '清洁', '待处理', NULL),
       (40008, '障碍物清除', '处理中', NULL),
       (40009, '清洁', '已处理', NULL),
       (40010, '障碍物清除', '待处理', NULL),
       (40001, '清洁', '处理中', NULL),
       (40002, '障碍物清除', '已处理', NULL),
       (40003, '清洁', '待处理', NULL),
       (40004, '流浪猫狗出没', '处理中', NULL),
       (40005, '清洁', '已处理', NULL),
       (40006, '障碍物清除', '待处理', NULL),
       (40007, '流浪猫狗出没', '处理中', NULL),
       (40008, '汽车占道', '已处理', '京E56789'),
       (40009, '清洁', '待处理', NULL),
       (40010, '障碍物清除', '处理中', NULL),
       (40001, '清洁', '已处理', NULL),
       (40002, '障碍物清除', '待处理', NULL),
       (40003, '清洁', '处理中', NULL),
       (40004, '障碍物清除', '已处理', NULL),
       (40005, '清洁', '待处理', NULL),
       (40006, '障碍物清除', '处理中', NULL),
       (40007, '清洁', '已处理', NULL),
       (40008, '障碍物清除', '待处理', NULL),
       (40009, '清洁', '处理中', NULL),
       (40010, '障碍物清除', '已处理', NULL),
       (40001, '清洁', '待处理', NULL),
       (40002, '障碍物清除', '处理中', NULL),
       (40003, '清洁', '已处理', NULL),
       (40004, '障碍物清除', '待处理', NULL),
       (40005, '清洁', '处理中', NULL),
       (40006, '障碍物清除', '已处理', NULL),
       (40007, '清洁', '待处理', NULL),
       (40008, '障碍物清除', '处理中', NULL),
       (40009, '清洁', '已处理', NULL),
       (40010, '障碍物清除', '待处理', NULL),
       (40001, '清洁', '处理中', NULL),
       (40002, '障碍物清除', '已处理', NULL),
       (40003, '清洁', '待处理', NULL),
       (40004, '障碍物清除', '处理中', NULL),
       (40005, '清洁', '已处理', NULL),
       (40006, '障碍物清除', '待处理', NULL),
       (40007, '清洁', '已处理', NULL),
       (40008, '障碍物清除', '处理中', NULL),
       (40009, '清洁', '待处理', NULL);


--
-- Table structure for table `suspiciousinfo`
--
-- 删除已有的 suspiciousinfo 表
DROP TABLE IF EXISTS `suspiciousinfo`;

-- 创建 suspiciousinfo 表
CREATE TABLE `suspiciousinfo`
(
    `InfoID`        VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                         NOT NULL,
    `LocationID`    INT                                                                                  NOT NULL,
    `Status`        ENUM ('未处理', '处理中', '已处理') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `Handler`       VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                        NOT NULL,
    `CrowdCategory` ENUM ('访客', '居民', '员工') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci       NOT NULL,
    `RecordTime`    TIMESTAMP                                                                            NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`InfoID`) USING BTREE,
    KEY `LocationID` (`LocationID`) USING BTREE,
    CONSTRAINT `suspiciousinfo_ibfk_1` FOREIGN KEY (`LocationID`) REFERENCES `locationinfo` (`PointID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_suspiciousinfo`;

-- 创建序列表
CREATE TABLE `seq_suspiciousinfo`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_suspiciousinfo` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_suspiciousinfo`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_suspiciousinfo
    BEFORE INSERT
    ON `suspiciousinfo`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_suspiciousinfo` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 InfoID
    SET NEW.InfoID = CONCAT('KY', LPAD(new_id, 6, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 InfoID）
INSERT INTO `suspiciousinfo` (`LocationID`, `Status`, `Handler`, `CrowdCategory`, `RecordTime`)
VALUES (40001, '未处理', '张三', '访客', '2024-08-27 04:00:00'),
       (40002, '处理中', '李四', '居民', '2024-08-28 03:12:19'),
       (40003, '已处理', '王五', '员工', '2024-08-28 03:12:19'),
       (40004, '未处理', '赵六', '访客', '2024-08-28 03:12:19'),
       (40005, '处理中', '孙七', '居民', '2024-08-28 03:12:19'),
       (40006, '已处理', '周八', '员工', '2024-08-28 03:12:19'),
       (40007, '未处理', '吴九', '访客', '2024-08-28 03:12:19'),
       (40008, '处理中', '郑十', '居民', '2024-08-28 03:12:19'),
       (40009, '已处理', '钱十一', '员工', '2024-08-28 03:12:19'),
       (40010, '未处理', '刘十二', '访客', '2024-08-28 03:12:19'),
       (40011, '处理中', '陈十三', '居民', '2024-08-28 03:12:19'),
       (40012, '已处理', '杨十四', '员工', '2024-08-28 03:12:19'),
       (40013, '未处理', '黄十五', '访客', '2024-08-28 03:12:19'),
       (40014, '处理中', '宋十六', '居民', '2024-08-28 03:12:19'),
       (40015, '已处理', '郑十七', '员工', '2024-08-28 03:12:19'),
       (40016, '未处理', '马十八', '访客', '2024-08-28 03:12:19'),
       (40017, '处理中', '唐十九', '居民', '2024-08-28 03:12:19'),
       (40018, '已处理', '顾二十', '员工', '2024-08-28 03:12:19'),
       (40019, '未处理', '梁二十一', '访客', '2024-08-28 03:12:19'),
       (40020, '处理中', '贾二十二', '居民', '2024-08-28 03:12:19'),
       (40021, '已处理', '余二十三', '员工', '2024-08-28 03:12:19'),
       (40022, '未处理', '邹二十四', '访客', '2024-08-28 03:12:19'),
       (40023, '处理中', '何二十五', '居民', '2024-08-28 03:12:19'),
       (40024, '已处理', '潘二十六', '员工', '2024-08-28 03:12:19'),
       (40025, '未处理', '陆二十七', '访客', '2024-08-28 03:12:19'),
       (40026, '处理中', '孔二十八', '居民', '2024-08-28 03:12:19'),
       (40027, '已处理', '曹二十九', '员工', '2024-08-28 03:12:19'),
       (40028, '未处理', '高三十', '访客', '2024-08-28 03:12:19'),
       (40029, '处理中', '曾三十一', '居民', '2024-08-28 03:12:19'),
       (40030, '已处理', '黄三十二', '员工', '2024-08-28 03:12:19'),
       (40031, '未处理', '雷三十三', '访客', '2024-08-28 03:12:19'),
       (40032, '处理中', '钟三十四', '居民', '2024-08-28 03:12:19'),
       (40033, '已处理', '费三十五', '员工', '2024-08-28 03:12:19'),
       (40034, '未处理', '贺三十六', '访客', '2024-08-28 03:12:19'),
       (40035, '处理中', '刘三十七', '居民', '2024-08-28 03:12:19'),
       (40036, '已处理', '叶三十八', '员工', '2024-08-28 03:12:19'),
       (40037, '未处理', '汤三十九', '访客', '2024-08-28 03:12:19'),
       (40038, '处理中', '杨四十', '居民', '2024-08-28 03:12:19'),
       (40039, '已处理', '阮四十一', '员工', '2024-08-28 03:12:19'),
       (40040, '未处理', '霍四十二', '访客', '2024-08-28 03:12:19'),
       (40041, '处理中', '朱四十三', '居民', '2024-08-28 03:12:19'),
       (40042, '已处理', '卢四十四', '员工', '2024-08-28 03:12:19'),
       (40043, '未处理', '贾四十五', '访客', '2024-08-28 03:12:19'),
       (40044, '处理中', '邓四十六', '居民', '2024-08-28 03:12:19'),
       (40045, '已处理', '孔四十七', '员工', '2024-08-28 03:12:19'),
       (40046, '未处理', '姚四十八', '访客', '2024-08-28 03:12:19'),
       (40047, '处理中', '崔四十九', '居民', '2024-08-28 03:12:19'),
       (40048, '已处理', '白五十', '员工', '2024-08-28 03:12:19'),
       (40049, '未处理', '曾五十一', '访客', '2024-08-28 03:12:19'),
       (40050, '处理中', '范五十二', '居民', '2024-08-28 03:12:19'),
       (40001, '未处理', '张三', '访客', '2024-08-28 03:12:19');


--
-- Table structure for table `trashbininfo`
--
-- 删除已有的 trashbininfo 表
DROP TABLE IF EXISTS `trashbininfo`;

-- 创建 trashbininfo 表
CREATE TABLE `trashbininfo`
(
    `BinID`      VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                                           NOT NULL,
    `BinType`    ENUM ('Recycling', 'General', 'Organic', 'Hazardous') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `LocationID` INT                                                                                                    NOT NULL,
    `Capacity`   DECIMAL(10, 2)                                                                                         NOT NULL,
    `Status`     ENUM ('Operational', 'Full', 'Needs Maintenance') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NOT NULL,
    `LastUpdate` TIMESTAMP                                                                                              NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`BinID`) USING BTREE,
    KEY `LocationID` (`LocationID`) USING BTREE,
    CONSTRAINT `trashbininfo_ibfk_1` FOREIGN KEY (`LocationID`) REFERENCES `locationinfo` (`PointID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- 删除已有的序列表
DROP TABLE IF EXISTS `seq_trashbininfo`;

-- 创建序列表
CREATE TABLE `seq_trashbininfo`
(
    `next_id` INT NOT NULL
);

-- 初始化序列
INSERT INTO `seq_trashbininfo` (`next_id`)
VALUES (100000);

-- 删除已有的触发器（如果存在）
DROP TRIGGER IF EXISTS `before_insert_trashbininfo`;

-- 创建触发器
DELIMITER $$

CREATE TRIGGER before_insert_trashbininfo
    BEFORE INSERT
    ON `trashbininfo`
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;

    -- 获取下一个 ID
    UPDATE `seq_trashbininfo` SET next_id = LAST_INSERT_ID(next_id + 1);
    SET new_id = LAST_INSERT_ID();

    -- 设置 BinID
    SET NEW.BinID = CONCAT('T', LPAD(new_id, 6, '0'));
END$$

DELIMITER ;

-- 插入示例数据（不包含 BinID）
INSERT INTO `trashbininfo` (`BinType`, `LocationID`, `Capacity`, `Status`, `LastUpdate`)
VALUES ('Recycling', 40001, 120.00, 'Operational', '2024-08-28 07:09:13'),
       ('General', 40002, 150.00, 'Full', '2024-08-28 07:09:13'),
       ('Organic', 40003, 100.00, 'Needs Maintenance', '2024-08-28 07:09:13'),
       ('Hazardous', 40004, 80.00, 'Operational', '2024-08-28 07:09:13'),
       ('Recycling', 40005, 130.00, 'Operational', '2024-08-28 07:09:13'),
       ('General', 40006, 160.00, 'Needs Maintenance', '2024-08-28 07:09:13'),
       ('Organic', 40007, 90.00, 'Full', '2024-08-28 07:09:13'),
       ('Hazardous', 40008, 70.00, 'Operational', '2024-08-28 07:09:13'),
       ('Recycling', 40009, 140.00, 'Needs Maintenance', '2024-08-28 07:09:13'),
       ('General', 40010, 150.00, 'Operational', '2024-08-28 07:09:13'),
       ('Recycling', 40011, 125.00, 'Operational', '2024-08-28 07:10:05'),
       ('General', 40012, 155.00, 'Needs Maintenance', '2024-08-28 07:10:05'),
       ('Organic', 40013, 105.00, 'Full', '2024-08-28 07:10:05'),
       ('Hazardous', 40014, 85.00, 'Operational', '2024-08-28 07:10:05'),
       ('Recycling', 40015, 135.00, 'Operational', '2024-08-28 07:10:05'),
       ('General', 40016, 165.00, 'Full', '2024-08-28 07:10:05'),
       ('Organic', 40017, 95.00, 'Needs Maintenance', '2024-08-28 07:10:05'),
       ('Hazardous', 40018, 75.00, 'Operational', '2024-08-28 07:10:05'),
       ('Recycling', 40019, 145.00, 'Needs Maintenance', '2024-08-28 07:10:05'),
       ('General', 40020, 155.00, 'Operational', '2024-08-28 07:10:05'),
       ('Organic', 40021, 110.00, 'Full', '2024-08-28 07:10:05'),
       ('Hazardous', 40022, 80.00, 'Operational', '2024-08-28 07:10:05'),
       ('Recycling', 40023, 120.00, 'Operational', '2024-08-28 07:10:05'),
       ('General', 40024, 150.00, 'Needs Maintenance', '2024-08-28 07:10:05'),
       ('Organic', 40025, 100.00, 'Full', '2024-08-28 07:10:05'),
       ('Hazardous', 40026, 70.00, 'Operational', '2024-08-28 07:10:05'),
       ('Recycling', 40027, 130.00, 'Needs Maintenance', '2024-08-28 07:10:05'),
       ('General', 40028, 160.00, 'Operational', '2024-08-28 07:10:05'),
       ('Organic', 40029, 90.00, 'Full', '2024-08-28 07:10:05'),
       ('Hazardous', 40030, 65.00, 'Operational', '2024-08-28 07:10:05'),
       ('Recycling', 40031, 140.00, 'Needs Maintenance', '2024-08-28 07:10:05'),
       ('General', 40032, 150.00, 'Operational', '2024-08-28 07:10:05'),
       ('Organic', 40033, 95.00, 'Full', '2024-08-28 07:10:05'),
       ('Hazardous', 40034, 75.00, 'Operational', '2024-08-28 07:10:05'),
       ('Recycling', 40035, 125.00, 'Operational', '2024-08-28 07:10:05'),
       ('General', 40036, 155.00, 'Needs Maintenance', '2024-08-28 07:10:05'),
       ('Organic', 40037, 105.00, 'Full', '2024-08-28 07:10:05'),
       ('Hazardous', 40038, 85.00, 'Operational', '2024-08-28 07:10:05'),
       ('Recycling', 40039, 135.00, 'Operational', '2024-08-28 07:10:05'),
       ('General', 40040, 165.00, 'Full', '2024-08-28 07:10:05');


--
-- Table structure for table `trashbinviolations`
--

DROP TABLE IF EXISTS `trashbinviolations`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trashbinviolations`
(
    `ViolationID`   int                                                                                          NOT NULL AUTO_INCREMENT,
    `BinID`         varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci                                 NOT NULL,
    `ViolatorID`    int(8) unsigned zerofill                                                                     NOT NULL,
    `ViolationType` enum ('Improper Disposal','Damage','Other') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `ViolationDate` timestamp                                                                                    NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`ViolationID`) USING BTREE,
    KEY `BinID` (`BinID`) USING BTREE,
    KEY `ViolatorID` (`ViolatorID`) USING BTREE,
    CONSTRAINT `trashbinviolations_ibfk_1` FOREIGN KEY (`BinID`) REFERENCES `trashbininfo` (`BinID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `trashbinviolations_ibfk_2` FOREIGN KEY (`ViolatorID`) REFERENCES `members` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trashbinviolations`
--

LOCK TABLES `trashbinviolations` WRITE;
/*!40000 ALTER TABLE `trashbinviolations`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `trashbinviolations`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles`
(
    `id`                 int(5) unsigned zerofill                                     NOT NULL AUTO_INCREMENT,
    `license_plate`      varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `registration_photo` blob,
    `resident_id`        int unsigned                                                 NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY `resident_id` (`resident_id`) USING BTREE,
    KEY `license_plate` (`license_plate`) USING BTREE,
    CONSTRAINT `vehicles_ibfk_1` FOREIGN KEY (`resident_id`) REFERENCES `members` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 30031
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles`
    DISABLE KEYS */;
INSERT INTO `vehicles` (`id`, `license_plate`, `registration_photo`, `resident_id`)
VALUES (30001, '京A12345', NULL, 10000001),
       (30002, '京B23456', NULL, 10000002),
       (30003, '京C34567', NULL, 10000003),
       (30004, '京D45678', NULL, 10000004),
       (30005, '京E56789', NULL, 10000005),
       (30006, '京F67890', NULL, 10000006),
       (30007, '京G78901', NULL, 10000007),
       (30008, '京H89012', NULL, 10000008),
       (30009, '京J90123', NULL, 10000009),
       (30010, '京K01234', NULL, 10000010),
       (30011, '京L12345', NULL, 10000011),
       (30012, '京M23456', NULL, 10000012),
       (30013, '京N34567', NULL, 10000013),
       (30014, '京P45678', NULL, 10000014),
       (30015, '京Q56789', NULL, 10000015),
       (30016, '京R67890', NULL, 10000016),
       (30017, '京S78901', NULL, 10000017),
       (30018, '京T89012', NULL, 10000018),
       (30019, '京U90123', NULL, 10000019),
       (30020, '京V01234', NULL, 10000020),
       (30021, '京W12345', NULL, 10000021),
       (30022, '京X23456', NULL, 10000022),
       (30023, '京Y34567', NULL, 10000023),
       (30024, '京Z45678', NULL, 10000024),
       (30025, '京A56789', NULL, 10000025),
       (30026, '京B67890', NULL, 10000026),
       (30027, '京C78901', NULL, 10000027),
       (30028, '京D89012', NULL, 10000028),
       (30029, '京E90123', NULL, 10000029),
       (30030, '京F01234', NULL, 10000030);
/*!40000 ALTER TABLE `vehicles`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2024-08-30  0:45:56
