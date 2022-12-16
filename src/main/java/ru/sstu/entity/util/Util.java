package ru.sstu.entity.util;

import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Util {
    private static final Logger logger = Logger.getLogger(Util.class);
    static String salt = "qwert123";
    public static String filterAllHtml(String srcStr) {
        String result = srcStr;
        try {
            if(srcStr == null) {  return ""; }
            result = srcStr.replaceAll("(?i)\\<(/?[^\\\\>]+)\\>"," ");
            result = result.replaceAll("javascript"," ").replaceAll("JAVASCRIPT"," ");
            result = result.replaceAll("<%"," ").replaceAll("%>"," ");
            result = result.replace("<", "&lt;").replace(">", "&gt;");
        }
        catch(Exception e) {
            logger.info(e.toString());
        }
        return result;
    }

    public static String get_SHA_512_SecurePassword(String passwordToHash,
                                                     String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static String getSalt()  {
       return salt;
    }
}
