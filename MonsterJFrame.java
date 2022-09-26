import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class MonsterJFrame extends JFrame
{
    //起始版面
    private Monsterstarting starting;
    //大版面
    private JPanel bigpanel;
    //上下邊界(JLabel)
    private MonsterBorder borderup = new MonsterBorder();
    private MonsterBorder borderdown = new MonsterBorder();
    //遊戲介面
    private JPanel gamepad = new JPanel();
    //怪物介面
    private MonsterPanel gameplay = null;
    //人物介面
    private MonsterUserpanel user = null;
    //道具介面
    public MonsterItem itempanel;

    public MonsterJFrame()
    {
        super("Monster Crush");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750,800);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        //起始頁面
        starting = new Monsterstarting();

        //大版面
        bigpanel = new JPanel();
        bigpanel.setLayout(new BorderLayout());

        //新增上下邊界
        bigpanel.add(borderup, BorderLayout.NORTH);
        bigpanel.add(borderdown, BorderLayout.SOUTH);

        //遊戲介面
        gamepad.setLayout(new BorderLayout());

        //玩家介面
        user = new MonsterUserpanel();
        gamepad.add(user, BorderLayout.SOUTH);

        //怪物介面<芳瑗部分>
        //這邊傳入玩家介面當參數，目的是讓怪物移動的時候，可以控制步數與分數
        gameplay = new MonsterPanel(user);
        gamepad.add(gameplay, BorderLayout.CENTER);

        bigpanel.add(gamepad, BorderLayout.CENTER);

        //道具介面
        itempanel = new MonsterItem(gameplay.getAllButton(), user);
        bigpanel.add(itempanel, BorderLayout.EAST);

        add(starting);
    }
    public class Monsterstarting extends JPanel implements ActionListener
    {
        //讓輸入區域成為instance variable，才能讓actionlister取到
        private JTextField nametext = new JTextField();
        public Monsterstarting()
        {
            setLayout(new GridLayout(4,1));
            setBackground(Color.BLACK);

            ImageIcon m1 = new ImageIcon("./picture/open1.png");
            Image m11 = m1.getImage();
            Image m111 = m11.getScaledInstance(750, 220, java.awt.Image.SCALE_SMOOTH);
            ImageIcon m1111 = new ImageIcon(m111);
            MonsterStartPanel p1 = new MonsterStartPanel(m111);
            add(p1);

            ImageIcon m2 = new ImageIcon("./picture/open2.png");
            Image m22 = m2.getImage();
            Image m222 = m22.getScaledInstance(750, 220, java.awt.Image.SCALE_SMOOTH);
            ImageIcon m2222 = new ImageIcon(m222);
            MonsterStartPanel p2 = new MonsterStartPanel(m222);

            p2.setLayout(new GridLayout(3,3));
            nametext.setPreferredSize(new Dimension(160,20));
            nametext.setBorder(javax.swing.BorderFactory.createEmptyBorder());

            p2.add(new JLabel(""));
            p2.add(new JLabel(""));
            p2.add(new JLabel(""));

            p2.add(new JLabel(""));

            JPanel l = new JPanel();
            l.setLayout(new GridLayout(2,1));
            l.setOpaque(false);
            l.add(new JLabel(""));
            l.add(nametext);
            p2.add(l);

            p2.add(new JLabel(""));

            p2.add(new JLabel(""));
            p2.add(new JLabel(""));
            p2.add(new JLabel(""));

            add(p2);

            ImageIcon m3 = new ImageIcon("./picture/open3.png");
            Image m33 = m3.getImage();
            Image m333 = m33.getScaledInstance(750, 220, java.awt.Image.SCALE_SMOOTH);
            ImageIcon m3333 = new ImageIcon(m333);
            MonsterStartPanel p3 = new MonsterStartPanel(m333);
            add(p3);

            ImageIcon m4 = new ImageIcon("./picture/open4.png");
            Image m44 = m4.getImage();
            Image m444 = m44.getScaledInstance(750, 220, java.awt.Image.SCALE_SMOOTH);
            ImageIcon m4444 = new ImageIcon(m444);
            MonsterStartPanel p4 = new MonsterStartPanel(m444);
            JButton check = new JButton("");
            ImageIcon icon1 = new ImageIcon("./picture/open5.png");
            Image icon2 = icon1.getImage();
            Image icon3 = icon2.getScaledInstance(120, 40, java.awt.Image.SCALE_SMOOTH);
            icon1 = new ImageIcon(icon3);
            check.setPreferredSize(new Dimension(120,40));
            check.setIcon(icon1);
            check.addActionListener(this);
            check.setContentAreaFilled(false); // 去背景
            check.setBorderPainted(false); // 去邊框
            p4.add(check);

            add(p4);

        }
        public void actionPerformed(ActionEvent e)
        {
            String name = nametext.getText();
            if(!name.equals(""))
            {
                MonsterUserdata.setName(name);
                user.repaint();
                setVisible(false);
                MonsterStart.gui.add(bigpanel);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "勇士，你一定有名字吧!", "No name message", JOptionPane.INFORMATION_MESSAGE);
            }    
        }
        public class Infoclass extends JLabel
        {
            public Infoclass(String text)
            {
                super(text, JLabel.CENTER);
                setOpaque(true);
                setBackground(Color.BLACK);
                setFont(new Font("微軟正黑體",Font.BOLD,16));
                setForeground(Color.WHITE);
            } 
        }
    }
}
