import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ZBuilder{
    JFrame window = new JFrame("ZBuilder v1");

    ZBuilder(){
		window.setLayout(new FlowLayout());
        window.getContentPane().setBackground(Color.BLACK);
		window.setSize(900,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
    }

    public static void main(String args[]){
		ZBuilder zbuilder = new ZBuilder();
	}
}//20