import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class MonsterPanel extends JPanel implements ActionListener
{
    //這邊設定玩家介面，目的是讓怪物移動的時候，可以控制步數與分數
    private static MonsterUserpanel userpanel = null;
    private int last_btnNumber = -1;
    private int last_picNumber = -1;
    private JButton[] btn;
    public static HashMap<Integer,String> pictures;

    public MonsterPanel(MonsterUserpanel userpanelIn)
    {
        userpanel = userpanelIn;
        //怪物圖片HashMap(編號,圖片路徑)
        pictures = new HashMap<>();
        pictures.put(1,"picture/1.png");
        pictures.put(2,"picture/2.png");
        pictures.put(3,"picture/3.png");
        pictures.put(4,"picture/4.png");
        pictures.put(5,"picture/5.png");
       
        //怪物介面
        setLayout(new GridLayout(8,6,2,2));
        setBackground(Color.BLACK);

        btn = new JButton[48];
        for(int i=0; i<btn.length; i++)
        {
            int random_number = (int)(Math.random()*5)+1;
            String number = String.valueOf(random_number);

            btn[i] = new JButton(String.valueOf(i) + "-" + number);
            ImageIcon iconInButton = new ImageIcon(pictures.get(random_number));
            iconInButton.setImage(iconInButton.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
            btn[i].setIcon(iconInButton);
            btn[i].setContentAreaFilled(false); // 去背景
            btn[i].setBorderPainted(false); // 去邊框
            btn[i].setFont(new Font("微軟正黑體",0,0)); // 隱藏文字
 
            btn[i].addActionListener(this);
            add(btn[i]);
        }
        /*** Initialize the game play, kill then fill **/
        canKill(btn, userpanel);
        /*
        while(canKill)
        {
            MonsterUserdata.setScore(0);
            Monsterkill.fill(btn);
            Monsterkill.kill(btn,userpanel);
            if(MonsterUserdata.getScore() == 0)
                canKill = false;
        }
        */
        /** **/
    }
    public void canKill(JButton[] btn, MonsterUserpanel userpanel)
    {
        while(true)
        {
            MonsterUserdata.setScore(0);
            Monsterkill.fill(btn);
            Monsterkill.kill(btn,userpanel);
            if(MonsterUserdata.getScore() == 0)
                break;
        }
    }
    public boolean CheckMove(int current_btn, int last_btn)
    {
        int up = last_btn - 6;
        int down = last_btn + 6;
        int left = last_btn - 1;
        int right = last_btn + 1;
        
        if(last_btn % 6 == 0) // 最左的按鈕，不能跟最右的消除
        {
            if(current_btn == up || current_btn == down || current_btn == right)
                return true;
            else
                return false;
        }
        else if((last_btn+1) % 6 == 0) // 最右的按鈕，不能跟最左的消除
        {
            if(current_btn == up || current_btn == down || current_btn == left)
                return true;
            else
                return false;
        }
        else
        {
            if(current_btn != up && current_btn != down && current_btn != left && current_btn != right)
                return false;
            else
                return true;
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        String[] current = e.getActionCommand().split("-");
        int current_btnNum = Integer.parseInt(current[0]);
        int current_picNum = Integer.parseInt(current[1]);

        //若有道具使用
        if(MonsterItem.itemstatus != "")
        {
            MonsterItem.ItemUse(current_btnNum);
            userpanel.repaint();//重新繪製記分板
            Monsterkill.kill(btn, userpanel);//三消
            Monsterkill.drop(btn);//掉落
            Monsterkill.fill(btn);//填充
            Monsterkill.kill(btn, userpanel);//三消
            return;
        }

        if(last_btnNumber == -1) //第一次選取時
        {
            last_btnNumber = current_btnNum;
            last_picNumber = current_picNum;
        }
        else
        {
            if(CheckMove(current_btnNum, last_btnNumber) == true)
            {
                JButton tempbtn = new JButton();
                tempbtn.setIcon(btn[current_btnNum].getIcon());

                btn[last_btnNumber].setText(String.valueOf(last_btnNumber) + "-" + String.valueOf(current_picNum));
                btn[current_btnNum].setText(String.valueOf(current_btnNum) + "-" + String.valueOf(last_picNumber));
                btn[current_btnNum].setIcon(btn[last_btnNumber].getIcon());
                btn[last_btnNumber].setIcon(tempbtn.getIcon());
                
                /*** match function suppose to be here ***/
                MonsterUserdata.rmMove();//移動減少步數
                userpanel.repaint();//重新繪製記分板
                Monsterkill.kill(btn, userpanel);//三消
                Monsterkill.drop(btn);//掉落
                Monsterkill.fill(btn);//填充

                last_btnNumber = -1;
                last_picNumber = -1;
                if(MonsterUserdata.getMove() == 0)
                {
                    JOptionPane.showMessageDialog(null, "謝謝勇士，為我們除去了"+MonsterUserdata.getScore()+"隻猛獸，今天請好好休息吧!", "遊戲結束", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
            else
            {
                last_btnNumber = -1;
                last_picNumber = -1;
            }   
        }
    }
    public JButton[] getAllButton()
    {
        return btn;
    }
}
