
USE libra;

CREATE table Consumer(
                         consumerId INT auto_increment NOT NULL,
                         firstName VARCHAR(30) NOT NULL,
                         secondName VARCHAR(30) NOT NULL,
                         patronymic VARCHAR(30),
                         access_level VARCHAR(1) NOT NULL,
                         login VARCHAR(256) NOT NULL,
                         hash_password TEXT NOT NULL,

                         PRIMARY KEY (consumerId)
);

CREATE table Book(
                     bookId INT auto_increment NOT NULL,
                     bookName VARCHAR(4000) NOT NULL,
                     publishingHouse VARCHAR(100) NOT NULL,
                     place VARCHAR(100) NOT NULL,
                     description VARCHAR(4000) NOT NULL,

                     PRIMARY KEY (bookId)
);

CREATE table Instance(
                         instanceId INT auto_increment NOT NULL,
                         bookId INT NOT NULL,
                         presence INT NOT NULL,
                         quantity INT NOT NULL,

                         PRIMARY KEY (instanceId),
                         FOREIGN KEY (bookId) REFERENCES Book (bookId)
);

CREATE table SubscriptionCard(
                                 SubscriptionCardId INT auto_increment NOT NULL,
                                 consumerId INT NOT NULL,
                                 instanceId INT NOT NULL,
                                 dateOfReceiving DATE NOT NULL,
                                 planned_date DATE NOT NULL,
                                 returnDate DATE NOT NULL,
                                 PRIMARY KEY (SubscriptionCardId),
                                 FOREIGN KEY (consumerId) REFERENCES Consumer (consumerId),
                                 FOREIGN KEY (instanceId) REFERENCES Instance (instanceId)
);

CREATE table Genre(
                      genreId INT auto_increment NOT NULL,
                      GenreName VARCHAR(50) NOT NULL,

                      PRIMARY KEY (genreId)
);

CREATE table GenreCatalog(
                             genreCatalogId INT auto_increment NOT NULL,
                             bookId INT NOT NULL,
                             genreId INT NOT NULL,

                             PRIMARY KEY (id),
                             FOREIGN KEY (bookId)

                                 REFERENCES Book (bookId),
                             FOREIGN KEY (genreId) REFERENCES Genre (genreId)
);

CREATE table Author(
                       authorId INT auto_increment NOT NULL,
                       firstNameAuthor VARCHAR(100) NOT NULL,
                       lastNameAuthor VARCHAR(100) NOT NULL,
                       patronymicAuthor VARCHAR(100) NOT NULL,

                       PRIMARY KEY (authorId)
);

CREATE table Information(
                            id INT auto_increment NOT NULL,
                            authorId INT NOT NULL,
                            bookId INT NOT NULL,

                            PRIMARY KEY (id),
                            FOREIGN KEY (bookId) REFERENCES Book (bookId),
                            FOREIGN KEY (authorId) REFERENCES Author (authorId)
);