import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Settings implements ActionListener{
    JPanel setting = new JPanel();
    JLabel settingText = new JLabel("");
    JLabel tempId = new JLabel("");
    JLabel settingDate = new JLabel("");
    JLabel settingVersion = new JLabel("");
    JRadioButton w1050_700 = new JRadioButton("1050x700");
    JRadioButton w900_600 = new JRadioButton("900x600");
    JRadioButton w750_500 = new JRadioButton("750x500");
    JRadioButton w600_400 = new JRadioButton("600x400"); 
    JRadioButtonMenuItem windowSize = new JRadioButtonMenuItem();

    private Config configSetting ;

    Settings(){
        w1050_700.addActionListener(this);
        w900_600.addActionListener(this);
        w750_500.addActionListener(this);
        w600_400.addActionListener(this);

        w1050_700.setActionCommand("1050x700");
        w900_600.setActionCommand("900x600");
        w750_500.setActionCommand("750x500");
        w600_400.setActionCommand("600x400");

        setting.setLayout(new FlowLayout());
        setting.setPreferredSize(new Dimension (840,520));
        settingText.setPreferredSize(new Dimension (640,30));
        settingDate.setPreferredSize(new Dimension (640,30));
        settingVersion.setPreferredSize(new Dimension (640,30));
        tempId.setPreferredSize(new Dimension (640,30));
        windowSize.setLayout(new FlowLayout());
        windowSize.setPreferredSize(new Dimension(640,60));
        w1050_700.setPreferredSize(new Dimension(300,25));
        w900_600.setPreferredSize(new Dimension(300,25));
        w750_500.setPreferredSize(new Dimension(300,25));
        w600_400.setPreferredSize(new Dimension(300,25));
        windowSize.add(w1050_700);
        windowSize.add(w900_600);
        windowSize.add(w750_500);
        windowSize.add(w600_400);
        setting.add(settingText);
        setting.add(settingDate);
        setting.add(settingVersion);
        setting.add(tempId);
        setting.add(windowSize);
        setting.setVisible(false);
    }

    public void settingConfigs(Config config){
        configSetting = config;
        settingDate.setText(configSetting.date);
        settingText.setText(configSetting.username);
        tempId.setText(configSetting.tempId);
        settingVersion.setText(configSetting.version+"");
    }

    public void actionPerformed(ActionEvent e){
        String value = e.getActionCommand();
        if(value.equals("1050x700")){
            w900_600.setSelected(false);
            w750_500.setSelected(false);
            w600_400.setSelected(false);
        }
        if(value.equals("900x600")){
            w1050_700.setSelected(false);
            w750_500.setSelected(false);
            w600_400.setSelected(false);
        }
        if(value.equals("750x500")){
            w1050_700.setSelected(false);
            w900_600.setSelected(false);
            w600_400.setSelected(false);
        }
        if(value.equals("600x400")){
            w1050_700.setSelected(false);
            w900_600.setSelected(false);
            w750_500.setSelected(false);
        }
    }
}//85