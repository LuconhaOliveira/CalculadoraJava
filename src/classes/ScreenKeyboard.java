package classes;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ScreenKeyboard{

    public static List<Key> keyboard = new ArrayList<Key>();
    private String[] characters = {"%","C","<X","/","1","2","3","X","4","5","6","-","7","8","9","+","+/-","0",".","="};
    private int a = 0;
    private int contador = 0;
    private int variante = 1;
    private int end = 0;

    public ScreenKeyboard(){
        for(int i=0;i<4;i++) {
            keyboard.add(new Key(i*100,100*variante,100,100,characters[a]));
            if(contador<3) {
                contador++;
            }else {
                i=-1;
                variante+=1;
                contador=0;
                end++;
            }
            if(end == 5) {
                i=4;
            }
            a++;
        }

    }

    public void render(Graphics g) {
        for(int i = 0; i < keyboard.size(); i++) {
            keyboard.get(i).render(g);
        }
    }
}
