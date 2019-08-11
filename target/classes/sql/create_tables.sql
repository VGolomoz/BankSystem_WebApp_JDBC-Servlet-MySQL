CREATE SCHEMA `bank_system` DEFAULT CHARACTER SET utf8;
use `bank_system`;

CREATE TABLE users (
user_id int NOT NULL AUTO_INCREMENT,
mail varchar(255) NOT NULL UNIQUE,
`password` varchar(255) NOT NULL,
`role` varchar(255) NOT NULL,
PRIMARY KEY(user_id)
);

CREATE TABLE user_account (
user_id int NOT NULL UNIQUE,
balance FLOAT NOT NULL,
currency VARCHAR(255) NOT NULL,
validity DATE NOT NULL,
deposit BOOLEAN NOT NULL,
credit BOOLEAN NOT NULL,
PRIMARY KEY(user_id)
);

CREATE TABLE contact_details (
user_id int NOT NULL,
`name` VARCHAR(255) NOT NULL,
lastName VARCHAR(255) NOT NULL,
address VARCHAR(255),
mobilePhone VARCHAR(255) NOT NULL,
mail varchar(255) NOT NULL UNIQUE,
birthday DATE NOT NULL,
PRIMARY KEY(user_id)
);

CREATE TABLE deposit_accounts (
user_id int NOT NULL,
balance FLOAT NOT NULL,
currency VARCHAR(255) NOT NULL,
rate FLOAT NOT NULL,
term DATE NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE credit_accounts (
user_id int NOT NULL,
balance FLOAT NOT NULL,
currency VARCHAR(255) NOT NULL,
`limit` FLOAT NOT NULL,
rate FLOAT NOT NULL,
accrued_interest FLOAT NOT NULL,
PRIMARY KEY(user_id)
);

CREATE TABLE op_credit_proof (
user_id int NOT NULL,
manager_id int,
decision BOOLEAN,
`date` DATETIME NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE op_bill_payment (
user_id int NOT NULL,
bill_number VARCHAR(255) NOT NULL,
purpose VARCHAR(255) NOT NULL,
amount FLOAT NOT NULL,
`date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE op_transfer (
sender_id int NOT NULL,
recipient_mail VARCHAR(255) NOT NULL,
amount FLOAT NOT NULL,
`date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE op_replenishment (
user_id int NOT NULL,
amount FLOAT NOT NULL,
accName VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE `user_account` ADD CONSTRAINT `user_account_fk0`
FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`);

ALTER TABLE `contact_details` ADD CONSTRAINT `contact_details_fk0`
FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`);

ALTER TABLE `deposit_accounts` ADD CONSTRAINT `deposit_accounts_fk0`
FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`);

ALTER TABLE `credit_accounts` ADD CONSTRAINT `credit_accounts_fk0`
FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`);

ALTER TABLE `op_credit_proof` ADD CONSTRAINT `op_credit_proof_fk0`
FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`);



