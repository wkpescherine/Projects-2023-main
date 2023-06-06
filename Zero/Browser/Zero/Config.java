import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
//import javax.tools.*;
//import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Config{
    static String date ;
	static Double version = 5.0;
	static String tempId ;
	static int width = 1050;
	static int height = 700;
    static String username = "";
    static String requestedSite = "";

    Config(){
        getDate();
        getTempId();
    }

    public void getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date newDate = new Date();
        date = formatter.format(newDate);
    }

    public void getTempId(){
        String createId = "";
        for(int a = 0; a< 25; a++){
            String val = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random rand = new Random();
            int num = val.length();
            String randomVal = Character.toString(val.charAt(rand.nextInt(num)));
            createId += randomVal;
        }
        tempId = createId;
    }
}//41