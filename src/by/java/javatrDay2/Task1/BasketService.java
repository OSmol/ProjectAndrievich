package javatrDay2.Task1;

import java.util.ArrayList;
import java.util.List;

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

    public List<Ball> findBallsByColor(String color) {
        List<Ball> list = new ArrayList<>();
        for (Ball ball : this.basket.getBalls()) {
            String colorName = ball.getColor().name();
            if (colorName.equalsIgnoreCase(color)) {
                list.add(ball);
            }
        }
        return list;
    }

    public int findCountOfBallsByColour(String color) {
      int count =0;
        for (Ball ball : this.basket.getBalls()) {
            String colorName = ball.getColor().name();
            if (colorName.equalsIgnoreCase(color)) {
                count++;
            }
        }
        return count;
    }

    public int findWeightOfAllBallsInTheBusket() {
        int sum = 0;
        for (Ball ball : this.basket.getBalls()) {
            sum = sum + ball.getWeight();
        }
        return sum;
    }
}
