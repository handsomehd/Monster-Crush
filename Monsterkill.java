import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Monsterkill {

    //這邊設定玩家介面，目的是讓怪物移動的時候，可以控制步數與分數
    private static MonsterUserpanel userpanel = null;
    
    //消除函數
    public static void kill(JButton[] btn, MonsterUserpanel userpanelIn)
    {
        userpanel = userpanelIn;
        String[] temp1 = null;
        String[] temp2 = null;
        String[] temp3 = null;
        String[] temp4 = null;
        String[] temp5 = null;
        for( int n=0; n<48; n++)
        {
            //橫列判斷
            //判斷5連消
            if( (n%6) < 2)
            {
                temp1 = btn[n].getText().split("-");
                temp2 = btn[n+1].getText().split("-");
                temp3 = btn[n+2].getText().split("-");
                temp4 = btn[n+3].getText().split("-");
                temp5 = btn[n+4].getText().split("-");
                if(temp1[1].equals(temp2[1]) && temp1[1].equals(temp3[1]) && temp1[1].equals(temp4[1]) && temp1[1].equals(temp5[1]) && !temp1[1].equals("0"))
                {
                    LTrow(btn, n, 5);
                    cancel(btn[n]);
                    cancel(btn[n+1]);
                    cancel(btn[n+2]);
                    cancel(btn[n+3]);
                    cancel(btn[n+4]);
                    MonsterUserdata.addScore(5);
                    MonsterItem.itemChange(4, 1);
                    userpanel.repaint();
                    drop(btn);
                    fill(btn);
                    kill(btn, userpanel);
                }
                reSpace(temp1, temp2, temp3, temp4, temp5);
            }
            //判斷4連消
            if( (n%6) < 3)
            {
                temp1 = btn[n].getText().split("-");
                temp2 = btn[n+1].getText().split("-");
                temp3 = btn[n+2].getText().split("-");
                temp4 = btn[n+3].getText().split("-");
                if(temp1[1].equals(temp2[1]) && temp1[1].equals(temp3[1]) && temp1[1].equals(temp4[1]) && !temp1[1].equals("0"))
                {
                    LTrow(btn, n, 4);
                    cancel(btn[n]);
                    cancel(btn[n+1]);
                    cancel(btn[n+2]);
                    cancel(btn[n+3]);
                    MonsterUserdata.addScore(4);
                    MonsterItem.itemChange(2, 1);
                    userpanel.repaint();
                    drop(btn);
                    fill(btn);
                    kill(btn, userpanel);
                }
                reSpace(temp1, temp2, temp3, temp4, temp5);
            }
            //判斷3連消
            if( (n%6) < 4)
            {
                temp1 = btn[n].getText().split("-");
                temp2 = btn[n+1].getText().split("-");
                temp3 = btn[n+2].getText().split("-");
                if(temp1[1].equals(temp2[1]) && temp1[1].equals(temp3[1]) && !temp1[1].equals("0"))
                {
                    LTrow(btn, n, 3);
                    cancel(btn[n]);
                    cancel(btn[n+1]);
                    cancel(btn[n+2]);
                    MonsterUserdata.addScore(3);
                    userpanel.repaint();
                    drop(btn);
                    fill(btn);
                    kill(btn, userpanel);
                }
                reSpace(temp1, temp2, temp3, temp4, temp5);
            }
            //直列判斷
            //判斷5連消
            if( (n/6) < 4)
            {
                temp1 = btn[n].getText().split("-");
                temp2 = btn[n+6].getText().split("-");
                temp3 = btn[n+12].getText().split("-");
                temp4 = btn[n+18].getText().split("-");
                temp5 = btn[n+24].getText().split("-");
                if(temp1[1].equals(temp2[1]) && temp1[1].equals(temp3[1]) && temp1[1].equals(temp4[1]) && temp1[1].equals(temp5[1]) && !temp1[1].equals("0"))
                {
                    LTcolumn(btn, n, 5);
                    cancel(btn[n]);
                    cancel(btn[n+6]);
                    cancel(btn[n+12]);
                    cancel(btn[n+18]);
                    cancel(btn[n+24]);
                    MonsterUserdata.addScore(5);
                    MonsterItem.itemChange(4, 1);
                    userpanel.repaint();
                    drop(btn);
                    fill(btn);
                    kill(btn, userpanel);
                }
                reSpace(temp1, temp2, temp3, temp4, temp5);
            }
            //判斷4連消
            if( (n/6) < 5)
            {
                temp1 = btn[n].getText().split("-");
                temp2 = btn[n+6].getText().split("-");
                temp3 = btn[n+12].getText().split("-");
                temp4 = btn[n+18].getText().split("-");
                if(temp1[1].equals(temp2[1]) && temp1[1].equals(temp3[1]) && temp1[1].equals(temp4[1]) && !temp1[1].equals("0"))
                {
                    LTcolumn(btn, n, 4);
                    cancel(btn[n]);
                    cancel(btn[n+6]);
                    cancel(btn[n+12]);
                    cancel(btn[n+18]);
                    MonsterUserdata.addScore(4);
                    MonsterItem.itemChange(3, 1);
                    userpanel.repaint();
                    drop(btn);
                    fill(btn);
                    kill(btn, userpanel);
                }
                reSpace(temp1, temp2, temp3, temp4, temp5);
            }
            //判斷3連消
            if( (n/6) < 6)
            {
                temp1 = btn[n].getText().split("-");
                temp2 = btn[n+6].getText().split("-");
                temp3 = btn[n+12].getText().split("-");
                if(temp1[1].equals(temp2[1]) && temp1[1].equals(temp3[1]) && !temp1[1].equals("0"))
                {
                    LTcolumn(btn, n, 3);
                    cancel(btn[n]);
                    cancel(btn[n+6]);
                    cancel(btn[n+12]);
                    MonsterUserdata.addScore(3);
                    userpanel.repaint();
                    drop(btn);
                    fill(btn);
                    kill(btn, userpanel);
                }
                reSpace(temp1, temp2, temp3, temp4, temp5);
            }
        }
    }
    
    public static void LTrow(JButton[] btn, int target, int amount)
    {
        String[] t = btn[target].getText().split("-");//觸發LT的按鈕
        String[] u2;
        String[] u1;
        String[] d1;
        String[] d2;
        //u2
        //u1
        //當前
        //d1
        //d2
        if(target/6 == 0)
        {
            for(int n=target; n<target+amount; n++)
            {
                d1 = btn[n+6].getText().split("-");
                d2 = btn[n+12].getText().split("-");
                if(t[1].equals(d1[1]) && t[1].equals(d2[1]))
                {
                    cancel(btn[n+6]);
                    cancel(btn[n+12]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
        if(target/6 == 7)
        {
            for(int n=target; n<target+amount; n++)
            {
                u1 = btn[n-6].getText().split("-");
                u2 = btn[n-12].getText().split("-");
                if(t[1].equals(u1[1]) && t[1].equals(u2[1]))
                {
                    cancel(btn[n-6]);
                    cancel(btn[n-12]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
        if(target/6 == 1)
        {
            for(int n=target; n<target+amount; n++)
            {
                u1 = btn[n-6].getText().split("-");
                d1 = btn[n+6].getText().split("-");
                d2 = btn[n+12].getText().split("-");
                if(t[1].equals(u1[1]) && t[1].equals(d1[1]) && t[1].equals(d2[1]))
                {
                    cancel(btn[n-6]);
                    cancel(btn[n+6]);
                    cancel(btn[n+12]);
                    MonsterUserdata.addScore(3);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(u1[1]) && t[1].equals(d1[1]))
                {
                    cancel(btn[n-6]);
                    cancel(btn[n+6]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(d1[1]) && t[1].equals(d2[1]))
                {
                    cancel(btn[n+6]);
                    cancel(btn[n+12]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
        if(target/6 == 6)
        {
            for(int n=target; n<target+amount; n++)
            {
                u2 = btn[n-12].getText().split("-");
                u1 = btn[n-6].getText().split("-");
                d1 = btn[n+6].getText().split("-");
                if(t[1].equals(u1[1]) && t[1].equals(u2[1]) && t[1].equals(d1[1]))
                {
                    cancel(btn[n-12]);
                    cancel(btn[n-6]);
                    cancel(btn[n+6]);
                    MonsterUserdata.addScore(3);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(u1[1]) && t[1].equals(u2[1]))
                {
                    cancel(btn[n-12]);
                    cancel(btn[n-6]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(u1[1]) && t[1].equals(d1[1]))
                {
                    cancel(btn[n-6]);
                    cancel(btn[n+6]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
        if(target/6>1 && target/6<6)
        {
            for(int n=target; n<target+amount; n++)
            {
                u2 = btn[n-12].getText().split("-");
                u1 = btn[n-6].getText().split("-");
                d1 = btn[n+6].getText().split("-");
                d2 = btn[n+12].getText().split("-");
                if(t[1].equals(u1[1]) && t[1].equals(u2[1]) && t[1].equals(d1[1]) && t[1].equals(d2[1]))
                {
                    cancel(btn[n-12]);
                    cancel(btn[n-6]);
                    cancel(btn[n+6]);
                    cancel(btn[n+12]);
                    MonsterUserdata.addScore(4);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(u1[1]) && t[1].equals(u2[1]) && t[1].equals(d1[1]))
                {
                    cancel(btn[n-12]);
                    cancel(btn[n-6]);
                    cancel(btn[n+6]);
                    MonsterUserdata.addScore(3);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(u1[1]) && t[1].equals(d1[1]) && t[1].equals(d2[1]))
                {
                    cancel(btn[n-6]);
                    cancel(btn[n+6]);
                    cancel(btn[n+12]);
                    MonsterUserdata.addScore(3);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(u1[1]) && t[1].equals(u2[1]))
                {
                    cancel(btn[n-12]);
                    cancel(btn[n-6]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(u1[1]) && t[1].equals(d1[1]))
                {
                    cancel(btn[n-6]);
                    cancel(btn[n+6]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(d1[1]) && t[1].equals(d2[1]))
                {
                    cancel(btn[n+6]);
                    cancel(btn[n+12]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
    }

    public static void LTcolumn(JButton[] btn, int target, int amount)
    {
        String[] t = btn[target].getText().split("-");//觸發LT的按鈕
        String[] l1;
        String[] l2;
        String[] r1;
        String[] r2;
        //l2 l1 當前 r1 r2
        if(target%6 == 0)
        {
            for(int n=target; n<target+amount*6; n=n+6)
            {
                r1 = btn[n+1].getText().split("-");
                r2 = btn[n+2].getText().split("-");
                if(t[1].equals(r1[1]) && t[1].equals(r2[1]))
                {
                    cancel(btn[n+1]);
                    cancel(btn[n+2]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
        if(target%6 == 5)
        {
            for(int n=target; n<target+amount*6; n=n+6)
            {
                l1 = btn[n-1].getText().split("-");
                l2 = btn[n-2].getText().split("-");
                if(t[1].equals(l1[1]) && t[1].equals(l2[1]))
                {
                    cancel(btn[n-1]);
                    cancel(btn[n-2]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
        if(target%6 == 1)
        {
            for(int n=target; n<target+amount*6; n=n+6)
            {
                l1 = btn[n-1].getText().split("-");
                r1 = btn[n+1].getText().split("-");
                r2 = btn[n+2].getText().split("-");
                if(t[1].equals(l1[1]) && t[1].equals(r1[1]) && t[1].equals(r2[1]))
                {
                    cancel(btn[n-1]);
                    cancel(btn[n+1]);
                    cancel(btn[n+2]);
                    MonsterUserdata.addScore(3);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(l1[1]) && t[1].equals(r1[1]))
                {
                    cancel(btn[n-1]);
                    cancel(btn[n+1]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(r1[1]) && t[1].equals(r2[1]))
                {
                    cancel(btn[n+1]);
                    cancel(btn[n+2]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
        if(target%6 == 4)
        {
            for(int n=target; n<target+amount*6; n=n+6)
            {
                l2 = btn[n-2].getText().split("-");
                l1 = btn[n-1].getText().split("-");
                r1 = btn[n+1].getText().split("-");
                if(t[1].equals(l2[1]) && t[1].equals(l1[1]) && t[1].equals(r1[1]))
                {
                    cancel(btn[n-2]);
                    cancel(btn[n-1]);
                    cancel(btn[n+1]);
                    MonsterUserdata.addScore(3);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(l1[1]) && t[1].equals(l2[1]))
                {
                    cancel(btn[n-2]);
                    cancel(btn[n-1]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(l1[1]) && t[1].equals(r1[1]))
                {
                    cancel(btn[n-1]);
                    cancel(btn[n+1]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
        if(target%6>1 && target%6<4)
        {
            for(int n=target; n<target+amount*6; n=n+6)
            {
                l2 = btn[n-2].getText().split("-");
                l1 = btn[n-1].getText().split("-");
                r1 = btn[n+1].getText().split("-");
                r2 = btn[n+2].getText().split("-");
                if(t[1].equals(l2[1]) && t[1].equals(l1[1]) && t[1].equals(r1[1]) && t[1].equals(r2[1]))
                {
                    cancel(btn[n-2]);
                    cancel(btn[n-1]);
                    cancel(btn[n+1]);
                    cancel(btn[n+2]);
                    MonsterUserdata.addScore(4);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(l2[1]) && t[1].equals(l1[1]) && t[1].equals(r1[1]))
                {
                    cancel(btn[n-2]);
                    cancel(btn[n-1]);
                    cancel(btn[n+1]);
                    MonsterUserdata.addScore(3);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(l1[1]) && t[1].equals(r1[1]) && t[1].equals(r2[1]))
                {
                    cancel(btn[n-1]);
                    cancel(btn[n+1]);
                    cancel(btn[n+2]);
                    MonsterUserdata.addScore(3);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(l1[1]) && t[1].equals(l2[1]))
                {
                    cancel(btn[n-2]);
                    cancel(btn[n-1]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(l1[1]) && t[1].equals(r1[1]))
                {
                    cancel(btn[n-1]);
                    cancel(btn[n+1]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
                if(t[1].equals(r1[1]) && t[1].equals(r2[1]))
                {
                    cancel(btn[n+1]);
                    cancel(btn[n+2]);
                    MonsterUserdata.addScore(2);
                    MonsterItem.itemChange(1, 1);
                    return;
                }
            }
        }
    }    

    //掉落函數
    public static void drop(JButton[] btn)
    {
        String[] tempdown = null;
        String[] tempup = null;

        for(int n=47; n>=6; n--)
        {
            tempdown = btn[n].getText().split("-");
            if(tempdown[1].equals("0"))
            {
                for(int m=n-6; m>=0; m=m-6)
                {
                    tempup = btn[m].getText().split("-");
                    if(!tempup[1].equals("0"))
                    {
                        btn[n].setText(tempdown[0] + "-" + tempup[1]);
                        btn[m].setText(tempup[0] + "-" + tempdown[1]);
                        btn[n].setIcon(btn[m].getIcon());
                        btn[m].setIcon(null);
                        break;
                    }
                    tempup = null;
                }
            }
            tempdown = null;
            tempup = null;
        }
    }
    //填滿圖案
    public static void fill(JButton[] btn_tobefilled)
    {
        for(int i = 0; i < btn_tobefilled.length; i++)
        {   
            if(btn_tobefilled[i].getText().split("-")[1].equals("0"))
            {
                int random_number = (int)(Math.random()*5)+1;
                ImageIcon iconInButton = new ImageIcon(MonsterPanel.pictures.get(random_number));
                iconInButton.setImage(iconInButton.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
                
                btn_tobefilled[i].setText(btn_tobefilled[i].getText().split("-")[0]+"-"+Integer.toString(random_number));
                btn_tobefilled[i].setIcon(iconInButton);
                btn_tobefilled[i].setContentAreaFilled(false); // 去背景
                btn_tobefilled[i].setBorderPainted(false); // 去邊框
            }
        }
    }
    //按鈕圖案消除
    public static void cancel(JButton cancelbtn)
    {
        String[] temp = cancelbtn.getText().split("-");
        cancelbtn.setText(temp[0] + "-0");
        cancelbtn.setIcon(null);
    }
    //消除所有暫存
    public static void reSpace(String[] r1, String[] r2, String[] r3, String[] r4, String[] r5)
    {
        r1 = null;
        r2 = null;
        r3 = null;
        r4 = null;
        r5 = null;
    }
}
