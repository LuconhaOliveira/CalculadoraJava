import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Key extends Rectangle {

    String characters;

    public Key(int x, int y, int width, int height, String character) {
        super(x,y,width,height);
        characters = character;
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x,y,width,height);
        g.setColor(Color.blue);
        g.drawRect(x, y, width, height);
        g.setFont(new Font("TimesRoman",Font.PLAIN,width/2));
        g.drawString(characters, x+(width/4), y+(width/2));
    }
}
