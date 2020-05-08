INSERT INTO book (title, author, isbn)
VALUES ('Effective Java', 'Joshua Bloch', '978-0134685991');
INSERT INTO book (title, author, isbn)
VALUES ('Spring', 'Mark Spencer', '978-0134486257');

INSERT INTO book
VALUES (DEFAULT, 'Harvey Deitel', '978-0134777566', 'Java 9 for Programmers');
INSERT INTO book
VALUES (DEFAULT, 'Cay S. Horstmann', '978-0134694726', 'Core Java SE 9');


INSERT INTO comment (ctext, date, book_id)
VALUES ('comment 1 to book 1', '2020-05-06 18:53:05.066', 1);

INSERT INTO comment (ctext, date, book_id)
VALUES ('comment 2 to book 1', '2020-05-07 9:12:37.777', 1);

INSERT INTO comment (ctext, date, book_id)
VALUES ('comment 1 to book 2', '2020-05-08 11:22:45.234', 2);