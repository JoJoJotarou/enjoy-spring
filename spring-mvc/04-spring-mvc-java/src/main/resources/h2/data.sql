CREATE TABLE t_user
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY, -- 自增主键
    name     VARCHAR(255) NOT NULL,             -- 用户名
    age      INT,                               -- 年龄
    birthday DATE,                              -- 生日
    gender   VARCHAR(10)                        -- 性别 (映射为字符串类型)
);

INSERT INTO t_user (name, age, birthday, gender)
VALUES ('Alice', 25, '1999-01-15', 'FEMALE'),
       ('Bob', 30, '1994-07-23', 'MALE'),
       ('Charlie', 22, '2002-03-10', 'MALE'),
       ('Diana', 28, '1996-06-05', 'FEMALE'),
       ('Eve', 35, '1989-11-30', 'FEMALE');
