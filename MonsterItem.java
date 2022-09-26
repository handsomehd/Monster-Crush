import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Font;
import java.awt.BorderLayout;

public class MonsterItem extends JPanel implements ActionListener{
    public static JButton bomb = new JButton("炸彈");
    public static JButton oneRowCut = new JButton("一字橫斬");
    public static JButton oneColumnCut = new JButton("一字直斬");
    public static JButton bury = new JButton("埋葬");
    public static JButton[] btn;
    public static MonsterUserpanel userpanel;
    public static String itemstatus = "";

    //按鈕panel
    public static JPanel p1 = new JPanel();
    public static JPanel p2 = new JPanel();
    public static JPanel p3 = new JPanel();
    public static JPanel p4 = new JPanel();

    //正常圖片
    public static ImageIcon iconInButton1 = new ImageIcon("picture/item1-1.png");
    public static ImageIcon iconInButton2 = new ImageIcon("picture/item2-2.png");
    public static ImageIcon iconInButton3 = new ImageIcon("picture/item3-3.png");
    public static ImageIcon iconInButton4 = new ImageIcon("picture/item4-4.png");

    //點擊後圖片
    public static ImageIcon iconInButton_1 = new ImageIcon("picture/item1-1re.png");
    public static ImageIcon iconInButton_2 = new ImageIcon("picture/item2-2re.png");
    public static ImageIcon iconInButton_3 = new ImageIcon("picture/item3-3re.png");
    public static ImageIcon iconInButton_4 = new ImageIcon("picture/item4-4re.png");

    //道具按鈕
    public static JLabel i1;
    public static JLabel i2;
    public static JLabel i3;
    public static JLabel i4;

    //道具次數
    public static int item1 = 0;
    public static int item2 = 0;
    public static int item3 = 0;
    public static int item4 = 0;

    public MonsterItem(JButton[] btn, MonsterUserpanel userpanel)
    {
        MonsterItem.btn = btn;
        MonsterItem.userpanel = userpanel;
    
        iconInButton1.setImage(iconInButton1.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        bomb.setIcon(iconInButton1);
        bomb.setContentAreaFilled(false); // 去背景
        bomb.setBorderPainted(false); // 去邊框
        bomb.setFont(new Font("微軟正黑體",0,0)); // 隱藏文字
        bomb.setFocusPainted(false);

        iconInButton2.setImage(iconInButton2.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        oneRowCut.setIcon(iconInButton2);
        oneRowCut.setContentAreaFilled(false); // 去背景
        oneRowCut.setBorderPainted(false); // 去邊框
        oneRowCut.setFont(new Font("微軟正黑體",0,0)); // 隱藏文字
        oneRowCut.setFocusPainted(false);

        iconInButton3.setImage(iconInButton3.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        oneColumnCut.setIcon(iconInButton3);
        oneColumnCut.setContentAreaFilled(false); // 去背景
        oneColumnCut.setBorderPainted(false); // 去邊框
        oneColumnCut.setFont(new Font("微軟正黑體",0,0)); // 隱藏文字
        oneColumnCut.setFocusPainted(false);

        iconInButton4.setImage(iconInButton4.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        bury.setIcon(iconInButton4);
        bury.setContentAreaFilled(false); // 去背景
        bury.setBorderPainted(false); // 去邊框
        bury.setFont(new Font("微軟正黑體",0,0)); // 隱藏文字
        bury.setFocusPainted(false);

        iconInButton_1.setImage(iconInButton_1.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        iconInButton_2.setImage(iconInButton_2.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        iconInButton_3.setImage(iconInButton_3.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        iconInButton_4.setImage(iconInButton_4.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));

        setLayout(new GridLayout(5,1,5,5));
        setBackground(Color.BLACK);

        bomb.addActionListener(this);
        oneRowCut.addActionListener(this);
        oneColumnCut.addActionListener(this);
        bury.addActionListener(this);

        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        p4.setBackground(Color.BLACK);

        p1.setLayout(new BorderLayout(2,2));
        p2.setLayout(new BorderLayout(2,2));
        p3.setLayout(new BorderLayout(2,2));
        p4.setLayout(new BorderLayout(2,2));

        p1.add(bomb, BorderLayout.CENTER);
        p2.add(oneRowCut, BorderLayout.CENTER);
        p3.add(oneColumnCut, BorderLayout.CENTER);
        p4.add(bury, BorderLayout.CENTER);

        i1 = new JLabel(Integer.toString(item1), SwingConstants.CENTER);
        i2 = new JLabel(Integer.toString(item2), SwingConstants.CENTER);
        i3 = new JLabel(Integer.toString(item3), SwingConstants.CENTER);
        i4 = new JLabel(Integer.toString(item4), SwingConstants.CENTER);

        i1.setForeground(Color.WHITE);
        i2.setForeground(Color.WHITE);
        i3.setForeground(Color.WHITE);
        i4.setForeground(Color.WHITE);

        p1.add(i1, BorderLayout.SOUTH);
        p2.add(i2, BorderLayout.SOUTH);
        p3.add(i3, BorderLayout.SOUTH);
        p4.add(i4, BorderLayout.SOUTH);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(new JLabel(""));

    }
    public void actionPerformed(ActionEvent e)
    {
        if(itemstatus.equals(e.getActionCommand()))
        {
            itemstatus = "";
            if(e.getSource() == bomb)
            {
                bomb.setIcon(iconInButton1);
            }
            if(e.getSource() == oneRowCut)
            {
                oneRowCut.setIcon(iconInButton2);
            }
            if(e.getSource() == oneColumnCut)
            {
                oneColumnCut.setIcon(iconInButton3);
            }
            if(e.getSource() == bury)
            {
                bury.setIcon(iconInButton4);
            }
            return;
        }
        else if(itemstatus != "")
        {
            return;
        }

        if(e.getSource() == bomb)
        {
            if(item1 == 0)
            {
                return;
            }
            itemstatus = bomb.getText();
            bomb.setIcon(iconInButton_1);
        }
        if(e.getSource() == oneRowCut)
        {
            if(item2 == 0)
            {
                return;
            }
            itemstatus = oneRowCut.getText();
            oneRowCut.setIcon(iconInButton_2);
        }
        if(e.getSource() == oneColumnCut)
        {
            if(item3 == 0)
            {
                return;
            }
            itemstatus = oneColumnCut.getText();
            oneColumnCut.setIcon(iconInButton_3);
        }
        if(e.getSource() == bury)
        {
            if(item4 == 0)
            {
                return;
            }
            itemstatus = bury.getText();
            bury.setIcon(iconInButton_4);
        }
    }
    public static void Bomb(int target)
    {
        if(target == 0)
        {
            Monsterkill.cancel(btn[target]);
            Monsterkill.cancel(btn[target+1]);
            Monsterkill.cancel(btn[target+6]);
            Monsterkill.cancel(btn[target+7]);
            MonsterUserdata.addScore(4);
        }
        else if(target == 5)
        {
            Monsterkill.cancel(btn[target]);
            Monsterkill.cancel(btn[target-1]);
            Monsterkill.cancel(btn[target+5]);
            Monsterkill.cancel(btn[target+6]);
            MonsterUserdata.addScore(4);
        }
        else if(target == 42)
        {
            Monsterkill.cancel(btn[target]);
            Monsterkill.cancel(btn[target+1]);
            Monsterkill.cancel(btn[target-6]);
            Monsterkill.cancel(btn[target-5]);
            MonsterUserdata.addScore(4);
        }
        else if(target == 47)
        {
            Monsterkill.cancel(btn[target]);
            Monsterkill.cancel(btn[target-1]);
            Monsterkill.cancel(btn[target-6]);
            Monsterkill.cancel(btn[target-7]);
            MonsterUserdata.addScore(4);
        }
        else if(target/6 == 0)
        {
            Monsterkill.cancel(btn[target]);
            Monsterkill.cancel(btn[target-1]);
            Monsterkill.cancel(btn[target+1]);
            Monsterkill.cancel(btn[target+6]);
            Monsterkill.cancel(btn[target+5]);
            Monsterkill.cancel(btn[target+7]);
            MonsterUserdata.addScore(6);
        }
        else if(target/6 == 7)
        {
            Monsterkill.cancel(btn[target]);
            Monsterkill.cancel(btn[target+1]);
            Monsterkill.cancel(btn[target-1]);
            Monsterkill.cancel(btn[target-6]);
            Monsterkill.cancel(btn[target-5]);
            Monsterkill.cancel(btn[target-7]);
            MonsterUserdata.addScore(6);
        }
        else if(target%6 == 0)
        {
            Monsterkill.cancel(btn[target]);
            Monsterkill.cancel(btn[target+1]);
            Monsterkill.cancel(btn[target-6]);
            Monsterkill.cancel(btn[target-5]);
            Monsterkill.cancel(btn[target+6]);
            Monsterkill.cancel(btn[target+7]);
            MonsterUserdata.addScore(6);
        }
        else if(target%6 == 5)
        {
            Monsterkill.cancel(btn[target]);
            Monsterkill.cancel(btn[target-1]);
            Monsterkill.cancel(btn[target-6]);
            Monsterkill.cancel(btn[target-7]);
            Monsterkill.cancel(btn[target+6]);
            Monsterkill.cancel(btn[target+5]);
            MonsterUserdata.addScore(6);
        }
        else
        {
            Monsterkill.cancel(btn[target]);
            Monsterkill.cancel(btn[target+1]);
            Monsterkill.cancel(btn[target-1]);
            Monsterkill.cancel(btn[target-6]);
            Monsterkill.cancel(btn[target-5]);
            Monsterkill.cancel(btn[target-7]);
            Monsterkill.cancel(btn[target+6]);
            Monsterkill.cancel(btn[target+5]);
            Monsterkill.cancel(btn[target+7]);
            MonsterUserdata.addScore(9);
        }
        bomb.setIcon(iconInButton1);
        itemstatus = "";
        itemChange(1, 2);
    }
    public static void OneRow(int target)
    {
        int row = target/6;
        Monsterkill.cancel(btn[row*6]);
        Monsterkill.cancel(btn[row*6+1]);
        Monsterkill.cancel(btn[row*6+2]);
        Monsterkill.cancel(btn[row*6+3]);
        Monsterkill.cancel(btn[row*6+4]);
        Monsterkill.cancel(btn[row*6+5]);
        MonsterUserdata.addScore(6);
        oneRowCut.setIcon(iconInButton2);
        itemstatus = "";
        itemChange(2, 2);
    }
    public static void OneColumn(int target)
    {
        int column = target%6;
        Monsterkill.cancel(btn[column]);
        Monsterkill.cancel(btn[column+6]);
        Monsterkill.cancel(btn[column+12]);
        Monsterkill.cancel(btn[column+18]);
        Monsterkill.cancel(btn[column+24]);
        Monsterkill.cancel(btn[column+30]);
        Monsterkill.cancel(btn[column+36]);
        Monsterkill.cancel(btn[column+42]);
        MonsterUserdata.addScore(8);
        oneColumnCut.setIcon(iconInButton3);
        itemstatus = "";
        itemChange(3, 2);
    }
    public static void Bury(int target)
    {
        String temp[] = btn[target].getText().split("-");
        String temp2[];
        int count = 0;
        for(int n=0; n<48; n++)
        {
            temp2 = btn[n].getText().split("-");
            if(temp2[1].equals(temp[1]))
            {
                Monsterkill.cancel(btn[n]);
                count++;
            }
        }
        MonsterUserdata.addScore(count);
        bury.setIcon(iconInButton4);
        itemstatus = "";
        itemChange(4, 2);
    }
    public static void ItemUse(int target)
    {
        if(itemstatus.equals(bomb.getText()))
            Bomb(target);
        if(itemstatus.equals(oneRowCut.getText()))
            OneRow(target);
        if(itemstatus.equals(oneColumnCut.getText()))
            OneColumn(target);
        if(itemstatus.equals(bury.getText()))
            Bury(target);
    }
    public static void itemChange(int item, int change)
    {
        if(item == 1)
        {
            if(change == 1)
                item1++;
            if(change == 2)
                item1--;
            i1.setText(Integer.toString(item1));
        }
        else if(item == 2)
        {
            if(change == 1)
                item2++;
            if(change == 2)
                item2--;
            i2.setText(Integer.toString(item2));
        }
        else if(item == 3)
        {
            if(change == 1)
                item3++;
            if(change == 2)
                item3--;
            i3.setText(Integer.toString(item3));
        }
        else
        {
            if(change == 1)
                item4++;
            if(change == 2)
                item4--;
            i4.setText(Integer.toString(item4));
        }
    }
}
