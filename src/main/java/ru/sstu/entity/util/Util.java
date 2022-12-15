package ru.sstu.entity.util;

public class Util {
    public static String filter(String str){
        return (str != null) ? (str) : ("");
    }

    public static String filterAllHtml(String srcStr) {
        String result = srcStr;
        try {
            if(srcStr == null)
                return "";
            result = srcStr.replaceAll("(?i)\\<(/?[^\\\\>]+)\\>"," ");
            result = result.replaceAll("javascript"," ").replaceAll("JAVASCRIPT"," ");
            result = result.replaceAll("<%"," ").replaceAll("%>"," ");
            result = result.replace("<", "&lt;").replace(">", "&gt;");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return result;
    }
}
