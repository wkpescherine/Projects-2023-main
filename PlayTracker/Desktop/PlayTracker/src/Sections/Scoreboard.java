package src.Sections;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import src.Main.Display;

public class Scoreboard{
    JLabel TeamAScore = new JLabel("");
    JLabel TeamBScore = new JLabel("");
    public JPanel scoreboard = new JPanel();

    public Scoreboard(){
        updateScore();
        scoreboard.setPreferredSize(new Dimension (100,35));
        scoreboard.setLayout(new FlowLayout());
        scoreboard.add(TeamAScore);
        scoreboard.add(TeamBScore);
    }

    public void updateScore(){
        TeamAScore.setText(Config.TeamA +":"+String.valueOf(Config.TeamAScore));
    }

}
