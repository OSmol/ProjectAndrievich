package javatr.task3.runner;
//3. Окружность вписана в квадрат заданной площади. Найти площадь квадрата, вписанного в эту
//окружность. Во сколько раз площадь вписанного квадрата меньше площади заданного?
public class Main {
    public static void main(String[] args) {
        double s_kvadr;
        double storona_kvadr;
        double radius_okr;
        double s_kvadr2;
        double x;
        s_kvadr =25;
        storona_kvadr = Math.sqrt(s_kvadr);
        radius_okr=storona_kvadr/2;
        s_kvadr2 =0.5*radius_okr*radius_okr*4;
        x=s_kvadr/s_kvadr2;
        System.out.println("x=" + x);
    }
}
