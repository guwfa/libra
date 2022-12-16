-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Хост: localhost:3306
-- Время создания: Дек 16 2022 г., 21:08
-- Версия сервера: 8.0.31-0ubuntu0.22.04.1
-- Версия PHP: 8.1.2-1ubuntu2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `libra`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Author`
--

CREATE TABLE `Author` (
                          `authorId` int NOT NULL,
                          `firstNameAuthor` varchar(100) NOT NULL,
                          `lastNameAuthor` varchar(100) NOT NULL,
                          `patronymicAuthor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `Author`
--

INSERT INTO `Author` (`authorId`, `firstNameAuthor`, `lastNameAuthor`, `patronymicAuthor`) VALUES
                                                                                               (1, 'Михаил', 'Атаманов', 'Михайлович'),
                                                                                               (2, 'Маша', 'Трауб', 'Сергеевна'),
                                                                                               (3, 'Сергей', 'Шахрай', 'Михайлович'),
                                                                                               (4, 'Гай', 'Цезарь', 'Юлий'),
                                                                                               (5, 'Александр', 'Мартынов', 'Владимирович'),
                                                                                               (6, ' Кира', 'Брид', 'Райсли'),
                                                                                               (7, 'Владимир', 'Высоцкий', 'Семенович');

-- --------------------------------------------------------

--
-- Структура таблицы `Book`
--

CREATE TABLE `Book` (
                        `bookId` int NOT NULL,
                        `bookName` varchar(4000) NOT NULL,
                        `publishingHouse` varchar(100) NOT NULL,
                        `place` varchar(100) NOT NULL,
                        `description` varchar(4000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `Book`
--

INSERT INTO `Book` (`bookId`, `bookName`, `publishingHouse`, `place`, `description`) VALUES
                                                                                         (2, 'Нам выходить на следующей', 'ОНИКС', 'Москва', 'В центре романа «Нам выходить на следующей» – история трех женщин: бабушки, матери и внучки, каждая из которых уверена, что найдет свою любовь и будет счастлива.'),
                                                                                         (3, 'Конституция Российской Федерации', 'ГРАНД-ФАИР', 'СПБ', 'Конститу́ция Росси́йской Федера́ции — высший нормативный правовой акт Российской Федерации'),
                                                                                         (4, 'Собирайся, мы уезжаем: Глянец', 'Интеллект', 'Саратов', '«Собирайся, мы уезжаем» – моя дебютная повесть. Редактор выловила ее из залежей папок, которые громоздились на подоконнике, заслоняя дневной свет. Это книга искренняя, наивная, одновременно жесткая,'),
                                                                                         (5, 'Правила дорожного движения', 'Росмэн', 'Саратов', 'Актуальные правила дорожного движения РФ с самыми последними изменениями. '),
                                                                                         (6, 'Milk and Honey. Белые стихи, покорившие мир', 'ГРАНД-ФАИР', 'Москва', 'Книга, которую никто не хотел издавать. '),
                                                                                         (7, 'Файлы Фредди ', 'ОНИКС', 'Саратов', 'Дополненное новое издание! Такого вы ещё не знали! Эту книгу вы так долго ждали!'),
                                                                                         (8, 'Тело помнит все', 'ГРАНД-ФАИР', 'СПБ', 'Психологическая травма нарушает нашу способность доверять внутренним чувствам, и это недоверие заставляет нас неправильно воспринимать угрозу там, где ее нет. Травма отражается на нашем разуме и эмоциональном состоянии, '),
                                                                                         (9, 'Ребенок в тебе должен обрести дом', 'Росмэн', 'Москва', 'Когда Сабина забывает купить любимую колбасу мужа, Михаэль гневается и кричит на неё. Дело не в колбасе: Михаэлю в этот момент кажется, будто его желания и потребности игнорируются. Так регулярно поступала его мать.'),
                                                                                         (10, 'Хочу и буду', 'ОНИКС', 'СПБ', 'Знаменитые шесть парвил Михаила Лабковского - в новом дополненном и расширенном издании.'),
                                                                                         (11, 'Земля Королей. Червовый том', 'Росмэн', 'Москва', 'Восемь карточных олицетворений, валеты и короли четырёх мастей с абсолютно разными характерами и темпераментами, оказались заперты друг с другом в параллельном измерении');

-- --------------------------------------------------------

--
-- Структура таблицы `Genre`
--

CREATE TABLE `Genre` (
                         `genreId` int NOT NULL,
                         `GenreName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `Genre`
--

INSERT INTO `Genre` (`genreId`, `GenreName`) VALUES
                                                 (3, 'Боевик'),
                                                 (4, 'Детектив'),
                                                 (5, 'Мистика'),
                                                 (6, 'Приключения'),
                                                 (7, 'Ужасы'),
                                                 (8, 'Триллер'),
                                                 (9, 'Фантастика'),
                                                 (10, 'Фэнтези'),
                                                 (11, 'Сказки');

-- --------------------------------------------------------

--
-- Структура таблицы `GenreCatalog`
--

CREATE TABLE `GenreCatalog` (
                                `genreCatalogId` int NOT NULL,
                                `bookId` int NOT NULL,
                                `genreId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `GenreCatalog`
--

INSERT INTO `GenreCatalog` (`genreCatalogId`, `bookId`, `genreId`) VALUES
                                                                       (2, 2, 4),
                                                                       (3, 3, 5),
                                                                       (4, 4, 6),
                                                                       (5, 5, 3),
                                                                       (6, 6, 7),
                                                                       (7, 7, 10),
                                                                       (8, 8, 5),
                                                                       (9, 9, 9),
                                                                       (10, 10, 11),
                                                                       (11, 11, 5);

-- --------------------------------------------------------

--
-- Структура таблицы `Information`
--

CREATE TABLE `Information` (
                               `id` int NOT NULL,
                               `authorId` int NOT NULL,
                               `bookId` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `Information`
--

INSERT INTO `Information` (`id`, `authorId`, `bookId`) VALUES
                                                           (12, 2, 2),
                                                           (13, 3, 3),
                                                           (14, 4, 4),
                                                           (15, 5, 5),
                                                           (16, 6, 6),
                                                           (17, 7, 7),
                                                           (18, 4, 8),
                                                           (19, 5, 9),
                                                           (20, 6, 10),
                                                           (21, 7, 11);

-- --------------------------------------------------------

--
-- Структура таблицы `Instance`
--

CREATE TABLE `Instance` (
                            `instanceId` int NOT NULL,
                            `bookId` int NOT NULL,
                            `presence` int NOT NULL,
                            `quantity` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `Instance`
--

INSERT INTO `Instance` (`instanceId`, `bookId`, `presence`, `quantity`) VALUES
                                                                            (1, 2, 1, 10000000),
                                                                            (2, 3, 1, 10000),
                                                                            (3, 4, 1, 10000000),
                                                                            (4, 5, 1, 200000),
                                                                            (5, 6, 1, 10000000),
                                                                            (6, 7, 1, 1000000),
                                                                            (7, 8, 1, 30000000),
                                                                            (8, 9, 1, 10000000),
                                                                            (9, 10, 1, 10000000),
                                                                            (10, 11, 1, 100000);

-- --------------------------------------------------------

--
-- Структура таблицы `security`
--

CREATE TABLE `security` (
                            `securityId` int NOT NULL,
                            `clientId` int NOT NULL,
                            `login` varchar(256) NOT NULL,
                            `hashPass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `security`
--

INSERT INTO `security` (`securityId`, `clientId`, `login`, `hashPass`) VALUES
                                                                           (1, 1, 'admin', '4e2c6bdf10480a89fb092e92fa8a8ea5bea96ae714afa0d13bbb14dcb679875b15561cb45168b9bd481d6c658fead87c791ce1c1e5226b8b3fc4219c18414490'),
                                                                           (2, 2, 'user', 'e2c0ff2b2344a72a72b1ca30bd1ce066e8ea945399a3258c5e9f008256469bcc548dbf6d1e15b0443eab97a63efad283554eb4c0572d446d25ac959627f51aed');

-- --------------------------------------------------------

--
-- Структура таблицы `SubscriptionCard`
--

CREATE TABLE `SubscriptionCard` (
                                    `SubscriptionCardId` int NOT NULL,
                                    `clientId` int NOT NULL,
                                    `instanceId` int NOT NULL,
                                    `dateOfReceiving` date NOT NULL,
                                    `planned_date` date NOT NULL,
                                    `returnDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `SubscriptionCard`
--

INSERT INTO `SubscriptionCard` (`SubscriptionCardId`, `clientId`, `instanceId`, `dateOfReceiving`, `planned_date`, `returnDate`) VALUES
                                                                                                                                     (13, 2, 3, '2022-12-14', '2022-12-14', '2022-12-24'),
                                                                                                                                     (16, 2, 8, '2022-12-14', '2022-12-14', '2022-12-24'),
                                                                                                                                     (17, 2, 10, '2022-12-14', '2022-12-14', '2022-12-24'),
                                                                                                                                     (18, 2, 3, '2022-12-16', '2022-12-16', '2022-12-26'),
                                                                                                                                     (19, 2, 3, '2022-12-16', '2022-12-16', '2022-12-26');

-- --------------------------------------------------------

--
-- Структура таблицы `Сlient`
--

CREATE TABLE `Сlient` (
                          `clientId` int NOT NULL,
                          `firstName` varchar(30) NOT NULL,
                          `secondName` varchar(30) NOT NULL,
                          `patronymic` varchar(30) DEFAULT NULL,
                          `access_level` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `Сlient`
--

INSERT INTO `Сlient` (`clientId`, `firstName`, `secondName`, `patronymic`, `access_level`) VALUES
                                                                                               (1, 'Денис', 'Администратор', NULL, '1'),
                                                                                               (2, 'Максим', 'Покупатель', NULL, '2');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Author`
--
ALTER TABLE `Author`
    ADD PRIMARY KEY (`authorId`);

--
-- Индексы таблицы `Book`
--
ALTER TABLE `Book`
    ADD PRIMARY KEY (`bookId`);

--
-- Индексы таблицы `Genre`
--
ALTER TABLE `Genre`
    ADD PRIMARY KEY (`genreId`);

--
-- Индексы таблицы `GenreCatalog`
--
ALTER TABLE `GenreCatalog`
    ADD PRIMARY KEY (`genreCatalogId`),
    ADD KEY `bookId` (`bookId`),
    ADD KEY `genreId` (`genreId`);

--
-- Индексы таблицы `Information`
--
ALTER TABLE `Information`
    ADD PRIMARY KEY (`id`),
    ADD KEY `bookId` (`bookId`),
    ADD KEY `authorId` (`authorId`);

--
-- Индексы таблицы `Instance`
--
ALTER TABLE `Instance`
    ADD PRIMARY KEY (`instanceId`),
    ADD KEY `bookId` (`bookId`);

--
-- Индексы таблицы `security`
--
ALTER TABLE `security`
    ADD PRIMARY KEY (`securityId`),
    ADD KEY `clientId` (`clientId`);

--
-- Индексы таблицы `SubscriptionCard`
--
ALTER TABLE `SubscriptionCard`
    ADD PRIMARY KEY (`SubscriptionCardId`),
    ADD KEY `clientId` (`clientId`),
    ADD KEY `instanceId` (`instanceId`);

--
-- Индексы таблицы `Сlient`
--
ALTER TABLE `Сlient`
    ADD PRIMARY KEY (`clientId`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Author`
--
ALTER TABLE `Author`
    MODIFY `authorId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT для таблицы `Book`
--
ALTER TABLE `Book`
    MODIFY `bookId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT для таблицы `Genre`
--
ALTER TABLE `Genre`
    MODIFY `genreId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT для таблицы `GenreCatalog`
--
ALTER TABLE `GenreCatalog`
    MODIFY `genreCatalogId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT для таблицы `Information`
--
ALTER TABLE `Information`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT для таблицы `Instance`
--
ALTER TABLE `Instance`
    MODIFY `instanceId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблицы `security`
--
ALTER TABLE `security`
    MODIFY `securityId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `SubscriptionCard`
--
ALTER TABLE `SubscriptionCard`
    MODIFY `SubscriptionCardId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT для таблицы `Сlient`
--
ALTER TABLE `Сlient`
    MODIFY `clientId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `GenreCatalog`
--
ALTER TABLE `GenreCatalog`
    ADD CONSTRAINT `GenreCatalog_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `Book` (`bookId`),
    ADD CONSTRAINT `GenreCatalog_ibfk_2` FOREIGN KEY (`genreId`) REFERENCES `Genre` (`genreId`);

--
-- Ограничения внешнего ключа таблицы `Information`
--
ALTER TABLE `Information`
    ADD CONSTRAINT `Information_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `Book` (`bookId`),
    ADD CONSTRAINT `Information_ibfk_2` FOREIGN KEY (`authorId`) REFERENCES `Author` (`authorId`);

--
-- Ограничения внешнего ключа таблицы `Instance`
--
ALTER TABLE `Instance`
    ADD CONSTRAINT `Instance_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `Book` (`bookId`);

--
-- Ограничения внешнего ключа таблицы `security`
--
ALTER TABLE `security`
    ADD CONSTRAINT `security_ibfk_1` FOREIGN KEY (`clientId`) REFERENCES `Сlient` (`clientId`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Ограничения внешнего ключа таблицы `SubscriptionCard`
--
ALTER TABLE `SubscriptionCard`
    ADD CONSTRAINT `SubscriptionCard_ibfk_1` FOREIGN KEY (`clientId`) REFERENCES `Сlient` (`clientId`),
    ADD CONSTRAINT `SubscriptionCard_ibfk_2` FOREIGN KEY (`instanceId`) REFERENCES `Instance` (`instanceId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;