package ru.sstu.entity.repository;

import org.apache.log4j.Logger;
import ru.sstu.entity.domain.Client;
import ru.sstu.entity.util.DatabaseConnection;
import java.util.HashMap;
import java.util.List;

public class ClientInstance {

    private static final Logger logger = Logger.getLogger(ClientInstance.class);
    private static List <Client> clients;
    private static HashMap<String,Client> clientsMap = DatabaseConnection.getMapClients();


    public  static Client getClient(String login){
        Client client = null;
        for(Client client1 : DatabaseConnection.getListClient()){
            if(client1.getLogin().equals(login)){
                client = client1;
            }
        }

        return (client != null) ? client : new Client();
    }

    public void newUserRegistration(String login, String firstName, String secondName, String patronymic, String password){
        logger.info("Данные пользователя приняты.");

        /*Тут запрос на создание пользователя в бд*/

        clients.add(new Client(clients.size(),firstName,secondName,patronymic,login,"2",password));
        logger.info("Пользователь зарегестрирован");
    }

    public static Boolean userIsExist(String login, String password){
        boolean isReg = false;

        for (Client client1 : DatabaseConnection.getListClient()){
            if(client1.getLogin().equals(login) && client1.getPassword().equals(password) ){
                isReg = true;
                break;
            }
        }

        logger.info("Проверка на существование пользователя с задаными  login="
                + login + " password=" + password + " Есть ли запись в таблице: " + isReg);

        return isReg;
    }

    public Boolean isAdministration(Client client){
        logger.info(
                "Данные пользователя приняты в обработку.\n " +
                        "Пользователь " + (client.getAccessLevel().equals("1") ?
                        ("") : ("не")) + "Администратор ");
        return client.getAccessLevel().equals("1");
    }
}
