package src.Main;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

import src.Sections.Teams;
import src.Sections.Quarter;
import src.Sections.Config;
import src.Sections.Minutes;
import src.Sections.Placeholder;
import src.Sections.Placeholder2;
import src.Sections.Placeholder3;
import src.Sections.PlayResult;
import src.Sections.Down;
import src.Sections.Distance;
import src.Sections.FieldPosition;
import src.Sections.Scoreboard;

public class SetTracker implements ActionListener{
    JPanel main = new JPanel();
    JButton AnalyzeO = new JButton("Analyze Offense");
    JButton AnalyzeD = new JButton("Analyze Defense");
    JButton save = new JButton("Save Data");

    Config config = new Config();
    Teams teams = new Teams();
    Quarter quarter = new Quarter();
    Minutes minutes = new Minutes();
    Down down = new Down();
    Distance distance = new Distance();
    PlayResult playresults = new PlayResult();
    FieldPosition fieldpos = new FieldPosition();
    Scoreboard score = new Scoreboard();
    Placeholder holder = new Placeholder();
    Placeholder2 holder2 = new Placeholder2();
    Placeholder3 holder3 = new Placeholder3();

    SetTracker(){
        save.setPreferredSize(new Dimension (720,25));
        AnalyzeD.setPreferredSize(new Dimension (355,25));
        AnalyzeO.setPreferredSize(new Dimension (355,25));
        save.addActionListener(this);
        main.add(teams.teams);
        main.add(quarter.qtr);
        main.add(minutes.min);
        main.add(down.downs);
        main.add(distance.distance);
        main.add(holder.holder);
        main.add(playresults.playresult);
        main.add(fieldpos.field_pos);
        main.add(holder2.holder);
        main.add(score.scoreboard);
        main.add(holder3.holder);
        main.add(AnalyzeO);
        main.add(AnalyzeD);
        main.add(save);
        main.setPreferredSize(new Dimension (750,520));
        main.setLayout(new FlowLayout());
        main.setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent e) {
        try{
            FileWriter myWriter = new FileWriter("/Users/wkpescherine/Desktop/Languages/Java/PlayTracker/src/Main/GameData.txt", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
                pWriter.write(Config.offense+","+Config.defense+","+Config.quarter+","+Config.minute+","+Config.down+","+Config.yards+"\r");
                pWriter.close();
        }catch(IOException err){
            err.printStackTrace();
        }      
    }
}