import java.awt.*;
import javax.swing.*;

public class Retail{
    JPanel retail = new JPanel();
    JButton clothM = new JButton("Mens Clothing");
    JButton clothW = new JButton("Womans Clothing");
    JButton grocery = new JButton("Grocery's");
    JButton food = new JButton("Order Food Onlien");
    JLabel retailText = new JLabel("SHOPPING");
    JLabel zCoins = new JLabel("Current zCoins = $ ");

    Retail(){
        retail.setLayout(new FlowLayout());
        retail.setPreferredSize(new Dimension (920,620));
        retail.setBackground(Color.GREEN);
        retailText.setPreferredSize(new Dimension (900,50));
        retailText.setHorizontalAlignment(SwingConstants.CENTER);
        clothM.setPreferredSize(new Dimension (440,50));
        clothW.setPreferredSize(new Dimension (440,50));
        grocery.setPreferredSize(new Dimension (440,50));
        food.setPreferredSize(new Dimension (440,50));
        zCoins.setPreferredSize(new Dimension (900,50));
        zCoins.setHorizontalAlignment(SwingConstants.CENTER);
        retail.add(retailText);
        retail.add(clothM);
        retail.add(clothW);
        retail.add(grocery);
        retail.add(food);
        retail.add(zCoins);
        retail.setVisible(false);
    }
}//33