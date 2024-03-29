//Associating under the Panels Directory (or package)
package Panels;

//Importing Graphics Dependencies
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class leaderPanel extends JPanel implements ActionListener{
    //Properties
    public JLabel LeaderboardLabel = new JLabel("LEADERBOARD");
    public JPanel PlayersPanel = new JPanel();
    public JScrollPane PlayersScroll = new JScrollPane(PlayersPanel);
    public JLabel PlayerLabels[];
    public JLabel PlayerLabels2[];
    public Timer theTimer = new Timer(1000/60, this);
    private int intScrollVelo = 2;
    private int intScrollHeight;

    //Methods
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == theTimer){
            if(PlayersPanel.getPreferredSize().getHeight() > 540){
                if(PlayersScroll.getViewport().getViewPosition().getY() >= intScrollHeight/2){
                    PlayersScroll.getViewport().setViewPosition(new Point(0, 0));
                }
                PlayersScroll.getViewport().setViewPosition(new Point(0, (int)PlayersScroll.getViewport().getViewPosition().getY() + intScrollVelo));
                repaint();
            }
        }
    }

    public void updatePlayerList(String strPlayerList[]){
        int intCount;

        if(strPlayerList.length <= 9){
            PlayersPanel.setBounds(0, 0, 680, 60 * strPlayerList.length);
            PlayersPanel.setPreferredSize(new Dimension(680, 60 * strPlayerList.length));
            PlayerLabels = new JLabel[strPlayerList.length];

            for(intCount = 0; intCount < strPlayerList.length; intCount++){
                PlayerLabels[intCount] = new JLabel(strPlayerList[intCount]);
                PlayerLabels[intCount].setSize(680,50);
                PlayerLabels[intCount].setLocation(0, intCount * 60);
                PlayerLabels[intCount].setHorizontalAlignment(SwingConstants.CENTER);
                PlayerLabels[intCount].setFont(assets.fntHelvetica30);
                PlayerLabels[intCount].setBackground(assets.clrLightGrey);
                PlayerLabels[intCount].setOpaque(true);
                PlayersPanel.add(PlayerLabels[intCount]);
            }
        }
        else if(strPlayerList.length == 10){
            theTimer.start();
            PlayersPanel.removeAll();
            PlayersPanel.setBounds(0, 0, 680, 60 * 2 * strPlayerList.length);
            PlayersPanel.setPreferredSize(new Dimension(680, 60 * 2 * strPlayerList.length));
            intScrollHeight = (int)PlayersPanel.getPreferredSize().getHeight();
            PlayerLabels = new JLabel[strPlayerList.length];
            PlayerLabels2 = new JLabel[strPlayerList.length];

            for(intCount = 0; intCount < strPlayerList.length; intCount++){
                PlayerLabels[intCount] = new JLabel(strPlayerList[intCount]);
                PlayerLabels[intCount].setSize(680,50);
                PlayerLabels[intCount].setLocation(0, intCount * 60);
                PlayerLabels[intCount].setHorizontalAlignment(SwingConstants.CENTER);
                PlayerLabels[intCount].setFont(assets.fntHelvetica30);
                PlayerLabels[intCount].setBackground(assets.clrLightGrey);
                PlayerLabels[intCount].setOpaque(true);
                PlayersPanel.add(PlayerLabels[intCount]);
                PlayerLabels2[intCount] = new JLabel(strPlayerList[intCount]);
                PlayerLabels2[intCount].setSize(680,50);
                PlayerLabels2[intCount].setLocation(0, 60 * strPlayerList.length + intCount * 60);
                PlayerLabels2[intCount].setHorizontalAlignment(SwingConstants.CENTER);
                PlayerLabels2[intCount].setFont(assets.fntHelvetica30);
                PlayerLabels2[intCount].setBackground(assets.clrLightGrey);
                PlayerLabels2[intCount].setOpaque(true);
                PlayersPanel.add(PlayerLabels2[intCount]);
            }
        }
        else if(strPlayerList.length > 10){
            PlayersPanel.removeAll();
            PlayersPanel.setBounds(0, 0, 680, 60 * 2 * strPlayerList.length);
            PlayersPanel.setPreferredSize(new Dimension(680, 60 * 2 * strPlayerList.length));
            intScrollHeight = (int)PlayersPanel.getPreferredSize().getHeight();
            PlayerLabels = new JLabel[strPlayerList.length];
            PlayerLabels2 = new JLabel[strPlayerList.length];

            for(intCount = 0; intCount < strPlayerList.length; intCount++){
                PlayerLabels[intCount] = new JLabel(strPlayerList[intCount]);
                PlayerLabels[intCount].setSize(680,50);
                PlayerLabels[intCount].setLocation(0, intCount * 60);
                PlayerLabels[intCount].setHorizontalAlignment(SwingConstants.CENTER);
                PlayerLabels[intCount].setFont(assets.fntHelvetica30);
                PlayerLabels[intCount].setBackground(assets.clrLightGrey);
                PlayerLabels[intCount].setOpaque(true);
                PlayersPanel.add(PlayerLabels[intCount]);
                PlayerLabels2[intCount] = new JLabel(strPlayerList[intCount]);
                PlayerLabels2[intCount].setSize(680,50);
                PlayerLabels2[intCount].setLocation(0, 60 * strPlayerList.length + intCount * 60);
                PlayerLabels2[intCount].setHorizontalAlignment(SwingConstants.CENTER);
                PlayerLabels2[intCount].setFont(assets.fntHelvetica30);
                PlayerLabels2[intCount].setBackground(assets.clrLightGrey);
                PlayerLabels2[intCount].setOpaque(true);
                PlayersPanel.add(PlayerLabels2[intCount]);
            }
        }

        try{
            PlayerLabels[0].setBackground(assets.clrNumber1);
            PlayerLabels[1].setBackground(assets.clrNumber2);
            PlayerLabels[2].setBackground(assets.clrNumber3);
        }
        catch(ArrayIndexOutOfBoundsException e){

        }

        PlayersPanel.repaint();
    }

    //Constructor
    public leaderPanel(){
        setPreferredSize(new Dimension(1280, 720));
        setLayout(null);
        setBackground(assets.clrBackground);

        LeaderboardLabel.setSize(500, 60);
        LeaderboardLabel.setLocation(390, 40);
        LeaderboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LeaderboardLabel.setFont(assets.fntHelvetica50);
        LeaderboardLabel.setForeground(assets.clrWhite);

        PlayersPanel.setBackground(assets.clrBackground);
        PlayersPanel.setLayout(null);
        PlayersScroll.setSize(new Dimension(680, 535));
        PlayersScroll.setLocation(300, 125);
        PlayersScroll.setBorder(null);
        PlayersScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        PlayersScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        add(LeaderboardLabel);
        add(PlayersScroll);
    }
}
