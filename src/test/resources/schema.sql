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
-- CREATE TABLE IF NOT EXISTS `types`
-- (
--     `id`   INT          NOT NULL AUTO_INCREMENT,
--     `name` VARCHAR(100) NOT NULL,
--     PRIMARY KEY (`id`)
-- );

-- Component Type
CREATE TABLE IF NOT EXISTS `components`
(
    `id`         INT          NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(255) NOT NULL DEFAULT NULL,
    `type`       VARCHAR(50)  NOT NULL DEFAULT NULL,
    `brand`      VARCHAR(50)  NOT NULL DEFAULT NULL,
    `model`      VARCHAR(50)  NOT NULL DEFAULT NULL,
    `specs`      TEXT         NULL DEFAULT NULL,
    `price`      DOUBLE       NOT NULL DEFAULT NULL,
    `created_at` TIMESTAMP    NULL DEFAULT (now()),
    `updated_at` TIMESTAMP    NULL DEFAULT (now()) ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)