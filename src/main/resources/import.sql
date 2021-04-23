drop table poll;

create table poll (
    id int not null primary key auto_increment,
    question varchar(50) not null,
--     option
);

-- DROP TABLE employees;
--
-- CREATE TABLE employees
-- (
--     empId       INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     firstName   VARCHAR2(25) NOT NULL DEFAULT '',
--     lastName    VARCHAR2(25) NOT NULL DEFAULT '',
--     title       VARCHAR2(25) NOT NULL DEFAULT '',
--     phoneNumber VARCHAR2(20) NOT NULL DEFAULT '',
--     email       VARCHAR2(40) NOT NULL DEFAULT '',
--     hireDate    DATE         NOT NULL,
--     managerId   INT          NOT NULL,
--     deptId  INT          NOT NULL
-- );
--
--
-- DROP TABLE departments;
--
-- CREATE TABLE departments
-- (
--     deptId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     deptName VARCHAR2(25) NOT NULL DEFAULT '',
--     managerId INT NOT NULL,
-- );
--



insert into poll (poll_id, question) values
(1, 'What is your favorite color?'),
(2, 'What is your favorite number?'),
(3, 'What is your favorite movie genre?'),
(4, 'What is your favorite music genre?'),
(5, 'What is your favorite sport?'),
(6, 'What is your favorite pop star?'),
(7, 'What is your favorite makeup brand?'),
(8, 'What is your favorite nail tip shape?'),
(9, 'What is your favorite type of vacation?'),
(10, 'What is your favorite car?'),
(11, 'What is your favorite fighting style?'),
(12, 'What is your favorite kind of pet?'),
(13, 'What is your favorite language?'),
(14, 'What is your favorite anime?'),
(15, 'What is your favorite phone brand?');



insert into option (option_id, option_value, poll_id) values
(1, 'Red', 1),
(2, 'Blue', 1),
(3, 'Yellow', 1),
(4, 'sixty-nine', 2),
(5, 'eighty-eight', 2),
(6, 'seventy-seven', 2),
(7, 'Action', 3),
(8, 'Drama', 3),
(9, 'Fantasy', 3),
(10, 'Rap', 4),
(11, 'Folk', 4),
(12, 'Pop', 4),
(13, 'Soccer', 5),
(14, 'Baseball', 5),
(15, 'Football', 5),
(16, 'Ariana Grande', 6),
(17, 'Demi Lovato', 6),
(18, 'Miley Cyrus', 6),
(19, 'Kat Von Dee', 7),
(20, 'ColorPop', 7),
(21, 'Makeup Revolution', 7),
(22, 'Coffin', 8),
(23, 'Square', 8),
(24, 'Stiletto', 8),
(25, 'ski', 9),
(26, 'beach', 9),
(27, 'mountain', 9),
(28, 'Corvette', 10),
(29, 'minivan', 10),
(30, 'camaro', 10),
(31, 'muy thai', 11),
(32, 'boxing', 11),
(33, 'jujitsu', 11),
(34, 'cat', 12),
(35, 'dog', 12),
(36, 'hedgehog', 12),
(37, 'spanish', 13,
(38, 'korean', 13),
(39, 'japanese', 13),
(40, 'Jujutsu Kaisen', 14),
(41, 'Saiki K', 14),
(42, 'Sakamoto-Kun', 14),
(43, 'Apple', 15),
(44, 'Samsung', 15),
(45, 'LG', 15);

