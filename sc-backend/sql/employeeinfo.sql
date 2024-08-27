-- 创建数据库，设置字符集为 utf8mb4
CREATE DATABASE IF NOT EXISTS my_database CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
USE scdb_demo0;

-- 创建辅助表用于管理自增 ID
CREATE TABLE IF NOT EXISTS IDGenerator (
                                           CurrentID INT NOT NULL
);

-- 初始化 IDGenerator 表
INSERT INTO IDGenerator (CurrentID) VALUES (10001);

-- 创建 EmployeeInfo 表
CREATE TABLE IF NOT EXISTS EmployeeInfo (
                                            ID VARCHAR(10) PRIMARY KEY,
                                            Name VARCHAR(50) NOT NULL,
                                            Position ENUM('Super Administrator', 'Security Guard', 'Cleaner') NOT NULL,
                                            Status ENUM('Active', 'Inactive') NOT NULL,
                                            Account VARCHAR(50) UNIQUE NOT NULL,
                                            Password VARCHAR(255) NOT NULL
);

-- 创建触发器以自动生成 ID
DELIMITER //

CREATE TRIGGER before_insert_EmployeeInfo
    BEFORE INSERT ON EmployeeInfo
    FOR EACH ROW
BEGIN
    DECLARE newID INT;

    -- 获取当前 ID
    SELECT CurrentID INTO newID FROM IDGenerator;

    -- 更新 IDGenerator 表
    UPDATE IDGenerator SET CurrentID = CurrentID + 1;

    -- 设置新 ID
    SET NEW.ID = CONCAT('YG', newID);
END;

//

DELIMITER ;
