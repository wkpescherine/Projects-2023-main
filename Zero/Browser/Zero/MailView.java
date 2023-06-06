import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MailView implements ActionListener{
    Config mailConfig = new Config();
    String nameOfUser = "none";
    String [] emails = new String[100];

    JPanel mail = new JPanel();
    JPanel zmail = new JPanel();
    JPanel zcompose = new JPanel();
    JPanel messagePanel = new JPanel();
    JButton inbox = new JButton("Inbox");
    JButton compose = new JButton("Compose");
    JButton previous = new JButton("Previous");
    JButton next = new JButton("Next");
    JButton send = new JButton("Send");
    JButton messageClose = new JButton("Close");
    JLabel fromText = new JLabel("From:");
    JLabel toText = new JLabel("To:");
    JLabel titleText = new JLabel("Title:");
    JLabel messageLabel = new JLabel("Message in here");
    JTextField fromTextField = new JTextField(25);
    JTextField toTextField = new JTextField(25);
    JTextField titleTextField = new JTextField(25);
    JTextArea messageArea = new JTextArea();

    MailView(){
        send.addActionListener(this);
		inbox.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					zmail.setVisible(true);
                    zcompose.setVisible(false);
                    messagePanel.setVisible(false);
                    populateMail();
				}
			}
        );
        compose.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					zmail.setVisible(false);
                    zcompose.setVisible(true);
                    fromTextField.setText(nameOfUser);
                    messagePanel.setVisible(false);
				}
			}
        );

        messageClose.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    messagePanel.setVisible(false);
                    zmail.setVisible(true);
                }
            }
        );
        
        mail.setLayout(new FlowLayout());
        mail.setPreferredSize(new Dimension (840,520));
        zmail.setLayout(new FlowLayout());
        zmail.setPreferredSize(new Dimension (620,480));
        previous.setBounds(250,350,100,25);
        next.setBounds(450,350,100,25);
        zmail.setVisible(false);
        zcompose.setLayout(null);
        zcompose.setPreferredSize(new Dimension (820,480));
        fromText.setBounds(50,25,50,25);
        fromTextField.setBounds(175,25,300,25);
        toText.setBounds(50,50,50,25);
        toTextField.setBounds(175,50,300,25);
        titleText.setBounds(50,75,50,25);
        titleTextField.setBounds(175,75,300,25);
        messageArea.setBounds(175,100,500,200);
        messageArea.setLineWrap(true);
        send.setBounds(200,300,100,25);
        messagePanel.setLayout(new FlowLayout());
        messagePanel.setPreferredSize(new Dimension(600,400));
        messagePanel.add(messageLabel);
        messagePanel.add(messageClose);
        messagePanel.setVisible(false);
        zcompose.add(fromText);
        zcompose.add(fromTextField);
        zcompose.add(toText);
        zcompose.add(toTextField);
        zcompose.add(titleText);
        zcompose.add(titleTextField);
        zcompose.add(messageArea);
        zcompose.add(send);
        zcompose.setVisible(false);
        mail.add(inbox);
        mail.add(compose);
        mail.add(previous);
        mail.add(next);
        mail.add(zmail);
        mail.add(zcompose);
        mail.add(messagePanel);
        mail.setVisible(false);
    }    
    public void actionPerformed(ActionEvent e){
        String sender = fromTextField.getText();
        String receiver = toTextField.getText();
        String msgTitle = titleTextField.getText();
        String msgSent = messageArea.getText();
        try{
            FileWriter myWriter = new FileWriter("emailDB.txt", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            pWriter.write(sender+","+receiver+","+msgTitle+","+msgSent+"\r");
            pWriter.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }  
        fromTextField.setText(nameOfUser);
        toTextField.setText("");
        titleTextField.setText("");
        messageArea.setText("");
    }

    public void populateMail(){
		try{
            int emailNum = 0;
            File myFile = new File("emailDB.txt");
			Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                emails[emailNum] = (data);
				String [] message = data.split(","); 
				if(message[0].equals(nameOfUser)){
                    emailNum += 1;
				}
			}
            myReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
        zmail.removeAll();
        int start = emails.length;
        JPanel jpanel[] = new JPanel[start];
        JButton jbutton[] = new JButton[start];
        JButton jbtnpage[] = new JButton[start];
        JLabel jlabel[] = new JLabel[start];
    
        for(int a = 0; a < emails.length-1; a++){
            String subMsg = emails[a];
            String [] subMsgSplit = subMsg.split(",");
            jpanel[a] = new JPanel();
            jbutton[a] = new JButton("View");
            jlabel[a] = new JLabel();
            JPanel mailSub = jpanel[a];
            JButton mailSubButton = jbutton[a];
            JLabel mailSubLabel = jlabel[a];
            mailSubButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        displayMessage(subMsgSplit[3]);
                        zmail.setVisible(false);
                        messagePanel.setVisible(true);
                    }
                }
            );
            mailSubLabel.setText(subMsgSplit[1]+" "+ subMsgSplit[2]);
            mailSub.setLayout(new FlowLayout());
            mailSub.setPreferredSize(new Dimension (600,50));
            mailSub.add(mailSubLabel);
            mailSub.add(mailSubButton);
            zmail.add(mailSub);
        }

        //The logic here is broken not doing anything at the moment
        //for(int a = 1; a< emails.length/10; a++){
        for(int b = 1; b< 10; b++){
            jbtnpage[b] = new JButton("1");
            JButton pageSelector = jbtnpage[b];
            System.out.print(b);
            pageSelector.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        populateMail();
                    }
                }
            );
            zmail.add(pageSelector);
        }

        zmail.validate();
        zmail.repaint();
    }

    public void displayMessage(String viewMessage){
        messageLabel.setText(viewMessage);
    }
}//203