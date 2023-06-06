//import java.awt.*;
import java.awt.Robot;

public class Robo {
    public static void sleep(long ms){
        try{Thread.sleep(ms); System.out.println("In sleep");}catch(Exception ignored){}
    }
    public static void main(String [] args) throws Exception{
        System.out.println("Before");
        sleep(5000);
        Robot bot = new Robot();
        bot.mouseMove(10, 100);
        System.out.println("After");
    }
}