INSERT INTO user_details
(id, name, birth_date, email)
VALUES
(1, 'Alice', '2006-04-01', 'alice@gmail.com'),
(2, 'Bob', '2003-08-06', 'bob@outlook.com'),
(3, 'Cathy', '1999-04-24', 'cathy@yahooo.com'),
(4, 'David', '2001-05-01', 'david@telkomsa.net');

ALTER SEQUENCE user_details_seq RESTART WITH 54;