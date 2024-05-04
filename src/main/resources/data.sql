INSERT INTO user_details
(id, name, birth_date, email)
VALUES
(1, 'Alice', '2006-04-01', 'alice@gmail.com'),
(2, 'Bob', '2003-08-06', 'bob@outlook.com'),
(3, 'Cathy', '1999-04-24', 'cathy@yahooo.com'),
(4, 'David', '2001-05-01', 'david@telkomsa.net');

INSERT INTO post(id, description, user_id)
VALUES (1, 'I want to learn Spring Boot', 1),
(2, 'I want to learn Django', 2),
(3, 'I want to program in Python', 2),
(4, 'I want to learn dotNet', 3),
(5, 'I want to program in C Sharp', 3),
(6, 'I want to learn DevOps', 4),
(7, 'I want to program in Java', 1),
(8, 'I want to use Docker, Kubernetes & Terraform', 4),
(9, 'I can''t decide between Azure or AWS.', 4);

ALTER SEQUENCE user_details_seq RESTART WITH 54;
ALTER SEQUENCE post_seq RESTART WITH 59;