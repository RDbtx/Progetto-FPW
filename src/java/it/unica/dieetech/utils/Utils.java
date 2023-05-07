package it.unica.dieetech.utils;
import it.unica.dieetech.exceptions.InvalidParamException;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.TimeZone;

/**
 *
 * @author ricca
 */
public class Utils {
    
    
    
    
    public static void checkString( String param, int min, int max) throws InvalidParamException{
        if (param == null)
            throw new InvalidParamException("Parametro nullo");
        
        if (param.length() < min || param.length() > max)
            throw new InvalidParamException("la stringa deve avere una dimensione compresa tra " + min +" e " + max);
        }   //controllo grandezza stringa 
    
    public static void checkInteger(String param, int min , int max) throws InvalidParamException{
        
        try{
            int value = Integer.valueOf(param);
            
            if (value < min || value > max)
                throw new InvalidParamException("la stringa deve avere una dimensione compresa tra " + min +" e " + max);
            
        } catch(NumberFormatException e){
                throw new InvalidParamException("la stringa inserita non è un numero");
        }
    }  //controllo valori integrale
    
    public static boolean checkLogin( String username , String password) throws InvalidParamException{
        Hashtable<String,String> users = new Hashtable<String,String>();
        users.put("Riccardo","Deidda");
        users.put("Andrea","Amato");
        users.put("Alessio","Vinci");
        users.put("Riccardo","Lecca");
        
        boolean retval = (users.containsKey(username) && users.get(username).equals(password));
        return retval;
        
    }   //serve a controllare i dati di login

    public static Object convertTime(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        cal.setTimeInMillis(time);
        return (cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" +
                cal.get(Calendar.YEAR) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + 
                cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
    }   //riporta l'orario in cui è stata chiamata questa funzione
    
    
}
