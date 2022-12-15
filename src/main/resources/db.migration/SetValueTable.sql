INSERT INTO Genre(GenreName)
VALUES
    ('Детектив'),
    ('Мистика'),
    ('Приключения'),
    ('Ужасы'),
    ("Триллер"),
    ("Фантастика"),
    ("Фэнтези"),
    ("Сказки");

INSERT INTO `Сlient`( `firstName`, `secondName`, `access_level`, `login`, `hash_password`)
VALUES
    ('Денис','Администратор',"1","admin","password"),
    ("Максим","Покупатель","2","firstUser","password");

INSERT INTO `Book`( `bookName`, `publishingHouse`, `place`, `description`)

VALUES
    ('Задача выжить','Росмэн','Москва','Представьте, что по дороге на работу вы задремали в маршрутке. Вас разбудили крики ужаса, а вокруг творится невесть что - одна за другой взрываются машины на проспек... '),
    ('Нам выходить на следующей','ОНИКС','Москва','В центре романа «Нам выходить на следующей» – история трех женщин: бабушки, матери и внучки, каждая из которых уверена, что найдет свою любовь и будет счастлива.'),
    (	'Конституция Российской Федерации','ГРАНД-ФАИР','СПБ','Конститу́ция Росси́йской Федера́ции — высший нормативный правовой акт Российской Федерации'),
    ('Собирайся, мы уезжаем: Глянец','Интеллект','Саратов','«Собирайся, мы уезжаем» – моя дебютная повесть. Редактор выловила ее из залежей папок, которые громоздились на подоконнике, заслоняя дневной свет. Это книга искренняя, наивная, одновременно жесткая,'),
    ('Правила дорожного движения','Росмэн','Саратов','Актуальные правила дорожного движения РФ с самыми последними изменениями. '),
    ('Milk and Honey. Белые стихи, покорившие мир','ГРАНД-ФАИР','Москва','Книга, которую никто не хотел издавать.'),
    ('Файлы Фредди ','ОНИКС','Саратов','Дополненное новое издание! Такого вы ещё не знали! Эту книгу вы так долго ждали!'),
    ('Тело помнит все','ГРАНД-ФАИР','СПБ','Психологическая травма нарушает нашу способность доверять внутренним чувствам, и это недоверие заставляет нас неправильно воспринимать угрозу там, где ее нет. Травма отражается на нашем разуме и эмоциональном состоянии, '),
    ('Ребенок в тебе должен обрести дом','Росмэн','Москва','Когда Сабина забывает купить любимую колбасу мужа, Михаэль гневается и кричит на неё. Дело не в колбасе: Михаэлю в этот момент кажется, будто его желания и потребности игнорируются. Так регулярно поступала его мать.'),
    ('Хочу и буду','ОНИКС','СПБ','Знаменитые шесть парвил Михаила Лабковского - в новом дополненном и расширенном издании.'),
    ('Земля Королей. Червовый том','Росмэн','Москва','Восемь карточных олицетворений, валеты и короли четырёх мастей с абсолютно разными характерами и темпераментами, оказались заперты друг с другом в параллельном измерении');

INSERT INTO `Instance` ( bookId, presence, quantity)
VALUES
    (1,1,10000000),
    (2,1,10000000),
    (3,1,10000000),
    (4,1,10000000),
    (5,1,10000000),
    (6,1,10000000),
    (7,1,10000000),
    (8,1,10000000),
    (9,1,10000000),
    (10,1,10000000),
    (11,1,10000000);

INSERT INTO `GenreCatalog`( `bookId`, `genreId`)
VALUES
    ('1','8'),
    ('2','4'),
    ('3','5'),
    ('4','6'),
    ('5','3'),
    ('6','7'),
    ('7','10'),
    ('8','5'),
    ('9','9'),
    ('10','11'),
    ('11','5');