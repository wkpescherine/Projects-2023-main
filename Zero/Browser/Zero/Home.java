import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home implements ActionListener{
    JPanel home = new JPanel();
    JPanel news = new JPanel();
    JPanel updates = new JPanel();
    JLabel homeText = new JLabel("Welcome to the Zero browser");
    String [] newsArticles = {"news label 1", "news label 2"};
    String [] updatesArticles = {"update 1"};
    JButton something = new JButton("Something");

    Home(){
        updateNews();
        updateUpdates();

        something.addActionListener(this);

        home.setLayout(null);
        //home.setBackground(Color.RED);
        home.setPreferredSize(new Dimension (700,420));
        homeText.setBounds(250,10,200,20);
        news.setPreferredSize(new Dimension (200,360));
        news.setBounds(25,50,200,360);
        news.setBackground(Color.WHITE);
        updates.setPreferredSize(new Dimension (440,360));
        updates.setBounds(250,50,440,360);
        updates.setBackground(Color.WHITE);
        home.add(homeText);
        home.add(news);
        home.add(updates);
        home.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("pushed button");
    }

    public void updateNews(){
        news.removeAll();
        int start = newsArticles.length;
        JButton jbutton[] = new JButton[start];
        JLabel jlabel[] = new JLabel[start];
    
        for(int a = 0; a < start; a++){
            jbutton[a] = new JButton();
            jlabel[a] = new JLabel();
            JButton newsSub = jbutton[a];
            JLabel newsSubLabel = jlabel[a];
            newsSub.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.out.println(newsSubLabel);
                    }
                }
            );
            newsSubLabel.setText(newsArticles[a]);
            newsSub.setPreferredSize(new Dimension (180,60));
            newsSub.add(newsSubLabel);
            news.add(newsSub);
        }
        news.validate();
        news.repaint();
    }
    //Have to programmatically build each label like in Site
    public void updateUpdates(){
        updates.removeAll();
        int start = updatesArticles.length;
        JPanel jpanel[] = new JPanel[start];
        JLabel jlabel[] = new JLabel[start];
    
        for(int b = 0; b < start; b++){
            jpanel[b] = new JPanel();
            jlabel[b] = new JLabel();
            JPanel updatesSub = jpanel[b];
            JLabel updatesSubLabel = jlabel[b];
            updatesSubLabel.setText(updatesArticles[b]);
            updatesSub.setPreferredSize(new Dimension (420,60));
            updatesSub.add(updatesSubLabel);
            updates.add(updatesSub);
        }
        updates.validate();
        updates.repaint();
    }
}//87