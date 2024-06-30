-- Populate users table
INSERT INTO `users` (`username`, `password`, `email`)
VALUES ('dtrump', '12345', 'dtrump@example.com'),
       ('jbiden', 'secret', 'jbiden@example.com'),
       ('bobama', 'password', 'bobama@example.com');

-- Populate types table
INSERT INTO `types` (`name`)
VALUES ('CPU'),
       ('RAM'),
       ('VGA'),
       ('PSU'),
       ('Motherboard');