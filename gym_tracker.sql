DROP DATABASE IF EXISTS gym_tracker;
CREATE DATABASE gym_tracker;
USE gym_tracker;

CREATE TABLE admins (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE trainers (
    trainer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(100),
    specialization VARCHAR(100)
);

CREATE TABLE members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(100),
    weight DECIMAL(5,2),
    gender ENUM('Male','Female','Other') NOT NULL,
    join_date DATE,
    trainer_id INT NULL,
    FOREIGN KEY (trainer_id) REFERENCES trainers(trainer_id) ON DELETE SET NULL
);

CREATE TABLE subscriptions (
    subscription_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    subscription_type ENUM('Monthly','Quarterly','Half-Yearly','Yearly'),
    start_date DATE,
    end_date DATE,
    amount DECIMAL(8,2),
    status ENUM('Active','Expired','Cancelled') DEFAULT 'Active',
    FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE CASCADE
);

CREATE TABLE attendance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    check_in_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE CASCADE
);

-- Sample Data
INSERT INTO admins (username, password) VALUES ('admin', 'admin123');

INSERT INTO trainers (name, phone, email, specialization) VALUES
('John Doe', '9876543210', 'john.doe@trainer.com', 'Bodybuilding'),
('Jane Smith', '8765432109', 'jane.smith@trainer.com', 'CrossFit'),
('Mike Johnson', '7654321098', 'mike.j@trainer.com', 'Yoga');

INSERT INTO members (name, phone, email, weight, gender, join_date, trainer_id) VALUES
('Alice Brown', '9988776655', 'alice@email.com', 65.5, 'Female', '2023-01-10', 1),
('Bob White', '8877665544', 'bob@email.com', 85.0, 'Male', '2023-02-15', 2),
('Charlie Green', '7766554433', 'cg@email.com', 75.0, 'Male', '2023-03-20', NULL),
('Diana Prince', '6655443322', 'diana@email.com', 60.0, 'Female', '2023-04-05', 3),
('Evan Stone', '5544332211', 'evan@email.com', 95.0, 'Male', '2023-05-12', 1);

INSERT INTO subscriptions (member_id, subscription_type, start_date, end_date, amount, status) VALUES
(1, 'Monthly', '2024-04-01', '2024-05-01', 999.00, 'Active'),
(2, 'Yearly', '2024-01-15', '2025-01-15', 8999.00, 'Active'),
(3, 'Quarterly', '2024-03-20', '2024-06-20', 2699.00, 'Active'),
(4, 'Half-Yearly', '2023-11-05', '2024-05-05', 4999.00, 'Active');

INSERT INTO attendance (member_id, check_in_time) VALUES
(1, '2024-04-08 08:00:00'),
(2, '2024-04-08 09:15:00'),
(1, '2024-04-09 08:30:00'),
(3, '2024-04-09 17:45:00'),
(4, '2024-04-09 18:20:00'),
(1, '2024-04-10 07:50:00');
