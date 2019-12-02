package javatrDay2.Task1.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//создать класс Мяч. Создать класс Корзина. Наполнить корзину мячиками.
//Определить вес мячиков в корзине
//и количество синих мячиков
public class Basket {
    private List<Ball> balls;

    public Basket() {
        this.balls = new ArrayList<>();
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

    public void addBalls(List<Ball> balls) {
        this.balls.addAll(balls);
    }

    public void deleteBall(Ball ball) {
        this.balls.remove(ball);
    }

    public void deleteBalls(List<Ball> balls) {
        this.balls.removeAll(balls);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(balls, basket.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "balls=" + balls +
                '}';
    }
}
