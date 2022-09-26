import javax.swing.*;
import java.awt.*;

public class MonsterBorder extends JLabel{

    public MonsterBorder(){
        ImageIcon icon1 = new ImageIcon("./picture/Border1-1-1.png");
        Image icon2 = icon1.getImage();
        Image icon3 = icon2.getScaledInstance(750, 85, java.awt.Image.SCALE_SMOOTH);
        ImageIcon bordericon = new ImageIcon(icon3);
        this.setIcon(bordericon);
    }
}
