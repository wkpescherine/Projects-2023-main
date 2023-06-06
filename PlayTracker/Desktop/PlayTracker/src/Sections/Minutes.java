package src.Sections;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.Main.Display;

public class Minutes implements ActionListener{
    //Config config = new Config();

    JButton m0 = new JButton("00");
    JButton m1 = new JButton("01");
    JButton m2 = new JButton("02");
    JButton m3 = new JButton("03");
    JButton m4 = new JButton("04");
    JButton m5 = new JButton("05");
    JButton m6 = new JButton("06");
    JButton m7 = new JButton("07");
    JButton m8 = new JButton("08");
    JButton m9 = new JButton("09");
    JButton m10 = new JButton("10");
    JButton m11 = new JButton("11");
    JButton m12 = new JButton("12");
    JButton m13 = new JButton("13");
    JButton m14 = new JButton("14");
    JButton m15 = new JButton("15");

    public JPanel min = new JPanel();

    public Minutes(){
        m0.addActionListener(this);
        m1.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "01";
                    Display.updateUI();
				}
			}
		);
        m2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "02";
                    Display.updateUI();
				}
			}
		);
        m3.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "03";
                    Display.updateUI();
				}
			}
		);
        m4.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "04";
                    Display.updateUI();
				}
			}
		);
        m5.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "05";
                    Display.updateUI();
				}
			}
		);
        m6.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "06";
                    Display.updateUI();
				}
			}
		);
        m7.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "07";
                    Display.updateUI();
				}
			}
		);
        m8.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "08";
                    Display.updateUI();
				}
			}
		);
          m9.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "09";
                    Display.updateUI();
				}
			}
		);
          m10.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "10";
                    Display.updateUI();
				}
			}
		);
          m11.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "11";
                    Display.updateUI();
				}
			}
		);
          m12.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "12";
                    Display.updateUI();
				}
			}
		);
          m13.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "13";
                    Display.updateUI();
				}
			}
		);
          m14.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    Config.minute = "14";
                    Display.updateUI();
				}
			}
		);
        m0.setPreferredSize(new Dimension (30,25));
        m1.setPreferredSize(new Dimension (30,25));
        m2.setPreferredSize(new Dimension (30,25));
        m3.setPreferredSize(new Dimension (30,25));
        m4.setPreferredSize(new Dimension (30,25));
        m5.setPreferredSize(new Dimension (30,25));
        m6.setPreferredSize(new Dimension (30,25));
        m7.setPreferredSize(new Dimension (30,25));
        m8.setPreferredSize(new Dimension (30,25));
        m9.setPreferredSize(new Dimension (30,25));
        m10.setPreferredSize(new Dimension (30,25));
        m11.setPreferredSize(new Dimension (30,25));
        m12.setPreferredSize(new Dimension (30,25));
        m13.setPreferredSize(new Dimension (30,25));
        m14.setPreferredSize(new Dimension (30,25));

        min.add(m0);
        min.add(m1);
        min.add(m2);
        min.add(m3);
        min.add(m4);
        min.add(m5);
        min.add(m6);
        min.add(m7);
        min.add(m8);
        min.add(m9);
        min.add(m10);
        min.add(m11);
        min.add(m12);
        min.add(m13);
        min.add(m14);
        min.setPreferredSize(new Dimension (530,35));
        min.setLayout(new FlowLayout());
    }

    public void actionPerformed(ActionEvent e){
        Config.minute = "00";
        Display.updateUI();
	}
}