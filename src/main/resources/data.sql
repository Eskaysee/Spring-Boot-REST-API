INSERT IGNORE INTO user_details
(id, name, birth_date, email)
VALUES
(4, 'David', '2001-05-01', 'dave@telkomsa.net');

INSERT IGNORE INTO post(id, description, user_id)
VALUES (6, 'I want to learn DevOps', 4),
(7, 'I want to program in Java', 1),
(8, 'I want to use Docker, Kubernetes & Terraform', 4),
(9, 'I can''t decide between Azure or AWS.', 4);