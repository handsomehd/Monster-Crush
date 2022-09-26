import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
public class MonsterStartPanel extends JPanel{
    Image picture;
    public MonsterStartPanel(Image picture)
    {
        this.picture = picture;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(picture, 0, 0, null);
    }
}
