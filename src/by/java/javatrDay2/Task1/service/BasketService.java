package javatrDay2.Task1.service;

import javatrDay2.Task1.util.Color;
import javatrDay2.Task1.bean.Ball;
import javatrDay2.Task1.bean.Basket;
import javatrDay2.Task1.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

import static javatrDay2.Task1.Main.LOGGER;

public class BasketService {
    private Basket basket;

    public BasketService(Basket basket) {
        this.basket = basket;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void addBall(Ball ball) {
        basket.addBall(ball);
    }

    public void addBalls(List<Ball> balls) {
        basket.addBalls(balls);
    }

    public void deleteBall(Ball ball) {
        basket.deleteBall(ball);
    }

    public List<Ball> findBallsByColor(Color color) {
        List<Ball> findBalls = new ArrayList<>();
        for (Ball ball : basket.getBalls()) {
            if (ball.getColor().equals(color)) {
                findBalls.add(ball);
            }
        }
        return findBalls;
    }

    public List<Ball> findBallsByColor(String color) throws ServiceException {
        LOGGER.debug("Call method findBallsByColor with color" + color);
        List<Ball> list;
        try {
            list = new ArrayList<>();
            for (Ball ball : this.basket.getBalls()) {
                String colorName = ball.getColor().name();
                if (colorName.equalsIgnoreCase(color)) {
                    list.add(ball);
                }
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }

        LOGGER.debug("list info is: " + list.toString());
        return list;
    }

    public int findCountOfBallsByColour(String color) throws ServiceException {
        LOGGER.debug("Call method findCountOfBallsByColor with color" + color);
        int count = 0;
        try {
            for (Ball ball : this.basket.getBalls()) {
                String colorName = ball.getColor().name();
                if (colorName.equalsIgnoreCase(color)) {
                    count++;
                }
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        LOGGER.debug("Count ball of this color info is: " + count);
        return count;
    }

    public int findWeightOfAllBallsInTheBasket() {
        int sum = 0;
        for (Ball ball : this.basket.getBalls()) {
            sum = sum + ball.getWeight();
        }
        return sum;
    }
}
