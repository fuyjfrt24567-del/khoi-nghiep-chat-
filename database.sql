-- Tạo database
CREATE DATABASE chat_app;
USE chat_app;

-- Bảng user
CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

-- Bảng message
CREATE TABLE message (
    message_id INT PRIMARY KEY AUTO_INCREMENT,
    sender VARCHAR(50),
    content TEXT,
    sent_time DATETIME DEFAULT CURRENT_TIMESTAMP
);
