package ru.sstu.entity.util;



import org.apache.log4j.Logger;
import ru.sstu.entity.domain.*;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.Date;
import java.util.*;


public class DatabaseConnection {
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class);

    private static final String NAME_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/libra";
    static final String DATABASE_USER = "root";
    static final String DATABASE_PASSWORD = "QWEasdZXC123";

    /*Запросы к бд ВСЕХ объектов*/
    static final String GET_ALL_USER = "SELECT Сlient.clientId ,Сlient.firstName, Сlient.secondName ,Сlient.patronymic, Сlient.access_level, security.login ,security.hashPass  FROM `Сlient` JOIN security On Сlient.clientId = security.clientId; ";

    static final String GET_ALL_INSTANCE = "SELECT * FROM Instance";
    static final String GET_ALL_BOOK = "SELECT * FROM Book";
    static final String GET_ALL_GENRE = "SELECT * FROM Genre";
    static final String GET_ALL_AUTHOR = "SELECT * FROM Author";
    static final String GET_ALL_SUBSCRIPTIONCARD = "SELECT * FROM SubscriptionCard";
    static   String GET_ALL_BOOK_CLIENT = "SELECT B.bookId, B.bookName, B.publishingHouse, B.place, B.description FROM Сlient JOIN SubscriptionCard SC on Сlient.clientId = SC.clientId JOIN Instance I on I.instanceId = SC.instanceId JOIN Book B on B.bookId = I.bookId WHERE Сlient.clientId = ?" ;



    /*Добавление ОДНОГО объекта*/
    static  String INSERT_BOOK = "INSERT INTO Book (bookName,publishingHouse,place,description) VALUES (?,?,?,?)";
    static  String INSERT_CLIENT = "INSERT INTO Сlient (firstName,secondName,patronymic,access_level) VALUES (?,?,?,?)";

    static  String INSERT_HASH = "INSERT INTO `security`(`securityId`, `clientId`, `login`, `hashPass`) VALUES (DEFAULT,DEFAULT,?,?)" ;
    static String INSERT_SubcriptionCard = "INSERT INTO `SubscriptionCard`(`SubscriptionCardId`, `clientId`, `instanceId`, `dateOfReceiving`, `planned_date`, `returnDate`) VALUES (DEFAULT,?,?,CURRENT_DATE,CURRENT_DATE,ADDDATE(CURRENT_DATE,INTERVAL 10 DAY))";


    /*Удаление ОДНОГО объекта*/
    static  String DELETE_BOOK = "DELETE FROM Book WHERE bookId=?";
    static  String DELETE_GENRECATALOG= "DELETE FROM GenreCatalog WHERE bookId=?";
    static String  DELETE_SUBCSRIPTIONCARD = "DELETE FROM SubscriptionCard WHERE SubscriptionCardId = ?";

    /*Обновление  ОДНОГО объекта*/
    static  String UPDATE_BOOK = "UPDATE Book SET bookName = ? ,publishingHouse = ?,place = ?,description = ?  WHERE bookId=?";

    /*Запрос ОДНОГО обхъекта*/

    static String GET_USER = "SELECT Сlient.clientId ,Сlient.firstName, Сlient.secondName ,Сlient.patronymic, Сlient.access_level, security.login ,security.hashPass  FROM `Сlient` JOIN security On Сlient.clientId = security.clientId WHERE security.login = ?";
    static String GET_INSTANCE = "SELECT * FROM Instance WHERE instanceId = ";


    static List<Instance> instanceList = getListInstance();


    /*Запрос ВСЕХ объектов*/
    public static HashMap<String, Client> getMapClients (){
        HashMap<String,Client> map = new HashMap<>();

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_USER);

            while (resultSet.next()) {
                map.put(
                        resultSet.getString(6),
                        new Client(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(6),
                                resultSet.getString(5),
                                resultSet.getString(7)
                        )
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        return  map;
    }

    static Instance getInstance(String id){
        Instance instance = null;

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(GET_INSTANCE + id);

            while (resultSet.next()) {

              instance =  new Instance(
                                resultSet.getInt(1),
                                resultSet.getInt(2),
                                resultSet.getInt(3),
                                resultSet.getInt(4)
                        );

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }


        return instance;
    }

    public static List<Instance> getListInstance(){
        List<Instance> list = new ArrayList<>();

        logger.info("getListInstance: Запрашиваю данные из таблицы Instance");

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_INSTANCE);

            while (resultSet.next()) {
                list.add(
                        new Instance(
                                resultSet.getInt(1),
                                resultSet.getInt(2),
                                resultSet.getInt(3),
                                resultSet.getInt(4)
                        )
                );
            }
            logger.info("getListInstance: Данные из таблицы  Instance");
            for(Instance instance : list){
                logger.info(instance.toString());
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }
        logger.info("getListInstance: Возвращаю данные из таблицы Instance");

        return  list;
    }

    public static List<Client> getListClient(){
        logger.info("Запрашиваю данные из таблицы Client");
        List<Client> listClient = new ArrayList<>();

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_USER);

            while (resultSet.next()) {
                listClient.add(
                        new Client(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(6),
                                resultSet.getString(5),
                                resultSet.getString(7)
                        )
                );
            }
            logger.info("Данные из таблицы  Client");
            for(Client client : listClient){
                logger.info(client.toString());
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }
        logger.info("Возвращаю данные из таблицы Client");
        return listClient;
    }

    public static List<Book> getListBook(){
        logger.info("getListBook: Запрашиваю данные из таблицы Book");
        List<Book> listBook = new ArrayList<>();

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_BOOK);

            while (resultSet.next()) {
                    listBook.add(
                            new Book(
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getString(3),
                                    resultSet.getString(4),
                                    resultSet.getString(5)
                            )
                    );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        logger.info("getListBook: Возвращаю  данные из таблицы Book");
        return listBook;
    }

    public static List<Genre> getListGenre(){
        logger.info("Запрашиваю данные из таблицы Genre");
        List<Genre> listGenre = new ArrayList<>();

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_GENRE);

            while (resultSet.next()) {
                listGenre.add(
                        new Genre(
                                resultSet.getInt(1),
                                resultSet.getString(2)
                        )
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        logger.info("Возвращаю  данные из таблицы Genre");
        return listGenre;
    }

    public static List<Author> getListAuthor(){
        logger.info("Запрашиваю данные из таблицы Author");
        List<Author> listAuthor = new ArrayList<>();

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_AUTHOR);

            while (resultSet.next()) {
                listAuthor.add(
                        new Author(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        )
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        logger.info("Возвращаю  данные из таблицы Author");
        return listAuthor;
    }

    public static List<SubcriptionCard> getListSubcriptionCard(){
        logger.info("Запрашиваю данные из таблицы SubcriptionCard");
        List<SubcriptionCard> listSubcriptionCard = new ArrayList<>();

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_SUBSCRIPTIONCARD);

            while (resultSet.next()) {
                listSubcriptionCard.add(
                        new SubcriptionCard(
                                resultSet.getInt(1),
                                resultSet.getInt(2),
                                resultSet.getInt(3),
                                resultSet.getDate(4),
                                resultSet.getDate(5),
                                resultSet.getDate(6)
                        )
                );
            }

            for (SubcriptionCard subcriptionCard : listSubcriptionCard){
                logger.info("SubcriptionCard info: " + subcriptionCard.toString());
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        logger.info("Возвращаю  данные из таблицы SubcriptionCard");
        return listSubcriptionCard;
    }

    public static List<Book> getAllBookToClientId(String clientId){

        logger.info("Запрашиваю выборку из таблиц  Book, Instance, SubscriptionCard,Client");
        List<Book> list = new ArrayList<>();

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(GET_ALL_BOOK_CLIENT);

            statement.setString(1, clientId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                 list.add(
                         new Book(
                                 resultSet.getInt(1),
                                 resultSet.getString(2),
                                 resultSet.getString(3),
                                 resultSet.getString(4),
                                 resultSet.getString(5)
                         )
                 );
            }
            logger.info("Возвращаю лист  Book: ");

            for(Book book : list){
                logger.info("Book: " + book.toString());
            }


            resultSet.close();
            statement.close();
            connection.close();


        }catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        return list;
    }

    /*Запрос ОДНОГО объекта*/

    public static Client getClient(String login){
        logger.info("Запрашиваю клиента  из  таблицы Client");
        logger.info("Данные из сигнатуры метода login= " + login);
        Client client = new Client();
        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            PreparedStatement preparedStatement  = connection.prepareStatement(GET_USER);

            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                client = new Client(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(6),
                        resultSet.getString(5),
                        resultSet.getString(7)
                );
            }

            logger.info(client.toString());

            resultSet.close();
            preparedStatement.close();
            connection.close();


        }catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }
        return client;
    }

    /*Добавление ОДНОГО объекта*/
    //Нужно добавить связей с другими таблицами
    public static void addBook(String bookName,String publishingHouse,String place,String description){
        logger.info("Начинаю добавление из  таблицы Book");

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(INSERT_BOOK);


            statement.setString(1, bookName);
            statement.setString(2,publishingHouse);
            statement.setString(3, place);
            statement.setString(4, description);

            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        logger.info("Данные в таблицу Book добавлены");
    }

    public static void addClient(String firstName,String secondName,String patronymic,String access_level,String login,String hash_password){
        logger.info("Начинаю добавление в таблицу Client");

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(INSERT_CLIENT);



            statement.setString(1, firstName);
            statement.setString(2,secondName);
            statement.setString(3, patronymic);
            statement.setString(4, access_level);
            statement.executeUpdate();




            statement = connection.prepareStatement(INSERT_HASH);
            statement.setString(1, login);
            statement.setString(2, Util.get_SHA_512_SecurePassword(hash_password,Util.getSalt()));
            statement.executeUpdate();


            statement.close();
            connection.close();
        }catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }
        logger.info("Данные в таблицу Client добавлены");
    }

    public static void addSubcriptionCard(int clientId, String bookId){
        logger.info("addSubcriptionCard: Начинаю создание читательской карты пользователя id=" + clientId);

        var instance = getInstance(bookId) ;


/*
        for(Instance instance :instanceList){
            if(instance.getBookId() == Integer.parseInt(bookId)){
                instanceId = instance.getInstanceId();
                logger.info("addSubcriptionCard: instance  найден  id = " + instanceId);
                break;
            }
            else {
                logger.info("addSubcriptionCard: Продолжаем проверку  instance. Текущий id = " + instance.getBookId() + "Нужный id =" + instanceId);
            }
        }*/

        logger.info(
                "addSubcriptionCard: " +
                        "clientId = " + clientId +
                        " instanceId = " + instance.getInstanceId()
        );

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(INSERT_SubcriptionCard);


            statement.setInt(1, clientId);
            statement.setInt(2,instance.getInstanceId());

            statement.executeUpdate();


            logger.info("addSubcriptionCard: Создание пользовательской карты завершено");
            statement.close();
            connection.close();
        }catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }
    }

    /*Удаление ОДНОГО объекта*/
    //Нужно добавить связей с другими таблицами
    public static void deleteBook(String idBook){
        logger.info("Начинаю удаление из  таблицы Book,  bookId=" + idBook);

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            PreparedStatement statement = connection.prepareStatement(DELETE_GENRECATALOG);
            statement.setString(1, idBook);
            statement.executeUpdate();

             statement = connection.prepareStatement(DELETE_BOOK);
            statement.setString(1, idBook);
            statement.executeUpdate();



            statement.close();
            connection.close();
        }catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        logger.info("Данные из таблицы Book удалены");
    }

     public static void dellSabCardUser(int SubcriptionCardId){
         logger.info("dellSabCardUser: Начинаю удаление  подписочной карты пользователя");

         try {
             Class.forName(NAME_DRIVER);
             Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE_SUBCSRIPTIONCARD);
             statement.setInt(1, SubcriptionCardId);
             statement.executeUpdate();

             logger.info("dellSabCardUser: Данные   удалены");
             statement.close();
             connection.close();
         }catch (SQLException | ClassNotFoundException e) {
             logger.info(e);
             logger.info("dellSabCardUser: Данные   не  удалены");
         }

     }



    public static void updateSavCardUser(int SubcriptionCardId, int clientId, int instanceId, java.util.Date dateOfReceiving, java.util.Date planned_date, java.util.Date returnDate){
        logger.info("Начинаю обновление   подписочной карты пользователя");

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            PreparedStatement statement = connection.prepareStatement("");
            statement.setInt(1, clientId);
            statement.setInt(2,instanceId);
            statement.setDate(3, (Date) dateOfReceiving);
            statement.setDate(4, (Date) planned_date);
            statement.setDate(5, (Date) returnDate);
            statement.executeUpdate();

            logger.info(
                    "Новые данные {" +
                            " SubcriptionCardId = " + SubcriptionCardId +
                            " instanceId = " + instanceId +
                            " dateOfReceiving = " + dateOfReceiving +
                            " planned_date = " + planned_date +
                            " returnDate = " + returnDate +
                            "}"
            );


            statement.close();
            connection.close();
        }catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        logger.info("Данные   обновлены");
    }

    /*Обновление ОДНОГО объекта*/
    //Нужно добавить связей с другими таблицами
    public static void updateBook(String bookName,String publishingHouse,String place,String description, int bookId){
        logger.info("Начинаю обновление из  таблицы Book");

        try {
            Class.forName(NAME_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);

            statement.setString(1, bookName);
            statement.setString(2,publishingHouse);
            statement.setString(3, place);
            statement.setString(4, description);
            statement.setString(5, String.valueOf(bookId));

            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }

        logger.info("Данные из таблицы Book обновлены");
    }

}

