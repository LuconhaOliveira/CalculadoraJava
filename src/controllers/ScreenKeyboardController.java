package controllers;

public class ScreenKeyboardController {
    private static final String[][] keys = {{"100","200","%"},{"200","200","C"},{"300","200","<X"},{"400","200","/"},{"100","300","1"},{"200","300","2"},
            {"300","300","3"},{"400","300","*"},{"100","400","4"},{"200","400","5"},{"300","400","6"},{"400","400","-"},{"100","500","7"},
            {"200","500","8"},{"300","500","9"},{"400","500","+"},{"100","600","+/-"},{"200","600","0"},{"300","600","."},{"400","600","="}};
    public static String VerifyKey(int x, int y){
        for(String[] row : keys){
            if (Integer.parseInt(row[0])>=x && Integer.parseInt(row[1])>=y){
                return row[2];
            }
        }
        return "";
    }
}
