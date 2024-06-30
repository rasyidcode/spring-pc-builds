-- User Table
CREATE TABLE IF NOT EXISTS `users`
(
    `id`       INT          NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(50)  NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `email`    VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`username`),
    UNIQUE (`email`)
);

-- Type Table
CREATE TABLE IF NOT EXISTS `types`
(
    `id`   INT          NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
);