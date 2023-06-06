import java.awt.*;

public class Robo2 {
    public static void main(String [] args) throws AWTException{
        Robot r = new Robot();
        System.out.println("Before");
        r.delay(5000);
        System.out.println("After");
        r.mouseMove(200,200);
        System.out.println("Finished");
    }   
}