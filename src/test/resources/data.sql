-- Populate users table
INSERT INTO `users` (`username`, `password`, `email`)
VALUES ('dtrump', '12345', 'dtrump@example.com'),
       ('jbiden', 'secret', 'jbiden@example.com'),
       ('bobama', 'password', 'bobama@example.com');

-- Populate types table
-- INSERT INTO `types` (`name`)
-- VALUES ('CPU'),
--        ('RAM'),
--        ('VGA'),
--        ('PSU'),
--        ('Motherboard');

-- Populate components table
INSERT INTO `components` (`name`, `type`, `brand`, `model`, `specs`, `price`)
VALUES ('Ryzen 5 5600X', 'CPU', 'AMD', '5600X', '{"cores":6,"threads":12}', 299.99),
       ('GeForce RTX 3060 Ti', 'GPU', 'NVIDIA', '3060 Ti', '{"memory": "8GB GDDR6", "core_clock": "1410MHz", "boost_clock": "1665MHz"}', 399.99),
       ('ASUS ROG Strix B550-F', 'Motherboard', 'ASUS', 'ROG Strix B550-F', '{"socket": "AM4", "form_factor": "ATX", "chipset": "B550"}', 189.99);