INSERT IGNORE INTO user_details
(id, name, birth_date, email)
VALUES
(11, 'Alice', '2006-04-01', 'alice@gmail.com'),
(12, 'Bob', '2003-08-06', 'bob@outlook.com'),
(13, 'Cathy', '1999-04-24', 'cathy@yahooo.com'),
(14, 'David', '2001-05-01', 'david@telkomsa.net');

INSERT IGNORE INTO post(id, description, user_id)
VALUES (11, 'I want to learn Spring Boot', 11),
(12, 'I want to learn Django', 12),
(13, 'I want to program in Python', 12),
(14, 'I want to learn dotNet', 13),
(15, 'I want to program in C Sharp', 13),
(16, 'I want to learn DevOps', 14),
(17, 'I want to program in Java', 11),
(18, 'I want to use Docker, Kubernetes & Terraform', 14),
(19, 'I can''t decide between Azure or AWS.', 14);

--ALTER SEQUENCE user_details_seq RESTART WITH 54;
--ALTER SEQUENCE post_seq RESTART WITH 59;
