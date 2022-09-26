import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Graphics;

public class MonsterUserpanel extends JPanel {
    //姓名
    JLabel info1 = null;
    //分數
    JLabel info2 = null;
    //步數
    JLabel info3 = null;
    
    public MonsterUserpanel()
    {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(1, 3, 5, 5));

        //姓名
        JPanel namepanel = new JPanel();
        namepanel.setLayout(new BorderLayout(2,2));

        JLabel nameinfo = new JLabel("NAME", JLabel.CENTER);
        nameinfo.setOpaque(true);
        nameinfo.setBackground(Color.BLACK);
        nameinfo.setFont(new Font("微軟正黑體",Font.BOLD,20));
        nameinfo.setForeground(Color.WHITE);
        namepanel.add(nameinfo, BorderLayout.NORTH);

        info1 = new JLabel(MonsterUserdata.getName(), JLabel.CENTER);
        info1.setOpaque(true);
        info1.setBackground(Color.BLACK);
        info1.setFont(new Font("微軟正黑體",Font.BOLD,30));
        info1.setForeground(Color.WHITE);
        namepanel.add(info1, BorderLayout.CENTER);

        add(namepanel);

        //分數
        JPanel scorepanel = new JPanel();
        scorepanel.setLayout(new BorderLayout(2,2));

        JLabel scoreinfo = new JLabel("SCORE", JLabel.CENTER);
        scoreinfo.setOpaque(true);
        scoreinfo.setBackground(Color.BLACK);
        scoreinfo.setFont(new Font("微軟正黑體",Font.BOLD,20));
        scoreinfo.setForeground(Color.WHITE);
        scorepanel.add(scoreinfo, BorderLayout.NORTH);

        info2 = new JLabel(String.valueOf(MonsterUserdata.getScore()), JLabel.CENTER);
        info2.setOpaque(true);
        info2.setBackground(Color.BLACK);
        info2.setFont(new Font("微軟正黑體",Font.BOLD,30));
        info2.setForeground(Color.WHITE);
        scorepanel.add(info2, BorderLayout.CENTER);

        add(scorepanel);

        //步數
        JPanel movepanel = new JPanel();
        movepanel.setLayout(new BorderLayout(2,2));

        JLabel moveinfo = new JLabel("MOVE", JLabel.CENTER);
        moveinfo.setOpaque(true);
        moveinfo.setBackground(Color.BLACK);
        moveinfo.setFont(new Font("微軟正黑體",Font.BOLD,20));
        moveinfo.setForeground(Color.WHITE);
        movepanel.add(moveinfo, BorderLayout.NORTH);

        info3 = new JLabel(String.valueOf(MonsterUserdata.getMove()), JLabel.CENTER);
        info3.setOpaque(true);
        info3.setBackground(Color.BLACK);
        info3.setFont(new Font("微軟正黑體",Font.BOLD,30));
        info3.setForeground(Color.WHITE);
        movepanel.add(info3, BorderLayout.CENTER);

        add(movepanel);
    }
    //重新讀取分數與步數
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        info1.setText(MonsterUserdata.getName());
        info2.setText(String.valueOf(MonsterUserdata.getScore()));
        info3.setText(String.valueOf(MonsterUserdata.getMove()));
    }
}
