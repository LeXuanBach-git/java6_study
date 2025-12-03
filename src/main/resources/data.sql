INSERT INTO todos(title, description, completed) VALUES('Todo 1', 'Description 1', 0);
INSERT INTO todos(title, description, completed) VALUES('Todo 2', 'Description 2', 0);

INSERT INTO books (title, author, price, isbn)
VALUES ('Java Programming Basics', 'Nguyen Van A', 199000, 'ISBN-001');
INSERT INTO books (title, author, price, isbn)
VALUES ('Spring Boot in Action', 'Tran Thi B', 259000, 'ISBN-002');
INSERT INTO books (title, author, price, isbn)
VALUES ('Database Design', 'Le Van C', 179000, 'ISBN-003');



INSERT INTO users(name, username, email, password) VALUES('user', 'user', 'user@gmail.com', '$2a$10$ZJ95pqs8zJVEaXMiyXR49unS/21S.BoDd/yfNXXtkWeJ627r5eLWm'); -- password = 123456
INSERT INTO users(name, username, email, password) VALUES('admin', 'admin', 'admin@gmail.com', '$2a$10$ZJ95pqs8zJVEaXMiyXR49unS/21S.BoDd/yfNXXtkWeJ627r5eLWm');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);


