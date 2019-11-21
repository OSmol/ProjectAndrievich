package javatrDay2.Task1;

import javatrDay2.helper.ScannerHelper;

import java.util.ArrayList;
import java.util.List;

//создать класс Мяч. Создать класс Корзина. Наполнить корзину мячиками.
//Определить вес мячиков в корзине
//и количество синих мячиков
public class Main {

    public static List<Ball> generateBalls() {
        List<Ball> list = new ArrayList<>();
        list.add(new Ball(5, Color.BLUE, 5, 25));
        list.add(new Ball(321, Color.BLUE, 7, 3));
        list.add(new Ball(22, Color.WHITE, 8, 41));
        list.add(new Ball(123, Color.RED, 1, 23));
        list.add(new Ball(145, Color.RED, 36, 14));
        return list;
    }

    public static void main(String[] args) {
        Basket basket = new Basket();
        BasketService basketService = new BasketService(basket);
        basketService.addBalls(generateBalls());
//определить вес мячиков
        System.out.println(basketService.findWeightOfAllBallsInTheBusket());

//определить количество синих мячиков и вывести список с синими мячиками на консоль
        System.out.println("Enter color: ");
        String colourName = ScannerHelper.inputStringFromConsole();
        System.out.println(basketService.findBallsByColor(colourName));
        System.out.println(basketService.findCountOfBallsByColour(colourName));


 //       System.out.println(basketService.findBallsByColor(Color.BLUE));




    }
}
