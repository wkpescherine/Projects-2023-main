package src.Main;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class PlayTracker{
	JLabel version = new JLabel("version 0.8");
    JFrame window = new JFrame("PlayTracker");

	Display display = new Display();
	SetTracker options = new SetTracker();

    PlayTracker(){
		version.setForeground(Color.WHITE);

		window.add(options.main);
		window.add(display.results);
		window.add(version);
		window.setLayout(new FlowLayout());
        window.getContentPane().setBackground(Color.BLACK);
		window.setSize(1050,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
    }
    public static void main(String args[]){
		PlayTracker tracker = new PlayTracker();
	}   
}