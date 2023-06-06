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

public class ChatView implements ActionListener{
    String personToMessage = "";
    String chatUserName = "";
    String [] friendsList = new String[100];
    String [] invites = new String[100];

    JPanel chat = new JPanel();
    JPanel sideBar = new JPanel();
    JPanel chatPanel = new JPanel();
    JPanel friendsPanel = new JPanel();
    JPanel messagePanel = new JPanel();
    JPanel invite1 = new JPanel();
    JPanel friend1 = new JPanel();
    JLabel messagePerson = new JLabel("Send To :"+personToMessage);
    JLabel invite1Label = new JLabel("none");
    JLabel friend1Label = new JLabel("none");
    JTextField messageArea = new JTextField();
    JTextField findPersonArea = new JTextField(13);
    JButton invitePersonBtn = new JButton("Invite");
    JButton sendMessage = new JButton("Message");
    JButton inviteAccept = new JButton();
    JButton inviteReject = new JButton();
    JButton check = new JButton("Check if new Friends");

    JLabel chatToFriend1 = new JLabel("Friend here");

    ChatView(){
        invitePersonBtn.addActionListener(this);

        chatToFriend1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					System.out.println("Clicked to chat with a friend");
				}	
			});

        check.addActionListener(
            new ActionListener(){
				public void actionPerformed(ActionEvent e){
                    buildFriendsSection();
				}
			}
        );

        chat.setLayout(new FlowLayout());
        chat.setPreferredSize(new Dimension (920,620));
        sideBar.setLayout(new FlowLayout());
        sideBar.setPreferredSize(new Dimension (200,610));
        sideBar.setBackground(Color.WHITE);
        friendsPanel.setPreferredSize(new Dimension(180,480));
        invite1.setPreferredSize(new Dimension(160,20));
        invite1.add(invite1Label);
        invite1.setVisible(false);
        friend1.setPreferredSize(new Dimension(160,20));
        friend1.add(friend1Label);
        friend1.setVisible(false);
        friendsPanel.add(chatToFriend1);
        friendsPanel.add(invite1);
        friendsPanel.add(friend1);
        sideBar.add(findPersonArea);
        sideBar.add(invitePersonBtn);
        sideBar.add(check);
        sideBar.add(friendsPanel);
        chatPanel.setLayout(new FlowLayout());
        chatPanel.setPreferredSize(new Dimension (700,610));
        chatPanel.setBackground(Color.WHITE);
        messagePanel.setLayout(null);
        messagePanel.setPreferredSize(new Dimension (380,90));
        messagePerson.setBounds(10, 10, 100, 20);
        sendMessage.setBounds(200, 10, 100, 20);
        messageArea.setBounds(10, 40, 350, 50);
        messagePanel.add(messagePerson);
        messagePanel.add(sendMessage);
        messagePanel.add(messageArea);
        chatPanel.add(messagePanel);
        chat.add(sideBar);
        chat.add(chatPanel);
        chat.setVisible(false);
    }
    public void actionPerformed(ActionEvent e){
        String invitePerson = findPersonArea.getText();
        try{
            FileWriter myWriter = new FileWriter("friendsListDB.txt", true);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            PrintWriter pWriter = new PrintWriter(bWriter);
            pWriter.write("\r"+chatUserName+"," +invitePerson+"," +"INVITE");
            pWriter.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        } 
        findPersonArea.setText("");
        System.out.println("Invited a person");
    }

    public void buildFriendsSection(){
        try{
            int invitesNum = 0;
            File myFile = new File("friendsListDB.txt");
			Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
				String [] invite = data.split(","); 
				if(invite[0].equals(chatUserName)){
                    invites[invitesNum] = (data);
                    invitesNum += 1;
				}
			}
            myReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        for(int a = 0; a < invites.length-1; a++){
            //Might have to add a NPE logic in here
            System.out.println("In builder 1 " + invites[a]);       
            String subInvite = invites[a];
            System.out.println("In builder 2 "+subInvite);
            String [] subInviteSplit = subInvite.split(",");
            if(subInviteSplit[0].equals(chatUserName)){
                System.out.println("Test");
            }
        }
    }
}//135