package controllers;

import main.Main;

public class operationsController {
    public int res = 0;
    Main main = new Main();
    public  int Calc(int num){
        switch (main.operator) {
            case "+" -> res += num;
            case "-" -> res -= num;
            case "*" -> res *= num;
            case "/" -> res /= num;
        }
        return res;
    }
}
