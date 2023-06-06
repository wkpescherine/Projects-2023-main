package src.Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import src.Sections.Config;
import src.Sections.Scoreboard;

public class Display implements ActionListener {
    JPanel results = new JPanel();

    Scoreboard score = new Scoreboard();
    
    JLabel offensiveTeam = new JLabel("Offense");
    JLabel divider1 = new JLabel(":");
    static JLabel teamOnOff = new JLabel("");
    JLabel defensiveTeam = new JLabel("Defense");
    JLabel divider2 = new JLabel(":");
    static JLabel teamOnDef = new JLabel("");
    JLabel quarter = new JLabel("Qtr");
    JLabel divider3 = new JLabel(":");
    static JLabel qtrNum = new JLabel("");
    JLabel minute = new JLabel("Min");
    JLabel divider4 = new JLabel(":");
    static JLabel minNum = new JLabel("");
    JLabel down = new JLabel("down");
    JLabel divider5 = new JLabel(":");
    static JLabel downValue = new JLabel("");
    JLabel yards = new JLabel("Yrds");
    JLabel divider6 = new JLabel(":");
    static JLabel yardsValue = new JLabel("");
    JLabel playsResult = new JLabel("Result");
    JLabel divider7 = new JLabel(":");
    static JLabel resultPlay = new JLabel("");
    JButton clear = new JButton("Clear");
    JButton changePoss = new JButton("Change of Poss");
    JLabel yard_line = new JLabel("Yard Line");
    JLabel divider8 = new JLabel(":");
    static JLabel side_yard = new JLabel("");

    public Display(){
        clear.addActionListener(this);
        changePoss.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    String tempTeam = Config.offense;
                    Config.offense = Config.defense;
                    Config.defense = tempTeam;
                    updateUI();
				}
			}
		);

        offensiveTeam.setPreferredSize(new Dimension (50,25));
        divider1.setPreferredSize(new Dimension (10,25));
        teamOnOff.setPreferredSize(new Dimension (30,25));
        defensiveTeam.setPreferredSize(new Dimension (55,25));
        divider2.setPreferredSize(new Dimension (10,25));
        teamOnDef.setPreferredSize(new Dimension (30,25));
        quarter.setPreferredSize(new Dimension (30,25));
        divider3.setPreferredSize(new Dimension (10,25));
        qtrNum.setPreferredSize(new Dimension (15,25));
        minute.setPreferredSize(new Dimension (30,25));
        divider4.setPreferredSize(new Dimension (10,25));
        minNum.setPreferredSize(new Dimension (20,25));
        down.setPreferredSize(new Dimension (40,25));
        divider5.setPreferredSize(new Dimension (10,25));
        downValue.setPreferredSize(new Dimension (20,25));
        yards.setPreferredSize(new Dimension (40,25));
        divider6.setPreferredSize(new Dimension (10,25));
        yardsValue.setPreferredSize(new Dimension (30,25));
        playsResult.setPreferredSize(new Dimension (60,25));
        divider7.setPreferredSize(new Dimension (20,25));
        resultPlay.setPreferredSize(new Dimension (40,25));
        yard_line.setPreferredSize(new Dimension (60,25));
        divider8.setPreferredSize(new Dimension (20,25));
        side_yard.setPreferredSize(new Dimension (40,25));

        results.setPreferredSize(new Dimension (290,520));
        results.add(offensiveTeam);
        results.add(divider1);
        results.add(teamOnOff);
        results.add(defensiveTeam);
        results.add(divider2);
        results.add(teamOnDef);
        results.add(quarter);
        results.add(divider3);
        results.add(qtrNum);
        results.add(down);
        results.add(divider4);
        results.add(downValue);
        results.add(yards);
        results.add(divider5);
        results.add(yardsValue);
        results.add(minute);
        results.add(divider6);
        results.add(minNum);
        results.add(playsResult);
        results.add(divider7);
        results.add(resultPlay);
        results.add(yard_line);
        results.add(divider8);
        results.add(side_yard);
        results.add(clear);
        results.add(changePoss);
    }

    public static void updateUI(){
        teamOnOff.setText(Config.offense);
        teamOnDef.setText(Config.defense);
        qtrNum.setText(Config.quarter);
        minNum.setText(Config.minute);
        downValue.setText(Config.down);
        yardsValue.setText(Config.yards);
        resultPlay.setText(Config.play_result);
        side_yard.setText(Config.side_of_field + Config.yard_line);
        //score.updateScore();
    }

    public static void changePoss(){
        String tempTeam = Config.offense;
        Config.offense = Config.defense;
        Config.defense = tempTeam;
    }

    public void actionPerformed(ActionEvent e){
        Config.play_result = "";
        updateUI();
	}
}