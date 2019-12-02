package javatrDay2.Task1.bean;

import javatrDay2.Task1.Color;

import java.util.Objects;

//создать класс Мяч. Создать класс Корзина. Наполнить корзину мячиками.
//Определить вес мячиков в корзине
//и количество синих мячиков
public class Ball {
    private long id;
    private Color color;
    private int size;
    private int weight;

    public Ball() {
    }

    public Ball (long id, Color color, int size, int weight){
        this.id=id;
        this.color=color;
        this.size=size;
        this.weight=weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return id == ball.id &&
                size == ball.size &&
                weight == ball.weight &&
                color == ball.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, size, weight);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "id=" + id +
                ", color=" + color +
                ", size=" + size +
                ", weight=" + weight +
                '}';
    }
}
