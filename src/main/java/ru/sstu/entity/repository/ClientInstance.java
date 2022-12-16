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

}
