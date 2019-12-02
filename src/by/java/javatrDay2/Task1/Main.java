package javatrDay2.Task1;

import javatrDay2.Task1.bean.Basket;
import javatrDay2.Task1.exception.ServiceException;
import javatrDay2.Task1.service.BasketService;
import javatrDay2.Task1.util.Util;
import javatrDay2.helper.ScannerHelper;
import org.apache.log4j.Logger;


//создать класс Мяч. Создать класс Корзина. Наполнить корзину мячиками.
//Определить вес мячиков в корзине
//и количество синих мячиков
public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) throws ServiceException {
        Basket basket = new Basket();
        BasketService basketService = new BasketService(basket);
        basketService.addBalls(Util.generateBalls());
//определить вес мячиков
        LOGGER.info("Общий вес всех мячей в корзине: " + basketService.findWeightOfAllBallsInTheBasket());

//определить количество синих мячиков и вывести список с синими мячиками на консоль
        String colourName = ScannerHelper.inputStringFromConsole();
        LOGGER.info("Enter color: " + basketService.findBallsByColor(colourName));
        LOGGER.info("Количество мячей заданного цвета: " + basketService.findCountOfBallsByColour(colourName));

        //       System.out.println(basketService.findBallsByColor(Color.BLUE));
    }
}
