package ru.sstu.entity.repository;

import org.apache.log4j.Logger;

public class SubcriptionCardInstance {
    private static final Logger logger = Logger.getLogger(SubcriptionCardInstance.class);


    public static boolean isRegisterCard(String idUser){
        boolean isReg = false;
         logger.info("Открыт метод проверки создания читательской карты");

         /*Тут логика*/

        logger.info("Карта " + ((isReg) ? ("") : ("не")) + "зарегестрирована");
        return isReg;
    }
}
