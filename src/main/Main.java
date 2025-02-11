package main;

import classes.ScreenKeyboard;
import controllers.OperationsController;
import controllers.ScreenKeyboardController;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main extends Canvas implements KeyListener,MouseListener,Runnable{

    public static int WIDTH = 400, HEIGHT = 600;

    String key;
    public int num1 = 0;
    String numVisor = "0";
    public static String operator = "+";
    ScreenKeyboard keyboard;
    static OperationsController operationsC = new OperationsController();


    public Main() {
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));

        keyboard = new ScreenKeyboard();
    }


    public static void main(String[] args) {
        Main main = new Main();
        JFrame frame = new JFrame();

        frame.add(main);
        frame.setTitle("Calculator");
        frame.setLocation(1000,200);

        frame.pack();

        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Thread(main).start();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.black);
        g.fillRect(0,100,WIDTH,HEIGHT-100);
        g.setFont(new Font("Comic Sans", Font.PLAIN, 100));
        g.setColor(Color.black);
        g.drawString(numVisor, 0, 90);

        keyboard.render(g);



        bs.show();
    }

    @Override
    public void run() {
        while(true) {
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_2
                || e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5
                || e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_8
                || e.getKeyCode() == KeyEvent.VK_9
                || e.getKeyCode() == KeyEvent.VK_NUMPAD0 || e.getKeyCode() == KeyEvent.VK_NUMPAD1 || e.getKeyCode() == KeyEvent.VK_NUMPAD2
                || e.getKeyCode() == KeyEvent.VK_NUMPAD3 || e.getKeyCode() == KeyEvent.VK_NUMPAD4 || e.getKeyCode() == KeyEvent.VK_NUMPAD5
                || e.getKeyCode() == KeyEvent.VK_NUMPAD6 || e.getKeyCode() == KeyEvent.VK_NUMPAD7 || e.getKeyCode() == KeyEvent.VK_NUMPAD8
                || e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
            if(numVisor.equals("0")) {
                numVisor = String.valueOf(e.getKeyChar());
            }else {
                numVisor = numVisor+e.getKeyChar();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ADD || e.getKeyCode() == KeyEvent.VK_P) {
            if(numVisor!="0") {
                num1 = operationsC.Calc(Integer.parseInt(numVisor));
                numVisor = "0";
                operator = "+";
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
            if(numVisor!="0") {
                num1 = operationsC.Calc(Integer.parseInt(numVisor));
                numVisor = "0";
                operator = "-";
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
            if(numVisor!="0") {
                num1 = operationsC.Calc(Integer.parseInt(numVisor));
                numVisor = "0";
                operator = "*";
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DIVIDE) {
            if(numVisor!="0") {
                num1 = operationsC.Calc(Integer.parseInt(numVisor));
                numVisor = "0";
                operator = "/";
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(numVisor!="0") {
                num1 = operationsC.Calc(Integer.parseInt(numVisor));
                numVisor = String.valueOf(num1);
                num1 = 0;
                operationsC.res = 0;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            numVisor=numVisor.substring(0, numVisor.length()-1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getButton() == MouseEvent.BUTTON1 && e.getY()>=100){
            key = ScreenKeyboardController.VerifyKey(e.getX(),e.getY());
            if(key.equals("0") || key.equals("1") || key.equals("2") || key.equals("3") || key.equals("4") ||
                    key.equals("5") || key.equals("6") || key.equals("7") || key.equals("8") || key.equals("9")){
                if(numVisor.equals("0")) {
                    numVisor = key;
                }else {
                    numVisor = numVisor+key;
                }
            } else if (key.equals("/")||key.equals("*")||key.equals("-")||key.equals("+")) {
                num1 = operationsC.Calc(Integer.parseInt(numVisor));
                numVisor = "0";
                operator = key;
            }else if (key.equals("=")){
                num1 = operationsC.Calc(Integer.parseInt(numVisor));
                numVisor = String.valueOf(num1);
                num1 = 0;
                operationsC.res = 0;
            } else if (key.equals("C")) {
                numVisor="0";
                num1 = 0;
                operationsC.res = 0;
            } else if (key.equals("<X")) {
                numVisor=numVisor.substring(0, numVisor.length()-1);
            } else if (key.equals("+/-")) {
                numVisor = String.valueOf(Integer.parseInt(numVisor)*-1);
            } else if (key.equals("%")) {
                numVisor = numVisor+"%";
            } else if (key.equals(".")) {
                if (!numVisor.contains(".")){
                    numVisor=numVisor+".";
                }
            }
        }

    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}