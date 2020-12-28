CREATE SCHEMA IF NOT EXISTS lab_3 DEFAULT CHARACTER SET utf8 ;
USE lab_3 ;

DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS phone;
DROP TABLE IF EXISTS passport;
DROP TABLE IF EXISTS booking;
DROP TABLE IF EXISTS guest;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS hotel_chain;


CREATE TABLE IF NOT EXISTS lab_3.hotel_chain (
                                                 hotel_chain_id INT NOT NULL AUTO_INCREMENT,
                                                 name VARCHAR(45) NOT NULL,
                                                 PRIMARY KEY (hotel_chain_id))
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS lab_3.country (
                                             country_id INT NOT NULL AUTO_INCREMENT,
                                             country VARCHAR(45) NOT NULL,
                                             PRIMARY KEY (country_id))
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS lab_3.hotel (
                                           hotel_id INT NOT NULL AUTO_INCREMENT,
                                           hotel_chain_id INT NOT NULL,
                                           country_id INT NOT NULL,
                                           name VARCHAR(45) NOT NULL,
                                           PRIMARY KEY (hotel_id),
                                           INDEX fk_hotel_hotel_chain1_idx (hotel_chain_id ASC) VISIBLE,
                                           INDEX fk_hotel_country1_idx (country_id ASC) VISIBLE,
                                           CONSTRAINT fk_hotel_hotel_chain1
                                               FOREIGN KEY (hotel_chain_id)
                                                   REFERENCES lab_3.hotel_chain (hotel_chain_id)
                                                   ON DELETE NO ACTION
                                                   ON UPDATE NO ACTION,
                                           CONSTRAINT fk_hotel_country1
                                               FOREIGN KEY (country_id)
                                                   REFERENCES lab_3.country (country_id)
                                                   ON DELETE NO ACTION
                                                   ON UPDATE NO ACTION)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS lab_3.review (
                                            review_id INT NOT NULL AUTO_INCREMENT,
                                            text TEXT(1000) NOT NULL,
                                            date DATE NOT NULL,
                                            hotel_id INT NOT NULL,
                                            PRIMARY KEY (review_id),
                                            INDEX fk_review_hotel1_idx (hotel_id ASC) VISIBLE,
                                            CONSTRAINT fk_review_hotel1
                                                FOREIGN KEY (hotel_id)
                                                    REFERENCES lab_3.hotel (hotel_id)
                                                    ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS lab_3.room (
                                          room_id INT NOT NULL AUTO_INCREMENT,
                                          max_persons TINYINT(5) NOT NULL,
                                          price_per_night DECIMAL(5,2) NOT NULL,
                                          status TINYINT(1) NOT NULL,
                                          hotel_id INT NOT NULL,
                                          PRIMARY KEY (room_id),
                                          INDEX fk_room_hotel1_idx (hotel_id ASC) VISIBLE,
                                          CONSTRAINT fk_room_hotel1
                                              FOREIGN KEY (hotel_id)
                                                  REFERENCES lab_3.hotel (hotel_id)
                                                  ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS lab_3.guest (
                                           guest_id INT NOT NULL AUTO_INCREMENT,
                                           first_name VARCHAR(45) NOT NULL,
                                           last_name VARCHAR(45) NOT NULL,
                                           state_of_account TINYINT(1) NOT NULL,
                                           PRIMARY KEY (guest_id))
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS lab_3.booking (
                                             booking_id INT NOT NULL AUTO_INCREMENT,
                                             start_date DATE NOT NULL,
                                             end_date VARCHAR(45) NOT NULL,
                                             guest_id INT NOT NULL,
                                             room_id INT NOT NULL,
                                             INDEX fk_room_has_guest_guest1_idx (guest_id ASC) VISIBLE,
                                             INDEX fk_room_has_guest_room1_idx (room_id ASC) VISIBLE,
                                             PRIMARY KEY (booking_id),
                                             CONSTRAINT fk_room_has_guest_room1
                                                 FOREIGN KEY (room_id)
                                                     REFERENCES lab_3.room (room_id)
                                                     ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION,
                                             CONSTRAINT fk_room_has_guest_guest1
                                                 FOREIGN KEY (guest_id)
                                                     REFERENCES lab_3.guest (guest_id)
                                                     ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS lab_3.email (
                                           email_id INT NOT NULL AUTO_INCREMENT,
                                           email VARCHAR(60) NOT NULL,
                                           guest_id INT NOT NULL,
                                           PRIMARY KEY (email_id),
                                           INDEX fk_email_guest1_idx (guest_id ASC) VISIBLE,
                                           CONSTRAINT fk_email_guest1
                                               FOREIGN KEY (guest_id)
                                                   REFERENCES lab_3.guest (guest_id)
                                                   ON DELETE NO ACTION
                                                   ON UPDATE NO ACTION)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS lab_3.phone (
                                           phone_id INT NOT NULL AUTO_INCREMENT,
                                           number VARCHAR(20) NOT NULL,
                                           guest_id INT NOT NULL,
                                           PRIMARY KEY (phone_id),
                                           INDEX fk_phone_guest1_idx (guest_id ASC) VISIBLE,
                                           CONSTRAINT fk_phone_guest1
                                               FOREIGN KEY (guest_id)
                                                   REFERENCES lab_3.guest (guest_id)
                                                   ON DELETE NO ACTION
                                                   ON UPDATE NO ACTION)
    ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS lab_3.passport (
                                              passport_id INT NOT NULL AUTO_INCREMENT,
                                              code INT NOT NULL,
                                              guest_id INT NOT NULL,
                                              PRIMARY KEY (passport_id),
                                              INDEX fk_passport_guest1_idx (guest_id ASC) VISIBLE,
                                              CONSTRAINT fk_passport_guest1
                                                  FOREIGN KEY (guest_id)
                                                      REFERENCES lab_3.guest (guest_id)
                                                      ON DELETE NO ACTION
                                                      ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE INDEX name_index ON hotel_chain (name);
CREATE INDEX country_index ON country (country);



INSERT INTO hotel_chain(hotel_chain_id, name) VALUES
(1, 'Hotel 1'),
(2, 'Hotel 2'),
(3, 'Hotel 3'),
(4, 'Hotel 4'),
(5, 'Hotel 5'),
(6, 'Hotel 6'),
(7, 'Hotel 7'),
(8, 'Hotel 8'),
(9, 'Hotel 9'),
(10, 'Hotel 10');

INSERT INTO country(country_id, country) VALUES
(1, 'Country 1'),
(2, 'Country 2'),
(3, 'Country 3'),
(4, 'Country 4'),
(5, 'Country 5'),
(6, 'Country 6'),
(7, 'Country 7'),
(8, 'Country 8'),
(9, 'Country 9'),
(10, 'Country 10');

INSERT INTO hotel(hotel_id, hotel_chain_id, country_id, name) VALUES
(1, 1, 1, 'Hotel 1'),
(2, 2, 2, 'Hotel 2'),
(3, 3, 3, 'Hotel 3'),
(4, 4, 4, 'Hotel 4'),
(5, 5, 5, 'Hotel 5'),
(6, 6, 6, 'Hotel 6'),
(7, 7, 7, 'Hotel 7'),
(8, 8, 8, 'Hotel 8'),
(9, 9, 9, 'Hotel 9'),
(10, 10, 10, 'Hotel 10');

INSERT INTO review(review_id, text, date, hotel_id) VALUES
(1, 'Some text 1', '2019-09-23', 1),
(2, 'Some text 2', '2019-09-23', 2),
(3, 'Some text 3', '2019-09-23', 3),
(4, 'Some text 4', '2019-09-23', 4),
(5, 'Some text 5', '2019-09-23', 5),
(6, 'Some text 6', '2019-09-23', 6),
(7, 'Some text 7', '2019-09-23', 7),
(8, 'Some text 8', '2019-09-23', 8),
(9, 'Some text 9', '2019-09-23', 9),
(10, 'Some text 10', '2019-09-23', 10);

INSERT INTO room(room_id, max_persons, price_per_night, status, hotel_id) VALUES
(1, 2, 100, 1, 1),
(2, 2, 100, 1, 2),
(3, 4, 200, 1, 3),
(4, 4, 200, 1, 4),
(5, 4, 200, 1, 5),
(6, 4, 200, 1, 6),
(7, 4, 200, 1, 7),
(8, 4, 200, 1, 8),
(9, 4, 200, 1, 9),
(10, 4, 200, 1, 10);

INSERT INTO guest(guest_id, first_name, last_name, state_of_account) VALUES
(1, 'Ivan', 'Ivanov', 1),
(2, 'Ivan', 'Ivanov', 1),
(3, 'Ivan', 'Ivanov', 1),
(4, 'Ivan', 'Ivanov', 1),
(5, 'Ivan', 'Ivanov', 1),
(6, 'Ivan', 'Ivanov', 1),
(7, 'Ivan', 'Ivanov', 1),
(8, 'Ivan', 'Ivanov', 1),
(9, 'Ivan', 'Ivanov', 1),
(10, 'Ivan', 'Ivanov', 1);

INSERT INTO booking(booking_id, start_date, end_date, guest_id, room_id) VALUES
(1, '2019-05-01', '2019-05-10', 1, 1),
(2, '2019-05-01', '2019-05-10', 2, 2),
(3, '2019-05-01', '2019-05-10', 3, 3),
(4, '2019-05-01', '2019-05-10', 4, 4),
(5, '2019-05-01', '2019-05-10', 5, 5),
(6, '2019-05-01', '2019-05-10', 6, 6),
(7, '2019-05-01', '2019-05-10', 7, 7),
(8, '2019-05-01', '2019-05-10', 8, 8),
(9, '2019-05-01', '2019-05-10', 9, 9),
(10, '2019-05-01', '2019-05-10', 10, 10);

INSERT INTO passport(passport_id, code, guest_id) VALUES
(1, 123456, 1),
(2, 123456, 2),
(3, 123456, 3),
(4, 123456, 4),
(5, 123456, 5),
(6, 123456, 6),
(7, 123456, 7),
(8, 123456, 8),
(9, 123456, 9),
(10, 123456, 10);

INSERT INTO phone(phone_id, number, guest_id) VALUES
(1, '+1-202-555-0196', 1),
(2, '+1-202-555-0196', 2),
(3, '+1-202-555-0196', 3),
(4, '+1-202-555-0196', 4),
(5, '+1-202-555-0196', 5),
(6, '+1-202-555-0196', 6),
(7, '+1-202-555-0196', 7),
(8, '+1-202-555-0196', 8),
(9, '+1-202-555-0196', 9),
(10, '+1-202-555-0196', 10);

INSERT INTO email(email_id, email, guest_id) VALUES
(1, 'some.mail@gmail.com', 1),
(2, 'some.mail@gmail.com', 2),
(3, 'some.mail@gmail.com', 3),
(4, 'some.mail@gmail.com', 4),
(5, 'some.mail@gmail.com', 5),
(6, 'some.mail@gmail.com', 6),
(7, 'some.mail@gmail.com', 7),
(8, 'some.mail@gmail.com', 8),
(9, 'some.mail@gmail.com', 9),
(10, 'some.mail@gmail.com', 10);


